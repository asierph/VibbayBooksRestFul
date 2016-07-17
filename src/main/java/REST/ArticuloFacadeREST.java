package REST;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Base64;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import POJOS.Articulo;
import POJOS.Imagen;
import javax.ws.rs.core.MediaType;


@Stateless
@Path("articulo")
public class ArticuloFacadeREST extends AbstractFacade<Articulo> {
    private EntityManager em;
    private final String RUTA_IMAGENES = "C:\\Users\\Asier\\Documents\\NetBeansProjects\\vibbaybooks\\src\\main\\webapp\\IMG";
    private final String JSON_RESPONSE = "\"return\":\"%s\"}";

    public ArticuloFacadeREST() {
        super(Articulo.class);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public String create(Articulo entity) {
        String result = super.create(entity);
        return String.format(JSON_RESPONSE, result);
    }

    @POST
    @Path("img")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Imagen subirImagen(Imagen img) {
        // Obtener el id que va a tener el articulo que va asociado a esta imagen
        EntityManager em = getEntityManager();
        Query query = em.createNativeQuery("SELECT AUTO_INCREMENT FROM information_schema.TABLES WHERE TABLE_SCHEMA = 'vibbaybooks' AND TABLE_NAME = 'articulo'");
        int idArticulo = ((BigInteger) query.getSingleResult()).intValue();
        
        String imagenCodificada = img.getImagenCodificada();
        String nombreImagen = "img" + String.valueOf(idArticulo);
        Imagen respuesta = new Imagen();
        try {
            byte[] imagenDecodificada = Base64.getMimeDecoder().decode(imagenCodificada);
            try (FileOutputStream fos = new FileOutputStream(new File(RUTA_IMAGENES + "/" + nombreImagen +  ".jpg"))) {
                fos.write(imagenDecodificada);
            }
            img.setNombre(nombreImagen);
            respuesta = img;
            return respuesta;
        } catch (IOException ex) {
            System.out.println("Error I/O");
            Logger.getLogger(ArticuloFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex){
            System.out.println("Otros errores");
            Logger.getLogger(ArticuloFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public String edit(@PathParam("id") Integer id, Articulo entity) {
        String result = super.edit(entity);
        return String.format(JSON_RESPONSE, result);
    }
    
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Articulo find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Articulo> findAll() {
        return super.findAll();
    }
    
    @GET
    @Override
    @Path("usuario/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Articulo> findAllArticuloByIdUsuario(@PathParam("id") Integer idUsuario) {
        return super.findAllArticuloByIdUsuario(idUsuario);
    }

    @GET
    @Path("count")
    @Produces({MediaType.APPLICATION_JSON})
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        if(em == null){
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.asierph_vibbaybooks_war_1.0PU");
            em = factory.createEntityManager();
        }
        return em;
    }
    
}

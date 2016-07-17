package REST;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import POJOS.Puja;
import javax.ws.rs.core.MediaType;


@Stateless
@Path("puja")
public class PujaFacadeREST extends AbstractFacade<Puja> {
    private EntityManager em;
    private final String JSON_RESPONSE = "\"return\":\"%s\"}";

    public PujaFacadeREST() {
        super(Puja.class);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public String create(Puja entity) {
        String result = super.create(entity);
        return String.format(JSON_RESPONSE, result);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Puja entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Puja find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Puja> findAll() {
        return super.findAll();
    }
    
    
    @GET
    @Path("usuario/{idUsuario}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public List<Puja> pujasUsuario(@PathParam("idUsuario") Integer idUsuario) {
        List<Puja> lista = (List<Puja>) getEntityManager().createNamedQuery("Puja.pujasUsuario").setParameter("idusuariopujador", idUsuario).getResultList();
        return lista;
    }
    
    @GET
    @Path("articulo/{idArticulo}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public List<Puja> pujasArticulo(@PathParam("idArticulo") Integer idArticulo) {
        List<Puja> lista = (List<Puja>) getEntityManager()
            .createNamedQuery("Puja.pujasArticulo")
            .setParameter("idarticulo", idArticulo)
            .getResultList();
        return lista;
    }
    
    @GET
    @Path("{idUsuario}/{idArticulo}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public String puedePujar( @PathParam("idUsuario") Integer idUsuario, @PathParam("idArticulo") Integer idArticulo){
        long i = (long) getEntityManager()
            .createNamedQuery("Puja.posiblePujar")
            .setParameter("idusuariopujador", idUsuario)
            .setParameter("idarticulo", idArticulo)
            .getSingleResult();
        
        String resultado = "";
        if(i > 0){
            resultado = "{\"puedePujar\":0}";
        
        }else{
            resultado = "{\"puedePujar\":1}";
        }
        return resultado;
    }
    
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
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

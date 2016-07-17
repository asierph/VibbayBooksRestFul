package POJOS;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "articulo", catalog = "vibbaybooks", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Articulo.findAll", query = "SELECT a FROM Articulo a"),
    @NamedQuery(name = "Articulo.findByIdarticulo", query = "SELECT a FROM Articulo a WHERE a.idarticulo = :idarticulo"),
    @NamedQuery(name = "Articulo.findByDenominacion", query = "SELECT a FROM Articulo a WHERE a.denominacion = :denominacion"),
    @NamedQuery(name = "Articulo.findByImagen", query = "SELECT a FROM Articulo a WHERE a.imagen = :imagen"),
    @NamedQuery(name = "Articulo.findByPrecio", query = "SELECT a FROM Articulo a WHERE a.precio = :precio"),
    @NamedQuery(name = "Articulo.findByFechapubli", query = "SELECT a FROM Articulo a WHERE a.fechapubli = :fechapubli"),
    @NamedQuery(name = "Articulo.findByEstado", query = "SELECT a FROM Articulo a WHERE a.estado = :estado"),
    @NamedQuery(name = "Articulo.findAllByIdvendedor", query = "SELECT a FROM Articulo a WHERE a.idvendedor.idusuario = :idvendedor")})

public class Articulo implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idarticulo", nullable = false)
    private Integer idarticulo;
    
    @Size(max = 255)
    @Column(name = "denominacion", length = 255)
    private String denominacion;
    
    @Size(max = 255)
    @Column(name = "imagen", length = 255)
    private String imagen;
    
    @Size(max = 45)
    @Column(name = "precio", length = 45)
    private String precio;
    
    @Column(name = "fechapubli")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechapubli;
    
    @Size(max = 45)
    @Column(name = "estado", length = 45)
    private String estado;
    
    @JoinColumn(name = "idvendedor", referencedColumnName = "idusuario")
    @ManyToOne
    private Usuario idvendedor;

    public Articulo() {
    }

    public Articulo(Integer idarticulo) {
        this.idarticulo = idarticulo;
    }


    //<editor-fold defaultstate="collapsed" desc="GETTERS">
    public Integer getIdarticulo() {
        return idarticulo;
    }
    
    public String getDenominacion() {
        return denominacion;
    }
    
    public String getImagen() {
        return imagen;
    }
    
    public String getPrecio() {
        return precio;
    }
    
    public Date getFechapubli() {
        return fechapubli;
    }
    
    public String getEstado() {
        return estado;
    }
      
    public Usuario getIdvendedor() {
        return idvendedor;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="SETTERS">
    public void setIdarticulo(Integer idarticulo) {
        this.idarticulo = idarticulo;
    }
    
    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }
    
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    public void setPrecio(String precio) {
        this.precio = precio;
    }
    
    public void setFechapubli(Date fechapubli) {
        this.fechapubli = fechapubli;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public void setIdvendedor(Usuario idvendedor) {
        this.idvendedor = idvendedor;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="HASH-CODE">
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.idarticulo);
        hash = 23 * hash + Objects.hashCode(this.denominacion);
        hash = 23 * hash + Objects.hashCode(this.imagen);
        hash = 23 * hash + Objects.hashCode(this.precio);
        hash = 23 * hash + Objects.hashCode(this.fechapubli);
        hash = 23 * hash + Objects.hashCode(this.estado);
        hash = 23 * hash + Objects.hashCode(this.idvendedor);
        return hash;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="EQUALS">
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Articulo other = (Articulo) obj;
        if (!Objects.equals(this.idarticulo, other.idarticulo)) {
            return false;
        }
        if (!Objects.equals(this.denominacion, other.denominacion)) {
            return false;
        }
        if (!Objects.equals(this.imagen, other.imagen)) {
            return false;
        }
        if (!Objects.equals(this.precio, other.precio)) {
            return false;
        }
        if (!Objects.equals(this.fechapubli, other.fechapubli)) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        if (!Objects.equals(this.idvendedor, other.idvendedor)) {
            return false;
        }
        return true;
    }
//</editor-fold>
     
}

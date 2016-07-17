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
@Table(name = "puja", catalog = "vibbaybooks", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Puja.findAll", query = "SELECT p FROM Puja p"),
    @NamedQuery(name = "Puja.findByIdpuja", query = "SELECT p FROM Puja p WHERE p.idpuja = :idpuja"),
    @NamedQuery(name = "Puja.findByPreciopuja", query = "SELECT p FROM Puja p WHERE p.preciopuja = :preciopuja"),
    @NamedQuery(name = "Puja.pujasUsuario", query = "SELECT p FROM Puja p WHERE p.idusuariopujador.idusuario = :idusuariopujador"),
    @NamedQuery(name = "Puja.pujasArticulo", query = "SELECT p FROM Puja p WHERE p.idarticulo.idarticulo = :idarticulo"),
    @NamedQuery(name = "Puja.posiblePujar", query = "SELECT COUNT(p) FROM Puja p WHERE p.idarticulo.idarticulo = :idarticulo AND p.idusuariopujador.idusuario = :idusuariopujador"),
    @NamedQuery(name = "Puja.findByFechapuja", query = "SELECT p FROM Puja p WHERE p.fechapuja = :fechapuja")})

public class Puja implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpuja", nullable = false)
    private Integer idpuja;
    
    @Size(max = 45)
    @Column(name = "preciopuja", length = 45)
    private String preciopuja;
    
    @Column(name = "fechapuja")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechapuja;
    
    @JoinColumn(name = "idusuariopujador", referencedColumnName = "idusuario")
    @ManyToOne
    private Usuario idusuariopujador;
    
    @JoinColumn(name = "idarticulo", referencedColumnName = "idarticulo")
    @ManyToOne
    private Articulo idarticulo;

    public Puja() {
    }

    public Puja(Integer idpuja) {
        this.idpuja = idpuja;
    }

    //<editor-fold defaultstate="collapsed" desc="GETTERS">
    public Integer getIdpuja() {
        return idpuja;
    }
    
    public String getPreciopuja() {
        return preciopuja;
    }
    
    public Date getFechapuja() {
        return fechapuja;
    }
    
    public Usuario getIdusuariopujador() {
        return idusuariopujador;
    }
    
    public Articulo getIdarticulo() {
        return idarticulo;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="SETTERS">
    public void setIdpuja(Integer idpuja) {
        this.idpuja = idpuja;
    }
    
    public void setPreciopuja(String preciopuja) {
        this.preciopuja = preciopuja;
    }
    
    public void setFechapuja(Date fechapuja) {
        this.fechapuja = fechapuja;
    }
    
    public void setIdusuariopujador(Usuario idusuariopujador) {
        this.idusuariopujador = idusuariopujador;
    }
    
    public void setIdarticulo(Articulo idarticulo) {
        this.idarticulo = idarticulo;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="HASH-CODE">
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.idpuja);
        hash = 67 * hash + Objects.hashCode(this.preciopuja);
        hash = 67 * hash + Objects.hashCode(this.fechapuja);
        hash = 67 * hash + Objects.hashCode(this.idusuariopujador);
        hash = 67 * hash + Objects.hashCode(this.idarticulo);
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
        final Puja other = (Puja) obj;
        if (!Objects.equals(this.idpuja, other.idpuja)) {
            return false;
        }
        if (!Objects.equals(this.preciopuja, other.preciopuja)) {
            return false;
        }
        if (!Objects.equals(this.fechapuja, other.fechapuja)) {
            return false;
        }
        if (!Objects.equals(this.idusuariopujador, other.idusuariopujador)) {
            return false;
        }
        if (!Objects.equals(this.idarticulo, other.idarticulo)) {
            return false;
        }
        return true;
    }
//</editor-fold>

}

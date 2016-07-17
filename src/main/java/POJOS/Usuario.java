package POJOS;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "usuario", catalog = "vibbaybooks", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdusuario", query = "SELECT u FROM Usuario u WHERE u.idusuario = :idusuario"),
    @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email"),
    @NamedQuery(name = "Usuario.findByPassword", query = "SELECT u FROM Usuario u WHERE u.password = :password"),
    @NamedQuery(name = "Usuario.findByMovil", query = "SELECT u FROM Usuario u WHERE u.movil = :movil"),
    @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Usuario.findByEmailPass", query = "SELECT u FROM Usuario u WHERE u.email = :email AND u.password = :password")})

public class Usuario implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idusuario", nullable = false)
    private Integer idusuario;
    
    @Size(max = 45)
    @Column(name = "email", length = 45)
    private String email;
    
    @Size(max = 45)
    @Column(name = "password", length = 45)
    private String password;
    
    @Size(max = 45)
    @Column(name = "movil", length = 45)
    private String movil;
    
    @Size(max = 45)
    @Column(name = "nombre", length = 45)
    private String nombre;

    public Usuario() {
    }

    //<editor-fold defaultstate="collapsed" desc="GETTERS">
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    
    public Integer getIdusuario() {
        return idusuario;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getMovil() {
        return movil;
    }
    
    public String getNombre() {
        return nombre;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="SETTERS">
    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setMovil(String movil) {
        this.movil = movil;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="HASHCODE">
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.idusuario);
        hash = 83 * hash + Objects.hashCode(this.email);
        hash = 83 * hash + Objects.hashCode(this.password);
        hash = 83 * hash + Objects.hashCode(this.movil);
        hash = 83 * hash + Objects.hashCode(this.nombre);
        return hash;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="EQUALS">
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.movil, other.movil)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.idusuario, other.idusuario)) {
            return false;
        }
        return true;
    }
//</editor-fold>
    
    

    
    
}

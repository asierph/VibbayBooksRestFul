package POJOS;

public class Imagen {
    
    private String imagenCodificada;
    private String nombre;
    
    public Imagen(){       
    }
    
    public Imagen(String imagenCodificada, String nombre) {
        this.imagenCodificada = imagenCodificada;
        this.nombre = nombre;
    }

    //<editor-fold defaultstate="collapsed" desc="GETTERS">
    public String getImagenCodificada() {
        return imagenCodificada;
    }
    
    public String getNombre() {
        return nombre;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="SETTERS">
    public void setImagenCodificada(String imagenCodificada) {
        this.imagenCodificada = imagenCodificada;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
//</editor-fold>

}

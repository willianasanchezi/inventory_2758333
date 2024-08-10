package co.app.model;  
  
public class Rol {  
    private int idRol;  
    private int codigoRol;  
    private String nombrePermiso;  
    private String descripcion;  
  
    // Constructor sin parámetros  
    public Rol() {}  
  
    // Constructor con parámetros  
    public Rol(int codigoRol, String nombrePermiso, String descripcion) {  
        this.codigoRol = codigoRol;  
        this.nombrePermiso = nombrePermiso;  
        this.descripcion = descripcion;  
    }  
  
    // Constructor con todos los parámetros  
    public Rol(int idRol, int codigoRol, String nombrePermiso, String descripcion) {  
        this.idRol = idRol;  
        this.codigoRol = codigoRol;  
        this.nombrePermiso = nombrePermiso;  
        this.descripcion = descripcion;  
    }  
  
    // Getters y Setters  
  
    public int getIdRol() {  
        return idRol;  
    }  
  
    public void setIdRol(int idRol) {  
        this.idRol = idRol;  
    }  
  
    public int getCodigoRol() {  
        return codigoRol;  
    }  
  
    public void setCodigoRol(int codigoRol) {  
        this.codigoRol = codigoRol;  
    }  
  
    public String getNombrePermiso() {  
        return nombrePermiso;  
    }  
  
    public void setNombrePermiso(String nombrePermiso) {  
        this.nombrePermiso = nombrePermiso;  
    }  
  
    public String getDescripcion() {  
        return descripcion;  
    }  
  
    public void setDescripcion(String descripcion) {  
        this.descripcion = descripcion;  
    }  
}  

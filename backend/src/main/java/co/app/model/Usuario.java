package co.app.model;    
  
public class Usuario {    
    private int idUsuario;    
    private String nombreCompleto;    
    private String identificacion;    
    private String correoElectronico;    
    private String contrasena;    
    private int codigoRol;    
  
    // Constructor sin parámetros  
    public Usuario() {}  
  
    // Constructor con cinco parámetros  
    public Usuario(String nombreCompleto, String identificacion, String correoElectronico, String contrasena, int codigoRol) {  
        this.nombreCompleto = nombreCompleto;  
        this.identificacion = identificacion;  
        this.correoElectronico = correoElectronico;  
        this.contrasena = contrasena;  
        this.codigoRol = codigoRol;  
    }  
    
    // Constructor con seis parámetros  
    public Usuario(int idUsuario, String nombreCompleto, String identificacion, String correoElectronico, String contrasena, int codigoRol) {  
        this.idUsuario = idUsuario;  
        this.nombreCompleto = nombreCompleto;  
        this.identificacion = identificacion;  
        this.correoElectronico = correoElectronico;  
        this.contrasena = contrasena;  
        this.codigoRol = codigoRol;  
    }  
  
    // Getters y Setters    
    
    public int getIdUsuario() {    
        return idUsuario;    
    }    
    
    public void setIdUsuario(int idUsuario) {    
        this.idUsuario = idUsuario;    
    }    
    
    public String getNombreCompleto() {    
        return nombreCompleto;    
    }    
    
    public void setNombreCompleto(String nombreCompleto) {    
        this.nombreCompleto = nombreCompleto;    
    }    
    
    public String getIdentificacion() {    
        return identificacion;    
    }    
    
    public void setIdentificacion(String identificacion) {    
        this.identificacion = identificacion;    
    }    
    
    public String getCorreoElectronico() {    
        return correoElectronico;    
    }    
    
    public void setCorreoElectronico(String correoElectronico) {    
        this.correoElectronico = correoElectronico;    
    }    
    
    public String getContrasena() {    
        return contrasena;    
    }    
    
    public void setContrasena(String contrasena) {    
        this.contrasena = contrasena;    
    }    
    
    public int getCodigoRol() {
        return codigoRol;    
    }    
    
    public void setcodigoRol(int codigoRol) {    
        this.codigoRol = codigoRol;    
    }    
}  

package co.app.model;  
  
import java.sql.Timestamp;

public class Prestamo {  
    private int idPrestamo;  
    private int idUsuario;  
    private int idProducto;  
    private Timestamp fechaPrestamo;
    private Timestamp fechaDevolucion;
    private String estado;  
  
    // Constructor sin parámetros  
    public Prestamo() {}  
  
    // Constructor con todos los parámetros, excepto idPrestamo (autogenerado)  
    public Prestamo(int idUsuario, int idProducto, Timestamp fechaPrestamo, Timestamp fechaDevolucion, String estado) {
        this.idUsuario = idUsuario;  
        this.idProducto = idProducto;  
        this.fechaPrestamo = fechaPrestamo;  
        this.fechaDevolucion = fechaDevolucion;  
        this.estado = estado;  
    }  
  
    // Constructor con todos los parámetros, incluyendo idPrestamo  
    public Prestamo(int idPrestamo, int idUsuario, int idProducto, Timestamp fechaPrestamo, Timestamp fechaDevolucion, String estado) {
        this.idPrestamo = idPrestamo;  
        this.idUsuario = idUsuario;  
        this.idProducto = idProducto;  
        this.fechaPrestamo = fechaPrestamo;  
        this.fechaDevolucion = fechaDevolucion;  
        this.estado = estado;  
    }  
  
    // Getters y Setters  
  
    public int getIdPrestamo() {  
        return idPrestamo;  
    }  
  
    public void setIdPrestamo(int idPrestamo) {  
        this.idPrestamo = idPrestamo;  
    }  
  
    public int getIdUsuario() {  
        return idUsuario;  
    }  
  
    public void setIdUsuario(int idUsuario) {  
        this.idUsuario = idUsuario;  
    }  
  
    public int getIdProducto() {  
        return idProducto;  
    }  
  
    public void setIdProducto(int idProducto) {  
        this.idProducto = idProducto;  
    }  
  
    public Timestamp getFechaPrestamo() {
        return fechaPrestamo;  
    }  
  
    public void setFechaPrestamo(Timestamp fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;  
    }  
  
    public Timestamp getFechaDevolucion() {
        return fechaDevolucion;  
    }  
  
    public void setFechaDevolucion(Timestamp fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;  
    }  
  
    public String getEstado() {  
        return estado;  
    }  
  
    public void setEstado(String estado) {  
        this.estado = estado;  
    }  
}  

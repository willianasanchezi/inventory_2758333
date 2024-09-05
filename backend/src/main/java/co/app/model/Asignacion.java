// co/app/model/Asignacion.java
package co.app.model;

import java.sql.Timestamp;

public class Asignacion {
    private int idAsignacion;
    private int idProducto;
    private int idUsuario;
    private Timestamp fechaCreacion;
    private Timestamp fechaAsignacion;
    private Timestamp fechaDevolucionProgramada;
    private Timestamp fechaDevolucionReal;
    private String estadoAsignacion;
    private String tipoAsignacion;
    private String observaciones;

    // Constructor sin parámetros
    public Asignacion() {}

    // Constructor con todos los parámetros
    public Asignacion(int idAsignacion, int idProducto, int idUsuario, Timestamp fechaCreacion, Timestamp fechaAsignacion,
                      Timestamp fechaDevolucionProgramada, Timestamp fechaDevolucionReal, String estadoAsignacion,
                      String tipoAsignacion, String observaciones) {
        this.idAsignacion = idAsignacion;
        this.idProducto = idProducto;
        this.idUsuario = idUsuario;
        this.fechaCreacion = fechaCreacion;
        this.fechaAsignacion = fechaAsignacion;
        this.fechaDevolucionProgramada = fechaDevolucionProgramada;
        this.fechaDevolucionReal = fechaDevolucionReal;
        this.estadoAsignacion = estadoAsignacion;
        this.tipoAsignacion = tipoAsignacion;
        this.observaciones = observaciones;
    }

    // Getters y Setters
    public int getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsignacion(int idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Timestamp getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(Timestamp fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public Timestamp getFechaDevolucionProgramada() {
        return fechaDevolucionProgramada;
    }

    public void setFechaDevolucionProgramada(Timestamp fechaDevolucionProgramada) {
        this.fechaDevolucionProgramada = fechaDevolucionProgramada;
    }

    public Timestamp getFechaDevolucionReal() {
        return fechaDevolucionReal;
    }

    public void setFechaDevolucionReal(Timestamp fechaDevolucionReal) {
        this.fechaDevolucionReal = fechaDevolucionReal;
    }

    public String getEstadoAsignacion() {
        return estadoAsignacion;
    }

    public void setEstadoAsignacion(String estadoAsignacion) {
        this.estadoAsignacion = estadoAsignacion;
    }

    public String getTipoAsignacion() {
        return tipoAsignacion;
    }

    public void setTipoAsignacion(String tipoAsignacion) {
        this.tipoAsignacion = tipoAsignacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}

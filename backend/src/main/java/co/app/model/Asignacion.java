// co/app/model/Asignacion.java
package co.app.model;

import java.sql.Timestamp;

public class Asignacion {
    private int idAsignacion;
    private int idProducto;
    private int idUsuario;
    private Timestamp asigFechaCreacion;
    private Timestamp asigFechaAsignacion;
    private Timestamp asigFechaDevolucionProgramada;
    private Timestamp asigFechaDevolucionReal;
    private String asigEstadoAsignacion;
    private String asigTipoAsignacion;
    private String asigObservaciones;

    // Constructor sin parámetros
    public Asignacion() {
    }

    // Constructor con todos los parámetros
    public Asignacion(int idAsignacion, int idProducto, int idUsuario, Timestamp asigFechaCreacion,
            Timestamp asigFechaAsignacion,
            Timestamp asigFechaDevolucionProgramada, Timestamp asigFechaDevolucionReal, String asigEstadoAsignacion,
            String asigTipoAsignacion, String asigObservaciones) {
        this.idAsignacion = idAsignacion;
        this.idProducto = idProducto;
        this.idUsuario = idUsuario;
        this.asigFechaCreacion = asigFechaCreacion;
        this.asigFechaAsignacion = asigFechaAsignacion;
        this.asigFechaDevolucionProgramada = asigFechaDevolucionProgramada;
        this.asigFechaDevolucionReal = asigFechaDevolucionReal;
        this.asigEstadoAsignacion = asigEstadoAsignacion;
        this.asigTipoAsignacion = asigTipoAsignacion;
        this.asigObservaciones = asigObservaciones;
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

    public Timestamp getAsigFechaCreacion() {
        return asigFechaCreacion;
    }

    public void setAsigFechaCreacion(Timestamp asigFechaCreacion) {
        this.asigFechaCreacion = asigFechaCreacion;
    }

    public Timestamp getAsigFechaAsignacion() {
        return asigFechaAsignacion;
    }

    public void setAsigFechaAsignacion(Timestamp asigFechaAsignacion) {
        this.asigFechaAsignacion = asigFechaAsignacion;
    }

    public Timestamp getAsigFechaDevolucionProgramada() {
        return asigFechaDevolucionProgramada;
    }

    public void setAsigFechaDevolucionProgramada(Timestamp asigFechaDevolucionProgramada) {
        this.asigFechaDevolucionProgramada = asigFechaDevolucionProgramada;
    }

    public Timestamp getAsigFechaDevolucionReal() {
        return asigFechaDevolucionReal;
    }

    public void setAsigFechaDevolucionReal(Timestamp asigFechaDevolucionReal) {
        this.asigFechaDevolucionReal = asigFechaDevolucionReal;
    }

    public String getAsigEstadoAsignacion() {
        return asigEstadoAsignacion;
    }

    public void setAsigEstadoAsignacion(String asigEstadoAsignacion) {
        this.asigEstadoAsignacion = asigEstadoAsignacion;
    }

    public String getAsigTipoAsignacion() {
        return asigTipoAsignacion;
    }

    public void setAsigTipoAsignacion(String asigTipoAsignacion) {
        this.asigTipoAsignacion = asigTipoAsignacion;
    }

    public String getAsigObservaciones() {
        return asigObservaciones;
    }

    public void setAsigObservaciones(String asigObservaciones) {
        this.asigObservaciones = asigObservaciones;
    }
}

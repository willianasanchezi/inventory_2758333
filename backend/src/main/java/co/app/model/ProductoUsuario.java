package co.app.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class ProductoUsuario {
    private int idProducto;
    private String codigo;
    private String nombreProducto;
    private String descripcion;
    private String marca;
    private String modelo;
    private String cantidadMemoria;
    private String capacidadDisco;
    private String estado;
    private int cantidad;
    private BigDecimal precioUnitario;
    private Timestamp fechaRegistro;
    private String userCreoRegistro;

    private int idUsuario;
    private Timestamp fechaCreacion;
    private String nombreCompleto;
    private String identificacion;
    private String correoElectronico;
    private String contrasena;
    private int codigoRol;
    private String estadoUsuario;

    private int idAsignacion;
    private Timestamp asigfechaCreacion;
    private Timestamp asigfechaAsignacion;
    private Timestamp asigfechaDevolucionProgramada;
    private Timestamp asigfechaDevolucionReal;
    private String asigestadoAsignacion;
    private String asigtipoAsignacion;
    private String asigobservaciones;

    // Constructor sin parámetros
    public ProductoUsuario() {
    }

    // Constructor con todos los parámetros
    public ProductoUsuario(int idProducto, String codigo, String nombreProducto, String descripcion, String marca,
            String modelo,
            String cantidadMemoria, String capacidadDisco, String estado, int cantidad, BigDecimal precioUnitario,
            Timestamp fechaRegistro, String userCreoRegistro,
            int idUsuario, Timestamp fechaCreacion, String nombreCompleto, String identificacion,
            String correoElectronico,
            String contrasena, int codigoRol, String estadoUsuario,
            int idAsignacion, Timestamp asigfechaCreacion,
            Timestamp asigfechaAsignacion,
            Timestamp asigfechaDevolucionProgramada, Timestamp asigfechaDevolucionReal, String asigestadoAsignacion,
            String asigtipoAsignacion, String asigobservaciones) {
        this.idProducto = idProducto;
        this.codigo = codigo;
        this.nombreProducto = nombreProducto;
        this.descripcion = descripcion;
        this.marca = marca;
        this.modelo = modelo;
        this.cantidadMemoria = cantidadMemoria;
        this.capacidadDisco = capacidadDisco;
        this.estado = estado;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.fechaRegistro = fechaRegistro;
        this.userCreoRegistro = userCreoRegistro;

        this.idUsuario = idUsuario;
        this.fechaCreacion = fechaCreacion;
        this.nombreCompleto = nombreCompleto;
        this.identificacion = identificacion;
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
        this.codigoRol = codigoRol;
        this.estadoUsuario = estadoUsuario;

        this.idAsignacion = idAsignacion;
        this.asigfechaCreacion = asigfechaCreacion;
        this.asigfechaAsignacion = asigfechaAsignacion;
        this.asigfechaDevolucionProgramada = asigfechaDevolucionProgramada;
        this.asigfechaDevolucionReal = asigfechaDevolucionReal;
        this.asigestadoAsignacion = asigestadoAsignacion;
        this.asigtipoAsignacion = asigtipoAsignacion;
        this.asigobservaciones = asigobservaciones;
    }

    // Getters y Setters

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCantidadMemoria() {
        return cantidadMemoria;
    }

    public void setCantidadMemoria(String cantidadMemoria) {
        this.cantidadMemoria = cantidadMemoria;
    }

    public String getCapacidadDisco() {
        return capacidadDisco;
    }

    public void setCapacidadDisco(String capacidadDisco) {
        this.capacidadDisco = capacidadDisco;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getUserCreoRegistro() {
        return userCreoRegistro;
    }

    public void setUserCreoRegistro(String userCreoRegistro) {
        this.userCreoRegistro = userCreoRegistro;
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

    public void setCodigoRol(int codigoRol) {
        this.codigoRol = codigoRol;
    }

    public String getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(String estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    // Asignacion
    public int getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsignacion(int idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public Timestamp getAsigFechaCreacion() {
        return asigfechaCreacion;
    }

    public void setAsigFechaCreacion(Timestamp asigfechaCreacion) {
        this.asigfechaCreacion = asigfechaCreacion;
    }

    public Timestamp getAsigFechaAsignacion() {
        return asigfechaAsignacion;
    }

    public void setAsigFechaAsignacion(Timestamp asigfechaAsignacion) {
        this.asigfechaAsignacion = asigfechaAsignacion;
    }

    public Timestamp getAsigFechaDevolucionProgramada() {
        return asigfechaDevolucionProgramada;
    }

    public void setAsigFechaDevolucionProgramada(Timestamp asigfechaDevolucionProgramada) {
        this.asigfechaDevolucionProgramada = asigfechaDevolucionProgramada;
    }

    public Timestamp getAsigFechaDevolucionReal() {
        return asigfechaDevolucionReal;
    }

    public void setAsigFechaDevolucionReal(Timestamp asigfechaDevolucionReal) {
        this.asigfechaDevolucionReal = asigfechaDevolucionReal;
    }

    public String getAsigEstadoAsignacion() {
        return asigestadoAsignacion;
    }

    public void setAsigEstadoAsignacion(String asigestadoAsignacion) {
        this.asigestadoAsignacion = asigestadoAsignacion;
    }

    public String getAsigTipoAsignacion() {
        return asigtipoAsignacion;
    }

    public void setAsigTipoAsignacion(String asigtipoAsignacion) {
        this.asigtipoAsignacion = asigtipoAsignacion;
    }

    public String getAsigObservaciones() {
        return asigobservaciones;
    }

    public void setAsigObservaciones(String asigobservaciones) {
        this.asigobservaciones = asigobservaciones;
    }

}

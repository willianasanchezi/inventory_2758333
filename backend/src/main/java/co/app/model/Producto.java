package co.app.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Producto {
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

    // Constructor sin parámetros
    public Producto() {}

    // Constructor con todos los parámetros
    public Producto(int idProducto, String codigo, String nombreProducto, String descripcion, String marca, String modelo,
                    String cantidadMemoria, String capacidadDisco, String estado, int cantidad, BigDecimal precioUnitario,
                    Timestamp fechaRegistro) {
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
}

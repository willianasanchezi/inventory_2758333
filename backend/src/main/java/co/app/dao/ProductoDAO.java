// co/app/dao/ProductoDAO.java
package co.app.dao;

import co.app.model.Producto;
import co.app.utils.DatabaseConnection;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    private static final String INSERT_PRODUCTO_SQL = "INSERT INTO productos (codigo, nombre_producto, descripcion, marca, modelo, cantidad_memoria, capacidad_disco, estado, cantidad, precio_unitario, user_creo_registro) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_PRODUCTOS = "SELECT * FROM productos";
    private static final String SELECT_PRODUCTO_BY_ID = "SELECT * FROM productos WHERE id_producto = ?";
    private static final String UPDATE_PRODUCTO_SQL = "UPDATE productos SET codigo = ?, nombre_producto = ?, descripcion = ?, marca = ?, modelo = ?, cantidad_memoria = ?, capacidad_disco = ?, estado = ?, cantidad = ?, precio_unitario = ?, user_creo_registro = ?  WHERE id_producto = ?";
    private static final String DELETE_PRODUCTO_SQL = "DELETE FROM productos WHERE id_producto = ?";

    public void insertarProducto(Producto producto) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCTO_SQL)) {
            preparedStatement.setString(1, producto.getCodigo());
            preparedStatement.setString(2, producto.getNombreProducto());
            preparedStatement.setString(3, producto.getDescripcion());
            preparedStatement.setString(4, producto.getMarca());
            preparedStatement.setString(5, producto.getModelo());
            preparedStatement.setString(6, producto.getCantidadMemoria());
            preparedStatement.setString(7, producto.getCapacidadDisco());
            preparedStatement.setString(8, producto.getEstado());
            preparedStatement.setInt(9, producto.getCantidad());
            preparedStatement.setBigDecimal(10, producto.getPrecioUnitario());
            preparedStatement.setString(11, producto.getUserCreoRegistro());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Producto> obtenerTodosLosProductos() {
        List<Producto> productos = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTOS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idProducto = rs.getInt("id_producto");
                String codigo = rs.getString("codigo");
                String nombreProducto = rs.getString("nombre_producto");
                String descripcion = rs.getString("descripcion");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                String cantidadMemoria = rs.getString("cantidad_memoria");
                String capacidadDisco = rs.getString("capacidad_disco");
                String estado = rs.getString("estado");
                int cantidad = rs.getInt("cantidad");
                BigDecimal precioUnitario = rs.getBigDecimal("precio_unitario");
                Timestamp fechaRegistro = rs.getTimestamp("fecha_registro");
                String userCreoRegistro = rs.getString("user_creo_registro");

                productos.add(new Producto(idProducto, codigo, nombreProducto, descripcion, marca, modelo, cantidadMemoria, capacidadDisco, estado, cantidad, precioUnitario, fechaRegistro, userCreoRegistro));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }

    public Producto obtenerProductoPorId(int id) {
        Producto producto = null;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCTO_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String codigo = rs.getString("codigo");
                String nombreProducto = rs.getString("nombre_producto");
                String descripcion = rs.getString("descripcion");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                String cantidadMemoria = rs.getString("cantidad_memoria");
                String capacidadDisco = rs.getString("capacidad_disco");
                String estado = rs.getString("estado");
                int cantidad = rs.getInt("cantidad");
                BigDecimal precioUnitario = rs.getBigDecimal("precio_unitario");
                Timestamp fechaRegistro = rs.getTimestamp("fecha_registro");
                String userCreoRegistro = rs.getString("user_Creo_Registro");

                producto = new Producto(id, codigo, nombreProducto, descripcion, marca, modelo, cantidadMemoria, capacidadDisco, estado, cantidad, precioUnitario, fechaRegistro, userCreoRegistro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return producto;
    }

    public boolean actualizarProducto(Producto producto) {
        boolean rowUpdated = false;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCTO_SQL)) {
            preparedStatement.setString(1, producto.getCodigo());
            preparedStatement.setString(2, producto.getNombreProducto());
            preparedStatement.setString(3, producto.getDescripcion());
            preparedStatement.setString(4, producto.getMarca());
            preparedStatement.setString(5, producto.getModelo());
            preparedStatement.setString(6, producto.getCantidadMemoria());
            preparedStatement.setString(7, producto.getCapacidadDisco());
            preparedStatement.setString(8, producto.getEstado());
            preparedStatement.setInt(9, producto.getCantidad());
            preparedStatement.setBigDecimal(10, producto.getPrecioUnitario());
            preparedStatement.setInt(11, producto.getIdProducto());
            preparedStatement.setString(12, producto.getUserCreoRegistro());

            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }

    public boolean eliminarProducto(int id) {
        boolean rowDeleted = false;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCTO_SQL)) {
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }


    public List<Producto> buscarProductosConFiltros(String nombreProducto, String marca, String modelo, String cantidadMemoria, String capacidadDisco, Timestamp fechaRegistroInicio, Timestamp fechaRegistroFin) {
        List<Producto> productosFiltrados = new ArrayList<>();
        List<Object> parametros = new ArrayList<>();

        StringBuilder sql = new StringBuilder("SELECT * FROM productos WHERE 1=1");

        if (nombreProducto != null && !nombreProducto.trim().isEmpty()) {
            sql.append(" AND nombre_producto LIKE ?");
            parametros.add("%" + nombreProducto.trim() + "%");
        }
        if (marca != null && !marca.trim().isEmpty()) {
            sql.append(" AND marca = ?");
            parametros.add(marca.trim());
        }
        if (modelo != null && !modelo.trim().isEmpty()) {
            sql.append(" AND modelo = ?");
            parametros.add(modelo.trim());
        }
        if (cantidadMemoria != null && !cantidadMemoria.trim().isEmpty()) {
            sql.append(" AND cantidad_memoria = ?");
            parametros.add(cantidadMemoria.trim());
        }
        if (capacidadDisco != null && !capacidadDisco.trim().isEmpty()) {
            sql.append(" AND capacidad_disco = ?");
            parametros.add(capacidadDisco.trim());
        }
        /*
        if (fechaRegistroInicio != null && fechaRegistroFin != null) {
            sql.append(" AND fecha_registro BETWEEN ? AND ?");
            parametros.add(fechaRegistroInicio);
            parametros.add(fechaRegistroFin);
        }
*/
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql.toString())) {
            for (int i = 0; i < parametros.size(); i++) {
                preparedStatement.setObject(i + 1, parametros.get(i));
            }
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idProducto = rs.getInt("id_producto");
                String codigo = rs.getString("codigo");
                String nombreProd = rs.getString("nombre_producto");
                String descripcion = rs.getString("descripcion");
                String marcaProd = rs.getString("marca");
                String modeloProd = rs.getString("modelo");
                String cantidadMem = rs.getString("cantidad_memoria");
                String capacidadDisc = rs.getString("capacidad_disco");
                String estado = rs.getString("estado");
                int cantidad = rs.getInt("cantidad");
                BigDecimal precioUnitario = rs.getBigDecimal("precio_unitario");
                Timestamp fechaRegistro = rs.getTimestamp("fecha_registro");
                String userCreoRegistro = rs.getString("user_Creo_Registro");

                Producto producto = new Producto(idProducto, codigo, nombreProd, descripcion, marcaProd, modeloProd, cantidadMem, capacidadDisc, estado, cantidad, precioUnitario, fechaRegistro, userCreoRegistro);
                productosFiltrados.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productosFiltrados;
    }
}

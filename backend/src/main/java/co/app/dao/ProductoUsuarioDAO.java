package co.app.dao;

import co.app.model.ProductoUsuario;
import co.app.utils.DatabaseConnection;

import java.math.BigDecimal;
//import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class ProductoUsuarioDAO {

    private static final String SELECT_ALL_PRODUCTOS_USUARIOS = "SELECT * FROM productos left join asignaciones on asignaciones.id_producto = productos.id_producto\r\n"
            + //
            "inner join usuarios on asignaciones.id_usuario = usuarios.id_usuario;";

    public List<ProductoUsuario> obtenerTodosLosProductosUsuarios() {
        List<ProductoUsuario> productoUsuario = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTOS_USUARIOS)) {
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

                int idUsuario = rs.getInt("id_usuario");
                Timestamp fechaCreacion = rs.getTimestamp("fecha_creacion");
                String nombreCompleto = rs.getString("nombre_completo");
                String identificacion = rs.getString("identificacion");
                String correoElectronico = rs.getString("correo_electronico");
                String contrasena = rs.getString("contrasena");
                int codigoRol = rs.getInt("codigo_rol");
                String estadoUsuario = rs.getString("estado_usuario");

                int idAsignacion = rs.getInt("id_asignacion");
                Timestamp asigfechaCreacion = rs.getTimestamp("asig_fecha_creacion");
                Timestamp asigfechaAsignacion = rs.getTimestamp("asig_fecha_asignacion");
                Timestamp asigfechaDevolucionProgramada = rs.getTimestamp("asig_fecha_devolucion_programada");
                Timestamp asigfechaDevolucionReal = rs.getTimestamp("asig_fecha_devolucion_real");
                String asigestadoAsignacion = rs.getString("asig_estado_asignacion");
                String asigtipoAsignacion = rs.getString("asig_tipo_asignacion");
                String asigobservaciones = rs.getString("asig_observaciones");

                productoUsuario.add(new ProductoUsuario(idProducto, codigo, nombreProducto, descripcion, marca, modelo,
                        cantidadMemoria, capacidadDisco, estado, cantidad, precioUnitario, fechaRegistro,
                        userCreoRegistro,
                        idUsuario, fechaCreacion, nombreCompleto, identificacion, correoElectronico,
                        contrasena, codigoRol, estadoUsuario,
                        idAsignacion, asigfechaCreacion, asigfechaAsignacion,
                        asigfechaDevolucionProgramada, asigfechaDevolucionReal, asigestadoAsignacion,
                        asigtipoAsignacion,
                        asigobservaciones));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productoUsuario;
    }

}

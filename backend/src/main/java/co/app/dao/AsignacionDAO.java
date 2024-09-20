// co/app/dao/AsignacionDAO.java
package co.app.dao;

import co.app.model.Asignacion;
import co.app.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AsignacionDAO {
    private static final String INSERT_ASIGNACION_SQL = "INSERT INTO asignaciones (id_producto, id_usuario, asig_fecha_asignacion, asig_fecha_devolucion_programada, asig_tipo_asignacion, asig_observaciones) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_ASIGNACIONES = "SELECT * FROM asignaciones";
    private static final String SELECT_ASIGNACION_BY_ID = "SELECT * FROM asignaciones WHERE id_asignacion = ?";
    private static final String UPDATE_ASIGNACION_SQL = "UPDATE asignaciones SET id_producto = ?, id_usuario = ?, asig_fecha_creacion = ?, asig_fecha_asignacion = ?, asig_fecha_devolucion_programada = ?, asig_fecha_devolucion_real = ?, asig_estado_asignacion = ?, asig_tipo_asignacion = ?, asig_observaciones = ? WHERE id_asignacion = ?";
    private static final String DELETE_ASIGNACION_SQL = "DELETE FROM asignaciones WHERE id_asignacion = ?";

    public void insertarAsignacion(Asignacion asignacion) {
        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ASIGNACION_SQL)) {
            preparedStatement.setInt(1, asignacion.getIdProducto());
            preparedStatement.setInt(2, asignacion.getIdUsuario());
            // preparedStatement.setTimestamp(3, asignacion.getAsigFechaCreacion());
            preparedStatement.setTimestamp(3, asignacion.getAsigFechaAsignacion());
            preparedStatement.setTimestamp(4, asignacion.getAsigFechaDevolucionProgramada());
            // preparedStatement.setTimestamp(5, asignacion.getAsigFechaDevolucionReal());
            // preparedStatement.setString(7, asignacion.getAsigEstadoAsignacion());
            preparedStatement.setString(5, asignacion.getAsigTipoAsignacion());
            preparedStatement.setString(6, asignacion.getAsigObservaciones());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Asignacion> obtenerTodasLasAsignaciones() {
        List<Asignacion> asignaciones = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ASIGNACIONES)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idAsignacion = rs.getInt("id_asignacion");
                int idProducto = rs.getInt("id_producto");
                int idUsuario = rs.getInt("id_usuario");
                Timestamp asigFechaCreacion = rs.getTimestamp("asig_fecha_creacion");
                Timestamp asigFechaAsignacion = rs.getTimestamp("asig_fecha_asignacion");
                Timestamp asigFechaDevolucionProgramada = rs.getTimestamp("asig_fecha_devolucion_programada");
                Timestamp asigFechaDevolucionReal = rs.getTimestamp("asig_fecha_devolucion_real");
                String asigEstadoAsignacion = rs.getString("asig_estado_asignacion");
                String asigTipoAsignacion = rs.getString("asig_tipo_asignacion");
                String asigObservaciones = rs.getString("asig_observaciones");

                asignaciones
                        .add(new Asignacion(idAsignacion, idProducto, idUsuario, asigFechaCreacion, asigFechaAsignacion,
                                asigFechaDevolucionProgramada, asigFechaDevolucionReal, asigEstadoAsignacion,
                                asigTipoAsignacion, asigObservaciones));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return asignaciones;
    }

    public Asignacion obtenerAsignacionPorId(int id) {
        Asignacion asignacion = null;
        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ASIGNACION_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                int idProducto = rs.getInt("id_producto");
                int idUsuario = rs.getInt("id_usuario");
                Timestamp asigFechaCreacion = rs.getTimestamp("asig_fecha_creacion");
                Timestamp asigFechaAsignacion = rs.getTimestamp("asig_fecha_asignacion");
                Timestamp asigFechaDevolucionProgramada = rs.getTimestamp("asig_fecha_devolucion_programada");
                Timestamp asigFechaDevolucionReal = rs.getTimestamp("asig_fecha_devolucion_real");
                String asigEstadoAsignacion = rs.getString("asig_estado_asignacion");
                String asigTipoAsignacion = rs.getString("asig_tipo_asignacion");
                String asigObservaciones = rs.getString("asig_observaciones");

                asignacion = new Asignacion(id, idProducto, idUsuario, asigFechaCreacion, asigFechaAsignacion,
                        asigFechaDevolucionProgramada, asigFechaDevolucionReal, asigEstadoAsignacion,
                        asigTipoAsignacion, asigObservaciones);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return asignacion;
    }

    public boolean actualizarAsignacion(Asignacion asignacion) {
        boolean rowUpdated = false;
        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ASIGNACION_SQL)) {
            preparedStatement.setInt(1, asignacion.getIdAsignacion());
            preparedStatement.setInt(2, asignacion.getIdProducto());
            preparedStatement.setInt(3, asignacion.getIdUsuario());
            preparedStatement.setTimestamp(4, asignacion.getAsigFechaCreacion());
            preparedStatement.setTimestamp(5, asignacion.getAsigFechaAsignacion());
            preparedStatement.setTimestamp(6, asignacion.getAsigFechaDevolucionProgramada());
            preparedStatement.setTimestamp(7, asignacion.getAsigFechaDevolucionReal());
            preparedStatement.setString(8, asignacion.getAsigEstadoAsignacion());
            preparedStatement.setString(9, asignacion.getAsigTipoAsignacion());
            preparedStatement.setString(10, asignacion.getAsigObservaciones());

            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }

    public boolean eliminarAsignacion(int id) {
        boolean rowDeleted = false;
        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ASIGNACION_SQL)) {
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }
}

// co/app/dao/AsignacionDAO.java
package co.app.dao;  
  
import co.app.model.Asignacion;  
import co.app.utils.DatabaseConnection;  
  
import java.sql.*;  
import java.util.ArrayList;  
import java.util.List;  
  
public class AsignacionDAO {  
    private static final String INSERT_ASIGNACION_SQL = "INSERT INTO asignaciones (id_producto, id_usuario, fecha_asignacion, fecha_devolucion_programada, tipo_asignacion, observaciones) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_ASIGNACIONES = "SELECT * FROM asignaciones";  
    private static final String SELECT_ASIGNACION_BY_ID = "SELECT * FROM asignaciones WHERE id_asignacion = ?";  
    private static final String UPDATE_ASIGNACION_SQL = "UPDATE asignaciones SET id_producto = ?, id_usuario = ?, fecha_creacion = ?, fecha_asignacion = ?, fecha_devolucion_programada = ?, fecha_devolucion_real = ?, estado_asignacion = ?, tipo_asignacion = ?, observaciones = ? WHERE id_asignacion = ?";  
    private static final String DELETE_ASIGNACION_SQL = "DELETE FROM asignaciones WHERE id_asignacion = ?";  
  
    public void insertarAsignacion(Asignacion asignacion) {  
        try (Connection connection = DatabaseConnection.getConnection();  
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ASIGNACION_SQL)) {  
            preparedStatement.setInt(1, asignacion.getIdProducto());  
            preparedStatement.setInt(2, asignacion.getIdUsuario());  
            //preparedStatement.setTimestamp(3, asignacion.getFechaCreacion());
            preparedStatement.setTimestamp(3, asignacion.getFechaAsignacion());
            preparedStatement.setTimestamp(4, asignacion.getFechaDevolucionProgramada());
            //preparedStatement.setTimestamp(5, asignacion.getFechaDevolucionReal());
            //preparedStatement.setString(7, asignacion.getEstadoAsignacion());
            preparedStatement.setString(5, asignacion.getTipoAsignacion());
            preparedStatement.setString(6, asignacion.getObservaciones());
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
                Timestamp fechaCreacion = rs.getTimestamp("fecha_creacion");  
                Timestamp fechaAsignacion = rs.getTimestamp("fecha_asignacion");  
                Timestamp fechaDevolucionProgramada = rs.getTimestamp("fecha_devolucion_programada");  
                Timestamp fechaDevolucionReal = rs.getTimestamp("fecha_devolucion_real");  
                String estadoAsignacion = rs.getString("estado_asignacion");  
                String tipoAsignacion = rs.getString("tipo_asignacion");  
                String observaciones = rs.getString("observaciones");  
  
                asignaciones.add(new Asignacion(idAsignacion, idProducto, idUsuario, fechaCreacion, fechaAsignacion, fechaDevolucionProgramada, fechaDevolucionReal, estadoAsignacion, tipoAsignacion, observaciones));  
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
                Timestamp fechaCreacion = rs.getTimestamp("fecha_creacion");  
                Timestamp fechaAsignacion = rs.getTimestamp("fecha_asignacion");  
                Timestamp fechaDevolucionProgramada = rs.getTimestamp("fecha_devolucion_programada");  
                Timestamp fechaDevolucionReal = rs.getTimestamp("fecha_devolucion_real");  
                String estadoAsignacion = rs.getString("estado_asignacion");  
                String tipoAsignacion = rs.getString("tipo_asignacion");  
                String observaciones = rs.getString("observaciones");  
  
                asignacion = new Asignacion(id, idProducto, idUsuario, fechaCreacion, fechaAsignacion, fechaDevolucionProgramada, fechaDevolucionReal, estadoAsignacion, tipoAsignacion, observaciones);  
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
            preparedStatement.setInt(1, asignacion.getIdProducto());  
            preparedStatement.setInt(2, asignacion.getIdUsuario());  
            preparedStatement.setTimestamp(3, asignacion.getFechaCreacion());  
            preparedStatement.setTimestamp(4, asignacion.getFechaAsignacion());  
            preparedStatement.setTimestamp(5, asignacion.getFechaDevolucionProgramada());  
            preparedStatement.setTimestamp(6, asignacion.getFechaDevolucionReal());  
            preparedStatement.setString(7, asignacion.getEstadoAsignacion());  
            preparedStatement.setString(8, asignacion.getTipoAsignacion());  
            preparedStatement.setString(9, asignacion.getObservaciones());  
            preparedStatement.setInt(10, asignacion.getIdAsignacion());  
  
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

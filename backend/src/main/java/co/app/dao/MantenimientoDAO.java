package co.app.dao;  
  
import co.app.model.Mantenimiento;  
import co.app.utils.DatabaseConnection;  
  
import java.sql.*;  
import java.util.ArrayList;  
import java.util.List;  
  
public class MantenimientoDAO {  
  
    private static final String INSERT_MANTENIMIENTO_SQL = "INSERT INTO mantenimientos (id_producto, fecha_mantenimiento, descripcion, estado) VALUES (?, ?, ?, ?)";  
    private static final String SELECT_ALL_MANTENIMIENTOS = "SELECT * FROM mantenimientos";  
    private static final String SELECT_MANTENIMIENTO_BY_ID = "SELECT * FROM mantenimientos WHERE id_mantenimiento = ?";  
    private static final String UPDATE_MANTENIMIENTO_SQL = "UPDATE mantenimientos SET id_producto = ?, fecha_mantenimiento = ?, descripcion = ?, estado = ? WHERE id_mantenimiento = ?";  
    private static final String DELETE_MANTENIMIENTO_SQL = "DELETE FROM mantenimientos WHERE id_mantenimiento = ?";  
  
    public void insertarMantenimiento(Mantenimiento mantenimiento) {  
        try (Connection connection = DatabaseConnection.getConnection();  
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MANTENIMIENTO_SQL)) {  
            preparedStatement.setInt(1, mantenimiento.getIdProducto());  
            preparedStatement.setTimestamp(2, new java.sql.Timestamp(mantenimiento.getFechaMantenimiento().getTime()));
            preparedStatement.setString(3, mantenimiento.getDescripcion());  
            preparedStatement.setString(4, mantenimiento.getEstado());  
            preparedStatement.executeUpdate();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }  
  
    public List<Mantenimiento> obtenerTodosLosMantenimientos() {  
        List<Mantenimiento> mantenimientos = new ArrayList<>();  
        try (Connection connection = DatabaseConnection.getConnection();  
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MANTENIMIENTOS)) {  
            ResultSet rs = preparedStatement.executeQuery();  
            while (rs.next()) {  
                int idMantenimiento = rs.getInt("id_mantenimiento");  
                int idProducto = rs.getInt("id_producto");
                Timestamp fechaMantenimiento = rs.getTimestamp("fecha_mantenimiento");
                String descripcion = rs.getString("descripcion");  
                String estado = rs.getString("estado");  
                mantenimientos.add(new Mantenimiento(idMantenimiento, idProducto, fechaMantenimiento, descripcion, estado));  
            }  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        return mantenimientos;  
    }  
  
    public Mantenimiento obtenerMantenimientoPorId(int id) {  
        Mantenimiento mantenimiento = null;  
        try (Connection connection = DatabaseConnection.getConnection();  
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MANTENIMIENTO_BY_ID)) {  
            preparedStatement.setInt(1, id);  
            ResultSet rs = preparedStatement.executeQuery();  
            if (rs.next()) {  
                int idProducto = rs.getInt("id_producto");
                Timestamp fechaMantenimiento = rs.getTimestamp("fecha_mantenimiento");
                String descripcion = rs.getString("descripcion");  
                String estado = rs.getString("estado");  
                mantenimiento = new Mantenimiento(id, idProducto, fechaMantenimiento, descripcion, estado);  
            }  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        return mantenimiento;  
    }  
  
    public boolean actualizarMantenimiento(Mantenimiento mantenimiento) {  
        boolean rowUpdated = false;  
        try (Connection connection = DatabaseConnection.getConnection();  
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_MANTENIMIENTO_SQL)) {  
            preparedStatement.setInt(1, mantenimiento.getIdProducto());  
            preparedStatement.setDate(2, new java.sql.Date(mantenimiento.getFechaMantenimiento().getTime()));  
            preparedStatement.setString(3, mantenimiento.getDescripcion());  
            preparedStatement.setString(4, mantenimiento.getEstado());  
            preparedStatement.setInt(5, mantenimiento.getIdMantenimiento());  
  
            rowUpdated = preparedStatement.executeUpdate() > 0;  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        return rowUpdated;  
    }  
  
    public boolean eliminarMantenimiento(int id) {  
        boolean rowDeleted = false;  
        try (Connection connection = DatabaseConnection.getConnection();  
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_MANTENIMIENTO_SQL)) {  
            preparedStatement.setInt(1, id);  
            rowDeleted = preparedStatement.executeUpdate() > 0;  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        return rowDeleted;  
    }  
}  

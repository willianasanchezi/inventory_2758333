package co.app.dao;  
  
import co.app.model.Prestamo;  
import co.app.utils.DatabaseConnection;  
  
import java.sql.Connection;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.ArrayList;  
import java.util.List;  
import java.sql.Date;
import java.sql.Timestamp;
  
public class PrestamoDAO {  
  
    private static final String INSERT_PRESTAMO_SQL = "INSERT INTO prestamos (id_usuario, id_producto, fecha_prestamo, fecha_devolucion, estado) VALUES (?, ?, ?, ?, ?)";  
    private static final String SELECT_ALL_PRESTAMOS = "SELECT * FROM prestamos";  
    private static final String SELECT_PRESTAMO_BY_ID = "SELECT * FROM prestamos WHERE id_prestamo = ?";  
    private static final String UPDATE_PRESTAMO_SQL = "UPDATE prestamos SET id_usuario = ?, id_producto = ?, fecha_prestamo = ?, fecha_devolucion = ?, estado = ? WHERE id_prestamo = ?";  
    private static final String DELETE_PRESTAMO_SQL = "DELETE FROM prestamos WHERE id_prestamo = ?";  
  
    public void insertarPrestamo(Prestamo prestamo) {  
        try (Connection connection = DatabaseConnection.getConnection();  
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRESTAMO_SQL)) {  
            preparedStatement.setInt(1, prestamo.getIdUsuario());  
            preparedStatement.setInt(2, prestamo.getIdProducto());  
            preparedStatement.setTimestamp(3, prestamo.getFechaPrestamo());
            preparedStatement.setTimestamp(4, prestamo.getFechaDevolucion());
            preparedStatement.setString(5, prestamo.getEstado());  
            preparedStatement.executeUpdate();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }  
  
    public List<Prestamo> obtenerTodosLosPrestamos() {  
        List<Prestamo> prestamos = new ArrayList<>();  
        try (Connection connection = DatabaseConnection.getConnection();  
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRESTAMOS)) {  
            ResultSet rs = preparedStatement.executeQuery();  
            while (rs.next()) {  
                int idPrestamo = rs.getInt("id_prestamo");  
                int idUsuario = rs.getInt("id_usuario");  
                int idProducto = rs.getInt("id_producto");
                Timestamp fechaPrestamo = rs.getTimestamp("fecha_prestamo");
                Timestamp fechaDevolucion = rs.getTimestamp("fecha_devolucion");
                String estado = rs.getString("estado");  
                prestamos.add(new Prestamo(idPrestamo, idUsuario, idProducto, fechaPrestamo, fechaDevolucion, estado));  
            }  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        return prestamos;  
    }  
  
    public Prestamo obtenerPrestamoPorId(int id) {  
        Prestamo prestamo = null;  
        try (Connection connection = DatabaseConnection.getConnection();  
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRESTAMO_BY_ID)) {  
            preparedStatement.setInt(1, id);  
            ResultSet rs = preparedStatement.executeQuery();  
            if (rs.next()) {  
                int idPrestamo = rs.getInt("id_prestamo");  
                int idUsuario = rs.getInt("id_usuario");  
                int idProducto = rs.getInt("id_producto");
                Timestamp fechaPrestamo = rs.getTimestamp("fecha_prestamo");
                Timestamp fechaDevolucion = rs.getTimestamp("fecha_devolucion");
                String estado = rs.getString("estado");  
                prestamo = new Prestamo(idPrestamo, idUsuario, idProducto, fechaPrestamo, fechaDevolucion, estado);  
            }  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        return prestamo;  
    }  
  
    public boolean actualizarPrestamo(Prestamo prestamo) {  
        boolean rowUpdated = false;  
        try (Connection connection = DatabaseConnection.getConnection();  
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRESTAMO_SQL)) {  
            preparedStatement.setInt(1, prestamo.getIdUsuario());  
            preparedStatement.setInt(2, prestamo.getIdProducto());  
            preparedStatement.setTimestamp(3, prestamo.getFechaPrestamo());
            preparedStatement.setTimestamp(4, prestamo.getFechaDevolucion());
            preparedStatement.setString(5, prestamo.getEstado());  
            preparedStatement.setInt(6, prestamo.getIdPrestamo());  
  
            rowUpdated = preparedStatement.executeUpdate() > 0;  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        return rowUpdated;  
    }  
  
    public boolean eliminarPrestamo(int id) {  
        boolean rowDeleted = false;  
        try (Connection connection = DatabaseConnection.getConnection();  
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRESTAMO_SQL)) {  
            preparedStatement.setInt(1, id);  
            rowDeleted = preparedStatement.executeUpdate() > 0;  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        return rowDeleted;  
    }  
}  

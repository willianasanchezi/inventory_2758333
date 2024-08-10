package co.app.dao;  
  
import co.app.model.Rol;  
import co.app.utils.DatabaseConnection;  
  
import java.sql.Connection;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.ArrayList;  
import java.util.List;  
  
public class RolDAO {  
  
    private static final String INSERT_ROL_SQL = "INSERT INTO roles (codigo_rol, nombre_permiso, descripcion) VALUES (?, ?, ?)";  
    private static final String SELECT_ALL_ROLES = "SELECT * FROM roles";  
    private static final String SELECT_ROL_BY_ID = "SELECT * FROM roles WHERE id_rol = ?";  
    private static final String UPDATE_ROL_SQL = "UPDATE roles SET codigo_rol = ?, nombre_permiso = ?, descripcion = ? WHERE id_rol = ?";  
    private static final String DELETE_ROL_SQL = "DELETE FROM roles WHERE id_rol = ?";  
  
    public void insertarRol(Rol rol) {  
        try (Connection connection = DatabaseConnection.getConnection();  
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ROL_SQL)) {  
            preparedStatement.setInt(1, rol.getCodigoRol());  
            preparedStatement.setString(2, rol.getNombrePermiso());  
            preparedStatement.setString(3, rol.getDescripcion());  
            preparedStatement.executeUpdate();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }  
  
    public List<Rol> obtenerTodosLosRoles() {  
        List<Rol> roles = new ArrayList<>();  
        try (Connection connection = DatabaseConnection.getConnection();  
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ROLES)) {  
            ResultSet rs = preparedStatement.executeQuery();  
            while (rs.next()) {  
                int idRol = rs.getInt("id_rol");  
                int codigoRol = rs.getInt("codigo_rol");  
                String nombrePermiso = rs.getString("nombre_permiso");  
                String descripcion = rs.getString("descripcion");  
                roles.add(new Rol(idRol, codigoRol, nombrePermiso, descripcion));  
            }  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        return roles;  
    }  
  
    public Rol obtenerRolPorId(int id) {  
        Rol rol = null;  
        try (Connection connection = DatabaseConnection.getConnection();  
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ROL_BY_ID)) {  
            preparedStatement.setInt(1, id);  
            ResultSet rs = preparedStatement.executeQuery();  
            if (rs.next()) {  
                int codigoRol = rs.getInt("codigo_rol");  
                String nombrePermiso = rs.getString("nombre_permiso");  
                String descripcion = rs.getString("descripcion");  
                rol = new Rol(id, codigoRol, nombrePermiso, descripcion);  
            }  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        return rol;  
    }  
  
    public boolean actualizarRol(Rol rol) {  
        boolean rowUpdated = false;  
        try (Connection connection = DatabaseConnection.getConnection();  
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ROL_SQL)) {  
            preparedStatement.setInt(1, rol.getCodigoRol());  
            preparedStatement.setString(2, rol.getNombrePermiso());  
            preparedStatement.setString(3, rol.getDescripcion());  
            preparedStatement.setInt(4, rol.getIdRol());  
  
            rowUpdated = preparedStatement.executeUpdate() > 0;  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        return rowUpdated;  
    }  
  
    public boolean eliminarRol(int id) {  
        boolean rowDeleted = false;  
        try (Connection connection = DatabaseConnection.getConnection();  
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ROL_SQL)) {  
            preparedStatement.setInt(1, id);  
            rowDeleted = preparedStatement.executeUpdate() > 0;  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        return rowDeleted;  
    }  
}  

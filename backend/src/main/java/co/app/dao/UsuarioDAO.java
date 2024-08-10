package co.app.dao;  
  
import co.app.model.Usuario;  
import co.app.utils.DatabaseConnection;
  
import java.sql.Connection;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.ArrayList;  
import java.util.List;  
  
public class UsuarioDAO {  
  
    private static final String INSERT_USUARIO_SQL = "INSERT INTO usuarios (nombre_completo, identificacion, correo_electronico, contrasena, codigo_rol) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_USUARIOS = "SELECT * FROM usuarios";  
    private static final String SELECT_USUARIO_BY_ID = "SELECT * FROM usuarios WHERE id_usuario = ?";  
    private static final String UPDATE_USUARIO_SQL = "UPDATE usuarios SET nombre_completo = ?, identificacion = ?, correo_electronico = ?, contrasena = ?, codigo_rol = ? WHERE id_usuario = ?";
    private static final String DELETE_USUARIO_SQL = "DELETE FROM usuarios WHERE id_usuario = ?";  
  
    public void insertarUsuario(Usuario usuario) {  
        try (Connection connection = DatabaseConnection.getConnection();  
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USUARIO_SQL)) {  
            preparedStatement.setString(1, usuario.getNombreCompleto());  
            preparedStatement.setString(2, usuario.getIdentificacion());  
            preparedStatement.setString(3, usuario.getCorreoElectronico());  
            preparedStatement.setString(4, usuario.getContrasena());  // Asegúrese de que la contraseña esté encriptada  
            preparedStatement.setInt(5, usuario.getCodigoRol());
            preparedStatement.executeUpdate();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }  
  
    public List<Usuario> obtenerTodosLosUsuarios() {  
        List<Usuario> usuarios = new ArrayList<>();  
        try (Connection connection = DatabaseConnection.getConnection();  
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USUARIOS)) {  
            ResultSet rs = preparedStatement.executeQuery();  
            while (rs.next()) {  
                int idUsuario = rs.getInt("id_usuario");  
                String nombreCompleto = rs.getString("nombre_completo");  
                String identificacion = rs.getString("identificacion");  
                String correoElectronico = rs.getString("correo_electronico");  
                String contrasena = rs.getString("contrasena");  
                int codigoRol = rs.getInt("codigo_rol");  
                usuarios.add(new Usuario(idUsuario, nombreCompleto, identificacion, correoElectronico, contrasena, codigoRol));  
            }  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        return usuarios;  
    }  
  
    public Usuario obtenerUsuarioPorId(int id) {  
        Usuario usuario = null;  
        try (Connection connection = DatabaseConnection.getConnection();  
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USUARIO_BY_ID)) {  
            preparedStatement.setInt(1, id);  
            ResultSet rs = preparedStatement.executeQuery();  
            if (rs.next()) {  
                String nombreCompleto = rs.getString("nombre_completo");  
                String identificacion = rs.getString("identificacion");  
                String correoElectronico = rs.getString("correo_electronico");  
                String contrasena = rs.getString("contrasena");  
                int codigoRol = rs.getInt("codigo_rol");  
                usuario = new Usuario(id, nombreCompleto, identificacion, correoElectronico, contrasena, codigoRol);  
            }  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        return usuario;  
    }  
  
    public boolean actualizarUsuario(Usuario usuario) {  
        boolean rowUpdated = false;  
        try (Connection connection = DatabaseConnection.getConnection();  
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USUARIO_SQL)) {  
            preparedStatement.setString(1, usuario.getNombreCompleto());  
            preparedStatement.setString(2, usuario.getIdentificacion());  
            preparedStatement.setString(3, usuario.getCorreoElectronico());  
            preparedStatement.setString(4, usuario.getContrasena());  // Asegúrese de que la contraseña esté encriptada  
            preparedStatement.setInt(5, usuario.getCodigoRol());
            preparedStatement.setInt(6, usuario.getIdUsuario());  
  
            rowUpdated = preparedStatement.executeUpdate() > 0;  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        return rowUpdated;  
    }  
  
    public boolean eliminarUsuario(int id) {  
        boolean rowDeleted = false;  
        try (Connection connection = DatabaseConnection.getConnection();  
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USUARIO_SQL)) {  
            preparedStatement.setInt(1, id);  
            rowDeleted = preparedStatement.executeUpdate() > 0;  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        return rowDeleted;  
    }  
}  

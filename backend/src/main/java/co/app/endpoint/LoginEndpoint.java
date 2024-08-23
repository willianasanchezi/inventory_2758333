//LoginEndpoint.java
package co.app.endpoint;

import co.app.utils.DatabaseConnection;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Path("/auth")
public class LoginEndpoint {
    private static final String SECRET_KEY = "your_secret_key"; // Cambia esto a una clave secreta segura

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(UserCredentials credentials) {
        AuthResult authResult = authenticateUser(credentials.getUsername(), credentials.getPassword());
        if (authResult.isAuthenticated()) {
            String token = JWT.create()
                    .withSubject(credentials.getUsername())
                    .withClaim("roles", authResult.getRole())
                    .sign(Algorithm.HMAC256(SECRET_KEY));
            return Response.ok(new AuthResponse(token)).build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Usuario o contraseña no es valido").build();
        }
    }

    private AuthResult authenticateUser(String username, String password) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DatabaseConnection.getConnection();
            //String sql = "SELECT contrasena, codigo_rol FROM usuarios WHERE correo_electronico = ?";
            String sql = "SELECT contrasena, codigo_rol FROM usuarios WHERE correo_electronico = ? AND estado_usuario = 'Activo'";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            rs = stmt.executeQuery();
            if (rs.next()) {
                String storedPassword = rs.getString("contrasena");
                if (checkPassword(password, storedPassword)) {
                    int roleId = rs.getInt("codigo_rol");
                    String role = getRoleById(roleId, conn);
                    if (role != null) {
                        return new AuthResult(true, role);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
        return new AuthResult(false, null);
    }

    private String getRoleById(int roleId, Connection conn) throws SQLException {
        String sql = "SELECT nombre_permiso FROM roles WHERE codigo_rol = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, roleId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("nombre_permiso");
                }
            }
        }
        return null;
    }

    private boolean checkPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }

    // Clase interna para las credenciales de usuario
    public static class UserCredentials {
        private String username;
        private String password;

        // Getters y setters
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    // Clase interna para la respuesta de autenticación
    public static class AuthResponse {
        private String token;

        public AuthResponse(String token) {
            this.token = token;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }

    public class AuthResult {
        private boolean authenticated;
        private String role;

        public AuthResult(boolean authenticated, String role) {
            this.authenticated = authenticated;
            this.role = role;
        }

        public boolean isAuthenticated() {
            return authenticated;
        }

        public String getRole() {
            return role;
        }
    }
}


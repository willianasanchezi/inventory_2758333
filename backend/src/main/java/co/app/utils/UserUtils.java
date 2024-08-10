package co.app.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class UserUtils {

    public static UserInfo getUserInfo(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return null;
        }

        String username = (String) session.getAttribute("user");
        if (username == null) {
            return null;
        }

        String userRole = getUserRoleFromDB(username);

        return new UserInfo(username, userRole);
    }

    private static String getUserRoleFromDB(String username) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String role = null;

        try {
            conn = DatabaseConnection.getConnection();
            String sql = "SELECT r.nombre_permiso FROM usuarios u INNER JOIN roles r ON u.codigo_rol = r.codigo_rol WHERE u.correo_electronico = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            rs = stmt.executeQuery();

            if (rs.next()) {
                role = rs.getString("nombre_permiso");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }

        return role;
    }

    public static class UserInfo {
        private final String username;
        private final String role;

        public UserInfo(String username, String role) {
            this.username = username;
            this.role = role;
        }

        public String getUsername() {
            return username;
        }

        public String getRole() {
            return role;
        }
    }
}


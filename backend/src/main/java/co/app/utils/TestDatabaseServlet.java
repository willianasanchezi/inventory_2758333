package co.app.utils;

import java.io.IOException;  
import java.sql.Connection;  
import java.sql.ResultSet;  
import java.sql.Statement;  
  
import jakarta.servlet.ServletException;  
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;  
import jakarta.servlet.http.HttpServletRequest;  
import jakarta.servlet.http.HttpServletResponse;  

@WebServlet("/testDatabase")
public class TestDatabaseServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        try {  
            Connection connection = DatabaseConnection.getConnection();  
  
            // Ejecuta una consulta de prueba  
            Statement stmt = connection.createStatement();  
            ResultSet rs = stmt.executeQuery("SELECT 1");  
  
            if (rs.next()) {  
                response.getWriter().write("La consulta de prueba fue exitosa!");  
            }  
        } catch (Exception e) {  
            response.getWriter().write("La prueba de conexión falló.");  
            e.printStackTrace();  
        }  
    }  
}  

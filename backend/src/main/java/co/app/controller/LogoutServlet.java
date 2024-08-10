package co.app.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/safezone/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener la sesión actual
        HttpSession session = request.getSession(false);

        // Si hay una sesión, invalidarla
        if (session != null) {
            session.invalidate();
        }

        // Redireccionar al usuario a la página de inicio de sesión o a la página principal
        response.sendRedirect("login.jsp"); // Asumiendo que tienes un archivo login.jsp
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Llamar a doGet dentro de doPost para manejar la solicitud POST de la misma manera
        doGet(request, response);
    }
}

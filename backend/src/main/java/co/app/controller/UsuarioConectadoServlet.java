package co.app.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/safezone/user")
public class UsuarioConectadoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String username = (session != null) ? (String) session.getAttribute("user") : null;

        if (username != null) {
            response.setContentType("text/plain");
            response.getWriter().write("Usuario conectado: " + username);
        } else {
            response.setContentType("text/plain");
            response.getWriter().write("No hay usuario conectado.");
        }
    }
}

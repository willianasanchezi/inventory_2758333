package co.app.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.IOException;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.ServletSecurity;

@WebServlet("/safezone/dashboard")
public class DashboardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Aquí podrías agregar cualquier lógica previa al reenvío, como establecer atributos en la solicitud
        // Por ejemplo: request.setAttribute("message", "Welcome to the Dashboard!");

        // Reenvía la solicitud al JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("/safezone/dashboard.jsp");
        if (dispatcher != null) {
            dispatcher.forward(request, response);
        } else {
            // Manejar la situación donde el dispatcher es null
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "La página solicitada no fue encontrada.");
        }
    }
}


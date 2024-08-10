package co.app.controller;

import co.app.utils.UserUtils;
import co.app.utils.UserUtils.UserInfo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("usertest")
public class UsuarioConectadoServletTest extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserInfo userInfo = UserUtils.getUserInfo(request);

        if (userInfo != null) {
            response.setContentType("text/plain");
            response.getWriter().write("Usuario conectado: " + userInfo.getUsername() + " Rol: " + userInfo.getRole());
        } else {
            response.setContentType("text/plain");
            response.getWriter().write("No hay usuario conectado.");
        }
    }
}


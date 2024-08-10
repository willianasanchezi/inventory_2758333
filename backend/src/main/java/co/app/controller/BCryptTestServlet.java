package co.app.controller;

import org.mindrot.jbcrypt.BCrypt;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/bcrypt-test")
public class BCryptTestServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/bcrypt-test.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String testPassword = request.getParameter("password");
        String hashed = BCrypt.hashpw(testPassword, BCrypt.gensalt());

        boolean passwordVerified = BCrypt.checkpw(testPassword, hashed);

        request.setAttribute("hashed", hashed);
        request.setAttribute("passwordVerified", passwordVerified);

        request.getRequestDispatcher("/bcrypt-test.jsp").forward(request, response);
    }
}

package co.app.controller;

import co.app.dao.UsuarioDAO;
import co.app.model.Usuario;
import org.mindrot.jbcrypt.BCrypt;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;
import java.util.List;

@WebServlet("safezone/usuarios")
public class UsuarioServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    private UsuarioDAO usuarioDAO;

    public void init() {
        usuarioDAO = new UsuarioDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }
        switch (action) {
            case "new":
                showNewForm(request, response);
                break;
            case "insert":
                insertUsuario(request, response);
                break;
            case "delete":
                deleteUsuario(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "update":
                updateUsuario(request, response);
                break;
            default:
                listUsuarios(request, response);
                break;
        }
    }

    private void listUsuarios(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Usuario> listaUsuarios = usuarioDAO.obtenerTodosLosUsuarios();
        request.setAttribute("listaUsuarios", listaUsuarios);
        request.getRequestDispatcher("/safezone/usuario-list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/safezone/usuario-form.jsp").forward(request, response);
    }

    private void insertUsuario(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String nombreCompleto = request.getParameter("nombreCompleto");
        String identificacion = request.getParameter("identificacion");
        String correoElectronico = request.getParameter("correoElectronico");
        String contrasena = request.getParameter("contrasena");
        contrasena = hashPassword(contrasena);
        int codigoRol = Integer.parseInt(request.getParameter("codigoRol"));
        Usuario nuevoUsuario = new Usuario(nombreCompleto, identificacion, correoElectronico, contrasena, codigoRol);
        usuarioDAO.insertarUsuario(nuevoUsuario);
        response.sendRedirect("../safezone/usuarios");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Usuario usuarioExistente = usuarioDAO.obtenerUsuarioPorId(id);
        request.setAttribute("usuario", usuarioExistente);
        request.getRequestDispatcher("/safezone/usuario-form.jsp").forward(request, response);
    }

    private void updateUsuario(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int idUsuario = Integer.parseInt(request.getParameter("id"));
        String nombreCompleto = request.getParameter("nombreCompleto");
        String identificacion = request.getParameter("identificacion");
        String correoElectronico = request.getParameter("correoElectronico");
        String contrasena = request.getParameter("contrasena");
        contrasena = hashPassword(contrasena);
        int codigoRol = Integer.parseInt(request.getParameter("codigoRol"));

        Usuario usuarioActualizado = new Usuario(idUsuario, nombreCompleto, identificacion, correoElectronico, contrasena, codigoRol);
        usuarioDAO.actualizarUsuario(usuarioActualizado);
        response.sendRedirect("../safezone/usuarios");
    }

    private void deleteUsuario(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        usuarioDAO.eliminarUsuario(id);
        response.sendRedirect("../safezone/usuarios");
    }

    private String hashPassword(String plainPassword) {
        int coste = 12;
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt(coste));
    }
}


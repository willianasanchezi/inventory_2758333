package co.app.controller;  
  
import co.app.dao.RolDAO;  
import co.app.model.Rol;  
import jakarta.servlet.ServletException;  
import jakarta.servlet.annotation.WebServlet;  
import jakarta.servlet.http.HttpServlet;  
import jakarta.servlet.http.HttpServletRequest;  
import jakarta.servlet.http.HttpServletResponse;  
  
import java.io.IOException;  
import java.io.Serial;  
import java.util.List;  
  
@WebServlet("/safezone/roles")  
public class RolServlet extends HttpServlet {  
    @Serial  
    private static final long serialVersionUID = 1L;  
    private RolDAO rolDAO;  
  
    public void init() {  
        rolDAO = new RolDAO();  
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
                insertRol(request, response);  
                break;  
            case "delete":  
                deleteRol(request, response);  
                break;  
            case "edit":  
                showEditForm(request, response);  
                break;  
            case "update":  
                updateRol(request, response);  
                break;  
            default:  
                listRoles(request, response);  
                break;  
        }  
    }  
  
    private void listRoles(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        List<Rol> listaRoles = rolDAO.obtenerTodosLosRoles();  
        request.setAttribute("listaRoles", listaRoles);  
        request.getRequestDispatcher("/safezone/rol-list.jsp").forward(request, response);  
    }  
  
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        request.getRequestDispatcher("/safezone/rol-form.jsp").forward(request, response);  
    }  
  
    private void insertRol(HttpServletRequest request, HttpServletResponse response)  
            throws IOException {  
        int codigoRol = Integer.parseInt(request.getParameter("codigoRol"));  
        String nombrePermiso = request.getParameter("nombrePermiso");  
        String descripcion = request.getParameter("descripcion");  
        Rol nuevoRol = new Rol(codigoRol, nombrePermiso, descripcion);  
        rolDAO.insertarRol(nuevoRol);  
        response.sendRedirect("../safezone/roles");  
    }  
  
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        int idRol = Integer.parseInt(request.getParameter("id"));  
        Rol rolExistente = rolDAO.obtenerRolPorId(idRol);  
        request.setAttribute("rol", rolExistente);  
        request.getRequestDispatcher("/safezone/rol-form.jsp").forward(request, response);  
    }  
  
    private void updateRol(HttpServletRequest request, HttpServletResponse response)  
            throws IOException {  
        int idRol = Integer.parseInt(request.getParameter("id"));  
        int codigoRol = Integer.parseInt(request.getParameter("codigoRol"));  
        String nombrePermiso = request.getParameter("nombrePermiso");  
        String descripcion = request.getParameter("descripcion");  
        Rol rolActualizado = new Rol(idRol, codigoRol, nombrePermiso, descripcion);  
        rolDAO.actualizarRol(rolActualizado);  
        response.sendRedirect("../safezone/roles");  
    }  
  
    private void deleteRol(HttpServletRequest request, HttpServletResponse response)  
            throws IOException {  
        int idRol = Integer.parseInt(request.getParameter("id"));  
        rolDAO.eliminarRol(idRol);  
        response.sendRedirect("../safezone/roles");  
    }  
}  

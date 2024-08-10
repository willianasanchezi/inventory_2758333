package co.app.controller;  
  
import co.app.dao.PrestamoDAO;
import co.app.model.Prestamo;  
  
import jakarta.servlet.ServletException;  
import jakarta.servlet.annotation.WebServlet;  
import jakarta.servlet.http.HttpServlet;  
import jakarta.servlet.http.HttpServletRequest;  
import jakarta.servlet.http.HttpServletResponse;  
  
import java.io.IOException;  
import java.io.Serial;  
import java.util.List;  
  
@WebServlet("/safezone/prestamos")  
public class PrestamoServlet extends HttpServlet {  
    @Serial  
    private static final long serialVersionUID = 1L;  
    private PrestamoDAO prestamoDAO;  
  
    public void init() {  
        prestamoDAO = new PrestamoDAO();  
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
                insertPrestamo(request, response);  
                break;  
            case "delete":  
                deletePrestamo(request, response);  
                break;  
            case "edit":  
                showEditForm(request, response);  
                break;  
            case "update":  
                updatePrestamo(request, response);  
                break;  
            default:  
                listPrestamos(request, response);  
                break;  
        }  
    }  
  
    private void listPrestamos(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        List<Prestamo> listaPrestamos = prestamoDAO.obtenerTodosLosPrestamos();  
        request.setAttribute("listaPrestamos", listaPrestamos);  
        request.getRequestDispatcher("/safezone/prestamo-list.jsp").forward(request, response);  
    }  
  
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        request.getRequestDispatcher("/safezone/prestamo-form.jsp").forward(request, response);  
    }  
  
    private void insertPrestamo(HttpServletRequest request, HttpServletResponse response)  
            throws IOException {  
        // Implementar la lógica para insertar un nuevo préstamo  
        // Debes obtener los parámetros del formulario y crear una instancia de Prestamo  
        // Luego, llamar al método insertarPrestamo() del DAO  
        response.sendRedirect("../safezone/prestamos");  
    }  
  
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        // Implementar la lógica para mostrar el formulario de edición con los datos del préstamo  
        request.getRequestDispatcher("/safezone/prestamo-form.jsp").forward(request, response);  
    }  
  
    private void updatePrestamo(HttpServletRequest request, HttpServletResponse response)  
            throws IOException {  
        // Implementar la lógica para actualizar un préstamo existente  
        response.sendRedirect("../safezone/prestamos");  
    }  
  
    private void deletePrestamo(HttpServletRequest request, HttpServletResponse response)  
            throws IOException {  
        // Implementar la lógica para eliminar un préstamo  
        response.sendRedirect("../safezone/prestamos");  
    }  
}  

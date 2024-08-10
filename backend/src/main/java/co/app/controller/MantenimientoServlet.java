package co.app.controller;

import co.app.dao.MantenimientoDAO;
import co.app.model.Mantenimiento;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;
import java.sql.Timestamp;
import java.util.List;

@WebServlet("/safezone/mantenimientos")
public class MantenimientoServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    private MantenimientoDAO mantenimientoDAO;

    public void init() {
        mantenimientoDAO = new MantenimientoDAO();
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
        try {
            switch (action) {
                case "new":
                    showNewForm(request, response);
                    break;
                case "insert":
                    insertMantenimiento(request, response);
                    break;
                case "delete":
                    deleteMantenimiento(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "update":
                    updateMantenimiento(request, response);
                    break;
                default:
                    listMantenimientos(request, response);
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    private void listMantenimientos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Mantenimiento> listaMantenimientos = mantenimientoDAO.obtenerTodosLosMantenimientos();
        request.setAttribute("listaMantenimientos", listaMantenimientos);
        request.getRequestDispatcher("mantenimiento-list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("mantenimiento-form.jsp").forward(request, response);
    }

    private void insertMantenimiento(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int idProducto = Integer.parseInt(request.getParameter("idProducto"));
        Timestamp fechaMantenimiento = Timestamp.valueOf(request.getParameter("fechaMantenimiento"));
        String descripcion = request.getParameter("descripcion");
        String estado = request.getParameter("estado");

        Mantenimiento nuevoMantenimiento = new Mantenimiento(idProducto, fechaMantenimiento, descripcion, estado);
        mantenimientoDAO.insertarMantenimiento(nuevoMantenimiento);

        response.sendRedirect("mantenimientos");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Mantenimiento mantenimientoExistente = mantenimientoDAO.obtenerMantenimientoPorId(id);
        request.setAttribute("mantenimiento", mantenimientoExistente);
        request.getRequestDispatcher("mantenimiento-form.jsp").forward(request, response);
    }

    private void updateMantenimiento(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int idMantenimiento = Integer.parseInt(request.getParameter("id"));
        int idProducto = Integer.parseInt(request.getParameter("idProducto"));
        Timestamp fechaMantenimiento = Timestamp.valueOf(request.getParameter("fechaMantenimiento"));
        String descripcion = request.getParameter("descripcion");
        String estado = request.getParameter("estado");

        Mantenimiento mantenimiento = new Mantenimiento(idMantenimiento, idProducto, fechaMantenimiento, descripcion, estado);
        mantenimientoDAO.actualizarMantenimiento(mantenimiento);

        response.sendRedirect("mantenimientos");
    }

    private void deleteMantenimiento(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        mantenimientoDAO.eliminarMantenimiento(id);
        response.sendRedirect("mantenimientos");
    }
}

package co.app.controller;

import co.app.dao.ProductoDAO;
import co.app.model.Producto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@WebServlet("/safezone/productos")
public class ProductoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductoDAO productoDAO;

    public void init() {
        productoDAO = new ProductoDAO();
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
                insertProducto(request, response);
                break;
            case "delete":
                deleteProducto(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "update":
                updateProducto(request, response);
                break;
            default:
                listProductos(request, response);
                break;
        }
    }

    private void listProductos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Producto> listaProductos = productoDAO.obtenerTodosLosProductos();
        request.setAttribute("listaProductos", listaProductos);
        request.getRequestDispatcher("/safezone/producto-list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/safezone/producto-form.jsp").forward(request, response);
    }

    private void insertProducto(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String codigo = request.getParameter("codigo");
        String nombreProducto = request.getParameter("nombreProducto");
        String descripcion = request.getParameter("descripcion");
        String marca = request.getParameter("marca");
        String modelo = request.getParameter("modelo");
        String cantidadMemoria = request.getParameter("cantidadMemoria");
        String capacidadDisco = request.getParameter("capacidadDisco");
        String estado = request.getParameter("estado");
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        BigDecimal precioUnitario = new BigDecimal(request.getParameter("precioUnitario"));

        Producto nuevoProducto = new Producto(0, codigo, nombreProducto, descripcion, marca, modelo, cantidadMemoria, capacidadDisco, estado, cantidad, precioUnitario, new Timestamp(System.currentTimeMillis()));
        productoDAO.insertarProducto(nuevoProducto);
        response.sendRedirect("/safezone/productos?action=list");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Producto existingProducto = productoDAO.obtenerProductoPorId(id);
        request.setAttribute("producto", existingProducto);
        request.getRequestDispatcher("/safezone/producto-form.jsp").forward(request, response);
    }

    private void updateProducto(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String codigo = request.getParameter("codigo");
        String nombreProducto = request.getParameter("nombreProducto");
        String descripcion = request.getParameter("descripcion");
        String marca = request.getParameter("marca");
        String modelo = request.getParameter("modelo");
        String cantidadMemoria = request.getParameter("cantidadMemoria");
        String capacidadDisco = request.getParameter("capacidadDisco");
        String estado = request.getParameter("estado");
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        BigDecimal precioUnitario = new BigDecimal(request.getParameter("precioUnitario"));

        Producto producto = new Producto(id, codigo, nombreProducto, descripcion, marca, modelo, cantidadMemoria, capacidadDisco, estado, cantidad, precioUnitario, new Timestamp(System.currentTimeMillis()));
        productoDAO.actualizarProducto(producto);
        response.sendRedirect("../safezone/productos?action=list");
    }

    private void deleteProducto(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productoDAO.eliminarProducto(id);
        response.sendRedirect("../safezone/productos?action=list");
    }
}

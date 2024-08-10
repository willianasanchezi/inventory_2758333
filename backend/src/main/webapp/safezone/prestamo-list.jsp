<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="co.app.model.Prestamo" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Préstamos</title>
    <link href="<%=request.getContextPath()%>/static/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

    <div class="container mt-4">
        <h2>Lista de Préstamos</h2>
        <a href="../safezone/prestamos?action=new" class="btn btn-primary mb-2">Crear Nuevo Préstamo</a>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>ID Usuario</th>
                    <th>ID Producto</th>
                    <th>Fecha de Préstamo</th>
                    <th>Fecha de Devolución</th>
                    <th>Estado</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Prestamo> listaPrestamos = (List<Prestamo>) request.getAttribute("listaPrestamos");
                    for(Prestamo prestamo : listaPrestamos) {
                %>
                    <tr>
                        <td><%= prestamo.getIdPrestamo() %></td>
                        <td><%= prestamo.getIdUsuario() %></td>
                        <td><%= prestamo.getIdProducto() %></td>
                        <td><%= prestamo.getFechaPrestamo() %></td>
                        <td><%= prestamo.getFechaDevolucion() %></td>
                        <td><%= prestamo.getEstado() %></td>
                        <td>
                            <a href="../safezone/prestamos?action=edit&id=<%= prestamo.getIdPrestamo() %>" class="btn btn-sm btn-warning">Editar</a>
                            <a href="../safezone/prestamos?action=delete&id=<%= prestamo.getIdPrestamo() %>" class="btn btn-sm btn-danger" onclick="return confirm('¿Estás seguro de que deseas eliminar este préstamo?');">Eliminar</a>
                        </td>
                    </tr>
                <%
                    }
                %>
            </tbody>
        </table>
        <nav>
            <form action="../safezone/dashboard" method="get">
                <input type="submit" value="Menu Principal" class="btn btn-secondary">
            </form>
        </nav>
    </div>

    <script src="<%=request.getContextPath()%>/static/js/bootstrap.bundle.min.js"></script>
</body>
</html>

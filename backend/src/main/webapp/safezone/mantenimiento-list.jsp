<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="co.app.model.Mantenimiento" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Mantenimientos</title>
    <link href="<%=request.getContextPath()%>/static/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

    <div class="container mt-4">
        <h2>Lista de Mantenimientos</h2>
        <a href="../safezone/mantenimientos?action=new" class="btn btn-primary mb-2">Crear Nuevo Mantenimiento</a>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>ID Producto</th>
                    <th>Fecha de Mantenimiento</th>
                    <th>Descripción</th>
                    <th>Estado</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Mantenimiento> listaMantenimientos = (List<Mantenimiento>) request.getAttribute("listaMantenimientos");
                    for(Mantenimiento mantenimiento : listaMantenimientos) {
                %>
                    <tr>
                        <td><%= mantenimiento.getIdMantenimiento() %></td>
                        <td><%= mantenimiento.getIdProducto() %></td>
                        <td><%= mantenimiento.getFechaMantenimiento() %></td>
                        <td><%= mantenimiento.getDescripcion() %></td>
                        <td><%= mantenimiento.getEstado() %></td>
                        <td>
                            <a href="../safezone/mantenimientos?action=edit&id=<%= mantenimiento.getIdMantenimiento() %>" class="btn btn-sm btn-warning">Editar</a>
                            <a href="../safezone/mantenimientos?action=delete&id=<%= mantenimiento.getIdMantenimiento() %>" class="btn btn-sm btn-danger" onclick="return confirm('¿Estás seguro de que deseas eliminar este mantenimiento?');">Eliminar</a>
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

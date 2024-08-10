<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="co.app.model.Producto" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Productos</title>
    <!-- Bootstrap CSS -->
    <link href="<%=request.getContextPath()%>/static/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

    <div class="container mt-4">
        <h2>Lista de Productos</h2>
        <a href="../safezone/productos?action=new" class="btn btn-primary mb-2">Crear Nuevo Producto</a>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Código</th>
                    <th>Nombre</th>
                    <th>Descripción</th>
                    <th>Marca</th>
                    <th>Modelo</th>
                    <th>Cantidad Memoria</th>
                    <th>Capacidad Disco</th>
                    <th>Estado</th>
                    <th>Cantidad</th>
                    <th>Precio Unitario</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Producto> listaProductos = (List<Producto>) request.getAttribute("listaProductos");
                    for(Producto producto : listaProductos) {
                %>
                    <tr>
                        <td><%= producto.getIdProducto() %></td>
                        <td><%= producto.getCodigo() %></td>
                        <td><%= producto.getNombreProducto() %></td>
                        <td><%= producto.getDescripcion() %></td>
                        <td><%= producto.getMarca() %></td>
                        <td><%= producto.getModelo() %></td>
                        <td><%= producto.getCantidadMemoria() %></td>
                        <td><%= producto.getCapacidadDisco() %></td>
                        <td><%= producto.getEstado() %></td>
                        <td><%= producto.getCantidad() %></td>
                        <td><%= producto.getPrecioUnitario() %></td>
                        <td>
                            <a href="../safezone/productos?action=edit&id=<%= producto.getIdProducto() %>" class="btn btn-sm btn-warning">Editar</a>
                            <a href="../safezone/productos?action=delete&id=<%= producto.getIdProducto() %>" class="btn btn-sm btn-danger" onclick="return confirm('¿Estás seguro de que deseas eliminar este producto?');">Eliminar</a>
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

    <!-- Bootstrap Bundle with Popper -->
    <script src="<%=request.getContextPath()%>/static/js/bootstrap.bundle.min.js"></script>
</body>
</html>

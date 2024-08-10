<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="co.app.model.Usuario" %>
<%@ page import="co.app.model.Rol" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Usuarios</title>
    <!-- Bootstrap CSS -->
    <link href="<%=request.getContextPath()%>/static/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

    <div class="container mt-4">
        <h2>Lista de Usuarios</h2>
        <a href="../safezone/usuarios?action=new" class="btn btn-primary mb-2">Crear Nuevo Usuario</a>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre Completo</th>
                    <th>Identificación</th>
                    <th>Correo Electrónico</th>
                    <th>Rol</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Usuario> listaUsuarios = (List<Usuario>) request.getAttribute("listaUsuarios");
                    for(Usuario usuario : listaUsuarios) {
                %>
                    <tr>
                        <td><%= usuario.getIdUsuario() %></td>
                        <td><%= usuario.getNombreCompleto() %></td>
                        <td><%= usuario.getIdentificacion() %></td>
                        <td><%= usuario.getCorreoElectronico() %></td>
                        <td><%= usuario.getCodigoRol() %></td>
                        <td>
                            <a href="../safezone/usuarios?action=edit&id=<%= usuario.getIdUsuario() %>" class="btn btn-sm btn-warning">Editar</a>
                            <a href="../safezone/usuarios?action=delete&id=<%= usuario.getIdUsuario() %>" class="btn btn-sm btn-danger" onclick="return confirm('¿Estás seguro de que deseas eliminar este usuario?');">Eliminar</a>
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
    <script src="static/js/bootstrap.bundle.min.js"></script>
</body>
</html>


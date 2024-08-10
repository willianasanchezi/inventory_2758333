<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>  
<%@ page import="java.util.List" %>  
<%@ page import="co.app.model.Rol" %>  
  
<!DOCTYPE html>  
<html>  
<head>  
    <meta charset="UTF-8">  
    <title>Lista de Roles</title>  
    <link href="<%=request.getContextPath()%>/static/css/bootstrap.min.css" rel="stylesheet">  
</head>  
<body>  
    <div class="container mt-4">  
        <h2>Lista de Roles</h2>  
        <a href="../safezone/roles?action=new" class="btn btn-primary mb-2">Crear Nuevo Rol</a>  
        <table class="table table-bordered">  
            <thead>  
                <tr>  
                    <th>ID</th>  
                    <th>Código Rol</th>  
                    <th>Nombre Permiso</th>  
                    <th>Descripción</th>  
                    <th>Acciones</th>  
                </tr>  
            </thead>  
            <tbody>  
                <%  
                    List<Rol> listaRoles = (List<Rol>) request.getAttribute("listaRoles");  
                    for(Rol rol : listaRoles) {  
                %>  
                    <tr>  
                        <td><%= rol.getIdRol() %></td>  
                        <td><%= rol.getCodigoRol() %></td>  
                        <td><%= rol.getNombrePermiso() %></td>  
                        <td><%= rol.getDescripcion() %></td>  
                        <td>  
                            <a href="../safezone/roles?action=edit&id=<%= rol.getIdRol() %>" class="btn btn-sm btn-warning">Editar</a>  
                            <a href="../safezone/roles?action=delete&id=<%= rol.getIdRol() %>" class="btn btn-sm btn-danger" onclick="return confirm('¿Estás seguro de que deseas eliminar este rol?');">Eliminar</a>  
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

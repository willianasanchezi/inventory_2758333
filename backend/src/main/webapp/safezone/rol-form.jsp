<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="co.app.model.Rol" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><%=(request.getAttribute("rol") != null) ? "Editar Rol" : "Crear Rol"%></title>
    <link href="<%=request.getContextPath()%>/static/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-3">
        <h2><%=(request.getAttribute("rol") != null) ? "Editar Rol" : "Crear Rol"%></h2>
        <form action="<%=request.getContextPath()%>/safezone/roles?action=<%=(request.getAttribute("rol") != null) ? "update" : "insert"%>" method="post">
            <%
                Rol rol = null;
                if (request.getAttribute("rol") != null) {
                    rol = (Rol) request.getAttribute("rol");
            %>
                <input type="hidden" name="id" value="<%= rol.getIdRol() %>">
            <%
                }
            %>
            <div class="mb-3">
                <label for="codigoRol" class="form-label">Código Rol:</label>
                <input type="number" class="form-control" id="codigoRol" name="codigoRol" value="<%=(rol != null) ? rol.getCodigoRol() : ""%>" required>
            </div>
            <div class="mb-3">
                <label for="nombrePermiso" class="form-label">Nombre Permiso:</label>
                <input type="text" class="form-control" id="nombrePermiso" name="nombrePermiso" value="<%=(rol != null) ? rol.getNombrePermiso() : ""%>" required>
            </div>
            <div class="mb-3">
                <label for="descripcion" class="form-label">Descripción:</label>
                <input type="text" class="form-control" id="descripcion" name="descripcion" value="<%=(rol != null) ? rol.getDescripcion() : ""%>" required>
            </div>
            <div class="mb-3">
                <button type="submit" class="btn btn-primary"><%=(rol != null) ? "Actualizar" : "Crear"%></button>
                <a href="<%=request.getContextPath()%>/safezone/roles" class="btn btn-secondary">Cancelar</a>
            </div>  
        </form>  
    </div>  
    <script src="<%=request.getContextPath()%>/static/js/bootstrap.bundle.min.js"></script>  
</body>  
</html>  

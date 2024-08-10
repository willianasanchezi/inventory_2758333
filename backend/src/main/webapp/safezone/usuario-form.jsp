<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="co.app.model.Usuario" %>
<%@ page import="co.app.model.Rol" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><%=(request.getAttribute("usuario") != null) ? "Editar Usuario" : "Crear Usuario"%></title>
    <link href="<%=request.getContextPath()%>/static/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-3">
        <h2><%=(request.getAttribute("usuario") != null) ? "Editar Usuario" : "Crear Usuario"%></h2>
        <form action="../safezone/usuarios?action=<%=(request.getAttribute("usuario") != null) ? "update" : "insert"%>" method="post">
            <%
                if (request.getAttribute("usuario") != null) {
                    Usuario usuario = (Usuario) request.getAttribute("usuario");
            %>
                <input type="hidden" name="id" value="<%= usuario.getIdUsuario() %>">
            <%
                }
            %>
            <div class="mb-3">
                <label for="nombreCompleto" class="form-label">Nombre Completo:</label>
                <input type="text" class="form-control" id="nombreCompleto" name="nombreCompleto" value="<%=(request.getAttribute("usuario") != null) ? ((Usuario)request.getAttribute("usuario")).getNombreCompleto() : ""%>" required>
            </div>
            <div class="mb-3">
                <label for="identificacion" class="form-label">Identificación:</label>
                <input type="text" class="form-control" id="identificacion" name="identificacion" value="<%=(request.getAttribute("usuario") != null) ? ((Usuario)request.getAttribute("usuario")).getIdentificacion() : ""%>" required>
            </div>
            <div class="mb-3">
                <label for="correoElectronico" class="form-label">Correo Electrónico:</label>
                <input type="email" class="form-control" id="correoElectronico" name="correoElectronico" value="<%=(request.getAttribute("usuario") != null) ? ((Usuario)request.getAttribute("usuario")).getCorreoElectronico() : ""%>" required>
            </div>
            <div class="mb-3">
                <label for="contrasena" class="form-label">Contraseña:</label>
                <input type="password" class="form-control" id="contrasena" name="contrasena" value="<%=(request.getAttribute("usuario") != null) ? ((Usuario)request.getAttribute("usuario")).getContrasena() : ""%>" required>
            </div>
            <div class="mb-3">
                <label for="codigoRol" class="form-label">Rol:</label>
                <input type="number" class="form-control" id="codigoRol" name="codigoRol" value="<%=(request.getAttribute("usuario") != null) ? ((Usuario)request.getAttribute("usuario")).getCodigoRol() : ""%>" required>
            </div>
            <div class="mb-3">
                <button type="submit" class="btn btn-primary"><%=(request.getAttribute("usuario") != null) ? "Actualizar" : "Crear"%></button>
                <a href="../safezone/usuarios" class="btn btn-secondary">Cancelar</a>
            </div>
        </form>
    </div>
    <script src="<%=request.getContextPath()%>/static/js/bootstrap.bundle.min.js"></script>
</body>
</html>

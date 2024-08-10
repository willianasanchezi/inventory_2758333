<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="co.app.model.Mantenimiento" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><%=(request.getAttribute("mantenimiento") != null) ? "Editar Mantenimiento" : "Crear Mantenimiento"%></title>
    <link href="<%=request.getContextPath()%>/static/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-3">
        <h2><%=(request.getAttribute("mantenimiento") != null) ? "Editar Mantenimiento" : "Crear Mantenimiento"%></h2>
        <form action="<%=request.getContextPath()%>/safezone/mantenimientos?action=<%=(request.getAttribute("mantenimiento") != null) ? "update" : "insert"%>" method="post">
            <%
                Mantenimiento mantenimiento = null;
                if (request.getAttribute("mantenimiento") != null) {
                    mantenimiento = (Mantenimiento) request.getAttribute("mantenimiento");
            %>
                <input type="hidden" name="id" value="<%= mantenimiento.getIdMantenimiento() %>">
            <%
                }
            %>
            <div class="mb-3">
                <label for="idProducto" class="form-label">ID Producto:</label>
                <input type="number" class="form-control" id="idProducto" name="idProducto" value="<%= mantenimiento != null ? mantenimiento.getIdProducto() : "" %>" required>
            </div>
            <div class="mb-3">
                <label for="fechaMantenimiento" class="form-label">Fecha de Mantenimiento:</label>
                <input type="date" class="form-control" id="fechaMantenimiento" name="fechaMantenimiento" value="<%= mantenimiento != null ? mantenimiento.getFechaMantenimiento().toString() : "" %>" required>
            </div>
            <div class="mb-3">
                <label for="descripcion" class="form-label">Descripción:</label>
                <textarea class="form-control" id="descripcion" name="descripcion" required><%= mantenimiento != null ? mantenimiento.getDescripcion() : "" %></textarea>
            </div>
            <div class="mb-3">
                <label for="estado" class="form-label">Estado:</label>
                <input type="text" class="form-control" id="estado" name="estado" value="<%= mantenimiento != null ? mantenimiento.getEstado() : "" %>" required>
            </div>
            <div class="mb-3">
                <button type="submit" class="btn btn-primary"><%= mantenimiento != null ? "Actualizar" : "Crear" %></button>
                <a href="<%=request.getContextPath()%>/safezone/mantenimientos" class="btn btn-secondary">Cancelar</a>
            </div>
        </form>
    </div>
    <script src="<%=request.getContextPath()%>/static/js/bootstrap.bundle.min.js"></script>
</body>
</html>

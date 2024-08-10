<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="co.app.model.Prestamo" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><%=(request.getAttribute("prestamo") != null) ? "Editar Préstamo" : "Crear Préstamo"%></title>
    <link href="<%=request.getContextPath()%>/static/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-3">
        <h2><%=(request.getAttribute("prestamo") != null) ? "Editar Préstamo" : "Crear Préstamo"%></h2>
        <form action="../safezone/prestamos?action=<%=(request.getAttribute("prestamo") != null) ? "update" : "insert"%>" method="post">
            <%
                Prestamo prestamo = null;
                if (request.getAttribute("prestamo") != null) {
                    prestamo = (Prestamo) request.getAttribute("prestamo");
            %>
                <input type="hidden" name="id" value="<%= prestamo.getIdPrestamo() %>">
            <%
                }
            %>
            <div class="mb-3">
                <label for="idUsuario" class="form-label">ID Usuario:</label>
                <input type="number" class="form-control" id="idUsuario" name="idUsuario" value="<%= prestamo != null ? prestamo.getIdUsuario() : "" %>" required>
            </div>
            <div class="mb-3">
                <label for="idProducto" class="form-label">ID Producto:</label>
                <input type="number" class="form-control" id="idProducto" name="idProducto" value="<%= prestamo != null ? prestamo.getIdProducto() : "" %>" required>
            </div>
            <div class="mb-3">
                <label for="fechaPrestamo" class="form-label">Fecha de Préstamo:</label>
                <input type="date" class="form-control" id="fechaPrestamo" name="fechaPrestamo" value="<%= prestamo != null ? prestamo.getFechaPrestamo().toString() : "" %>" required>
            </div>
            <div class="mb-3">
                <label for="fechaDevolucion" class="form-label">Fecha de Devolución:</label>
                <input type="date" class="form-control" id="fechaDevolucion" name="fechaDevolucion" value="<%= prestamo != null ? prestamo.getFechaDevolucion().toString() : "" %>" required>
            </div>
            <div class="mb-3">
                <label for="estado" class="form-label">Estado:</label>
                <input type="text" class="form-control" id="estado" name="estado" value="<%= prestamo != null ? prestamo.getEstado() : "" %>" required>
            </div>
            <div class="mb-3">
                <button type="submit" class="btn btn-primary"><%= prestamo != null ? "Actualizar" : "Crear" %></button>
                <a href="../safezone/prestamos" class="btn btn-secondary">Cancelar</a>
            </div>
        </form>
    </div>
    <script src="<%=request.getContextPath()%>/static/js/bootstrap.bundle.min.js"></script>
</body>
</html>

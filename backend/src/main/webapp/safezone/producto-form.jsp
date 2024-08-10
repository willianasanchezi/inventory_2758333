<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="co.app.model.Producto" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><%=(request.getAttribute("producto") != null) ? "Editar Producto" : "Crear Producto"%></title>
    <link href="<%=request.getContextPath()%>/static/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-3">
        <h2><%=(request.getAttribute("producto") != null) ? "Editar Producto" : "Crear Producto"%></h2>
        <form action="../safezone/productos?action=<%=(request.getAttribute("producto") != null) ? "update" : "insert"%>" method="post">
            <%
                Producto producto = (Producto) request.getAttribute("producto");
            %>
            <% if (producto != null) { %>
                <input type="hidden" name="id" value="<%= producto.getIdProducto() %>">
            <% } %>
            <div class="mb-3">
                <label for="codigo" class="form-label">Código:</label>
                <input type="text" class="form-control" id="codigo" name="codigo" value="<%=(producto != null) ? producto.getCodigo() : ""%>" required>
            </div>
            <div class="mb-3">
                <label for="nombreProducto" class="form-label">Nombre del Producto:</label>
                <input type="text" class="form-control" id="nombreProducto" name="nombreProducto" value="<%=(producto != null) ? producto.getNombreProducto() : ""%>" required>
            </div>
            <div class="mb-3">
                <label for="descripcion" class="form-label">Descripción:</label>
                <textarea class="form-control" id="descripcion" name="descripcion" required><%=(producto != null) ? producto.getDescripcion() : ""%></textarea>
            </div>
            <div class="mb-3">
                <label for="marca" class="form-label">Marca:</label>
                <input type="text" class="form-control" id="marca" name="marca" value="<%=(producto != null) ? producto.getMarca() : ""%>" required>
            </div>
            <div class="mb-3">
                <label for="modelo" class="form-label">Modelo:</label>
                <input type="text" class="form-control" id="modelo" name="modelo" value="<%=(producto != null) ? producto.getModelo() : ""%>" required>
            </div>
            <div class="mb-3">
                <label for="cantidadMemoria" class="form-label">Cantidad de Memoria:</label>
                <input type="text" class="form-control" id="cantidadMemoria" name="cantidadMemoria" value="<%=(producto != null) ? producto.getCantidadMemoria() : ""%>" required>
            </div>
            <div class="mb-3">
                <label for="capacidadDisco" class="form-label">Capacidad de Disco:</label>
                <input type="text" class="form-control" id="capacidadDisco" name="capacidadDisco" value="<%=(producto != null) ? producto.getCapacidadDisco() : ""%>" required>
            </div>
            <div class="mb-3">
                <label for="estado" class="form-label">Estado:</label>
                <input type="text" class="form-control" id="estado" name="estado" value="<%=(producto != null) ? producto.getEstado() : ""%>" required>
            </div>
            <div class="mb-3">
                <label for="cantidad" class="form-label">Cantidad:</label>
                <input type="number" class="form-control" id="cantidad" name="cantidad" value="<%=(producto != null) ? Integer.toString(producto.getCantidad()) : ""%>" required>
            </div>
            <div class="mb-3">
                <label for="precioUnitario" class="form-label">Precio Unitario:</label>
                <input type="text" class="form-control" id="precioUnitario" name="precioUnitario" value="<%=(producto != null && producto.getPrecioUnitario() != null) ? producto.getPrecioUnitario().toString() : ""%>" required>
            </div>
            <div class="mb-3">
                <button type="submit" class="btn btn-primary"><%=(producto != null) ? "Actualizar" : "Crear"%></button>
                <a href="../safezone/productos" class="btn btn-secondary">Cancelar</a>
            </div>
        </form>
    </div>
    <script src="<%=request.getContextPath()%>/static/js/bootstrap.bundle.min.js"></script>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ page import="co.app.utils.UserUtils" %>  
<%@ page import="co.app.utils.UserUtils.UserInfo" %>  
  
<!DOCTYPE html>  
<html>  
<head>  
    <title>Dashboard</title>  
    <!-- Bootstrap CSS -->  
    <link href="<%=request.getContextPath()%>/static/css/bootstrap.min.css" rel="stylesheet">  
    <!-- Agrega aquí cualquier CSS o metadatos que necesites -->  
</head>  
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light"> <!-- Bootstrap navigation bar -->  
        <div class="container-fluid">  
            <a class="navbar-brand" href="#">Dashboard</a>  
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">  
                <span class="navbar-toggler-icon"></span>  
            </button>  
            <div class="collapse navbar-collapse" id="navbarNav">  
                <ul class="navbar-nav">  
                    <li class="nav-item">  
                        <a class="nav-link active" aria-current="page" href="<%=request.getContextPath()%>/safezone/usuarios?action=list">Usuarios</a>
                    </li>  
                    <li class="nav-item">  
                        <a class="nav-link" href="<%=request.getContextPath()%>/safezone/roles?action=list">Roles</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<%=request.getContextPath()%>/safezone/productos?action=list">Productos</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<%=request.getContextPath()%>/safezone/mantenimientos?action=list">Mantenimientos</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<%=request.getContextPath()%>/safezone/prestamos?action=list">Prestamos</a>
                    </li>
                </ul>  
            </div>  
        </div>  
    </nav>  
    <!-- Agrega aquí el contenido adicional que necesites -->  
  
    <form action="logout" method="get" class="mt-3">  
        <input type="submit" value="Cerrar Sesión" class="btn btn-primary">  
    </form>  
  
    <div class="user-info mt-3">  
        <%  
            UserInfo userInfo = UserUtils.getUserInfo(request);  
            if(userInfo != null) {  
                out.println("<p>Username: " + userInfo.getUsername() + "</p>");  
                out.println("<p>Role: " + userInfo.getRole() + "</p>");  
            } else {  
                out.println("<p>User not logged in or session not available.</p>");  
            }  
        %>  
    </div>  
  
    <!-- Bootstrap Bundle with Popper -->  
    <script src="<%=request.getContextPath()%>/static/js/bootstrap.bundle.min.js"></script>  
</body>  
</html>  

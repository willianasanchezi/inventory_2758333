<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<!DOCTYPE html>  
<html>  
<head>  
    <title>Login</title>  
    <!-- Bootstrap CSS -->  
    <link href="static/css/bootstrap.min.css" rel="stylesheet">  
    <!-- Agrega aquí cualquier otro CSS o metadatos que necesites -->  
</head>  
<body>  
    <div class="container mt-5">  
        <div class="row">  
            <div class="col-md-6 offset-md-3">  
                <div class="card">  
                    <div class="card-body">  
                        <h2 class="card-title text-center">Login</h2>  
                        <% if (request.getAttribute("errorMessage") != null) { %>  
                            <div class="alert alert-danger" role="alert">  
                                <%= request.getAttribute("errorMessage") %>  
                            </div>  
                        <% } %>  
                        <form action="login" method="post">  
                            <div class="form-group">  
                                <label for="username">Usuario:</label>  
                                <input type="text" class="form-control" id="username" name="username" required>  
                            </div>  
                            <div class="form-group">  
                                <label for="password">Contraseña:</label>  
                                <input type="password" class="form-control" id="password" name="password" required>  
                            </div>  
                            <button type="submit" class="btn btn-primary btn-block">Iniciar Sesión</button>  
                        </form>  
                    </div>  
                </div>  
            </div>  
        </div>  
    </div>  
  
    <!-- Optional JavaScript; choose one of the two! -->  
  
    <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->  
     <script src="static/js/bootstrap.bundle.min.js"></script>  
  
    <!-- Option 2: jQuery, Popper.js, and Bootstrap JS  
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>  
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.7.11/dist/umd/popper.min.js"></script>  
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>  
    -->  
</body>  
</html>  

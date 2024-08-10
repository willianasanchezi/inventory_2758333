<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>BCrypt Test Page</title>
</head>
<body>
    <h2>BCrypt Hashing and Verification Test</h2>
    <form action="bcrypt-test" method="post">
        Password to test: <input type="text" name="password" />
        <input type="submit" value="Test" />
    </form>
    <%
        if (request.getAttribute("hashed") != null) {
            out.println("<p>Hashed Password: " + request.getAttribute("hashed") + "</p>");
            out.println("<p>Password Verified: " + request.getAttribute("passwordVerified") + "</p>");
        }
    %>
</body>
</html>

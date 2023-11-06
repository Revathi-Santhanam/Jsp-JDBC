<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<body>
<h2>Register</h2>
<form action="register" method="POST">
   <p>Username: <input type="text" name="username"/></p>
   <p>Password: <input type="password" name="password"/></p>
   <p>ConfirmPassword: <input type="password" name="c_password"/></p>

   <%
        if(request.getAttribute("error") != null){
        out.print("<p>PASSWORD MISMATCH !!!</p>");
        }
      %>

   <input type="submit" value="Register"/>
</form>
</body>
</html>

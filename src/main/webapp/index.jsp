<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<body>
<h2>Login</h2>
<form action="login" method="POST">
   <p>Username: <input type="text" name="username"/></p>
   <p>Password: <input type="password" name="password"/></p>
   <%
     if(request.getAttribute("error") != null){
     out.print("<p>INVALID !!!</p>");
     }
   %>
   <input type="submit" value="Login"/>
   <p class="register">Not a member?  <a href="register.jsp">Register here!</a></p>
</form>
</body>
</html>

<%-- 
    Document   : SignIn
    Created on : Sep 30, 2022, 5:53:46 PM
    Author     : phanv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/bootstrap.min.css"/>
        <link rel="stylesheet" href="CSS/styleLogIn.css"/>
        <title>Sign In</title>
    </head>
    <body>
  <% String ms1 = (String) request.getAttribute("ms1");
    String ms2 = (String) request.getAttribute("ms2");
    String ms3 = (String) request.getAttribute("ms3");%>
    
  <div class="login-box">
    <h2>Login</h2>
    <form action="login" method="post">
      <div class="user-box">
        <input type="text" name="username" required="">
        <label>Username <span style="color: red;">*</span></label>
      </div>
        <% if (request.getAttribute("ms1")!= null) {%>
        <p style="color: red;padding: 0;margin: 0;">${ms1}</p>
        <% }%>
      <div class="user-box">
        <input type="password" name="password" required="">
        <label>Password <span style="color: red;">*</span></label>
      </div>
      <% if (request.getAttribute("ms2")!= null) {%>
        <p style="color: red;padding: 0;margin: 0;">${ms2}</p>
        <% }%>
        <a href="" onclick='this.parentNode.submit(); return false;'>
        <span></span>
        <span></span>
        <span></span>
        <span></span>
        Log In
      </a>
      <a href="SignUp.jsp" style="margin-left: 60px;">
        <span></span>
        <span></span>
        <span></span>
        <span></span>
        Sign Up
      </a>
        <% if (request.getAttribute("ms3")!= null) {%>
        <p style="color: red;padding: 0;margin: 10px 0;">${ms3}</p>
        <% }%>
    </form>
  </div>

    </body>
</html>

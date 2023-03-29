<%-- 
    Document   : SignUp
    Created on : Sep 30, 2022, 5:53:56 PM
    Author     : phanv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.*"%>
<!DOCTYPE html>
<html>
    <% String ms = (String) request.getAttribute("ms");%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/bootstrap.min.css"/>
        <link rel="stylesheet" href="CSS/styleSignUp.css"/>
        <title>Sign Up</title>
    </head>
    <body>
        <% String ms1 = (String) request.getAttribute("ms");%>
  <div class="login-box">
    <h2>Sign Up</h2>
    <% if (request.getAttribute("ms")!= null) {%>
        <p style="color: red;padding: 0;margin: 0;">${ms1}</p>
        <% }%>
        <form action="signup" method="post">
      <div class="user-box">
          <input type="text" name="username" required="">
        <label>Username <span style="color: red;">*</span></label>
      </div>
      <div class="user-box">
        <input type="password" name="password" required="">
        <label>Password <span style="color: red;">*</span></label>
      </div>
      <div class="user-box">
        <input type="text" name="name" required="">
        <label>Name <span style="color: red;">*</span></label>
      </div>
      <div class="user-box">
        <input type="text" name="RollNo" required="">
        <label>Rollno <span style="color: red;">*</span></label>
      </div>
      <div class="user-box">
        <input type="text" name="classN" required="">
        <label>Class Name  <span style="color: red;">*</span></label>
      </div>
      <div class="user-box">
        <input type="text" name="subject" required="">
        <label>Major  <span style="color: red;">*</span></label>
      </div>
      
      <a href="" onclick='this.parentNode.submit(); return false;'>
        <span></span>
        <span></span>
        <span></span>
        <span></span>
        Sign Up
      </a>
      <a href="SignIn.jsp" style="margin-left: 60px;">
        <span></span>
        <span></span>
        <span></span>
        <span></span>
        Log In
      </a>
    </form>
  </div>
                

    </body>
</html>

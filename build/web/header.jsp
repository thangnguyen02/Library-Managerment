<%-- 
    Document   : header
    Created on : Oct 27, 2022, 1:17:39 AM
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.*" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%  Account user = (Account)request.getSession().getAttribute("user");%>
        <div class="header">
        <div id="logo">
            <img src="img/logo1.png" alt="LOGO">
        </div>
        <div style="width: 40vw;"></div>
        <div class="inf"> 
            <a href="/Assognment_PRJ/user?username=<%= user.getUserN() %>" style="text-decoration: none; color: red;display: inline-block; font-size:20px;"><%= user.getName()%></a>
            [<a href="/Assognment_PRJ/logout" style="text-decoration: none; color: rgb(69, 115, 212);display: inline-block;font-size:10px;">LOGOUT</a>]
        </div>
         </div><!-- comment -->
         
    </body>
</html>

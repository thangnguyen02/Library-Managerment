<%-- 
    Document   : updaeBook
    Created on : Oct 18, 2022, 1:21:41 PM
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%  String id =(String)request.getAttribute("id");
            String ms =(String)request.getAttribute("ms");%>
        <form action="update" method="post" class="form_insert1">
            <p><span>*</span>If you do not enter anything in the information fields of the book, old data will not be changed.<span>*</span></p>
            UPDATE:<br>
            <table>
                <tr>
                    <% if (request.getAttribute("id") != null ){%>
                    <td>ID: </td>
                    <td><input type="text" placeholder="" name="Id" value="${id}" readonly=""/></td>
                    <% } else { %>
                    <td>ID: </td>
                    <td><input type="text" placeholder="Id" name="Id"></td>
                    <% }%>
                </tr>
                <tr>
                    <td>Name: </td>
                    <td><input type="text" placeholder="Name" name="Name"/></td>
                </tr>
                <tr>
                    <td>Category: </td>
                    <td><input type="text" placeholder="Category" name="Category"/> </td>
                </tr>
                <tr>
                    <td>Specialized: </td>
                    <td><input type="text" placeholder="Specialized" name="Specialized"/> </td>
                </tr>
                <tr>
                    <td>Author: </td>
                    <td><input type="text" placeholder="Author" name="Author"/></td>
                </tr>
                <tr>
                    <td>PublishingYear: </td>
                    <td><input type="text" placeholder="PublishingYear" name="PublishingYear"/></td>
                </tr>
               
            </table> 
                <input type="submit" value="UPDATE" class="last"/>
            <% if (request.getAttribute("ms") != null ){%>
            <h4 style="color: red"><%= ms %></h4>
            <% } %>
        </form>
    </body>
</html>

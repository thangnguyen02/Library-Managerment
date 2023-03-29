<%-- 
    Document   : SearchList
    Created on : Oct 29, 2022, 2:41:08 AM
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
          <%  List<Book> ls = (List<Book>)request.getAttribute("listBooks");
        %>
       
        
        <% if (request.getAttribute("listBooks") == null || ls.isEmpty()) {%>
                <p>There is have no Books</p>
                <% } else { %> 
                <table class="table_css">
                    <tr class="fir">
                        <td>Name</td>
                        <td>Category</td>
                        <td>Specialized</td>
                        <td>Author</td>
                        <td>PublishingYear</td>
                    </tr>
                    <%
                for (Book b : ls) {%> 
                    <tr style="margin: 2px;">
                        <td><%= b.getName() %></td>
                        <td><%= b.getCategory() %></td>
                        <td><%= b.getSpecialized() %></td>
                        <td><%= b.getAuthor() %></td>
                        <% if (b.getPublishingYear() == 0) {%>
                        <td></td>
                        <%} else { %>
                        <td><%= b.getPublishingYear()  %></td>
                        <% } %>
                    </tr>
                    <% } %>
                </table>
                <% }%> 
                <nav aria-label="Page navigation example"  style="margin: 20px 0px;">
            <ul class="pagination"  style="margin-left: 54%;transform: translateX(-50%);">
              <li class="page-item"><a class="page-link" href="/Assognment_PRJ/search?page=1">1</a></li>
              <li class="page-item"><a class="page-link" href="/Assognment_PRJ/search?page=2">2</a></li>
              <li class="page-item"><a class="page-link" href="/Assognment_PRJ/search?page=3">3</a></li>
              <li class="page-item"><a class="page-link" href="/Assognment_PRJ/search?page=4">4</a></li>
              <li class="page-item"><a class="page-link" href="/Assognment_PRJ/search?page=5">5</a></li>
              <li class="page-item"><a class="page-link" href="/Assognment_PRJ/search?page=6">6</a></li>
              <li class="page-item"><a class="page-link" href="/Assognment_PRJ/search?page=7">7</a></li>
              <li class="page-item"><a class="page-link" href="/Assognment_PRJ/search?page=8">8</a></li>
              <li class="page-item"><a class="page-link" href="/Assognment_PRJ/search?page=9">9</a></li>
              <li class="page-item"><a class="page-link" href="/Assognment_PRJ/search?page=10">10</a></li>
            </ul>
          </nav>
    </body>
</html>

<%-- 
    Document   : SeachList
    Created on : Oct 29, 2022, 2:33:24 AM
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.*" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="themify-icons/themify-icons.css"/>
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
                <td>Name
                    <a href="/Assognment_PRJ/sort?collname=Name&type=desc&page=1" style="text-decoration: none;"><span class="ti-arrow-down"></span></a>
                    <a href="/Assognment_PRJ/sort?collname=Name&type=asc&page=1" style="text-decoration: none;"><span class="ti-arrow-up"></span></a>
                </td>
                <td>Category
                    <a href="/Assognment_PRJ/sort?collname=Category&type=desc&page=1" style="text-decoration: none;"><span class="ti-arrow-down"></span></a>
                    <a href="/Assognment_PRJ/sort?collname=Category&type=asc&page=1" style="text-decoration: none;"><span class="ti-arrow-up"></span></a>
                </td>
                <td>Specialized</td>
                <td>Author
                    <a href="/Assognment_PRJ/sort?collname=author&type=desc&page=1" style="text-decoration: none;"><span class="ti-arrow-down"></span></a>
                    <a href="/Assognment_PRJ/sort?collname=author&type=asc&page=1" style="text-decoration: none;"><span class="ti-arrow-up"></span></a>
                </td>
                <td>PublishYear
                    <a href="/Assognment_PRJ/sort?collname=PublishingYear&type=desc&page=1" style="text-decoration: none;"><span class="ti-arrow-down"></span></a>
                    <a href="/Assognment_PRJ/sort?collname=PublishingYear&type=asc&page=1" style="text-decoration: none;"><span class="ti-arrow-up"></span></a>
                </td>
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
        <% if (request.getAttribute("isSort") != null) {
         Integer isS = (Integer) request.getAttribute("isSort");
        if (isS.intValue() == 1) {%>
        <nav aria-label="Page navigation example" style="margin: 20px 0px;">
            <ul class="pagination"  style="margin-left: 54%;transform: translateX(-50%);">
                <li class="page-item"><a class="page-link" href="/Assognment_PRJ/sort?collname=&type=&page=1">1</a></li>
                <li class="page-item"><a class="page-link" href="/Assognment_PRJ/sort?collname=&type=&page=2">2</a></li>
                <li class="page-item"><a class="page-link" href="/Assognment_PRJ/sort?collname=&type=&page=3">3</a></li>
                <li class="page-item"><a class="page-link" href="/Assognment_PRJ/sort?collname=&type=&page=4">4</a></li>
                <li class="page-item"><a class="page-link" href="/Assognment_PRJ/sort?collname=&type=&page=5">5</a></li>
                <li class="page-item"><a class="page-link" href="/Assognment_PRJ/sort?collname=&type=&page=6">6</a></li>
                <li class="page-item"><a class="page-link" href="/Assognment_PRJ/sort?collname=&type=&page=7">7</a></li>
                <li class="page-item"><a class="page-link" href="/Assognment_PRJ/sort?collname=&type=&page=8">8</a></li>
                <li class="page-item"><a class="page-link" href="/Assognment_PRJ/sort?collname=&type=&page=9">9</a></li>
                <li class="page-item"><a class="page-link" href="/Assognment_PRJ/sort?collname=&type=&page=10">10</a></li>
            </ul>
        </nav>
        <% }%>
        <% } else {%>
        <nav aria-label="Page navigation example" style="margin: 20px 0px;">
            <ul class="pagination"  style="margin-left: 54%;transform: translateX(-50%);">
                <li class="page-item"><a class="page-link" href="/Assognment_PRJ/listOfBooks?page=1">1</a></li>
                <li class="page-item"><a class="page-link" href="/Assognment_PRJ/listOfBooks?page=2">2</a></li>
                <li class="page-item"><a class="page-link" href="/Assognment_PRJ/listOfBooks?page=3">3</a></li>
                <li class="page-item"><a class="page-link" href="/Assognment_PRJ/listOfBooks?page=4">4</a></li>
                <li class="page-item"><a class="page-link" href="/Assognment_PRJ/listOfBooks?page=5">5</a></li>
                <li class="page-item"><a class="page-link" href="/Assognment_PRJ/listOfBooks?page=6">6</a></li>
                <li class="page-item"><a class="page-link" href="/Assognment_PRJ/listOfBooks?page=7">7</a></li>
                <li class="page-item"><a class="page-link" href="/Assognment_PRJ/listOfBooks?page=8">8</a></li>
                <li class="page-item"><a class="page-link" href="/Assognment_PRJ/listOfBooks?page=9">9</a></li>
                <li class="page-item"><a class="page-link" href="/Assognment_PRJ/listOfBooks?page=10">10</a></li>
            </ul>
        </nav>
        <% }%>
    </body>
</html>

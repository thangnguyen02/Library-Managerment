<%-- 
    Document   : home_user
    Created on : Sep 30, 2022, 6:08:58 PM
    Author     : phanv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.*" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/bootstrap.min.css"/>
        <link rel="stylesheet" href="CSS/stylehome_user.css"/>
        <title>Home</title>
    </head>
    <body>
        <%  List<Book> ls = (List<Book>)request.getAttribute("listBooks");
            Integer check = (Integer) request.getSession().getAttribute("check");
            List<History> ls2 = (List<History>)request.getAttribute("listHistorys");
            List<Fines> lis4 = (List<Fines>) request.getAttribute("listFines");
        %>



        <jsp:include page="header.jsp"/>

        <div class="main_content">
            <div class="menu">
                <ul>
                    <li><a href="/Assognment_PRJ/home">Home</a></li>
                    <li><a href="/Assognment_PRJ/listOfBooks?page=1">List of Books</a></li>
                    <li><a href="/Assognment_PRJ/myLibrary">My library</a></li>
                    <li><a href="/Assognment_PRJ/borrowB?page=1">Borrow books online</a></li>
                </ul>
            </div>   
            <div class="content" style="padding: 0px 2rem;">
                <% if (check.intValue() == 0) {%> 
                <jsp:include page="homePage.jsp"/>
                <%} else if (check.intValue() == 1) {%>
                <form action="search" method="post" class="form_search">
                    SEARCH:<br/> <br/>
                    <input type="text" placeholder="Name" name="name"/>
                    <input type="text" placeholder="Category" name="Category"/>
                    <input type="text" placeholder="Specialized" name="specialized"/>
                    <input type="text" placeholder="Author" name="author"/>
                    <input type="text" placeholder="PublishingYear" name="PublishingYear"/>
                    <input type="submit" value="SEARCH"/>
                </form>
                <br/>
                <h3 style="color: red">List Books</h3>
                <% Integer isS = (Integer) request.getAttribute("isSearch");
                    if (isS.intValue() == 0) {
                %>               
                <jsp:include page="SearchList.jsp"/>
                <% } else {%>               
                <jsp:include page="ListOfBook.jsp"/>          
                <% }%>
                <% } else if (check.intValue() == 2) {%>
                <form action="searchLib" class="form_search">
                    SEARCH:<br/> <br/>
                    <input type="text" placeholder="Name" name="name"/>
                    <input type="date" name="dateBegin" value="1900-01-01"/>
                    <input type="date" name="dateEnd" value="2099-01-01"/>
                    <input type="text" placeholder="Status" name="Status"/>
                    <input type="text" placeholder="Note" name="note"/>
                    <input type="submit" value="search"/>
                </form>
                <br/>
                <h3 style="color: red">List History</h3>
                <% if (request.getAttribute("listHistorys") == null || ls2.isEmpty()) {%>
                <p>There is have no Library</p>
                <% } else { %> 
                <table class="table_css">
                    <tr class="fir">
                        <td>ID</td>
                        <td>Name</td>
                        <td>Date</td>
                        <td>Event</td>
                        <td>Status</td>
                    </tr>
                    <% for (History b : ls2) {%> 
                    <tr>
                        <td><%= b.getId() %></td>
                        <td><%= b.getName() %></td>
                        <td><%= b.getDate() %></td>
                        <td><%= b.getStatus() %></td>
                        <td><%= b.getNote() %></td>                     
                    </tr>
                    <% } %>
                </table>
                <br/>
                <h3 style="color: red">List Fines</h3>
                <% }%>
                <% if (request.getAttribute("listFines") == null || lis4.isEmpty()) {%>
                <p>There is have no Fines</p>
                <% } else { %> 
                <table class="table_css">
                    <tr>
                         <td>ID Book</td>
                        <td>Number of days penalized</td>
                        <td>Money</td>
                        <td>Status</td>
                        <td>Date</td>
                    </tr>
                    <% for (Fines b : lis4) {%> 
                    <tr>
                        <td><%=  b.getId()%></td>
                        <td><%= b.getDatePhat() %></td>
                        <td><%= b.getMoney() %>.000VND</td> 
                        <td><%= b.getStauts() %></td>
                        <% if (b.getDate() != null) {%>
                        <td><%= b.getDate() %></td> 
                        <% } else {%>
                        <td></td> 
                        <% }%>
                    </tr>
                    <% } %>
                </table>
                <% }%>

                <% } else if (check.intValue() == 3) {%>
                <form action="search" method="post" class="form_search">
                    SEARCH:<br/> <br/>
                    <input type="text" placeholder="Name" name="name"/>
                    <input type="text" placeholder="Category" name="Category"/>
                    <input type="text" placeholder="Specialized" name="specialized"/>
                    <input type="text" placeholder="Author" name="author"/>
                    <input type="text" placeholder="PublishingYear" name="PublishingYear"/>
                    <input type="submit" value="SEARCH"/>
                </form>
                <br/>
                <h3 style="color: red">List Books:</h3>
                <% Integer isS = (Integer) request.getAttribute("isSearch");
                    if (isS.intValue() == 0) {
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
                        <td><a href="/Assognment_PRJ/borrow?id=<%= b.getId()%>">Borrow</a></td>
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
                
                
                <% } else {%>
                <% if (request.getAttribute("msi") != null) {
                String ms = (String) request.getAttribute("msi");%>
               <h4 style="color: red"><%= ms %></h4>
                <% }%>
                <% if (request.getAttribute("listBooks") == null || ls.isEmpty()) {%>
                <div style="height: 500px;">
                <p>There is have no Books</p>
                </div>
                <% } else { %> 
                <table class="table_css">
                    <tr class="fir">
                        <td>ID</td>
                        <td>Name</td>
                        <td>Category</td>
                        <td>Specialized</td>
                        <td>Author</td>
                        <td>PublishingYear</td>
                    </tr>
                    <%
                for (Book b : ls) {%> 
                    <tr>
                        <td><%= b.getId() %></td>
                        <td><%= b.getName() %></td>
                        <td><%= b.getCategory() %></td>
                        <td><%= b.getSpecialized() %></td>
                        <td><%= b.getAuthor() %></td>
                        <% if (b.getPublishingYear() == 0) {%>
                        <td></td>
                        <%} else { %>
                        <td><%= b.getPublishingYear()  %></td>
                        <% } %>
                        <td><a href="/Assognment_PRJ/borrow?id=<%= b.getId()%>">Borrow</a></td>
                    </tr>
                    <% } %>
                </table>
                <nav aria-label="Page navigation example"  style="margin: 20px 0px;">
                    <ul class="pagination"  style="margin-left: 54%;transform: translateX(-50%);">
                        <li class="page-item"><a class="page-link" href="/Assognment_PRJ/borrowB?page=1">1</a></li>
                        <li class="page-item"><a class="page-link" href="/Assognment_PRJ/borrowB?page=2">2</a></li>
                        <li class="page-item"><a class="page-link" href="/Assognment_PRJ/borrowB?page=3">3</a></li>
                        <li class="page-item"><a class="page-link" href="/Assognment_PRJ/borrowB?page=4">4</a></li>
                        <li class="page-item"><a class="page-link" href="/Assognment_PRJ/borrowB?page=5">5</a></li>
                        <li class="page-item"><a class="page-link" href="/Assognment_PRJ/borrowB?page=6">6</a></li>
                        <li class="page-item"><a class="page-link" href="/Assognment_PRJ/borrowB?page=7">7</a></li>
                        <li class="page-item"><a class="page-link" href="/Assognment_PRJ/borrowB?page=8">8</a></li>
                        <li class="page-item"><a class="page-link" href="/Assognment_PRJ/borrowB?page=9">9</a></li>
                        <li class="page-item"><a class="page-link" href="/Assognment_PRJ/borrowB?page=10">10</a></li>
                    </ul>
                </nav>

                <% }%>
                <% }%>

                <% } else if (check.intValue() == 9) { %>
                <div class="right">
                    <div id="img">
                        <img src="img/imguser.jpg" alt="anhdaidien">
                        <button id="logout"><a style="text-decoration:none ; color: black;" href="#">UPLOAD</a></button>
                    </div>
                    <div id="infor">
                        <h4><span style="color:black;">Access :</span>Student</h4>
                        <h4><span style="color:black;">UserName: </span>${user.getUserN()}</h4>
                        <h4><span style="color:black;">Name: </span>${user.getName()}</h4>
                        <h4><span style="color:black;">RollNo: </span>${user.getRollno()}</h4>
                        <h4><span style="color:black;">Class: </span>${user.getClassName()}</h4>
                        <h4><span style="color:black;">Major: </span>${user.getSubject()}</h4>
                        <button id="logout" class="rightB"><a style="text-decoration:none ; color: black;" href="#">Change information</a></button>
                    </div>

                </div>
                <% }%>
            </div>
        </div>

        <jsp:include page="footer.jsp"/>

    </body>
</html>

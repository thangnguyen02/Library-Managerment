<%-- 
    Document   : hom_management
    Created on : Oct 17, 2022, 5:29:14 PM
    Author     : acer
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
        <title>MANAGER</title>
    </head>
    <body>
        <%  List<Book> ls = (List<Book>)request.getAttribute("listBooks");
            Integer check = (Integer) request.getSession().getAttribute("check");
            List<Account> ls2 = (List<Account>)request.getAttribute("listUser");
            List<Employee> ls4 = (List<Employee>)request.getAttribute("listE");
            List<Fines> lis4 = (List<Fines>) request.getAttribute("listFines");
            List<History> lis5 = (List<History>)request.getAttribute("listGiveback");
            String mes = (String) request.getAttribute("mess");
            List<History> ls0 = (List<History>)request.getAttribute("historyAll");
        %>



        <jsp:include page="header.jsp"/>

        <div class="main_content">
            <div class="menu">
                <ul>
                    <li><a href="/Assognment_PRJ/home">Home</a></li>
                    <li><a href="/Assognment_PRJ/list?page=1">List of Books</a></li>
                    <li><a href="/Assognment_PRJ/insert">Insert Books</a></li>
                    <li><a href="/Assognment_PRJ/listUser">List Account</a></li>                  
                    <li><a href="/Assognment_PRJ/listFines">List Fines</a></li>                                      
                    <li><a href="/Assognment_PRJ/accept">Show Request</a></li>
                    <li><a href="/Assognment_PRJ/listEmployee">List Employee</a></li>
                    <li><a href="/Assognment_PRJ/giveback">Give Back</a></li>
                </ul>
            </div>          


            <div class="content" style="padding: 0px 2rem;">

                <% if (check.intValue() == 0) {%>
                <form action="SearchHistory" class="form_search">
                    SEARCH:<br/> <br/>
                    <input type="text" placeholder="UserName" name="UserName"/> 
                    <input type="text" placeholder="ID" name="ID"/> 
                    <input type="date" placeholder="Date" name="date"/> 
                    <input type="text" placeholder="Event" name="Event"/> 
                    <input type="text" placeholder="Status" name="Status"/> 
                    <input type="submit" value="SEARCH"/>
                </form>
                <br/>
                <% if (request.getAttribute("historyAll") == null) {%>
                <div style="height: 500px"><p>There is have no History</p></div>
                <% } else { %> 
                <table class="table_css">
                    <tr class="fir">
                        <td>UserName </td>
                        <td>ID Books</td>
                        <td>Date</td>
                        <td>Event</td>
                        <td>Status</td>
                    </tr>
                    <% for (History b : ls0) {%> 
                    <tr>
                        <td><%= b.getId() %></td>
                        <td><%= b.getName() %></td>
                        <td><%= b.getDate() %></td>
                        <td><%= b.getStatus() %></td>
                        <td><%= b.getNote() %></td>

                    </tr>
                    <% } %>
                </table>
                <% } %>
                <%} else if (check.intValue() == 1) {%>
                <form action="search" method="post" class="form_search">
                    SEARCH:<br/><br/>               
                    <input type="text" placeholder="id" name="id"/>
                    <input type="text" placeholder="name" name="name"/>
                    <input type="text" placeholder="Category" name="Category"/> 
                    <input type="text" placeholder="specialized" name="specialized"/> 
                    <input type="text" placeholder="author" name="author"/>
                    <input type="text" placeholder="PublishingYear" name="PublishingYear"/>
                    <input class="button" type="submit" value="SEARCH" style="margin: 10px 0;"/>
                </form>
                <br/>
                <% Integer isS = (Integer) request.getAttribute("isSearch");
                    if (isS.intValue() == 0) { %>
                <% if (request.getAttribute("listBooks") == null) {%>
                <div style="height: 500px"><p>There is have no Books</p></div>
                <% } else { %> 
                <table class="table_css">
                    <tr class="fir">
                        <td>ID </td>
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
                        <td><a href="/Assognment_PRJ/update?id=<%= b.getId() %>" >UPDATE</a></td>
                        <td><a href="/Assognment_PRJ/delete?id=<%= b.getId() %>">DELETE</a></td>
                    </tr>
                    <% } %>
                </table>
               
                <% } %>
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
                <% if (request.getAttribute("listBooks") == null) {%>
                <div style="height: 500px">
                <p>There is have no Books</p>
                </div>
                <% } else { %> 
                <table class="table_css">
                    <tr class="fir">
                        <td>ID </td>
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
                        <td><a href="/Assognment_PRJ/update?id=<%= b.getId() %>" >UPDATE</a></td>
                        <td><a href="/Assognment_PRJ/delete?id=<%= b.getId() %>">DELETE</a></td>
                    </tr>
                    <% } %>
                </table>
                
                <% } %>
                <nav aria-label="Page navigation example"  style="margin: 20px 0px;">
                    <ul class="pagination"  style="margin-left: 54%;transform: translateX(-50%);">
                        <li class="page-item"><a class="page-link" href="/Assognment_PRJ/list?page=1">1</a></li>
                        <li class="page-item"><a class="page-link" href="/Assognment_PRJ/list?page=2">2</a></li>
                        <li class="page-item"><a class="page-link" href="/Assognment_PRJ/list?page=3">3</a></li>
                        <li class="page-item"><a class="page-link" href="/Assognment_PRJ/list?page=4">4</a></li>
                        <li class="page-item"><a class="page-link" href="/Assognment_PRJ/list?page=5">5</a></li>
                        <li class="page-item"><a class="page-link" href="/Assognment_PRJ/list?page=6">6</a></li>
                        <li class="page-item"><a class="page-link" href="/Assognment_PRJ/list?page=7">7</a></li>
                        <li class="page-item"><a class="page-link" href="/Assognment_PRJ/list?page=8">8</a></li>
                        <li class="page-item"><a class="page-link" href="/Assognment_PRJ/list?page=9">9</a></li>
                        <li class="page-item"><a class="page-link" href="/Assognment_PRJ/list?page=10">10</a></li>
                    </ul>
                </nav>
                <% }%>
                <% } else if (check.intValue() == 2) {%>
                <form action="searchAccount" class="form_search">
                    SEARCH:<br/> 
                    <input type="text" placeholder="UserName" name="UserName"/>
                    <input type="text" placeholder="Name" name="Name"/>
                    <input type="text" placeholder="RollNo" name="RollNo"/>
                    <input type="text" placeholder="Class" name="Class"/>
                    <input type="text" placeholder="Subject" name="Subject"/>
                    <input type="submit" value="SEARCH"/>
                </form>
                <br/>
                <% if (request.getAttribute("listUser") == null) {%>
                <div style="height: 500px"><p>There is have no Account</p></div>
                <% } else { int i = 1;%> 
                <table class="table_css">
                    <tr class="fir">
                        <td>STT</td>
                        <td>UserName </td>
                        <td>Name</td>
                        <td>RollNo</td>
                        <td>Class</td>
                        <td>Major</td>
                    </tr>
                    <%
                for (Account b : ls2) {%> 
                    <tr>
                        <td><%= i++ %></td>
                        <td><%= b.getUserN() %></td>
                        <td><%= b.getName() %></td>
                        <td><%= b.getRollno() %></td>
                        <td><%= b.getClassName() %></td>
                        <td><%= b.getSubject() %></td>
                    </tr>
                    <% } %>
                </table>
                <% } %>
                <% } else if (check.intValue() == 3) {%>
                <!--        <form action="searchAccount">
                            SEARCH:<br/> 
                            <input type="text" placeholder="UserName" name="UserName"/>
                            <input type="text" placeholder="Name" name="Name"/>
                            <input type="text" placeholder="RollNo" name="RollNo"/>
                            <input type="text" placeholder="Class" name="Class"/>
                            <input type="text" placeholder="Subject" name="Subject"/>
                            <input type="submit" value="search"/>
                        </form>
                        <br/>-->
                <% if (request.getAttribute("listE") == null) {%>
                <div style="height: 500px"><p>Not found</p></div>
                <% } else { int i = 1;%> 
                <table class="table_css">
                    <tr class="fir">
                        <td>STT</td>
                        <td>ID </td>
                        <td>Name</td>
                        <td>Address</td>
                        <td>Phone</td>
                        <td>Positions</td>
                    </tr>
                    <%
                for (Employee b : ls4) {%> 
                    <tr>
                        <td><%= i++ %></td>
                        <td><%= b.getId() %></td>
                        <td><%= b.getName() %></td>
                        <td><%= b.getAddress() %></td>
                        <td><%= b.getPhone() %></td>
                        <td><%= b.getPositions() %></td>

                    </tr>
                    <% } %>
                </table>
                <% } %>
                <% } else if (check.intValue() == 4) {%>
                <form action="searchAccount" class="form_search">
                    SEARCH:<br/><br/>
                    <input type="text" placeholder="UserName" name="UserName"/>
                    <input type="text" placeholder="ID" name="ID"/>
                    <input type="text" placeholder="Status" name="Status"/>
                    <input type="text" placeholder="Date" name="Date"/>
                    <input type="submit" value="SEARCH"/>
                </form>
                <br/>
                <% if (request.getAttribute("listFines") == null) {%>
                <div style="height: 500px;">
                    <p>Not found</p>
                </div>
                <% } else {%> 
                <table class="table_css">
                    <tr class="fir">
                        <td>UserName </td>
                        <td>ID</td>
                        <td>Number of days penalized</td>
                        <td>Money</td>
                        <td>Status</td>
                        <td>Date</td>
                    </tr>
                    <%
                for (Fines b : lis4) {%> 
                    <tr>
                        <td><%= b.getUserName() %></td>
                        <td><%= b.getId() %></td>
                        <td><%= b.getDatePhat() %></td>
                        <td><%= b.getMoney() %>.000VND</td>
                        <td><%= b.getStauts() %></td>
                        <% if (b.getDate() != null){%>
                        <td><%= b.getDate() %></td>
                        <% } else%>
                        <% { %> <td></td><% } %>
                        <% if (b.getStauts().equals("Unpaid")) {%>
                        <td><a href="/Assognment_PRJ/paid?username=<%= b.getUserName() %>&id=<%= b.getId() %>">PAY</a></td>
                        <% } %>
                    </tr>
                    <% } %>
                </table>
                <% } %>                 

                <% } else if (check.intValue() == 5) {%>
                <form action="insert" method="post" class="form_insert1">
                    <p><span>*</span>If you do not enter anything in the information fields of the book, it will be left blank.<span>*</span></p>
                    <table>
                        <tr>
                            <td> ID: </td> 
                            <td><input type="text" name="id" placeholder="ID"/> </td> 
                        </tr>
                        <tr>
                            <td>Name: </td> 
                            <td><input type="text" name="name" placeholder="Name"/></td> 
                        </tr>
                        <tr>
                            <td> Category: </td> 
                            <td><input type="text" name="category" placeholder="Category"/></td> 
                        </tr>
                        <tr>
                            <td>Specialized: </td> 
                            <td><input type="text" name="sp" placeholder="Specialized"/></td> 
                        </tr>
                        <tr>
                            <td>Author: </td> 
                            <td><input type="text" name="author" placeholder="Author"/>  </td> 
                        </tr>
                        <tr>
                            <td>PublishingYear: </td> 
                            <td><input type="text" name="publis" placeholder="PublishingYear"/> </td> 
                        </tr>
                    </table>
                    <input type="submit" value="INSERT" class="last"/>
                    <% if (request.getAttribute("mess") != null) {
                     String ms = (String) request.getAttribute("mess");
                    %> 
                    <br/><!-- comment -->
                    <h3 style="color: red"> <%= ms%></h3>
                    <% } %>
                </form>

                <% } else if (check.intValue() == 6) {%>
                <form action="searchHistory" class="form_search">
                    SEARCH:<br/><br/>
                    <input type="text" placeholder="UserName" name="UserName"/> 
                    <input type="text" placeholder="ID" name="ID"/> 
                    <input type="date" placeholder="Date" name="date"/> 
                    <input type="text" placeholder="Event" name="Event"/> 
                    <input type="text" placeholder="Status" name="Status"/> 
                    <input type="submit" value="SEARCH"/>
                </form>
                <br/>
                <% if (request.getAttribute("historyAll") == null || ls0.isEmpty()) {%>
                <div style="height: 500px;">
                    <p>There is have no Request</p>
                </div>
                <% } else { %> 
                <table class="table_css">
                    <tr class="fir">
                        <td>UserName </td>
                        <td>ID</td>
                        <td>Date</td>
                        <td>Status</td>
                        <td>Note</td>
                    </tr>
                    <% for (History b : ls0) {%> 
                    <tr>
                        <td><%= b.getId() %></td>
                        <td><%= b.getName() %></td>
                        <td><%= b.getDate() %></td>
                        <td><%= b.getStatus() %></td>
                        <td><%= b.getNote() %></td>
                        <td><a href="/Assognment_PRJ/accept?username=<%= b.getId() %>&id=<%= b.getName() %>&result=accept">Accept</a></td>
                        <td><a href="/Assognment_PRJ/accept?username=<%= b.getId() %>&id=<%= b.getName() %>&result=refuse">Refuse</a></td>
                    </tr>
                    <% } %>
                </table>
                <% }%>
                <% } else if (check.intValue() == 7) {%>
          
                <form action="SearchHistory" method="post" class="form_search">
                    SEARCH:<br/><br/>
                    <input type="text" placeholder="UserName" name="UserName"/> 
                    <input type="text" placeholder="ID" name="ID"/> 
                    <input type="date" placeholder="Date" name="date"/> 
                    <input type="submit" value="SEARCH"/>
                </form>
              
                <% if (request.getAttribute("mess") != null ){%>
                <h4 style="color: red; margin: 20px 0;"><%= mes %></h4>
                <% } %>
                <% if (request.getAttribute("listGiveback") == null || lis5.isEmpty()) {%>
                <div style="height: 500px;">
                    <p>There is have no Borrow</p>
                </div>
                <% } else { %> 
                <h3 style="color: red">List Borrow</h3>
                <table class="table_css">
                    <tr class="fir">
                        <td>UserName </td>
                        <td>ID</td>
                        <td>Date</td>
                        <td>Status</td>
                        <td>Note</td>
                    </tr>
                    <% for (History b : lis5) {%> 
                    <tr>
                        <td><%= b.getId() %></td>
                        <td><%= b.getName() %></td>
                        <td><%= b.getDate() %></td>
                        <td><%= b.getStatus() %></td>
                        <td><%= b.getNote() %></td>
                        <td><a href="/Assognment_PRJ/gb?username=<%= b.getId() %>&id=<%= b.getName() %>">Give Back</a></td>
                    </tr>
                    <% } %>
                </table>
                <% }%>
                <% } else if (check.intValue() == 8) { %>
                <jsp:include page="updateBook.jsp"/>
                <% } else if (check.intValue() == 9) { %>

                <div class="right">
                    <div id="img">
                        <img src="img/manage.png" alt="anhdaidien">
                        <button id="logout"><a style="text-decoration:none ; color: black;" href="#">UPLOAD</a></button>
                    </div>
                    <div id="infor">
                        <h4><span style="color:black;">Access:</span>Manage</h4>
                        <h4><span style="color:black;">UserName:</span>${user.getUserN()}</h4>
                        <h4><span style="color:black;">Name:</span>${user.getName()}</h4>
                        <button id="logout" class="rightB"><a style="text-decoration:none ; color: black;" href="#">Change information</a></button>
                    </div>

                </div>
                <% }%>
            </div>
        </div>

        <jsp:include page="footer.jsp"/>

    </body>
</html>

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.Book;
import model.BooksDAO;

/**
 *
 * @author acer
 */
public class SearchBooksServlet extends HttpServlet {
   List<Book> listBook = new ArrayList<>();
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
      Account a = (Account)request.getSession().getAttribute("user");
      String page = request.getParameter("page");
      int k = Integer.parseInt(page);
       if (listBook.size() <= (k-1)*15 )
                request.setAttribute("listBooks", null);
            else if (listBook.size() <= (k)*15 ) 
                request.setAttribute("listBooks", listBook.subList((k-1)*15, listBook.size()));
            else
                request.setAttribute("listBooks", listBook.subList((k-1)*15, k*15));
        request.getRequestDispatcher("SearchList.jsp").include(request, response);
        request.setAttribute("isSearch", 0);
        if (a.getRole() == 0){      
        request.getRequestDispatcher("home_user.jsp").forward(request, response);
        }        
        else if (a.getRole()== 1) {
        request.getRequestDispatcher("home_management.jsp").forward(request, response); }
    } 
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String Category = request.getParameter("Category");
        String specialized = request.getParameter("specialized");
        String author = request.getParameter("author");
        String PublishingYear = request.getParameter("PublishingYear");
        Account a = (Account)request.getSession().getAttribute("user");
        if (id == null) id = "";
        if (name == null) name = "";
        if (Category == null) Category = "";
        if (specialized == null) specialized = "";
        if (author == null) author = "";
        if (PublishingYear == null) PublishingYear = "";
        BooksDAO bk = new BooksDAO();
        List<Book> ls = bk.search(id, name, Category, specialized, author, PublishingYear);
        listBook = ls;
        int k = 1;
        if (ls.size() <= (k-1)*15 )
                request.setAttribute("listBooks", null);
            else if (ls.size() <= (k)*15 ) 
                request.setAttribute("listBooks", ls.subList((k-1)*15, ls.size()));
            else
                request.setAttribute("listBooks", ls.subList((k-1)*15, k*15));
        
        request.getRequestDispatcher("SearchList.jsp").include(request, response);
        request.setAttribute("isSearch", 0);            
       if (a.getRole() == 0){      
        request.getRequestDispatcher("home_user.jsp").forward(request, response);
        }        
        else if (a.getRole()== 1) {
        request.getRequestDispatcher("home_management.jsp").forward(request, response); }
    } 
       
}

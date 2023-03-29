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
import model.Book;
import model.BooksDAO;

/**
 *
 * @author acer
 */
public class InsertServlet_mana extends HttpServlet {
   
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.getSession().setAttribute("check", 5);
        request.getRequestDispatcher("home_management.jsp").forward(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String category = request.getParameter("category");
        String sp = request.getParameter("sp");
        String author = request.getParameter("author");
        String publis = request.getParameter("publis");
        int k;
        if (publis == null || publis.isEmpty()) k = 0;
        else k = Integer.parseInt(publis);
        Book b = new Book(id, name, category, sp, author, k);
        BooksDAO bk = new BooksDAO();
        Book crB = bk.getBook(id);
        if (crB != null) {
            request.setAttribute("mess", "Book that already exist!");
        } else {
         bk.insert(b);
        request.setAttribute("mess", "INSERT SECCESSFULLY!");
        }
        
        request.getRequestDispatcher("home_management.jsp").forward(request, response);
        
    }

}

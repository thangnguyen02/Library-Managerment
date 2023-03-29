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
 * @author phanv
 */
public class listOfBooks extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
            String page = request.getParameter("page");
            int k = Integer.parseInt(page);
            BooksDAO bk = new BooksDAO();
            List<Book> listBooks = bk.getBooks();
            if (listBooks.size() <= (k-1)*15 )
                request.setAttribute("listBooks", null);
            else if (listBooks.size() <= (k)*15 ) 
                request.setAttribute("listBooks", listBooks.subList((k-1)*15, listBooks.size()));
            else
                request.setAttribute("listBooks", listBooks.subList((k-1)*15, k*15));
            request.getSession().setAttribute("check", 1);
            request.setAttribute("isSearch", 1);
            int n = (int)Math.ceil(listBooks.size()/10);
            request.getSession().setAttribute("n", n);
            request.getRequestDispatcher("home_user.jsp").forward(request, response);

            
    } 

}

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
import java.util.List;
import model.Book;
import model.BooksDAO;

/**
 *
 * @author acer
 */
public class listOfBooks_mana extends HttpServlet {

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
            request.getRequestDispatcher("home_management.jsp").forward(request, response);
    } 

}

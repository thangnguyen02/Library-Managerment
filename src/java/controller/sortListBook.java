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
import model.*;

/**
 *
 * @author acer
 */
public class sortListBook extends HttpServlet {
   List<Book> list = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String page = request.getParameter("page");
        String coll = request.getParameter("collname");
        String type = request.getParameter("type");
        int k = Integer.parseInt(page);
        
        if (!coll.isEmpty() && !type.isEmpty()) {
        BooksDAO bk = new BooksDAO();
        List<Book> lis = bk.getBooksSort(coll, type);
        list = lis;
        }
        
        if (list.size() <= (k-1)*10 )
                request.setAttribute("listBooks", null);
            else if (list.size() <= (k)*10 ) 
                request.setAttribute("listBooks", list.subList((k-1)*10, list.size()));
            else
                request.setAttribute("listBooks", list.subList((k-1)*10, k*10));
            request.setAttribute("isSort", 1);
            request.setAttribute("isSearch", 1);
            request.getRequestDispatcher("ListOfBook.jsp").include(request, response);
            request.getRequestDispatcher("home_user.jsp").forward(request, response);
        
    } 

}

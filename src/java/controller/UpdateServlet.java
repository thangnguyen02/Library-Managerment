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
public class UpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        request.setAttribute("id", id);
        request.getRequestDispatcher("updateBook.jsp").include(request, response);
        request.getSession().setAttribute("check", 8);
        request.getRequestDispatcher("home_management.jsp").forward(request, response);
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("Id");
        String name = request.getParameter("Name");
        String category = request.getParameter("Category");
        String sp = request.getParameter("Specialized");
        String author = request.getParameter("Author");
        String publis = request.getParameter("PublishingYear");
        int k = 0;
        BooksDAO bk = new BooksDAO();
        Book current = bk.getBook(id);
        if (current == null) {
            request.setAttribute("ms", "No find Book");
            request.getRequestDispatcher("updateBook.jsp").include(request, response);
            request.getRequestDispatcher("home_management.jsp").forward(request, response);
        } else {
            if (name.isEmpty())
                name = current.getName();
            if (category.isEmpty())
                category = current.getCategory();
            if (sp.isEmpty())
                sp = current.getSpecialized();
            if (author.isEmpty())
                author = current.getAuthor();
            if (publis.isEmpty())
                k = current.getPublishingYear();
            else if (!isNumeric(publis)) {
                request.setAttribute("ms", "Public Year is not Invalid!!");
                request.getRequestDispatcher("updateBook.jsp").include(request, response);
                request.getRequestDispatcher("home_management.jsp").forward(request, response);
            } else if (publis.isEmpty())
                k = current.getPublishingYear();
            else
                k = Integer.parseInt(publis);
            Book b = new Book(id, name, category, sp, author, k);
            bk.update(id, b);
            request.setAttribute("ms", "UPDATE SUCCESSFULLY!!");
            request.getRequestDispatcher("updateBook.jsp").include(request, response);
            request.getRequestDispatcher("home_management.jsp").forward(request, response);
        }
    }
}

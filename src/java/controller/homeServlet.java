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
import java.util.HashMap;
import java.util.List;
import model.Account;
import model.Message;
import model.MessageDAO;
import model.*;

/**
 * @author acer
 *
 * @author acer
 */
public class homeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Account a = (Account) request.getSession().getAttribute("user");
        MessageDAO ms = new MessageDAO();
        request.getSession().setAttribute("user", a);
        if (a.getRole() == 0) {
            BooksDAO bk = new BooksDAO();
            HashMap<Book, Integer> t = bk.getTopBorrow();
            List<Message> lis = ms.getMess(a.getUserN());
            request.setAttribute("listms", lis);
            request.setAttribute("Top3", t);
            request.getRequestDispatcher("homePage.jsp").include(request, response);
            request.getSession().setAttribute("check", 0);
            request.getRequestDispatcher("home_user.jsp").forward(request, response);
        } else if (a.getRole() == 1) {
            HistoryDAO hs = new HistoryDAO();
            List<History> lis = hs.getHistoryAll();
            request.setAttribute("historyAll", lis);
            request.getSession().setAttribute("check", 0);
            request.getRequestDispatcher("home_management.jsp").forward(request, response);
        }
    }

}

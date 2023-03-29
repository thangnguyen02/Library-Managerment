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
import java.util.HashMap;
import java.util.List;
import model.Account;
import model.AccountDAO;
import model.Book;
import model.BooksDAO;
import model.History;
import model.HistoryDAO;
import model.Message;
import model.MessageDAO;

/**
 *
 * @author phanv
 */
public class LoginServlet extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.getRequestDispatcher("SignIn.jsp").forward(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        String adminU = request.getServletContext().getInitParameter("user_admin");
        String adminP = request.getServletContext().getInitParameter("pass_admin");
        if (user.equals(adminU) && pass.equals(adminP)) {
            request.getRequestDispatcher("adminPage.jsp").forward(request, response);
        } else 
        {
        AccountDAO ac = new AccountDAO();
        Account a = ac.getAccount(user, pass);
        boolean ok = true;
        if (user.isEmpty()) {
            String ms = "Empty username !";
            request.setAttribute("ms1", ms);
        }
        if (pass.isEmpty()) {
            String ms = "Empty password !";
            request.setAttribute("ms2", ms);
        }
        if (!user.isEmpty() && !pass.isEmpty()){
            if (a == null){
            String ms = "Invalid username,password!";
            request.setAttribute("ms3", ms); 
            request.getRequestDispatcher("SignIn.jsp").forward(request, response);
        } else {
                MessageDAO ms = new MessageDAO();
                request.getSession().setAttribute("user", a);
                if (a.getRole() == 0) {
                   response.sendRedirect("home");
                ok = false;
                } else if (a.getRole() == 1 ) {
                    response.sendRedirect("home");
                    ok = false;
                }
        }
        }
        if (ok)   request.getRequestDispatcher("SignIn.jsp").forward(request, response);
    }
    }
}

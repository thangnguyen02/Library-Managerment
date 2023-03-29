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
import model.*;
/**
 *
 * @author acer
 */
public class UserServlet extends HttpServlet {
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        Account a = (Account) request.getSession().getAttribute("user");
        request.getSession().setAttribute("check", 9);
        if (a.getRole() == 0)
        request.getRequestDispatcher("home_user.jsp").forward(request, response);
        else request.getRequestDispatcher("home_management.jsp").forward(request, response);
    } 


}

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
import model.Account;
import model.AccountDAO;

/**
 *
 * @author acer
 */
public class searchAccountServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String userName = request.getParameter("UserName");
        String Name = request.getParameter("Name");
        String RollNo = request.getParameter("RollNo");
        String Class = request.getParameter("Class");
        String Subject = request.getParameter("Subject");
        
        AccountDAO ac= new AccountDAO();
        List<Account> ls = ac.search(userName, Name, RollNo, Class, Subject);
        request.setAttribute("listUser", ls);
        request.getSession().setAttribute("check", 2);
        request.getRequestDispatcher("home_management.jsp").forward(request, response);
    } 


}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import java.io.IOException;
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
public class listUserServlet extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        AccountDAO ac = new AccountDAO();
        List<Account> ls = ac.getAccounts(0);
        request.setAttribute("listUser", ls);
        request.getSession().setAttribute("check", 2);
        request.getRequestDispatcher("home_management.jsp").forward(request, response);
    } 

}

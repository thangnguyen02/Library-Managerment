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
import model.*;
/**
 *
 * @author acer
 */
public class listEServlet extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        EmployeeDAO ed= new EmployeeDAO();
        List<Employee> lis = ed.getEmployees();
        request.setAttribute("listE", lis);
        request.getSession().setAttribute("check", 3);
        request.getRequestDispatcher("home_management.jsp").forward(request, response);
    } 

}

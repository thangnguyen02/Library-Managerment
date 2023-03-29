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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import model.Fines;
import model.FinesDAO;

/**
 *
 * @author acer
 */
public class paidServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String us = request.getParameter("username");
        String id = request.getParameter("id");
        FinesDAO fd = new FinesDAO();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern("yyyy-MM-dd");
        String format = simpleDateFormat.format(date);
        fd.update("Paid", format, us, id);
        List<Fines> lis = fd.getAllF();
        request.setAttribute("listFines", lis);
        request.getRequestDispatcher("home_management.jsp").forward(request, response);
    } 

}

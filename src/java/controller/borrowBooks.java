/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Account;
import model.History;
import model.HistoryDAO;

/**
 *
 * @author acer
 */
public class borrowBooks extends HttpServlet {
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        Account a = (Account)request.getSession().getAttribute("user");
        String id = request.getParameter("id");
        HistoryDAO hs = new HistoryDAO();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern("yyyy-MM-dd");
        String format = simpleDateFormat.format(date);
        hs.insert(a.getUserN(), id, format, "Borrow", "Pending");
        request.setAttribute("isSearch", 1);
        request.setAttribute("ms", "Request successful!!");
        request.getRequestDispatcher("borrowB?page=1").forward(request, response);
    } 


}

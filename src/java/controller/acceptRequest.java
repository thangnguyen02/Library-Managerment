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
import model.Account;
import model.History;
import model.HistoryDAO;
import model.MessageDAO;

/**
 *
 * @author acer
 */
public class acceptRequest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HistoryDAO hs = new HistoryDAO();
        MessageDAO ms = new MessageDAO();
        String un = request.getParameter("username");
        String id = request.getParameter("id");
        String result = request.getParameter("result");
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern("yyyy-MM-dd");
        String format = simpleDateFormat.format(date);
        
        if (un != null && id != null && result != null) {
            if (result.equals("accept")) {
                hs.update(un, id, "note", "Successful");
                 String mes = "An application for a book loan with code "+id+" was accepted. Go to the library within 1 week to receive the book";
                 ms.insert(un, mes, format);
            } else {
                hs.delete(un, id);
                String mes = "Your request to borrow a book with book code "+id+" has been declined";
                ms.insert(un, mes, format);
            }
        } 
            List<History> lis = hs.getHis();
            request.setAttribute("historyAll", lis);
            request.getSession().setAttribute("check", 6);
            request.getRequestDispatcher("home_management.jsp").forward(request, response);
        
    }
}

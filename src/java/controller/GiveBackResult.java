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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.*;
/**
 *
 * @author acer
 */
public class GiveBackResult extends HttpServlet {
   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String un = request.getParameter("username");
        String id = request.getParameter("id");
        HistoryDAO hs = new HistoryDAO();
        FinesDAO fd = new FinesDAO();
        
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern("yyyy-MM-dd");
        String format = simpleDateFormat.format(date);
        History h = hs.getHisbyUnID(un, id);
        History hG = new History(un, id, format, "GiveBack","Successful");
        hs.insert(un, id, format, "GiveBack","Successful");
        Fines x;
         int day =  fd.getDay(h.getDate(), hG.getDate());
                    if (day > 60) {
                x = new Fines(un, id, (day - 60),(day - 60)*5,"Unpaid", null);
                fd.insert(x); }
   
        request.setAttribute("mess", "GiveBack Successful!!");
        request.getRequestDispatcher("giveback").forward(request, response);
    } 
}

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
public class SerchLibServlet extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String dateB = request.getParameter("dateBegin");
        String dateE = request.getParameter("dateEnd");
        String status = request.getParameter("Status");
        String note = request.getParameter("note");
        Account a = (Account)request.getSession().getAttribute("user");
        if (id == null) id = "";
        if (name == null) name = "";
        if (dateB.isEmpty()) dateB = "1900-01-01";
        if (dateE.isEmpty()) dateE = "2099-01-01";
        if (status == null) status = "";
        if (note == null) note = "";
        
        HistoryDAO Hk = new HistoryDAO();
        List<History> ls = Hk.search(a.getUserN(),id, name, dateB, dateE, status, note);
        request.setAttribute("listHistorys", ls);
        if (a.getRole() == 0){
         FinesDAO fd = new FinesDAO();   
        request.setAttribute("listFines", fd.getFinesByID(a.getUserN()));    
        request.getRequestDispatcher("home_user.jsp").forward(request, response);}
        else if (a.getRole()==1) 
        request.getRequestDispatcher("home_management.jsp").forward(request, response);
    } 

}

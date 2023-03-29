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
import java.util.ArrayList;
import java.util.List;
import model.*;

/**
 *
 * @author acer
 */
public class LybraryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Account a = (Account) request.getSession().getAttribute("user");
        HistoryDAO hs = new HistoryDAO();
        FinesDAO fd = new FinesDAO();
        List<History> lis = hs.getLib(a.getUserN());

        request.setAttribute("listHistorys", lis);
        request.setAttribute("listFines", fd.getFinesByID(a.getUserN()));
        request.getSession().setAttribute("check", 2);
        request.getRequestDispatcher("home_user.jsp").forward(request, response);

    }

}

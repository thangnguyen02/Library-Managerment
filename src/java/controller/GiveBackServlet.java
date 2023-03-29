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
public class GiveBackServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HistoryDAO hs = new HistoryDAO();
        List<History> listB = hs.getBorrow();
        List<History> listG = hs.getGiveback();
        List<History> lis3 = new ArrayList<>();
          List<History> lis4 = new ArrayList<>();
        for (History h: listB) {
            for (History h1 : listG) {
                if (h.getName().equals(h1.getName()) && h.getId().equals(h1.getId())) {
                    lis3.add(h);
                }
            }
        }
          for (History h: listB) {
              if (lis3.indexOf(h) == -1) {
                  lis4.add(h);
              }
          }
        request.setAttribute("listGiveback", lis4);
        request.getSession().setAttribute("check", 7);
        request.getRequestDispatcher("home_management.jsp").forward(request, response);
    } 

}

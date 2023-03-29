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
import model.Account;
import model.Book;
import model.BooksDAO;
import model.History;
import model.HistoryDAO;

/**
 *
 * @author acer
 */
public class ListBorrow extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        Account a = (Account)request.getSession().getAttribute("user");
        String page = request.getParameter("page");
            int k = Integer.parseInt(page);
            BooksDAO bk = new BooksDAO();
            HistoryDAO hs = new HistoryDAO();
            List<History> lisHis = hs.getLib(a.getUserN());
            List<Book> listBooks = bk.getBooks();
            List<Book> lis = new ArrayList<>();
            for (Book b: listBooks) {
                boolean ok = false;
                for (History h: lisHis) {
                    if (b.getId().equals(h.getId())) {
                        ok = true;
                        break;
                    }
                }
                if (!ok) lis.add(b);
            }
            
       if (lis.size() <= (k-1)*15 )
                request.setAttribute("listBooks", null);
            else if (lis.size() <= (k)*15 ) 
                request.setAttribute("listBooks", lis.subList((k-1)*15, lis.size()));
            else
                request.setAttribute("listBooks", lis.subList((k-1)*15, k*15));
            request.getSession().setAttribute("check", 3);
            request.setAttribute("isSearch", 1);
            request.setAttribute("msi", request.getAttribute("ms"));
            request.getRequestDispatcher("home_user.jsp").forward(request, response);
    } 

}

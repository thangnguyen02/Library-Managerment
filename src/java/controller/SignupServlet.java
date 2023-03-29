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
import model.Account;
import model.AccountDAO;

/**
 *
 * @author phanv
 */
public class SignupServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("SignUp.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        String name = request.getParameter("name");
        String RollNo = request.getParameter("RollNo");
        String classN = request.getParameter("classN");
        String subject = request.getParameter("subject");
        AccountDAO ac = new AccountDAO();
        Account a = ac.getAccount(user, pass);
        if (user.isEmpty()) {
            String ms = "Empty username !";
            request.setAttribute("ms", ms);
        } else if (pass.isEmpty()) {
            String ms = "Empty password !";
            request.setAttribute("ms", ms);
        } else if (name.isEmpty()) {
            String ms = "Empty Name !";
            request.setAttribute("ms", ms);
        } else if (RollNo.isEmpty()) {
            String ms = "Empty RollNo !";
            request.setAttribute("ms", ms);
        } else if (classN.isEmpty()) {
            String ms = "Empty class !";
            request.setAttribute("ms", ms);
        } else if (subject.isEmpty()) {
            String ms = "Empty subject !";
            request.setAttribute("ms", ms);
        } else if (!user.isEmpty() && !pass.isEmpty() && !name.isEmpty() && !RollNo.isEmpty() && !classN.isEmpty()
                && !subject.isEmpty()) {
            if (a != null) {
                String ms = "Username is exist!";
                request.setAttribute("ms", ms);
            } else {
                a = new Account(user, pass, name, RollNo, classN, subject, 0);
                ac.insert(a);
                String ms = "Sign Up successfully !!";
                request.setAttribute("ms", ms);

            }
        }
        request.getRequestDispatcher("SignUp.jsp").include(request, response);
    }

}

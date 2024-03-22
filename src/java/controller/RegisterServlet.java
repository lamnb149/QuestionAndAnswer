/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Email;
import model.Profile;
import util.Crypto;

/**
 *
 * @author Admin
 */
public class RegisterServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegisterServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.getRequestDispatcher("Register.jsp").forward(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String firstName = request.getParameter("fname_signup");
        String lastName = request.getParameter("lname_signup");
        String fullName = firstName + lastName;
        String username = request.getParameter("gmail_signup");
        String password = request.getParameter("password_signup");
        String repassword = request.getParameter("repassword_signup");
        boolean gender = request.getParameter("gender").equals("male") ? true : false;
        DAO.INSTANCE.getAll();
        String ms = "Register successfully";
        boolean isHaveUser = false;
        for (Profile p : DAO.INSTANCE.getProfileList()) {
            if (p.getUsername().equals(username)) {
                isHaveUser = true;
                ms = "Duplicated username, register fail!";
                break;
            }
        }
        if (!password.equals(repassword)) {
            request.setAttribute("mes", "Password are not the same");
            request.getRequestDispatcher("Register.jsp").forward(request, response);
            return;
        }
        if (isHaveUser) {
            request.setAttribute("mes", ms);
            request.getRequestDispatcher("Register.jsp").forward(request, response);
        } else {
            password = Crypto.toSHA1(password);
            DAO.INSTANCE.addProfile(fullName, gender, username, password, 1);
            Email.sendEmail(username, "Register successfully", "Welcome to localhost:9999/SocialMedia");
            response.sendRedirect("Login.jsp");
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

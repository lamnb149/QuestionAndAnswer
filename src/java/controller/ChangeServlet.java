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
import jakarta.servlet.http.HttpSession;
import java.util.Random;
import model.Email;
import model.Profile;
import org.json.simple.JSONObject;

/**
 *
 * @author Admin
 */
public class ChangeServlet extends HttpServlet {
   
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
            out.println("<title>Servlet ChangeServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ChangeServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.getRequestDispatcher("Change.jsp").forward(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        DAO.INSTANCE.getAll();
        String gmail_change = request.getParameter("gmail_changePass");
        String msg = "";
        HttpSession ses = request.getSession();
        if (!isValidGmail(gmail_change)) {
            msg = "Email is not exist. Please re-enter!";
            JSONObject json = new JSONObject();
            json.put("msg", msg);
            json.put("gmail", gmail_change);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print(json);
        } else {
            String pin = generateRandomPIN(4);
            ses.setAttribute("pinChange", pin);
            ses.setAttribute("gmailChange", gmail_change);
            Email.sendEmail(gmail_change, "PIN TO CHANGE PASSWORD", "PIN: " + pin);
        }
    }
  
    public boolean isValidGmail(String gmail) {
        for (Profile p : DAO.INSTANCE.getProfileList()) {
            if (p.getUsername().equals(gmail)) {
                return true;
            }
        }
        return false;
    }

    public String generateRandomPIN(int length) {
        String numbers = "0123456789";
        Random random = new Random();
        char[] pin = new char[length];
        for (int i = 0; i < length; i++) {
            pin[i] = numbers.charAt(random.nextInt(numbers.length()));
        }
        return new String(pin);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

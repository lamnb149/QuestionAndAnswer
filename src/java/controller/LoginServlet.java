package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dal.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpSession;
import java.util.Random;
import model.*;
import util.Crypto;

/**
 *
 * @author Admin
 */
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Object out = request.getParameter("out");
        HttpSession ses = request.getSession();
        if (out != null) {
            ses.removeAttribute("user");
        }
        response.sendRedirect("Login.jsp");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO.INSTANCE.getAll();
        String username = request.getParameter("gmail_login");
        String password = request.getParameter("password_login");
        String passwordCrypt = Crypto.toSHA1(password);
        String r = request.getParameter("chkremember");
        Cookie crem = new Cookie("reme", r);
        Cookie cuser = new Cookie("user", username);
        Cookie cpass = new Cookie("pass", password);
        if (r != null) {
            crem.setMaxAge(60 * 60 * 24 * 7);
            cuser.setMaxAge(60 * 60 * 24 * 7);
            cpass.setMaxAge(60 * 60 * 24 * 7);
        } else {
            crem.setMaxAge(0);
            cuser.setMaxAge(0);
            cpass.setMaxAge(0);
        }
        response.addCookie(crem);
        response.addCookie(cuser);
        response.addCookie(cpass);
        request.setAttribute("mes", "Wrong password or gmail");

        HttpSession ses = request.getSession();
        Integer wrongLoginCount = (Integer)ses.getAttribute("wrongLoginCount");
        
        if (wrongLoginCount == null) {
            wrongLoginCount = 0;
        }
        
        if (wrongLoginCount >= 3) {
            String btnPin = request.getParameter("btnPin");
            String btnGmail = request.getParameter("btnGmail");
            
            String savedPin = request.getParameter("pin");
            String inputPin;
            if (btnGmail != null) {
                String pin = generateRandomPIN(4);
                ses.setAttribute("pin", pin);
                savedPin = (String) ses.getAttribute("pin");
                String gmail = request.getParameter("gmail");
                System.out.println("gmail = " + gmail);
                if (!isValidGmail(gmail)) {
                    request.setAttribute("msgValidGmail", "Gmail is not exists");
                    request.getRequestDispatcher("Login.jsp").forward(request, response);
                    return;
                }
                Email.sendEmail(gmail, "Code", "PIN: " + pin);
                request.setAttribute("gmail_cur", gmail);
                System.out.println("gmail" + gmail);
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }  
            if (btnPin != null) {
                inputPin = request.getParameter("inputPin");
                if (inputPin.equals(savedPin)) {
                    ses.setAttribute("wrongLoginCount", 0);
                } else {
                    request.setAttribute("msg", "MA PIN BI SAI, VUI LONG KIEM TRA LAI");
                }
                request.setAttribute("mes", "");
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }
            return;
        }
        
        boolean isValidLogin = false;
        
        for (Profile p : DAO.INSTANCE.getProfileList()) {
            if (p.getUsername().equals(username) && p.getPassword().equals(passwordCrypt)) {
                ses.setAttribute("user", p);
                isValidLogin = true;
                ses.setAttribute("wrongLoginCount", 0);
                break;
            }
        }

        if (!isValidLogin) {
            wrongLoginCount++;
            ses.setAttribute("wrongLoginCount", wrongLoginCount);
            request.setAttribute("message", "Invalid username or password!");
            System.out.println("heloo");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
            return;
        }
        response.sendRedirect(request.getContextPath() + "/Admin");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    
    public String generateRandomPIN(int length) {
        String numbers = "0123456789";
        Random random = new Random();
        char[] pin = new char[length];
        for (int i = 0; i < length; i++) {
            pin[i] = numbers.charAt(random.nextInt(numbers.length()));
        }
        return new String(pin);
    }
    
    public boolean isValidGmail(String gmail) {
        for (Profile p : DAO.INSTANCE.getProfileList()) {
            if (p.getUsername().equals(gmail)) {
                return true;
            }
        }
        return false;
    } 
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

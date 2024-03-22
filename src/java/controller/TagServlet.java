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

/**
 *
 * @author Admin
 */
public class TagServlet extends HttpServlet {
   
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
            out.println("<title>Servlet TagServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TagServlet at " + request.getContextPath () + "</h1>");
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
        response.sendRedirect("Home");
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String btnAddTag = request.getParameter("btnAddTag");
        String btnRemoveTag = request.getParameter("btnRemoveTag");
        
        if (btnAddTag != null) {
            String allTag = request.getParameter("all-tag");
            String postId = request.getParameter("postId");
            try {
                int allTag_INT = Integer.parseInt(allTag);
                int postId_INT = Integer.parseInt(postId);
                DAO.INSTANCE.addTag(postId_INT, allTag_INT);
            } catch (Exception e) {
                System.out.println(e);
            }
        } 
        if (btnRemoveTag != null) {
            String tagAvailable = request.getParameter("tag-available");
            String postId = request.getParameter("postId");
            try {
                int tagAvailable_INT = Integer.parseInt(tagAvailable);
                int postId_INT = Integer.parseInt(postId);
                DAO.INSTANCE.removePostTag(postId_INT, tagAvailable_INT);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        doGet(request, response);
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

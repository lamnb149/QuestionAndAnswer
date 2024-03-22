
package controller;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Paging;

/**
 *
 * @author Admin
 */
public class Admin extends HttpServlet {

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
            out.println("<title>Servlet Admin</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Admin at " + request.getContextPath() + "</h1>");
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
        DAO.INSTANCE.getAll();
        request.setAttribute("dao", DAO.INSTANCE);
        String des = request.getParameter("des");
        request.setAttribute("postList", DAO.INSTANCE.getPostList());
        request.setAttribute("profileList", DAO.INSTANCE.getProfileList());
        request.setAttribute("postFeedBackList", DAO.INSTANCE.getPostFeedBackList());
        des = (des == null) ? "1" : des;
        String type_raw = request.getParameter("type");
        String type =  (type_raw == null) ? "1" : type_raw;
        System.out.println("type= " + type);
        String postId = request.getParameter("postId");
        String userId = request.getParameter("userId");
        if (type.equals("1")) {
            try {
                int postId_INT = Integer.parseInt(postId);
                DAO.INSTANCE.updateAField(postId_INT, "DeletionDate", 0);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        if (type.equals("2")) {
            try {
                int userId_INT = Integer.parseInt(userId);
                DAO.INSTANCE.updateBan(userId_INT, true);
            } catch (Exception e) {
                System.out.println(e);
            }
            
            
        }  
        if (type.equals("3")) {
            try {
                int userId_INT = Integer.parseInt(userId);
                DAO.INSTANCE.updateBan(userId_INT, false);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        if (des.equals("1")) {
            request.getRequestDispatcher("Admin.jsp").forward(request, response);
        } else if (des.equals("2")) {
            request.getRequestDispatcher("AdminUser.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("AdminFeedBack.jsp").forward(request, response);
        }
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
        String body = request.getParameter("body-feedback");
        String postId = request.getParameter("postId");
        try {
            int postId_INT = Integer.parseInt(postId);
            DAO.INSTANCE.addFeedBack(postId_INT, body);
        } catch (Exception e) {
            System.out.println(e);
        }
        doGet(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

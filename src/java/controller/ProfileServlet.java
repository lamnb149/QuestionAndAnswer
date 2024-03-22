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
import model.Post;
import model.Profile;
import util.Crypto;

/**
 *
 * @author Admin
 */
public class ProfileServlet extends HttpServlet {
   
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
            out.println("<title>Servlet ProfileServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProfileServlet at " + request.getContextPath () + "</h1>");
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
        DAO.INSTANCE.getAll();
        HttpSession ses = request.getSession();
        Profile userCur = (Profile) ses.getAttribute("user");
        request.setAttribute("nestedComment", DAO.INSTANCE.getNestedComment(userCur, 0));
        request.setAttribute("dao", DAO.INSTANCE);
        request.getRequestDispatcher("Profile.jsp").forward(request, response);
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
        String btnPost = request.getParameter("btnPost");
        String btnSubmitMain = request.getParameter("myCmt-submit-main");
        String btnSubmitSecond = request.getParameter("myCmt-submit-main");
        String btnUpdate = request.getParameter("btnUpdate");
        String btnChangePass = request.getParameter("btnChangePass");
        HttpSession ses = request.getSession();
        Profile prof = (Profile) ses.getAttribute("user");
        if (btnChangePass != null) {
            DAO.INSTANCE.getAll();
            String oldPass = request.getParameter("oldPassword");
            oldPass = Crypto.toSHA1(oldPass);
            String userId = request.getParameter("userId");
            try {
                response.setContentType("text/plain");
                response.setCharacterEncoding("UTF-8");
                int userId_int = Integer.parseInt(userId);
                String oldPass_db = DAO.INSTANCE.getProfileById(userId_int).getPassword();
                String newPassword = request.getParameter("newPassword");
                String reNewPassword = request.getParameter("reNewPassword");
                String msg = "Change Password Succesfully";
                if (!oldPass.equals(oldPass_db)) {
                    msg = "Old password is wrong. Please check again!";
                    response.getWriter().print(msg);
                } else {
                    if (!newPassword.equals(reNewPassword)) {
                        msg = "New Password and Re New Password is not the same";
                        response.getWriter().print(msg);
                    } else {
                        String newPasswordCrypt = Crypto.toSHA1(newPassword);
                        Profile p = DAO.INSTANCE.getProfileById(userId_int);
                        DAO.INSTANCE.changePassword(p.getUsername(), newPasswordCrypt);
                        response.getWriter().print(msg);
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            return;
        }
        if (btnPost != null) {
            String title = request.getParameter("title-p");
            String body = request.getParameter("body-p");
            String postType = (request.getParameter("post_type").equals("Question") ? "1" : "3");
            String ownerId = request.getParameter("owner-p");
            try {
                int postTypeInt = Integer.parseInt(postType);
                int ownerIdInt = Integer.parseInt(ownerId);
                DAO.INSTANCE.addPost(postTypeInt, body, ownerIdInt, title, 0, 1);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        if (btnSubmitMain != null) {
            String textMain = request.getParameter("myCmt-text-main");
            String userIdMain = request.getParameter("myCmt-userId-main");
            String postIdMain = request.getParameter("myCmt-postId-main");
            try {
                int userIdMain_INT = Integer.parseInt(userIdMain);
                int postIdMain_INT = Integer.parseInt(postIdMain);
                DAO.INSTANCE.addComment(postIdMain_INT, textMain, userIdMain_INT, 0);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        if (btnSubmitSecond != null) {
            String textSecond = request.getParameter("myCmt-text-main");
            String userIdSecond = request.getParameter("myCmt-userId-second");
            String postIdSecond = request.getParameter("myCmt-postId-second");
            String parendIdSecond = request.getParameter("myCmt-parenId-second");
            try {
                int userIdSecond_INT = Integer.parseInt(userIdSecond);
                int postIdSecond_INT = Integer.parseInt(postIdSecond);
                int parendIdSecond_INT = Integer.parseInt(parendIdSecond);
                DAO.INSTANCE.addComment(postIdSecond_INT, textSecond, userIdSecond_INT, parendIdSecond_INT);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        if (btnUpdate != null) {
            String displayName = request.getParameter("displayName");
            String location = request.getParameter("location");
            String aboutMe = request.getParameter("aboutMe");
            boolean gender = (request.getParameter("gender").equals("male")) ? true : false;
            String dob = request.getParameter("dob");
            String fullName = request.getParameter("fullName");
            String phoneNumber = request.getParameter("phoneNumber");
            int id = prof.getId();
            DAO.INSTANCE.updateProfile(id, displayName, location, aboutMe, gender, dob, phoneNumber, fullName);
        }
        String urlImgAvt = request.getParameter("urlAvt");
        String urlImgBack = request.getParameter("urlBack");
        if (urlImgAvt != null || urlImgBack != null) {
            if (urlImgAvt != null) {
                DAO.INSTANCE.updateProfileImg(prof.getId(), "images/" + urlImgAvt, true);
            } 
            if (urlImgBack != null) {
                DAO.INSTANCE.updateProfileImg(prof.getId(), "images/" + urlImgBack, false);
            }
        }
        String following = request.getParameter("FOLLOWING");
        String followed = request.getParameter("FOLLOWED");
        if (following != null || followed != null) {
            DAO.INSTANCE.getAll();
            request.setAttribute("dao", DAO.INSTANCE);
            request.setAttribute("followerList", DAO.INSTANCE.getFollowerList());
            if (following != null) {
                request.getRequestDispatcher("Following.jsp").forward(request, response);
            }
            if (followed != null) {
                request.getRequestDispatcher("Followed.jsp").forward(request, response);
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

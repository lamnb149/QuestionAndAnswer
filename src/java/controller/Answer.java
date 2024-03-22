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
import model.Profile;

/**
 *
 * @author Admin
 */
public class Answer extends HttpServlet {
   
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
            out.println("<title>Servlet Answer</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Answer at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        DAO.INSTANCE.getAll();
        HttpSession ses = request.getSession();
        Profile userCur = (Profile) ses.getAttribute("user");
        String postId = request.getParameter("postId");
        try {
            int postId_INT = Integer.parseInt(postId);
            request.setAttribute("nestedComment", DAO.INSTANCE.getNestedComment(userCur, postId_INT));
        } catch (Exception e) {
            System.out.println(e);
        }
        request.setAttribute("dao", DAO.INSTANCE);
        request.getRequestDispatcher("Answer.jsp").forward(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String btnPost = request.getParameter("btnPost");
        String btnSubmitMain = request.getParameter("myCmt-submit-main"); // OK
        String btnSubmitSecond = request.getParameter("myCmt-submit-main");
        String btnAnswer = request.getParameter("btnAnswer");
        String btnAccepted = request.getParameter("btnAccepted");
        String btnUnAccepted = request.getParameter("btnUnAccepted");
        String btnUpdate = request.getParameter("btnUpdate");
        String btnUpdateAnswer = request.getParameter("btnUpdateAnswer");
        HttpSession ses = request.getSession();
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
        if (btnAnswer != null) {
            String userId = request.getParameter("userId");
            String postId = request.getParameter("postId");
            String answerText = request.getParameter("answerText");
            try {
                int userId_INT = Integer.parseInt(userId);
                int postId_INT = Integer.parseInt(postId);
                DAO.INSTANCE.addPost(2, answerText, userId_INT, "", postId_INT, 1);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        if (btnAccepted != null) {
            String acceptedId = request.getParameter("acceptedId");
            String postId = request.getParameter("postId");
            try {
                int acceptedId_INT = Integer.parseInt(acceptedId);
                int postId_INT = Integer.parseInt(postId);
                DAO.INSTANCE.updateAField(postId_INT, "AcceptedAnswerId", acceptedId_INT);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        if (btnUnAccepted != null) {
            String postId = request.getParameter("postId");
            try {
                int postId_INT = Integer.parseInt(postId);
                DAO.INSTANCE.updateAField(postId_INT, "AcceptedAnswerId", 0);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        if (btnUpdate != null) {
            String titleUpdate = request.getParameter("title-update");
            String bodyUpdate = request.getParameter("body-update");
            String postId = request.getParameter("postId");
            try {
                int postId_INT = Integer.parseInt(postId);
                DAO.INSTANCE.updatePost(postId_INT, titleUpdate, bodyUpdate);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        if (btnUpdateAnswer != null) {
            String titleAnsUpdate = request.getParameter("title-answer-update");
            String bodyAnsUpdate = request.getParameter("body-answer-update");
            String answerId = request.getParameter("answerId");
            try {
                int answerId_INT = Integer.parseInt(answerId);
                DAO.INSTANCE.updatePost(answerId_INT, titleAnsUpdate, bodyAnsUpdate);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        doGet(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

package controller;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.*;
import model.Comment;
import model.Post;
import model.Profile;

public class HomeServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HomeServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HomeServlet at " + request.getContextPath () + "</h1>");
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
        request.setAttribute("dao", DAO.INSTANCE);
        request.setAttribute("postList", DAO.INSTANCE.getPostList());
        request.setAttribute("profileList", DAO.INSTANCE.getProfileList());
        request.setAttribute("commentList", DAO.INSTANCE.getCommentList());
        request.setAttribute("nestedComment", DAO.INSTANCE.getNestedComment(userCur, 0));
        request.getRequestDispatcher("Home.jsp").forward(request, response);
    } 
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String btnPost = request.getParameter("btnPost");
        String btnSubmitMain = request.getParameter("myCmt-submit-main");
        String btnSubmitSecond = request.getParameter("myCmt-submit-main");
        String btnUpdate = request.getParameter("btnUpdate");
        String btnDelete = request.getParameter("btnDelete");
        String btnDelCmt = request.getParameter("btnDelCmt");
        String btnUpCmt = request.getParameter("btnUpCmt");
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
            String titleUpdate = request.getParameter("title-update");
            String bodyUpdate = request.getParameter("body-update");
            String postIdUpdate = request.getParameter("postId");
            try {
                int postIdUpdate_INT = Integer.parseInt(postIdUpdate);
                DAO.INSTANCE.updatePost(postIdUpdate_INT, titleUpdate, bodyUpdate);
            } catch (NumberFormatException e) {
                System.out.println(e);
            }
        }
        if (btnDelete != null) {
            String postIdUpdate = request.getParameter("postId");
            try {
                int postIdUpdate_INT = Integer.parseInt(postIdUpdate);
                DAO.INSTANCE.updateAField(postIdUpdate_INT, "DeletionDate", -1);
            } catch (NumberFormatException e) {
                System.out.println(e);
            }
        }
        /****************CMT************************/
        String cmtId = request.getParameter("cmtId");
        try {
            int cmtId_INT = Integer.parseInt(cmtId);
            if (btnDelCmt != null) {
                DAO.INSTANCE.deleteComment(cmtId_INT);
            }
            if (btnUpCmt != null) {
                
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

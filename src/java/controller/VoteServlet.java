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
import model.Vote;
import org.json.simple.JSONObject;

/**
 *
 * @author Admin
 */
public class VoteServlet extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet VoteServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet VoteServlet at " + request.getContextPath () + "</h1>");
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
        request.getRequestDispatcher("/Home").forward(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String btnLike = request.getParameter("btnLike");
        String btnDislike = request.getParameter("btnDislike");
        String userCurId = request.getParameter("userCurId");
        String postId = request.getParameter("postId");
        String voteType = request.getParameter("voteType");
        System.out.println(btnLike);
        System.out.println(userCurId);
        System.out.println(postId);
        System.out.println(voteType);
        try {
            int userCurId_INT = Integer.parseInt(userCurId);
            int postId_INT = Integer.parseInt(postId);
            int voteType_INT = Integer.parseInt(voteType);
            boolean isVote = DAO.INSTANCE.isVote(userCurId_INT, postId_INT, voteType_INT);
            System.out.println("isVote = " + isVote);
            if (btnLike != null) {
                if (!isVote) {
                    boolean isVoteDislike = DAO.INSTANCE.isVote(userCurId_INT, postId_INT, 2);
                    if (isVoteDislike) {
                        Vote v = DAO.INSTANCE.getVoteByAll(userCurId_INT, postId_INT, 2);
                        DAO.INSTANCE.deleteVote(v.getId(), 2, userCurId_INT);
                    }
                    DAO.INSTANCE.addVote(postId_INT, 1, userCurId_INT);
                }
            }
            if (btnDislike != null) {
                if(!isVote) {
                    boolean isVoteLike = DAO.INSTANCE.isVote(userCurId_INT, postId_INT, 1);
                    if (isVoteLike) {
                        Vote v = DAO.INSTANCE.getVoteByAll(userCurId_INT, postId_INT, 1);
                        DAO.INSTANCE.deleteVote(v.getId(), 1, userCurId_INT);
                    }
                    DAO.INSTANCE.addVote(postId_INT, 2, userCurId_INT);
                }
            }
            DAO.INSTANCE.getAll();
            int likeCount = DAO.INSTANCE.getLikeCount(postId_INT);
            int dislikeCount = DAO.INSTANCE.getDislikeCount(postId_INT);
            JSONObject json = new JSONObject();
            json.put("like", likeCount);
            json.put("dislike", dislikeCount);
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            response.getWriter().print(json);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

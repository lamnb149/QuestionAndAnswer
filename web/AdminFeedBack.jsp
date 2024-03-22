<%-- 
    Document   : AdminFeedBack.jsp
    Created on : Oct 25, 2023, 11:45:45 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/admin.css"/>
    </head>
    <body>
        <div class="container">
            <div class="left">
                <div><a href="Admin?des=1">Post</a></div>
                <div><a href="Admin?des=2">User</a></div>
                <div><a href="Admin?des=3">FeedBack</a></div>
            </div>
            <div class="right">
                <table>
                    <tr>
                        <th>ID</th>
                        <th>PostID</th>
                        <th>Body</th>
                        <th>Creation</th>
                    </tr>
                    <c:forEach items="${postFeedBackList}" var="pfb">
                        <tr>
                            <td>${pfb.id}</td>
                            <td><strong>${pfb.postId}</strong></td>
                            <td>${pfb.feedBack}</td>
                            <td>${pfb.creationDate}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
    </body>
</html>

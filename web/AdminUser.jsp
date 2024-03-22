<%-- 
    Document   : AdminUser.jsp
    Created on : Oct 25, 2023, 10:49:06 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
                        <th>Display Name</th>
                        <th>FullName</th>
                        <th>Username</th>
                        <th>isBaned</th>
                        <th>Action</th>
                        <th>Note</th>
                    </tr>
                    <c:forEach items="${profileList}" var="pr">
                        <tr>
                            <td>${pr.id}</td>
                            <td><strong>${pr.displayName}</strong></td>
                            <td>${pr.fullName}</td>
                            <td>${pr.username}</td>
                            <td>${pr.isBaned}</td>
                            <c:if test="${pr.isBaned == true}">
                                <td><a href="Admin?type=3&&userId=${pr.id}">UN-BAN</a></td>
                            </c:if>
                            <c:if test="${pr.isBaned == false}">
                                <td><a href="Admin?type=2&&userId=${pr.id}">BAN</a></td>
                            </c:if>
                            <td></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
    </body>
</html>

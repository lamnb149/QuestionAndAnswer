<%-- 
    Document   : Followed.jsp
    Created on : Oct 22, 2023, 4:20:45 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:forEach var="f" items="${followerList}">
            <c:if test="${f.followerId == param.userId}">
                <c:out value="${f.userId}"></c:out>
            </c:if>
        </c:forEach>
    </body>
</html>

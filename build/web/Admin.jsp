
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
                        <th>Title</th>
                        <th>Body</th>
                        <th>UserID</th>
                        <th>PostType</th>
                        <th>Action</th>
                        <th>NOTE</th>
                    </tr>
                    <c:forEach items="${postList}" var="p">
                        <c:if test="${p.deletionDate == null}">
                            <tr>
                                <td>${p.id}</td>
                                <td><strong>${p.title}</strong></td>
                                <td>${p.body}</td>
                                <td>${p.ownerUserId}</td>
                                <td>${p.postTypeId}</td>
                                <td><a href="Admin?type=1&&postId=${p.id}">DELETE</a></td>
                                <td></td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </table>
                
                
                
            </div>
        </div>
    </body>
</html>

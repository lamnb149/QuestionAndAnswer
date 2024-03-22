<%-- 
    Document   : Search.jsp
    Created on : Oct 25, 2023, 1:50:24 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/search.css"/>
    </head>
    <body>
        <div class="container-all">
        <div class="header">
            <div class="contain-search">
                <div class="search-style">
                    <form action="Search" method="post">
                        <img src="images/icons/search.png" alt="" class="img-search">
                        <input type="text" class="search-header" placeholder="Search anything...">
                    </form>
                </div>

            </div>
            <div class="info-header">
                <div class="container-dropdown">
                    <div class="dropdown">
                        <button class="dropbtn">
                            <img src="" class="avt-header">
                            <div>NAME</div>
                        </button>
                        <div class="dropdown-content">
                            <a href="Profile?userId=${sessionScope.user.id}">Profile</a>
                            <a href="Login?out=1">Log Out</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="left">
                <div class="left-text">
                    KET QUA TIM KIEM
                </div>
                <div class="left-icon">
                    <div class="icon">
                        <img src="" alt="">
                    </div>
                </div>
            </div>
            <div class="right">
                <div class="right-group boxdesign" boxdesign>
                    <div class="text-group">
                        NHOM
                    </div>
                    <div class="group">
                        <div class="image-group">
                            <img src="bg5.jpg" alt="">
                        </div>
                        <div class="type-name-group">
                            <div class="name-group">A Crazy Mind - Viết Để Trưởng Thành</div>
                            <div class="type-group">PRIVATE</div>
                        </div>
                    </div>
                </div>
                <div class="right-people boxdesign" boxdesign>
                    <div class="text-people">Mọi Người</div>
                    <c:forEach items="${requestScope.listProfileSearch}" var="p">
                        <div class="people">
                            <div class="img-people">
                                <a href="Profile?userId=${p.id}"><img src="${p.profileImage}" alt=""></a>
                            </div>
                            <div class="name-people">${p.displayName}</div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </body>
</html>

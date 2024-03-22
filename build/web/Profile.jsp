<%-- 
    Document   : Profile.jsp
    Created on : Oct 16, 2023, 9:32:40 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/profile.css">
        <link rel="stylesheet" href="css/home.css"/>
        <link rel="stylesheet" href="css/copy.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container-all">
            <div class="header">
                <div class="contain-search">
                    <div>
                        <form action="" method="">
                            <img src="images/icons8-search-64.png" alt="" class="img-search">
                            <input type="text" class="search-header" placeholder="Search anything...">
                        </form>
                    </div>
                </div>
                <div class="info-header">
                    <div class="header-noti">
                        NOTIFICATION
                    </div>
                    <div class="header-profile">
                        PROFILE
                    </div>
                </div>
            </div>
            <div class="profile">
                <div class="profile-background" style="background-image: url(${dao.getProfileById(param.userId).background});                           background-size: cover"></div>
                <div class="profile-info">
                    <div class="ghost-div-info">
                    </div>
                    <div class="profile-info-main">
                        <div class="post-title padding-style active">
                            <div class="text-style">
                                Post
                            </div>
                        </div>
                        <div class="about-title padding-style">
                            <button class="button-style">
                                <div class="text-style">
                                    About
                                </div>
                            </button>
                        </div>
                        <div class="follow-title padding-style">
                            <form action="Profile?userId=${param.userId}" method = "post">
                                <button type ='submit' name = 'FOLLOW' value="FOLLOW" class="button-style">
                                    <div class="text-style">
                                        Follow
                                    </div>
                                </button>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="break"></div>
                <div class="profile-post">
                    <div class="ghost-div">
                    </div>
                    <div class="profile-post-main">
                        <div class="total-post">
                            <c:forEach items="${dao.getPostList()}" var="p">
                                <c:if test="${(p.postTypeId == 3 || p.postTypeId == 1) && (p.ownerUserId == param.userId)}">
                                    <div class="div-post boxdesign">
                                        <div class="avt-name">
                                            <img src="${dao.getProfileById(p.ownerUserId).profileImage}" alt="" class="img-avt img-post">
                                            <div class="name-post">${dao.getProfileById(p.ownerUserId).displayName}</div>
                                            <div class="time-post">
                                                <c:set var="time" value="${dao.calcTime(p.creationDate)}"/>
                                                <c:if test="${(time >= 1440)}">
                                                    ${Math.ceil(time / 1440)} days ago
                                                    <c:set var="timeStr" value="${Math.ceil(time / 1440)} days ago"/>
                                                </c:if>
                                                <c:if test="${(time < 1440 && time >= 60)}">
                                                    ${Math.ceil(time / 60)} hours ago
                                                    <c:set var="timeStr" value="${Math.ceil(time / 60)} hours ago"/>
                                                </c:if>
                                                <c:if test="${(time < 60)}">
                                                    ${Math.ceil(time)} minutes ago
                                                    <c:set var="timeStr" value="${Math.ceil(time)} minutes ago"/>
                                                </c:if>
                                            </div>
                                        </div>
                                        <div class="title-post" style="margin: 2%;margin-top: 20px;">
                                            <strong>${p.title}</strong>
                                        </div>
                                        <div class="content-post">
                                            ${p.body}
                                        </div>
                                        <div class="image-post">
                                            Chua co
                                        </div>
                                        <div class="react-post">
                                            <div class="like">
                                                <a href="#">Like</a>
                                            </div>
                                            <div class="dislike">
                                                <a href="#">Dislike</a>
                                            </div>
                                            <div class="comment">
                                                <c:if test="${p.postTypeId == 1}">
                                                    <a href="#">Answer</a>
                                                </c:if>
                                                <c:if test="${p.postTypeId == 3}">
                                                    <button class="commentButton" id="commentButton" value="${p.id}">Comment</button>
                                                    <div id="commentModal" class="modal commentModal">
                                                        <div class="modal-content">
                                                            <div class="header-close">
                                                                <div class="header-comment">
                                                                    Blog of ${dao.getProfileById(p.ownerUserId).displayName}
                                                                </div>
                                                                <span class="close closeModal" id="closeModal">&times;</span>
                                                            </div>
                                                            <div class="comment-post">
                                                                <div class="avt-name">
                                                                    <img src="${dao.getProfileById(p.ownerUserId).profileImage}" alt="" class="img-avt img-post">
                                                                    <div class="name-post">${dao.getProfileById(p.ownerUserId).displayName}</div>
                                                                    <div class="time-post">
                                                                        ${pageScope.timeStr}
                                                                    </div>
                                                                </div>
                                                                <div class="title-post">
                                                                    <strong>${p.title}</strong>
                                                                </div>
                                                                <div class="content-post" id="content-post">
                                                                    ${p.body}
                                                                </div>
                                                                <div class="image-post">
                                                                    Chua co
                                                                </div>
                                                                <div class="react-post">
                                                                    <div class="like">
                                                                        <a href="#">Like</a>
                                                                    </div>
                                                                    <div class="dislike">
                                                                        <a href="#">Dislike</a>
                                                                    </div>
                                                                </div>
                                                                <!--comment-->
                                                                <c:out value="${requestScope.nestedComment[p.id]}" escapeXml="false"></c:out>
                                                                    <!--                                                        mycomment-->
                                                                    <div class="my-comment">
                                                                        <div class="my-comment-img">
                                                                            <img src="${sessionScope.user.profileImage}" alt="" class="img-avt img-post">
                                                                    </div>
                                                                    <div class="my-comment-content">
                                                                        <form action="Home" method="post" id="commentForm">
                                                                            <textarea id="commentText" name="myCmt-text-main" required></textarea>
                                                                            <input type = 'text' name = 'myCmt-userId-main' value = '${sessionScope.user.id}' hidden id="myCmt-userId-main">
                                                                            <input type = 'text' name = 'myCmt-postId-main' value = '${p.id}' hidden id="myCmt-postId-main" class="myCmt-postId-main">
                                                                            <input type="submit" name="myCmt-submit-main" value="Comment" class="submit-cmt">
                                                                        </form>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </c:if>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="break-post"></div>
                                </c:if>
                            </c:forEach>
                        </div>
                    </div>
                </div>
                <div class="left" id="left">
                    <div class="profile-left boxdesign">
                        <div class="left-image">
                            <img src="${dao.getProfileById(param.userId).profileImage}">
                            <c:if test="${sessionScope.user.id == param.userId}">
                                <div class="icon-update"><button class="update-button" id="update-button" onclick="showUpdateModal()">UPDATE</button></div>
                            </c:if>
                        </div>
                        <div class="left-changepass" style="text-align: center">
                            <c:if test="${sessionScope.user.id == param.userId}">
                                <div class="icon-update"><button class="update-button" id="change-button" onclick="showChangePassModal()">CHANGE PASSWORD</button></div>
                            </c:if>
                        </div>
                        <div class="left-name"><strong>${dao.getProfileById(param.userId).displayName}</strong></div>
                        <div class="left-follow">FOLLOW</div>
                    </div>
                    <div class="break"></div>
                    <div class="basic-left boxdesign">
                        <c:if test="${sessionScope.user.id == param.userId}"> <!--de tam-->
                            <form id="imageForm" action="Profile?userId=${param.userId}" method="post">
                                <input type="file" name="urlAvt" id="imageInput" accept="image/*"> IMG
                            </form>
                            <form id="backgroundForm" action="Profile?userId=${param.userId}" method="post">
                                <input type="file" name="urlBack" id="backgroundInput" accept="image/*"> BACKGROUND
                            </form>
                        </c:if>
                        <div class="title-basic-left">BASIC INFO</div>
                        <div class="school">SCHOOL</div>
                        <div class="cirrcu">CURRCU</div>
                        <div class="datejoin">JOIN</div>
                    </div>
                    <div class="break"></div>
                    <div class="photo-left boxdesign">
                        PHOTO
                    </div>
                    <div class="break"></div>
                    <div class="friend-left boxdesign">
                        FRIEND
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="modalUpdate" id="updateModal">
        <div class="modal-content-update">
            <span class="closeModalUpdate" id="closeModalUpdate">&times;</span>
            <form action="Profile?userId=${param.userId}" method="post">
                <table>
                    <tr>
                        <td><label for="displayName">Display Name:</label></td>
                        <td><input type="text" id="displayName" name="displayName" required value="${dao.getProfileById(param.userId).displayName}"></td>
                    </tr>
                    <tr>
                        <td><label for="location" >Location:</label></td>
                        <td><input type="text" id="location" name="location" value="${dao.getProfileById(param.userId).location}"></td>
                    </tr>
                    <tr>
                        <td><label for="aboutMe">About Me:</label></td>
                        <td><textarea id="aboutMe" name="aboutMe">${dao.getProfileById(param.userId).aboutMe}</textarea></td>
                    </tr>
                    <tr>
                        <td><label for="gender">Gender:</label></td>
                        <td>
                            <select id="gender" name="gender">
                                <option value="male">Male</option>
                                <option value="female">Female</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="dob" >Date of Birth:</label></td>
                        <td><input type="date" id="dob" name="dob" value="${dao.getProfileById(param.userId).dob}"></td>
                    </tr>
                    <tr>
                        <td><label for="fullName">Full Name:</label></td>
                        <td><input type="text" id="fullName" name="fullName" value="${dao.getProfileById(param.userId).fullName}"></td>
                    </tr>
                    <tr>
                        <td><label for="phoneNumber">Phone Number:</label></td>
                        <td><input type="text" id="phoneNumber" name="phoneNumber" value="${dao.getProfileById(param.userId).phoneNumber}"></td>
                    </tr>
                </table>
                <input type="submit" value="Submit" name="btnUpdate">
            </form>
        </div>
    </div>
    <div class="modalUpdate" id="changePassModal">
        <div class="modal-content-update">
            <span class="closeModalUpdate" id="closeModalChangePass">&times;</span>
            <form action="" method="" id="formChangePass">
                <div id="msgChangePass"></div>
                <table>
                    <tr>
                        <td><label for="oldPassword">Old Password:</label></td>
                        <td><input type="password" id="oldPassword" name="oldPassword" required onkeypress="removeMsg()"></td>
                    </tr>
                    <tr>
                        <td><label for="newPassword">New Password:</label></td>
                        <td><input type="password" id="newPassword" name="newPassword" required onkeypress="removeMsg()"></td>
                    </tr>
                    <tr>
                        <td><label for="reNewPassword">Renew Password:</label></td>
                        <td><input type="password" id="reNewPassword" name="reNewPassword" required onkeypress="removeMsg()"></td>
                    </tr>
                </table>
                <button type="button" value="Submit" name="btnChangePass" onclick="checkFormChangePass(${param.userId})">CHANGE PASS</button>
            </form>
        </div> 
    </div>
    <script src="js/profile.js"></script>
</body>
</html>

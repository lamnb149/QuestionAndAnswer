<%-- 
    Document   : Answer.jsp
    Created on : Oct 22, 2023, 10:12:31 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/answer.css">
        <link rel="stylesheet" href="css/home.css"/>

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
                    <div>
                        <c:if test="${sessionScope.user == null}">
                            <form action="Login" method="get">
                                <input type ='submit' name = 'SIGNIN' value = 'SIGN IN'>
                            </form>
                        </c:if>
                    </div>
                    <div>
                        <div>
                            <a href="Login?out=1">LOGOUT</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container-bottom">
                <div class="content-left">
                    <div class="icon">ICON</div>
                    <div class="icon">ICON</div>
                    <div class="icon">ICON</div>
                    <div class="icon">ICON</div>
                </div>
                <div class="content-main">
                    <div class="boxdesign div-post" style="margin-top: 8%;">
                        <div class="avt-name">
                            <img src="${dao.getProfileById(param.ownerUserId).profileImage}" alt="" class="img-avt img-post">
                            <div class="name-post">${dao.getProfileById(param.ownerUserId).displayName}</div>
                            <div class="time-post">
                                <c:set var="time" value="${dao.calcTime(dao.getPostById(param.postId).creationDate)}"/>
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
                            <c:if test="${sessionScope.user.id == param.ownerUserId}">
                                <div class="update-post"><button class="update-button" id="update-button" onclick="showModelUpdate()">UPDATE</button></div>
                                <div class="modalUpdate" id="updateModal">
                                    <div class="modal-content-update">
                                        <span class="closeModalUpdate" id="closeModalUpdate">&times;</span>
                                        <form action="Answer?postId=${param.postId}&&ownerUserId=${param.ownerUserId}" method="post">    
                                            <input type="text" value="${param.postId}" hidden>
                                            <table>
                                                <tr>
                                                    <td><label for="title-update">Title: </label></td>
                                                    <td><input type="text" id="title-update" name="title-update"></td>
                                                </tr>
                                                <tr>
                                                    <td><label for="body-update">Body: </label></td>
                                                    <td><textarea id="body-update" name="body-update"></textarea></td>
                                                </tr>
                                            </table>
                                            <input type="submit" value="Submit" name="btnUpdate">
                                        </form>
                                    </div>
                                </div>
                            </c:if>
                        </div>
                        <div class="title-post" style="margin: 2%;margin-top: 20px;">
                            <strong>${dao.getPostById(param.postId).title}</strong>
                        </div>
                        <div class="content-post">
                            ${dao.getPostById(param.postId).body}
                        </div>
                        <div class="image-post">
                        </div>
                        <div class="react-post">
                            <div class="like">
                                <button data-like>Like</button>
                                <div id="likeCount">0</div>
                            </div>
                            <div class="dislike">
                                <button data-dislike>Dislike</button>
                                <div id="dislikeCount">0</div>
                            </div>
                            <div class="reply">
                                <button id="btnReplyMain" onclick="showAnswerModal()">ANSWER</button>
                            </div>
                        </div>
                    </div>
                    <div class="break"></div>
                    <div class="content">
                        <div class="">
                            <c:forEach items="${dao.getPostList()}" var="p">
                                <c:if test="${(p.postTypeId == 2) && (p.parentId == param.postId)}">
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
                                                <c:if test="${sessionScope.user.id == param.ownerUserId && dao.getPostById(param.postId).acceptedAnswerId == p.id}">
                                                    <div class="acceptedAnswer">
                                                    <form action="Answer?postId=${param.postId}&&ownerUserId=${param.ownerUserId}" method = "post">
                                                        <input name="postId" value="${param.postId}" hidden>
                                                        <input type="submit" value="UNACCEPTED" name="btnUnAccepted">
                                                    </form>
                                                </div>
                                            </c:if>
                                            <c:if test="${sessionScope.user.id == param.ownerUserId && dao.getPostById(param.postId).acceptedAnswerId == 0}">
                                                <div class="acceptedAnswer">
                                                    <form action="Answer?postId=${param.postId}&&ownerUserId=${param.ownerUserId}" method = "post">
                                                        <input name="acceptedId" value="${p.id}" hidden>
                                                        <input name="postId" value="${param.postId}" hidden>
                                                        <input type="submit" value="ACCEPTED" name="btnAccepted">
                                                    </form>
                                                </div>
                                            </c:if>

                                        </div>
                                        <div class="title-post" style="margin: 2%;margin-top: 20px;">
                                            <strong>${p.title}</strong>
                                        </div>
                                        <div class="content-post">
                                            ${p.body}
                                        </div>
                                        <div class="image-post">
                                        </div>
                                        
                                        <div class="react-post">
                                            <div class="like">
                                                <a href="#">Like</a>
                                            </div>
                                            <div class="dislike">
                                                <a href="#">Dislike</a>
                                            </div>
                                            <c:if test="${sessionScope.user.id == p.ownerUserId}">
                                                <div class="update">
                                                    <button onclick="showUpdateAnswerModal(${p.id})">UPDATE</button>
                                                </div>
                                            </c:if>
                                            <div class="comment">
                                                <c:if test="${p.postTypeId == 2}">
                                                    <button class="commentButton" id="commentButton" value="${p.id}" onclick="showModelComment()">Comment</button>
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
                                                                        <form action="Answer?postId=${param.postId}&&ownerUserId=${param.ownerUserId}" method="post" id="commentForm">
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
                                    <div class="break"></div>
                                </c:if>
                            </c:forEach>
                            <div class="answer">

                            </div>
                        </div>
                    </div>

                </div>
                <div class="content-right">
                    <div class="quest-related">RELATED QUEST</div>
                    <div class="quest-tag">QUEST TAGS</div>
                </div>
            </div> 

        </div>

        <div class="modalUpdateDevide">
            <div class="modalUpdate" id="updateModal">
                <div class="modal-content-update">
                    <span class="closeModalUpdate" id="closeModalUpdate">&times;</span>
                    <form action="Answer?postId=${p.id}" method="post">    
                        <table>
                            <tr>
                                <td><label for="title-update">Title: </label></td>
                                <td><input type="text" id="title-update" name="title-update"></td>
                            </tr>
                            <tr>
                                <td><label for="body-update">Body: </label></td>
                                <td><textarea id="body-update" name="body-update"></textarea></td>
                            </tr>
                        </table>
                        <input type="submit" value="Submit" name="btnUpdate">
                    </form>
                </div>
            </div>
        </div>
        <div id="answerModal" class="modalAnswer">
            <div class="modal-content-answer">
                <span class="closeAnswer" id="closeAnswerModal">&times;</span>
                <form action="Answer?postId=${param.postId}&&ownerUserId=${param.ownerUserId}" method="post">
                    <div class="form-container">
                        <div class="name-picture">
                            <img src="${sessionScope.user.profileImage}" class="picture">
                            <h2 class="commenter-name">${sessionScope.user.displayName}</h2>
                        </div>
                        <div class="body-question">
                            <h2>${dao.getPostById(param.postId).title}</h2>
                        </div>
                            <textarea id="answerText" name="answerText" class="answer-text" required></textarea>
                            <input type = 'text' name = 'userId' value = '${sessionScope.user.id}' hidden>
                            <input type = 'text' name = 'postId' value = '${param.postId}' hidden>
                    </div>
                    <input type="submit" value="Submit" name="btnAnswer" class="submit-button">
                </form>
            </div>
        </div>
        <div id="updateAnswerModal" class="modalAnswer">
            <div class="modal-content-answer">
                <span class="closeAnswer" id="closeUpdateAnswerModal">&times;</span>
                <form action="" method="post" id="updateAnswerForm">
                    <div class="form-container">
                        <input type="text" value="" id="answerId" name="answerId" hidden>
                        <table>
                            <tr>
                                <td><label for="title-answer-update">Title: </label></td>
                                <td><input type="text" id="title-answer-update" name="title-answer-update"></td>
                            </tr>
                            <tr>
                                <td><label for="body-answer-update">Body: </label></td>
                                <td><textarea id="body-answer-update" name="body-answer-update"></textarea></td>
                            </tr>
                        </table>
                    </div>
                    <input type="submit" value="Update Answer" name="btnUpdateAnswer" class="submit-button">
                </form>
            </div>
        </div>
<!--        <div id="updateCommentModal" class="modalComment">
            <div class="modal-content-comment">
                <span class="closeComment" id="closeUpdateCommentModal">&times;</span>
                <form action="" method="post" id="updateCommentForm">
                    <div class="form-container">
                        <input type="text" value="" id="answerId" name="answerId" hidden>
                        <table>
                            <tr>
                                <td><label for="text-comment-update">Body: </label></td>
                                <td><textarea id="body-answer-update" name="text-comment-update"></textarea></td>
                            </tr>
                        </table>
                    </div>
                    <input type="submit" value="Update Comment" name="btnUpdateComment" class="submit-button">
                </form>
            </div>
        </div>-->
        <script type="text/javascript" src="js/answer.js"></script>
    </body>
</html>

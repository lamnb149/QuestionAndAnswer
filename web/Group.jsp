<%-- 
    Document   : Group.jsp
    Created on : Oct 25, 2023, 7:29:22 AM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/group.css"/>
        <link rel="stylesheet" href="css/home.css"/>
    </head>
    <body>
        <div class="container-all">
            <div class="header">
                <div class="contain-search">
                    <div class="search-style">
                        <form action="" method="">
                            <img src="images/icons/search.png" alt="" class="img-search">
                            <input type="text" class="search-header" placeholder="Search anything...">
                        </form>
                    </div>

                </div>
                <div class="info-header">
                    <div class="container-dropdown">
                        <div class="dropdown">
                            <button class="dropbtn">
                                <img src="${sessionScope.user.profileImage}" class="avt-header">
                                <div>${sessionScope.user.displayName}</div>
                            </button>
                            <div class="dropdown-content">
                                <a href="">Profile</a>
                                <a href="">Log Out</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="container">
                <div class="left">
                    <div class="return">RETURN</div>
                    <div class="name">NAME GROUP</div>
                    <div class="group">
                        <div class="home-group">HOME GROUP</div>
                        <div class="member-group">FRIEND GROUP</div>
                    </div>
                </div>
                <div class="right">
                    <div class="top-right box-design">
                        <div class="background">
                            <img src="bg5.jpg">
                        </div>
                        <div class="description">
                            <div class="name-descrip">
                                <h2>UI/UX Design Community</h2>
                            </div>
                            <div class="icon-descrip">
                                <div>
                                    ICON
                                </div>
                                <div class="count-member">
                                    MEMBER
                                </div>
                            </div>
                            <div class="text-descrip">
                                Lorem ipsum dolor sit amet consectetur adipisicing elit. Quis quam, exercitationem
                                reiciendis veniam alias iure id laboriosam harum voluptate explicabo autem quas ipsum
                                repellat aliquam in beatae cupiditate vel nemo?
                            </div>
                            <div class="admin-descrip">
                                <div style="margin-top: 10px;">ADMIN</div>
                                <div class="user-admin">
                                    <div>PER1</div>
                                    <div>PER1</div>
                                    <div>PER1</div>
                                    <div>PER1</div>
                                </div>

                            </div>
                        </div>
                    </div>
                    <div class="mid-right">
                        <div class="post-mid-group">POST_MID</div>
                        <div class="member-mid-group">MEMBER_MID</div>
                    </div>
                    <div class="bot-right">
                        <div class="total-post">
                            <div class="div-3_1 boxdesign">
                                <form action="Group?groupId=${param.groupId}" method="post">
                                    <div class="write">
                                        <input type = 'text' name = 'owner-p' value = '${sessionScope.user.id}' hidden>
                                        <img src="${sessionScope.user.profileImage}" alt="" class="personal-img img-post">
                                        <div class="write-text">
                                            <input class="title-per" type="text" placeholder="Title" class="title" hidden 
                                                   name="title-p" autocomplete="off">
                                            <input type="text" placeholder="Share something..." name="body-p" autocomplete="off">
                                        </div>
                                    </div>

                                    <div class="break-text"></div>
                                    <div class="act">
                                        <input type="file" id="uploadImage">
                                        <div onclick="removeHidden()" class="hideTitle"><img src="images/icons/letter-t-.png" alt=""/></div>
                                        <select name="post_type">
                                            <option value="Blog" selected>Blog</option>
                                            <option value="Question">Question</option>
                                        </select>
                                    </div>
                                    <input type="submit" value="Post" name="btnPost" class="postDesign">
                                </form>
                            </div>
                                        <div class="break"></div>
                            <c:forEach items="${requestScope.postList}" var="p">
                                <c:if test="${(p.postTypeId == 3 || p.postTypeId == 1) && p.deletionDate == null && p.groupId == param.groupId}">
                                    <div class="div-post" style="background-color: #F1F2F4;">
                                        <div class="boxdesign">
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

                                                <c:if test="${sessionScope.user.id == p.ownerUserId}">
                                                    <div class="update-post"><button class="update-button" onclick="showModelUpdate()">UPDATE</button></div>
                                                    <div class="modalUpdate" id="updateModal">
                                                        <div class="modal-content-update">
                                                            <span class="closeModalUpdate" id="closeModalUpdate">&times;</span>
                                                            <form action="Home?postId=${p.id}" method="post">    
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
                                                    <div class="delete-post">
                                                        <form action="Home?postId=${p.id}" method = "post">
                                                            <input type ='submit' name = 'btnDelete' value = 'DELETE'>
                                                        </form>
                                                    </div>
                                                </c:if>

                                            </div>
                                            <div class="tag-post">
                                                <div class="show-tag">
                                                    <c:forEach items="${dao.postTagList}" var="t">
                                                        <c:if test="${t.postId == p.id}">
                                                            <c:out value="${dao.getNameTagById(t.tagId)}"></c:out>
                                                        </c:if>
                                                    </c:forEach>
                                                </div>
                                                <div class="action-tag">
                                                    <div class="add-tag">
                                                        <form action="Tag" method="post">
                                                            <input type = 'text' name = 'postId' value = '${p.id}' hidden>
                                                            <select id="id" name="all-tag">
                                                                <c:forEach items="${dao.tagList}" var="t">
                                                                    <option value="${t.id}">${dao.getNameTagById(t.id)}</option>
                                                                </c:forEach>
                                                            </select>
                                                            <input type ='submit' name = 'btnAddTag' value = 'Add Tag'>
                                                        </form>
                                                    </div>
                                                    <div class="remove-tag">
                                                        <form action="Tag" method="post">
                                                            <input type = 'text' name = 'postId' value = '${p.id}' hidden>
                                                            <select id="id" name="tag-available">
                                                                <c:forEach items="${dao.postTagList}" var="pt">
                                                                    <c:if test="${pt.postId == p.id}">
                                                                        <option value="${pt.tagId}">${dao.getNameTagById(pt.tagId)}</option>
                                                                    </c:if>
                                                                </c:forEach>
                                                            </select>
                                                            <input type ='submit' name = 'btnRemoveTag' value = 'Remove Tag'>
                                                        </form>
                                                    </div>
                                                </div>

                                            </div>


                                            <div class="title-post" style="margin: 2%;margin-top: 20px;">
                                                <strong>${p.title}</strong>
                                            </div>
                                            <div class="content-post">
                                                ${p.body}
                                            </div>
                                            <c:if test="${p.postTypeId == 3}">
                                                <c:if test="${p.id == 4}">
                                                    <div class="image-post">
                                                        <div><img src="images/imageposts/img_post_4(1).jpg" alt=""/></div>
                                                        <div><img src="images/imageposts/img_post_4(2).jpg" alt=""/></div>
                                                    </div>
                                                </c:if>

                                            </c:if>

                                            <div class="react-post" id="react-post-${p.id}">
                                                <div class="like" >
                                                    <form action="" method="" id="form-like${p.id}">
                                                        <input type="text" name="userCurId" value="${sessionScope.user.id}" hidden>
                                                        <input type="text" name="postId" value="${p.id}" hidden>
                                                        <input type="text" name="voteType" value="1" hidden>
                                                        <input type="text" name="actionVote" value="${dao.getActionVoteUser(sessionScope.user.id, p.id)}" hidden>
                                                        <button type ='button' name = 'btnLike' value = 'LIKE' class="icon-container" onclick="showLike(${p.id})" id="likeButton${p.id}">
                                                            <img src="images/icons/heart.png" alt="" class="img-icon"/>
                                                        </button>
                                                    </form>
                                                    <div id="likeCount${p.id}">${dao.getLikeCount(p.id)}</div>
                                                </div>
                                                <div class="dislike">
                                                    <form action="" method="" id="form-dislike${p.id}">
                                                        <input type="text" name="userCurId" value="${sessionScope.user.id}" hidden>
                                                        <input type="text" name="postId" value="${p.id}" hidden>
                                                        <input type="text" name="voteType" value="0" hidden>
                                                        <button type ='button' name = 'btnDislike' value = 'DISLIKE' class="icon-container dislikeButton" onclick="showDislikeLike(${p.id})" id="dislikeButton{
                                                                    p.id
                                                                }">
                                                            <img src="images/icons/dislike.png" alt="" class="img-icon"/>
                                                        </button>
                                                    </form>
                                                    <div id="dislikeCount${p.id}">${dao.getDislikeCount(p.id)}</div>
                                                </div>
                                                <div class="comment">
                                                    <c:if test="${p.postTypeId == 1}">
                                                        <a href="Answer?postId=${p.id}&&ownerUserId=${p.ownerUserId}">Answer</a>
                                                    </c:if>
                                                    <c:if test="${p.postTypeId == 3}">
                                                        <div class="comment-react">
                                                            <button class="commentButton icon-container" id="commentButton" value="${p.id}">
                                                                <img src="images/icons/comment.png" alt="" class="img-icon"/>
                                                            </button>
                                                            <div id="cmtCount">0</div>
                                                        </div>
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
                                                                            <a href="#" class="like-text">Like</a>
                                                                        </div>
                                                                        <div class="dislike">
                                                                            <a href="#" class="dislike-text">Dislike</a>
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
                                    </div>
                                    <div class="break"></div>
                                </c:if>
                            </c:forEach>
                        </div>
                        <div class="bonus-info">
                            <div class="private">PRIVATE</div>
                            <div class="visible">VISIBLE</div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <div class="modalCmtUpdate" id="updateCmtModal">
            <div class="modal-cmt-content-update">
                <span class="closeModalCmtUpdate" id="closeModalCmtUpdate">&times;</span>
                <form action="Home" method="post">    
                    <table>
                        <tr>
                            <td><label for="title-update-cmt">Title: </label></td>
                            <td><input type="text" id="title-update-cmt" name="title-update-cmt"></td>
                        </tr>
                        <tr>
                            <td><label for="body-update-cmt">Body: </label></td>
                            <td><textarea id="body-update-cmt" name="body-update-cmt"></textarea></td>
                        </tr>
                    </table>
                    <input type="submit" value="Submit" name="btnUpdateCmt">
                </form>
            </div>
        </div>
        <script type="text/javascript" src="js/home.js"></script>
        <script type="text/javascript" src="js/outer.js"></script>
    </body>
</html>

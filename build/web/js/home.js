var flag = true;
function removeHidden() {
    var input = document.getElementsByClassName("title-per")[0];
    var div_3_1 = document.getElementsByClassName("div-3_1")[0];
    if (flag) {
        input.removeAttribute("hidden");
        div_3_1.style.height = "200px";
    } else {
        input.setAttribute("hidden", "true");
        div_3_1.style.height = "150px";
    }
    flag = !flag;
}

var commentButtons = document.querySelectorAll(".commentButton");
var closeModals = document.querySelectorAll(".closeModal");
var replyClicks = document.querySelectorAll(".replyClick");
var childComments = document.querySelectorAll(".childComment");
var commentModals = document.querySelectorAll(".commentModal");
var flagHideChildComment = true;
flagHideChildComment = !flagHideChildComment;

var userId = document.getElementById("myCmt-userId-main").value;

//var marginLeftLevel = 35;
//var wAvtCommentDif = 35;
//var numberOfLevels = 10;


commentButtons.forEach(function (button, index) {
    button.addEventListener("click", function () {
        commentModals[index].style.display = "block";
//        var avtComment = document.getElementById("avt-comment");
//        var wAvtComment = avtComment.offsetWidth;
//        var marginLeftLevel = wAvtComment + 'px';
//        var avtCommentDif = document.getElementById("avtCommentDif");
//        var wAvtCommentDif = avtCommentDif.offsetWidth;
        var forms = commentModals[index].querySelectorAll(".myCmt-userId-second");
        for (var i = 0; i < forms.length; i++) {
            var form = forms[i];
            form.value = userId;
        }
        var postIdInput = commentModals[index].querySelector(".myCmt-postId-main");
        postIdValue = postIdInput.value;
        var _forms = commentModals[index].querySelectorAll(".myCmt-postId-second");
        for (var i = 0; i < forms.length; i++) {
            var form = _forms[i];
            form.value = postIdValue;
        }
        
        closeModals[index].onclick = function () {
            commentModals[index].style.display = "none";
        };

        replyClicks[index].onclick = function () {
            if (flagHideChildComment) {
                childComments[index].style.display = "block";
                flagHideChildComment = !flagHideChildComment;
            } else {
                childComments[index].style.display = "none";
                flagHideChildComment = !flagHideChildComment;
            }
        };
        window.onclick = function (event) {
            if (event.target == commentModals[index]) {
                commentModals[index].style.display = "none";
            }
        };
    });
});

function showComment(commentId) {
    var mainForm = document.getElementById("main-form-" + commentId);
    if (mainForm.style.display === "none" || mainForm.style.display === "") {
        mainForm.style.display = "block";
    } else {
        mainForm.style.display = "none";
    }
}

//function showUpdateCmt(commentId) {
//    var modalsUpdate = document.querySelectorAll(".modalCmtUpdate")[0];
//    var updateButtons = document.querySelectorAll(".btnUpdateCmt");
//    var closeModals = document.querySelectorAll(".closeModalCmtUpdate")[0];
//    
//    function showModal(index) {
//        modalsUpdate[index].style.display = "block";
//    }
//
//    function hideModal(index) {
//        modalsUpdate[index].style.display = "none";
//    }
//    
//    updateButtons.forEach(function(button, index) {
//        button.addEventListener("click", function () {
//            showModal(index);
//        });
//        closeModals[index].addEventListener("click", function () {
//            hideModal(index);
//        });
//        window.addEventListener("click", function (event) {
//            if (event.target == modalsUpdate[index]) {
//                modalsUpdate[index].style.display = "none";
//            }
//        });
//    });
//}

function showModelUpdate() {
    var modalsUpdate = document.querySelectorAll(".modalUpdate");
    var updateButtons = document.querySelectorAll(".update-button");
    var closeModals = document.querySelectorAll(".closeModalUpdate");
    
    function showModal(index) {
        modalsUpdate[index].style.display = "block";
    }

    function hideModal(index) {
        modalsUpdate[index].style.display = "none";
    }
    
    updateButtons.forEach(function(button, index) {
        button.addEventListener("click", function () {
            showModal(index);
        });
        closeModals[index].addEventListener("click", function () {
            hideModal(index);
        });
        window.addEventListener("click", function (event) {
            if (event.target == modalsUpdate[index]) {
                modalsUpdate[index].style.display = "none";
            }
        });
    });
}

function showModalFeedback() {
    var modalsFeedback = document.querySelectorAll(".modalFeedback");
    var feedbackButtons = document.querySelectorAll(".feedback-button");
    var closeModals = document.querySelectorAll(".closeModalFeedback");
    
    function showModal(index) {
        modalsFeedback[index].style.display = "block";
    }

    function hideModal(index) {
        modalsFeedback[index].style.display = "none";
    }
    
    feedbackButtons.forEach(function(button, index) {
        button.addEventListener("click", function () {
            showModal(index);
        });
        closeModals[index].addEventListener("click", function () {
            hideModal(index);
        });
        window.addEventListener("click", function (event) {
            if (event.target == modalsFeedback[index]) {
                modalsFeedback[index].style.display = "none";
            }
        });
    });
}

function showLike(postId) {
    var form = document.getElementById("form-like"+postId);
    var buttonLike = document.getElementById("likeButton"+postId);
    var buttonDislike = document.getElementById("dislikeButton"+postId);
    var postId = postId;
    var userCurId = form.userCurId.value;
    var likeCur = document.getElementById("likeCount"+postId);
    var dislikeCur = document.getElementById("dislikeCount"+postId);
    var url = "Vote?btnLike=1&&postId=" + postId + "&&userCurId=" + userCurId + "&&voteType=1";
    xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            let data = JSON.parse(xhttp.responseText);
            let like = data.like;
            let dislike = data.dislike;
            likeCur.innerHTML = like;
            dislikeCur.innerHTML = dislike;
        }
    }
    xhttp.open("POST", url, true);
    xhttp.send();
}

function showDislikeLike(postId) {
    var form = document.getElementById("form-dislike"+postId);
    var postId = postId;
    var userCurId = form.userCurId.value;
    var likeCur = document.getElementById("likeCount"+postId);
    var dislikeCur = document.getElementById("dislikeCount"+postId);
    var url = "Vote?btnDislike=1&&postId=" + postId + "&&userCurId=" + userCurId + "&&voteType=2";
    xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            let data = JSON.parse(xhttp.responseText);
            let like = data.like;
            let dislike = data.dislike;
            likeCur.innerHTML = like;
            dislikeCur.innerHTML = dislike;
        }
    }
    xhttp.open("POST", url, true);
    xhttp.send();
}













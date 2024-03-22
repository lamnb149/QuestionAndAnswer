function showModelUpdate() {
    var modalUpdate = document.getElementById("updateModal");
    var updateButton = document.querySelector(".update-button");
    var closeModal = document.getElementById("closeModalUpdate");

    function showModal() {
        modalUpdate.style.display = "block";
    }

    function hideModal() {
        modalUpdate.style.display = "none";
    }

    showModal();

    closeModal.addEventListener("click", function () {
        hideModal();
    });

    window.addEventListener("click", function (event) {
        if (event.target == modalUpdate) {
            hideModal();
        }
    });
}

function showModelComment() {
    var commentButtons = document.querySelectorAll(".commentButton");
    var closeModals = document.querySelectorAll(".closeModal");
    var replyClicks = document.querySelectorAll(".replyClick");
    var childComments = document.querySelectorAll(".childComment");
    var commentModals = document.querySelectorAll(".commentModal");
    var flagHideChildComment = true;
    flagHideChildComment = !flagHideChildComment;

    var userId = document.getElementById("myCmt-userId-main").value;
    var urlParams = new URLSearchParams(window.location.search);
    var postId = urlParams.get("postId");
    var ownerUserId = urlParams.get("ownerUserId");

    commentButtons.forEach(function (button, index) {
        button.addEventListener("click", function () {
            commentModals[index].style.display = "block";
            commentModals[index].style.zIndex = "2";
            var commentForms = document.querySelectorAll(".commentFormDif");
            commentForms.forEach(function (commentForm) {
                commentForm.action = "/SocialNetwork/Answer?postId=" + postId + "&&ownerUserId=" + ownerUserId;
            });
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
                document.getElementById("left").style.display = "block";
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
}

function showComment(commentId) {
    var mainForm = document.getElementById("main-form-" + commentId);
    if (mainForm.style.display === "none" || mainForm.style.display === "") {
        mainForm.style.display = "block";
    } else {
        mainForm.style.display = "none";
    }
}

function showAnswerModal() {
    var answerModal = document.getElementById("answerModal");
    var closeAnswerModal = document.getElementById("closeAnswerModal");

    function showModal() {
        answerModal.style.display = "block";
    }

    function hideModal() {
        answerModal.style.display = "none";
    }

    showModal();

    closeAnswerModal.addEventListener("click", function () {
        hideModal();
    });

    window.addEventListener("click", function (event) {
        if (event.target == answerModal) {
            hideModal();
        }
    });
}

function showUpdateAnswerModal(answerId) {
    var updateAnswerModal = document.getElementById("updateAnswerModal");
    var closeUpdateAnswerModal = document.getElementById("closeUpdateAnswerModal");

    function showModal() {
        updateAnswerModal.style.display = "block";
    }

    function hideModal() {
        updateAnswerModal.style.display = "none";
    }

    showModal();

    closeUpdateAnswerModal.addEventListener("click", function () {
        hideModal();
    });

    window.addEventListener("click", function (event) {
        if (event.target == updateAnswerModal) {
            hideModal();
        }
    });
    
    var urlParams = new URLSearchParams(window.location.search);
    var postId = urlParams.get("postId");
    var userOwnerId = urlParams.get("ownerUserId");
    document.getElementById("answerId").value = answerId;
    let updateAnswerF = document.getElementById("updateAnswerForm");
    updateAnswerF.action = "/SocialNetwork/Answer?postId=" + postId + "&&ownerUserId=" + userOwnerId;
}

//function showUpdateCmt(cmtId) {
//    var updateCommentModal = document.getElementById("updateAnswerModal");
//    var closeUpdateCommentModal = document.getElementById("closeUpdateAnswerModal");
//
//    function showModal() {
//        updateCommentModal.style.display = "block";
//    }
//
//    function hideModal() {
//        updateCommentModal.style.display = "none";
//    }
//
//    showModal();
//
//    closeUpdateCommentModal.addEventListener("click", function () {
//        hideModal();
//    });
//
//    window.addEventListener("click", function (event) {
//        if (event.target == updateCommentModal) {
//            hideModal();
//        }
//    });
//    
//    var urlParams = new URLSearchParams(window.location.search);
//    var postId = urlParams.get("postId");
//    var userOwnerId = urlParams.get("ownerUserId");
////    document.getElementById("cmtId").value = cmtId;
//    var updateAnswerForms = document.querySelectorAll(".editComment");
//    updateAnswerForms.forEach(function(form) {
//        form.action = "/SocialNetwork/Answer?postId=" + postId + "&&ownerUserId=" + userOwnerId;    
//    });
//}





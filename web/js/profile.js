var commentButtons = document.querySelectorAll(".commentButton");
var closeModals = document.querySelectorAll(".closeModal");
var replyClicks = document.querySelectorAll(".replyClick");
var childComments = document.querySelectorAll(".childComment");
var commentModals = document.querySelectorAll(".commentModal");
var flagHideChildComment = true;
flagHideChildComment = !flagHideChildComment;

var userId = document.getElementById("myCmt-userId-main").value;
var urlParams = new URLSearchParams(window.location.search);
var userId = urlParams.get("userId");

commentButtons.forEach(function (button, index) {
    button.addEventListener("click", function () {
        commentModals[index].style.display = "block";
        commentModals[index].style.zIndex = "2";
        var commentForms = document.querySelectorAll(".commentFormDif");
        commentForms.forEach(function (commentForm) {
            commentForm.action = "/SocialNetwork/Profile?userId=" + userId;
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

function showComment(commentId) {
    var mainForm = document.getElementById("main-form-" + commentId);
    if (mainForm.style.display === "none" || mainForm.style.display === "") {
        mainForm.style.display = "block";
    } else {
        mainForm.style.display = "none";
    }
}

function showUpdateModal() {
    var modal = document.getElementById("updateModal");
    var updateButton = document.getElementById("update-button");
    var closeModal = document.getElementById("closeModalUpdate");

    modal.style.display = "block";

    closeModal.addEventListener("click", function () {
        modal.style.display = "none";
    });

    window.addEventListener("click", function (event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    });
}

function showChangePassModal() {
    var modal = document.getElementById("changePassModal");
    var closeModal = document.getElementById("closeModalChangePass");

    modal.style.display = "block";

    closeModal.addEventListener("click", function () {
        modal.style.display = "none";
    });

    window.addEventListener("click", function (event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    });
}

function checkFormChangePass(userId) {
    var oldPass = document.getElementById("oldPassword").value;
    var newPassword = document.getElementById("newPassword").value;
    var reNewPassword = document.getElementById("reNewPassword").value;
    var url = "Profile?userId=" + userId + "&oldPassword=" + oldPass + "&newPassword=" + newPassword + "&reNewPassword=" + reNewPassword
    + "&btnChangePass=1";
    xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            var data = xhttp.responseText;
            document.getElementById("msgChangePass").innerHTML = data;
        }
    }
    xhttp.open("POST", url, true);
    xhttp.send();
}

function removeMsg() {
    document.getElementById("msgChangePass").innerHTML = "";
}

//const imageInput = document.getElementById("imageInput");
//const backgroundInput = document.getElementById("backgroundInput");
//
//imageInput.addEventListener("change", function () {
//    document.getElementById("imageForm").submit(); // Gửi form hình ảnh khi tệp thay đổi
//});
//
//backgroundInput.addEventListener("change", function () {
//    document.getElementById("backgroundForm").submit(); // Gửi form background khi tệp thay đổi
//});





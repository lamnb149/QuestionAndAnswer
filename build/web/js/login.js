function showPassword() {
    var x = document.getElementsByName("password_login")[0];
    if (x.type == "password") {
        x.type = "text";
    } else {
        x.type = "password";
    }
}

function validateForm() {
    var email = document.forms["loginForm"]["gmail_login"].value;
    var password = document.forms["loginForm"]["password_login"].value;
//    var emailPattern = /^[a-zA-Z0-9._-]+@(fpt\.edu\.vn|fu\.edu\.vn)$/;
    var passwordPattern = /^(?=.*[A-Z]).{6,}$/;

//    if (!email.match(emailPattern)) {
//        alert("Email must be in the format of user@fpt.edu.vn or user@fu.edu.vn");
//        return false;
//    }

    if (!password.match(passwordPattern)) {
        alert("Password must have at least one uppercase letter and be at least 6 characters long");
        return false;
    }
    return true;
}

function showModal() {
    var modal = document.getElementById('feedbackModal');
    modal.style.display = 'block';

    var closeModalBtn = document.getElementById('closeModalFeedBack');
    closeModalBtn.addEventListener('click', function () {
        var modal = document.getElementById('feedbackModal');
        modal.style.display = 'none';
    });

    window.onclick = function (event) {
        var modal = document.getElementById('feedbackModal');
        if (event.target == modal) {
            modal.style.display = 'none';
        }
    }
}

function showGmail() {
    var gmail = document.getElementById("gmail_change").value;
    var url = "Change?gmail_changePass="+gmail;
    xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            if (xhttp.responseText) {
                let data = JSON.parse(xhttp.responseText);
                let msg = data.msg;
                let gmail = data.gmail;
                document.getElementById("gmail_change").value = gmail;
                document.getElementById("valid_gmail").innerHTML = msg;
            } else {
                window.location.href = "ChangeControl"; 
            }
            
        }
    }
    xhttp.open("POST", url, true);
    xhttp.send();
}
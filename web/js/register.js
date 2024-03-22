function validateForm() {
    var gmail = document.getElementById("gmail_signup").value;
    var password = document.getElementById("password_signup").value;
    var repassword = document.getElementById("repassword_signup").value;

//    var emailPattern = /^[a-zA-Z0-9._-]+@(fpt\.edu\.vn|fu\.edu\.vn)$/;
//    var passwordPattern = /^(?=.*[A-Z]).{6,}$/;
//    if (!gmail.match(emailPattern)) {
//        alert("Invalid email. Please enter a valid email address.");
//        return false;
//    }
//
//    if (!password.match(passwordPattern)) {
//        alert("Password must have at least one uppercase letter and be at least 6 characters long.");
//        return false;
//    }
//
//    if (password !== repassword) {
//        alert("Password and Confirm Password do not match.");
//        return false;
//    }
    return true;
}
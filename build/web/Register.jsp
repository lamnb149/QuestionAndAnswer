<%-- 
    Document   : Register.jsp
    Created on : Oct 18, 2023, 2:55:32 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/register.css"/>
        <script type="text/javascript" src="js/register.js" ></script>
        <title>JSP Page</title>
    </head>
    <body>
        <h2>${mes}</h1>
        <div class="div">
        <div class="div-2">
            <div class="div-3">
                <div class="column">
                    <div class="div-4">
                        <div class="div-5">WELCOME BACK!</div>
                        <div class="div-6">
                            <span style="
                      font-family: Nunito, -apple-system, Roboto, Helvetica,
                        sans-serif;
                      font-weight: 400;
                      color: rgba(68, 75, 89, 1);
                    ">
                                <span style="font-size: 20px;">Already have an account,</span>
                            </span>
                            <span style="
                      font-family: Nunito, -apple-system, Roboto, Helvetica,
                        sans-serif;
                      font-weight: 700;
                      color: rgba(134, 153, 218, 1);
                    ">
                                <span style="font-size: 20px;"><a href="Login.jsp">Sign In</a></span>

                            </span>
                        </div>

                        <div class="div-7">

                            <!-- <div class=e57_415>
                                <div class="e51_0"></div>
                                <div class="e51_1"></div><span class="e55_0">Login</span><span
                                    class="e57_414">Register</span>
                            </div> -->
                            <form action="Register" style="width: 100%;" method="post" onsubmit="return validateForm();">
                                <div class="fl_name">
                                    <div class="div-8">
                                        <div class="div-9">First Name</div>
                                        <input type="text" placeholder="First Name" class="div-10" name="fname_signup" required>
                                    </div>
                                    <div class="div-8">
                                        <div class="div-9">Last Name</div>
                                        <input type="text" placeholder="Last Name" class="div-10" name="lname_signup" required>
                                    </div>
                                </div>
                                <div class="div-8">
                                    <div class="div-9">Gmail</div>
                                    <input type="text" placeholder="Enter your gmail" class="pass_css" name="gmail_signup" required id="gmail_signup">
                                </div>
                                <div class="password">
                                    <div class="div-8">
                                        <div class="div-9">Password</div>
                                        <input type="password" placeholder="Enter your password" class="pass_inp div-10" name="password_signup" required id="password_signup">
                                    </div>
                                    <div class="div-8">
                                        <div class="div-9">Confirm your password</div>
                                        <input type="password" placeholder="Confirm your password" class="pass_rep div-10" name="repassword_signup" required id="repassword_signup">
                                    </div>
                                </div>
                                <div>
                                    <input type="radio" name="gender" value="male" checked>Male
                                    <input type="radio" name="gender" value="female">Female
                                </div>
                                <input type="submit" value="Sign Up" class="submitBtn">
                        </div>
                        
                        </form>
                          
                    </div>
                </div>
            </div>
        </div>
    </div>
    </body>
</html>

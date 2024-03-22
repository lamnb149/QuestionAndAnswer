
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/css?family=Poppins&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="css/login.css">
        <script type="text/javascript" src="js/login.js" ></script>
        <title>LOGIN</title>
    </head>
    <body>
        <c:set var="cookie" value="${pageContext.request.cookies}"/>
        ${cookie.value.user}
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
                                    <span style="font-size: 20px;">Don’t have a account,</span>
                                </span>
                                <span style="
                                      font-family: Nunito, -apple-system, Roboto, Helvetica,
                                      sans-serif;
                                      font-weight: 700;
                                      color: rgba(134, 153, 218, 1);
                                      ">
                                    <span style="font-size: 20px;">
                                        <a href="Register.jsp">Sign up</a></span>

                                </span>
                            </div>
                            <div class="div-7">
                                ${mes}
                                <form action="Login" style="width: 100%;" method="post" name="loginForm" id="formLogin">
                                    <div class="div-8">
                                        <div class="div-9">Gmail</div>
                                        <input type="text" placeholder="Enter your gmail" class="div-10" name="gmail_login" value="${cookie.user.value}">
                                    </div>
                                    <div class="div-11">
                                        <div class="div-12">Password</div>
                                        <div class="div-8">
                                            <img class="img_hidden" src="images/hidden.png" onclick="showPassword()">
                                            <input type="password" placeholder="Enter your password" class="div-10" value="${cookie.pass.value}"
                                                   name="password_login" value="">
                                        </div>
                                    </div>
                                    <div class="div-15">
                                        <div class="div-16">
                                            <input type="checkbox" name="chkremember" 
                                                   ${cookie.reme.value != null ? 'checked' : ''}       >
                                            <label class="div-17">Remember me</label>
                                        </div>
                                        <div class="div-18"><a onclick="showModal()">Forget password?</a></div>
                                    </div>
                                    <c:if test="${sessionScope.wrongLoginCount > 0}">
                                        <div class="g-recaptcha" data-sitekey="6Lf_XNEoAAAAACp4dTR08x2M5wE8HPplm5ze95ra"></div>
                                    </c:if>

                                    <input type="submit" value="Sign In" class="submitBtn">
                                </form>
                            </div>
                            <c:if test="${sessionScope.wrongLoginCount >= 3}">
                                <div class="modalCmtUpdate" id="updateCmtModal">
                                    <div class="modal-cmt-content-update">
                                        ${requestScope.msgValidGmail}
                                        <form action="Login" method="post">    
                                            <table>
                                                <tr>
                                                    <td><label for="inputField">INPUT GMAIL: </label></td>
                                                    <td><input type="text" id="inputField" name="gmail" value="${requestScope.gmail_cur != null ? requestScope.gmail_cur : ""}"></td>
                                                </tr>
                                            </table>
                                            <input type="submit" value="Submit Gmail" name="btnGmail">
                                        </form>
                                        <form action="Login" method="post">    
                                            <table>
                                                <tr>
                                                    <input type="hidden" name="pin" value="${sessionScope.pin}"/>
                                                    <td><label for="pinField">INPUT PIN: </label></td>
                                                    <td><textarea id="pinField" name="inputPin"></textarea></td>
                                                </tr>
                                            </table>
                                            <input type="submit" value="Submit Pin" name="btnPin">
                                        </form>
                                    </div>
                                </div>
                            </c:if>
                            <div class="c">
                                <div class="c-2"></div> 
                                <div class="c-3">OR</div>
                                <div class="c-4"></div>
                            </div>
                            <div class="h">
                                <div class="h-2">
                                    <img
                                        loading="lazy"
                                        srcset="
                                        https://cdn.builder.io/api/v1/image/assets/TEMP/8c0a6267-c983-4af4-a403-bd3ba88766d9?apiKey=0db8c097f3f0425c82376e80def6fa49&width=100   100w,
                                        https://cdn.builder.io/api/v1/image/assets/TEMP/8c0a6267-c983-4af4-a403-bd3ba88766d9?apiKey=0db8c097f3f0425c82376e80def6fa49&width=200   200w,
                                        https://cdn.builder.io/api/v1/image/assets/TEMP/8c0a6267-c983-4af4-a403-bd3ba88766d9?apiKey=0db8c097f3f0425c82376e80def6fa49&width=400   400w,
                                        https://cdn.builder.io/api/v1/image/assets/TEMP/8c0a6267-c983-4af4-a403-bd3ba88766d9?apiKey=0db8c097f3f0425c82376e80def6fa49&width=800   800w,
                                        https://cdn.builder.io/api/v1/image/assets/TEMP/8c0a6267-c983-4af4-a403-bd3ba88766d9?apiKey=0db8c097f3f0425c82376e80def6fa49&width=1200 1200w,
                                        https://cdn.builder.io/api/v1/image/assets/TEMP/8c0a6267-c983-4af4-a403-bd3ba88766d9?apiKey=0db8c097f3f0425c82376e80def6fa49&width=1600 1600w,
                                        https://cdn.builder.io/api/v1/image/assets/TEMP/8c0a6267-c983-4af4-a403-bd3ba88766d9?apiKey=0db8c097f3f0425c82376e80def6fa49&width=2000 2000w,
                                        https://cdn.builder.io/api/v1/image/assets/TEMP/8c0a6267-c983-4af4-a403-bd3ba88766d9?apiKey=0db8c097f3f0425c82376e80def6fa49&
                                        "
                                        class="img-h"
                                        />
                                    <div class="h-3">Sign up with Google</div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="column-2">
                        <div class="div-23">
                            <div class="div-24">
                                <div class="div-25">
                                    <div class="div-26" style="font-size: 15px;">
                                        <a href="#">Help</a>
                                    </div>
                                    <div class="div-27" style="font-size: 15px;">
                                        <a href="#">Contact us</a>
                                    </div>
                                    <div class="div-28" style="font-size: 15px;">
                                        <div class="div-29" style="font-size: 15px;">English</div>
                                    </div>
                                    <div class="div-30" style="font-size: 15px;">
                                        <a href="#">Sign Up</a>
                                    </div>
                                </div>
                                <img loading="lazy" srcset="
                                     https://cdn.builder.io/api/v1/image/assets/TEMP/72f31705-20ed-4287-8bb6-2c8eac08603f?apiKey=0db8c097f3f0425c82376e80def6fa49&width=100   100w
                                     " class="img-6" />
                            </div>
                            <img loading="lazy" srcset="
                                 https://cdn.builder.io/api/v1/image/assets/TEMP/b5ec6c17-e2df-4610-94a1-df7c738cd666?apiKey=0db8c097f3f0425c82376e80def6fa49&width=100   100w,
                                 https://cdn.builder.io/api/v1/image/assets/TEMP/b5ec6c17-e2df-4610-94a1-df7c738cd666?apiKey=0db8c097f3f0425c82376e80def6fa49&width=200   200w,
                                 https://cdn.builder.io/api/v1/image/assets/TEMP/b5ec6c17-e2df-4610-94a1-df7c738cd666?apiKey=0db8c097f3f0425c82376e80def6fa49&width=400   400w,
                                 https://cdn.builder.io/api/v1/image/assets/TEMP/b5ec6c17-e2df-4610-94a1-df7c738cd666?apiKey=0db8c097f3f0425c82376e80def6fa49&width=800   800w,
                                 https://cdn.builder.io/api/v1/image/assets/TEMP/b5ec6c17-e2df-4610-94a1-df7c738cd666?apiKey=0db8c097f3f0425c82376e80def6fa49&width=1200 1200w,
                                 https://cdn.builder.io/api/v1/image/assets/TEMP/b5ec6c17-e2df-4610-94a1-df7c738cd666?apiKey=0db8c097f3f0425c82376e80def6fa49&width=1600 1600w,
                                 https://cdn.builder.io/api/v1/image/assets/TEMP/b5ec6c17-e2df-4610-94a1-df7c738cd666?apiKey=0db8c097f3f0425c82376e80def6fa49&width=2000 2000w,
                                 https://cdn.builder.io/api/v1/image/assets/TEMP/b5ec6c17-e2df-4610-94a1-df7c738cd666?apiKey=0db8c097f3f0425c82376e80def6fa49&
                                 " class="img-7" />
                        </div>
                    </div>
                </div>
            </div>
            <div class="modalFeedback" id="feedbackModal">
                <div class="modal-feedback">
                    <span class="closeModalFeedback" id="closeModalFeedBack">&times;</span>
                    <div id="valid_gmail"></div>
                    <form action="" method = "" id="form-gmailChange">
                        <label for="gmail_change">Gmail</label><br/>
                        <input type = 'text' name = 'gmail_changePass' value = '' id="gmail_change"><br/>
                        <button name = 'btnSendMail' onclick="showGmail()" type="button">Send Pin</button>
                    </form>
                </div>
            </div>
        </div>
        <script src="https://www.google.com/recaptcha/api.js" async defer></script>
        <script>
            window.onload = function () {
                const wrongLoginCount = <%= session.getAttribute("wrongLoginCount") %>;
                const form = document.getElementById("formLogin");
                form.addEventListener("submit", function (event) {
                    const response = grecaptcha.getResponse();
                    if (response) {
                        form.submit();
                    } else {
                        event.preventDefault();
                        alert("Check please captcha");
                    }
                });
            }
        </script>
    </body>
</html>

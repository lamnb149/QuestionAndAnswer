
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
        <div class="div">
            <div class="div-2">
                <div class="div-3">
                    <div class="column">
                        <div class="div-4">
                            <div class="div-5">WELCOME BACK!</div>


                            <div class="div-7">

                                <!-- <div class=e57_415>
                                    <div class="e51_0"></div>
                                    <div class="e51_1"></div><span class="e55_0">Login</span><span
                                        class="e57_414">Register</span>
                                </div> -->
                                ${requestScope.msg}
                                <form action="ChangeControl" style="width: 100%;" method="post">
                                    <div class="div-11">
                                        <div class="div-12">Enter Pin</div>
                                        <input type="text" placeholder="Enter PIN" class="div-10" name="input_pin">
                                    </div>
                                    <div class="div-11">
                                        <div class="div-12">New Password</div>
                                        <input type="password" placeholder="Enter new password" class="div-10" name="new_password">
                                    </div>
                                    <div class="div-11">
                                        <div class="div-12">Re-enter New Password</div>
                                        <div class="div-8">
                                            <input type="password" placeholder="Re-enter new password" class="div-10"
                                                   name="renew_password" value="">
                                        </div>
                                    </div>
                                    <input type="submit" value="Change" class="submitBtn">
                                </form>
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
        </div>
    </body>
</html>

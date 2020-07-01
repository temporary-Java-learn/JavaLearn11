<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html
    PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="tp_page" content="3.0">
    <title>注册</title>
    <link href="css/register_3.0.css" rel="stylesheet" type="text/css">
    <script src="js/register_new.js"></script>
    <script type="text/javascript" async="" src="js/captcha.js"></script>
</head>

<body>
    <div class="regist_header clearfix">
        <div class="wrap">
            <div class="regist_header_right clearfix">
                <div class="help_wrap">已有账号，
                </div>
                <span class="fr"><a href="login.jsp" class="blue_link" style="color:red;">请登录</a></span>
            </div>
        </div>
    </div>

    <script type="text/javascript" src="js/jquery.cookie.js"></script>

    <input type="hidden" id="validateSig">
    <input type="hidden" name="returnUrl" id="returnUrl">
    <input id="p" type="hidden" value="">
    <input type="password" style="display:none">
    <div class="y_regist_wrap">
        <!--背景小图标 -->
        <div class="r_icon1"></div>
        <div class="r_icon2"></div>
        <div class="r_icon3"></div>
        <div class="r_icon4"></div>
        <div class="r_icon5"></div>
        <div class="y_regist_model">
            <h4 class="y_regist_tit" style="color:#FFF;opacity:0.8;margin-top:120px;">注册</h4>
            <form action="register" method="post">
                <div class="y_regist_form">
                    <ul class="clearfix"  >
                        <li >
                            <div class="y_same_item" style="background:#FFF;">
                                <input class="ysame_input" name="logname" type="text" value="" id="phone" placeholder="手机号">
                            </div>
                        </li>
                        <li>
                            <div class="y_same_item" style="background:#FFF;">
                                <input class="ysame_input" name="name" type="text" value="" id="phone" placeholder="账号">
                                <span class="y_same_label">
                                </span>
                            </div>
                        </li>
                        <li>
                            <div class="y_same_item" style="background:#FFF;">
                                <input class="ysame_input y_set_password" name="password" type="password" placeholder="设置密码" oncopy="return false;" oncut="return false;" onpaste="return false;" autocomplete="off" id="password">
                                <span class="y_same_label"></span> </div>

                        <li>
                        
                            <div class="y_same_item" style="background:#FFF;">
                                <input class="ysame_input" type="password" name="password1" placeholder="确认密码" oncopy="return false;" oncut="return false;" onpaste="return false;" id="password2">
                                <span class="y_same_label"></span> </div>
                        </li>

                         <li>
                         	<input type="submit"  value="注册" class="y_agreement_btn"></input>
                           <!--  <a class="y_agreement_btn" href="index.jsp">同意协议并注册</a> -->
                        </li>
                    </ul>
                </div> <!-- // y_regist_form ending -->
            </form>
        </div>
    </div>
    <!--// y_regist_wrap ending -->
    <script type="text/javascript" src="js/api.js"></script>
    <script type="text/javascript">
        var showValidCodeWhenRegistByMobile = false;
        var registerValidateUserBehaviorSwitcher = true;
        jRegist.init();
    </script>
    </div>
</body>

</html>
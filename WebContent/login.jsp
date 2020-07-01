<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html
    PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta name="tp_page" content="2.0">
    <meta http-equiv="X-UA-Compatible" content="IE=8">
    <meta name="renderer" content="webkit">
    <title>登录</title>
    <link href="css/pc_login_new.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="js/pc_login_new.js"></script>

    <script>
        var LOGIN_RESULT = { SUCCESS: 0, FAIL: 1 };
        var REGISTER_RESULT = { SUCCESS: 10, FAIL: 11 };
        var DOMAIN_TYPE = { YHD: 1, MALL: 2, YW_111: 3 };
        var LOGIN_SOURCE = { NORMAL: 1, FRAME: 2 };
        var URLPrefix = { "yhd_domain": ".yhd.com", "sam_passport_statics": "https://security.samsclub.cn/front-passport/passport", "chinese": "1号店", "passportother": "https://passport.1mall.com", "sam_domain": ".samsclub.cn", "sam_captcha_js_url": "https://security.samsclub.cn/captcha/js/api.js", "helpUrl": "http://www.yihaodian.com/cms/view.do?topicId=9864", "hk_passport_statics": "https://passport.yihaodian.com.hk/front-passport/passport", "yhd_captcha_host": "https://captcha.yhd.com", "tracker": "tracker.yhd.com", "sam_login_url": "https://security.samsclub.cn/customer/login_input.do", "sam_passport_host": "https://security.samsclub.cn", "central": "http://www.yhd.com", "out3wurl": "www.yihaodian.com", "yhd_passport_host": "https://passport.yhd.com", "sam_request_namespace": "/customer", "mySite": "http://my.yihaodian.com/member/my.do", "passport_statics": "https://passport.yhd.com/front-passport/passport", "yaowang": "http://www.111.com.cn", "sam_captcha_host": "https://security.samsclub.cn", "my": "http://my.yhd.com", "httpurl": "http://www.yihaodian.com", "mymall": "http://my.1mall.com", "yhd_login_url": "https://passport.yhd.com/passport/login_input.do", "agreementUrl": "http://cms.yhd.com/cms/view.do?topicId=10", "no3wUrl": "yhd.com", "h5AgreementUrl": "http://cms.yhd.com/cms/view.do?topicId=54", "yiwangauth": "http://mall.yiwang.cn", "webStaticResourceUrl": "http://image.yihaodianimg.com", "passport": "https://passport.yhd.com", "validCodeShowUrl": "https://captcha.yhd.com/public/validcode.do", "mall": "http://www.1mall.com" };
        var currSiteId = 1;

        var returnUrl = "http://www.yhd.com/?tracker_u=2225501&cu=true&utm_source=baidu-pinzhuan&utm_medium=cpc&utm_campaign=t_288551095_baidupinzhuan&utm_term=yhdbaidupcpz001_0_b6668955cfd9487d9ed6a9c92618bc99";
        var autoLoginFlag = "1";
        var valid_code_service_flag = "1";
        var showValidCode = "0";
        var mUrl = "";

        var no3wUrl = "yhd.com";
        var imgPath = "https://passport.yhd.com/front-passport/passport/images";
        var fromDomain = "";
        var resetIframeUrl = fromDomain + "/login/callback.do";

        var yhdUrl = "http://www.yhd.com";
        var yhdPassportUrl = "https://passport.yhd.com";
        var ywPassportUrl = "";
        var pubkey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDXQG8rnxhslm+2f7Epu3bB0inrnCaTHhUQCYE+2X+qWQgcpn+Hvwyks3A67mvkIcyvV0ED3HFDf+ANoMWV1Ex56dKqOmSUmjrk7s5cjQeiIsxX7Q3hSzO61/kLpKNH+NE6iAPpm96Fg15rCjbm+5rR96DhLNG7zt2JgOd2o1wXkQIDAQAB";
    </script>
    <script type="text/javascript" async="" src="js/captcha.js"></script>
</head>

<body>
    <link rel="shortcut icon" href="https://passport.yhd.com/front-passport/passport/images/yhd_favicon.ico">
    <div class="regist_header clearfix">
        <div class="wrap">
            <div class="regist_header_right clearfix">
                <!--<a href="#" class="english_edition" id="edition" style="display:none">English</a>-->
                <div class="help_wrap">

                </div>
                <span class="fr"><a href="登陆.html" class="blue_link"></a></span>
            </div>
        </div>
    </div>



    <input type="hidden" id="isAutoLogin" value="0">
    <input type="hidden" id="autoLoginFlag" value="1">
    <input type="hidden" id="uuid">
    <div class="login_wrap">
        <div class="wrap clearfix">
            <div class="mod_login_wrap">
                <div class="login_pc">
                    <div class="clearfix">
                        <h3>用户登录</h3>
                        <a href="register.jsp" class="regist_new blue_link">注册新账号</a>
                    </div>
                    <form action="login" method="post">
                        <div class="login_form">
                            <div class="form_item_wrap">
                                <div class="form_item">
                                    <label class="user_ico">&nbsp;</label>
                                    <input id="un" type="text" name="username" spellcheck="false" tabindex="1" class="ipt ipt_username gay_text" placeholder="账户或手机号" style="outline: none;" value="">
                                </div>
                                <div class="form_item">
                                    <label class="paswd_ico">&nbsp;</label>
                                    <input id="pwd" type="password" oncopy="return false" onpaste="return false"  oncut="return false" oncontextmenu="return false" name="password" tabindex="2" class="ipt ipt_password gay_text" placeholder="密码" style="outline: none;">
                                </div>
                                <div id="vcd_div" class="verify_code clearfix" style="display: none;">
                                    <input id="validateSig" type="hidden">
                                    <div class="form_item cur_right">
                                        <label class="verify_ico">&nbsp;</label>
                                    </div>
                                </div>

                                <div class="auto_login clearfix">


                                </div>
								<input type="submit" value="登录" class="login_btn">
                               <%--  <a href="${pageContext.request.contextPath}/login"><button id="login_button" type="button" class="login_btn"
                                    onclick="javascript:double_submit();return false;">登录</button></a> --%>
                    </form>

                </div>

                <div class="joint_landing_wrap">
                </div>
                <!---->
            </div>
        </div>
        <!--login code-20160613-zhangqian7-S-->







        <script type="text/javascript" src="js/api.js"></script>


        <script>
            pageInit();



            $(document).ready(function () {
                var isIE = !!window.ActiveXObject;
                var isIE6 = isIE && !window.XMLHttpRequest;
                if (isIE6) {
                    $(".login_switch").hide();
                }
                if (0 == 0) {
                    $(".login_switch").hide();
                }

                jsLoginFed.loadImageUrl("1", "Passport_Login_Ad_Click");

                var host = window.location.host;
                var reg_host = /([a-z0-9_-]+\.)*(yhd|yihaodian|1mall|111)\.(com\.hk)$/;
                if (reg_host.test(host)) {
                    var requestUrl = URLPrefix.passport + "/passport/cookie_rurl_synchronization.do";
                    cookie_sync.cookieRURLSynchronization(requestUrl);

                    if (window.addEventListener) {
                        window.addEventListener("message", handMessage, false);
                    }
                    else {
                        window.attachEvent("onmessage", handMessage);
                    }

                    $(".login_switch").hide();
                }
            });

            function handMessage(event) {
                event = event || window.event;
                if (event.origin === 'https://passport.yhd.com') {
                    var obj = eval('(' + event.data + ')');
                    window.location = obj.returnUrl;
                }
            }
        </script>

        <div id="Vidown_extension_alhnopeoagjmjfgcbnokcnagkecgdcdh" style="display: none;"></div>
        <div id="__yct_container__" style="display: none; visibility: hidden;">
</body>

</html>
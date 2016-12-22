<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
        <title>用户注册</title>
        <link rel="stylesheet" type="text/css" href="./source/css/style.css" />
        <link rel="stylesheet" href="./source/css/base.css" type="text/css" />
        <link rel="stylesheet" href="./source/css/login.css" type="text/css" />
        <script type="text/javascript" src="./source/js/jquery.min.js"></script>
    </head>
    <body>
        <%@include file="/WEB-INF/pages/header.jsp" %>
        <div class="bd">
            <!-- 注册主体部分start -->
            <div class="login w990 bc mt10 regist " style="margin:auto">
                <div class="login_hd">
                    <h2>用户注册</h2>
                    <b></b>
                </div>
                <div class="login_bd">
                    <div class="login_form fl">
                        <form action="member_regist_success" method="post" class="regist_from">
                            <ul>
                                <li class="action_error"><s:actionerror/></li>
                                <li>
                                    <label for="">邀请码：</label>
                                    <input type="text" class="txt" name="invitationCode" value="<s:property value="invitationCode"/>" /><span class="prompt"></span>
                                     <p>请输入16位邀请码</p>
                                </li>
                                <li>
                                    <label for="">用户名：</label>
                                    <input type="text" class="txt" name="username" value="<s:property value="username"/>" /><span class="prompt"></span>
                                    <p>3-20位字符，可由中文、字母、数字和下划线组成</p>
                                </li>
                                <li>
                                    <label for="">密码：</label>
                                    <input type="password" class="txt" name="password" /><span class="prompt"></span>
                                    <p>6-20位字符，可使用字母、数字和符号的组合，不建议使用纯数字、纯字母、纯符号</p>
                                </li>
                                <li>
                                    <label for="">确认密码：</label>
                                    <input type="password" class="txt" name="repassword" /><span class="prompt"></span>
                                    <p> <span>请再次输入密码</p>
                                </li>
                                <li>
                                    <label for="">邮箱：</label>
                                    <input type="text" class="txt" name="email" value="<s:property value="email"/>" /><span class="prompt"></span>
                                    <p>邮箱必须合法</p>
                                </li>
                                <!--                            <li>
                                                                <label for="">手机号码：</label>
                                                                <input type="text" class="txt" value="" name="mobil" id="tel" placeholder=""/><span class="prompt"></span>
                                                            </li>-->
                                <li class="checkcode">
                                    <!--                                <label>验证码：</label>
                                                                    <input type="text" class="txt" value="" placeholder="请输入短信验证码" style="width:200px" name="captcha" disabled="disabled" id="captcha"/> <input type="button" onclick="bindPhoneNum(this)" id="get_captcha" value="获取验证码" style="height: 25px;padding:3px 8px"/>
                                                                    <input type="text" class="txt" name="checkcode" value="" placeholder="请输入验证码" style="width:200px"/><img src="CheckCode"class="captcha" width="50px" />-->
                                    <label for="">验证码：</label>
                                    <input type="text"  name="checkcode" />
                                    <img src="CheckCode"  class="checkcode" alt="" />
                                </li>


                                <li>
                                    <label for="">&nbsp;</label>
                                    <input type="checkbox" class="chb" checked="true" name="agree"/> 我已阅读并同意《用户注册协议》<span class="prompt"></span>
                                </li>
                                <li>
                                    <label for="">&nbsp;</label>
                                    <input type="submit" value="" class="login_btn" />
                                </li>
                            </ul>
                        </form>

                    </div>
                    <div class="guide fl">
                        <h3>已经是社团成员？</h3>
                        <p>现在马上登录网站，享受各种福利，心动不如行动，赶紧行动吧!</p>

                        <a href="member_login" class="reg_btn">马上登陆 >></a>
                    </div>
                </div>
            </div>
            <!-- 注册主体部分end -->

        </div>

        <div style="clear:both;"></div>
        <!--footer begin-->
        <%@include file="/WEB-INF/pages/footer.jsp" %>
        <!--footer end-->
        <script type="text/javascript" src="./source/js/jquery.min.js"></script>
        <script type="text/javascript" src="./source/js/jquery.validate.min.js"></script>
        <script type="text/javascript">
            function bindPhoneNum() {
                //启用输入框
                $('#captcha').prop('disabled', false);
                layer.open({
                    type: 1,
                    title: false,
                    closeBtn: 1,
                    shadeClose: true,
                    skin: '',
                    content: '<div style="text-align: center;padding: 10px;width:340px">\
                                <table>\
                                    <tr>\
                                        <td colspan="2">请输入验证码</td>\
                                    </tr>\
                                    <tr>\
                                        <td>\
                                            <input type="text" id="code" value="" style="width:8em;"/>\
                                        </td>\
                                        <td>\
                                            <img src="http://127.0.0.1/shop/www.shop.com/Captcha/show" class="captcha" width="140px"  style="margin-left:5em"/>\
                                        </td>\
                                    </tr>\
                                    <tr>\
                                        <td colspan="2"><input type="submit" value=" 获取验证码 " onclick="send_sms()"/></td>\
                                    </tr>\
                                </table>\
                            </div>'
                });
                var time = 60;
                var interval = setInterval(function () {
                    time--;
                    if (time <= 0) {
                        clearInterval(interval);
                        var html = '获取验证码';
                        $('#get_captcha').prop('disabled', false);
                    } else {
                        var html = time + '秒后再次获取';
                        $('#get_captcha').prop('disabled', true);
                    }

                    $('#get_captcha').val(html);
                }, 1000);
            }
            function send_sms() {
                var tel = $('#tel').val();
                var code = $('#code').val();
                var url = "{:U('Home/member/sendSms')}";
                var data = {tel: tel, code: code};
                console.debug(data);
                $.getJSON(url, data, function (data) {
                });
            }
            $('body').on('click', '.checkcode', function () {
                $(this).attr('src', "CheckCode?tiem=" + new Date().getTime());
            });

            //----------------  表单自动验证插件  -----------------

            $('.regist_from').validate({
                rules: {
                    invitationCode:{
                        required: true,
                        rangelength: [16, 16],
                        remote: "check",
                    },
                    username: {
                        required: true,
                        rangelength: [3, 20],
                        remote: "check",
                    },
                    password: {
                        required: true,
                        rangelength: [6, 20],
                    },
                    repassword: {
                        equalTo: "input[name=password]",
                    },
                    email: {
                        required: true,
                        email: true,
                        remote: "check",
                    },
                    //                                            tel: {
                    //                                                required: true,
                    //                                                remote: '{:U("checkField")}',
                    //                                            },
                    captcha: {
                        required: true,
                    },
                    agree: "required",
                },
                messages: {
                    invitationCode:{
                        required: "邀请码不能为空",
                        rangelength: '请输入正确的邀请码',
                        remote: "邀请码无效",
                    },
                    username: {
                        required: '用户名不能为空',
                        rangelength: '用户名长度不合法',
                        remote: "用户名已被占用",
                    },
                    password: {
                        required: '密码不能为空',
                        rangelength: '密码长度不合法',
                    },
                    repassword: {
                        equalTo: '两次密码不一致',
                    },
                    email: {
                        required: '邮箱不能为空',
                        email: '邮箱不合法',
                        remote: '邮箱已被占用',
                    },
                    //                                            tel: {
                    //                                                required: '手机号码不能为空',
                    //                                                remote: '手机号码已被占用',
                    //                                            },
                    //                                            captcha: "短信验证码不能为空",
                    agree: "必须同意网站协议",
                },
                errorPlacement: function (msg, node) {
                    //将错误信息,放到node后的error-tips节点上
                    $(node[0]).siblings(".prompt").text($(msg[0]).text());
                },
                success: function () {}
            });
        </script>
    </body>
</html>
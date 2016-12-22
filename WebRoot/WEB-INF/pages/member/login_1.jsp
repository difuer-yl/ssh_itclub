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
        <title>登录</title>
        <link rel="stylesheet" type="text/css" href="./source/css/style.css" />
        <link rel="stylesheet" href="./source/css//base.css" type="text/css" />
        <link rel="stylesheet" href="./source/css//login.css" type="text/css" />
        <script type="text/javascript" src="./source/js/jquery.min.js"></script>
    </head>
    <body>
        <%@include file="/WEB-INF/pages/header.jsp" %>
        <div class="bd">
            <!-- 登录主体部分start -->
            <div class="login   ">
                <div class="login_hd">
                    <h2>用户登录</h2>
                    <b></b>
                </div>
                <div class="login_bd">
                    <div class="login_form fl">
                        <form action="admin/admin_login" method="post">
                            
                            <ul>
                                <li class="action_error"><s:actionerror/></li>
                                <li>
                                    <label >用户名：</label>
                                    <input type="text" class="txt" name="username" value="<s:property value="username"/>" />
                                </li>
                                <li>
                                    <label>密码：</label>
                                    <input type="password" class="txt" name="password" />
                                    <a href="">忘记密码?</a>
                                </li>
                                <li class="checkcode">
                                    <label for="">验证码：</label>
                                    <input type="text"  name="checkcode" />
                                    <img src="CheckCode"  class="checkcode" alt="" />
                                </li>
                                <li>
                                    <label for="">&nbsp;</label>
                                    <input type="checkbox" class="chb" name="remember" /> 保存登录信息
                                </li>
                                <li>
                                    <label for="">&nbsp;</label>
                                    <input type="submit" value="" class="login_btn" />
                                </li>
                            </ul>
                        </form>


                    </div>

                    <div class="guide fl">
                        <h3>还不是社团成员？</h3>
                        <p>现在免费注册成为社团成员，享受各种福利，心动不如行动，赶紧加入吧!</p>

                        <a href="member_regist" class="reg_btn">免费注册 >></a>
                    </div>

                </div>
            </div>
            <!-- 登录主体部分end -->
        </div>


        <div style="clear:both;"></div>
        <!--footer begin-->
        <%@include file="/WEB-INF/pages/footer.jsp" %>
        <!--footer end-->
        <script type="text/javascript" src="./js/jquery.min.js"></script>
    </body>
</html>
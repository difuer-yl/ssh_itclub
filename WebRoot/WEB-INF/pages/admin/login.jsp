<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <meta charset="utf-8"/>
        <meta name="renderer" content="webkit|ie-comp|ie-stand"/>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
        <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
        <meta http-equiv="Cache-Control" content="no-siteapp" />
        <link href="/itclub/source/css/admin/H-ui.min.css" rel="stylesheet" type="text/css" />
        <link href="/itclub/source/css/admin/H-ui.login.css" rel="stylesheet" type="text/css" />
        <link href="/itclub/source/css/admin/style.css" rel="stylesheet" type="text/css" />
        <link href="/itclub/source/css/admin/iconfont.css" rel="stylesheet" type="text/css" />
        <title>后台登录 - ITclub</title>
        <meta name="keywords" content="ITclub" />
        <meta name="description" content="IT俱乐部" />
    </head>
    <body>
        <!--<input type="hidden" id="TenantId" name="TenantId" value="" />-->
        <div class="header">
            <img src="/itclub/source/images/logo.png" height="60px" />
        </div>
        <div class="loginWraper">
            <div id="loginform" class="loginBox">
                <form class="form form-horizontal" action="/itclub/admin/admin_login" method="post">
                    <div class="row cl">
                        <label class="form-label col-xs-3"></label>
                        <div class="formControls col-xs-8">
                            <s:actionerror/>
                        </div>
                    </div>
                    <div class="row cl">
                        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
                        <div class="formControls col-xs-8">
                            <input id="" name="username" type="text" placeholder="账户" class="input-text size-L">
                        </div>
                    </div>
                    <div class="row cl">
                        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
                        <div class="formControls col-xs-8">
                            <input id="" name="password" type="password" placeholder="密码" class="input-text size-L">
                        </div>
                    </div>
                    <div class="row cl">
                        <div class="formControls col-xs-8 col-xs-offset-3">
                            <input class="input-text size-L" type="text" placeholder="验证码" name="checkcode"  style="width:150px;"/>
                            <img src="/itclub/CheckCode" class="checkcode" style="height:41px">
                        </div>
                    </div>
                    <div class="row cl">
                        <div class="formControls col-xs-8 col-xs-offset-3">
                            <label for="online">
                                <input type="checkbox" name="auto" id="online" value="true">
                                    使我保持登录状态</label>
                        </div>
                    </div>
                    <div class="row cl">
                        <div class="formControls col-xs-8 col-xs-offset-3">
                            <input name="" type="submit" class="btn btn-success radius size-L" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;" />
                            <input name="" type="reset" class="btn btn-default radius size-L" value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;" />
                        </div>
                    </div>
                </form>
            </div>
            <div class="footer">

                Copyright ITclub
            </div>
        </div>
        <script type="text/javascript" src="/itclub/source/js/jquery.min.js"></script> 
        <script type="text/javascript" src="/itclub/source/js/admin/H-ui.js"></script> 
        <script type="text/javascript">
            $('body').on('click', '.checkcode', function () {
                $(this).attr('src', "/itclub/CheckCode?tiem=" + new Date().getTime());
            });
        </script>
    </body>
</html>
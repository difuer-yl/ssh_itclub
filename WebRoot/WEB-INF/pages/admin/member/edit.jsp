<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <meta charset="utf-8"/>
        <meta name="renderer" content="webkit|ie-comp|ie-stand"/>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
        <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
        <meta http-equiv="Cache-Control" content="no-siteapp" />
        <LINK rel="Bookmark" href="/favicon.ico" />
        <LINK rel="Shortcut Icon" href="/favicon.ico" />
        <%@include file="../css.jsp" %>
        <title>添加用户 - H-ui.admin v2.3</title>
    </head>
    <body>
        <article class="page-container">
            <form action="member_edit_success" method="post" class="form form-horizontal" id="form-member-add">
                <div class="row cl">
                    <input type="text" value="${list.get(0).id}" hidden name="id" />
                    <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>用户名：</label>
                    <div class="formControls col-xs-8 col-sm-9">
                        <input type="text" class="input-text" value="${list.get(0).username}" placeholder="" id="username" name="username">
                    </div>
                </div>
                <div class="row cl">
                    <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>密码：</label>
                    <div class="formControls col-xs-8 col-sm-9">
                        <input type="password" class="input-text" value="" placeholder="" id="password" name="password">
                    </div>
                </div>
                <div class="row cl">
                    <label class="form-label col-xs-4 col-sm-3">性别：</label>
                    <div class="formControls col-xs-8 col-sm-9 skin-minimal">
                        <div class="radio-box">
                            <input name="sex" type="radio" id="sex-1" <c:if test="${list.get(0).sex==1}"> checked</c:if>  value="1"/>
                            <label for="sex-1">男</label>
                        </div>
                        <div class="radio-box">
                            <input type="radio" id="sex-2" name="sex" <c:if test="${list.get(0).sex==0}"> checked</c:if> value="0">
                                <label for="sex-2">女</label>
                        </div>
                    </div>
                </div>
                <div class="row cl">
                    <label class="form-label col-xs-4 col-sm-3">手机：</label>
                    <div class="formControls col-xs-8 col-sm-9">
                        <input type="text" class="input-text" value="${list.get(0).mobil}" placeholder="" id="mobile" name="mobile">
                    </div>
                </div>
                <div class="row cl">
                    <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>邮箱：</label>
                    <div class="formControls col-xs-8 col-sm-9">
                        <input type="text" class="input-text" placeholder="@" name="email" id="email" value="${list.get(0).email}">
                    </div>
                </div>
                <div class="row cl">
                    <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
                        <input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
                    </div>
                </div>
            </form>
        </article>

        <!--_footer 作为公共模版分离出去--> 
        <%@include file="../js.jsp" %>
        <!--/_footer /作为公共模版分离出去--> 

        <!--请在下方写此页面业务相关的脚本--> 
        <script type="text/javascript">
            $(function () {
                $('.skin-minimal input').iCheck({
                    checkboxClass: 'icheckbox-blue',
                    radioClass: 'iradio-blue',
                    increaseArea: '20%'
                });

                $("#form-member-add").validate({
                    rules: {
                        username: {
                            required: true,
                            minlength: 3,
                            maxlength: 20
                        },
                        password: {
                            required: true,
                            minlength: 6,
                            maxlength: 20
                        },
                        sex: {
                            required: true,
                        },
                        mobile: {
                            isMobile: true,
                        },
                        email: {
                            required: true,
                            email: true,
                        },
                    },
                    onkeyup: false,
                    focusCleanup: true,
                    success: "valid",
                    submitHandler: function (form) {
                        var a=$(form).ajaxSubmit();
                        var index = parent.layer.getFrameIndex(window.name);
                        //parent.$('.btn-refresh').click();
                        //提示层
        
                        layer.msg('玩命提示中');
                        
                        parent.layer.close(index);
                    }
                });
            });
        </script> 
        <!--/请在上方写此页面业务相关的脚本-->
    </body>
</html>
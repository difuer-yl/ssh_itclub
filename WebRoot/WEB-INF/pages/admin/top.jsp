<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title></title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <%@include file="css.jsp" %>

    </head>
    <body>
        <header class="navbar-wrapper">
            <div class="navbar navbar-fixed-top">
                <div class="container-fluid cl"> <a class="logo navbar-logo f-l mr-10 hidden-xs" href="index">ITclub</a> <a class="logo navbar-logo-m f-l mr-10 visible-xs" href="/aboutHui.shtml">H-ui</a> <span class="logo navbar-slogan f-l mr-10 hidden-xs">v0.1</span> <a aria-hidden="false" class="nav-toggle Hui-iconfont visible-xs" href="javascript:;">&#xe667;</a>
                    <nav class="nav navbar-nav">
                        <ul class="cl">
                            <li class="dropDown dropDown_hover"><a href="javascript:;" class="dropDown_A"><i class="Hui-iconfont">&#xe600;</i> 新增 <i class="Hui-iconfont">&#xe6d5;</i></a>
                                <ul class="dropDown-menu menu radius box-shadow">
                                    <li><a href="javascript:;" onclick="article_add('添加资讯', 'article_add')"><i class="Hui-iconfont">&#xe616;</i> 资讯</a></li>
                                    <li><a href="javascript:;" onclick="picture_add('添加资讯', 'picture-add.html')"><i class="Hui-iconfont">&#xe613;</i> 图片</a></li>
                                    <li><a href="javascript:;" onclick="product_add('添加资讯', 'product-add.html')"><i class="Hui-iconfont">&#xe620;</i> 产品</a></li>
                                    <li><a href="javascript:;" onclick="member_add('添加用户', 'member_add', '', '510')"><i class="Hui-iconfont">&#xe60d;</i> 用户</a></li>
                                </ul>
                            </li>
                        </ul>
                    </nav>
                    <nav id="Hui-userbar" class="nav navbar-nav navbar-userbar hidden-xs">
                        <ul class="cl">
                            <li>超级管理员</li>
                            <li class="dropDown dropDown_hover"> <a href="#" class="dropDown_A">${session.get("ADMIN_MEMBER").username} <i class="Hui-iconfont">&#xe6d5;</i></a>
                                <ul class="dropDown-menu menu radius box-shadow">
                                    <li><a href="#">个人信息</a></li>
                                    <li><a href="#">切换账户</a></li>
                                    <li><a href="member_signout">退出</a></li>
                                </ul>
                            </li>
                            <li id="Hui-msg"> <a href="#" title="消息"><s:if test="#session.ADMIN_MEMBER.newprompt !=0"><span class="badge badge-danger"><s:property value="#session.ADMIN_MEMBER.newprompt" /></span></s:if><i class="Hui-iconfont" style="font-size:18px">&#xe68a;</i></a> </li>
                            <li id="Hui-skin" class="dropDown right dropDown_hover"> <a href="javascript:;" class="dropDown_A" title="换肤"><i class="Hui-iconfont" style="font-size:18px">&#xe62a;</i></a>
                                <ul class="dropDown-menu menu radius box-shadow">
                                    <li><a href="javascript:;" data-val="default" title="默认（黑色）">默认（黑色）</a></li>
                                    <li><a href="javascript:;" data-val="blue" title="蓝色">蓝色</a></li>
                                    <li><a href="javascript:;" data-val="green" title="绿色">绿色</a></li>
                                    <li><a href="javascript:;" data-val="red" title="红色">红色</a></li>
                                    <li><a href="javascript:;" data-val="yellow" title="黄色">黄色</a></li>
                                    <li><a href="javascript:;" data-val="orange" title="绿色">橙色</a></li>
                                </ul>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </header>

    </body>
</html>
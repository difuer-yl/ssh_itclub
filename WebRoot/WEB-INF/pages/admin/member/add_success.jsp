<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
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
        <title>添加用户 - itclub</title>
    </head>
    <body>
        <article class="page-container">
            <center><s:actionmessage />
                <a href="member_add" class="btn btn-primary radius" >继续添加</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" class="btn btn-primary radius exit" value="退出" /></center>
        </article>

        <!--_footer 作为公共模版分离出去--> 
        <!--/_footer /作为公共模版分离出去--> 

        <!--请在下方写此页面业务相关的脚本--> 
        <script type="text/javascript">
            $(function () {
                $('body').on('click', '.exit', function () {
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index);
                });
            });
        </script> 
        <!--/请在上方写此页面业务相关的脚本-->
    </body>
</html>
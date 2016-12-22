
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/source/css/header.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/source/css/search-form.css" />


        <!--顶部导航开始-->
        <div class="top">

            <div id="top_m">

                <div id="top_l">
${name}
                    <a href="javascript:void(0);" onclick="AddFavorite('IT俱乐部', location.href)">
                        <div id="top_l1">
                            <img src="${pageContext.request.contextPath}/source/images/shoucang.png" alt=""/>
                    </div>收藏本站</a>  
                <!--  <a href="javascript:void(0);" onclick="SetHome(this,'http://www.ecmoban.com');">设为首页</a>-->
            </div>

            <div id="top_r">
                <div id="top_r1">
                    <img src="source/images/headp.png" />
                </div>
                <s:if test=""></s:if>
                    <ul>
						<s:if test="#session.MEMBER_INFO ==null">
                           <li><a href="member_login">登录</a></li><li><a href="member_regist">注册</a></li></s:if>
                           <s:if test="#session.MEMBER_INFO !=null">
                           <li style="width: 50px"><a href="#"><s:property value="#session.MEMBER_INFO.username " /> </a></li><li><a href="#">消息（<s:property value="#session.MEMBER_INFO.newprompt" />）</a></li><li><a href="#">设置</a></li><li><a href="member_signout">退出</a></li>
                           </s:if>
                </ul>

            </div>
        </div>
    </div>
    <!--顶部导航结束-->

    <!--头部开始-->
    <div class="hd">
        <div id="hd_m">
            <div id="hd_l">
                <a href="index"><img src="${pageContext.request.contextPath}/source/images/logo.png" alt="IT俱乐部" /></a>
            </div>
            <div id="hd_nav">
                <ul>
                    <li class="index"><a href="index">首页</a></li>
                    <li class="forum"><a href="forum">论坛</a></li>
                    <li><a href="#">空间</a></li>
                    <li><a href="#">文化</a></li>
                    <li><a href="#">部门</a></li>
                    <li><a href="#">名人</a></li>
                    <li><a href="#">成员</a></li>
                </ul>
            </div>

            <!-- 头部搜索 start -->
            <div id="hd_r">
                <form onsubmit="">
                    <div class="search-wrapper active">
                        <div class="input-holder">
                            <input type="text" class="search-input" placeholder="请输入搜索内容" />
                            <!--<button class="search-icon" onclick=""><span></span></button>-->
                            <button class="search-icon" onclick=""><img src="${pageContext.request.contextPath}/source/images/search.png" alt="" /></button>
                        </div>
                    </div>
                </form>
            </div>
            <!-- 头部搜索 end -->
        </div>
    </div>
    <!--头部结束-->

<script type="text/javascript" src="${pageContext.request.contextPath}/source/js/default.js"></script>
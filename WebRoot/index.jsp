<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>加载中...  -IT俱乐部</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<META HTTP-EQUIV="Refresh" CONTENT="0;URL=index">
<style type="text/css">
	.main{
		width: 100%;
		height: auto;
		padding-top: 100px;
	}
	a{
		display: block;
		text-align: center;
		font-size: 20px;
		margin-top: 200px;
	}
	.loading{
		width: 80px;
		height: 40px;
		margin: 0 auto;
		margin-top:100px;
	}
	.loading span{
		display: inline-block;
		width: 8px;
		height: 100%;
		border-radius: 4px;
		background: lightgreen;
		-webkit-animation: load 1s ease infinite;
		animation: load 1s ease infinite;
	}
	@-webkit-keyframes load{
		0%,100%{
			height: 40px;
			background: lightgreen;
		}
		50%{
			height: 70px;
			margin: -15px 0;
			background: lightblue;
		}
	}
	.loading span:nth-child(2){
		-webkit-animation-delay:0.2s;
		animation-delay:0.2s;
	}
	.loading span:nth-child(3){
		-webkit-animation-delay:0.4s;
		animation-delay:0.4s;
	}
	.loading span:nth-child(4){
		-webkit-animation-delay:0.6s;
		animation-delay:0.6s;
	}
	.loading span:nth-child(5){
		-webkit-animation-delay:0.8s;
		animation-delay:0.8s;
	}
</style>
  </head>
  
  <body>
    <div class="main">
	<div class="loading">
		<span></span>
		<span></span>
		<span></span>
		<span></span>
		<span></span>
	</div>
</div>
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/source/extension/treegrid/jquery.treegrid.css"
	type="text/css">
<%@include file="../css.jsp"%>
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>栏目管理</title>
</head>
<body>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>
		系统管理 <span class="c-gray en">&gt;</span> 菜单管理 <a
			class="btn btn-success radius r"
			style="line-height:1.6em;margin-top:3px"
			href="javascript:location.replace(location.href);" title="刷新"><i
			class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
	<div class="page-container">
		<div class="text-c">
			<input type="text" name="" id="" placeholder="栏目名称、id"
				style="width:250px" class="input-text">
			<button name="" id="" class="btn btn-success" type="submit">
				<i class="Hui-iconfont">&#xe665;</i> 搜索
			</button>
		</div>
		<div class="cl pd-5 bg-1 bk-gray mt-20">
			<span class="l"><a href="javascript:;" onclick="datadel()"
				class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i>
					批量删除</a> <a class="btn btn-primary radius"
				onclick="system_category_add('添加菜单','system_category_add')"
				href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加菜单</a></span> <span
				class="r">共有数据：<strong>54</strong> 条
			</span>
		</div>
		<div class="mt-20">
			<table
				class="table table-border table-bordered table-hover table-bg table-sort tree">
				<thead>
					<tr class="text-c">
						<th width="25"></th>
						<th>栏目名称</th>
						<th>图标</th>
						<th>路径</th>
						<th width="100">操作</th>
					</tr>
				</thead>
				<tbody>
				
					<s:iterator id="adminmenu" value="adminMenuList">
					<tr class="text-c treegrid-${adminmenu.id} <s:if test="#adminmenu.level!=1">treegrid-parent-${adminmenu.parentId}</s:if> ">
						<td></td>
						
						<td class="text-l">${adminmenu.name}</td>
						<td>${adminmenu.icon}</td>
						<td>${adminmenu.path}</td>
						<td class="f-14"><a title="编辑" href="javascript:;"
							onclick="system_category_edit('菜单编辑','system_category_edit',${adminmenu.id},'700','480')"
							style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a>
							<a title="删除" href="javascript:;"
							onclick="system_category_del(this,${adminmenu.id})" class="ml-5"
							style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
					</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>



	</div>
	<%@include file="../js.jsp"%>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/source/extension/treegrid/jquery.treegrid.min.js"></script>
	<script type="text/javascript">
		/*$('.table-sort').dataTable({
			"aaSorting" : [ [ 1, "asc" ] ],//默认第几个排序
			"bStateSave" : true,//状态保存
			"aoColumnDefs" : [
			//{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
			{
				"orderable" : false,
				"aTargets" : [ 0, 4 ]
			} // 制定列不参与排序
			]
		});*/
		/*系统-栏目-添加*/
		function system_category_add(title, url, w, h) {
			layer_show(title, url, w, h);
		}
		/*系统-栏目-编辑*/
		function system_category_edit(title, url, id, w, h) {
			layer_show(title, url+"?id="+id, w, h);
		}
		/*系统-栏目-删除*/
		function system_category_del(obj, id) {
			layer.confirm('确认要删除吗？', function(index) {
				 $.ajax({url: "system_category_del?id=" + id, success: function (result) {
                            if (result) {
                                $(obj).parents("tr").remove();
                                layer.msg('删除成功!', {icon: 1, time: 1000});
                            } else {
                                layer.msg('删除失败!', {icon: 2, time: 1000});

                            }
                        }});
			});
		}
	</script>
	<script type="text/javascript">
		$('.tree').treegrid();
	</script>
</body>
</html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<LINK rel="Bookmark" href="/favicon.ico">
<LINK rel="Shortcut Icon" href="/favicon.ico" />

<%@include file="../css.jsp"%>
<link
	href="${pageContext.request.contextPath}/source/extension/uploadify/uploadify.css">

<title>栏目设置</title>

</head>
<body>
	<div class="page-container">
		<form action="system_category_edit_success" method="post" class="form form-horizontal" id="form-category-add">
			<div id="tab-category" class="HuiTab">
				<div class="">
					<div class="row cl">
						<!--  <input type="file" id="personalInfoUpload"/>
						<br> 图片预览
						<div id="showImage"></div>-->
						<label class="form-label col-xs-4 col-sm-3">
							<span class="c-red">*</span>上级菜单：</label> 
							<input hidden="hidden" id="parent_id" name="parentId" value="${menu.id }" />
						<div class="formControls col-xs-8 col-sm-9">
							<span class="select-box"> 
							<select class="select" id="sel_Sub" name="" onchange="setParentId(this)">
									<option value="0">顶级菜单</option>
									<s:if test="adminMenuList.size!=0">
										<s:iterator id="category" value="adminMenuList">
											<option value="${category.id}">&nbsp;&nbsp;├
												${category.name}</option>
										</s:iterator>
									</s:if>
							</select>
							</span>
						</div>
						<div class="col-3"></div>
					</div>
					<div class="row cl">
						<label class="form-label col-xs-4 col-sm-3"><span
							class="c-red">*</span>菜单名称：</label>
						<div class="formControls col-xs-8 col-sm-9">
							<input type="text" class="input-text" value="${menu.name }" placeholder=""
								id="" name="name" datatype="*2-16" nullmsg="用户名不能为空" />
						</div>
						<div class="col-3"></div>
					</div>
					<div class="row cl">
						<label class="form-label col-xs-4 col-sm-3">图标：</label>
						<div class="formControls col-xs-8 col-sm-9">
							<input type="text" class="input-text" value="${menu.icon }" placeholder=""
								id="" name="icon" />
						</div>
						<div class="col-3"></div>
					</div>
					<div class="row cl">
						<label class="form-label col-xs-4 col-sm-3">路径：</label>
						<div class="formControls col-xs-8 col-sm-9">
							<input type="text" class="input-text" value="${menu.path }" placeholder=""
								id="" name="path">
						</div>
						<div class="col-3"></div>
					</div>
					<div class="row cl">
						<label class="form-label col-xs-4 col-sm-3">内容类型：</label>
						<div class="formControls col-xs-8 col-sm-9">
							<span class="select-box"> <select name="" class="select">
									<option value="1">文章</option>
									<option value="2">图片</option>
									<option value="3">商品</option>
									<option value="4">视频</option>
									<option value="5">专题</option>
									<option value="6">链接</option>
							</select>
							</span>
						</div>
						<div class="col-3"></div>
					</div>
					<div class="row cl">
						<label class="form-label col-xs-4 col-sm-3">是否生成静态html：</label>
						<div class="formControls col-xs-8 col-sm-9 skin-minimal">
							<div class="check-box">
								<input type="checkbox" id="checkbox-pinglun"> <label
									for="checkbox-pinglun">&nbsp;</label>
							</div>
						</div>
						<div class="col-3"></div>
					</div>
				</div>
				<div class="tabCon">
					<div class="row cl">
						<label class="form-label col-xs-4 col-sm-3">首页模版：</label>
						<div class="formControls col-xs-8 col-sm-9">
							<input type="text" class="input-text" value=""
								style="width:200px;"> <input type="button"
								class="btn btn-default" value="浏览">
						</div>
						<div class="col-3"></div>
					</div>
					<div class="row cl">
						<label class="form-label col-xs-4 col-sm-3">列表页模版：</label>
						<div class="formControls col-xs-8 col-sm-9">
							<input type="text" class="input-text" value=""
								style="width:200px;"> <input type="button"
								class="btn btn-default" value="浏览">
						</div>
						<div class="col-3"></div>
					</div>
					<div class="row cl">
						<label class="form-label col-xs-4 col-sm-3">详情页模版：</label>
						<div class="formControls col-xs-8 col-sm-9">
							<input type="text" class="input-text" value=""
								style="width:200px;"> <input type="button"
								class="btn btn-default" value="浏览">
						</div>
						<div class="col-3"></div>
					</div>
					<div class="row cl">
						<label class="form-label col-xs-4 col-sm-3">详细页存储规则：</label>
						<div class="formControls col-xs-8 col-sm-9">
							<span class="select-box"> <select class="select" id=""
								name="">
									<option value="1">按年度划子目录</option>
									<option value="2">按年/月划分子目录</option>
									<option value="3">按年/月/日划分子目录</option>
							</select>
							</span>
						</div>
						<div class="col-3"></div>
					</div>
					<div class="row cl">
						<label class="form-label col-xs-4 col-sm-3">每页显示多少条：</label>
						<div class="formControls col-xs-8 col-sm-9">
							<input type="text" class="input-text" value="20"
								style="width:200px;">
						</div>
						<div class="col-3"></div>
					</div>
				</div>
				<div class="tabCon">
					<div class="row cl">
						<label class="form-label col-xs-4 col-sm-3">首页文件名：</label>
						<div class="formControls col-xs-8 col-sm-9">
							<input type="text" class="input-text" value="index.html"
								style="width:200px;">
						</div>
						<div class="col-3"></div>
					</div>
					<div class="row cl">
						<label class="form-label col-xs-4 col-sm-3">关键词：</label>
						<div class="formControls col-xs-8 col-sm-9">
							<input type="text" class="input-text" value="">
						</div>
						<div class="col-3"></div>
					</div>
					<div class="row cl">
						<label class="form-label col-xs-4 col-sm-3">描述：</label>
						<div class="formControls col-xs-8 col-sm-9">
							<textarea name="" cols="" rows="" class="textarea"
								placeholder="说点什么...最少输入10个字符" datatype="*10-100"
								dragonfly="true" nullmsg="备注不能为空！"
								onKeyUp="textarealength(this,100)"></textarea>
							<p class="textarea-numberbar">
								<em class="textarea-length">0</em>/100
							</p>
						</div>
						<div class="col-3"></div>
					</div>
				</div>
			</div>
			<div class="row cl">
				<div class="col-9 col-offset-3">
					<input class="btn btn-primary radius" type="submit"
						value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
				</div>
			</div>
		</form>
	</div>
	</div>
	<%@include file="../js.jsp"%>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/source/extension/uploadify/jquery.uploadify.min.js"></script>

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript">
		$(function() {
			function FileUpload(buttonId) {
				$.ajaxFileUpload({
					url : 'fileUpload!upload',// 用于文件上传的服务器端请求地址
					type : "post",
					dataType : "json",
					timeout : 1000,
					secureuri : false,// 一般设置为false
					fileElementId : uploadId,// 文件上传空间的id属性 <input type="file" id="uploadId" />
					error : function(XMLHttpRequest, textStatus, errorThrown) {

					},
					success : function(data) {

					}

				});

				$('.skin-minimal input').iCheck({
					checkboxClass : 'icheckbox-blue',
					radioClass : 'iradio-blue',
					increaseArea : '20%'
				});

				$("#form-category-add").validate({
					rules : {
						parent_id : {
							required : true,
						},
						name : {
							required : true,
						},
						icon : {
							required : true,
						},
						path : {
							isMobile : true,
						},
					},
					onkeyup : false,
					focusCleanup : true,
					success : "valid",
					submitHandler : function(form) {
						var a = $(form).ajaxSubmit();
						var index = parent.layer.getFrameIndex(window.name);
						//parent.$('.btn-refresh').click();
						//提示层

						layer.msg('玩命提示中');

						parent.layer.close(index);
					}
				});

			}
			;

		});

		$(function() {//等同于$(document).ready(function(){});说明此函数在页面加载完后被调用
			$("#personalInfoUpload").uploadify(
				{
					buttonText : '上传头像',// 按钮的显示文本
					height : 25,//按钮高度30
					swf : '${pageContext.request.contextPath}/source/extension/uploadify/uploadify.swf',//起到提交文件作用的flash
					uploader : '${pageContext.request.contextPath}/fileAction',//异步提交的后台路径（action的路径）
					width : 150,//按钮的宽120
					fileSizeLimit : '2048KB',// 上传文件的最大限制	
					onUploadSuccess : function(object, path) {//上传成功的回调方法
					$("#showImage").html(
						"<img src='"+path+"'/>");
					},
			});
			
						
							
		});
		function setParentId(e){
				var v=$("#sel_Sub").val();
				$("#parent_id").attr("value",v);
			}	
	</script>
	<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>

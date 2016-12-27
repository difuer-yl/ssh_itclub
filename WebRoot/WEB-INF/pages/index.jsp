<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/source/css/style.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/source/css/base.css" />
<title>IT</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/source/js/jquery.min.js"></script>

<!-- lunbotu -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/source/css/slideshows.css" />

<script
	src="${pageContext.request.contextPath}/source/js/jquery.cycle.all.js"></script>
<script
	src="${pageContext.request.contextPath}/source/js/jquery.easing.1.3.js"></script>
<script>
	$(function() {
		$('#slideshow_1')
				.cycle(
						{
							fx : 'scrollHorz',
							easing : 'easeInOutCirc',
							speed : 700,
							timeout : 5000,
							pager : '.ss1_wrapper .slideshow_paging',
							before : function(currSlideElement,
									nextSlideElement) {
								var data = $('.data', $(nextSlideElement))
										.html();
								$('.ss1_wrapper .slideshow_box .data')
										.fadeOut(
												300,
												function() {
													$(
															'.ss1_wrapper .slideshow_box .data')
															.remove();
													$(
															'<div class="data">'
																	+ data
																	+ '</div>')
															.hide()
															.appendTo(
																	'.ss1_wrapper .slideshow_box')
															.fadeIn(600);
												});
							}
						});
		$('.ss1_wrapper').mouseenter(function() {
			$('#slideshow_1').cycle('pause');
		}).mouseleave(function() {
			$('#slideshow_1').cycle('resume');
		});

		$('a[href="#"]').click(function(event) {
			event.preventDefault();
		});
	});
</script>
<!-- end -->


</head>
<%@include file="/WEB-INF/pages/header.jsp"%>

<!--body开始-->
<div class="bd">
	<div class="baer">
		<!-- 轮播图 begin -->
		<div class="ss1_wrapper">
			<div class="slideshow_paging"></div>
			<div class="slideshow_box">
				<div class="data"></div>
			</div>
			<div id="slideshow_1" class="slideshow">
				<div class="slideshow_item">
					<div class="image">
						<a href="#"><img
							src="${pageContext.request.contextPath}/source/images/pic1.jpg"
							alt="photo 2" width="1166" height="435px" /></a>
					</div>
					<div class="data">
						<h4 class="lunbo_t">
							<a href="#">Donec sollicitudin enim sit</a>
						</h4>
						<p class='lunbo_c'>Sed mollis tristique lectus vitae aliquet.
							Quisque vitae metus ut velit varius feugiat. Maecenas luctus
							pulvinar elit et viverra. Aenean vel est nulla.</p>
						<p class="right">-作者</p>
					</div>
				</div>
				<div class="slideshow_item">
					<div class="image">
						<a href="#"><img
							src="${pageContext.request.contextPath}/source/images/pic2.jpg"
							alt="photo 3" width="1166" height="435px" /></a>
					</div>
					<div class="data">
						<h4>
							<a href="#">Pellentesque lacinia metus</a>
						</h4>
						<p>Integer pretium volutpat ligula sit amet pretium. Morbi
							nisi dui, rutrum ut bibendum sit amet, gravida eget dui.</p>
					</div>
				</div>
				<div class="slideshow_item">
					<div class="image">
						<a href="#"><img
							src="${pageContext.request.contextPath}/source/images/pic3.jpg"
							alt="photo 1" width="1166" height="435px" /></a>
					</div>
					<div class="data">
						<h4>
							<a href="#">Lorem ipsum dolor sit amet</a>
						</h4>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
							Donec sollicitudin enim sit amet dolor posuere dictum.
							Pellentesque lacinia metus non erat auctor vehicula.</p>
					</div>
				</div>
				<div class="slideshow_item">
					<div class="image">
						<a href="#"><img
							src="${pageContext.request.contextPath}/source/images/pic4.jpg"
							alt="photo 4" width="1166" height="435px" /></a>
					</div>
					<div class="data">
						<h4>
							<a href="#">Morbi nisi dui bibendum sit amet</a>
						</h4>
						<p>Aliquam feugiat lorem at massa pulvinar interdum. Ut nulla
							est, vulputate eget facilisis vel, cursus nec sapien. Quisque
							tincidunt adipiscing lorem, tincidunt sodales lorem imperdiet
							quis.</p>
					</div>
				</div>
				<div class="slideshow_item">
					<div class="image">
						<a href="#"><img
							src="${pageContext.request.contextPath}/source/images/pic5.jpg"
							alt="photo 4" width="1166" height="435px" /></a>
					</div>
					<div class="data">
						<h4>
							<a href="#">Morbi nisi dui bibendum sit amet</a>
						</h4>
						<p>Aliquam feugiat lorem at massa pulvinar interdum. Ut nulla
							est, vulputate eget facilisis vel, cursus nec sapien. Quisque
							tincidunt adipiscing lorem, tincidunt sodales lorem imperdiet
							quis.</p>
					</div>
				</div>
			</div>
		</div>
		<!-- 轮播图 end -->
	</div>
	<!--news begin-->

	<div class="news">
		<div class="box1">
			<div id="news_logo">
				<img
					src="${pageContext.request.contextPath}/source/images/news_logo.png" />
				<span>热点新闻</span>
				<div id="tex">
					<h3>HTML5可被用于隐藏恶意程序</h3>
					<p>意大利研究人员在预印本网站发表报告，提出了一种新的代码混淆技术，可被用于成功发动偷渡式下载攻击，欺骗恶的</p>

					<ul>
						<li>黑客:初级玩盗号 高级玩卫星</li>
						<li>黑客:初级玩盗号 高级玩卫星</li>
						<li>黑客:初级玩盗号 高级玩卫星</li>
						<li>黑客:初级玩盗号 高级玩卫星</li>
					</ul>

				</div>
			</div>

		</div>

		<div class="box2">
			<div id="news_logo">
				<img
					src="${pageContext.request.contextPath}/source/images/active.png" />
				<span>学术活动</span>

				<div id="tex">
					<h3>HTML5可被用于隐藏恶意程序</h3>
					<p>意大利研究人员在预印本网站发表报告，提出了一种新的代码混淆技术，可被用于成功发动偷渡式下载攻击，欺骗恶的</p>

					<ul>
						<li>黑客:初级玩盗号 高级玩卫星</li>
						<li>黑客:初级玩盗号 高级玩卫星</li>
						<li>黑客:初级玩盗号 高级玩卫星</li>
						<li>黑客:初级玩盗号 高级玩卫星</li>
					</ul>

				</div>

			</div>
		</div>

		<div class="box3">
			<div id="news_logo">
				<img src="${pageContext.request.contextPath}/source/images/note.png" />
				<span>通知公告</span>

				<div id="tex">
					<h3>HTML5可被用于隐藏恶意程序</h3>
					<p>意大利研究人员在预印本网站发表报告，提出了一种新的代码混淆技术，可被用于成功发动偷渡式下载攻击，欺骗恶的</p>

					<ul>
						<li>黑客:初级玩盗号 高级玩卫星</li>
						<li>黑客:初级玩盗号 高级玩卫星</li>
						<li>黑客:初级玩盗号 高级玩卫星</li>
						<li>黑客:初级玩盗号 高级玩卫星</li>
					</ul>

				</div>

			</div>
		</div>

	</div>

	<!--news end-->
	<!--talk begin-->

	<div class="talk">
		<div class="talk_top">
			<div class="talk_l">
				<img src="${pageContext.request.contextPath}/source/images/ioc.png" />
				<span>专题讨论</span>

			</div>

			<div class="talk_r">
				<span>往期专题</span> <img
					src="${pageContext.request.contextPath}/source/images/ioc.png" />
			</div>

		</div>

		<div class="talk_foot">
			<div id="photo"></div>
			<div id="box_1">
				<span><h3>HTML5可被用于隐藏恶意程序</h3>
					<p>意大利研究人员在预印本网站发表报告，提出了一种新的代码混淆技术，可被用于成功发动偷渡式下载攻击，欺骗恶研究人员在预印本网站发表报告，提出了一种新的代码混淆技术，可被用于成功发动偷渡式下载攻击，欺研究人员在预印本网站发表报告，提出了一种新的代码混淆技术，可被用于成功发动偷渡式下载攻击，欺的</p>

					<p1>查看详情>></p1> </span>
			</div>

			<div id="box_2">


				<div id="box_l">
					<img
						src="${pageContext.request.contextPath}/source/images/yuan.png" />
					<img
						src="${pageContext.request.contextPath}/source/images/yuan.png" />
					<img
						src="${pageContext.request.contextPath}/source/images/yuan.png" />
				</div>

				<div id="box_r">
					<ul>
						<li><a href='SpecialTopic_RecruitNewCommunity'>【2016年】社团招新</a></li>
						<li>恶研究人员在预印本网站发表报告，提出了一种新的代码混淆技术，可</li>
						<li>恶研究人员在预印本网站发表报告，提出了一种新的代码混淆技术，可</li>
					</ul>

				</div>

			</div>


		</div>






	</div>

	<!--talk end-->

	<!--pic begin-->

	<div class="pic">
		<div class="pic_top">
			<img src="${pageContext.request.contextPath}/source/images/ioc.png" />
			<span>图文展示</span>

		</div>

		<div class="pic_foot">
			<div class="box_pic1"></div>

			<div class="box_pic2">

				<div class="box_pic2_1"></div>

				<div class="box_pic2_2"></div>

				<div class="box_pic2_3"></div>

				<div class="box_pic2_4"></div>

			</div>

			<div class="box_pic3"></div>


		</div>


	</div>

	<!--pic end-->

	<!--link end-->
	<div class="link">
		<div class="link_top" style="height: 40px;">
			<img src="${pageContext.request.contextPath}/source/images/ioc.png" />
			<span>友情社团</span>

		</div>
		<div class="friendlinks">
			<s:iterator id="friendlink" value="friendlinks">
				<div class="friendlink">
					<a href="${friendlink.url }"><img src="${friendlink.logo }"
						alt="${friendlink.name }" width="100px" title="${friendlink.name }---${friendlink.description}"/></a>
				</div>
			</s:iterator>
		</div>
	</div>
	<!--link end-->
</div>

<!--body结束-->


<!--footer begin-->
<%@include file="/WEB-INF/pages/footer.jsp"%>
<!--footer end-->

<script type="text/javascript">
	//设为首页
	function SetHome(obj, url) {
		try {
			obj.style.behavior = 'url(#default#homepage)';
			obj.setHomePage(url);
		} catch (e) {
			if (window.netscape) {
				try {
					netscape.security.PrivilegeManager
							.enablePrivilege("UniversalXPConnect");
				} catch (e) {
					alert("抱歉，此操作被浏览器拒绝！nn请在浏览器地址栏输入“about:config”并回车然后将[signed.applets.codebase_principal_support]设置为'true'");
				}
			} else {
				alert("抱歉，您所使用的浏览器无法完成此操作。nn您需要手动将【" + url + "】设置为首页。");
			}
		}
	}

	//收藏本站 bbs.ecmoban.com
	function AddFavorite(title, url) {
		try {
			window.external.addFavorite(url, title);
		} catch (e) {
			try {
				window.sidebar.addPanel(title, url, "");
			} catch (e) {
				alert("抱歉，您所使用的浏览器无法完成此操作。" + title + "加入收藏失败，请使用Ctrl+D进行添加");
			}
		}
	}
</script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/source/js/default.js"></script>
</body>
</html>

<%-- 
    Document   : invite
    Created on : 2016-11-10, 17:30:13
    Author     : chiaki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <meta charset="utf-8"/>
        <meta name="renderer" content="webkit|ie-comp|ie-stand"/>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
        <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
        <meta http-equiv="Cache-Control" content="no-siteapp" />
        <%@include file="../css.jsp" %>
        <title>邀请码管理</title>
    </head>
    <body>
        <nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 用户中心 <span class="c-gray en">&gt;</span> 邀请码管理 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
        <div class="page-container">
            <div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> <a href="javascript:;" onclick="member_add('添加用户', 'member_add', '', '510')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加用户</a></span> <span class="r">共有数据：<strong>${list.size()}</strong> 条</span> </div>
            <div class="mt-20">
                <table class="table table-border table-bordered table-hover table-bg table-sort">
                    <thead>
                        <tr class="text-c">
                            <th width="25"><input type="checkbox" name="" value=""></th>
                            <th width="80">ID</th>
                            <th width="100">用户名</th>
                            <th width="40">性别</th>
                            <th width="90">手机</th>
                            <th width="150">邮箱</th>
                            <th width="130">加入时间</th>
                            <th width="70">状态</th>
                            <th width="100">操作</th>
                        </tr>
                    </thead>
                    <tbody>
                        <s:iterator id="member" value="list">
                            <tr class="text-c">
                                <td><input type="checkbox" value="1" name=""></td>
                                <td>${member.id}</td>
                                <td><u style="cursor:pointer" class="text-primary" onclick="member_show('张三', 'member-show.html', '10001', '360', '400')">${member.username}</u></td>
                                <td><c:choose>
                                        <c:when test="${member.sex==0}">女</c:when>
                                        <c:when test="${member.sex==1}">男</c:when>
                                    </c:choose></td>
                                <td>${member.mobil}</td>
                                <td>${member.email}</td>
                                <td>${member.regdate}</td>
                                <td class="td-status"><span class="label label-success radius">已启用</span></td>
                                <td class="td-manage">
                                    <a title="编辑" href="javascript:;" onclick="member_edit('编辑', 'member_edit', ${member.id}, '', '410')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a> 
                                    <a title="删除" href="javascript:;" onclick="member_del(this, ${member.id})" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
                            </tr>
                        </s:iterator>
                    </tbody>
                </table>
            </div>
        </div>
        <%@include file="../js.jsp" %>
        <script type="text/javascript">
            $(function () {
                $('.table-sort').dataTable({
                    "aaSorting": [[1, "asc"]], //默认第几个排序
                    "bStateSave": true, //状态保存
                    "aoColumnDefs": [
                        //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
                        {"orderable": false, "aTargets": [0, 7, 8]}// 制定列不参与排序
                    ]
                });
                $('.table-sort tbody').on('click', 'tr', function () {
                    if ($(this).hasClass('selected')) {
                        $(this).removeClass('selected');
                    } else {
                        table.$('tr.selected').removeClass('selected');
                        $(this).addClass('selected');
                    }
                });
            });
            /*用户-添加*/
            function member_add(title, url, w, h) {
                layer_show(title, url, w, h);
            }
            /*用户-查看*/
            function member_show(title, url, id, w, h) {
                layer_show(title, url, w, h);
            }
            /*用户-编辑*/
            function member_edit(title, url, id, w, h) {
                layer_show(title, url + "?id=" + id, w, h);
            }
            /*密码-修改*/
            function change_password(title, url, id, w, h) {
                layer_show(title, url, w, h);
            }
            /*用户-删除*/
            function member_del(obj, id) {
                layer.confirm('确认要删除吗？', function (index) {
                    $.ajax({url: "member_del?id=" + id, success: function (result) {
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
    </body>
</html>
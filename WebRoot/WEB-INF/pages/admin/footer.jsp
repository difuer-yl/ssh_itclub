<%-- 
    Document   : footer
    Created on : 2016-11-29, 15:05:11
    Author     : luoyu <chiaki@difuer.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <script type="text/javascript" src="../source/js/jquery.min.js"></script> 
        <script type="text/javascript" src="../source/extension/layer/2.1/layer.js"></script>
        <script type="text/javascript" src="../source/extension/laypage/1.2/laypage.js"></script> 
        <script type="text/javascript" src="../source/extension/My97DatePicker/WdatePicker.js"></script> 
        <script type="text/javascript" src="../source/extension/datatables/1.10.0/jquery.dataTables.min.js"></script> 
        <script type="text/javascript" src="../source/js/admin/H-ui.js"></script> 
        <script type="text/javascript" src="../source/js/admin/H-ui.admin.js"></script> 
        <script type="text/javascript">
            /*资讯-添加*/
            function article_add(title, url) {
                var index = layer.open({
                    type: 2,
                    title: title,
                    content: url
                });
                layer.full(index);
            }
            /*图片-添加*/
            function picture_add(title, url) {
                var index = layer.open({
                    type: 2,
                    title: title,
                    content: url
                });
                layer.full(index);
            }
            /*产品-添加*/
            function product_add(title, url) {
                var index = layer.open({
                    type: 2,
                    title: title,
                    content: url
                });
                layer.full(index);
            }
            /*用户-添加*/
            function member_add(title, url, w, h) {
                layer_show(title, url, w, h);
            }
        </script> 

    </body>
</html>

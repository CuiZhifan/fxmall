<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/4/13
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/fxmall/Goods/GoodsAdd" method="post" enctype="multipart/form-data">
        <input type="text" name="goodName">
        <<input type="text" name="orderNo">
        <input type="file" name="uploadpic2">
        <input type="submit" value="提交">
    </form>
</body>
</html>

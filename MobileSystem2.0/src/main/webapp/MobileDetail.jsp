<%--
  Created by IntelliJ IDEA.
  User: 24529
  Date: 2021/8/11
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<h1 align="center">手机详细页面</h1>
<table class="table" style="width: 800px" align="center">
    <tr>
        <td>品牌</td>
        <td>${mobile.brand}</td>
    </tr>
    <tr>
        <td>型号</td>
        <td>${mobile.type}</td>
    </tr>
    <tr>
        <td>价格</td>
        <td>${mobile.price}</td>
    </tr>
    <tr>
        <td>照片</td>
        <td><img src="images/${mobile.imageUrl}" class="rounded" alt=""></td>
    </tr>
</table>
<div align="center">
    <a href="pageMobile">
        <button type="button" class="btn btn-outline-success">回到手机商场</button>
    </a>
</div>
</body>
</html>

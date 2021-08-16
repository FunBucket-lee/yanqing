<%--
  Created by IntelliJ IDEA.
  User: 24529
  Date: 2021/8/11
  Time: 14:22
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
<h1 align="center">书籍详细</h1>
<table class="table table-striped" style="width: 500px" align="center">
    <tr>
        <td>编号</td>
        <td>${book.id}</td>
    </tr>
    <tr>
        <td>书名</td>
        <td>${book.name}</td>
    </tr>
    <tr>
        <td>价格</td>
        <td>${book.price}</td>
    </tr>
    <tr>
        <td>类别</td>
        <td>${book.category}</td>
    </tr>
    <tr>
        <td>库存</td>
        <td>${book.pnum}</td>
    </tr>
    <tr>
        <td>图片</td>
        <td><img class="rounded" src="images/${book.imgurl}" alt=""></td>
    </tr>
    <tr>
        <td>描述</td>
        <td>${book.description}</td>
    </tr>
    <tr>
        <td>作者</td>
        <td>${book.author}</td>
    </tr>
    <tr>
        <td>销量</td>
        <td>${book.sales}</td>
    </tr>
</table>
<div align="center">
    <a href="findAllBooks">
        <button type="button" class="btn btn-outline-success">回到图书列表</button>
    </a>
</div>
</body>
</html>

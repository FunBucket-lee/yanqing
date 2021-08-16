<%--
  Created by IntelliJ IDEA.
  User: 24529
  Date: 2021/8/10
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous">
    </script>
</head>
<body>
<h1>欢迎来到手机商城</h1>
<table class="table">
    <thead>
    <tr>
        <td>品牌</td>
        <td>型号</td>
        <td>详细信息</td>
        <td>购物车</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${all}" var="mobile">
        <tr>
            <td>${mobile.brand}</td>
            <td>${mobile.type}</td>
            <td><a href="mobileDetail?id=${mobile.id}" style="text-decoration: none" class="link-success">详细连接</a></td>
            <td><a href="addCart?id=${mobile.id}" style="text-decoration: none" class="link-success">加入购物车</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<hr>
<h5>最近浏览记录</h5>
<c:forEach items="${history}" var="mobile">
    <h6>${mobile.brand}  ${mobile.type}</h6>
</c:forEach>
<hr>
<a href="home">
    <button type="button" class="btn btn-success">回到主页面</button>
</a>
<a href="showCart">
    <button type="button" class="btn btn-success">查看购物车</button>
</a>
</body>
</html>

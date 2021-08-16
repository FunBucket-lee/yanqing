<%--
  Created by IntelliJ IDEA.
  User: 24529
  Date: 2021/8/11
  Time: 10:47
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
<h1>购物车列表</h1>
<c:if test="${empty cart}">
    <h3>购物车空空如也</h3>
</c:if>
<c:if test="${not empty cart}">
    <table class="table table-striped" align="center">
        <tr>
            <th>编号</th>
            <th>书名</th>
            <th>图片</th>
            <th>价格</th>
            <th>购买数量</th>
        </tr>
        <c:forEach items="${cart}" var="entry">
            <tr>
                <td>${entry.key.id}</td>
                <td>${entry.key.name}</td>
                <td><img class="rounded" src="images/${entry.key.imgurl}" alt=""></td>
                <td>${entry.key.price}</td>
                <td>${entry.value}</td>
            </tr>
        </c:forEach>
    </table>

</c:if>
<div align="center">
    <a href="findAllBooks">
        <button type="button" class="btn btn-outline-success">回到图书列表</button>
    </a>
</div>
</body>
</html>

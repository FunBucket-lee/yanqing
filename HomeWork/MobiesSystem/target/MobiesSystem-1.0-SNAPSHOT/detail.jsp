<%--
  Created by IntelliJ IDEA.
  User: 24529
  Date: 2021/8/10
  Time: 21:53
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
<table class="table">
    <thead>
    <tr>
        <td>编号</td>
        <td>品牌</td>
        <td>型号</td>
        <td>价格</td>
        <td>照片</td>
    </tr>
    </thead>
    <tbody>
    <td>${mobile.id}</td>
    <td>${mobile.brand}</td>
    <td>${mobile.type}</td>
    <td>${mobile.price}</td>
    <td><img src="${mobile.imageUrl}"/></td>
    </tbody>
</table>
<a href="MobileShop">
    <button type="button" class="btn btn-success">回到商城</button>
</a>
</body>
</html>

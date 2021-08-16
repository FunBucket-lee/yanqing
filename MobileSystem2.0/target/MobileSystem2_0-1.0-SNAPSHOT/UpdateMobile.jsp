<%--
  Created by IntelliJ IDEA.
  User: 24529
  Date: 2021/8/11
  Time: 21:38
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
<h1 align="center">修改商品</h1>
<form action="updateMobile" method="post">
  <input type="hidden" name="id" value="${mobile.id}">
  <table class="table table-striped" style="width: 500px" align="center">
    <tr>
      <td>品牌</td>
      <td><input type="text" class="form-control" aria-label="Sizing example input"
                 aria-describedby="inputGroup-sizing-sm" name="brand" value="${mobile.brand}"></td>
    </tr>
    <tr>
      <td>型号</td>
      <td><input type="text" class="form-control" aria-label="Sizing example input"
                 aria-describedby="inputGroup-sizing-sm" name="type" value="${mobile.type}"></td>

    </tr>
    <tr>
      <td>价格</td>
      <td><input type="text" class="form-control" aria-label="Sizing example input"
                 aria-describedby="inputGroup-sizing-sm" name="price" value="${mobile.price}"></td>

    </tr>
    <tr>
      <td>图片</td>
      <td><input type="text" class="form-control" aria-label="Sizing example input"
                 aria-describedby="inputGroup-sizing-sm" name="imageUrl" value="${mobile.imageUrl}"></td>

    </tr>
    <tr>
      <td colspan="2" align="center"><input class="btn btn-primary" type="submit" value="提交"></td>
    </tr>
  </table>
</form>
</body>
</html>

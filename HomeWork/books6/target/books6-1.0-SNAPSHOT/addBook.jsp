<%--
  Created by IntelliJ IDEA.
  User: 24529
  Date: 2021/8/11
  Time: 14:56
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
<h1 align="center">添加图书</h1>
<form action="addBook" method="post">
    <table class="table table-striped" style="width: 500px" align="center">
        <tr>
            <td>书名</td>
            <td><input type="text" class="form-control" aria-label="Sizing example input"
                       aria-describedby="inputGroup-sizing-sm" name="name"></td>
        </tr>
        <tr>
            <td>价格</td>
            <td><input type="text" class="form-control" aria-label="Sizing example input"
                       aria-describedby="inputGroup-sizing-sm" name="price"></td>

        </tr>
        <tr>
            <td>类别</td>
            <td><input type="text" class="form-control" aria-label="Sizing example input"
                       aria-describedby="inputGroup-sizing-sm" name="category"></td>

        </tr>
        <tr>
            <td>库存</td>
            <td><input type="text" class="form-control" aria-label="Sizing example input"
                       aria-describedby="inputGroup-sizing-sm" name="pnum"></td>

        </tr>
        <tr>
            <td>图片</td>
            <td><input type="text" class="form-control" aria-label="Sizing example input"
                       aria-describedby="inputGroup-sizing-sm" name="imgurl"></td>

        </tr>
        <tr>
            <td>描述</td>
            <td><input type="text" class="form-control" aria-label="Sizing example input"
                       aria-describedby="inputGroup-sizing-sm" name="description"></td>

        </tr>
        <tr>
            <td>作者</td>
            <td><input type="text" class="form-control" aria-label="Sizing example input"
                       aria-describedby="inputGroup-sizing-sm" name="author"></td>

        </tr>
        <tr>
            <td>销量</td>
            <td><input type="text" class="form-control" aria-label="Sizing example input"
                       aria-describedby="inputGroup-sizing-sm" name="sales"></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input class="btn btn-primary" type="submit" value="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>

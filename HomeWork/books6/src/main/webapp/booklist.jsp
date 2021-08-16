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
<h1 align="center">图书列表</h1>
<a href="addBook.jsp">
    <button type="button" class="btn btn-success">添加新书</button>
</a>&nbsp;&nbsp;
<a href="ShowCart.jsp">
    <button type="button" class="btn btn-success">显示购物车</button>
</a>
<button type="button" onclick="delCheck()" class="btn btn-success">删除选中</button>
<br>
<div>
    <form action="searchBooks" method="get">
        书名:<input type="text" name="name" placeholder="请输入书名关键字"/>
        <input type="submit" value="搜索">
    </form>
    <br/>
</div>
<br>
<h2>多条件动态查询</h2>
<div>
    <form action="searchBookPage" method="post">
        书名:<input type="text" name="name" placeholder="请输入书名关键字"/><br/>

        类别：<input type="text" name="category" placeholder="请输入类别关键字"/><br/>
        作者：<input type="text" name="author" placeholder="请输入作者"/><br/>
        最低价格：<input type="text" name="minPrice"/>
        最高价：<input type="text" name="maxPrice"/><br/>
        <input type="submit" value="搜索">
    </form>
    <br/>
</div>
<br>
<table class="table table-striped" align="center">
    <tr>
        <th>勾选</th>
        <th>编号</th>
        <th>书名</th>
        <th>价格</th>
        <th>类别</th>
        <th>详情</th>
        <th>修改</th>
        <th>删除</th>
        <th>加入购物车</th>
    </tr>
    <c:forEach items="${pageInfo.list}" var="book">
        <tr>
            <td><input type="checkbox" class="checks" value="${book.id}"></td>
            <td>${book.id}</td>
            <td>${book.name}</td>
            <td>${book.price}</td>
            <td>${book.category}</td>
            <td><a href="bookDetail?id=${book.id}">
                <button type="button" class="btn btn-outline-success">查看详情</button>
            </a></td>
            <td><a href="toUpdate?id=${book.id}">
                <button type="button" class="btn btn-outline-success">修改</button>
            </a></td>
            <td><a href="delBook?id=${book.id}" onclick="return confirm('确定要删除吗?')">
                <button type="button" class="btn btn-outline-success">删除</button>
            </a></td>
            <td><a href="addCart?id=${book.id}">
                <button type="button" class="btn btn-outline-success">加入购物车</button>
            </a></td>
        </tr>
    </c:forEach>
</table>
<div class="btn-group me-2" role="group" align="center">
    <a href="pageBooks?pageNum=${pageInfo.pageNum==1?1:pageInfo.pageNum-1}">
        <button type="button" class="btn btn-secondary">上一页</button>
    </a>
    &nbsp;
    <span>当前页数为${pageInfo.pageNum}/共${pageInfo.pages}页  共${pageInfo.total}条记录</span>
    &nbsp;
    <a href="pageBooks?pageNum=${pageInfo.pageNum==pageInfo.pages?pageInfo.pageNum:pageInfo.pageNum+1}">
        <button type="button" class="btn btn-secondary">下一页</button>
    </a>
</div>
<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.js"></script>
<script>
    function delCheck() {
        let ids = '';
        $(".checks").each(function (i, e) {
            if ($(e).prop('checked') === true) {
                ids += "&id=" + $(e).val();
            }
        });
        if (ids !== '') {
            ids = ids.substr(1);
        }
        alert(ids);
        if (ids === '') {
            alert("你还未选中删除项")
        } else {
            location.href = "deleteBooks?" + ids;
        }
    }
</script>
</body>
</html>

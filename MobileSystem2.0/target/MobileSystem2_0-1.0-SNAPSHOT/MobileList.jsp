<%--
  Created by IntelliJ IDEA.
  User: 24529
  Date: 2021/8/11
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="semantic/dist/semantic.min.css">
    <script
            src="https://code.jquery.com/jquery-3.1.1.min.js"
            integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
            crossorigin="anonymous"></script>
    <script src="semantic/dist/semantic.min.js"></script>
</head>
<body>
<h1 align="center">欢迎进入手机商城</h1>
<a href="AddMobile.jsp" style="text-decoration: none" class="link-success">
    <button type="button" class="btn btn-outline-success btn-sm">增加商品</button>
</a>
<button type="button" id="sbtn" class="btn btn-outline-success btn-sm">
    筛选
</button>
<button type="button" onclick="delCheck()" class="btn btn-outline-success btn-sm">删除所选</button>
<div class="col-md-3" id="select" style="display: none">
    <form action="searchMobile" enctype="multipart/form-data" id="selfrom" method="post">
        <div class="field">
            <label>品牌</label>
            <input type="text" class="form-control" name="brand">
        </div>
        <div class="field">
            <label>型号</label>
            <input type="text" class="form-control" name="type">
        </div>
        <div class="field">
            <label>最低价格</label>
            <input type="text" class="form-control" name="minPrice">
        </div>
        <div class="field">
            <label>最高价格</label>
            <input type="text" class="form-control" name="maxPrice">
        </div>
        <div>
            <button type="submit" class="btn btn-outline-success btn-sm">提交</button>
        </div>
    </form>
</div>
<table class="table table-striped">
    <thead class="table-light">
    <tr>
        <td>选择</td>
        <td>品牌</td>
        <td>型号</td>
        <td>详细信息</td>
        <td>操作</td>
        <td>操作</td>
        <td>购物车</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${pageInfo.list}" var="mobile">
        <tr>
            <td><input class="form-check-input check" type="checkbox" value="${mobile.id}"></td>
            <td>${mobile.brand}</td>
            <td>${mobile.type}</td>
            <td><a href="findById?id=${mobile.id}" style="text-decoration: none" class="link-success">
                <button type="button" class="btn btn-outline-success btn-sm">查看详情</button>
            </a></td>
            <td><a href="toUpdate?id=${mobile.id}" style="text-decoration: none" class="link-success">
                <button type="button" class="btn btn-outline-success btn-sm">修改</button>
            </a></td>
            <td><a href="delMobile?id=${mobile.id}" style="text-decoration: none" class="link-success"
                   onclick="return confirm('确定要删除')">
                <button type="button" class="btn btn-outline-success btn-sm">删除</button>
            </a></td>
            <td><a href="addCart?id=${mobile.id}" style="text-decoration: none" class="link-success">
                <button type="button" class="btn btn-outline-success btn-sm">加入购物车</button>
            </a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
    <div class="btn-group me-2" role="group" aria-label="Second group">
        <span>当前页数为${pageInfo.pageNum}/共${pageInfo.pages}页  共${pageInfo.total}条记录</span>
        &nbsp;
        <a href="pageMobile?pageNum=1">
            <button type="button" class="btn btn-secondary">回到首页</button>
        </a>
        &nbsp;
        <a href="pageMobile?pageNum=${pageInfo.pageNum==1?1:pageInfo.pageNum-1}">
            <button type="button" class="btn btn-secondary">上一页</button>
        </a>
        &nbsp;
        <a href="pageMobile?pageNum=${pageInfo.pageNum==pageInfo.pages?pageInfo.pageNum:pageInfo.pageNum+1}">
            <button type="button" class="btn btn-secondary">下一页</button>
        </a>
    </div>
</div>
<script>
    $("#sbtn").click(function () {
        $('#select').toggle();
    });
    $('selfrom').submit(function () {
        $('#select').hide();
    });

    function delCheck() {
        let ids = '';
        $(".check").each(function (i, e) {
            if ($(e).prop('checked') === true) {
                ids += "&id=" + $(e).val();
            }
        });
        if (ids !== '') {
            ids = ids.substr(1);
        }
        if (ids === '') {
            alert("你还未选中删除项")
        } else {
            location.href = "deleteCheck?" + ids;
        }
    }
</script>
</body>
</html>

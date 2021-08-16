<%--
  Created by IntelliJ IDEA.
  User: 24529
  Date: 2021/8/10
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="i" begin="1" end="10" step="1">
    <h4>${i}砺锋科技</h4>
</c:forEach>
<hr>
<h1>List集合遍历</h1>
<table border="1" cellspacing="0" cellpadding="0" width="700px">
    <tr>
        <td>姓名</td>
        <td>索引</td>
        <td>编号</td>
        <td>是否为第一个</td>
        <td>是否为最后一个</td>
    </tr>
    <c:forEach var="stu" items="${student}" varStatus="vs">
        <tr ${vs.count%2==1?"style='background-color:yellow'":"style='background-color:white'"} >
            <td>${stu}</td>
            <td>${st.index}</td>
            <td>${st.count}</td>
            <td>${st.first}</td>
            <td>${st.last}</td>
        </tr>
    </c:forEach>
</table>
<hr/>
<table border="1" cellspacing="0" cellpadding="0" width="700px">
    <tr>
        <td>编号</td>
        <td>书名</td>
        <td>价格</td>
        <td>作者</td>
    </tr>
    <c:forEach items="${books}" var="book" varStatus="vs">
        <tr ${vs.count%2==1?"style='background-color:yellow'":"style='background-color:white'"}>
            <td>${book.id}</td>
            <td>${book.name}</td>
            <td>${book.price}</td>
            <td>${book.author}</td>
        </tr>
    </c:forEach>
</table>
<hr/>
<h1>Map集合遍历</h1>
<table border="1" cellpadding="0" cellspacing="0" width="700px">
    <tr>
        <td>学号</td>
        <td>姓名</td>
    </tr>
    <c:forEach var="entry" items="${studentMap}" varStatus="vs">
        <tr ${vs.count%2==1?"style='background-color:yellow'":"style='background-color:white'"} >
            <td>${entry.key}</td>
            <td>${entry.value}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

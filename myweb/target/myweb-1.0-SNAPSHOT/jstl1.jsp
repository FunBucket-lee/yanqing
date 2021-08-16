<%--
  Created by IntelliJ IDEA.
  User: 24529
  Date: 2021/8/10
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:set var="score" value="59" scope="page"></c:set>
<c:if test="${score>=60}">
    <h1>恭喜！！成绩及格了</h1>
</c:if>
<c:if test="${score<60}">
    <h1>抱歉！！成绩不及格</h1>
</c:if>

<hr>

成绩等级细分:<br>
<c:choose>
    <c:when test="${score}>=90">优秀</c:when>
    <c:when test="${score}>=80">良好</c:when>
    <c:when test="${score}>=70">中等</c:when>
    <c:when test="${score}>=60">及格</c:when>
    <c:otherwise>
        不及格
    </c:otherwise>
</c:choose>
</body>
</html>

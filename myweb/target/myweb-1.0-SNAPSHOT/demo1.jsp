<%--
  Created by IntelliJ IDEA.
  User: 24529
  Date: 2021/8/9
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    int a = 10;
    int b = 20;
    int c = a + b;
%>
<body>
表达式一：a+b=<%= c%>
<br>
表达式二：a+b=<%= a + b%>
</body>
</html>

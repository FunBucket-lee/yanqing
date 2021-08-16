<%--
  Created by IntelliJ IDEA.
  User: 24529
  Date: 2021/8/9
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
用户名：<%= request.getParameter("username")%><br>
密码：<%= request.getParameter("password")%>
</body>
</html>

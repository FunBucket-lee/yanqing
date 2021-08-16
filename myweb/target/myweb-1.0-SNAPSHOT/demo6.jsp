<%--
  Created by IntelliJ IDEA.
  User: 24529
  Date: 2021/8/9
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<%
    request.getRequestDispatcher("demo7.jsp?username=admin&password=123").forward(request, response);
%>--%>
<jsp:forward page="demo7.jsp">
    <jsp:param name="username" value="admin"/>
    <jsp:param name="password" value="123456"/>
</jsp:forward>
</body>
</html>

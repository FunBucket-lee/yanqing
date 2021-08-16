<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 24529
  Date: 2021/8/9
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
List list = new ArrayList<>();
list.add("aaa");
list.add("bbb");
%>
<%= list%>
<%@include file="header.jsp"%>
<h1>demo3</h1>
</body>
</html>

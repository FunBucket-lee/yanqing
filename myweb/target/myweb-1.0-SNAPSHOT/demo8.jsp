<%--
  Created by IntelliJ IDEA.
  User: 24529
  Date: 2021/8/9
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    pageContext.setAttribute("h", "HelloWorld!!pageContext");
    request.setAttribute("h", "HelloWorld!!request");
    session.setAttribute("h", "HelloWorld!!session");
    application.setAttribute("h", "HelloWorld!!application");
    request.getRequestDispatcher("demo9.jsp").forward(request,response);
    response.sendRedirect("demo9.jsp");
%>
</body>
</html>

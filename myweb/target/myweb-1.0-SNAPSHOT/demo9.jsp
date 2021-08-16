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
<%= pageContext.getAttribute("h")%><br/>
<%= request.getAttribute("h")%><br/>
<%= session.getAttribute("h")%><br/>
<%= application.getAttribute("h")%><br/>
</body>
</html>

<%@ page import="com.qing.entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: 24529
  Date: 2021/8/10
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
用户名1:<%= request.getAttribute("username")%><br/>
密码1:<%= session.getAttribute("password")%><br/>

用户名2:${username}<br/>
密码2:${password}<br/>

<hr>
学生姓名1:
<%
    Student student = (Student) request.getAttribute("student");
    response.getWriter().print(student.getName());
%><br/>
学生姓名2:
${student.name}<br/>
学生姓名3:
${student["name"]}<br/>

所在城市1:
<%= student.getCity().getAddress()%><br>
所在城市2:
${student.city.address}
所在城市3:
${student["city"]["address"]}
</body>
</html>

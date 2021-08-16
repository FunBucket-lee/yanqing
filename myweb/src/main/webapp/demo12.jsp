<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 24529
  Date: 2021/8/10
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setAttribute("num", 10);
    request.setAttribute("str1", null);
    request.setAttribute("str2", "");
    request.setAttribute("str3", "  ");

    List list1 = new ArrayList<>();
    request.setAttribute("list", list1);

    List list2 = new ArrayList();
    list2.add("手机");
    list2.add("平板");
    request.setAttribute("list2", list2);

    request.setAttribute("s", 1);
%>

${num}<br>
<hr>
${empty str1} --- true<br>
${not empty str1} --- true<br>
${empty str1} --- false<br>

${empty list1} --- true<br>
${empty list2} --- false<br>

<hr>
${empty list2?"你还没买商品":"你买的商品如下"} --- ${list2}<br>

<input type="radio" name="gender" value="male" ${s==0?"checked='checked'":""}>男<br>
<input type="radio" name="gender" value="male" ${s==1?"checked='checked'":""}>女<br>

</body>
</html>

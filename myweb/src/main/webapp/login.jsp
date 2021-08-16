<%--
  Created by IntelliJ IDEA.
  User: 24529
  Date: 2021/8/10
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <script>
        function changeCode() {
            let img = document.getElementsByTagName("img")[0];
            img.src = "validCode?time=" + new Date().getTime();
        }
    </script>
</head>
<body>
<%
    String username = null;
    String checked = null;
    String password = null;

    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("username")) {
                username = cookie.getValue();
                checked = "checked='checked'";
            }
            if (cookie.getName().equals("password")) {
                password = cookie.getValue();
            }
            if (cookie.getName().equals("user")) {
                String user = cookie.getValue();
                String[] users = user.split("&");
                username = users[0];
                password = users[1];
                if (username.equals("admin") && password.equals("123456")) {
                    request.getSession().setAttribute("username", username);
                    request.getRequestDispatcher("home").forward(request, response);
                }
            }
        }
    }
    request.setAttribute("username", username);
    request.setAttribute("password", password);
    request.setAttribute("checked", checked);
%>

<form action="login" method="post">
    用户名:<label>
    <input type="text" name="username" value="${username}"/>
</label><br/>
    密码:<label>
    <input type="password" name="password" value="${password}"/>
</label><br/>
    验证码:<label>
    <input type="text" name="code">
</label>
    <img src="validCode" onclick="changeCode()" alt="">
    <a href="javascript:changeCode()">看不清换一张</a><br>
    <label>
        <input type="checkbox" name="remember" ${checked}>
    </label>记住账号密码<br>
    <label>
        <input type="checkbox" name="autologin" ${checked}>
        自动登录
    </label>
    <span style="color: #ff0051">${error}</span>
    <input type="submit" value="登录">
</form>
</body>
</html>

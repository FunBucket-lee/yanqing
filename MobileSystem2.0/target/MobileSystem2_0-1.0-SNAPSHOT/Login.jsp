<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <script>
        function changeCode() {
            let img = document.getElementsByTagName("img")[0];
            img.src = "validCode?time=" + new Date().getTime();
        }
    </script>
</head>
<body>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous">
</script>


<%
    String username = "";
    String password = "";
    String check = "";

    //获取客户端保存的Cookie
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("username")) {
                username = cookie.getValue();
                check = "checked = 'checked'";
            }
            if (cookie.getName().equals("password")) {
                password = cookie.getValue();
            }

            if (cookie.getName().equals("user")) {
                String value = cookie.getValue();
                String[] user = value.split("&");
                username = user[0];
                password = user[1];
                if (username.equals("admin") && password.equals("123456")) {
                    request.getSession().setAttribute("username", username);
                    request.getRequestDispatcher("findAllMobile").forward(request, response);
                }
            }
        }
        request.setAttribute("username", username);
        request.setAttribute("password", password);
        request.setAttribute("check", check);
    }
%>
    <form method="post" action="userLoginServlet">
        <div class="col-md-3">
            <label class="form-label">用户名</label>
            <input type="text" name="username" class="form-control" id="exampleInputUsername" value="${username}">
        </div>
        <div class="col-md-3 mg-3">
            <label for="exampleInputPassword1" class="form-label">密码</label>
            <input type="password" name="password" class="form-control" id="exampleInputPassword1" value="${password}">
        </div>
        <br>
        <div class="col-md-3 mg-2">
            验证码&nbsp<label>
            <input type="text" class="form-control" name="code">
        </label>
            <img src="validCode" onclick="changeCode()" alt="">
            <a href="javascript:changeCode()" style="text-decoration: none #0dcaf0">看不清 换一张</a><br>
        </div>
        <br>
        <div class="form-check">
            <input class="form-check-input" type="checkbox" name="remember" value="" id="flexCheckRemember" ${check}>
            <label class="form-check-label">
                记住账号密码
            </label>
        </div>
        <div class="form-check">
            <input class="form-check-input" name="autologin" type="checkbox" value="" id="flexCheckAutoLogin">
            <label class="form-check-label">
                自动登录
            </label>
        </div>
        <button type="submit" class="btn btn-primary btn-success" ${check}>登录</button>
        <span style="color: #d21551">${error}</span>
    </form>
</body>
</html>

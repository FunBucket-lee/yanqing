<%--
  Created by IntelliJ IDEA.
  User: 24529
  Date: 2021/8/14
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous">
    </script>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>

</head>
<body>
<h1>欢迎进入注册页面</h1>
<form id="aform" action="AddUserServlet" method="post" style="width: 400px">
    <div class="mb-3">
        <label class="form-label">用户名</label>
        <input type="text" class="form-control" name="username" id="username" onblur="validateUsername()"><span
            id="msg"></span>
    </div>
    <div class="mb-3">
        <label for="exampleInputPassword1" class="form-label">密码</label>
        <input type="password" id="password" name="password" class="form-control" onblur="validatePassword()"
               id="exampleInputPassword1"><span
            id="pmsg"></span>
    </div>
    <button type="button" id="btn" class="btn btn-primary">确定</button>
</form>
</body>
<script type="text/javascript">
    function validateUsername() {
        let username = $("#username").val();
        if (username == null || username === "") {
            $("#msg").html("<span id='warn' style='color: red'>用户名不能为空</span>");
        } else {
            $("#msg").load('RegisterServlet', 'username=' + username)
        }
    }

    function validatePassword() {
        let password = $("#password").val();
        if (password == null || password === "") {
            $("#pmsg").html("<span id='warn' style='color: red'>密码不能为空</span>");
        }else {
            $("#pmsg").html("");
        }
    }

    $("#btn").click(function () {
        let resUsername = $("#warn").css("color").substring(4, 7);
        let resUPassword = $("#warn").css("color").substring(4, 7);
        //红色rgb(255, 0, 0) 绿色rgb(0, 128, 0)
        if (resUsername === '255') {
            validateUsername();
        } else if (resUPassword === '255') {
            validatePassword()
        } else {
            $("#aform").submit();
        }
    });
</script>
</html>

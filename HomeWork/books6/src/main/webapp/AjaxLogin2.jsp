<%--
  Created by IntelliJ IDEA.
  User: 24529
  Date: 2021/8/14
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js">
</script>
<body>
<form action="">
    用户名:<input type="text" name="username" onblur="validate()" id="username"><span style="color: red"
                                                                                   id="msg"></span><br>
    密码:<input type="password" name="password" id="password">
</form>

<script type="text/javascript">

    function validate() {
        let username = $("#username").val();
        if (username == null || username === "") {
            $("#msg").html("<span style='color: red'>用户名不能为空</span>");
        } else {
           $.ajax({
               url:'JsonAjax',
               type:'get',
               data:{'username':username},
               success:function (data){
                   $('#msg').html()
               },
               error:function (){
                   alert("Ajax执行失败");
               }
           })
        }
    }

</script>
</body>
</html>

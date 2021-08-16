<%--
  Created by IntelliJ IDEA.
  User: 24529
  Date: 2021/8/14
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
</head>
<body>
<input type="button" value="请求单个数据" onmouseover="validate()">&nbsp;
<input type="button" value="请求全部数据" onmouseover="validate2()">&nbsp;
<div id="msg"></div>
</body>
<script type="text/javascript">
    function validate() {
        $.ajax({
            url: 'jsonAjaxServletSingle',
            type: 'get',
            dataType: 'json',
            success: function (data) {
                $("#msg").html("姓名:" + data.name + "<br>年龄:" + data.age + "<br>性别:" + data.gender + "<br>")
            },
            error: function (data) {
                alert("ajax执行失败");
            }
        })
    }

    function validate2() {
        $.ajax({
            url: 'jsonAjaxServletList',
            type: 'get',
            dataType: 'json',
            success: function (data) {
                let s = "";
                for (let i = 0; i < data.length; i++) {
                    s += "姓名:" + data[i].name + "<br>年龄:" + data[i].age + "<br>性别:" + data[i].gender + "<br>";

                }
                $("#msg").html(s);
            },
            error: function (data) {
                alert("ajax执行失败");
            }
        })
    }
</script>
</html>

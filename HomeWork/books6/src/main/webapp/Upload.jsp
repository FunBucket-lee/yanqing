<%--
  Created by IntelliJ IDEA.
  User: 24529
  Date: 2021/8/13
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<span style="color: red">${errMsg}</span>
<form action="upload" enctype="multipart/form-data" method="post">
    <table border="1" cellpadding="0" cellspacing="0">
        <caption>注册信息</caption>
        <tr>
            <td>姓名</td>
            <td><input name="username" type="text"></td>
        </tr>
        <tr>
            <td>年龄</td>
            <td><input name="age" type="text"></td>
        </tr>
        <tr>
            <td>头像</td>
            <td style="height: 220px">
                上传图片<input type="file" id="file" name="photo" onchange="changepic(this)"
                           accept="image/jpeg,image/jpg,image/bmp,image/png,image/gif"><br>
                <img src="images/101.jpg" id="img1" alt="" width="160" height="180">
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="上传"></td>
        </tr>

    </table>
</form>

<script type="text/javascript">

    function changepic(e) {
        let f = document.getElementById('file').files[0];
        let filename = f.name;
        let ext = filename.substring(filename.lastIndexOf(".") + 1);
        let acceptType = ['jpg', 'jpeg', 'png', 'bmp', 'gif'];
        let flag = false;
        for (let i = 0; i < acceptType.length; i++) {
            if (ext === acceptType[i]) {
                flag = true
            }
        }
        if (flag === false) {
            alert("不接受非图片文件");
            location.href = "Upload.jsp";
            return;
        }

        let reader = new FileReader();
        reader.readAsDataURL(f);
        reader.onload = function () {
            document.getElementById('img1').src = this.result;
        };
    }
</script>
</body>
</html>

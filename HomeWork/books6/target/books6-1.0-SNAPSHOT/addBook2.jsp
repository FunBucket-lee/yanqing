<%--
  Created by IntelliJ IDEA.
  User: 24529
  Date: 2021/8/11
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<h1 align="center">添加图书</h1>
<form action="addBook2" enctype="multipart/form-data" method="post">
    <table class="table table-striped" style="width: 500px" align="center">
        <tr>
            <td>书名</td>
            <td><input type="text" class="form-control" aria-label="Sizing example input"
                       aria-describedby="inputGroup-sizing-sm" name="name"></td>
        </tr>
        <tr>
            <td>价格</td>
            <td><input type="text" class="form-control" aria-label="Sizing example input"
                       aria-describedby="inputGroup-sizing-sm" name="price"></td>

        </tr>
        <tr>
            <td>类别</td>
            <td><input type="text" class="form-control" aria-label="Sizing example input"
                       aria-describedby="inputGroup-sizing-sm" name="category"></td>

        </tr>
        <tr>
            <td>库存</td>
            <td><input type="text" class="form-control" aria-label="Sizing example input"
                       aria-describedby="inputGroup-sizing-sm" name="pnum"></td>

        </tr>
        <tr>
            <td>图片</td>
            <td> 上传图片<input type="file" id="file" name="photo" onchange="changepic(this)"
                            accept="image/jpeg,image/jpg,image/bmp,image/png,image/gif"><br>
                <img src="images/101.jpg" id="img1" alt="" width="160" height="180">

        </tr>
        <tr>
            <td>描述</td>
            <td><input type="text" class="form-control" aria-label="Sizing example input"
                       aria-describedby="inputGroup-sizing-sm" name="description"></td>

        </tr>
        <tr>
            <td>作者</td>
            <td><input type="text" class="form-control" aria-label="Sizing example input"
                       aria-describedby="inputGroup-sizing-sm" name="author"></td>

        </tr>
        <tr>
            <td>销量</td>
            <td><input type="text" class="form-control" aria-label="Sizing example input"
                       aria-describedby="inputGroup-sizing-sm" name="sales"></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input class="btn btn-primary" type="submit" value="提交"></td>
        </tr>
    </table>
</form>
<script type="text/javascript">
    function changepic(e) {
        //获取文件上传对象
        let f = document.getElementById('file').files[0];
        //获取上传文件的额名称
        //获取文件上传的后缀
        let filename = f.name;
        let ext = filename.substring(filename.lastIndexOf(".") + 1);
        //数据定义可接受的文件类型
        let acceptType = ['jpg', 'jpeg', 'png', 'bmp', 'gif'];
        let flag = false;
        //验证文件是否合法
        for (let i = 0; i < acceptType.length; i++) {
            if (ext === acceptType[i]) {
                flag = true
            }
        }
        if (flag === false) {
            alert("不接受非图片文件");
            f.name="";
            return;
        }
    }
</script>
</body>
</html>

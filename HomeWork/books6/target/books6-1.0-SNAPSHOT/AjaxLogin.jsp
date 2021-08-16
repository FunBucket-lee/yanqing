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

    //单个json
    let person = {'name': '张三', age: 3, "gender": true};

    //Json数组
    let ps = [{'name': '张三', age: 3, "gender": true},
        {'name': '李四', 'age': 4, "gender": true},
        {'name': '王五', 'age': 5, "gender": true}]

    //Json中放Json
    let person1 = {
        "p1": {'name': '张三', 'age': 3, "gender": true}
    }

    //Json中放Json数组
    let persons1 = {
        "persons": [{'name': '张三', 'age': 3, "gender": true},
            {'name': '李四', 'age': 4, "gender": true},
            {'name': '王五', 'age': 5, "gender": true}]
    }

    //Json转字符串
    person = JSON.stringify(person);

    //字符串转Json
    let personS = "{'name': '张三', age: 3, 'gender': true}";
    person = JSON.parse(personS)



    function validate() {
        let username = $("#username").val();
        if (username == null || username === "") {
            $("#msg").html("用户名不能为空");
        } else {
            // $.get('ajaxServlet', 'username=' + username, function (result) {
            //     if (result == 'true') {
            //         $("#msg").html("<span style='color: red'>用户名已被使用！</span>");
            //     } else {
            //         $("#msg").html("<span style='color: green'>用户名可以使用！</span>");
            //     }
            // });
            $("#msg").load('ajaxServlet', 'username=' + username)
        }
    }

</script>
</body>
</html>

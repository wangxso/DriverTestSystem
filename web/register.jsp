<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Login Page | Amaze UI Example</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="alternate icon" type="image/png" href="i/favicon.png">
    <link rel="stylesheet" href="css/amazeui.min.css"/>
    <style>
        .header {
            text-align: center;
        }
        .header h1 {
            font-size: 200%;
            color: #333;
            margin-top: 30px;
        }
        .header p {
            font-size: 14px;
        }
    </style>
</head>
<body>
<div class="header">
    <div class="am-g">
        <h1>无忧驾考</h1>
        <p>让驾考更加简单</p>
    </div>
    <hr />
</div>
<div class="am-g">
    <div class="col-lg-6 col-md-8 col-sm-centered">
        <h3>登录</h3>
        <hr>
        <form method="post" class="am-form" action="register">
            <label for="username">用户名:</label>
            <input type="text" name="username" id="username" value="">
            <br>
            <label for="password">密码:</label>
            <input type="password" name="password" id="password" value="">
            <label for="rePass">密码:</label>
            <input type="password" name="rePass" id="rePass" value="">
            <br>
            <br />
            <c:if test="${sessionScope.error==1}">
                <p style="color: red"> 两次密码不一致</p>
            </c:if>
            <div class="am-cf">
                <input type="submit" name="" value="注 册" class="am-btn am-btn-primary am-btn-sm am-fl">
            </div>
        </form>
        <hr>
        <p>© 2019 wangx</p>
    </div>
</div>
</body>
</html>
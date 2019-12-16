<%--
  Created by IntelliJ IDEA.
  User: wangx
  Date: 2019/12/11
  Time: 9:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>报名驾校</title>
    <link rel="alternate icon" type="image/png" href="i/favicon.png">
    <link rel="stylesheet" href="http://cdn.clouddeep.cn/amazeui/1.0.1/css/amazeui.min.css"/>
    <link rel="stylesheet" href="css/entry.css"/>
    <link href="http//netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="NavBar.jsp" flush="true">
    <jsp:param name="active" value="4"/>
</jsp:include>
<div class="entry-bd">
    <div class="am-panel am-panel-default top-box">
        <div class="am-panel-bd">
            <div class="am-g com-info-base">
                <div class="col-sm-2 col-lg-2">
                    <img src="${sessionScope.driver_school.src}" alt="${sessionScope.driver_school.title}">
                </div>
                <div class="col-sm-4 col-lg-6">
                    <p class="top-title">
                        ${sessionScope.driver_school.title}
                    </p>
                    <p class="phone">
                        电话:${sessionScope.driver_school.phone}
                    </p>
                    <p class="adderss">
                        驾校地址：${sessionScope.driver_school.address}
                    </p>
                </div>
                <div class="col-sm-6 col-lg-4">
                    <p class="price" style="margin-top: 50px;">￥${sessionScope.driver_school.price}</p>
                </div>
            </div>
        </div>
    </div>

    <div class="am-panel am-panel-default bottom-form-box">
        <div class="am-panel-bd bottom-from" id="entery-form">
            <form class="am-form" action="#" method="post">
                <fieldset>
                    <legend>
                        <h3 class="bottom-form-title">
                            报名咨询
                        </h3>
                    </legend>
                    <div class="am-form-group">
                        <label for="doc-ipt-name-1">姓名</label>
                        <input type="text" class="" name="name" id="doc-ipt-name-1" placeholder="输入姓名">
                    </div>
                    <div class="am-form-group">
                        <label for="doc-ipt-phone-1">手机</label>
                        <input type="tel" class="" name="phone" id="doc-ipt-phone-1" placeholder="输入电子邮件">
                    </div>
                    <div class="am-form-group">
                        <label for="doc-ipt-email-1">邮件</label>
                        <input type="email" class="" name="email" id="doc-ipt-email-1" placeholder="输入电子邮件">
                    </div>
                    <p><input type="submit" class="am-btn am-btn-primary" value="提交"></p>
                </fieldset>
            </form>
        </div>
    </div>
</div>
<script src="https://cdn.bootcss.com/zepto/1.0rc1/zepto.min.js"></script>
<script src="http://cdn.clouddeep.cn/amazeui/1.0.1/js/amazeui.min.js"></script>
</body>
</html>

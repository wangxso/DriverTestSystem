<%--
  Created by IntelliJ IDEA.
  User: wangx
  Date: 2019/12/9
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>无忧驾考 | 科目四</title>
    <link rel="alternate icon" type="image/png" href="i/favicon.png">
    <link rel="stylesheet" href="http://cdn.clouddeep.cn/amazeui/1.0.1/css/amazeui.min.css"/>
    <link rel="stylesheet" href="css/subjectone.css" />
    <link href="http//netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="NavBar.jsp" flush="true">
    <jsp:param name="active" value="3"/>
</jsp:include>

<div class="col-sm-6 col-lg-10">
    <div class="am-panel am-panel-default fram-1">
        <div class="am-panel-bd fram-1-bd">
            <div class="am-panel am-panel-default header">
                <div class="am-panel-bd">
                <h1 style="text-align: center">2019小车科目四考试</h1>
                <span>科目四，又称科目四理论考试、驾驶员理论考试，是机动车驾驶证考核的一部分。公安部123号令实施后，科目三考试分为两项内容，除了路考，增加了安全文明驾驶考试，俗称“科目四”，考量“车德”。因为这个考试在科目三之后进行，所以大家都习惯称之为科目四考试。实际的官方说法中没有科目四一说。</span>
            </div>
        </div>

        <jsp:include page="innerul.jsp">
            <jsp:param name="type" value="4"/>
        </jsp:include>
</div>

<script src="https://cdn.bootcss.com/zepto/1.0rc1/zepto.min.js"></script>
<script src="http://cdn.clouddeep.cn/amazeui/1.0.1/js/amazeui.min.js"></script>
</body>
</html>

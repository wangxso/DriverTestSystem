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
    <title>无忧驾考 | 科目一</title>
    <link rel="alternate icon" type="image/png" href="i/favicon.png">
    <link rel="stylesheet" href="http://cdn.clouddeep.cn/amazeui/1.0.1/css/amazeui.min.css"/>
    <link rel="stylesheet" href="css/subjectone.css" />
    <link href="http//netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="NavBar.jsp" flush="true">
    <jsp:param name="active" value="2"/>
</jsp:include>

<div class="am-g">
    <div class="col-sm-6 col-lg-10">
        <div class="am-panel am-panel-default fram-1">
            <div class="am-panel-bd fram-1-bd">
                <div class="am-panel am-panel-default header">
                    <div class="am-panel-bd">
                        <h1 style="text-align: center">2019小车科目一考试</h1>
                        <span>科目一，又称科目一理论考试、驾驶员理论考试，是机动车驾驶证考核的一部分 。根据《机动车驾驶证申领和使用规定》，考试内容包括驾车理论基础、道路安全法律法规、地方性法规等相关知识。考试形式为上机考试，100道题，90分及以上过关。</span>
                    </div>
                </div>
                <jsp:include page="innerul.jsp">
                    <jsp:param name="type" value="1"/>
                </jsp:include>
</div>


<script src="https://cdn.bootcss.com/zepto/1.0rc1/zepto.min.js"></script>
<script src="http://cdn.clouddeep.cn/amazeui/1.0.1/js/amazeui.min.js"></script>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>无忧驾考 | 驾校报名</title>
    <link rel="alternate icon" type="image/png" href="i/favicon.png">
    <link rel="stylesheet" href="http://cdn.clouddeep.cn/amazeui/1.0.1/css/amazeui.min.css"/>
    <link rel="stylesheet" href="css/subjectone.css" />
    <link href="http//netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="NavBar.jsp" flush="true">
    <jsp:param name="active" value="4"/>
</jsp:include>

<div class="am-panel am-panel-default fram-1">
    <div class="am-panel-bd">
        <ul class="driver-school-list">
            <li>
                <c:forEach items="${sessionScope.driverSchoolPage}" var="item">
                <div class="am-g"  style="padding: 10px">
                    <div class="col-sm-1 col-lg-2">
                        <img src="${item.src}" alt="${item.title}">
                    </div>
                    <div class="col-sm-4 col-lg-6">
                        <div class="item-left">
                            <p class="top-bar">
                                <a class="title" href="#">${item.title}</a>
                            </p>
                            <p class="field">${item.address}</p>
                        </div>
                    </div>
                    <div class="col-sm-6 col-lg-2">
                        <div class="item-right">
                            <span class="price">￥${item.price}</span>
                        </div>
                    </div>

                    <div class="col-sm-2 col-lg-2 register-btn">
                        <a class="am-btn am-btn-secondary" href="showOneDriverSchool?id=${item.sid}">报名</a>
                    </div>
                </div>
                </c:forEach>
            </li>
        </ul>
        <div class="am-cf">
            共 ${sessionScope.count} 条记录
            <div class="am-fr">
                <ul class="am-pagination">
                    <li class="am-disabled"><a href="#">«</a></li>
                    <c:forEach var="i" begin="1" end="${sessionScope.totalPage}">
                        <li id="${i}"><a href="showDriverSchool?curr=${i}">${i}</a></li>
                    </c:forEach>
                    <li><a href="#">»</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.bootcss.com/zepto/1.0rc1/zepto.min.js"></script>
<script src="http://cdn.clouddeep.cn/amazeui/1.0.1/js/amazeui.min.js"></script>
<script src="js/jquery.min.js"></script>
<script type="text/javascript">
    var cur = "${sessionScope.curr}";
    var all = "${sessionScope.totalPage}";
    for (var i=0;i<all;i++){
        if ((i !== cur) && ($("#"+i).hasClass("am-active"))){
            $('#'+i).removeClass("am-active")
        }
    }
    $('#'+cur).addClass("am-active");
</script>
</body>
</html>

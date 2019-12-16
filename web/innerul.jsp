<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Random" %><%--
  Created by IntelliJ IDEA.
  User: wangx
  Date: 2019/12/11
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<ul class="sm-block-grid-2 md-block-grid-3 lg-block-grid-4 inner-ul">
    <li>
        <div class="am-btn-group am-btn-group-justify">
            <a href="getUnitTest?type=1&mode=${param.get('type')}" class="am-btn am-btn-default inner icon0" role="button">顺序练习</a>
        </div>
    </li>
    <li>
        <div class="am-btn-group am-btn-group-justify">
            <a href="getUnitTest?type=1&mode=${param.get('type')}&method=random" class="am-btn am-btn-default inner icon1" role="button">随机练习</a>
        </div>
    </li>
    <li>
        <div class="am-btn-group am-btn-group-justify">
            <a class="am-btn am-btn-default inner icon2" href="
<c:if test="${param.get('type')==1}">
unitTest_1.jsp
</c:if>
<c:if test="${param.get('type')==4}">
unitTest_4.jsp
</c:if>
" role="button">专项练习</a>
        </div>
    </li>
    <li>
        <div class="am-btn-group am-btn-group-justify">
            <a class="am-btn am-btn-default inner icon3" href="generateMockTest?mode=${param.get("type")}" role="button">模拟考试</a>
        </div>
    </li>
</ul>
</div>
</div>
</div>
<div class="col-sm-6 col-lg-2">
    <a href="findDriverSchool.jsp">
        <div class="jxbm-entry">
            <div class="jxbm-left">
            </div>
            <div class="jxbm-right">
                <p class="jxbm-right-title">驾校报名</p>
                <p class="jxbm-right-detail">在线快速报名驾校入口</p>
            </div>
        </div>
    </a>
</div>

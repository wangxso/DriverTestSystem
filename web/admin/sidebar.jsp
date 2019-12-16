<%--
  Created by IntelliJ IDEA.
  User: wangx
  Date: 2019/12/15
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- sidebar start -->
<div class="admin-sidebar">
    <ul class="am-list admin-sidebar-list">
        <li><a href="admin-index.jsp"><span class="am-icon-home"></span> 首页</a></li>
        <li><a href="adminUserManager?curr=1"><span class="am-icon-table"></span> 用户管理</a></li>
        <li><a href="adminProblemManager?curr=1"><span class="am-icon-pencil-square-o"></span> 题目管理</a></li>
        <li><a href="/driver/logout"><span class="am-icon-sign-out"></span> 注销</a></li>
    </ul>
</div>
<!-- sidebar end -->


<%--
  Created by IntelliJ IDEA.
  User: wangx
  Date: 2019/12/9
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header class="am-topbar am-topbar-fixed-top">
    <div class="am-container">
        <h1 class="am-topbar-brand">
            <a href="#">无忧驾考</a>
        </h1>

        <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-secondary am-show-sm-only"
                data-am-collapse="{target: '#collapse-head'}"><span class="am-sr-only">导航切换</span> <span
                class="am-icon-bars"></span></button>

        <div class="am-collapse am-topbar-collapse" id="collapse-head">
            <ul class="am-nav am-nav-pills am-topbar-nav">
                <li <c:if test="${param.get('active')=='1'}">class="am-active"</c:if>><a href="index.jsp">首页</a></li>
                <li <c:if test="${param.get('active')=='2'}">class="am-active"</c:if> ><a href="subjectone.jsp">科目一</a></li>
                <li <c:if test="${param.get('active')=='3'}">class="am-active"</c:if>><a href="subjectfour.jsp">科目四</a></li>
                <li <c:if test="${param.get('active')=='4'}">class="am-active"</c:if>><a href="showDriverSchool?curr=1">驾校报名</a></li>

            </ul>
            <c:if test="${sessionScope.get('user')==null}">
                <div class="am-topbar-right">
                    <a href="register.jsp">
                        <button class="am-btn am-btn-secondary am-topbar-btn am-btn-sm"><span class="am-icon-pencil"></span> 注册</button>
                    </a>
                </div>

                <div class="am-topbar-right">
                    <a href="login.jsp">
                        <button class="am-btn am-btn-primary am-topbar-btn am-btn-sm"><span class="am-icon-user"></span> 登录</button>
                    </a>
                </div>
            </c:if>
            <c:if test="${sessionScope.get('user')!=null}">
                <div class="am-topbar-right">
                    <a class="am-badge am-badge-secondary am-radius">你好,${sessionScope.user.username}</a>
                    <c:if test="${sessionScope.user.role=='admin'}">
                        <a href="goToAdmin">
                            <button class="am-btn am-btn-secondary am-topbar-btn am-btn-sm"><span class="am-icon-pencil">管理员后台</span> </button>
                        </a>
                    </c:if>
                    <a href="personal.jsp">
                        <button class="am-btn am-btn-secondary am-topbar-btn am-btn-sm"><span class="am-icon-user">个人中心</span> </button>
                    </a>
                    <a href="logout">
                        <button class="am-btn am-btn-secondary am-topbar-btn am-btn-sm"><span class="am-icon-sign-out">退出登录</span> </button>
                    </a>
                </div>
            </c:if>
        </div>
    </div>
</header>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="no-js">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>无忧驾考 | 用户管理</title>
  <meta name="description" content="这是一个 table 页面">
  <meta name="keywords" content="table">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="icon" type="image/png" href="../i/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="../i/app-icon72x72@2x.png">
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="stylesheet" href="../css/amazeui.min.css"/>
  <link rel="stylesheet" href="../css/admin.css">
</head>
<body>
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->

<!-- header -->
<jsp:include page="header.jsp" />

<div class="am-cf admin-main">
  <!-- sidebar end -->
    <jsp:include page="sidebar.jsp" />
  <!-- content start -->
  <div class="admin-content">

    <div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">用户管理</strong> / <small>UserManager</small></div>
    </div>

    <div class="am-g">
      <div class="col-md-6 am-cf">
        <div class="am-fl am-cf">
          <div class="am-btn-toolbar am-fl">
            <div class="am-btn-group am-btn-group-xs">
              <button type="button" class="am-btn am-btn-default"><span class="am-icon-plus"></span> 新增</button>
              <button type="button" class="am-btn am-btn-default"><span class="am-icon-trash-o"></span> 删除</button>
            </div>
            <div class="am-form-group am-margin-left am-fl">
              <select>
                <option value="option1">所有类别</option>
                <option value="option2">管理员</option>
                <option value="option3">非管理员</option>
              </select>
            </div>
          </div>
        </div>
      </div>
      <div class="col-md-3 am-cf">
        <div class="am-fr">
          <div class="am-input-group am-input-group-sm">
            <input type="text" class="am-form-field">
                <span class="am-input-group-btn">
                  <button class="am-btn am-btn-default" type="button">搜索</button>
                </span>
          </div>
        </div>
      </div>
    </div>

    <div class="am-g">
      <div class="col-sm-12">
        <form class="am-form">
          <table class="am-table am-table-striped am-table-hover table-main">
            <thead>
              <tr>
                <th class="table-check">
                  <input type="checkbox" /></th>
                <th class="table-id">ID</th>
                <th class="table-title">用户名</th>
                <th class="table-type">role</th>
                <th class="table-author">创建时间</th>
                <th class="table-date">修改日期</th>
                <th class="table-set">操作</th>
              </tr>
          </thead>
          <tbody>
          <c:forEach items="${sessionScope.userPage}" var="item">

            <tr>
              <td><input type="checkbox" /></td>
              <td>${item.uid}</td>
              <td><a href="#">${item.username}</a></td>
              <td>${item.role}</td>
              <td>${item.createDate}</td>
              <td>${item.updateDate}</td>
              <td>
                <div class="am-btn-toolbar">
                  <div class="am-btn-group am-btn-group-xs">
                    <button class="am-btn am-btn-default am-btn-xs am-text-secondary"><span class="am-icon-pencil-square-o"></span> 编辑</button>
                    <button class="am-btn am-btn-default am-btn-xs am-text-danger"><span class="am-icon-trash-o"></span> 删除</button>
                  </div>
                </div>
              </td>
            </tr>
          </c:forEach>
          </tbody>
        </table>
          <div class="am-cf">
  共 ${sessionScope.count} 条记录
  <div class="am-fr">
    <ul class="am-pagination">
      <li class="am-disabled"><a href="#">«</a></li>
      <c:forEach var="i" begin="1" end="${sessionScope.totalPage}">
        <li id="${i}"><a href="adminUserManager?curr=${i}">${i}</a></li>
      </c:forEach>
      <li><a href="#">»</a></li>
    </ul>
  </div>
</div>
          <hr />
          <p>共${sessionScope.totalPage} 页,现在第 ${sessionScope.curr}</p>
        </form>
      </div>

    </div>
  </div>
  <!-- content end -->
</div>

<footer>
  <hr>
  <p class="am-padding-left">© 2019 wangx</p>
</footer>

<script src="../js/zepto.min.js"></script>
<script src="../js/amazeui.min.js"></script>
<script src="../js/app.js"></script>
<script src="../js/jquery.min.js"></script>
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

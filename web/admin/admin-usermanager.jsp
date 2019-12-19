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
  <link rel="stylesheet" href="../css/manageruser.css">
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
              <button type="button" class="am-btn am-btn-default" onclick="addUser()"><span class="am-icon-plus"></span> 新增</button>
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
                    <button class="am-btn am-btn-default am-btn-xs am-text-secondary"><span class="am-icon-pencil-square-o"></span> 编辑</button>
                    <button type="button" class="am-btn am-btn-default am-btn-xs am-text-danger" onclick="deleteUser('${item.uid}')"><span class="am-icon-trash-o"></span> 删除</button>
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
<div id="addUser" hidden>
  <form class="am-form" method="post" action="/driver/register">
    <fieldset style="width: 500px">
      <legend>表单标题</legend>
      <div class="am-form-group">
        <label for="doc-ipt-username-1">用户名</label>
        <input type="text" name="username" class="" id="doc-ipt-username-1" placeholder="输入用户名">
      </div>

      <div class="am-form-group">
        <label for="doc-ipt-pwd-1">密码</label>
        <input type="password" name="password" class="" id="doc-ipt-pwd-1" placeholder="设置个密码吧">
      </div>
      <div class="am-form-group">
        <label for="doc-select-1">权限</label>
        <select id="doc-select-1" name="role">
          <option value="normal">normal</option>
          <option value="admin">admin</option>
        </select>
        <span class="am-form-caret"></span>
    </div>
      <p><button type="submit" class="am-btn am-btn-primary">提交</button></p>
    </fieldset>
  </form>
</div>
<footer>
  <hr>
  <p class="am-padding-left">© 2019 wangx</p>
</footer>

<script src="../js/zepto.min.js"></script>
<script src="../js/amazeui.min.js"></script>
<script src="../js/app.js"></script>
<script src="../js/jquery.min.js"></script>
<script src="../js/layer.js"></script>
<script type="text/javascript">
  var cur = "${sessionScope.curr}";
  var all = "${sessionScope.totalPage}";
  for (var i=0;i<all;i++){
    if ((i !== cur) && ($("#"+i).hasClass("am-active"))){
      $('#'+i).removeClass("am-active")
    }
  }
  $('#'+cur).addClass("am-active");

  function deleteUser(uid) {
    layer.confirm('您确定要删除该用户？', {
      btn: ['确定','取消'] //按钮
    }, function(){
      var uids = [];
      uids.push(uid)
      var json = JSON.stringify(uids);
      console.log(json)
      $.ajax({
        type: 'post',
        url: 'deleteUserById',
        data: {
          uids: json
        },
        success:function (data) {
          console.log(data);
          data = JSON.parse(data);
          if(data.result === 'success'){
            layer.msg('删除成功', {icon: 1});
          }else{
            layer.msg('删除失败', {icon: 2});
          }
        }
      })
    }, function(){
      layer.msg('好的呢',{icon:2});
    });

  }

  function addUser() {
    let innerHTML = $('#addUser').prop("innerHTML");
    console.log(innerHTML)
    layer.open({
      type: 1,
      title: false,
      closeBtn: 0,
      shadeClose: true,
      skin: 'addUsers',
      content: innerHTML
    });
  }

</script>
</body>
</html>

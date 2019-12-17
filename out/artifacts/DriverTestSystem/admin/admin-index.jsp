<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="no-js">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>无忧驾考 | 后台首页</title>
  <meta name="description" content="这是一个 index 页面">
  <meta name="keywords" content="index">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="icon" type="image/png" href="assets/i/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="stylesheet" href="http://cdn.clouddeep.cn/amazeui/1.0.1/css/amazeui.min.css"/>
  <link rel="stylesheet" href="../css/admin.css">
</head>
<body>
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->
<!-- top bar start -->
<jsp:include page="header.jsp" />
<!-- top bar end -->
<div class="am-cf admin-main">
  <!-- sidebar -->
  <jsp:include page="sidebar.jsp" />
  <!--  sidebar end -->
  <!-- content start -->
  <div class="admin-content">

    <div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">首页</strong> / <small>一些常用模块</small></div>
    </div>

    <ul class="sm-block-grid-1 md-block-grid-4 am-margin am-padding am-text-center admin-content-list ">
      <li><a href="#" class="am-text-success"><span class="am-icon-btn am-icon-user-md"></span><br/>用户数量<br/>${sessionScope.userNum}</a></li>
      <li><a href="#" class="am-text-warning"><span class="am-icon-btn am-icon-briefcase"></span><br/>访问次数<br/>${sessionScope.userVisited}</a></li>
      <li><a href="#" class="am-text-danger"><span class="am-icon-btn am-icon-file"></span><br/>题目数量<br/>${sessionScope.pNum}</a></li>
      <li><a href="#" class="am-text-secondary"><span class="am-icon-btn am-icon-user-md"></span><br/>在线用户<br/>${applicationScope.allUser.size()}</a></li>
    </ul>
    <div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">在线用户</strong> / <small>Online User</small></div>
    </div>
    <div class="am-g">
      <div class="col-sm-12">
        <form class="am-form">
          <table class="am-table am-table-striped am-table-hover table-main">
            <thead>
            <tr>
              <th class="table-id">ID</th><th class="table-title">用户名</th><th class="table-type">创建时间</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${applicationScope.allUser}" var="item">
            <tr>
              <td>${item.uid}</td>
              <td><a href="#">${item.username}</a></td>
              <td>${item.createDate}</td>
            </tr>
            </c:forEach>
            </tbody>
          </table>
          <div class="am-cf">
            共 ${applicationScope.allUser.size()} 条记录
            <div class="am-fr">
              <ul class="am-pagination">
                <li class="am-disabled"><a href="#">«</a></li>
                <li class="am-active"><a href="#">1</a></li>
                <li><a href="#">»</a></li>
              </ul>
            </div>
          </div>
        </form>
        <div id="main" style="width: 600px;height:400px;"></div>
        </div>
    </div>
  </div>
<footer>
  <hr>
  <p class="am-padding-left">&copy; 2019 wangx</p>
</footer>

<script src="../js/zepto.min.js"></script>
<script src="../js/amazeui.min.js"></script>
<script src="../js/app.js"></script>
<script src="https://cdn.bootcss.com/echarts/4.3.0-rc.2/echarts.min.js"></script>
<script type="text/javascript">
  $(document).ready(function(){
      $.get("/driver/getUserVisitedHistory",{},function (data) {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));
        var x_data = [];
        var y_data = [];
        for (let index in data){
          console.log(data[index])
        }
        // 指定图表的配置项和数据
        option = {
          xAxis: {
            type: 'category',
            data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
          },
          yAxis: {
            type: 'value'
          },
          series: [{
            data: [820, 932, 901, 934, 1290, 1330, 1320],
            type: 'line'
          }]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
      },"json")
  });

</script>
</body>
</html>

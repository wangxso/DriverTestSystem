<%--
  Created by IntelliJ IDEA.
  User: wangx
  Date: 2019/12/9
  Time: 9:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head lang="en">
  <meta charset="UTF-8">
  <title>无忧驾考 | 首页</title>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport"
        content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
  <meta name="format-detection" content="telephone=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp"/>
  <link rel="alternate icon" type="image/png" href="i/favicon.png">
  <link rel="stylesheet" href="http://cdn.clouddeep.cn/amazeui/1.0.1/css/amazeui.min.css"/>
  <style>
    .get {
      background: #1E5B94;
      color: #fff;
      text-align: center;
      padding: 100px 0;
    }

    .get-title {
      font-size: 200%;
      border: 2px solid #fff;
      padding: 20px;
      display: inline-block;
    }

    .get-btn {
      background: #fff;
    }

    .detail {
      background: #fff;
    }

    .detail-h2 {
      text-align: center;
      font-size: 150%;
      margin: 40px 0;
    }

    .detail-h3 {
      color: #1f8dd6;
    }

    .detail-p {
      color: #7f8c8d;
    }

    .detail-mb {
      margin-bottom: 30px;
    }

    .hope {
      background: #0bb59b;
      padding: 50px 0;
    }

    .hope-img {
      text-align: center;
    }

    .hope-hr {
      border-color: #149C88;
    }

    .hope-title {
      font-size: 140%;
    }

    .about {
      background: #fff;
      padding: 40px 0;
      color: #7f8c8d;
    }

    .about-color {
      color: #34495e;
    }

    .about-title {
      font-size: 180%;
      padding: 30px 0 50px 0;
      text-align: center;
    }

    .footer p {
      color: #7f8c8d;
      margin: 0;
      padding: 15px 0;
      text-align: center;
      background: #2d3e50;
    }
  </style>
</head>
<body>
<jsp:include page="NavBar.jsp" flush="true">
  <jsp:param name="active" value="1"/>
</jsp:include>

<div class="get">
  <div class="am-g">
    <div class="col-lg-12">
      <h1 class="get-title">驾考没烦恼，无忧驾考</h1>

      <p>
        期待你的参与，共同打造一个轻松的驾考
      </p>

      <p>
        <a href="findDriverSchool.jsp" class="am-btn am-btn-sm get-btn">驾校报名√</a>
      </p>
    </div>
  </div>
</div>

<div class="detail">
  <div class="am-g am-container">
    <div class="col-lg-12">
      <h2 class="detail-h2">一次通过，期待和你一起去实现!</h2>

      <div class="am-g">
        <div class="col-lg-3 col-md-6 col-sm-12 detail-mb">

          <h3 class="detail-h3">
            快速通关
          </h3>

          <p class="detail-p">
            人的能力是有限的,人的努力是无限的。
            人的能力是有限的,人的努力是无限的。
            人的能力是有限的,人的努力是无限的。
            人的能力是有限的,人的努力是无限的。
          </p>
        </div>
        <div class="col-lg-3 col-md-6 col-sm-12 detail-mb">
          <h3 class="detail-h3">
            <i class="am-icon-cogs am-icon-sm"></i>
            全真模拟
          </h3>

          <p class="detail-p">
            人的能力是有限的,人的努力是无限的。
            人的能力是有限的,人的努力是无限的。
            人的能力是有限的,人的努力是无限的。
            人的能力是有限的,人的努力是无限的。
          </p>
        </div>
        <div class="col-lg-3 col-md-6 col-sm-12 detail-mb">
          <h3 class="detail-h3">
            <i class="am-icon-check-square-o am-icon-sm"></i>
            实时对接
          </h3>

          <p class="detail-p">
            人的能力是有限的,人的努力是无限的。
            人的能力是有限的,人的努力是无限的。
            人的能力是有限的,人的努力是无限的。
            人的能力是有限的,人的努力是无限的。
          </p>
        </div>
        <div class="col-lg-3 col-md-6 col-sm-12 detail-mb">
          <h3 class="detail-h3">
            <i class="am-icon-send-o am-icon-sm"></i>
            云端保存
          </h3>

          <p class="detail-p">
            人的能力是有限的,人的努力是无限的。
            人的能力是有限的,人的努力是无限的。
            人的能力是有限的,人的努力是无限的。
            人的能力是有限的,人的努力是无限的。
          </p>
        </div>
      </div>
    </div>
  </div>
</div>

<div class="hope">
  <div class="am-g am-container">
    <div class="col-lg-4 col-md-6 col-sm-12 hope-img">
        <h1>公告</h1>
    </div>
  </div>
</div>

<div class="about">
  <div class="am-g am-container">
    <div class="col-lg-12">

      </div>
    </div>
  </div>
</div>

<footer class="footer">
  <p>&copy;2019 <a href="blog.wangxinsheng.cn" target="_blank">wangx</a></p>
</footer>
<script src="https://cdn.bootcss.com/zepto/1.0rc1/zepto.min.js"></script>
<script src="http://cdn.clouddeep.cn/amazeui/1.0.1/js/amazeui.min.js"></script>
</body>
</html>
</html>
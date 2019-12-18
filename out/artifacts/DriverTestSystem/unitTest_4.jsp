<%--
  Created by IntelliJ IDEA.
  User: wangx
  Date: 2019/12/12
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="http://cdn.clouddeep.cn/amazeui/1.0.1/css/amazeui.min.css"/>
    <link href="http//netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="css/unit.css" rel="stylesheet">
</head>
<body>
<jsp:include page="NavBar.jsp"></jsp:include>
<div class="am-g">
    <div class="col-sm-6 col-lg-10">
        <div class="am-panel am-panel-default fram-1">
            <div class="am-panel-bd">
                <div class="header-title-box">
                    <h1 class="title">科目四 章节练习</h1>
                    <p class="summary">按照法规章节逐步分类</p>
                </div>

                <div class="lx-category">
                    <div class="lx-category-hd">
                        <h3>
                            <a href="#">第1章：违法行为综合判断与案例分析</a>
                        </h3>
                    </div>
                    <div class="lx-category-bd">
                        <ul class="dot-ul cl">
                            <a href="getUnitTest?type=1&mode=4"><li>顺序练习</li></a>
                        </ul>
                    </div>


                    <div class="lx-category-hd">
                        <h3>
                            <a href="#">第2章：安全行车常识</a>
                        </h3>
                    </div>
                    <div class="lx-category-bd">
                        <ul class="dot-ul cl">
                            <a href="getUnitTest?type=2&mode=4"><li>顺序练习</li></a>
                        </ul>
                    </div>


                    <div class="lx-category-hd">
                        <h3>
                            <a href="#">第3章：常见交通标志、标线和交通手势辨识</a>
                        </h3>
                    </div>
                    <div class="lx-category-bd">
                        <ul class="dot-ul cl">
                            <a href="getUnitTest?type=3&mode=4"><li>顺序练习</li></a>
                        </ul>
                    </div>

                    <div class="lx-category-hd">
                        <h3>
                            <a href="#">第4章：驾驶职业道德和文明驾驶常识</a>
                        </h3>
                    </div>
                    <div class="lx-category-bd">
                        <ul class="dot-ul cl">
                            <a href="getUnitTest?type=4&mode=4"><li>顺序练习</li></a>
                        </ul>
                    </div>


                    <div class="lx-category-hd">
                        <h3>
                            <a href="#">第5章：恶劣气候和复杂道路条件下驾驶常识</a>
                        </h3>
                    </div>
                    <div class="lx-category-bd">
                        <ul class="dot-ul cl">
                            <a href="getUnitTest?type=5&mode=4"><li>顺序练习</li></a>
                        </ul>
                    </div>


                    <div class="lx-category-hd">
                        <h3>
                            <a href="#">第6章：紧急情况下避险常识</a>
                        </h3>
                    </div>
                    <div class="lx-category-bd">
                        <ul class="dot-ul cl">
                            <a href="getUnitTest?type=6&mode=4"><li>顺序练习</li></a>
                        </ul>
                    </div>


                    <div class="lx-category-hd">
                        <h3>
                            <a href="#">第7章：交通事故救护及常见危化品处置常识</a>
                        </h3>
                    </div>
                    <div class="lx-category-bd">
                        <ul class="dot-ul cl">
                            <a href="getUnitTest?type=7&mode=4"><li>顺序练习</li></a>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.bootcss.com/zepto/1.0rc1/zepto.min.js"></script>
<script src="http://cdn.clouddeep.cn/amazeui/1.0.1/js/amazeui.min.js"></script>
</body>
</html>

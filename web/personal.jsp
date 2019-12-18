<%@ page import="java.util.List" %>
<%@ page import="cn.wangx.DriverTest.pojo.Problem" %>
<%@ page import="java.util.Map" %>
<%@ page import="cn.wangx.DriverTest.pojo.UserProblem" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wangx
  Date: 2019/12/17
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>无忧驾考 | 个人中心</title>
    <link rel="stylesheet" href="http://cdn.clouddeep.cn/amazeui/1.0.1/css/amazeui.min.css"/>
    <link rel="stylesheet" href="css/personal.css"/>
    <link href="http//netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="NavBar.jsp" />
<div data-am-widget="tabs" class="am-tabs am-tabs-d2 outter-box">
    <ul class="am-tabs-nav am-cf">
        <li class="am-active">
            <a href="[data-tab-panel-0]">用户个人信息</a>
        </li>
        <li class="">
            <a href="[data-tab-panel-1]">用户考试记录</a>
        </li>
        <li class="">
            <a href="[data-tab-panel-2]">用户做题记录</a>
        </li>
    </ul>
    <div class="am-tabs-bd">
        <div data-tab-panel-0 class="am-tab-panel am-active">
            <section class="am-panel am-panel-success">
                <header class="am-panel-hd">
                    <h3 class="am-panel-title">个人信息</h3>
                </header>
                <div class="am-panel-bd">

                    <div class="am-g">
                        <div class="col-lg-4">
                            <div class="avatar">
                                <img src="i/startup-640x1096.png" class="avatar-larger avatar-circle">
                            </div>
                        </div>
                         <div id="loadgif">
                        　　<img  alt="加载中..." src="i/loading.gif"/>
                            <h1 id="tip">数据加载中...</h1>
                        </div>
                        <div class="col-lg-8 info-box">
                            <div class="info">用户名：${sessionScope.user.username}</div>
                            <div class="info">真实姓名：${sessionScope.userProfile.realName}</div>
                            <div class="info">
                                帐号密码：********
                                <span onclick="changePassWord()" class="right"><a href="#">修改密码</a></span>
                            </div>
                            <div class="info">通过题数：${sessionScope.userProfile.passNumber==null?0:sessionScope.userProfile.passNumber}</div>
                            <div class="info">错误题数：${sessionScope.userProfile.failNumber==null?0:sessionScope.userProfile.failNumber}</div>
                        </div>
                    </div>
                    <div id="chart" style="width: 800px;height: 600px"></div>
                    <div id="chart-kemu4" style="width: 800px;height: 600px"></div>
                </div>
            </section>
        </div>
        <div
                data-tab-panel-1 class="am-tab-panel ">

            <div id="exam-chart" style="width: 100%;height: 500px"></div>

        </div>
        <div
                data-tab-panel-2 class="am-tab-panel ">
            <table class="am-table">
                <thead>
                <tr>
                    <th>pid</th>
                    <th>题目</th>
                    <th>状态</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${sessionScope.userProblemList}" varStatus="status">
                    <tr>
                        <td>${status.index}</td>
                        <td>
                            ${sessionScope.problemMap.get(item.pid).content}
                        </td>

                        <td>
                            <c:if test="${item.status==1}">
                                <span class="am-badge am-badge-success">success</span>
                            </c:if>
                            <c:if test="${item.status==0}">
                                <span class="am-badge am-badge-danger">wrong</span>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script src="js/jquery.min.js"></script>
<script src="js/zepto.min.js"></script>
<script src="js/app.js"></script>
<script src="js/amazeui.min.js"></script>
<script src="https://cdn.bootcss.com/echarts/4.3.0-rc.2/echarts.min.js"></script>\
<script src="js/personal.js"></script>
<script src="js/layer.js"></script>
<script type="text/javascript">
    var chart = echarts.init(document.getElementById("chart"));
    var examChart = echarts.init(document.getElementById("exam-chart"));
    var kemusiChart = echarts.init(document.getElementById("chart-kemu4"));
    var exam_option = {
        title: {
          text: "用户考试趋势图" ,
            x: 'center'
        },
        legend: {
            data:['正确题目','错误题目','未做题目'],
            x:"left"
        },
        tooltip: {
            trigger: 'axis'
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: [<c:forEach items="${sessionScope.examList}" var="item">"${item.date}",</c:forEach> ]
        },
        yAxis: {
            type: 'value'
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        toolbox: {
            feature: {
                saveAsImage: {},
                magicType: {//动态类型切换
                    type: ['bar', 'line']
                }
            }
        },
        series: [{
            name:'正确题目',
            data: [<c:forEach items="${sessionScope.examList}" var="item">${item.pass},</c:forEach>],
            type: 'line',
            stack: '个数',
        },{
            name: "错误题目",
            data: [<c:forEach items="${sessionScope.examList}" var="item">${item.fail},</c:forEach>],
            type: 'line',
            stack: '个数',
        }
        ]
    };



    var option = {
        title : {
            text: '用户科目一错误题目分类',
            subtext: '',
            x:'right'
        },
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        toolbox:{
            feature: {
                saveAsImage: {},
                magicType: {//动态类型切换
                    type: ['bar', 'pie']
                }
            }
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: ['第一章  道路交通安全法律、法规和规章','第二章 交通信号','第三章 安全行车、文明驾驶基础知识',
                '第四章 机动车驾驶操作相关基础知识','第五章 货车专用试题','第六章 客车专用试题','第七章 摩托车专用试题']
        },
        series : [
            {
                name: '章节',
                type: 'pie',
                radius : '55%',
                center: ['50%', '60%'],
                data:[
                    {value:${sessionScope.mode1[1]}, name:'第一章  道路交通安全法律、法规和规章'},
                    {value:${sessionScope.mode1[2]}, name:'第二章 交通信号'},
                    {value:${sessionScope.mode1[3]}, name:'第三章 安全行车、文明驾驶基础知识'},
                    {value:${sessionScope.mode1[4]}, name:'第四章 机动车驾驶操作相关基础知识'},
                    {value:${sessionScope.mode1[5]}, name:'第五章 货车专用试题'},
                    {value:${sessionScope.mode1[6]}, name:'第六章 客车专用试题'},
                    {value:${sessionScope.mode1[7]}, name:'第七章 摩托车专用试题'},
                ],
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };

    var option4 = {
        title : {
            text: '用户科目四错误题目分类',
            subtext: '',
            x:'right'
        },
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: ['第1章：违法行为综合判断与案例分析','第2章：安全行车常识','第3章：常见交通标志、标线和交通手势辨识',
                '第4章：驾驶职业道德和文明驾驶常识','第5章：恶劣气候和复杂道路条件下驾驶常识','第6章：紧急情况下避险常识',
                '第7章：交通事故救护及常见危化品处置常识','第8章：摩托车专用试题']
        },
        series : [
            {
                name: '章节',
                type: 'pie',
                radius : '55%',
                center: ['50%', '60%'],
                data:[
                    {value:${sessionScope.mode4[1]}, name:'第1章：违法行为综合判断与案例分析'},
                    {value:${sessionScope.mode4[2]}, name:'第2章：安全行车常识'},
                    {value:${sessionScope.mode4[3]}, name:'第3章：常见交通标志、标线和交通手势辨识'},
                    {value:${sessionScope.mode4[4]}, name:'第4章：驾驶职业道德和文明驾驶常识'},
                    {value:${sessionScope.mode4[5]}, name:'第5章：恶劣气候和复杂道路条件下驾驶常识'},
                    {value:${sessionScope.mode4[6]}, name:'第6章：紧急情况下避险常识'},
                    {value:${sessionScope.mode4[7]}, name:'第7章：交通事故救护及常见危化品处置常识'},
                    {value:${sessionScope.mode4[8]}, name:'第8章：摩托车专用试题'},
                ],
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };
    kemusiChart.setOption(option4);
    chart.setOption(option);
    examChart.setOption(exam_option);
</script>
</body>
</html>

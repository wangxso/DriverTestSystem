<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wangx
  Date: 2019/12/16
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成绩</title>
    <link rel="alternate icon" type="image/png" href="i/favicon.png">
    <link rel="stylesheet" href="css/amazeui.min.css">
    <link rel="stylesheet" href="css/result.css">
</head>
<body>
<jsp:include page="NavBar.jsp" />
<div class="content-fram">
    <!--网格行限制宽度-->
    <div class="am-g">
        <div class="col-lg-4">
            <div class="left score left-box">
                <div id="score-chart" style="width: 400px;height: 400px"></div>
            </div>
        </div>
        <div class="col-lg-4">
            <c:if test="${sessionScope.pass>=90}">
                <div class="result cheshen"></div>
            </c:if>
            <c:if test="${sessionScope.pass<90}">
                <div class="result shashou"></div>
            </c:if>
            <div class="result"></div>
        </div>
        <div class="col-lg-4">
            <div id="chart" style="width: 600px;height: 800px"></div>
        </div>
    </div>
</div>

</body>
<script src="js/zepto.min.js"></script>
<script src="js/amazeui.min.js"></script>
<script src="js/app.js"></script>
<script src="https://cdn.bootcss.com/echarts/4.3.0-rc.2/echarts.min.js"></script>
<script>
    //清空数据，防止错误
    sessionStorage.clear();
    var chart = echarts.init(document.getElementById("chart"));
    var score_chart = echarts.init(document.getElementById("score-chart"));
    chart.title = '环形图';
    var score_option = {
        tooltip : {
            formatter: "{a} <br/>{b} : {c}分"
        },
        toolbox: {
            feature: {
                restore: {},
                saveAsImage: {}
            }
        },
        series: [
            {
                name: '分数',
                type: 'gauge',
                detail: {formatter:'{value}分'},
                data: [{value: ${sessionScope.pass}, name: '考试分数'}]
            }
        ]
    };

    var option = {
        title : {
            text: '模拟考试成绩',
            subtext: '90分及格，满分100分',
            x:'center'
        },
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: ['正确题数','错误题数','未完成题数']
        },
        series : [
            {
                name: '题数',
                type: 'pie',
                radius : '55%',
                center: ['50%', '60%'],
                data:[
                    {value:${sessionScope.pass}, name:'正确题数'},
                    {value:${sessionScope.fail}, name:'错误题数'},
                    {value:${sessionScope.blank}, name:'未完成题数'},
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

    chart.setOption(option);
    score_chart.setOption(score_option);
</script>
</html>

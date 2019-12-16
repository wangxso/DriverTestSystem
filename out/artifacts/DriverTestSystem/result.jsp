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
    <div class="left score">
        <p class="result">不及格</p>
        <p class="result-score">60</p>
    </div>
    <div id="chart" style="width: 600px;height: 800px"></div>
</div>

</body>
<script src="../js/zepto.min.js"></script>
<script src="../js/amazeui.min.js"></script>
<script src="../js/app.js"></script>
<script src="https://cdn.bootcss.com/echarts/4.3.0-rc.2/echarts.min.js"></script>
<script>

    var chart = echarts.init(document.getElementById("chart"));

    chart.title = '环形图';

    var option = {
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b}: {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            x: 'left',
            data:['正确','错误','未完成']
        },
        series: [
            {
                name:'访问来源',
                type:'pie',
                radius: ['50%', '70%'],
                avoidLabelOverlap: false,
                label: {
                    normal: {
                        show: false,
                        position: 'center'
                    },
                    emphasis: {
                        show: true,
                        textStyle: {
                            fontSize: '30',
                            fontWeight: 'bold'
                        }
                    }
                },
                labelLine: {
                    normal: {
                        show: false
                    }
                },
                data:[
                    {value:${sessionScope.pass}, name:'正确'},
                    {value:${sessionScope.fail}, name:'错误'},
                    {value:${sessionScope.blank}, name:'未完成'},
                ]
            }
        ]
    };


    chart.setOption(option)
</script>
</html>

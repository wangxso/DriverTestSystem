<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wangx
  Date: 2019/12/13
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>模拟考试</title>
    <link rel="alternate icon" type="image/png" href="i/favicon.png">
    <link rel="stylesheet" href="css/amazeui.min.css">
    <link rel="stylesheet" href="css/mouni.css">
</head>
<body>
<jsp:include page="NavBar.jsp">
    <jsp:param name="active" value="2"/>
</jsp:include>
<div class="top-content">
    <div class="am-g">
        <div class="col-sm-6 col-lg-3">
            <fieldset class="kaochang">
                <legend>理论考试</legend>
                <span>第01考台</span>
            </fieldset>

            <fieldset class="kaosheng">
                <legend>考生信息</legend>
                <div class="author-img"></div>
                <div class="kaosheng-item kemu red">科目${sessionScope.mode}</div>
                <div class="kaosheng-item name">张三</div>
                <div class="kaosheng-item">考试题数: ${sessionScope.problem_id_list.size()}</div>
                <div class="kaosheng-item">考试时间：45分钟</div>
                <div class="">满分100分，及格90分</div>
            </fieldset>
            <fieldset class="daojishi">
                <legend>剩余时间</legend>
                <span class="joind djs"><span class="joinm">45</span>分<span class="joins">00</span>秒</span>
            </fieldset>
        </div>
        <div class="col-sm-6 col-lg-6">
            <fieldset class="kaoti">
                <legend>题目信息</legend>
                <div class="question-detail">
                    <div class="timu">
                        <p>${sessionScope.problem_by_id.content}</p>
                    </div>
                    <div class="answer-w">
                        <div class="options">
                            <c:if test="${sessionScope.chooses[0]!=null}">
                                <p>${sessionScope.chooses[0]}</p>
                            </c:if>
                            <c:if test="${sessionScope.chooses[1]!=null}">
                                <p>${sessionScope.chooses[1]}</p>
                            </c:if>
                            <c:if test="${sessionScope.chooses[2]!=null}">
                                <p>${sessionScope.chooses[2]}</p>
                            </c:if>
                            <c:if test="${sessionScope.chooses[3]!=null}">
                                <p>${sessionScope.chooses[3]}</p>
                            </c:if>
                        </div>
                    </div>
                </div>
                <div class="clearfix">
                    <div class="select-w right">
                        <label>请选择:</label>
                        <c:if test="${sessionScope.chooses[0]!=null}">
                            <button class="select-table" onclick="checkAnswers('A')">A</button>
                        </c:if>
                        <c:if test="${sessionScope.chooses[1]!=null}">
                            <button class="select-table" onclick="checkAnswers('B')">B</button>
                        </c:if>
                        <c:if test="${sessionScope.chooses[2]!=null}">
                            <button class="select-table" onclick="checkAnswers('C')">C</button>
                        </c:if>
                        <c:if test="${sessionScope.chooses[3]!=null}">
                            <button class="select-table" onclick="checkAnswers('D')">D</button>
                        </c:if>
                    </div>
                </div>
            </fieldset>
            <fieldset class="tishi">
                <legend>试题提示信息</legend>
                <span>

                </span>
            </fieldset>

            <div class="btn-bar">
                <button class="pre am-btn-primary am-btn-lg" <c:if test="${sessionScope.curr == 0}">disabled</c:if> onclick="goToPreProblem()">上一题</button>
                <button class="next am-btn-success am-btn-lg" onclick="goToNextProblem()">下一题</button>
                <button class="submit am-btn-default am-btn-lg" onclick="submit()">交卷</button>
            </div>
        </div>
        <div class="col-sm-12 col-lg-3">
            <div class="datika">
                <ul class="datika-list-w">
                    <c:forEach items="${sessionScope.problem_id_list}" var="item" varStatus="status">
                    <li id="${status.index}"><a href="generateMockTest?curr=${status.index}">${status.index+1}</a></li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
</div>
<fieldset class="tishi-img">
    <legend>图片信息</legend>
    <div class="media-w">
        <c:if test="${sessionScope.problem_by_id.img!=null}">
            <img src="${sessionScope.problem_by_id.img}" alt="" ref="bigImg">
        </c:if>
    </div>
</fieldset>
<script src="https://cdn.bootcss.com/zepto/1.0rc1/zepto.min.js"></script>
<script src="http://cdn.clouddeep.cn/amazeui/1.0.1/js/amazeui.min.js"></script>
<script src="js/localStorageUtils.js"></script>
<script src="js/cookieUtils.js"></script>
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
    $("#"+${sessionScope.curr}).addClass("curr");
    var setTimer = null;
    var chazhi = 0;
    //差值计算
    //例子(模拟)
    chazhi = 45 * 60  * 1000;
    //真实时间(注意月份需减掉1，否则时间会计算错误)
    //chazhi = (new Date(year,month-1,day,hour,minute,second)) - (new Date()); //计算剩余的毫秒数
    //chazhi = (new Date(2018,8-1,6,6,6,6)) - (new Date());

    //执行函数部分
    countFunc(chazhi);
    setTimer = setInterval(function() {
        chazhi = chazhi - 1000;
        countFunc(chazhi);
    }, 1000);



    function countFunc(leftTime) {
        if(leftTime >= 0) {
            var minutes = parseInt(leftTime / 1000 / 60 % 60, 10); //计算剩余的分钟
            var seconds = parseInt(leftTime / 1000 % 60, 10); //计算剩余的秒数
            minutes = checkTime(minutes);
            seconds = checkTime(seconds);
            $(".joinm").html(minutes);
            $(".joins").html(seconds);
        } else {
            clearInterval(setTimer);
            $(".joinm").html("00");
            $(".joins").html("00");
        }
    }
    function checkTime(i) { //将0-9的数字前面加上0，例1变为01
        if(i < 10) {
            i = "0" + i;
        }
        return i;
    }

    function checkAnswers(answer) {
        var res = "${sessionScope.problem_by_id.result}";
        if(sessionStorage.getItem("${sessionScope.curr}")){
            alert("请不要重复提交")
        }else{
            if(answer === res){
                sessionStorage.setItem(${sessionScope.curr},"pass")
            }else{
                sessionStorage.setItem(${sessionScope.curr},"faild")
            }
        }
        goToNextProblem()
    }

    function goToNextProblem() {
        var curr = "${sessionScope.curr+1}";
        window.location.href = "generateMockTest?curr="+curr;
    }

    function goToPreProblem() {
        var curr = "${sessionScope.curr-1}";
        window.location.href = "generateMockTest?curr="+curr;
    }

    function changeTheStyle() {
        var pass_num = 0;
        var faild_num = 0;
        for (var i=0;i<="${sessionScope.problem_id_list.size()}";i++){
            var res = sessionStorage.getItem(i);
            if(res === "pass"){
                $('#'+i).addClass("pass");
                pass_num++;
            }else if(res === "faild"){
                $('#'+i).addClass("faild");
                faild_num++;
            }
        }
        return {
            "fail":faild_num,
            "pass":pass_num
        }

    }
    changeTheStyle();
    function submit() {
        console.log(changeTheStyle());
        $.ajax({
            type:"post",
            url: "mockSubmit",
            data: changeTheStyle(),
            success:function (data) {
                window.location.href = "result.jsp"
            }
        })
    }
</script>
</body>
</html>

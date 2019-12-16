<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: wangx
  Date: 2019/12/10
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>无忧驾考 | 测试</title>
    <link rel="alternate icon" type="image/png" href="i/favicon.png">
    <link rel="stylesheet" href="http://cdn.clouddeep.cn/amazeui/1.0.1/css/amazeui.min.css"/>
    <link rel="stylesheet" href="css/subjectone.css" />
    <link rel="stylesheet" href="css/test.css" />
    <link href="https://cdn.bootcss.com/font-awesome/5.11.2/css/fontawesome.min.css" rel="stylesheet">
</head>
<body>
<c:if test="${sessionScope.problem.mode == 1}">
    <jsp:include page="NavBar.jsp">
        <jsp:param name="active" value="2"/>
    </jsp:include>
</c:if>
<c:if test="${sessionScope.problem.mode == 4}">
    <jsp:include page="NavBar.jsp">
        <jsp:param name="active" value="3"/>
    </jsp:include>
</c:if>

<div class="am-panel am-panel-default fram-1">
    <div class="am-panel-bd">
        <div class="q-bd">
            <div class="content">
                ${sessionScope.problem.content}
            </div>

            <div class="answers">
                <c:if test="${sessionScope.chooses[0]!=null}">
                   <p ref="answerclick" onclick="checkAnswer('A')" id="A" data-a-label="A" class="">${sessionScope.chooses[0]}</p>
                </c:if>
                <c:if test="${sessionScope.chooses[1]!=null}">
                    <p ref="answerclick" onclick="checkAnswer('B')" id="B" data-a-label="B" class="">${sessionScope.chooses[1]}</p>
                </c:if>
                <c:if test="${sessionScope.chooses[2]!=null}">
                    <p ref="answerclick" id="C" onclick="checkAnswer('C')" data-a-label="C" class="">${sessionScope.chooses[2]}</p>
                </c:if>
                <c:if test="${sessionScope.chooses[3]!=null}">
                    <p ref="answerclick" id="D" onclick="checkAnswer('D')" data-a-label="D" class="">${sessionScope.chooses[3]}</p>
                </c:if>
            </div>
            <c:if test="${sessionScope.problem.img!=null}">
                <img class="content-img" src="${sessionScope.problem.img}" />
            </c:if>

            <c:if test="${fn:length(sessionScope.problem.result) >= 2}">
                <button id="confirm-btn" onclick="checkMultiChoose()" class="am-btn am-btn-primary am-btn-lg" style="margin-left: 20px">确定</button>
            </c:if>

        </div>

        <div class="option-type-msg">
            <span id="problem-msg">
                <p style="color: greenyellow">通过:${cookie.pass.value}</p>
                <p style="color: red">错误:${cookie.fail.value}</p>
            </span>
        </div>
        <div class="bottom-btn">
            <a id="pre-btn" href="getOrderTest?pid=${sessionScope.problem.pid+1}" class="am-btn am-btn-primary am-btn-lg"
            <c:if test="${sessionScope.problem.pid==1}">
               disabled
            </c:if>">上一题
            </a>
            <a id="next-btn" href="getOrderTest?pid=${sessionScope.problem.pid+1}" class="am-btn am-btn-primary am-btn-lg" style="margin-left: 20px">下一题</a>
        </div>
    </div>
</div>
<script src="https://cdn.bootcss.com/zepto/1.0rc1/zepto.min.js"></script>
<script src="http://cdn.clouddeep.cn/amazeui/1.0.1/js/amazeui.min.js"></script>
<script src="js/cookieUtils.js"></script>
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
    var res = "${sessionScope.problem.result}";
    //为多选题
    if(res.length >= 2){
        $('#problem-msg').text("多选题，请选择两个以上的答案！")
    }else{
        $('#problem-msg').text("单选题，请选择你觉得正确的答案!")
    }

    /**
     * 检查答案是否一致，单选题
     * @param answer
     */
    function checkAnswer(answer) {
        var result = "${sessionScope.problem.result}";
        if(result.length < 2){
            if(answer === result){
                $("#"+answer).addClass("correct");
                setCookie("pass",parseInt(getCookie("pass"))+1);
                goToNextProblem()
            }else{
                $("#"+answer).addClass("error");
                $("#"+result).addClass("correct");
                setCookie("fail",parseInt(getCookie("fail"))+1);
            }
        }else{
            if(!$("#"+answer).hasClass("success")){
                $('#'+answer).addClass("success");
            }else{
                $('#'+answer).removeClass("success")
            }
        }
    }


    /**
     * 检查答案是否一致，多选题
     *
     */
    function checkMultiChoose() {
        var flag = true
        var answer_list = []
        //获取选择的答案
        if($('#A').hasClass("success")){
            answer_list.push("A")
        }
        if($('#B').hasClass("success")){
            answer_list.push("B")
        }
        if($('#C').hasClass("success")){
            answer_list.push('C')
        }
        if($('#D').hasClass("success")){
            answer_list.push("D")
        }
        //判断答案是否正确
        var result = "${sessionScope.problem.result}"
        var res_list = result.split("")
        //答案没有选全
        for (var i=0;i<res_list.length;i++){
            var r = res_list[i]
            console.log(!isInArray(answer_list, r)+"  r is: "+ r)
            if(!isInArray(answer_list,r)){
                console.log(1)
                $('#'+r).addClass("correct")
                flag = false
            }
        }
        //答案不在结果之中
        for (var i=0;i<answer_list.length;i++){
            var as = answer_list[i]
            console.log(!isInArray(res_list, as)+"  as is: "+ as)
            if(!isInArray(res_list, as) && as!=null){
                console.log(2)
                $("#"+as).removeClass("success");
                $('#'+as).addClass("error")
                flag = false
            }
        }
        //全部正确跳转下一题
        if(flag){
            goToNextProblem()
        }

    }

    function isInArray(arr,value){
        for(var i = 0; i < arr.length; i++){
            if(value === arr[i]){
                return true;
            }
        }
        return false;
    }

    function goToNextProblem() {
        var url = $("#next-btn").attr("href");
        window.location.href = url
    }
</script>
</body>
</html>

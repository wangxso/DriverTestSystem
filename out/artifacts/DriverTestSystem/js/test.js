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
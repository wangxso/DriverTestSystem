<%--
  Created by IntelliJ IDEA.
  User: wangx
  Date: 2019/12/11
  Time: 9:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>报名驾校</title>
    <link rel="alternate icon" type="image/png" href="i/favicon.png">
    <link rel="stylesheet" href="http://cdn.clouddeep.cn/amazeui/1.0.1/css/amazeui.min.css"/>
    <link rel="stylesheet" href="css/entry.css"/>
    <link rel="stylesheet" href="https://www.layuicdn.com/layui-v2.5.5/css/layui.css">
</head>
<body>
<jsp:include page="NavBar.jsp" flush="true">
    <jsp:param name="active" value="4"/>
</jsp:include>
<div class="entry-bd">
    <div class="am-panel am-panel-default top-box">
        <div class="am-panel-bd">
            <div class="am-g com-info-base">
                <div class="col-sm-2 col-lg-2">
                    <img src="${sessionScope.driver_school.src}" alt="${sessionScope.driver_school.title}">
                </div>
                <div class="col-sm-4 col-lg-6">
                    <p class="top-title">
                        ${sessionScope.driver_school.title}
                    </p>
                    <p class="phone">
                        电话:${sessionScope.driver_school.phone}
                    </p>
                    <p class="adderss">
                        驾校地址：${sessionScope.driver_school.address}
                    </p>
                </div>
                <div class="col-sm-6 col-lg-4">
                    <p class="price" style="margin-top: 50px;">￥${sessionScope.driver_school.price}</p>
                </div>
            </div>
        </div>
    </div>

    <div class="am-panel am-panel-default bottom-form-box">
        <div class="am-panel-bd bottom-from" id="entery-form">
            <form class="am-form" action="#" method="post">
                <fieldset>
                    <legend>
                        <h3 class="bottom-form-title">
                            报名咨询
                        </h3>
                    </legend>
                    <form class="layui-form" action="#">
                        <div class="layui-form-item">
                            <label class="layui-form-label">姓名</label>
                            <div class="layui-input-block">
                                <input type="text" name="name" required  lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input">
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label class="layui-form-label">手机号</label>
                            <div class="layui-input-block">
                                <input type="text" lay-verify="phone | required" placeholder="请输入手机号">
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label class="layui-form-label">邮箱</label>
                            <div class="layui-input-block">
                                <input type="text" name="email" required  lay-verify="eamil" placeholder="请输入eamil" autocomplete="off" class="layui-input">
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <div class="layui-input-block">
                                <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                            </div>
                        </div>
                    </form>
        </div>
    </div>
</div>
<script src="https://cdn.bootcss.com/zepto/1.0rc1/zepto.min.js"></script>
<script src="http://cdn.clouddeep.cn/amazeui/1.0.1/js/amazeui.min.js"></script>
<script src="js/jquery.min.js"></script>
<script src="https://www.layuicdn.com/layui-v2.5.5/layui.js"></script>
<script type="text/javascript">

    layui.use('form', function(){
        var form = layui.form;

        //监听提交
        form.on('submit(formDemo)', function(data){
            layer.msg("提交成功",{icon:1})
        });
    });


</script>
</body>
</html>

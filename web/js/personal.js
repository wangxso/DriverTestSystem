
$(document).ready(function () {
        $.ajax({
            type:"get",
            url: "getUserProfile",
            success:function (data) {
                var json = JSON.parse(data);
                console.log(json);
                f = false;
                let item = sessionStorage.getItem("flag");
                if(item==null){
                    window.location.reload();
                    sessionStorage.setItem("flag","true")
                }
                $('#loadgif').hide()
            },
            error: function (e) {
                alert("加载失败")
            }
        })
});

/**
 * 进入下一页
 * @param curr
 */
function toPagination(curr) {
    $.ajax({
        type:"get",
        url: "pagination",
        data:{
            "curr":curr
        },
        success: function (data) {

        }
    })
}



function checkOldPassword(oldPassword) {
    $.ajax({
        type: 'post',
        url: 'checkPassword',
        data:{
            "password": oldPassword
        },
        success: function (data) {

        }
    })

}


function changePassWord() {
    //prompt层
    layer.prompt({title: 'please input old password', formType: 1}, function(pass, index){
        layer.msg(pass);
        layer.close(index);
    });
}
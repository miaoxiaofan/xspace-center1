// $(function () {
//     valide();
//  });
function valide1() {
    var username =$("#username").val();
    var password =$("#password").val();

    var params = {
        name: username,
        password: password
    }
    var url = WEB_ROOT + "/memeber/valide";

    $.ajax({
        url: url,
        data: params,
        dataType: "json",
        type: "GET",
        success: function (result) {

            if (result.code==0) {
                alert("提示:校验成功");
            }
            else {
                alert("校验失败,"+result.msg);
            }
        },
        error: function (msg) {

            alert("提示,校验失败");
        }
    });

}


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

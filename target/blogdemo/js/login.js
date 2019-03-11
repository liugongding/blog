        $("#username").keyup(
            function () {
                if(isNaN($("#username").val())){
                    $("#info").text("提示:账号只能为数字");
                }
                else {
                    $("#info").text("");
                }
            }
        )
        $("#loginButton").click(function () {
            if($("#username").val()==''&&$("#password").val()==''){
                $("#info").text("提示:账号和密码不能为空");
            }
            else if ($("#username").val()==''){
                $("#info").text("提示:账号不能为空");
            }
            else if($("#password").val()==''){
                $("#info").text("提示:密码不能为空");
            }
            else if(isNaN($("#username").val())){
                $("#info").text("提示:账号必须为数字");
            }
            else {
                $.ajax({
                    type: "POST",
                    url: "/blog/login/logindemo",
                    data: {
                        username:$("#username").val() ,
                        password: $("#password").val()
                    },
                    dataType: "json",
                    success: function(data) {
                        if(data.stateCode == "0") {
                            $("#info").text("提示:该用户不存在或密码错误");
                        } else if(data.stateCode == "1") {
                            $("#info").text("提示:该用户不存在或密码错误");
                        } else if(data.stateCode == "2"){
                            $("#info").text("提示:登陆成功，跳转中...");
                            window.location.href="/blog/view/backstage.html";
                        }
                    }
                });
            }
        })

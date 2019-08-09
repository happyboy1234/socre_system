<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="renderer" content="webkit">
<title>login</title>
	<link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
	<link href="/css/bootstrap.min.css" rel="stylesheet">
	<link href="/css/login.css" rel="stylesheet">
	<script src="/js/jquery-3.3.1.min.js"></script>
	<script src="/js/bootstrap.min.js"></script>
    <!-- 弹出框 -->
	<script type="text/javascript" src="/js/layer/layer.js"></script>
</head>
<body>
    <div class="container">
        <div class="form row">
            <div class="form-horizontal col-md-offset-3" id="login_form">
                <h3 class="form-title">LOGIN</h3>
                <div class="col-md-9">
                	<form method="post">
	                    <div class="form-group">
	                        <i class="fa fa-user fa-lg"></i>
	                        <input class="form-control required" type="text" placeholder="用户名" id="username" name="username" autofocus="autofocus" maxlength="20" value="${loname }">
	                    </div>
	                    <div class="form-group">
	                    	<i class="fa fa-lock fa-lg"></i>
	                    	<input class="form-control required" type="password" placeholder="密码" id="password" name="password" maxlength="16"/>
	                    </div>
	                    <div class="form-group">
	                    	<div class="row">
	                    		<div class="col-sm-6 ">
			                    	<input class="form-control required" type="text" placeholder="验证码" id="ucheckcode" name="ucheckcode" maxlength="16"/>
	                    		</div>
	                    		<div class="col-sm-4 pull-left">
				                	<img src="/user/checkCode" alt="" width="100" height="33" class="passcode" style="height:33px;cursor:pointer;" onclick="this.src=this.src+'?'">
	                    		</div>
	                    	</div>
	                    </div>
	                    <div class="form-group col-md-offset-9">
	                      	<a href="register" class="pull-left"><font size="4">注册</font></a>
	                        <a href="javascript:void(0)" id="loginbtn" class="btn btn-success pull-right">登录</a>
	                        <!-- <button type="submit" id="loginbtn" class="btn btn-success pull-right" name="submit">登录</button> -->
	                    </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>

<script type="text/javascript">
var LOGIN = {
		checkInput:function() {
			
			if(!$("#username").val()) {
				layer.msg("请输入用户名");
				return false;
			}
			if(!$("#password").val()) {
				layer.msg("请输入密码");
				return false;
			}
			if(!$("#ucheckcode").val()) {
				layer.msg("请输入验证码");
				return false;
			}
			return true;
		},
		doLogin:function() {
			/* 获取当前项目名称
			function getContextPath(){
			    var pathName = document.location.pathname;
			    var index = pathName.substr(1).indexOf("/");
			    var result = pathName.substr(0,index+1);
			    return result;
			}
			var contextPath = getContextPath(); */
			$.post("/user/login", 
					{
						username:$("#username").val(),
						password:$("#password").val(),
						ucheckcode:$("#ucheckcode").val(),
					},
					function(data){	//e3Result
						if (data.status == 200) {
							if(data.data.power == 1){
									$(location).attr("href","/score/scoreSys");
							}
						} else {
							layer.alert(data.msg);
						}
					});
		},
		login:function() {
			if (this.checkInput()) {
				this.doLogin();
			}
		}
	
};
$(function(){
	$("#loginbtn").click(function(){
		LOGIN.login();
	});
});
</script>

</html>
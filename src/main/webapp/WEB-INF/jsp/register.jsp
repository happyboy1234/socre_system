<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="renderer" content="webkit">
<title>用户注册</title>
	<link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
	<link href="/css/bootstrap.min.css" rel="stylesheet">
	<link href="css/login.css" rel="stylesheet">
	<script src="/js/jquery-3.3.1.min.js"></script>
	<script src="/js/bootstrap.min.js"></script>
    <!-- 、弹出框 -->
	<script type="text/javascript" src="/js/layer/layer.js"></script>
</head>
<body>
    <div class="container">
        <div class="form row">
            <div class="form-horizontal col-md-offset-3" id="login_form">
                <h3 class="form-title">Register</h3>
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
	                            <i class="fa fa-lock fa-lg"></i>
	                            <input class="form-control required" type="password" placeholder="确认密码" id="passwordagain" name="password" maxlength="16"/>
	                    </div>
	                    <div class="form-group">
	                        <a href="/admin" class="pull-left">返回登录</a>
	                    </div>
	                    <div class="form-group col-md-offset-9">
	                        <a href="javascript:void(0)" id="register" class="btn btn-success pull-right">注册</a>
	                    </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
<script type="text/javascript">
//注册---------------------------------------------------------------------------------------------------------
var flag = false;
var REGISTER = {
		checkInput:function() {
			
			if(!$("#username").val()) {
				layer.msg("请输入用户名");
				return false;
			}
			if(flag == false){
				layer.alert("注册失败:用户名不能存在空格!");
				return false;
			}
			if(!$("#password").val()) {
				layer.msg("请输入密码");
				return false;
			}
			if(!$("#passwordagain").val()) {
				layer.msg("请确认密码");
				return false;
			}
			if($("#password").val() != $("#passwordagain").val()){
				layer.msg("两次输入密码不一致");
				return false;
			}
			return true;
		},
		doRegister:function() {
			
			$.post("/user/doRegister", 
					{
						username:$("#username").val(),
						password:$("#password").val()
					},
					function(data){	//e3Result
						if (data.status == 200) {
							layer.alert("注册成功:如需进入评分,请联系管理员开通权限",
									{
					    				btn:['确定'],
					    			},function(){
										$(location).attr("href","/admin")
					    			});
						} else {
							layer.alert("注册失败:" + data.msg);
						}
					});
		},
		register:function() {
			if (this.checkInput()) {
				this.doRegister();
			}
		}
	
};
//入口----------------------------------------------------------------------------------------------------------
$(function(){
	//注册
	$("#register").click(function(){
		REGISTER.register();
	});
	//异步确认用户名是否被占用
	$("#username").blur(function(){
		var cusername = $("#username").val();
		if(cusername != ""){
			var ret = /^[\S]*$/;
			if(!ret.test(cusername)){
				layer.alert("用户名中不能存在空格");
				flag = false;
			}else{
				$.get("/user/checkname",
						{
							registername:$("#username").val()
						},
						function(data){
							if(data.status != 200){
								layer.alert(data.msg);
								flag = false;
							}else{
								flag = true;
							}
						});
			}
		}
		
	});
	
	
});

</script>
</html>
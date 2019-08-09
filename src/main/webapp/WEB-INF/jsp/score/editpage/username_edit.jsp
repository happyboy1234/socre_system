<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="renderer" content="webkit">
<title>密码修改</title>
	<link href="/css/font-awesome.min.css" rel="stylesheet">
	<!-- <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"> -->
	<link href="/css/bootstrap.min.css" rel="stylesheet">
	<link href="/css/password_edit.css" rel="stylesheet">
	<script src="/js/jquery-3.3.1.min.js"></script>
	<script src="/js/bootstrap.min.js"></script>
    <!-- 、弹出框 -->
	<script type="text/javascript" src="/js/layer/layer.js"></script>
</head>
<body>
<div class="container">
        <div class="form row">
            <div class="form-horizontal col-md-offset-3" id="login_form">
                <h3 class="form-title">修改用户名</h3>
                <div class="col-md-9">
                	<form method="post">
	                    <div class="form-group">
	                        <i class="fa fa-user fa-lg"></i>
	                        <input class="form-control required" type="text" placeholder="新用户名" id="newusername" name="newusername" maxlength="20">
	                    </div>
	                    <div class="form-group">
	                            <i class="fa fa-lock fa-lg"></i>
	                            <input class="form-control required" type="password" placeholder="原密码" id="password" name="password" maxlength="16"/>
	                    </div>
	                    <div class="form-group col-md-offset-9">
	                    	<a href="javascript:void(0)" id="changeUsername" class="btn btn-success pull-right">确认更改</a>
	                    </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
<script type="text/javascript">
//修改用户名-----------------------------------------------------------------------------------------
var flag = false;
var CHANGEUSERNAME = {
		checkInput:function() {
			
			if(!$("#newusername").val()) {
				layer.msg("请输入新用户名");
				return false;
			}
			if(!$("#password").val()) {
				layer.msg("请输入密码");
				return false;
			}
			if(flag == false){
				layer.alert("更改失败:用户名被占用或存在空格");
				return false;
			}
			return true;
		},
		doChange:function() {
			
			$.post("/user/changeUsername", 
					{
					newusername:$("#newusername").val(),
					password:$("#password").val()
					},
					function(data){	//e3Result
						if (data.status == 200) {
							layer.alert("修改成功",
								{
								btn:['确定'],
								},function(){
									window.parent.location.reload();							
								});
							
						} else {
							layer.alert("修改失败:" + data.msg);
						}
					});
		},
		change:function() {
			if (this.checkInput()) {
				this.doChange();
			}
		}
	
};
//入口----------------------------------------------------------------------------------------------------------
$(function(){
	//修改用户名
	$("#changeUsername").click(function(){
		CHANGEUSERNAME.change();
	});
	
	
	//异步确认用户名是否被占用
	$("#newusername").blur(function(){
		
		var cusername = $("#newusername").val();
		if(cusername != ""){
			var ret = /^[\S]*$/;
			if(!ret.test(cusername)){
				layer.alert("用户名中不能存在空格");
				flag = false;
			}else{
				$.get("/user/checkname",
						{
							registername:$("#newusername").val()
						},
						function(data){
							if(data.status != 200){
								flag = false;
								layer.msg(data.msg);
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
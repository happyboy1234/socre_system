<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="renderer" content="webkit">
<title>Insert title here</title>
    <!-- 1、Jquery组件引用 -->
    <script src="/js/jquery-3.3.1.min.js"></script>

    <!-- 2、bootstrap组件引用 -->
    <script src="/js/bootstrap.min.js"></script>
    <link href="/css/bootstrap.css" rel="stylesheet" />
    
    <!-- 3、弹出框 -->
	<script type="text/javascript" src="/js/layer/layer.js"></script>
</head>
<body>
	<!--顶部导航栏部分-->
	<nav class="navbar navbar-default">
	    <div class="container">
	        <div class="navbar-header">
	            <a class="navbar-brand" title="logoTitle" href=""><font style="color:black">用户权限管理</font></a>
	       </div>
	    </div>      
	</nav>
<div class="container">
	目标用户:<span class="badge">${requestScope.username }</span><br>
			<input type="hidden" id="target_user" value="${requestScope.username }"/>
	    	<%-- <input type="hidden" id="power" value="${requestScope.power }" /> --%>
	    	<input type="hidden" id="new_power" value="${(requestScope.power==0)?'普通用户':'管理员' }" />
	<hr>
	<div class="dropdown">
	  	修改权限:
	  	<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
	    	<span class="buttonText">${(requestScope.power==0)?"普通用户":"管理员" }</span>
	    	<span class="caret"></span>
	  	</button>
	  	<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
	    	<li><a href="#" onclick="shows($(this).text())">普通用户</a></li>
	    	<li role="separator" class="divider"></li>
	    	<li><a href="#" onclick="shows($(this).text())">管理员</a></li>
	  	</ul>
	  	<a href="javascript:void(0)" id="modify_power" class="btn btn-success pull-right">保存</a>
	</div>
</div>
</body>
<script type="text/javascript">
//当选择权限时记录信息-------------------
function shows(a) {
    $('.buttonText').text(a)
    if(a == "普通用户"){
    	$("#new_power").val(0)
    }
    if(a == "管理员"){
    	$("#new_power").val(1)
    }
}
//点击保存时-----------------------------
$(function(){
	$("#modify_power").click(function(){
		var username = $("#target_user").val();
		var power = $("#power").val();
		var newpower = $("#new_power").val();
		$.post("/user/modifyUserPower",
				{
				username: username,
				//power: power,
				newpower: newpower
				},
				function(data){	//e3Result
					if (data.status == 200) {
						layer.alert("权限修改成功",
								{
									btn:["确定"],
								},function(){
								var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
					           	//layer.msg(index); 弹出框 几秒后自动消失
					           	parent.layer.close(index); //再执行关闭
							});
						
					} else {
						layer.alert("权限修改失败:" + data.msg);
					}
				});
	});
});
</script>
</html>
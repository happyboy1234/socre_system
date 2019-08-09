<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="renderer" content="webkit">
<title>Insert title here</title>
	<script src="/js/jquery-3.3.1.min.js"></script>
</head>
<body>
<div class="jumbotron" style="height:100%">
	<h1>&nbsp;&nbsp;&nbsp;&nbsp;保存失败</h1>
	<h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${requestScope.msg }</h3>
	<h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;窗口将在3秒后关闭</h3>
</div>
<script type="text/javascript">
	setTimeout(function(){
			var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
	        //layer.msg(index);
	        parent.layer.close(index); //再执行关闭
		}, 3000);
</script>
</body>
</html>
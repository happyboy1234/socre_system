<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="renderer" content="webkit">
	<script src="/js/jquery-3.3.1.min.js"></script>
    <script src="/js/layer/layer.js"></script>
</head>
<body>
<script type="text/javascript">
	$(function(){
		layer.msg("保存成功")
		setTimeout(function(){
				var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
		        //layer.msg(index);
		        parent.layer.close(index); //再执行关闭
			}, 1200);
	})
</script>
</body>
</html>
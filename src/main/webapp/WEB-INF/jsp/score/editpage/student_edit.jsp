<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit">
    <title>学生编辑页面</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/bootstrap-fileinput/css/bootstrap-fileinput.css" rel="stylesheet">
	<script src="/js/jquery-3.3.1.min.js"></script>
	<script src="/bootstrap-fileinput/js/bootstrap-fileinput.js"></script>
	<!-- 1、弹出框 -->
	<script type="text/javascript" src="/js/layer/layer.js"></script>
</head>
<body>
<div class="container">
    <div class="page-header">
        <form action="/student/updateStudent" method="post" id="uploadForm" enctype="multipart/form-data">
        <div class="row">
			<div class="form-group">
	            <div class="col-sm-4">
	                <!-- <div class="h4">图片预览</div> -->
	                <div class="fileinput fileinput-new" data-provides="fileinput"  id="exampleInputUpload">
	                    <div class="fileinput-new thumbnail" style="width: 150px;height: auto;max-height:240px;">
	                        <img id='picImg' style="width: 100%;height: auto;max-width: 140px;max-height:200px;" src="${(student.imageadr==null)?'/bootstrap-fileinput/images/noimage.png':student.imageadr }" alt="" />
	                      	图片不得大于<font color="red">3M</font>
	                    </div>
	                    <div class="fileinput-preview fileinput-exists thumbnail" style="max-width: 200px; max-height: 150px;"></div>
	                    <div>
	                        <span class="btn btn-primary btn-file">
	                            <span class="fileinput-new">&nbsp;&nbsp;选择图片</span>
	                            <span class="fileinput-exists">换一张</span>
	                            <input type="file" name="img" id="img" accept="image/gif,image/jpeg,image/x-png"/>
	                        </span>
	                        <a href="javascript:;" class="btn btn-warning fileinput-exists" data-dismiss="fileinput">移除</a>
	                    </div>
	                </div>
	        	</div>
	        	<input type="hidden" id="id" name="id" value="${student.id }"/>
	        	<input type="hidden" id="preimage" name="preimage" value="${student.imageadr }"/>
	            <div class="col-sm-8">
	            	<div class="form-group" style="margin-top:15px">
                        <label  class="control-label col-sm-2 col-md-1" for="sno">学号:</label>
                        <div class="col-sm-7">
                            <input id="sno" name="sno" type="text" class="form-control" placeholder="学号" value="${student.sno }" readonly/>
                        </div><br><br>
                    </div>
	            	<div class="form-group" style="margin-top:15px">
                        <label  class="control-label col-sm-2 col-md-1" for="name">姓名:</label>
                        <div class="col-sm-7">
                            <input id="name" name="name" type="text" class="form-control" placeholder="姓名" value="${student.name }"/>
                        </div><br><br>
                    </div>
	            	<div class="form-group" style="margin-top:15px">
                        <label  class="control-label col-sm-2 col-md-1" for="academy">学院:</label>
                        <div class="col-sm-7">
                            <input id="academy" name="academy" type="text" class="form-control" placeholder="学院" value="${student.academy }"/>
                        </div><br><br>
                    </div>
	            	<div class="form-group" style="margin-top:15px">
                        <label  class="control-label col-sm-2 col-md-1" for="grade">班级:</label>
                        <div class="col-sm-7">
                            <input id="grade" name="grade" type="text" class="form-control" placeholder="班级" value="${student.grade }"/>
                        </div><br><br>
                    </div>
	            	<div class="form-group" style="margin-top:15px">
                        <label  class="control-label col-sm-2 col-md-1" for="phone">手机:</label>
                        <div class="col-sm-7">
                            <input id="phone" name="phone" type="text" class="form-control" placeholder="性别" value="${student.phone }"/>
                        </div><br><br>
                    </div>
	            	<div class="form-group" style="margin-top:15px">
                        <label  class="control-label col-sm-2 col-md-1" for="sex">性别:</label>
                        <div class="col-sm-7">
                            <%-- <input id="sex" name="sex" type="text" class="form-control" placeholder="性别" value="${student.sex }"/> --%>
                            <select class="input-xlarge" style="min-width: 100px;height: 30px;" id="sex" name="sex">
	                            	<option>${student.sex }</option>
								</select> 
                        </div><br><br>
                    </div>
	            	<div class="form-group" style="margin-top:15px">
                        <div class="col-sm-9"  style="text-align:right;">
			            	<button type="submit" id="uploadSubmit" class="btn btn-info">保存</button>
                        </div><br><br>
                    </div>
                    
	            </div>
        	</div>       
      	</div>
        </form>
    </div>
</div>
</body>
<script type="text/javascript">
	$(function(){
		var flag = false;
		
		$("#uploadSubmit").click(function() {
			var name = $("#name").val();
			if(name == ""){
				layer.msg("姓名不能为空")
				return false
			}
			var academy = $("#academy").val();
			if(academy == ""){
				layer.msg("学院不能为空")
				return false
			}
			var grade = $("#grade").val();
			if(grade == ""){
				layer.msg("班级不能为空")
				return false
			}
			var phone = $("#phone").val();
			if(phone != ""){
				var ret = /^1\d{10}$/;
				if(!ret.test(phone)){
					layer.alert("手机号格式错误,可以不填手机号,但格式必须正确!")
					return false;
				}
			}
			var sex = $("#sex").val();
			if(sex == ""){
				layer.msg("性别不能为空")
				return false
			}
			return true;
		});//-------------------------------------------------------------------
		
		//判断下拉框赋值
		var a = $("#sex option:selected").text();
		if(a == "男"){ 
			 $("#sex").append("<option>女</option>");
		 }
		if(a == "女"){ 
			 $("#sex").append("<option>男</option>");
		 }
		
	});
</script>
</html>
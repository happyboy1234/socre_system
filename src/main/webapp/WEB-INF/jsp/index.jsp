<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit">
<title>评分查询</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="/css/build.min.18082018.css" rel="stylesheet" type="text/css" media="all">

	<script src="/js/jquery-3.3.1.min.js"></script>
    <!-- 弹出框 -->
	<script type="text/javascript" src="/js/layer/layer.js"></script>
	
	<!-- 7、日历时间组件 -->
    <link href="/css/bootstrap-datetimepicker.css" rel="stylesheet" />
    <script src="/js/moment-with-locales.js"></script>
    <script src="/js/bootstrap-datetimepicker.js"></script>
    <script src="/js/bootstrap-datetimepicker.zh-CN.js"></script>
    
<style type="text/css">
.footer {
	 display:block;
     width: 100%;
     height: 30px;
     line-height: 30px;
     margin-top: 0;
     left: 0;
     right: 0;
     bottom: 0;
     position: absolute; 
     z-index: 10;
     background-color:#DFDFDF;
     position: fixed;  
 }
html,body{
	width: 100%;
	height: 100%;
}
.main-container{
	width: 100%;
	height: 100%;
}
</style>
</head>
<body>
	<div class="nav-container">
		<nav class="nav-1">
			<div class="container">
				<div class="row">
					<div class="col-xs-12">
						<a href="#" class="home-link">
							<img src="" alt="IrAts" class="logo">
						</a>
						<ul class="menu">
							<li><a href="#">一</a></li>
							<li><a href="#">二</a></li>
							<!-- <li class="has-dropdown"><a href="#">二</a>
								<ul class="subnav">
									<li><a href="/docs/getting-started-guide">这个屌</a></li>
									<li><a href="/docs/user-guide">User Guide</a></li>
									<li><a href="/docs/industry-word2vec">Industry
											Word2Vec</a></li>
									<li><a href="/docs/api-reference">REST API</a></li>
								</ul>
							</li> -->
							<li><a href="#">三</a></li>
							<li><a href="#">四</a></li>
							<li><a href="#">五</a></li>
						</ul>
						<ul class="social-links">
<!-- 							<li><a href="#" target="_blank">欢迎~</a></li> -->
							<li><a href="#">欢迎~</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="mobile-toggle">
				<div class="bar-1"></div>
				<div class="bar-2"></div>
			</div>
		</nav>
	</div>
	<div class="promo-1">
		<!--<div class="main-container">
			<section class="promo-1"> -->
			<div class="promo-image-holder">
				<div class="background-image-holder fadeIn" style="background: url(&quot;/images/indeximg.jpg&quot;) 50% 50%;">
					<img alt="Slide Background" src="/images/indeximg.jpg" class="background-image" style="display: none;">
				</div>
			</div>
			<div class="container">
				<div class="row">
					<div class="col-sm-10 col-sm-offset-1 text-center">
						<h1 class="text-white">评分查询</h1>
					</div>
				</div>
				<div class="row">
					<div class="col-md-10 col-md-offset-1 col-xs-12">
						<div class="col-sm-7 col-xs-12">
							<div class="col-sm-7 left-content col-xs-12">
								<div class="vertical-align">
									<h4>可选择时间段内查询</h4>
									
									<div class="row">
										<label  class="control-label col-sm-4" for="beginTime">开始日期：</label>
			                       		<div class="col-sm-6 col-xs-10">
				                            <div class='input-group date' id='datetimepicker1'>
												<input type='text' class="form-control" id="beginTime" readonly/> 
												<span class="input-group-addon">
												<span class="glyphicon glyphicon-calendar"></span>
												</span>
											</div>
				                       	</div>
				                	</div>
				                	<p class="lead"></p>
									<div class="row">
										<label  class="control-label col-sm-4" for="endTime">结束日期：</label>
				                   		<div class="col-sm-6  col-xs-10">
				                           <div class='input-group date' id='datetimepicker2'>
												<input type='text' class="form-control" id="endTime" readonly/> 
												<span class="input-group-addon">
												<span class="glyphicon glyphicon-calendar"></span>
												</span>
											</div>
				                       	</div>
				                	</div>
				                	<p class="lead"></p>
				                	<div class="row">
				                   		<div class="col-sm-4"></div>
				                   		<div class="col-sm-6">
				                           <div class='input-group date' id='datetimepicker2'>
						                		<a href="javascript:void(0)" id="clean_condition" target="_blank" class="btn btn-grey">清空日期</a>
											</div>
				                       	</div>
				                	</div>
								</div>
							</div>
							<div class="col-sm-5 left-content col-xs-12">
								<div class="vertical-align">
									<div class="row">
										<h4>平均分:</h4>
									</div>
									<div class="row">
										<p class="lead"></p><p class="lead"></p><p class="lead"></p>
										<div class="col-sm-8">
				                           <div class='input-group date' id='datetimepicker2'>
								               	<input type="text" class="form-control" id="avgScore" readonly />
											</div>
				                       	</div>
				                       	<br><br><br><br><br>
					                </div>
				               	</div>
							</div>
						</div>
						
						
						<!-- 
						<div class="col-sm-7 left-content">
							<div class="vertical-align">
								<h4>请绑定您的学号与姓名</h4>
								<p class="lead">
									Create an Event<sup>n</sup> account and enjoy a free allocation<br>
									of compute time, every month.
								</p>
								<p class="lead">
									为了保护您的隐私<br>
									在第一次登录时需要绑定自己的学号信息<br>
								</p>
							</div>
						</div>
						 -->
						 
						 
						<div class="col-sm-5 right-content col-xs-12">
							<div class="vertical-align">
								<h4><span class="sub">请输入您的学号姓名</span></h4>
								<div class="col-sm-3"></div>
								<div class="col-sm-6">
									<form method="post">
				                        <input class="form-control required" type="text" placeholder="学号" id="sno" name="sno" maxlength="11"/>
				                        <br>
				                    	<input class="form-control required" type="text" placeholder="姓名" id="stuname" name="stuname" maxlength="16"/>
				                    	<br>
				                    	<input type="hidden" id="ifmark" name="ifmark" value="已评分"/>
				                    </form>
			                    </div>
								<a href="javascript:void(0)" id="bunding" class="btn btn-white">查询</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		<!-- </section> -->
	</div>
	
</body>
<script type="text/javascript">
//注册---------------------------------------------------------------------------------------------------------
var BUNDING = {
		checkInput:function() {
			var sno = $("#sno").val();
			if(!$("#sno").val()) {
				layer.msg("请输入学号");
				return false;
			}
			if(!$("#stuname").val()) {
				layer.msg("请输入姓名");
				return false;
			}
			var ret = /^1\d{10}$/;
			if(!ret.test(sno)){
				layer.alert("学号格式错误!")
				return false;
			}
			return true;
		},
		doBunding:function() {
			
			$.post("/outerview/average_show", 
					{
						sno:$("#sno").val(),
						stuname:$("#stuname").val(),
			            beginTime: $("#beginTime").val(),
			            endTime: $("#endTime").val(),
			            ifmark: $("#ifmark").val(),
					},
					function(data){	//e3Result
						if (data.status == 200) {
							layer.msg("查询成功")
							$("#avgScore").val(Math.round(data.data.average*100)/100);
							$("#avgScore").focus()

						} else {
							layer.alert(data.msg);
						}
					});
		},
		bungding:function() {
			if (this.checkInput()) {
				this.doBunding();
			}
		}
	
};
//入口----------------------------------------------------------------------------------------------------------
$(function(){
	
	//绑定
	$("#bunding").click(function(){
		BUNDING.bungding();
	});
	
	
	//初始化时间选择
    $('#datetimepicker1').datetimepicker({
            format: "yyyy-mm-dd",
            autoclose: true,
            todayBtn: true,
            language:'zh-CN',
            pickerPosition:"bottom-left",
            minView: "month"
    });
    
    //初始化时间选择
    $('#datetimepicker2').datetimepicker({
    	format: "yyyy-mm-dd",
    	autoclose: true,
    	todayBtn: true,
    	language:'zh-CN',
    	pickerPosition:"bottom-left",
    	minView: "month"
    });
    
    $("#clean_condition").click(function(){
    	$("#beginTime").val("")
    	$("#endTime").val("")
    });
	
});

</script>

</html>
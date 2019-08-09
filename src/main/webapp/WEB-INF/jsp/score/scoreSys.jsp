<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="renderer" content="webkit">
<!-- 引入样式文件和动态控制 -->
<script src="/js/jquery-3.3.1.min.js"></script>
<link href="/css/bootstrap.min.css" rel="stylesheet">
<script src="/js/bootstrap.min.js"></script>
<!--主要样式控制-->
<link href="/css/main.css" rel="stylesheet">

<title>学生工作评分系统</title>

</head>
<body>
<!--顶部导航栏部分-->
<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" title="logoTitle" href="/score/scoreSys">学生工作评分系统</a>
       </div>
       <div class="collapse navbar-collapse">
           <ul class="nav navbar-nav navbar-right">
               <li role="presentation">
                   <a href="#">当前用户：<span class="badge">${user.username }</span></a>
               </li>
               <li>
                   <a href="/user/logout">
                         <span class="glyphicon glyphicon-lock"></span>退出登录</a>
                </li>
            </ul>
       </div>
    </div>      
</nav>

<!-- 中间主体内容部分 -->
<div class="pageContainer">
     <!-- 左侧导航栏 -->
     <div class="pageSidebar">
         <ul class="nav nav-stacked nav-pills">
             <li role="presentation">
                 <a href="">工作评价</a>
             </li>
             <li role="presentation">
                 <a href="stuManager" target="mainFrame">学生管理</a>
             </li>
             <li role="presentation">
                 <a href="workRecord" target="mainFrame">工作记录</a>
             </li>
             <li role="presentation">
                 <a href="doScore" target="mainFrame">评分</a>
             </li>
             <li role="presentation">
                 <a href="showScore" target="mainFrame">评分查询</a>
             </li>
             <li role="presentation">
                 <a href="avgScore" target="mainFrame">平均分统计</a>
             </li>
             <!-- 开始 -->
             <li class="dropdown">
                 <a class="dropdown-toggle" data-toggle="dropdown" href="nav4.html" target="mainFrame">
                     个人设置<span class="caret"></span>
                 </a>
                 <ul class="dropdown-menu">
                     <li>
                         <a href="editpage/username_edit" target="mainFrame">修改用户名</a>
                     </li>
                     <li>
                         <a href="editpage/password_edit" target="mainFrame">修改密码</a>
                     </li>
                 </ul>
             </li>
             <!-- 结束 -->
             <li role="presentation">
                 <a href="admin" target="mainFrame">权限设置</a>
             </li>



         </ul>
     </div>

      <!-- 左侧导航和正文内容的分隔线 -->
     <div class="splitter"></div>
     <!-- 正文内容部分 -->
     <div class="pageContent">
       <iframe src="welcome" id="mainFrame" name="mainFrame" 
       frameborder="0" width="100%"  height="100%" frameBorder="0">
       </iframe> 
     </div>

 </div>
  <!-- 底部页脚部分 -->
 <div class="footer">
     <p class="text-center">
         2019 &copy; IrAts & Pan.
     </p>
 </div>

 <script type="text/javascript">
 $(".nav li").click(function() {
        $(".active").removeClass('active');
        $(this).addClass("active");
    }); 


 </script>
</body>
</html>
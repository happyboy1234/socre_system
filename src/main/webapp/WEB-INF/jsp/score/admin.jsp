<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width" />
    <meta name="renderer" content="webkit">
    <title>用户管理</title>
    <!-- 1、Jquery组件引用 -->
    <script src="/js/jquery-3.3.1.min.js"></script>

    <!-- 2、bootstrap组件引用 -->
    <link href="/css/bootstrap.css" rel="stylesheet" />
    <script src="/js/bootstrap.min.js"></script>
    
    <!-- 3、bootstrap table组件以及中文包的引用 -->
    <script src="/js/bootstrap-table.js"></script>
    <link href="/css/bootstrap-table.css" rel="stylesheet" />
    <script src="/js/bootstrap-table-zh-CN.js"></script>
    <!-- 4、导出excle插件 -->
    <script src="/js/bootstrap-table-export.js"></script>
    <script src="/js/tableExport.js"></script>
    <script src="/js/jquery.base64.js"></script>
    
    <!-- 5、页面Js文件的引用 -->
    <script src="/js/edit/admin.js"></script>
    <!-- 6、弹出框 -->
	<script type="text/javascript" src="/js/layer/layer.js"></script>

<!-- 设置表格隔行变色 -->
<style type="text/css">
	#tb_departments tr:nth-child(even){
	background: #fafafa;
	}
</style>
</head>
<body>
    <div class="panel-body" style="padding-bottom:0px;">
        <div class="panel panel-default">
            <div class="panel-heading">查询条件</div>
            <div class="panel-body">
                <from id="formSearch" class="form-horizontal">
                    <div class="form-group" style="margin-top:15px">
                        <label  class="control-label col-sm-2 col-md-1" for="username">用户名:</label>
                        <div class="col-sm-4">
                            <input id="username" type="text" class="form-control" >
                        </div>
                        <div class="col-sm-4" style="text-align:right;">
                            <button type="button" style="margin-left:50px" id="btn_query" class="btn btn-primary">查询</button>
                        </div>
                    </div>
                </from>
            </div>
        </div>       

        <div id="toolbar" class="btn-group">
            <!-- <button id="btn_add" type="button" class="btn btn-default">
                <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
            </button> -->
            <button id="btn_edit" type="button" class="btn btn-default">
                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
            </button>
            <button id="btn_delete" type="button" class="btn btn-default">
                <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
            </button>
        </div>
        <table id="tb_departments"></table>
    </div>
</body>
</html>
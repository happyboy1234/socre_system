$(function () {

    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();
    
    //-----------------------------------查询事件
    $('#btn_query').click(function(){
    	if($("#username").val() =='' || $.trim($("#username").val()) ==''){
    		layer.alert("查询条件为空,即将显示所有数据");
    	}
    	$("#tb_departments").bootstrapTable('refresh',{url:'/user/user-list'});
    });
    
    //------------------------------------删除用户
    $("#btn_delete").click(function(){
    	var rows = $("#tb_departments").bootstrapTable("getSelections");
    	if(rows.length == 0){
    		layer.alert("请选择要删除的用户")
    		return;
    	}
    	layer.alert("确定要删除所选用户吗?",
					{
					btn:["确定"],
					},function(){
						var usernames='';
						for(var i=0; i<rows.length; i++){
							usernames += rows[i]['username'] + ",";
						}
						usernames = usernames.substring(0,usernames.length - 1)
						$.post("/user/deleteUser",
								{
							usernames:usernames
								},
								function(data){	//e3Result
									if (data.status == 200) {
										layer.msg("删除成功"); //弹出框 几秒后自动消失
										//删除成功刷新数据
										$("#tb_departments").bootstrapTable('refresh',{url:'/user/user-list'});
									} else if(data.status == 201){
										layer.alert(data.msg);
										$("#tb_departments").bootstrapTable('refresh',{url:'/user/user-list'});
									}else {
										layer.alert("删除失败:" + data.msg);
									}
								});
					});
    });
    
    //------------------------------------修改用户权限
    $("#btn_edit").click(function(){
    	var rows = $("#tb_departments").bootstrapTable("getSelections");
    	if(rows.length == 0){
    		layer.msg("请选择需要修改的用户")
    		return;
    	}else if(rows.length != 1){
    		layer.msg("只能修改一个用户信息")
    		return;
    	}
    	var user = rows[0];
    	var username = user.username + "";
    	var power = user.power;
    	layer.open({
    		type: 2,
    		title: '编辑用户权限',
    		area: ['350px','450px'],
    		fix: false,
    		content:'/user/goto_edit?username=' + username + "&power=" + power,
    		//content:'/score/editpage/power_edit?username=' + username + "&power=" + power,
    		end:function(){
    			$("#tb_departments").bootstrapTable('refresh',{url:'/user/user-list'});
    		}
    	});
    	
    });
    
});



var TableInit = function () {
	
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#tb_departments').bootstrapTable({
            url: '/user/user-list',         //请求后台的URL（*）
            method: 'get',                      //请求方式（*）
            toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: true,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "client",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pagenation: true,
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [5, 10, 25, 50],        //可供选择的每页的行数（*）
            search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: true,
            showColumns: true,                  //是否显示所有的列
            showRefresh: true,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: true,                //是否启用点击选中行
            height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "username",                     //每一行的唯一标识，一般为主键列
            showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: false,                   //是否显示父子表
            //导出功能
            exportDataType:'all',//'basic':当前页的数据, 'all':全部的数据, 'selected':选中的数据
            showExport: true,  //是否显示导出按钮
            buttonsAlign:"right",  //按钮位置
            exportTypes:['excel', 'txt', 'doc'],  //导出文件类型，[ 'csv', 'txt', 'sql', 'doc', 'excel', 'xlsx', 'pdf']
            columns: [{
                checkbox: true
            }, {
                field: 'username',
                title: '用户名',
                sortable: true
            },{
                field: 'power',
                title: '权限',
                sortable: true
            },{
                field: 'sno',
                title: '学号',
                sortable: true
            },{
                field: 'trueName',
                title: '姓名',
                sortable: true
            }]
        });
    };
	//得到查询的参数
	oTableInit.queryParams = function (params) {
	    var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
	    	//limit: params.limit,   //页面大小 
	        //offset: params.offset,  //开始索引值,就是第几条的意思 
	        //page: (params.offset/params.limit) +1,  //页码
	        username: $.trim($("#username").val())
	    };
	    return temp;
	};

    return oTableInit;
};


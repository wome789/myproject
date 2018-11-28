var form;

//初始化layui
layui.use(['form','table'], function(){
	var table = layui.table;
	form = layui.form;
	
	//=====================初始化表格========================
	//,{field:'info', title: '文章内容', align: 'center'}
	table.render({
		elem: '#table'
		,url:'/news/find'
		,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
		,cols: [[
			{type:'numbers'}
			,{field:'title', title: '标题' , align: 'center'} //width 支持：数字、百分比和不填写。你还可以通过 minWidth 参数局部定义当前单元格的最小宽度，layui 2.2.1 新增
			,{field:'createTime', title: '添加时间', align: 'center', sort: true}
			,{field:'state', title: '是否显示' , align: 'center',templet:'#stateBtn'}
			,{field:'toolBar', title: '操作' , align: 'center', toolbar: '#barDemo'}
		]]
		,page: true
		,id: 'newsReload'
	});
	//=====================初始化表格========================
	
	//=====================表单搜索==========================
	var $ = layui.$, active = {
		reload: function(){
			var titleParam = $('#titleParam').val();
			//执行重载
			table.reload('newsReload', {
				page: {
					curr: 1 //重新从第 1 页开始
				}
				,where: {
					title : titleParam
				}
			});
		}
	};

	$('.demoTable .layui-btn').on('click', function(){
	  var type = $(this).data('type');
	  active[type] ? active[type].call(this) : '';
	});
	//=====================表单搜索===============================
		
	//=====================表单工具条监听==========================
	//监听工具条
	table.on('tool(tableFilter)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
		var data = obj.data; //获得当前行数据
		var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
		var tr = obj.tr; //获得当前行 tr 的DOM对象
		
		if(layEvent === 'detail'){ //查看
			//do somehing
		} else if(layEvent === 'del'){ //删除
			layer.confirm('真的删除行么', function(index){
				obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
				layer.close(index);
				//向服务端发送删除指令
				deleteItem(data.id);
				search();
			});
		} else if(layEvent === 'edit'){ //编辑
			openUpdate("","","",baseAddress +'/news/updatePage?id=' + data.id);
		} else if(layEvent === 'show') {
			isShow(data.id,0);
		} else if(layEvent === 'notShow') {
			isShow(data.id,1);
		}
	});
	//=====================表单工具条监听==========================
		
	//========================业务逻辑====================================
		//initInfo();
	//========================业务逻辑====================================
});

//搜索方法
function search() {
	$("#search").click();
}

//添加新闻按钮
$('#updatePic').on('click', function(){
	openUpdate("",1100,600,baseAddress +'/news/updatePage');
});
$('#aaa').on('click', function(){
	var titleParam = $('#titleParam').val();
	alert(titleParam);
});

//删除
function deleteItem(id) {
	$.ajax({  
		url: baseAddress +"/news/delete",  
		type: 'post',  
		dataType: 'json',  
		data: {"id": id},   //<span style="color:#ff0000;">这里改为$('#formadd').serialize()提交数据正常，否则id="content"的值提交不过去</span>  
		success: function (data) {  
			if(data.errcode == 200) {
				layer.alert("操作成功");
		  	}else {
		  		layer.alert(data.errmsg);
		  	}
		},  
		error: function (XMLHttpRequest, textStatus, errorThrown) {  
			layer.alert("数据删除出错");
		}  
	});
}

//显示/不显示   1显示 0不显示
function isShow(id,showParam) {
	
	$.ajax({  
		url: baseAddress +"/news/update",  
		type: 'post',  
		dataType: 'json',  
		data: {"id": id,"state":showParam},   //<span style="color:#ff0000;">这里改为$('#formadd').serialize()提交数据正常，否则id="content"的值提交不过去</span>  
		success: function (data) {  
			if(data.errcode == 200) {
				layer.alert("操作成功");
				search();
		  	}else {
		  		layer.alert(data.errmsg);
		  	}
		},  
		error: function (XMLHttpRequest, textStatus, errorThrown) {  
			layer.alert("数据删除出错");
		}  
	});
	
}












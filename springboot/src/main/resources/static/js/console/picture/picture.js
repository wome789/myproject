var form;

//初始化layui
layui.use(['form','table'], function(){
	var table = layui.table;
	form = layui.form;
	
	//=====================初始化表格========================
	table.render({
		elem: '#pictureTable'
		,url:'/picture/find'
		,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
		,cols: [[
			{type:'numbers'}
			,{field:'name', title: '图片名称' , align: 'center'} //width 支持：数字、百分比和不填写。你还可以通过 minWidth 参数局部定义当前单元格的最小宽度，layui 2.2.1 新增
			,{field:'picTypeName', title: '图片分类', align: 'center', sort: true}
			,{field:'url', title: '图片效果', align: 'center',templet:'#img'}
			,{field:'jumpUrl', title: '跳转链接' , align: 'center'}
			,{field:'toolBar', title: '操作' , align: 'center', toolbar: '#barDemo'}
		]]
		,page: true
		,id: 'picReload'
	});
	//=====================初始化表格========================
	
	//=====================表单搜索==========================
	var $ = layui.$, active = {
		reload: function(){
			var picTypeId = $('#picType').val();
			//执行重载
			table.reload('picReload', {
				page: {
					curr: 1 //重新从第 1 页开始
				}
				,where: {
					picTypeId : picTypeId
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
			openUpdate("","","",baseAddress +'/picture/updatePage?id=' + data.id);
		}
	});
	//=====================表单工具条监听==========================
		
	//========================业务逻辑====================================
		initInfo();
	//========================业务逻辑====================================
});

//初始化下拉框
function initInfo() {
	$.ajax({  
		url: baseAddress + "/pictureType/findAll",  
		type: 'post',  
		dataType: 'json',  
		data: "",   //<span style="color:#ff0000;">这里改为$('#formadd').serialize()提交数据正常，否则id="content"的值提交不过去</span>  
		success: function (data) {  
			if(data.errcode == 200) {
				$.each(data.data, function (index, item) {
						$("#picType").append("<option value="+item.id+">"+item.name+"</option>");  
				});
				reloadSelect();
		  	}else {
		  		layer.alert(data.errmsg);
		  	}
		},  
		error: function (XMLHttpRequest, textStatus, errorThrown) {  
			layer.alert("数据请求出错");
		}  
	});  
}

//刷新select选择框渲染
function reloadSelect() {
	form.render('select'); 
}

//搜索方法
function search() {
	$("#search").click();
}

//添加图片按钮
$('#updatePic').on('click', function(){
	openUpdate("","","",baseAddress +'/picture/updatePage');
});

//删除
function deleteItem(id) {
	$.ajax({  
		url: baseAddress +"/picture/delete",  
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
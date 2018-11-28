var infoEditor,indexInfoEditor;

$(function(){
	//初始化富文本编辑器
	infoEditor = createLocalEditor("info");
	indexInfoEditor = createLocalEditor("indexInfo");
	
	initValue();
});

//初始化赋值
function initValue() {
	var infoValue = $("#infoValue").html();
	var indexInfoValue = $("#indexInfoValue").html();
	
	infoEditor.txt.html(infoValue);
	indexInfoEditor.txt.html(indexInfoValue);
}

layui.use(['form', 'layedit', 'laydate'], function(){
	var form = layui.form;
	var layer = layui.layer;
	var layedit = layui.layedit;
	var laydate = layui.laydate;
	
	form.on('submit(*)', function(data){
		//console.log(data.elem) //被执行事件的元素DOM对象，一般为button对象
		//console.log(data.form) //被执行提交的form对象，一般在存在form标签时才会返回
		//console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}
		var info = infoEditor.txt.html();
		var indexInfo = indexInfoEditor.txt.html();
		
		if(info == '' || info == undefined) {
			layer.alert("请设置内容");
			return;
		}
		if(indexInfo == '' || indexInfo == undefined) {
			layer.alert("请设置首页展示内容");
			return;
		}
		
		var params = $.param({'info':info,'indexInfo':indexInfo}) + '&' + $('#form').serialize();
		
		$.ajax({  
			url: baseAddress + "/aboutUs/update",  
			type: 'post',  
			dataType: 'json',  
			data: params,   //<span style="color:#ff0000;">这里改为$('#formadd').serialize()提交数据正常，否则id="content"的值提交不过去</span>  
			success: function (data) {  
				if(data.errcode == 200) {
					$("#submitBtn").removeAttr("disabled").text("立即提交");
					layer.alert('操作成功');
			  	}else {
			  		layer.alert(data.errmsg);
			  	}
			},  
			beforeSend: function () {  
			 // 一般是禁用按钮等防止用户重复提交  
			    $(data.elem).attr("disabled", "true").text("提交中...");  
			},  
			error: function (XMLHttpRequest, textStatus, errorThrown) {  
				layer.alert("提交出错");
			}  
		});

		return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
	});
   
});
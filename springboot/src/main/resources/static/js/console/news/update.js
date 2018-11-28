
var layerIndex,form,infoEditor;

$(function(){
	
	infoEditor = createLocalEditor("info");
	
	layui.use(['form', 'layedit', 'laydate','upload','layer'], function(){
		var layer = layui.layer;
		var upload = layui.upload;
		form = layui.form;
		var layer = layui.layer;
		var layedit = layui.layedit;
		var laydate = layui.laydate;
		
		//========================业务逻辑====================================
		initValue();
		//========================业务逻辑====================================
		
		
		//先得到当前iframe层的索引
		layerIndex = parent.layer.getFrameIndex(window.name); 
		
		
		form.on('submit(*)', function(data){
			//console.log(data.elem) //被执行事件的元素DOM对象，一般为button对象
			//console.log(data.form) //被执行提交的form对象，一般在存在form标签时才会返回
			//console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}
			
			var info = infoEditor.txt.html();
			
			if(info == '' || info == undefined) {
				layer.alert("请填写文章内容");
				return;
			}
			
			var params = $.param({'info':info}) + '&' + $('#form').serialize();
			
			$.ajax({  
				url: baseAddress + "/news/update",  
				type: 'post',  
				dataType: 'json',  
				data: params,   //<span style="color:#ff0000;">这里改为$('#formadd').serialize()提交数据正常，否则id="content"的值提交不过去</span>  
				success: function (data) {  
					if(data.errcode == 200) {
						//$(data.elem).attr("disabled", "false").text("立即提交");
						parent.layer.alert('操作成功');
						parent.layer.close(layerIndex);//需要手动关闭窗口
						//layer.closeAll();
				  	}else {
				  		layer.alert(data.errmsg);
				  	}
				},  
				beforeSend: function () {  
				 // 一般是禁用按钮等防止用户重复提交  
				    //$(data.elem).removeAttr("disabled").text("提交中...");  
				},  
				error: function (XMLHttpRequest, textStatus, errorThrown) {  
					//layer.alert("提交出错");
				}  
			});  

			return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
		});
	});       

});

//保存方法
function save() {
	$("#submitBtn").click();
}

function initValue() {
	var infoValue = $("#infoValue").html();
	
	infoEditor.txt.html(infoValue);
}

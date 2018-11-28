
var layerIndex,form;

$(function(){
	
	layui.use(['form', 'layedit', 'laydate','upload','layer'], function(){
		var layer = layui.layer;
		var upload = layui.upload;
		form = layui.form;
		var layer = layui.layer;
		var layedit = layui.layedit;
		var laydate = layui.laydate;
		
		//========================业务逻辑====================================
			initInfo();
		//========================业务逻辑====================================
		
		
		//先得到当前iframe层的索引
		layerIndex = parent.layer.getFrameIndex(window.name); 
		
		//普通图片上传
		var uploadInst = upload.render({
		  elem: '#picture'
		  ,url: baseAddress + '/tool/upload/'
		  ,before: function(obj){
		    //预读本地文件示例，不支持ie8
		   /*  obj.preview(function(index, file, result){
		      $('#icoImg').attr('src', result); //图片链接（base64）
		    }); */
		  }
		  ,done: function(data){
		  	if(data.errcode == 200) {
		  		var itemId = this.item.attr("id");
		  		$("#" + itemId + "Img").css("display","block");
				$("#" + itemId + "Img").attr("src", getImgSrc(data.data[0].fileName));
				$("#" + itemId + "ImgId").val(data.data[0].fileName);
		  	}else {
		  		alert(data.errmsg);
		  	}
		  }
		  ,error: function(){
		  }
		});
		
		form.on('submit(*)', function(data){
			//console.log(data.elem) //被执行事件的元素DOM对象，一般为button对象
			//console.log(data.form) //被执行提交的form对象，一般在存在form标签时才会返回
			//console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}
			var pictureImgId = $("#pictureImgId").val();
			var picTypeName = $("#picType").find("option:selected").text();
			
			if(pictureImgId == "") {
				layer.alert('请上传图片');
				return;
			}
			
			var params = $.param({'url':pictureImgId,'picTypeName' : picTypeName}) + '&' + $('#form').serialize();
			
			$.ajax({  
				url: baseAddress + "/picture/update",  
				type: 'post',  
				dataType: 'json',  
				data: params,   //<span style="color:#ff0000;">这里改为$('#formadd').serialize()提交数据正常，否则id="content"的值提交不过去</span>  
				success: function (data) {  
					if(data.errcode == 200) {
						$(data.elem).attr("disabled", "false").text("立即提交");
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
					layer.alert("提交出错");
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

function initInfo() {
	
	//初始化图片
	var urlValue = $("#urlValue").text();
	
	if(!(urlValue == "" || urlValue == undefined)) {
		$("#pictureImg").css("display","block");
		$("#pictureImg").attr("src", getImgSrc(urlValue));
		$("#pictureImgId").val(urlValue);
	}
	
	
	//获取select下拉框
	var typeNameValue = $("#typeNameValue").val();
	
	$.ajax({  
		url: baseAddress + "/pictureType/findAll",  
		type: 'post',  
		dataType: 'json',  
		data: "",   //<span style="color:#ff0000;">这里改为$('#formadd').serialize()提交数据正常，否则id="content"的值提交不过去</span>  
		success: function (data) {  
			if(data.errcode == 200) {
				$.each(data.data, function (index, item) {
					if(typeNameValue == item.id) {
						$("#picType").append("<option value="+item.id+" selected>"+item.name+"</option>");  
					}else {
						$("#picType").append("<option value="+item.id+">"+item.name+"</option>");  
					}
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

function reloadSelect() {
	form.render('select'); //刷新select选择框渲染
}
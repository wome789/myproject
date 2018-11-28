
$(function(){
	initValue();
});

function initValue() {
	var icoId = $("#icoValue").html();
	var logoId = $("#logoValue").html();
	
	if(!(icoId == "" || icoId == undefined)) {
		$("#icoImg").css("display","block");
		$("#icoImg").attr("src", getImgSrc(icoId));
		$("#icoImgId").val(icoId);
	}
	
	if(!(logoId == "" || logoId == undefined)) {
		$("#logoImg").css("display","block");
		$("#logoImg").attr("src",  getImgSrc(logoId));
		$("#logoImgId").val(logoId);
	}
}

layui.use(['form', 'layedit', 'laydate','upload'], function(){
	var upload = layui.upload;
	var form = layui.form;
	var layer = layui.layer;
	var layedit = layui.layedit;
	var laydate = layui.laydate;
	
	//普通图片上传
	var uploadInst = upload.render({
	  elem: '#logo,#ico,#test1'
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
		var ico = $("#icoImgId").val();
		var logo = $("#logoImgId").val();
		
		if(ico == "") {
			layer.alert('请上传图标');
			return;
		}
		
		if(logo == "") {
			layer.alert("请上传logo");
			return;
		}
		
		var params = $.param({'ico':ico,'logo':logo}) + '&' + $('#form').serialize();
		
		$.ajax({  
			url: bassAddress + "/webSet/update",  
			type: 'post',  
			dataType: 'json',  
			data: params,   //<span style="color:#ff0000;">这里改为$('#formadd').serialize()提交数据正常，否则id="content"的值提交不过去</span>  
			success: function (data) {  
				if(data.errcode == 200) {
					$("#submitBtn").attr("disabled", "false").text("立即提交");
					layer.alert('操作成功');
			  	}else {
			  		layer.alert(data.errmsg);
			  	}
			},  
			beforeSend: function () {  
			 // 一般是禁用按钮等防止用户重复提交  
			    $(data.elem).removeAttr("disabled").text("提交中...");  
			},  
			error: function (XMLHttpRequest, textStatus, errorThrown) {  
				layer.alert("提交出错");
			}  
		});  

		return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
	});
   
});
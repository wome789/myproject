/**
 * 获取项目中图片地址
 * @param imgId
 * @returns
 */
function getImgSrc(imgName) {
	return baseAddress + "/tool/downloader?fileName=" + window.encodeURIComponent(imgName);
}

/**
 * 创建富文本编辑器
 * @param divId
 * @returns
 */
function createLocalEditor(divId) {
	var E = window.wangEditor
    var editor = new E('#' + divId)
    // 或者 var editor = new E( document.getElementById('editor') )
	// 自定义菜单配置
    editor.customConfig.menus = [
        'head',  // 标题
        'bold',  // 粗体
        'fontSize',  // 字号
        'fontName',  // 字体
        'italic',  // 斜体
        'underline',  // 下划线
        'strikeThrough',  // 删除线
        'foreColor',  // 文字颜色
        'backColor',  // 背景颜色
        'list',  // 列表
        'justify',  // 对齐方式
        'quote',  // 引用
        'emoticon',  // 表情
        'image',  // 插入图片
        'table',  // 表格
        'video',  // 插入视频
        'code',  // 插入代码
        'undo',  // 撤销
        'redo'  // 重复
    ]
	
	// 配置服务器端地址
    editor.customConfig.uploadImgServer = baseAddress +'/tool/editorUpload';
	
	editor.customConfig.uploadImgHooks = {

		// 如果服务器端返回的不是 {errno:0, data: [...]} 这种格式，可使用该配置
		// （但是，服务器端返回的必须是一个 JSON 格式字符串！！！否则会报错）
		customInsert: function (insertImg, result, editor) {
		// 图片上传并返回结果，自定义插入图片的事件（而不是编辑器自动插入图片！！！）
		// insertImg 是插入图片的函数，editor 是编辑器对象，result 是服务器端返回的结果
		
		// 举例：假如上传图片成功后，服务器端返回的是 {url:'....'} 这种格式，即可这样插入图片：
		var url = result.data[0];
		insertImg(url)
		
		// result 必须是一个 JSON 格式字符串！！！否则报错
		}
	}
	
    editor.create();
	
	return editor;
}

function openUpdate(_title,_width,_height,_url,_tableId){
	if(!_width) _width=800;
	if(!_height) _height=500;
	var index =layer.open({
		type: 2,
		title: _title,
		area: [_width+'px', _height+'px'],
		shade: 0.8,
		closeBtn: 1,
		shadeClose: false,
		maxmin: true,
		anim: 2,
		content: _url
		//,btnAlign: 'c' //按钮居中
		,btn: ['保存', '关闭'] //只是为了演示
		,yes: function(index, layero){
			var body = layer.getChildFrame('body', index);
			var iframeWin = window[layero.find('iframe')[0]['name']];//得到iframe页的窗口对象，执行iframe页的方法：
			iframeWin.save();//调用子页面的方法
			search();
			//$("#search").click();
		}
		,btn2: function(){
			top.layer.close(index)
		}
	});
}
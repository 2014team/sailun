/*更新*/
const UPDATE = getAminUrl('admin/CENTER/BANNER/UPDATE');
/*保存*/
const SAVE = getAminUrl('admin/CENTER/BANNER/SAVE');


$(function(){
	//回显Select选值	
	echoSelect();
	var imageUrl = $("#imageUrl").val();
	if(imageUrl){
	 $('.layui-upload-drag').html('<img class="layui-upload-img" src="'+imageUrl+'">')
	}
	
});
var files = "";
/*初始化layui*/
layui.use([ 'form', 'layer','upload' ], function() {
	$ = layui.jquery;
	var form = layui.form,
		layer = layui.layer,
		 upload = layui.upload;
	
	 upload.render({
		    elem: '#upload_image_Id'
		    /* ,url: '/upload/' */
		     ,size: 1024 //限制文件大小，单位 KB
		    ,auto:false
		    ,choose: function(obj){
		      //预读本地文件示例，不支持ie8
		      console.log(obj)
		      obj.preview(function(index, file, result){
		      files = file
		        $('.layui-upload-drag').html('<img class="layui-upload-img" src="'+result+'">'); //图片链接（base64）
		     
		      });
		    }
		  });
	 
	 
	 
	//自定义验证规则
	form.verify({
		integer : [
			/^[1-9]\d*$/
			, '只能输入正整数'
		]
	});

	//保存
	 form.on('submit(editSave)', function(obj) {
		var formData = new FormData();
		var reqData = obj.field;
		formData.append("bannerId", reqData.bannerId);
		formData.append("jumpUrl", reqData.jumpUrl);
		formData.append("imageUrl", reqData.imageUrl);
		formData.append("status",reqData.status);
		formData.append("file", files);
		if(!files && !reqData.imageUrl){
			layer.msg("图片不能为空！", {icon : 6,time : 1500});
			return false;
		}
		
		//加载动画
   		var loading = layer.load(2, {
   		    shade: [0.2, '#fff'],
   		    content:'保存中,请稍等操作...',
   		    success: function (layerContentStyle) {
   		        layerContentStyle.find('.layui-layer-content').css({
   		            'padding-top': '35px',
   		            'text-align': 'center',
   		            'background-position': 'center top',
   		            'width': 'auto'
   		        });
   		    }
   		});
   		
		
		var url = checkSave() ? UPDATE : SAVE;
		$.ajax({
			url : url,
			type : "POST",
			data : formData,
			processData : false, // 使数据不做处理
			contentType : false, // 不要设置Content-Type请求头
			dataType : "json",
			success : function(resp) {
				//关闭动画
				layer.close(loading);
					if (resp.code == 200) { //这个是从后台取回来的状态值
						layer.msg(resp.msg, {icon : 6,time : 1500
						},function(){
						// 获得frame索引
							var index = parent.layer.getFrameIndex(window.name);
							//关闭当前frame
							parent.layer.close(index);
							//刷新列表
							window.parent.updateRowData(obj);
							
						});
						
					} else {
						layer.msg(resp.msg, {
							icon : 2,
							time : 1500
						});
					}
				},
			error : function(e) {
				console.error(e);
				layer.msg("系统异常，稍后再试!", {
					icon : 2,
					time : 1000
				});
			}
		});
		return false;
	});
});

//检查是否保存还是修改操作
function checkSave() {
	var userId = $("#bannerId").val();
	return userId;
};

//回显Select选值
function echoSelect(){
	echoSelectData("status",$("#status").attr('value'));
}
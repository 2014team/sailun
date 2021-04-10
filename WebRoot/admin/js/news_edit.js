/*更新*/
const UPDATE = getAminUrl('admin/CENTER/NEWS/UPDATE');
/*保存*/
const SAVE = getAminUrl('admin/CENTER/NEWS/SAVE');


$(function(){
	//回显Select选值	
	echoSelect();
	
	var imageUrl = $("#coverImage").val();
	if(imageUrl){
	 $('.layui-upload-drag').html('<img class="layui-upload-img" src="'+imageUrl+'">')
	}
});

var files = "";
/*初始化layui*/
layui.use([ 'form', 'layer' ,'upload','layedit'], function() {
	$ = layui.jquery;
	var form = layui.form,
		layer = layui.layer,
		 upload = layui.upload,
		 layedit = layui.layedit;
	//自定义验证规则
	form.verify({
		integer : [
			/^[1-9]\d*$/
			, '只能输入正整数'
		]
	});
	
	 layedit.set({
		  uploadImage: {
		    url: '/admin/center/upload/image' //接口url
		    ,type: 'post' //默认post
		  }
		});
	var index = layedit.build('content'/*, {
		  height: 180 //设置编辑器高度
	}*/); //建立编辑器
	
	
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
	

	//保存
	 form.on('submit(editSave)', function(obj) {
		var formData = new FormData();
		var reqData = obj.field;
		var content = layedit.getContent(index)	//获得编辑器的内容
		
		formData.append("newsId", reqData.newsId);
		formData.append("title", reqData.title);
		formData.append("coverImage", reqData.coverImage);
		formData.append("describe", reqData.describe);
		formData.append("status",reqData.status);
		formData.append("newsTypeId",reqData.newsTypeId);
		formData.append("content",content);
		formData.append("file", files);
		if(!files && !reqData.coverImage){
			layer.msg("封面图片不能为空！", {icon : 6,time : 1500});
			return false;
		}
		
		var url = checkSave() ? UPDATE : SAVE;
		$.ajax({
			url : url,
			type : "POST",
			data : formData,
			processData : false, // 使数据不做处理
			contentType : false, // 不要设置Content-Type请求头
			dataType : "json",
			success : function(resp) {
					if (resp.code == 200) { //这个是从后台取回来的状态值
						layer.msg(resp.msg, {icon : 6,time : 1500
						},function(){
						// 获得frame索引
							var index = parent.layer.getFrameIndex(window.name);
							//关闭当前frame
							parent.layer.close(index);
							//检查是否保存还是修改操作
							if (checkSave()) {
								//修改,更新行数据
								window.parent.updateRowData(obj);
							} else {
								//保存，重载列表
								window.parent.updateTableData();
							}
							
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
var userId = $("#newsId").val();
return userId;
};

//回显Select选值
function echoSelect(){
echoSelectData("newsTypeId",$("#newsTypeId").attr('value'));
}
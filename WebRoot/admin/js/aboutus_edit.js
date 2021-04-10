﻿/*更新*/
const UPDATE = getAminUrl('admin/CENTER/ABOUTUS/UPDATE');
/*保存*/
const SAVE = getAminUrl('admin/CENTER/ABOUTUS/SAVE');


$(function(){
	//回显Select选值	
	echoSelect();
	
});

/*初始化layui*/
layui.use([ 'form', 'layer','layedit' ], function() {
	$ = layui.jquery;
	var form = layui.form,
		layer = layui.layer
		layedit = layui.layedit;
	
	
	
	layedit.set({
		  uploadImage: {
		    url: '/admin/center/upload/image' //接口url
		    ,type: 'post' //默认post
		  }
		});
	var index = layedit.build('content'/*, {
		  height: 180 //设置编辑器高度
	}*/); //建立编辑器
	
	
	//自定义验证规则
	form.verify({
		integer : [
			/^[1-9]\d*$/
			, '只能输入正整数'
		]
	});

	//保存
	form.on('submit(editSave)', function(obj) {
		
		var content = layedit.getContent(index)	//获得编辑器的内容
		//参数 index： 即执行layedit.build返回的值
		//var xxx = layedit.getText(index)
		var reqData = obj.field;
		reqPostHasParameter(checkSave() ? UPDATE : SAVE, {"content":content,"status":$("#status").val(),"aboutusId":($("#aboutusId")?$("#aboutusId").val():'')}, function(result) {
			if (result.code == 200) {
				layer.msg(result.msg, {
					icon : 1,
					time : 1000
				}, function() {
					x_admin_close();

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
				layer.msg(result.msg, {
					icon : 2,
					time : 1000
				});
			}
		}, function(e) {
			console.log(e);
		})

		return false;
	});
});

//检查是否保存还是修改操作
function checkSave() {
	var userId = $("#aboutusId").val();
	return userId;
};

//回显Select选值
function echoSelect(){
	//echoSelectData("validFlag",$("#validFlag").attr('value'));
}
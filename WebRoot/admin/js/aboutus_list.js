/*列表数据*/
const LIST = getAminUrl('admin/CENTER/ABOUTUS/LIST')
/*列表删除*/
const DELETE = getAminUrl('admin/CENTER/ABOUTUS/DELETE');
/*编辑*/
const EDIT = getAminUrl('admin/CENTER/ABOUTUS/EDIT');
/*批量删除*/
const BATCH_DELETE = getAminUrl('admin/CENTER/ABOUTUS/BATCH/DELETE');
/*查找单个对象*/
const GET = getAminUrl('admin/CENTER/ABOUTUS/GET');
/*更新*/
const UPDATE = getAminUrl('admin/CENTER/ABOUTUS/UPDATE');
/*保存*/
const SAVE = getAminUrl('admin/CENTER/ABOUTUS/SAVE');

//行对象
var rowObj = "";

/*实例化编辑器 */
var ue = UE.getEditor('container', {
	initialFrameHeight:320});


/*初始化layui*/
layui.use([ 'table', 'form', 'laydate' ], function() {
	    var table  = layui.table,
		form = layui.form,
		laydate = layui.laydate;


	 
	 
	    //保存
		form.on('submit(editSave)', function(obj) {
			
			var content = ue.getContent();	//获得编辑器的内容
			//参数 index： 即执行layedit.build返回的值
			//var xxx = layedit.getText(index)
			var reqData = obj.field;
			
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
	   		
			reqPostHasParameter(checkSave() ? UPDATE : SAVE, {"content":content,"status":$("#status").val(),"aboutusId":($("#aboutusId")?$("#aboutusId").val():'')}, function(result) {
				//关闭动画
				layer.close(loading);
				
				if (result.code == 200) {
					layer.msg(result.msg, {
						icon : 1,
						time : 1000
					}, function() {

						//检查是否保存还是修改操作
//						if (checkSave()) {
//							//修改,更新行数据
//							window.parent.updateRowData(obj);
//						} else {
//							//保存，重载列表
//							window.parent.updateTableData();
//						}


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


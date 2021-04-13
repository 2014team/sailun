/*列表数据*/
const LIST = getAminUrl('admin/CENTER/CONTACT/LIST')
/*列表删除*/
const DELETE = getAminUrl('admin/CENTER/CONTACT/DELETE');
/*编辑*/
const EDIT = getAminUrl('admin/CENTER/CONTACT/EDIT');
/*详情*/
const DETAIL = getAminUrl('admin/CENTER/CONTACT/DETAIL');
/*导出*/
const EXPORT = getAminUrl('admin/CENTER/CONTACT/EXPORT');
/*批量删除*/
const BATCH_DELETE = getAminUrl('admin/CENTER/CONTACT/BATCH/DELETE');
/*查找单个对象*/
const GET = getAminUrl('admin/CENTER/CONTACT/GET');
//行对象
var rowObj = "";


/*初始化layui*/
layui.use([ 'table', 'form', 'laydate' ], function() {
	    var table  = layui.table,
		form = layui.form,
		laydate = layui.laydate;
	    
	    
	    // 下拉清空内容
	    form.on('select(brickType)', function(data){   
	    	 var val=data.value;
	    	 if(val == ""){
	    		 $("#searchValue").val("");
	    		 
	    	 }

	   });

	  //年月范围选择
	laydate.render({
		elem : '#createDateStr'
		,type: 'datetime'
		,range : '~'
	});
	

	table.render({
		elem : '#table_list',
		url : LIST,
		toolbar : '#toolbar',
		method : "post",
		page : { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
			layout : [ 'limit', 'count', 'prev', 'page', 'next', 'skip' ], //自定义分页布局 //,curr: 5 //设定初始在第 5 页
			limits: [10,20,30,50,100,1000], //每页条数选项
			limit : 10, //每页显示的条数
			groups : 5, //步长
			first : '首页', //不显示首页
			last : '尾页', //不显示尾页
			prev : '上一页',
			next : '下一页'
		},
		cols : [ [
			{
				checkbox : true
			},
			{
				field : 'indexId',
				title : '序号',
				type : 'numbers',
				width : 75,
				sort : true,
			}
			
				,{
					field : 'username' ,
					title : '姓名' ,
				}
				,{
					field : 'mobileNum' ,
					title : '电话' ,
				}
				,{
					field : 'email' ,
					title : '邮箱' ,
				}
				,{
					field : 'vehicleBrand' ,
					title : '车辆品牌' ,
				}
				,{
					field : 'type' ,
					title : '型号' ,
				}
				,{
					field : 'contents' ,
					hide:true,
					title : '内容' ,
				}
				, {
					field : 'createDate' ,
					title : '创建日期' ,
					templet : function(d) {
					return date.toDateString(d.createDate, 'yyyy-MM-dd HH:mm:ss');
				    }
				}
				, {
					field : 'updateDate' ,
					title : '更新日期' ,
					hide:true,
					templet : function(d) {
					return date.toDateString(d.updateDate, 'yyyy-MM-dd HH:mm:ss');
				    }
				}
			
			, {
				align : 'left',
				toolbar : '#operateBarTpl',
				title : '操作'
			}

		] ],done:function(){
			
			table.resize('tableId');
		}
		  
		  ,id: 'tableId'
	});
	
	//监听行工具条 
	table.on('tool(table_list)', function(obj) { //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
		rowObj = obj;
		var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
		var tr = obj.tr; //获得当前行 tr 的 DOM 对象（如果有的话）
		if (layEvent === 'edit') {
			edit(obj)//列表编辑
		} else if (layEvent === 'del') {
			del(obj);//列表删除
		}else if (layEvent === 'detail') {
			detail(obj);//详情
		}
	});
	
	
	/*搜索*/
	 form.on('submit(searchFilter)', function (data) {
			data = JSON.parse(JSON.stringify(data.field));
		      //执行重载
		      table.reload( 'tableId',{
		      	method:"post",
		        page: {
		          curr: 1 //重新从第 1 页开始
		        }
		        ,where: data
		      }, 'data');
  
    });
    
});


/*删除*/
function del(obj) {
	var contactId = obj.data.contactId;
	layer.confirm("确认要删除吗？", function(index) {
		reqPostHasParameter(DELETE, {
			"contactId" : contactId
		}, function(result) {
			if (result.code == 200) {
				layer.msg(result.msg, {
					icon : 1,
					time : 1000
				},function(){
					obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
					layer.close(index);		
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
	});
};

/*编辑*/
function edit(obj) {
	 
	var url = EDIT;
	var title = '联系我们';
	if(obj){
		var contactId = obj.data.contactId;
		url = EDIT + "?contactId=" + contactId;
		 title = '联系我们';
	}	
	x_admin_show(title, url);
};

/*导出*/
function exportContant() {
	var selectData =layui.table.checkStatus('tableId').data;
	if(selectData.length < 1){	
		layer.msg('请选择要导出的数据！', {icon: 2});
		return false;
	}
	layer.confirm('确认要导出吗？', function(index) {
		var array = new Array();
		$.each(selectData,function(i,e){
			array.push(e.contactId);
		 })
		 
		 layer.close(index);	
		 $("#contactIdArr").val(array);
		 $("#rendReloadId").attr("action",EXPORT).submit();
	});
	
};

/*详情*/
function detail(obj) {
	
	var url = DETAIL;
	var title = '联系我们';
	if(obj){
		var contactId = obj.data.contactId;
		url = DETAIL + "?contactId=" + contactId;
		title = '联系我们';
	}	
	x_admin_show(title, url);
};

/*批量删除*/
function batchDel() {
	var selectData =layui.table.checkStatus('tableId').data;
	if(selectData.length < 1){	
		layer.msg('请选择要删除的数据！', {icon: 2});
		return false;
	}
	layer.confirm('确认要删除吗？', function(index) {
		var array = new Array();
		$.each(selectData,function(i,e){
			array.push(e.contactId);
		 })
		reqPostHasParameter(BATCH_DELETE, {"contactIdArr":array},function(result) {
			if (result.code == 200) { //这个是从后台取回来的状态值
				layer.msg(result.msg, {
					icon : 1,
					time : 1000
				},function(){
					layui.table.reload('tableId');
					layer.close(index);	
				});
			}
			
		}, function(e) {
			console.log(e);
		}) 
		
	});
		
   }	


/*更新行数据*/
function updateRowData(obj){
	var reqData = obj.field;
	 reqPostHasParameter(GET, {"contactId":reqData.contactId}, function(result) {
		 reqData = result.data.userDto;
		 rowObj.update({
				 username: obj.field.username,
				 mobileNum: obj.field.mobileNum,
				 email: obj.field.email,
				 vehicleBrand: obj.field.vehicleBrand,
				 type: obj.field.type,
				 contents: obj.field.contents,
				 createDate: obj.field.createDate,
				 updateDate: obj.field.updateDate,
			});	
	 }, function(e) {
		 console.log(e);
	 })
}

/*表格重载*/
function updateTableData(){
	layui.table.reload('tableId', {
	       page: {
	         curr:1 //重新从第 1 页开始
	       }
	     }, 'data'); 
}


<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
  	<%@include file="/WEB-INF/page/admin/common/head_layui.jsp" %>
  	<link rel="stylesheet" href="/admin/css/list.css?t=<%=new java.util.Date().getTime() %>">
  	<script type="text/javascript" src="/admin/js/contact_list.js?t=<%=new java.util.Date().getTime() %>"></script>
  </head>
  
   <body>
    <div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a href="/admin/user/list/ui">联系我们管理</a>
        <a>
          <cite>列表</cite></a>
      </span>
      <a class="layui-btn layui-btn-primary layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:38px">&#xe669;</i></a>
    </div>
    <div class="x-body">
      <div class="layui-row">
        <div class="layui-form layui-col-md12 x-so">
        	<r:auth menuName="联系我们列表/查询" menuUrl="联系我们列表/查询"> 	
	         
				 	姓名：
		          <div class="layui-inline">
				    <input class="layui-input" name="username" id="username" autocomplete="off">
				  </div>
				 	电话：
		          <div class="layui-inline">
				    <input class="layui-input" name="mobileNum" id="mobileNum" autocomplete="off">
				  </div>
				 	邮箱：
		          <div class="layui-inline">
				    <input class="layui-input" name="email" id="email" autocomplete="off">
				  </div>
				 	车辆品牌：
		          <div class="layui-inline">
				    <input class="layui-input" name="vehicleBrand" id="vehicleBrand" autocomplete="off">
				  </div>
				 	型号：
		          <div class="layui-inline">
				    <input class="layui-input" name="type" id="type" autocomplete="off">
				  </div>
				 	内容：
		          <div class="layui-inline">
				    <input class="layui-input" name="contents" id="contents" autocomplete="off">
				  </div>
				
				
			
				<div class="layui-input-inline xbtpt10">
	          	  <button class="layui-btn" lay-submit lay-filter="searchFilter" >搜索</button>
	          </div>
			
          </r:auth>
        </div>
      </div>
      
       <!-- 列表 -->	
      <table class="layui-hide" id="table_list" lay-filter="table_list" ></table>
    </div>
    
    
    <script type="text/html" id="toolbar">
      <div class="layui-btn-container toolbar">
		<r:auth menuName="联系我们列表/批量删除" menuUrl="联系我们列表/批量删除">
         <button class="layui-btn layui-btn-sm layui-btn-danger" onclick="batchDel()" >批量删除</button>
    		</r:auth>
         <r:auth menuName="联系我们列表/增加" menuUrl="联系我们列表/增加">
			<button class="layui-btn layui-btn-sm"  onclick="edit()" ><i class="layui-icon"></i>增加</button>
    		</r:auth>
     </div>
	</script>
   
   
    <!-- 操作模板 -->
    <script type="text/html" id="operateBarTpl">
		<div class="td-manage">
			<r:auth menuName="联系我们列表/状态修改" menuUrl="联系我们列表/状态修改">
              <a title="编辑"  lay-event="edit" href="javascript:;">
                <i class="layui-icon" style="font-size: 20px;">&#xe642;</i>
              </a>
     		</r:auth>
			<r:auth menuName="联系我们列表/状态修改" menuUrl="联系我们列表/状态修改">
              <a title="删除"  lay-event="del" href="javascript:;">
                <i class="layui-icon" style="font-size: 20px;">&#xe640;</i>
              </a>
     		</r:auth>
		</div>
	</script>

  </body>
</html>

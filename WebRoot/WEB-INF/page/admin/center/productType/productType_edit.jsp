<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
  <head>
  	<%@include file="/WEB-INF/page/admin/common/head_layui.jsp" %>
  	<script type="text/javascript" src="/admin/js/productType_edit.js?t=<%=new java.util.Date().getTime() %>"></script>
  </head>
   <body>
    <div class="x-body">
        <div class="layui-form">
        
         <input type="hidden" id="productTypeId" name="productTypeId" value="${entity.productTypeId}" />
			
			<div class="layui-form-item">
			<label for="L_pass" class="layui-form-label"> 
			<span class="x-red">*</span>分类名称：
			</label>
			<div class="layui-input-inline">
				<input type="text" id="typeName" name="typeName"
					value="${entity.typeName}"   lay-verify="required" maxlength="50"
					autocomplete="off" class="layui-input">
			</div>
			<div class="layui-form-mid layui-word-aux">必选项</div>
		</div>
		
		<div class="layui-form-item">
				<label for="L_pass" class="layui-form-label"> 
				<span class="x-red">*</span>排序：
				</label>
				<div class="layui-input-inline">
				<input type="text"  lay-verify="required|number" name="sort"
                        autocomplete="off" class="layui-input" maxlength="100" value="${empty entity.sort?100: entity.sort}">
				</div>
				<div class="layui-form-mid layui-word-aux">必选项</div>
			</div>
		
			  
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
              </label>
               <button class="layui-btn" lay-submit lay-filter="editSave"> 保存</button>
          </div>
      </div>
    </div>
  </body>
  
</html>
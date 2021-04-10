<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
  <head>
  	<%@include file="/WEB-INF/page/admin/common/head_layui.jsp" %>
  	<script type="text/javascript" src="/admin/js/aboutus_edit.js?t=<%=new java.util.Date().getTime() %>"></script>
  </head>
   <body>
    <div class="x-body">
        <div class="layui-form">
        
          <input type="hidden" id="aboutusId" name="aboutusId" value="${entity.aboutusId}" />
         <div class="layui-form-item">
		   <textarea id="content" style="display: none;">${entity.content}</textarea>	
		   
		 </div>
		    
        <div class="layui-form-item">
			<label for="L_pass" class="layui-form-label"> 
			<span class="x-red">*</span>状态：
			</label>
			<div class="layui-input-inline">
					<select id="status" name="status" value="${entity.status}" lay-verify="required">
			                   <option value="0" >启用</option>
			                   <option value="1" >停用</option>
			             </select>
			</div>
			<div class="layui-form-mid layui-word-aux">必选项</div>
		</div>
        
			  
			  
		
			  
			  
          <div class="layui-form-item xbtpt10">
              <label for="L_repass" class="layui-form-label">
              </label>
               <button class="layui-btn" lay-submit lay-filter="editSave"> 保存</button>
          </div>
      </div>
    </div>
  </body>
  
</html>
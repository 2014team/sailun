<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
  <head>
  	<%@include file="/WEB-INF/page/admin/common/head_layui.jsp" %>
  	<script type="text/javascript" src="/admin/js/banner_edit.js?t=<%=new java.util.Date().getTime() %>"></script>
  </head>
   <body>
    <div class="x-body">
        <div class="layui-form">
        
         <input type="hidden" id="bannerId" name="bannerId" value="${entity.bannerId}" />
			
		
		<div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
                <span class="x-red">*</span> 首页广告
              </label>
              <div class="layui-input-inline">
                 <div class="layui-upload-drag" id="upload_image_Id">
				  <i class="layui-icon">
				  </i>
				  <p>点击上传，或将文件拖拽到此处</p>
				</div>
          </div>
         	 <input type="hidden" id="imageUrl" name="imageUrl" value="${entity.imageUrl }"></input>
          </div>
		
		
			<div class="layui-form-item">
			<label for="L_pass" class="layui-form-label"> 
			<span class="x-red">*</span>跳转地址：
			</label>
			<div class="layui-input-inline">
				<input type="text" id="jumpUrl" name="jumpUrl"
					value="${entity.jumpUrl}"   lay-verify="required"
					autocomplete="off" class="layui-input">
			</div>
			<div class="layui-form-mid layui-word-aux">必选项</div>
		</div>
		
			<div class="layui-form-item">
			<label for="L_pass" class="layui-form-label"> 
			<span class="x-red">*</span>状态：
			</label>
			<div class="layui-input-inline">
			
				<select id="status" name="status" lay-verify="required">
			                   <option value="0" >启用</option>
			                   <option value="1" >停用</option>
			             </select>
			    	</div>
			<div class="layui-form-mid layui-word-aux">必选项</div>
			</div>
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
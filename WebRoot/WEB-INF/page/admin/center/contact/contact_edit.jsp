<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
  <head>
  	<%@include file="/WEB-INF/page/admin/common/head_layui.jsp" %>
  	<script type="text/javascript" src="/admin/js/contact_edit.js?t=<%=new java.util.Date().getTime() %>"></script>
  </head>
   <body>
    <div class="x-body">
        <div class="layui-form">
        
         <input type="hidden" id="contactId" name="contactId" value="${entity.contactId}" />
			
			<div class="layui-form-item">
			<label for="L_pass" class="layui-form-label"> 
			<span class="x-red">*</span>姓名：
			</label>
			<div class="layui-input-inline">
				<input type="text" id="username" name="username"
					value="${entity.username}"   lay-verify="required"
					autocomplete="off" class="layui-input">
			</div>
			<div class="layui-form-mid layui-word-aux">必选项</div>
		</div>
		
			<div class="layui-form-item">
			<label for="L_pass" class="layui-form-label"> 
			<span class="x-red">*</span>电话：
			</label>
			<div class="layui-input-inline">
				<input type="text" id="mobileNum" name="mobileNum"
					value="${entity.mobileNum}"   lay-verify="required|phone"
					autocomplete="off" class="layui-input">
			</div>
			<div class="layui-form-mid layui-word-aux">必选项</div>
		</div>
		
			<div class="layui-form-item">
			<label for="L_pass" class="layui-form-label"> 
			<span class="x-red">*</span>邮箱：
			</label>
			<div class="layui-input-inline">
				<input type="text" id="email" name="email"
					value="${entity.email}"   lay-verify="required|email"
					autocomplete="off" class="layui-input">
			</div>
			<div class="layui-form-mid layui-word-aux">必选项</div>
		</div>
		
			<div class="layui-form-item">
			<label for="L_pass" class="layui-form-label"> 
			<span class="x-red">*</span>车辆品牌：
			</label>
			<div class="layui-input-inline">
				<input type="text" id="vehicleBrand" name="vehicleBrand"
					value="${entity.vehicleBrand}"   lay-verify="required"
					autocomplete="off" class="layui-input">
			</div>
			<div class="layui-form-mid layui-word-aux">必选项</div>
		</div>
		
			<div class="layui-form-item">
			<label for="L_pass" class="layui-form-label"> 
			<span class="x-red">*</span>型号：
			</label>
			<div class="layui-input-inline">
				<input type="text" id="type" name="type"
					value="${entity.type}"   lay-verify="required"
					autocomplete="off" class="layui-input">
			</div>
			<div class="layui-form-mid layui-word-aux">必选项</div>
		</div>
		
		
	    <div class="layui-form-item layui-form-text">
                  <label for="desc" class="layui-form-label">
                    <span class="x-red">*</span>内容
                  </label>
                  <div class="layui-input-block" >
                      <textarea id="contents" name="contents" class="layui-textarea">${entity.contents }</textarea>
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
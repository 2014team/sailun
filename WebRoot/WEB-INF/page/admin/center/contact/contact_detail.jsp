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
			姓名：
			</label>
			<div class="layui-input-inline">
				<input type="text" id="username" name="username"
					value="${entity.username}"   lay-verify="required"
					autocomplete="off" class="layui-input">
			</div>
			<div class="layui-form-mid layui-word-aux"></div>
		</div>
		
			<div class="layui-form-item">
			<label for="L_pass" class="layui-form-label"> 
			电话：
			</label>
			<div class="layui-input-inline">
				<input type="text" id="mobileNum" name="mobileNum"
					value="${entity.mobileNum}"   lay-verify="required"
					autocomplete="off" class="layui-input">
			</div>
			<div class="layui-form-mid layui-word-aux"></div>
		</div>
		
			<div class="layui-form-item">
			<label for="L_pass" class="layui-form-label"> 
			邮箱：
			</label>
			<div class="layui-input-inline">
				<input type="text" id="email" name="email"
					value="${entity.email}"   lay-verify="required"
					autocomplete="off" class="layui-input">
			</div>
			<div class="layui-form-mid layui-word-aux"></div>
		</div>
		
			<div class="layui-form-item">
			<label for="L_pass" class="layui-form-label"> 
			车辆品牌：
			</label>
			<div class="layui-input-inline">
				<input type="text" id="vehicleBrand" name="vehicleBrand"
					value="${entity.vehicleBrand}"   lay-verify="required"
					autocomplete="off" class="layui-input">
			</div>
			<div class="layui-form-mid layui-word-aux"></div>
		</div>
		
			<div class="layui-form-item">
			<label for="L_pass" class="layui-form-label"> 
			型号：
			</label>
			<div class="layui-input-inline">
				<input type="text" id="type" name="type"
					value="${entity.type}"   lay-verify="required"
					autocomplete="off" class="layui-input">
			</div>
			<div class="layui-form-mid layui-word-aux"></div>
		</div>
		
			<div class="layui-form-item">
			<label for="L_pass" class="layui-form-label"> 
			创建日期：
			</label>
			<div class="layui-input-inline">
				<input type="text" id="type" name="type"
					value="<fmt:formatDate value='${entity.createDate}' pattern='yyyy-MM-dd HH:mm:ss' />"   lay-verify="required"
					autocomplete="off" class="layui-input">
			</div>
			<div class="layui-form-mid layui-word-aux"></div>
		</div>
		
			
		    <div class="layui-form-item layui-form-text">
                   <label for="desc" class="layui-form-label">
                     内容
                   </label>
                   <div class="layui-input-block" >
                       <textarea readonly="readonly" class="layui-textarea" >${entity.contents }</textarea>
                   </div>
               </div>
                
      </div>
    </div>
  </body>
  
</html>
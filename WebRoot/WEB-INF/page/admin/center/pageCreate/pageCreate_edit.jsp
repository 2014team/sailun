<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
  <head>
  	<%@include file="/WEB-INF/page/admin/common/head_layui.jsp" %>
  	<script type="text/javascript" src="/admin/js/pageCreate_edit.js?t=<%=new java.util.Date().getTime() %>"></script>
  	<%@ taglib uri="/WEB-INF/tag/pageConfig.tld" prefix="pc" %> 
  </head>
   <body>
    <div class="x-body">
        <div class="layui-form">
        
         <input type="hidden" id="pageCreateId" name="pageCreateId" value="${entity.pageCreateId}" />
			
			<div class="layui-form-item">
			<label for="L_pass" class="layui-form-label"> 
			<span class="x-red">*</span>模本名称：
			</label>
			<div class="layui-input-inline">
				<input type="text" id="templateName" name="templateName"
					value="${entity.templateName}"   lay-verify="required"
					autocomplete="off" class="layui-input">
			</div>
			<div class="layui-form-mid layui-word-aux">必选项</div>
		</div>
		
			<div class="layui-form-item">
                    <label for="name" class="layui-form-label">
              <span class="x-red">*</span>模本路径：
                    </label>
                    <div class="layui-input-block">
                        <input type="text"  lay-verify="required" name="templatePath"
                        autocomplete="off" class="layui-input" maxlength="100" value="${entity.templatePath}">
                    	<div class="layui-form-mid layui-word-aux">必选项</div>
                    </div>
                </div>
		
		
			 <div class="layui-form-item">
                    <label for="name" class="layui-form-label">
              <span class="x-red">*</span>生成文件路径：
                    </label>
                    <div class="layui-input-block">
                        <input type="text"  lay-verify="required" name="generatorFile"
                        autocomplete="off" class="layui-input" maxlength="100" value="${entity.generatorFile}">
                    	<div class="layui-form-mid layui-word-aux">必选项</div>
                    </div>
                </div>
		
			<div class="layui-form-item">
			<label for="L_pass" class="layui-form-label"> 
			<span class="x-red">*</span>排序：
			</label>
			<div class="layui-input-inline">
				<input type="text" id="sort" name="sort"
					value="${entity.sort}"   lay-verify="required"
					autocomplete="off" class="layui-input">
			</div>
			<div class="layui-form-mid layui-word-aux">必选项</div>
		</div>
		
		<div class="layui-form-item">
				<label for="L_pass" class="layui-form-label"> 
				<span class="x-red">*</span>页面配置：
				</label>
				<div class="layui-input-inline">
						<select id="pageConfigId" name="pageConfigId" value="${entity.pageConfigId}" lay-verify="required" >
			          	<c:forEach items="${pc:getList()}" var="item">
			          		<option value="${item.code }" >${item.configPageName }</option>
			          	</c:forEach>
				        </select>
				</div>
				<div class="layui-form-mid layui-word-aux">必选项</div>
			</div>
			
			
		
		<div class="layui-form-item layui-form-text">
                  <label for="desc" class="layui-form-label">
                    <span class="x-red">*</span>模板内容：
                  </label>
                  <div class="layui-input-block" >
                      <textarea id="templateContent" name="templateContent" class="layui-textarea"  maxlength="1500">${entity.templateContent }</textarea>
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
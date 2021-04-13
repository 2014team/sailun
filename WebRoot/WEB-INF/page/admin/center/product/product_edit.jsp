<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
  <head>
  	<%@include file="/WEB-INF/page/admin/common/head_layui.jsp" %>
  	<script type="text/javascript" src="/js/UEditor/ueditor.config.js?t=<%=new java.util.Date().getTime() %>"></script>
  	<script type="text/javascript" src="/js/UEditor/ueditor.all.js?t=<%=new java.util.Date().getTime() %>"></script>
  	 <script type="text/javascript" charset="utf-8" src="/js/UEditor/lang/zh-cn/zh-cn.js"></script>
  	<script type="text/javascript" src="/admin/js/product_edit.js?t=<%=new java.util.Date().getTime() %>"></script>
  </head>
   <body>
    <div class="x-body">
        <div class="layui-form">
        
         <input type="hidden" id="productId" name="productId" value="${entity.productId}" />
			
		
		 <div class="layui-form-item">
                    <label for="name" class="layui-form-label">
              <span class="x-red">*</span>标题：：
                    </label>
                    <div class="layui-input-block">
                        <input type="text"  lay-verify="required" name="title"
                        autocomplete="off" class="layui-input" maxlength="100" value="${entity.title}">
                    </div>
                </div>
		
		
		
		<div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
                <span class="x-red">*</span> 封面图片：
              </label>
              <div class="layui-input-inline">
                 <div class="layui-upload-drag" id="upload_image_Id">
				  <i class="layui-icon">
				  </i>
				  <p>点击上传，或将文件拖拽到此处</p>
				  
				</div>
				<div class="layui-form-mid layui-word-aux upload-tips">必选项</div>
          </div>
         	 <input type="hidden" id="coverImage" name="coverImage" value="${entity.coverImage }"></input>
          </div>
		
		<div class="layui-form-item">
				<label for="L_pass" class="layui-form-label"> 
				<span class="x-red">*</span>状态：
				</label>
				<div class="layui-input-inline">
						<select id="status" name="status" value="${entity.status}" lay-verify="required">
				                   <option value="0" >上架</option>
				                   <option value="1" >下架</option>
				             </select>
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
				<label for="L_pass" class="layui-form-label"> 
				<span class="x-red">*</span>产品类别：
				</label>
				<div class="layui-input-inline">
						<select id="productTypeId" name="productTypeId" value="${entity.productTypeId }" lay-verify="required">
								<c:forEach items="${productTypeList }" var="item">
									<option value="${item.productTypeId }" >${item.typeName }</option>
								</c:forEach>
			             </select>
				</div>
				<div class="layui-form-mid layui-word-aux">必选项</div>
			</div>
		
		
	    <div class="layui-form-item layui-form-text">
                  <label for="desc" class="layui-form-label">
                    <span class="x-red">*</span>简介描述：
                  </label>
                  <div class="layui-input-block" >
                      <textarea id="describe" name="describe" class="layui-textarea" >${entity.describe }</textarea>
                  </div>
              </div>
		
			
		
		
		 <div class="layui-form-item layui-form-text">
                  <label for="desc" class="layui-form-label">
                    	内容介绍：
                  </label>
                  <div class="layui-input-block" >
                      <script id="container" name="content" type="text/plain">${entity.content}</script>
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
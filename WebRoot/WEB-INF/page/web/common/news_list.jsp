<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- jstl -->
<%@include file="/WEB-INF/page/web/common/com.jsp"%>

<c:forEach items="${result.data}" var="item">
	<div class="flex-item banner-anime">
	<a href="/news/detail" target="_blank">
		<div class="image">
			<img src="${item.coverImage }" alt="${item.coverImage }">
		</div>
		<div class="text">
			<h4>${item.title }</h4>
			<p>${item.describe }</p>
		</div>
	</a>
</div>
	
</c:forEach>	

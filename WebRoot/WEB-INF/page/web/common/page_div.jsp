<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- jstl -->

	<input type="hidden" value="${result.page}" name="page" id="page">
	
	<c:if test="${result.totalPages gt 1}">
		<div id="pager" class="pager clearfix">
		<c:choose>
			<c:when test="${result.page eq 1}">
				<a class="pg-first""></a>
			</c:when>
			<c:otherwise>
				<a class="pg-first" onclick="searchByPage(1)"></a>
			</c:otherwise>
		</c:choose>
			
			
			<c:choose>
			<c:when test="${result.page eq 1}">
				<a class="pg-prev"></a>
			</c:when>
			<c:otherwise>
				<a class="pg-prev"  onclick="searchByPage(${result.page -1 gt 1 ? result.page -1 : 1})"></a>
			</c:otherwise>
		</c:choose>
			
			
			<c:forEach var="i" begin="${result.stepBeginIndex }" end="${result.stepEndIndex }" step="1">
					<c:choose>
						<c:when test="${result.page eq i}">
							<span class="current" onclick="searchByPage(${i})">${i}</span>
						</c:when>
						<c:otherwise>
							<a onclick="searchByPage(${i})">${i}</a>
						</c:otherwise>
					</c:choose>	
		</c:forEach>
		<%--  <c:if test="${result.totalPages - result.page ge result.step/2 }">
			<span class="els">...</span>
		</c:if>  --%>
		
		<c:choose>
			<c:when test="${result.page eq result.totalPages}">
				<a class="pg-next"></a>
			</c:when>
			<c:otherwise>
				<a class="pg-next" onclick="searchByPage(${result.page+1 gt result.totalPages ? result.totalPages : result.page+1 })"></a>
			</c:otherwise>
		</c:choose>
		
		<c:choose>
			<c:when test="${result.page eq result.totalPages}">
				<a class="pg-last"></a>
			</c:when>
			<c:otherwise>
				<a class="pg-last" onclick="searchByPage(${result.totalPages})"></a>
			</c:otherwise>
		</c:choose>
		
	</div>
</c:if>
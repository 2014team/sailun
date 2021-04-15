<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- jstl -->
<%@include file="/WEB-INF/page/web/common/com.jsp"%>

<c:if test="${result.totalPages gt 1}">
		<div id="pager" class="pager clearfix">
			<a class="pg-first" onclick="searchByPage(1)"></a>
			<a class="pg-prev"  ${result.page eq 1 ? 'disabled':''} onclick="searchByPage(${result.page}-1)"></a>
			
			<c:forEach var="i" begin="1" end="7" step="1">
					<c:choose>
						<c:when test="${result.page eq i}">
							<span class="current" onclick="searchByPage(${i})">${i}</span>
						</c:when>
						<c:otherwise>
							<a onclick="searchByPage(${i})">${i}</a>
						</c:otherwise>
					</c:choose>	
		</c:forEach>
		<c:if test="${result.totalPages gt 6 }">
			<span class="els">...</span>
		</c:if>
		<a class="pg-next" ${result.page gt result.totalPages  ? 'disabled':''  } onclick="searchByPage(${result.page+1})"></a>
		<a class="pg-last" onclick="searchByPage(${result.totalPages})"></a>
	</div>
</c:if>
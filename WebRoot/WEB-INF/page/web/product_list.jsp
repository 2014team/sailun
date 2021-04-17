<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- jstl -->
<%@include file="/WEB-INF/page/web/common/com.jsp"%>

<div id="fh5co-work-section">
				<section id="onlinestore">
					<div class="sec-inner inner-width inner-mid-width">
						<div class="h2Title-block">
							<h2 class="h2Title headline-anime">
								<span class="text-en">NEWS</span>
								<span class="text-ja">${empty productType.typeName?'产品中心' :productType.typeName }</span>
							</h2>
						</div>
						<div class="onlinestore flex-box" id="list_div">
							
						
						<c:forEach items="${result.data}" var="item">
								<div class="flex-item banner-anime">
								<a href="/news/detail/${item.productId}" target="_blank">
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
							
						</div>
					</div>
				</section>
			</div>

			<div style="text-align: center;" is="page_div">
				<!-- 分页div -->
				<%@include file="/WEB-INF/page/web/common/page_div.jsp" %>
			</div>


	

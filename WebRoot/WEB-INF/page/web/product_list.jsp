<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- jstl -->
<%@include file="/WEB-INF/page/web/common/com.jsp"%>

<section id="times">
					<div class="sec-inner inner-width inner-mid-width">
						<div class="h2Title-block">
							<h2 class="h2Title headline-anime">
								<span class="text-en">PRODUCTS</span>
								<span class="text-ja">${empty productType.typeName?'产品中心' :productType.typeName }</span>
							</h2>
						</div>
						<div class="times3-box flex-box"  id="list_div" var>
							<c:forEach items="${result.data}" var="item">
								<div class="flex-item banner-anime">
									<a href="product/detail/${item.productId}">
										<div class="image-wrap">
											<div class="image-times" style="background-image:url('${item.coverImage }');"></div>
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
		

			<div style="text-align: center;background: #f5f5f5;" is="page_div">
				<!-- 分页div -->
				<%@include file="/WEB-INF/page/web/common/page_div.jsp" %>
			</div>


	

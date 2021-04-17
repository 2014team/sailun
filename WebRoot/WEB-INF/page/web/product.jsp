<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
	<%@include file="/WEB-INF/page/web/common/meta.jsp" %>
	<%@include file="/WEB-INF/page/web/common/css.jsp" %>
	<%@include file="/WEB-INF/page/web/common/com.jsp"%>
	<script type="text/javascript" src="/web/sailun/js/page.js"></script>

	<!-- Modernizr JS -->
	<script src="/web/js/modernizr-2.6.2.min.js"></script>
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	<script src="/web/js/respond.min.js"></script>
	<![endif]-->

</head>

<body>
	<div id="fh5co-wrapper">
		<div id="fh5co-page">

			<!-- nav -->
			<%@include file="/WEB-INF/page/web/common/nav.jsp" %>


			<!-- end:fh5co-header -->
			<aside id="fh5co-hero" class="js-fullheight">
				<div class="flexslider js-fullheight">
					<ul class="slides">
						<li style="background-image: url(/web/images/slide_5c4ca.jpg);">
							<div class="overlay-gradient"></div>
							<div class="container">
								<div class="col-md-10 col-md-offset-1 text-center js-fullheight slider-text">
									<div class="slider-text-inner desc">
										<div align="center"><img src="/web/images/perger.png"></div>

									</div>
								</div>
							</div>
							<div class="search-area">
								<div class="container">
									<input type="text" placeholder="输入要搜索的产品" id="searchValue" name="searchValue">
									<button id="search_id">搜索产品</button>
								</div>
							</div>
						</li>
					</ul>
				</div>
			</aside>
			
			<div id="list_div">
				<!-- 分页数据列表 -->
				<%@include file="/WEB-INF/page/web/product_list.jsp" %>
			</div>
			
			<!-- foot -->	
			<%@include file="/WEB-INF/page/web/common/foot.jsp" %>

		</div>

	</div>
	<!-- js -->
		<%@include file="/WEB-INF/page/web/common/js.jsp" %>
		<script type="text/javascript" src="/web/sailun/js/product.js"></script>
</body>

</html>
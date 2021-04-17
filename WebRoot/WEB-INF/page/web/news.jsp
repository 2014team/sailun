<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
	<%@include file="/WEB-INF/page/web/common/meta.jsp" %>
	<%@include file="/WEB-INF/page/web/common/css.jsp" %>
	
	<%@include file="/WEB-INF/page/web/common/com.jsp"%>
	<script type="text/javascript" src="/web/sailun/js/page.js"></script>

</head>

<body>
	<div id="fh5co-wrapper">
		<div id="fh5co-page">

			 <!-- nav -->
			<%@include file="/WEB-INF/page/web/common/nav.jsp" %>
			<!-- end:fh5co-header -->


			<!-- end:fh5co-header -->
			<aside id="fh5co-hero" class="js-fullheight">
				<div class="flexslider js-fullheight">
					<ul class="slides">
						<li style="background-image: url(/web/images/slide_8.jpg);">
							<div class="overlay-gradient"></div>
							<div class="container">
								<div class="col-md-10 col-md-offset-1 text-center js-fullheight slider-text">
									<div class="slider-text-inner desc">
										<div align="center"><img src="/web/images/cpr.png"></div>
									</div>
								</div>
							</div>
							<div class="search-area">
								<div class="container">
									<input type="text" placeholder="输入要搜索的新闻" id="searchValue" name="searchValue">
									<button id="search_id">搜索新闻</button>
								</div>
							</div>
						</li>
					</ul>
				</div>
			</aside>
			

			<div id="list_div">
				<!-- 分页数据列表 -->
				<%@include file="/WEB-INF/page/web/news_list.jsp" %>
			</div>
			
			<!-- foot -->	
			<%@include file="/WEB-INF/page/web/common/foot.jsp" %>


		</div>
		<!-- END fh5co-page -->

	</div>
	<!-- END fh5co-wrapper -->

		<!-- js -->
		<%@include file="/WEB-INF/page/web/common/js.jsp" %>
		<script type="text/javascript" src="/web/sailun/js/news.js"></script>
		
		<dc
</body>

<!-- Mirrored from valino.jp/company.php by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 04 Apr 2021 06:45:11 GMT -->

</html>
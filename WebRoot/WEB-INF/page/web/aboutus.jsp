<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<head>
	<%@include file="/WEB-INF/page/web/common/meta.jsp" %>
	<%@include file="/WEB-INF/page/web/common/css.jsp" %>

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
						</li>
					</ul>
				</div>
			</aside>
			<div id="fh5co-work-section">
				<div class="container">
					${entity.content }
				</div>
			</div>
			
			<!-- foot -->	
			<%@include file="/WEB-INF/page/web/common/foot.jsp" %>


		</div>
		<!-- END fh5co-page -->

	</div>
	<!-- js -->
	<%@include file="/WEB-INF/page/web/common/js.jsp" %>
</body>

<!-- Mirrored from valino.jp/company.php by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 04 Apr 2021 06:45:11 GMT -->

</html>
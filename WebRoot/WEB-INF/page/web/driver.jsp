<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<%@include file="/WEB-INF/page/web/common/meta.jsp" %>
	<%@include file="/WEB-INF/page/web/common/css.jsp" %>

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
				<section id="LINK">
					<div class="sec-inner inner-width inner-mid-width">
						<div class="h2Title-block">
							<h2 class="h2Title headline-anime">
								<span class="text-en">DRIVER INTRODUCTION</span>
								<span class="text-ja">车手介绍</span>
							</h2>
							<div class="link flex-box">
							
								<%@include file="/WEB-INF/page/web/common/driver.jsp" %>
								
								
							</div>
						</div>
					</div>
				</section>
			</div>


			<!-- foot -->	
			<%@include file="/WEB-INF/page/web/common/foot.jsp" %>


		</div>
		<!-- END fh5co-page -->

	</div>
	<!-- END fh5co-wrapper -->

	<!-- jQuery -->

		<!-- js -->
		<%@include file="/WEB-INF/page/web/common/js.jsp" %>
</body>

</html>
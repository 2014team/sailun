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
								<div class="flex-item banner-anime">
									<a href="/detail/detail" target="_blank">
										<div class="image">
											<img src="/web/img/banner_02.jpg" alt="VALINO BASE">
										</div>
										<div class="text">
											<p>
												VALINO BASE
												<br>Official Website
											</p>
										</div>
									</a>
								</div>
								<div class="flex-item banner-anime">
									<a href="ddetail.html" target="_blank">
										<div class="image">
											<img src="/web/img/banner_03.jpg" alt="VALINO INTERNATIONAL">
										</div>
										<div class="text">
											<p>
												VALINO
												<br>INTERNATIONAL
											</p>
										</div>
									</a>
								</div>
								<div class="flex-item banner-anime">
									<a href="ddetail.html" target="_blank">
										<div class="image">
											<img src="/web/img/banner_05.jpg" alt="DIGICAM">
										</div>
										<div class="text">
											<p>
												DIGICAM
											</p>
										</div>
									</a>
								</div>
								<div class="flex-item banner-anime">
									<a href="ddetail.html" target="_blank">
										<div class="image">
											<img src="/web/img/banner_06.jpg" alt="Advanti Racing">
										</div>
										<div class="text">
											<p>
												Advanti Racing
											</p>
										</div>
									</a>
								</div>
							</div>
						</div>
					</div>
				</section>
			</div>

			<!-- 底部 -->
			<div id="footer">
				<div class="container">
					<div class="row copy-right">
						<div class="col-md-6 col-md-offset-3 text-center">
							<!-- <p class="fh5co-social-icons">
								<a href="https://twitter.com/VALINOTIRES/"><i class="icon-twitter2"></i></a>
								<a href="https://www.facebook.com/Valino-Tires-International-651901148493959/"><i
										class="icon-facebook2"></i></a>
								<a href="https://www.instagram.com/valino_photos/"><i class="icon-instagram"></i></a>
								<a href="https://www.youtube.com/channel/UCMtrayWAm38NYTD2m_I5svQ"><i
										class="icon-youtube"></i></a>
							</p> -->
							<p class="flogoimg"><a href="index.html"><img src="/web/images/logo_2.jpg"></a></p>
							<p class="flogo">COPYRIGHT (C) VALINO TIRES CO., LTD. ALL RIGHTS RESERVED.</p>
							<p class="flogo"><a href="company.html"> - COMPANY PROFILE -</a></p>
							<p class="flogo"><a href="https://valino.tires/logos/"> - BRANDLOGO RESOURCES SITE -</a></p>
						</div>
					</div>
				</div>
			</div>


		</div>
		<!-- END fh5co-page -->

	</div>
	<!-- END fh5co-wrapper -->

	<!-- jQuery -->

		<!-- js -->
		<%@include file="/WEB-INF/page/web/common/js.jsp" %>
</body>

</html>
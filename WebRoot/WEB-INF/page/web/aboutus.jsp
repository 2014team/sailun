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
			
			<!-- フッター部インクルード ここから -->
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
	<!-- js -->
	<%@include file="/WEB-INF/page/web/common/js.jsp" %>
</body>

<!-- Mirrored from valino.jp/company.php by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 04 Apr 2021 06:45:11 GMT -->

</html>
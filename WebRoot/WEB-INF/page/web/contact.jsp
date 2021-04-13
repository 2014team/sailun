<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>VALINO TIRES Official Website / COMPANY PROFILE</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="VALINO TIRES Official Website" />
	<meta name="keywords"
		content="VALINO, ヴァリノ, VARINO TIRES, ヴァリノタイヤ, スポーツ走行, sports tires, ドリフトタイヤ, drift tires, pergea, ペルギア, greeva, グリーヴァ, ebisu matsuri, エビス祭," />

	<meta name="author" content="VALINO TIRES" />

	<!-- Facebook and Twitter integration -->
	<meta property="og:title" content="" />
	<meta property="og:image" content="" />
	<meta property="og:url" content="" />
	<meta property="og:site_name" content="" />
	<meta property="og:description" content="" />
	<meta name="twitter:title" content="" />
	<meta name="twitter:image" content="" />
	<meta name="twitter:url" content="" />
	<meta name="twitter:card" content="" />

	<link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700,900' rel='stylesheet' type='text/css'>
	<link href="https://fonts.googleapis.com/css?family=Roboto+Slab:300,400,700" rel="stylesheet">
	
	<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
	<!-- Animate.css -->
	<link rel="stylesheet" href="/web/css2/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="/web/css2/icomoon.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="/web/css2/bootstrap.css">
	<!-- Superfish -->
	<link rel="stylesheet" href="/web/css2/superfish.css">
	<!-- Flexslider  -->
	<link rel="stylesheet" href="/web/css2/flexslider.css">
	<link rel="stylesheet" href="/web/css/common_style.css">
	<link rel="stylesheet" href="/web/css2/style.css">
	<link rel="stylesheet" type="text/css" href="/web/css/mailform.css" />
	
	<%@include file="/WEB-INF/page/web/common/head.jsp" %>
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
										<div align="center"><img src="/web/images/cur.png"></div>

									</div>
								</div>
							</div>
						</li>
					</ul>
				</div>
			</aside>
			<div id="fh5co-work-section">
				<div class="container">

					<form action="https://valino.jp/contact/php/mailform.php" method="post" id="mail_form">
						<dl>
							<dt>姓名<span>Your Name</span></dt>
							<dd class="required"><input type="text" id="name_1" name="name_1" value="" />
							</dd>

							<dt>电话<span>Phone Number</span></dt>
							<dd><input type="text" id="read_1" name="read_1" value="" /> </dd>

							<dt>车辆品牌<span>Vehicle Brand</span></dt>
							<dd class="required"><input type="text" id="mail_address" name="mail_address" value="" />
							</dd>

							<dt>邮箱<span>Mail Address Confirm</span></dt>
							<dd class="required"><input type="text" id="mail_address_confirm" name="mail_address_confirm" value="" /></dd>


							<dt>型号<span>Postal</span></dt>
							<dd><input type="text" id="postal" name="postal" value=""
									onkeyup="AjaxZip3.zip2addr(this,'','address_1','address_1');" /></dd>


							<dt>内容<span>Contents</span></dt>
							<dd class="required"><textarea id="mail_contents" name="mail_contents" cols="40"
									rows="5"></textarea></dd>

							<dt></dt>
							<dd><input type="submit" id="mail_submit_button" name="mail_submit_button" value="提交信息" />
							</dd>
						</dl>
					</form>

				</div>
			</div>


			<!--底部 -->
			<footer>
				<div id="footer">
					<div class="container">
						<div class="row copy-right">
							<div class="col-md-6 col-md-offset-3 text-center">
								<!-- <p class="fh5co-social-icons">
									<a href="https://twitter.com/VALINOTIRES/"><i class="icon-twitter2"></i></a>
									<a href="https://www.facebook.com/Valino-Tires-International-651901148493959/"><i
											class="icon-facebook2"></i></a>
									<a href="https://www.instagram.com/valino_photos/"><i
											class="icon-instagram"></i></a>
									<a href="https://www.youtube.com/channel/UCMtrayWAm38NYTD2m_I5svQ"><i
											class="icon-youtube"></i></a>
								</p> -->
								<p class="flogoimg"><a href="./index.html"><img src="/web/images/logo_2.jpg"></a></p>
								<p class="flogo">COPYRIGHT (C) VALINO TIRES CO., LTD. ALL RIGHTS RESERVED.</p>
								<p class="flogo"><a href="./company.html"> - COMPANY PROFILE -</a></p>
								<p class="flogo"><a href="https://valino.tires/logos/"> - BRANDLOGO RESOURCES SITE -</a>
								</p>
							</div>
						</div>
					</div>
				</div>
			</footer>
			<!--底部结束 -->


		</div>
		<!-- END fh5co-page -->

	</div>
	<!-- END fh5co-wrapper -->
	
	
	<script src="/web/js/jquery.min.js"></script>
	<script type="text/javascript" src="/web/js/mailform.js"></script>
	<!-- Waypoints -->
	<script src="/web/js/jquery.waypoints.min.js"></script>
	<!-- Superfish -->
	<script src="/web/js/superfish.js"></script>
	<!-- Flexslider -->
	<script src="/web/js/jquery.flexslider-min.js"></script>

	<!-- Main JS (Do not remove) -->
	<script src="/web/js/main.js"></script>

</body>


</html>
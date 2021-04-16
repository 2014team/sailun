<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<head>
	<%@include file="/WEB-INF/page/web/common/meta.jsp" %>
	<%@include file="/WEB-INF/page/web/common/css.jsp" %>
	<link rel="stylesheet" type="text/css" href="/web/css/mailform.css" />

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

					<form method="post" id="mail_form">
						<dl>
							<dt>姓名<span>Your Name</span></dt>
							<dd class="required"><input type="text" id="name_1" name="username" value="" />
							</dd>

							<dt>电话<span>Phone Number</span></dt>
							<dd class="required"><input type="text" id="phone" name="mobileNum" value="" /> </dd>

							<dt>车辆品牌<span>Vehicle Brand</span></dt>
							<dd class="required"><input type="text" id="vehicle_brand" name="vehicleBrand" value="" />
							</dd>

							<dt>邮箱<span>Mail Address Confirm</span></dt>
							<dd class="required"><input type="text" id="mail_address" name="email" value="" /></dd>


							<dt>型号<span>Model</span></dt>
							<dd class="required"><input type="text" id="model" name="type" value=""/></dd>


							<dt>内容<span>Contents</span></dt>
							<dd class="required"><textarea id="content" name="contents" cols="40" rows="5"></textarea></dd>

							<dt></dt>
							<dd><input type="button" id="mail_submit_button" name="mail_submit_button" value="提交信息" />
							</dd>
						</dl>
					</form>

				</div>
			</div>


			<!-- foot -->	
			<%@include file="/WEB-INF/page/web/common/foot.jsp" %>
			
			

		</div>
		<!-- END fh5co-page -->

	</div>
		<!-- js -->
		<%@include file="/WEB-INF/page/web/common/js.jsp" %>
		<script type="text/javascript" src="/web/js/mailform.js"></script>
	
</body>

<style>

<!-- Mirrored from valino.jp/company.php by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 04 Apr 2021 06:45:11 GMT -->

</html>
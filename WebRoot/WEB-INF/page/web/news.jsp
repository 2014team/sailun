<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
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
							<div class="search-area">
								<div class="container">
									<input type="text" placeholder="输入要搜索的新闻">
									<button>搜索新闻</button>
								</div>
							</div>
						</li>
					</ul>
				</div>
			</aside>
			<div id="fh5co-work-section">
				<section id="onlinestore">
					<div class="sec-inner inner-width inner-mid-width">
						<div class="h2Title-block">
							<h2 class="h2Title headline-anime">
								<span class="text-en">NEWS</span>
								<span class="text-ja">新闻中心</span>
							</h2>
						</div>
						<div class="onlinestore flex-box">
							<div class="flex-item banner-anime">
								<a href="/news/detail" target="_blank">
									<div class="image">
										<img src="/web/img/valino_TOKYO.jpg" alt="VALINO TIRES">
									</div>
									<div class="text">
										<h4>Honda中国2021年3月汽车销量同比暴涨150.2%</h4>
										<p>Honda发布2021年3月在中国的终端汽车销量。2021年3月Honda在中国的终端汽车销量为151218辆，同比暴涨150.2%。其中广汽本田3月终端销量为76203辆，东风本田3月终端销量为75015辆。</p>
									</div>
								</a>
							</div>
							<div class="flex-item banner-anime">
								<a href="ndetail.html" target="_blank">
									<div class="image">
										<img src="/web/img/banner_01.jpg" alt="">
									</div>
									<div class="text">
										<h4>隔热板缺陷 逾19万辆国产奥迪A6L召回</h4>
										<p>日前，一汽-大众汽车有限公司根据《缺陷汽车产品召回管理条例》和《缺陷汽车产品召回管理条例实施办法》的要求，向国家市场监督管理总局备案了召回计划。决定自2021年4月16日起召回部分国产A6L，共191981辆。</p>
									</div>
								</a>
							</div>
							<div class="flex-item banner-anime">
								<a href="ndetail.html" target="_blank">
									<div class="image">
										<img src="/web/img/banner_04.jpg" alt="">
									</div>
									<div class="text">
										<h4>上汽荣威3月汽车销量发布 同比大涨65%</h4>
										<p>上汽荣威3月热销超3.3万辆，同比上涨65%，创历年新高!热门车型荣威i5销量继续破万，助力荣威i系列热销1.7万辆、同比增长89%;荣威RX5系列热销近万辆，同比增长11%，成为当之无愧的SUV销量王;荣威iMAX8继续发力，环比大涨148%，稳居自主品牌高端MPV前列;上汽科莱威CLEVER热销3668辆，推动新能源整体销量突破万辆大关，环比劲增141%，持续领跑自主品牌新能源市场。</p>
									</div>
								</a>
							</div>
						</div>
					</div>
				</section>
			</div>
			<div style="text-align: center;">
				<div id="pager" class="pager clearfix">
					<a class="pg-first" page-id="1"></a>
					<a class="pg-prev" page-id="0" disabled="true"></a>
					<span class="current" page-id="1">1</span>
					<a page-id="2">2</a>
					<a page-id="3">3</a>
					<a page-id="4">4</a>
					<a page-id="5">5</a>
					<a page-id="6">6</a>
					<a page-id="7">7</a>
					<span class="els">...</span>
					<a class="pg-next" page-id="2"></a>
					<a class="pg-last" page-id="10"></a>
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
	<!-- END fh5co-wrapper -->

		<!-- js -->
		<%@include file="/WEB-INF/page/web/common/js.jsp" %>
</body>

<!-- Mirrored from valino.jp/company.php by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 04 Apr 2021 06:45:11 GMT -->

</html>
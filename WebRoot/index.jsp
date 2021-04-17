<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
    <%@include file="/WEB-INF/page/web/common/meta.jsp" %>
	<%@include file="/WEB-INF/page/web/common/com.jsp"%>
   	<%@include file="/WEB-INF/page/web/common/css.jsp" %>
    <link rel="stylesheet" href="/web/css/swiper.css"><!-- Swiper -->
    <!-- 基本 -->
    <style>
        #fh5co-header-section {
            position: relative;
        }

        .firstview-image {
            background-image: url(/web/img/first_pc_2.jpg);
        }

        .firstview-image {
            width: 100%;
            padding-top: calc((100% / 1920) * 1080);
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            position: relative;
            z-index: 10;
        }
    </style>
</head>

<body data-menuflag="off">
    <div id="fh5co-wrapper">
        <div id="fh5co-page">
            
            <!-- nav -->
			<%@include file="/WEB-INF/page/web/common/nav.jsp" %>
            
            <section id="firstview">
                <div class="sec-inner">
                    <div class="swiper-container">
                        <div class="swiper-wrapper">
                             <!-- banner -->
                            <%@include file="/WEB-INF/page/web/common/banner.jsp" %>
                        </div>
                        <div class="swiper-button-prev swiper-button-white"></div>
                        <div class="swiper-button-next swiper-button-white"></div>
                        <div class="swiper-pagination swiper-pagination-white"></div>
                    </div>
                </div>
            </section>
            <section id="products_news">
                <div class="section-text st-products show-pc">
                    <img src="/web/img/products_text.png" alt="products">
                </div>
                <div class="sec-inner inner-mid-width">
                    <div class="products_news flex-box">
                        <div id="products" class="product-box flex-item">
                            <div class="section-text st-products show-sp">
                                <img src="/web/img/products_text.png" alt="products">
                            </div>
                            <h2 class="h2Title headline-anime">
                                <span class="text-en">PRODUCTS</span>
                                <span class="text-ja">产品一览</span>
                            </h2>
                            <div class="products_banner flex-box">
                                <%@include file="/WEB-INF/page/web/common/product.jsp" %>
                            </div>
                        </div>
                        
                        <div id="news" class="news-box flex-item">
                            <h2 class="h2Title headline-anime">
                                <span class="text-en">NEWS</span>
                                <span class="text-ja">新闻中心</span>
                            </h2>

							<div class="news_list-box">
                                <div class="iframe">
                                    <div id="news_wrap">
                                        <ul id="news_list">
                                           		<!--资讯列表  -->
    											<%@include file="/WEB-INF/page/web/common/news_index_list.jsp" %> 
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="scroll-btn">
                                <a class="down-btn"></a>
                                <a class="up-btn"></a>
                            </div>


					</div>
                    </div>
                </div>
            </section>
            <div class="spacePc-10 "></div>
        </div>
    </div>
    <!----------------------------------------  FOOTER  ---------------------------------------->
    <div class="pageTop-btn">
        <a href="#" data-smooth=""></a>
    </div>
    <footer>
        <div class="footer-inner inner-width inner-mid-width">
            <div class="footer-logo">
                <div class="image">
                    <a href="index.html">
                        <img src="/web/images/logo_2.jpg">
                    </a>
                </div>
            </div>
            <!-- <p class="social-icons">
                <a href="https://twitter.com/VALINOTIRES/"><i class="icon-twitter2"></i></a>
                <a href="https://www.facebook.com/Valino-Tires-International-651901148493959/"><i
                        class="icon-facebook2"></i></a>
                <a href="https://www.instagram.com/valino_photos/"><i class="icon-instagram"></i></a>
                <a href="https://www.youtube.com/channel/UCMtrayWAm38NYTD2m_I5svQ"><i class="icon-youtube"></i></a>
            </p> -->
            <p class="copyright">COPYRIGHT (C) VALINO TIRES CO., LTD. ALL RIGHTS RESERVED.</p>

            <div class="brandlogo"><a href="company.html">- COMPANY PROFILE -</a></div>

            <div class="brandlogo"><a href="https://valino.tires/logos/">- BRANDLOGO RESOURCES SITE -</a></div>

            <div style="height:3rem"></div>
        </div>
    </footer>
    <script src="/web/js/smoothscroll.js"></script>
    <script src="/web/js/obj.js"></script>
    <script src="/web/js/common.js"></script>
    <script src="/web/js/jquery.min.js"></script>
    <script src="/web/js/superfish.js"></script>
    <script src="/web/js/jquery.waypoints.min.js"></script>
    <script src="/web/js/jquery.flexslider-min.js"></script>
    <script src="/web/js/scrollreveal.min.js"></script>
    <script src="/web/js/swiper.js"></script>
    


	<!--Swiper-->
	<script>
		var swiper = new Swiper('.swiper-container', {
			effect: 'fade',
			autoplay: {
				delay: 5000,
				stopOnLastSlide: false,
				disableOnInteraction: false,
				reverseDirection: false
			},
			navigation: {
				nextEl: '.swiper-button-next',
				prevEl: '.swiper-button-prev',
			},
			loop: true,
			pagination: {
				el: '.swiper-pagination',
				type: 'bullets',
			},
		});
	</script>
    <script>
        ScrollReveal({ distance: '80px' });
        var option = {
            duration: 1000,
            viewFactor: 1,
            origin: "left",
            easing: 'cubic-bezier(.25,.1,.25,1)',
        }

        ScrollReveal().reveal('.headline-anime', option)
        var option2 = {
            duration: 800,
            viewFactor: 0.7,
            origin: "top",
            easing: 'cubic-bezier(.25,.1,.25,1)',
        }
        ScrollReveal().reveal('.banner-anime', option2);
    </script>
    
        <script src="/web/sailun/js/page.js"></script>
    	<script src="/web/sailun/js/new_index_list.js"></script>
</body>


<!-- Mirrored from valino.jp/ by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 04 Apr 2021 06:45:01 GMT -->

</html>
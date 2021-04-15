<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%@include file="/WEB-INF/page/web/common/meta.jsp" %>
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
                                           
                                            <li><span class="news_List_Ymd">
                                                    <font size="3">2021/02/16 </font>
                                                </span><br><span class="news_List_Title">
                                                    <font size="3"><a
                                                            href="ndetail.html">VALINO
                                                            D1ライセンス選考会 </a> </font>
                                                </span></li>
                                            <li><span class="news_List_Ymd">
                                                    <font size="3">2021/01/31 </font>
                                                </span><br><span class="news_List_Title">
                                                    <font size="3"><a
                                                            href="ndetail.html">【準優勝】D1
                                                            GRAND PRIX Rd.8 TSUKUBA</a> </font>
                                                </span></li>
                                            <li><span class="news_List_Ymd">
                                                    <font size="3">2021/01/31 </font>
                                                </span><br><span class="news_List_Title">
                                                    <font size="3"><a
                                                            href="ndetail.html">【準優勝】D1
                                                            GRAND PRIX Rd.8 TSUKUBA 単走</a> </font>
                                                </span></li>
                                            <li><span class="news_List_Ymd">
                                                    <font size="3">2021/01/30 </font>
                                                </span><br><span class="news_List_Title">
                                                    <font size="3"><a
                                                            href="ndetail.html">【優勝】D1
                                                            GRAND PRIX Rd.7 TSUKUBA</a> </font>
                                                </span></li>
                                            <li><span class="news_List_Ymd">
                                                    <font size="3">2021/01/30 </font>
                                                </span><br><span class="news_List_Title">
                                                    <font size="3"><a
                                                            href="ndetail.html">【単走優勝】D1
                                                            GRAND PRIX Rd.7 TSUKUBA </a> </font>
                                                </span></li>
                                            <li><span class="news_List_Ymd">
                                                    <font size="3">2021/01/27 </font>
                                                </span><br><span class="news_List_Title">
                                                    <font size="3"><a
                                                            href="ndetail.html">2021年度スカラシップのご案内
                                                            ［2月1日］から申し込み受付開始</a> </font>
                                                </span></li>
                                            <li><span class="news_List_Ymd">
                                                    <font size="3">2020/12/26 </font>
                                                </span><br><span class="news_List_Title">
                                                    <font size="3"><a
                                                            href="ndetail.html">［VALINO
                                                            TOKYO］VALINO 折り畳みコンテナBOX 発売</a> </font>
                                                </span></li>
                                            <li><span class="news_List_Ymd">
                                                    <font size="3">2020/12/26 </font>
                                                </span><br><span class="news_List_Title">
                                                    <font size="3"><a
                                                            href="ndetail.html">［VALINO
                                                            TOKYO ］VALINOロングTシャツ発売</a> </font>
                                                </span></li>
                                            <li><span class="news_List_Ymd">
                                                    <font size="3">2020/12/26 </font>
                                                </span><br><span class="news_List_Title">
                                                    <font size="3"><a
                                                            href="ndetail.html">VALINO
                                                            TOKYO WEB限定ショップ 1月15日・16日・17日 3日間限定オープン</a> </font>
                                                </span></li>
                                            <li><span class="news_List_Ymd">
                                                    <font size="3">2020/12/18 </font>
                                                </span><br><span class="news_List_Title">
                                                    <font size="3"><a href="ndetail.html"
                                                            target="_parent">［新商品］武将シリーズ 最新作N820 予約開始</a> </font>
                                                </span></li>
                                            <li><span class="news_List_Ymd">
                                                    <font size="3">2020/12/12 </font>
                                                </span><br><span class="news_List_Title">
                                                    <font size="3"><a href="ndetail.html"
                                                            target="_parent">VALINO TIRES RC タイヤ&amp;ホイール 販売店一覧ページ開設</a>
                                                    </font>
                                                </span></li>
                                            <li><span class="news_List_Ymd">
                                                    <font size="3">2020/12/06 </font>
                                                </span><br><span class="news_List_Title">
                                                    <font size="3"><a
                                                            href="ndetail.html">2020年
                                                            Formula Drift Japanシリーズ VALINO TIRESが 1位・2位・3位を 独占！</a> </font>
                                                </span></li>
    
    
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
    <script src="/web/js/main.js"></script>
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
</body>


<!-- Mirrored from valino.jp/ by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 04 Apr 2021 06:45:01 GMT -->

</html>
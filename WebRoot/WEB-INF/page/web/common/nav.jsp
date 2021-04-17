<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  	<%@ taglib uri="/WEB-INF/tag/newsType.tld" prefix="nt" %>
  	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="fh5co-header">
	<header id="fh5co-header-section">
		<div class="clearfix">
			<div class="nav-header">
				<a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle"><i></i></a>
				<h1 id="fh5co-logo">
					<a href="/"><img src="/web/images/logo.png"></a>
				</h1>
				<nav id="fh5co-menu-wrap" role="navigation">
					<ul class="sf-menu" id="fh5co-primary-menu">
						<li><a href="/"><b>网站首页</b></a></li>
						<li><a href="/news" class="fh5co-sub-ddown"><b>资讯发布</b></a>
							<ul class="fh5co-sub-menu">
							 	<%@include file="/WEB-INF/page/web/common/newsType.jsp" %>
							</ul></li>
						<li><a href="/product" class="fh5co-sub-ddown"><b>产品展示</b></a>
							<ul class="fh5co-sub-menu">
								<%@include file="/WEB-INF/page/web/common/productType.jsp" %>
							</ul></li>
						<li><a href="/driver"><b>车手介绍</b></a></li>
						<li><a href="/aboutus"><b>关于我们</b></a></li>
						<li><a href="/contact"><b>联系我们</b></a></li>
					</ul>
				</nav>
			</div>
		</div>
	</header>
</div>


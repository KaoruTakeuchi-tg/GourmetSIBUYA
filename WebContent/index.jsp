<%@page import="jp.topgate.gourmetshibuya.beans.RestaurantBean"%>
<%@page import="java.util.List"%>
<%@page import="beanList.RestaurantList"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>GourmentSIBUYA toppage</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/img/favicon.ico" />
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v5.13.0/js/all.js"
	crossorigin="anonymous"></script>
<!-- Google fonts-->
<link
	href="https://fonts.googleapis.com/css?family=Merriweather+Sans:400,700"
	rel="stylesheet" />
<link
	href="https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic"
	rel="stylesheet" type="text/css" />
<!-- Third party plugin CSS-->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/magnific-popup.js/1.1.0/magnific-popup.min.css"
	rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/styles.css" rel="stylesheet" />
<link href="css/search.css" rel="stylesheet" />
</head>
<body id="page-top">
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-light fixed-top py-3"
		id="mainNav">
		<div class="container">
			<a class="navbar-brand js-scroll-trigger" href="#page-top">GourmentSIBUYA</a>
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto my-2 my-lg-0">
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#about">About</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href=RestaurantServlet>Services</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="CreateAccount">新規会員登録</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="Login">ログイン</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- Masthead-->
	<header class="masthead">
		<div class="container h-100">
			<div
				class="row h-100 align-items-center justify-content-center text-center">
				<div class="col-lg-10 align-self-end">
					<h1 class="text-uppercase text-white font-weight-bold">渋谷や周辺のレストランを探すなら
						GourmentSIBUYAにお任せ!</h1>
					<hr class="divider my-4" />
				</div>
				<div class="col-lg-8 align-self-baseline">
					<p class="text-white-75 font-weight-light mb-5">
						渋谷の隠れ家から高級レストラン、会員制レストランまで幅広く掲載しています。<br>忘年会・デート・歓迎会等様々なシーンに応じたお店が見つかるはずです。
					</p>
					<div class="container h-100">
						<div class="d-flex justify-content-center h-100">
							<div class="searchbar">
								<input class="search_input" type="text" name=""
									placeholder="Search..."> <a href="#"
									class="search_icon"><i class="fas fa-search"></i></a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>
	<!-- About-->
	<section class="page-section bg-primary" id="about">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-8 text-center">
					<h2 class="text-white mt-0">GourmentSIBUYA Premium</h2>
					<hr class="divider light my-4" />
					<p class="text-white-50 mb-4">グールメント渋谷プレミアム会員は最高のサービスと至高のお食事時間をお客様にご提供いたいます。<br>
					1.プレミアム会員限定の有名レストランご招待<br>
					2.予約が取りにくいレストランも優先的に予約<br>
					3.コンシェルジェがお客様のお店選びをサポート</p>
					<a class="btn btn-light btn-xl js-scroll-trigger" href="">プレミアム会員になる</a>
				</div>
			</div>
		</div>
	</section>
	<!-- Services-->
	<section class="page-section" id="services">
		<div class="container">
			<h2 class="text-center mt-0">GourmentSIBUYAの強み</h2>
			<hr class="divider my-4" />
			<div class="row">
				<div class="col-lg-3 col-md-6 text-center">
					<div class="mt-5">
						<i class="fas fa-4x fa-gem text-primary mb-4"></i>
						<h3 class="h4 mb-2">高品質なサービス</h3>
						<p class="text-muted mb-0">お店を掲載前にGourmentIBUYAが厳しくお店をチェック！安心して来店することができます。</p>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 text-center">
					<div class="mt-5">
						<i class="fas fa-4x fa-laptop-code text-primary mb-4"></i>
						<h3 class="h4 mb-2">最新のシステム</h3>
						<p class="text-muted mb-0">トップゲート社が提供しているTGSSで最高のセキュリティーを実現しています。お客様の個人情報をしっかり保護します。</p>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 text-center">
					<div class="mt-5">
						<i class="fas fa-4x fa-globe text-primary mb-4"></i>
						<h3 class="h4 mb-2">膨大な情報</h3>
						<p class="text-muted mb-0">渋谷周辺の店舗掲載数No1!お客様の希望に合ったお店がきっと見つかるはすです。</p>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 text-center">
					<div class="mt-5">
						<i class="fas fa-4x fa-heart text-primary mb-4"></i>
						<h3 class="h4 mb-2">お気に入り機能</h3>
						<p class="text-muted mb-0">プレミアム会員限定で、予約が取れない超人気レストランも優先的に予約ができます。</p>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Portfolio-->
	<section id="portfolio">
		<div class="container-fluid p-0">
			<div class="row no-gutters">
			<%List<RestaurantBean> reList = (List<RestaurantBean>)request.getAttribute("RestaurantInfo");
			Iterator<RestaurantBean> iterator = reList.iterator();
			RestaurantBean rb = new RestaurantBean();
			while(iterator.hasNext()){
			rb = iterator.next();%>
			<div class="col-lg-4 col-sm-6">
					<a class="portfolio-box" href="assets/img/portfolio/fullsize/1.jpg"><img
						class="img-fluid" src="assets/img/portfolio/thumbnails/1.jpg" alt="" />
						<div class="portfolio-box-caption">
						<div class="project-name"><%=rb.getName() %></div>
						</div></a>
				</div>
			<%} %>
				<!-- <div class="col-lg-4 col-sm-6">
					<a class="portfolio-box" href="assets/img/portfolio/fullsize/2.jpg"><img
						class="img-fluid" src="assets/img/portfolio/thumbnails/2.jpg"
						alt="" />
						<div class="portfolio-box-caption">
							<div class="project-category text-white-50">Category</div>
							<div class="project-name">Project Name</div>
						</div></a>
				</div>
				<div class="col-lg-4 col-sm-6">
					<a class="portfolio-box" href="assets/img/portfolio/fullsize/3.jpg"><img
						class="img-fluid" src="assets/img/portfolio/thumbnails/3.jpg"
						alt="" />
						<div class="portfolio-box-caption">
							<div class="project-category text-white-50">Category</div>
							<div class="project-name">Project Name</div>
						</div></a>
				</div>
				<div class="col-lg-4 col-sm-6">
					<a class="portfolio-box" href="assets/img/portfolio/fullsize/4.jpg"><img
						class="img-fluid" src="assets/img/portfolio/thumbnails/4.jpg"
						alt="" />
						<div class="portfolio-box-caption">
							<div class="project-category text-white-50">Category</div>
							<div class="project-name">Project Name</div>
						</div></a>
				</div>
				<div class="col-lg-4 col-sm-6">
					<a class="portfolio-box" href="assets/img/portfolio/fullsize/5.jpg"><img
						class="img-fluid" src="assets/img/portfolio/thumbnails/5.jpg"
						alt="" />
						<div class="portfolio-box-caption">
							<div class="project-category text-white-50">Category</div>
							<div class="project-name">Project Name</div>
						</div></a>
				</div>
				<div class="col-lg-4 col-sm-6">
					<a class="portfolio-box" href="assets/img/portfolio/fullsize/6.jpg"><img
						class="img-fluid" src="assets/img/portfolio/thumbnails/6.jpg"
						alt="" />
						<div class="portfolio-box-caption p-3">
							<div class="project-category text-white-50">Category</div>
							<div class="project-name">Project Name</div>
						</div></a>
				</div> -->
			</div>
		</div>
	</section>
	<!-- Contact-->
	<section class="page-section" id="contact">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-8 text-center">
					<h2 class="mt-0">お問い合わせ</h2>
					<hr class="divider my-4" />
					<p class="text-muted mb-5"></p>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-4 ml-auto text-center mb-5 mb-lg-0">
					<i class="fas fa-phone fa-3x mb-3 text-muted"></i>
					<div>+81 (0120) 123-4567</div>
				</div>
				<div class="col-lg-4 mr-auto text-center">
					<i class="fas fa-envelope fa-3x mb-3 text-muted"></i>
					<!-- Make sure to change the email address in BOTH the anchor text and the link target below!-->
					<a class="d-block" href="mailto:contact@yourwebsite.com">Takeuchi&Izumida@topgate.co.jp</a>
				</div>
			</div>
		</div>
	</section>
	<!-- Footer-->
	<footer class="bg-light py-5">
		<div class="container">
			<div class="small text-center text-muted">
				Copyright © 2020 - TopGate
				<div class="topgate"></div>
				<img alt="topGate Log" src="./assets/img/topgate.png">
			</div>
		</div>
	</footer>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
	<!-- Third party plugin JS-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/magnific-popup.js/1.1.0/jquery.magnific-popup.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
</body>
</html>

<%@page import="jp.topgate.gourmetshibuya.beans.CourseBean"%>
<%@page import="beanList.CourseList"%>
<%@page import="jp.topgate.gourmetshibuya.beans.ReviewBean"%>
<%@page import="beanList.ReviewList"%>
<%@page import="jp.topgate.gourmetshibuya.beans.RestaurantBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ja">
<head>
<%
	RestaurantBean rb = new RestaurantBean();
rb = (RestaurantBean) request.getAttribute("rb");
%>
<title><%=rb.getName()%></title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700,800"
	rel="stylesheet">

<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/animate.css">
<link rel="stylesheet" href="css/owl.carousel.min.css">

<link rel="stylesheet" href="css/magnific-popup.css">


<link rel="stylesheet" href="fonts/ionicons/css/ionicons.min.css">
<link rel="stylesheet" href="fonts/fontawesome/css/font-awesome.min.css">
<link rel="stylesheet" href="fonts/flaticons/font/flaticon.css">

<!-- Theme Style -->
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light fixed-top py-3"
		id="mainNav">
		<div class="container">
			<a class="navbar-brand js-scroll-trigger" href="IndexServlet">GourmentSIBUYA</a>
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
						href="#services">Services</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#accountregister">新規会員登録</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#accountregister">ログイン</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- END header -->
	<section class="home-slider owl-carousel">
		<div class="slider-item"
			style="background-image: url(<%=rb.getPhoto()%>);">

			<div class="container">
				<div
					class="row slider-text align-items-center justify-content-center">
					<div class="col-md-8 text-center col-sm-12 element-animate">
						<h1><%=rb.getName()%></h1>
						<pre>
							<p class="mb-5"><%=rb.getContent()%></p>
						</pre>
						<p>
							<a href="#" class="btn btn-white btn-outline-white">予約する</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- END slider -->


	<section class="section bg-light element-animate">
		<div class="container">
			<div class="row">
				<div class="col-md-6 mb-4 mb-lg-0 col-lg-3 text-center">
					<span class="display-4 text-black d-block mb-4"></span>
					<h4 class="mb-4 text-primary">住所</h4>
					<p><%=rb.getPlace()%></p>
				</div>
				<div class="col-md-6 mb-4 mb-lg-0 col-lg-3 text-center">
					<span class=" display-4 text-black d-block mb-4"></span>
					<h4 class="mb-4 text-primary">電話番号</h4>
					<p><%=rb.getPhonenum()%></p>
				</div>
				<div class="col-md-6 mb-4 mb-lg-0 col-lg-3 text-center">
					<span class=" display-4 text-black d-block mb-4"></span>
					<h4 class="mb-4 text-primary">営業時間</h4>
					<p><%=rb.getBusiness_hours()%></p>
					<p>
						定休日(<%=rb.getRegular_holiday()%>)
					<p>
				</div>
				<div class="col-md-6 mb-4 mb-lg-0 col-lg-3 text-center">
					<span class=" display-4 text-black d-block mb-4"></span>
					<h4 class="mb-4 text-primary">評価</h4>
					<h3><%=rb.getEvaluation()%></h3>
				</div>
			</div>
		</div>
	</section>

	<section class="section bg-light element-animate">

		<div class="clearfix mb-5 pb-5">
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-12 text-center heading-wrap">
						<h2>Menu</h2>
						<span class="back-text-dark">Menu</span>
					</div>
				</div>
			</div>
		</div>

		<div class="container">
			<div class="row no-gutters">
				<%
					CourseList cl = (CourseList) request.getAttribute("course");
				int i = 1;

				for (CourseBean cb : cl.getCourseBeanList()) {
				%>
				<%
					if (i == 1) {
				%>
				<div class="col-md-6">
					<div class="sched d-block d-lg-flex">
						<div class="bg-image order-2"
							style="background-image: url('<%=cb.getImg()%>');"></div>
						<div class="text order-1">
							<h3><%=cb.getCourse_name()%></h3>
							<p><%=cb.getExplanation()%></p>
							<p class="text-primary h3"><%=cb.getPrice()%></p>
						</div>
					</div>
					<%
						}
					%>
					<%
						if (i == 2) {
					%>
					<div class="sched d-block d-lg-flex">
						<div class="bg-image"
							style="background-image: url('<%=cb.getImg()%>');"></div>
						<div class="text">
							<h3><%=cb.getCourse_name()%></h3>
							<p><%=cb.getExplanation()%></p>
							<p class="text-primary h3"><%=cb.getPrice()%></p>
						</div>
					</div>
				</div>
				<%
					}
				%>
				<%
					if (i == 3) {
				%>
				<div class="col-md-6">
					<div class="sched d-block d-lg-flex">
						<div class="bg-image order-2"
							style="background-image: url('<%=cb.getImg()%>');"></div>
						<div class="text order-1">
							<h3><%=cb.getCourse_name()%></h3>
							<p><%=cb.getExplanation()%></p>
							<p class="text-primary h3"><%=cb.getPrice()%></p>
						</div>
					</div>
					<%
						}
					%>
					<%
						if (i == 4) {
					%>
					<div class="sched d-block d-lg-flex">
						<div class="bg-image"
							style="background-image: url('<%=cb.getImg()%>');"></div>
						<div class="text">
							<h3><%=cb.getCourse_name()%></h3>
							<p><%=cb.getExplanation()%></p>
							<p class="text-primary h3"><%=cb.getPrice()%></p>
						</div>
					</div>
				</div>
				<%
					}
				%>
				<%
					i++;
				}
				%>
			</div>
		</div>
		<!--  <div class="container">
        <div class="row no-gutters">
          <div class="col-md-6">
            <div class="sched d-block d-lg-flex">
              <div class="bg-image order-2" style="background-image: url('assets/img/dishes_4.jpg');"></div>
              <div class="text order-1">
                <h3>Grilled Caesar salad, shaved reggiano</h3>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Architecto illo delectus...</p>
                <p class="text-primary h3">$12.00</p>
              </div>
            </div>
            <div class="sched d-block d-lg-flex">
              <div class="bg-image" style="background-image: url('assets/img/dishes_1.jpg');"></div>
              <div class="text">
                <h3>Spicy Calamari and beans</h3>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Architecto illo delectus...</p>
                <p class="text-primary h3">$12.00</p>
              </div>
            </div>
          </div>
          <div class="col-md-6">
            <div class="sched d-block d-lg-flex">
              <div class="bg-image order-2" style="background-image: url('assets/img/dishes_2.jpg');"></div>
              <div class="text order-1">
                <h3>Bacon wrapped wild gulf prawns</h3>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Architecto illo delectus...</p>
                <p class="text-primary h3">$18.00</p>
              </div>
            </div>
            <div class="sched d-block d-lg-flex">
              <div class="bg-image" style="background-image: url('assets/img/dishes_3.jpg');"></div>
              <div class="text">
                <h3>Seared ahi tuna fillet*, honey-ginger sauce</h3>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Architecto illo delectus...</p>
                <p class="text-primary h3">$16.00</p>
              </div>
            </div>
          </div>-->
		<!-- </div>
		</div -->
	</section>
	<!-- .section -->



	<section class="section element-animate">

		<div class="clearfix mb-5 pb-5">
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-12 text-center heading-wrap">
						<h2>クチコミ</h2>
						<span class="back-text">クチコミ</span>
					</div>
				</div>
			</div>
		</div>

<<<<<<< HEAD
      <%ReviewList reviewList = (ReviewList)request.getAttribute("review");%>
      <div class="container">
        <div class="row">
        <%for(ReviewBean revireBean : reviewList.getReviewList()){%>
          <div class="col-md-4"><!-- ここから -->
            <blockquote class="testimonial">
              <p>&ldquo; <%=revireBean.getContent()%>&rdquo;</p>
              <div class="d-flex author">
                <img src="img/person_1.jpg" alt="" class="mr-4">
                <div class="author-info">
                  <h4><%=revireBean.getUserName()%></h4>
                  <p><%=revireBean.getCreate_at()%></p>
                </div>
              </div>
            </blockquote>
          </div>
          <%}%>
         <!--  <div class="col-md-4">
=======
		<%
			ReviewList reviewList = (ReviewList) request.getAttribute("review");
		%>
		<div class="container">
			<div class="row">
				<%
					for (ReviewBean revireBean : reviewList.getReviewList()) {
				%>
				<div class="col-md-4">
					<!-- ここから -->
					<blockquote class="testimonial">
						<p><%=revireBean.getTitle()%></p>
						<p><%=revireBean.getContent()%></p>
						<div class="d-flex author">
							<img src="img/person_1.jpg" alt="" class="mr-4">
							<div class="author-info">
								評価<%=revireBean.getEvaluation()%>
								<h4><%=revireBean.getUserName()%></h4>
								<p><%=revireBean.getCreate_at()%></p>
							</div>
						</div>
					</blockquote>
				</div>
				<%
					}
				%>
				<!--  <div class="col-md-4">
>>>>>>> a7671dc8b65b6be53a4662a6c1d93ee79ff52ba6
            <blockquote class="testimonial">
              <p>&ldquo; Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolor, obcaecati? Quis eum minus, sequi atque quisquam ducimus aliquam veritatis nobis cum iusto neque enim explicabo maxime natus doloribus, fuga sunt. &rdquo;</p>
              <div class="d-flex author">
                <img src="img/person_2.jpg" alt="" class="mr-4">
                <div class="author-info">
                  <h4>Mike Richardson</h4>
                  <p>CEO, XYZ Company</p>
                </div>
              </div>
            </blockquote>
          </div>
          <div class="col-md-4">
            <blockquote class="testimonial">
              <p>&ldquo; Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolor, obcaecati? Quis eum minus, sequi atque quisquam ducimus aliquam veritatis nobis cum iusto neque enim explicabo maxime natus doloribus, fuga sunt. &rdquo;</p>
              <div class="d-flex author">
                <img src="img/person_3.jpg" alt="" class="mr-4">
                <div class="author-info">
                  <h4>Charles White</h4>
                  <p>CEO, XYZ Company</p>
                </div>
              </div>
            </blockquote>
          </div>-->
			</div>
		</div>
		<form action="Review.jsp" method="GET">
			<input type="submit" class="btn btn-outline-primary" value="クチコミ投稿">
		</form>
	</section>
	<!-- .section -->

	<footer class="bg-light py-5">
		<div class="container">
			<div class="small text-center text-muted">
				Copyright © 2020 - TopGate
				<div class="topgate"></div>
				<img alt="topGate Log" src="./assets/img/topgate.png">
			</div>
		</div>
	</footer>

	<!-- loader -->
	<div id="loader" class="show fullscreen">
		<svg class="circular" width="48px" height="48px">
			<circle class="path-bg" cx="24" cy="24" r="22" fill="none"
				stroke-width="4" stroke="#eeeeee" />
			<circle class="path" cx="24" cy="24" r="22" fill="none"
				stroke-width="4" stroke-miterlimit="10" stroke="#cf1d16" /></svg>
	</div>

	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/jquery.waypoints.min.js"></script>

	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/magnific-popup-options.js"></script>


	<script src="js/main.js"></script>
</body>
</html>
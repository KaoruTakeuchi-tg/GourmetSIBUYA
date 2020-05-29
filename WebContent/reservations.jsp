<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="jp.topgate.gourmetshibuya.beans.CourseBean"%>
<%@page import="java.util.List"%>
<%@page import="beanList.RestaurantList"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>

<!DOCTYPE html>
<html lang="ja">
<head>
<title>ご予約</title>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="css/review.css">
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
						href=RestaurantServlet>Services</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="CreateAccount">新規会員登録</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="Login">ログイン</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- END header -->

    	<div class="area">
	<form action="ReviewServlet" method="GET">
		<div class="form-group">
			<label for="name">代表者名</label> <input type="text"
				class="form-control" id="name" name="name">
		</div>
		<div class="form-group">
			<label for="howmany">人数</label> <input type="text"
				class="form-control" id="howmany" name="howmany">
		</div>

		<div class="form-group">
			<label for="exampleFormControlSelect1">コース選択</label> <select
				class="form-control" id="exampleFormControlSelect1" name="course_name">
				<%CourseList cl = (CourseList);

				for(CourseBean ci: cl.getCourseBeenList()){
				%>
				<option><%ci.getCourse_name();%>></option>
				<%}%>

			</select>
		</div>

		<div class="form-group">
			<label for="time">時間</label> <input type="time"
				class="form-control" id="time" name="time">
		</div>
		<input type="submit" class="btn btn-primary" value="予約">
	</form>

	</div>

	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/jquery.waypoints.min.js"></script>

	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/magnific-popup-options.js"></script>




</body>
</html>
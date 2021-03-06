<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="jp.topgate.gourmetshibuya.beans.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
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
<link rel="stylesheet" href="css/review.css">
<title>Insert title here</title>
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
					<%HttpSession session2 = request.getSession();
					UserBean user = (UserBean)session.getAttribute("User");
					if(user == null){%>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="CreateAccount">新規会員登録</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="Login">ログイン</a></li>
					<%}else{ %>
						<a href="ReservationsServlet">予約一覧</a>
					<%} %>
				</ul>
			</div>
		</div>
	</nav>
	<!-- <form action="" method="GET">
		<input class="form-control" type="text" placeholder="タイトル"> <label
			for="exampleFormControlTextarea1">本文</label>
		<textarea class="form-control" id="exampleFormControlTextarea1"
			rows="3"></textarea>

		<div class="form-group">
			<label for="exampleFormControlSelect1">評価</label> <select
				class="form-control" id="exampleFormControlSelect1">
				<option>1</option>
				<option>2</option>
				<option>3</option>
				<option>4</option>
				<option>5</option>
			</select>
		</div>
		<input type="submit" class="btn btn-primary" value="投稿">
	</form> -->
	<div class="area">
	<form action="ReviewServlet" method="GET">
		<div class="form-group">
			<label for="name">タイトル</label> <input type="text"
				class="form-control" id="name" name="title">
		</div>
		<div class="form-group">
			<label for="message">本文</label>
			<textarea id="message" name="content" rows="8" cols="80"
				class="form-control"></textarea>
		</div>
		<div class="form-group">
			<label for="exampleFormControlSelect1">評価</label> <select
				class="form-control" id="exampleFormControlSelect1" name="evaluation">
				<option>1</option>
				<option>2</option>
				<option>3</option>
				<option>4</option>
				<option>5</option>
			</select>
		</div>
		<input type="submit" class="btn btn-primary" value="投稿">
	</form>
	<%if(request.getAttribute("message") != null){%>
		<%=request.getAttribute("message") %>
	<%} %>
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
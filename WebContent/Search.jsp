<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="jp.topgate.gourmetshibuya.beans.RestaurantBean"%>
<%@page import="java.util.List"%>
<%@page import="beanList.RestaurantList"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>

<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<div class="container">

	<%int indexNum = (int)request.getAttribute("indexNum");%>
    <hgroup class="mb20">
		<h1>検索結果</h1>
		<h2 class="lead"><strong class="text-danger"><%=indexNum%></strong> results were found for the search for <strong class="text-danger">Gourmet SIBUYA</strong></h2>   <!--  要素数 -->
	</hgroup>

	<%RestaurantList rl = (RestaurantList)request.getAttribute("searchResult");
	int i = 0;

	for(RestaurantBean ri: rl.getResutaurantList()){
		%>
    <section class="col-xs-12 col-sm-6 col-md-12">
    <form action="" method="GET" >
		<article class="search-result row">
			<div class="col-xs-12 col-sm-12 col-md-3">
				<a href="javascript:Restaurant<%=i %>.submit()" title="Lorem ipsum" class="thumbnail"><img src="<%=ri.getPhoto()%>" alt="Lorem ipsum" /></a>            <!-- 画像 -->
			</div>
			<div class="col-xs-12 col-sm-12 col-md-7 excerpet">
				<h3><a href="#" title=""><%=ri.getName() %></a></h3>
                <span class="plus"><a href="#" title="Lorem ipsum"><i class="glyphicon glyphicon-plus"></i></a></span>
			</div>
			<div class="col-xs-12 col-sm-12 col-md-2">
				<ul class="meta-search">
					<li><i class="glyphicon glyphicon-tags"></i> <span><%=ri.getGenres()%></span></li>  <!-- ジャンル -->
					<li><i class="glyphicon glyphicon-home"></i> <span><%=ri.getPlace()%></span></li>  <!-- 住所 -->
					<li><i class="glyphicon glyphicon-phone"></i> <span><%=ri.getPhonenum()%></span></li>  <!-- 電話番号 -->
					<li><i class="glyphicon glyphicon-time"></i> <span><%=ri.getBusiness_hours()%></span></li>  <!-- 営業時間 -->
					<!-- ５段階評価 -->
				</ul>
			</div>

			<span class="clearfix borda"></span>
		</article>
		</form>
	</section>
	<% i++;
	} %>
</div>



</head>
<body>

</body>
</html>
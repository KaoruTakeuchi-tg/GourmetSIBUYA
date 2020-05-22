<%@page import="jp.topgate.gourmetshibuya.beans.RestaurantBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% RestaurantBean rb = new RestaurantBean();
	rb = (RestaurantBean)request.getAttribute("rb"); %>
	<%=rb.getPhoto() %>
</body>
</html>
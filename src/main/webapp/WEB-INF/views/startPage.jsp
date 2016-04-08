<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/JavaScript"
	src="${pageContext.request.contextPath}/resources/lib/jquery-1.9.1.min.js">
	
</script>
<!-- <link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"> -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<!-- <script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> -->
<script type="text/JavaScript"
	src="${pageContext.request.contextPath}/resources/js/anim.js">
	
</script>
<style type="text/css">
.centered {
	top: -50%;
	left: 50%; 
	width: 450px; 
	height: 450px; 
	position: absolute; 
	margin-top: -225px;
	margin-left: -225px;
	border: 1px solid black;
}

.logo-cnt {
	position: absolute;
	margin-left: 9px;
	margin-top: 24px;
	/* overflow: visible;
	border: 1px solid black;  */
}

.border {
	border: 1px solid black;
	width: 432px;
	height: 124px;
	margin-top: 123px;
	margin-left: -1px;
	opacity: 0;
}

.logo {
	position: absolute;
	
	/* clip: rect(0px, 432px, 124px, 0px); */
	clip: rect(124px, 432px, 248px, 0px);
}
</style>

<title>Insert title here</title>
</head>
<body>

	<h1>Hello ${pageContext.request.contextPath}</h1>
	<form action="sayhello">
		Please input your name:<br> <input type="text" name="name"
			value=""> <br> <br>
		<input type="submit" value="Submit">
	</form>
	<br>
	<div class="centered">

		<div class="logo-cnt">

			<img class="logo"
				src="${pageContext.request.contextPath}/resources/img/facebook.png" />
			<div class="border"></div>

		</div>

	</div>
</body>
</html>
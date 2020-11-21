<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="zh">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>登录</title>
<link rel="stylesheet" type="text/css" href="../static/css/loginStyles.css">
</head>
<body>
<div class="htmleaf-container">
	<div class="wrapper">
		<div class="container">
			<h1>Welcome</h1>
			
			<form class="form" action="${pageContext.request.contextPath}/system/doLogin" method="post">
				<c:if test="${loginMessage  != null}">
				<font>${loginMessage}</font>
				</c:if>
				<input type="text" placeholder="Id" name="id">
				<input type="password" placeholder="Password" name="password">
				<button type="submit" id="login-button">Login</button>
			</form>
		</div>
		
	</div>
</div>

<script src="../static/js/jquery-2.1.1.min.js" type="text/javascript"></script>
<script>
$('#login-button').click(function (event) {
	event.preventDefault();
	$('form').fadeOut(500);
	$('.wrapper').addClass('form-success');
	$('.form').submit();
});
</script>

<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';color:#000000">
<h1>酒店管理系统</h1>
</div>
</body>
</html>
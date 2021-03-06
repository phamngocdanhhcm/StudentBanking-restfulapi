<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- <link href="/template/login/style.css" rel="stylesheet" type="text/css" media="all"/> -->
<style type="text/css">
body {
	margin: 0;
	padding: 0;
	background-color: #17a2b8;
	height: 100vh;
}

#login .container #login-row #login-column #login-box {
	margin-top: 120px;
	max-width: 600px;
	height: 320px;
	border: 1px solid #9C9C9C;
	background-color: #EAEAEA;
}

#login .container #login-row #login-column #login-box #login-form {
	padding: 20px;
}

#login .container #login-row #login-column #login-box #login-form #register-link
	{
	margin-top: -85px;
}
</style>
</head>
<body>
	<div id="login">
		<h3 class="text-center text-white pt-5">Hệ thống chuyển tiền</h3>

		<!-- 	<div class="alert alert-info">
			<strong>Info!</strong> Indicates a neutral informative change or
			action.
		</div>

		<div class="alert alert-warning">
			<strong>Warning!</strong> Indicates a warning that might need
			attention.
		</div>
		
			<div class="alert alert-success">
					<strong>Success!</strong> Indicates a successful or positive
					action.
				</div>
 -->

		<div class="container">
			<div id="login-row"
				class="row justify-content-center align-items-center">


				<div id="login-column" class="col-md-6">
					<c:if test="${not empty message }">
						<div class="alert alert-danger">
							<strong>Đăng nhập không thành công !</strong> ${message}
						</div>
					</c:if>
					<div id="login-box" class="col-md-12">



						<form id="login-form" class="form"
							action="<c:url value='/dang-nhap'/>" method="POST">
							<h3 class="text-center text-info">Login</h3>
							<div class="form-group">
								<label for="username" class="text-info">Username:</label><br>
								<input type="text" name="username" id="username"
									class="form-control">
							</div>
							<div class="form-group">
								<label for="password" class="text-info">Password:</label><br>
								<input type="password" name="password" id="password"
									class="form-control">
							</div>
							<div>
								<input type="hidden" value="login" name="action" />
							</div>
							<div class="form-group">
								<!-- 	<label for="remember-me" class="text-info"><span>Remember
										me</span> <span><input id="remember-me" name="remember-me"
										type="checkbox"></span></label> -->
								<br> <input type="submit" name="submit"
									class="btn btn-info btn-md" value="submit">
							</div>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
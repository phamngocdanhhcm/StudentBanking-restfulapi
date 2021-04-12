<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-web-inforuser"/>

<html lang="en">
<head>
<meta charset="utf-8" />
<link rel="icon" type="image/png"
	href="template/web/assets/img/favicon.ico">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>Users</title>

<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<meta name="viewport" content="width=device-width" />


<!-- Bootstrap core CSS     -->
<link href="template/web/assets/css/bootstrap.min.css" rel="stylesheet" />

<!-- Animation library for notifications   -->
<link href="template/web/assets/css/animate.min.css" rel="stylesheet" />

<!--  Light Bootstrap Table core CSS    -->
<link
	href="template/web/assets/css/light-bootstrap-dashboard.css?v=1.4.0"
	rel="stylesheet" />


<!--  CSS for Demo Purpose, don't include it in your project     -->
<link href="template/web/assets/css/demo.css" rel="stylesheet" />


<!--     Fonts and icons     -->
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">
<link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300'
	rel='stylesheet' type='text/css'>
<link href="template/web/assets/css/pe-icon-7-stroke.css"
	rel="stylesheet" />
	
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<%@ page import="java.text.NumberFormat" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

	
	

</head>
<body>
<!-- 	<p>Currency in USA :
         <fmt:setLocale value = "en_US"/>
         <fmt:formatNumber value = "10000000" type = "currency"/>
      </p>  -->
	<div class="wrapper">
		<%@include file="/common/web/header.jsp"%>

		<div class="main-panel">
			<%@include file="/common/web/list.jsp"%>



			<div class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12">
							<div class="card">
								<div class="header">
									<h4 class="title">Thông tin người dùng</h4>
								</div>
								<div class="content">
									
										<div class="row">
											<div class="col-md-6">
												<div class="form-group">
													<label>Full name</label> <input type="text"
														disabled="disabled" class="form-control"
														placeholder="Full name" id="name" name="name"
														value="">
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label for="exampleInputEmail1">Phone</label> <input
														disabled="disabled" type="number" class="form-control"
														id="phone" name="phone" placeholder="phone"
														value="">
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-md-12">
												<div class="form-group">
													<label>Gmail</label> <input type="email"
														disabled="disabled" class="form-control"
														placeholder="gmail" id="email" name="email"
														value="">
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-md-12">
												<div class="form-group">
													<label>Address</label> <input type="text" id="address"
														disabled="disabled" name="address" class="form-control"
														placeholder="Home Address" value="">
												</div>
											</div>
										</div>


										<div class="row">
											<div class="col-md-12">
												<div class="form-group">
													<label>Money</label> <input type="text"
														disabled="disabled" class="form-control"
														placeholder="Money" id="money" name="money"
														value="">
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-md-12">
												<div class="form-group">
													<input type="hidden" id="id" name="id" disabled="disabled"
														class="form-control" placeholder="Home Address"
														value="">
												</div>
											</div>
										</div>


										<div class="clearfix"></div>
									
								</div>
							</div>
						</div>


					</div>
				</div>
			</div>


			<!--  	<footer class="footer">
				<div class="container-fluid">
					<nav class="pull-left">
						<ul>
							<li><a href="#"> Home </a></li>
							<li><a href="#"> Company </a></li>
							<li><a href="#"> Portfolio </a></li>
							<li><a href="#"> Blog </a></li>
						</ul>
					</nav>
					<p class="copyright pull-right">
						&copy;
						<script>
							document.write(new Date().getFullYear())
						</script>
						<a href="http://www.creative-tim.com">Creative Tim</a>, made with
						love for a better web
					</p>
				</div>
			</footer>
-->

			<script type="text/javascript">
			
				function load(){
					var name_header = null;
					var money_header = null;
					var id = ${Infor_user.id};
					var da1 = {
							"id" : null , 
							"name" : null ,
							"phone" :null , 
							"email" : null, 
							"address" : null  ,
							"money" : null,
							"iduser" : id
					};							
	
					$.ajax({
						 type: "GET",
				            url: "${APIurl}", //Tên servlet
				            data: "id=" + id,  //Gán giá trị vào name mục đich để servlet nhận được Parameter
				            dataType: "json",
				            async: true,
				            cache: false,
						success: function (result)
						{
							document.getElementById('name').value = result.name ;
							document.getElementById('phone').value = result.phone ;
							document.getElementById('email').value = result.email ;
							document.getElementById('address').value = result.address ;
							document.getElementById('money').value = result.money.toLocaleString("it-IT",{style: "currency",currency: "VND",});
							

						},
						error : function(error) {
							var a = error;
						}
					})
				}
				window.onload = load();
			
				
			</script>

		</div>
	</div>


</body>

<!--   Core JS Files   -->
<script src="template/web/assets/js/jquery.3.2.1.min.js"
	type="text/javascript"></script>
<script src="template/web/assets/js/bootstrap.min.js"
	type="text/javascript"></script>

<!--  Charts Plugin -->
<script src="template/web/assets/js/chartist.min.js"></script>

<!--  Notifications Plugin    -->
<script src="template/web/assets/js/bootstrap-notify.js"></script>

<!--  Google Maps Plugin    -->
<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>

<!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->
<script
	src="template/web/assets/js/light-bootstrap-dashboard.js?v=1.4.0"></script>

<!-- Light Bootstrap Table DEMO methods, don't include it in your project! -->
<script src="template/web/assets/js/demo.js"></script>

</html>

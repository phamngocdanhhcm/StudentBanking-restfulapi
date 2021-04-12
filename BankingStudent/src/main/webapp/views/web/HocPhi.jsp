<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-web-inforuser"/>
<c:url var="APIurl1" value="/api-web-Pay"/>

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

	
</head>
<body>

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
									<h4 class="title">Học phí cần phải đóng</h4>
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
													<label for="exampleInputEmail1">Mã sinh viên đóng tiền</label> <input
														disabled="disabled" type="number" class="form-control"
														id="masinhvien" name="masinhvien" placeholder=""
														value="">
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-md-12">
												<div class="form-group">
													<label>Số tiền nợ học phí</label> <input type="text"
														disabled="disabled" class="form-control"
														placeholder="" id="money" name="money"
														value="">
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-md-12">
												<div class="form-group">
													<label>Tình trạng</label> <input type="text" id="tinhtrang"
														disabled="disabled" name="tinhtrang"  class="form-control"
														placeholder="" value="">
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
							document.getElementById('masinhvien').value = result.id ;
							$.ajax({
								type : "GET",
								url : "${APIurl1}", //Tên servlet
								data : "id=" + id, //Gán giá trị vào id mục đich để servlet nhận được Parameter
								dataType : "json",
								async : true,
								cache : false,
								success : function(result) {
									if(result != null)
										{
										document.getElementById('money').value = result.moneytopaid.toLocaleString("it-IT",{style: "currency",currency: "VND",});

										
										document.getElementById('tinhtrang').value = "Chưa thanh toán";
										}
									else{
										document.getElementById('money').value = "";
										document.getElementById('tinhtrang').value = "Tài khoản không nợ học phí !";
									
									}
									

								},
								error : function(error) {
									
								}
							})

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

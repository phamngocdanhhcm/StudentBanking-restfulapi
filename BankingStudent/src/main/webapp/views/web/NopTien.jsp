<!doctype html>
<%@page import="com.giuaki.model.Infor_User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-web-Pay" />
<c:url var="APIurl1" value="/api-web-inforuser" />
<c:url var="APIurl2" value="/api-web-Otp" />
<c:url var="APIurl3" value="/api-web-Mail" />



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

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

<%
	String a12 = "Infor_user";
%>

<script type="text/javascript">
	var check = null;

	function generateOTP() {
		// Khai báo một biến chữ số
		// nơi lưu trữ tất cả các chữ số
		var digits = '0123456789';
		let OTP = '';
		for (let i = 0; i < 4; i++) {
			OTP += digits[Math.floor(Math.random() * 10)];
		}
		return OTP;
	}

	function insert() {
		var a2 = "2";
		var a3 = "3";
		var id = id_pay;
		var otp = Number(generateOTP());

		var id_infuser = ${Infor_user.id};
		var status = 0;
		var data = {
			"id_pay" : id,
			"status" : status,
			"iduserpay" : id_infuser,
			"otp" : otp
		};

		$.ajax({
			type : "POST",
			url : "${APIurl2}", //Tên servlet
			data : JSON.stringify(data), //Gán giá trị vào id mục đich để servlet nhận được Parameter
			contentType : "application/json",
			dataType : "json",
			success : function(result) {
				a2 = result;
				if (a2 == null) {
					var check = false;
					alert("Giao dịch đang được thực hiên !");
				} else {

					document.getElementById('moneytopaid').value = moneytopaid;
					document.getElementById('otp1').value = otp;
					name_receive
					document.getElementById('myform').submit();

				}
			},
			error : function(error) {
				var a = result;
			}
		})

	}

	
</script>

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
									<h4 class="title">Đóng học phí</h4>
								</div>
								<div class="content">
									<form action="<c:url value='/Otp'/>" method="GET" id="myform"
										name="myform">
										<div class="row">
											<div class="col-md-12">
												<div class="form-group">
													<label>Mã số sinh viên</label> <input type="text"
														onchange="load()" class="form-control"
														placeholder="Mã số sinh viên" id="id" name="id" value="">
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-md-12">
												<div class="form-group">
													<label>Ho tên sinh viên</label> <input type="text"
														disabled="disabled" class="form-control" id="name"
														name="name" placeholder="name" value="">
												</div>
											</div>

										</div>

										<div class="row">
											<div class="col-md-12">
												<div class="form-group">
													<label>Số tiền cần đóng</label> <input type="text"
														disabled="disabled" class="form-control" id="money"
														name="money" placeholder="money" value="">
												</div>
											</div>
										</div>


										<div class="row">
											<div class="col-md-12">
												<div class="form-group">
													<label>Trạng thái</label> <input type="text"
														class="form-control" placeholder="status" id="status"
														disabled="disabled" name="status" value="">
												</div>
											</div>
										</div>

										<div>
											<input type="hidden" value="otp" name="action" />
										</div>

										<div>
											<input type="hidden" value="" name="otp1" id="otp1" />
										</div>
										
										<div>
											<input type="hidden" value="" name="name_receive" id="name_receive" />
										</div>
										<div>
											<input type="hidden" value="" name="moneytopaid" id="moneytopaid" />
										</div>


										<button type="button" id="Button" name="Button"
											onclick="insert()" class="btn btn-info btn-fill pull-right">Đóng
											tiền</button>
										<div class="clearfix"></div>
									</form>
								</div>
							</div>
						</div>


					</div>
				</div>
			</div>


		

			<script type="text/javascript">
				var id_pay = null;

				/*		  
						
				 */
				var moneytopaid = null;
				function load() {
					var id = document.getElementById("id").value;
					$
							.ajax({
								type : "GET",
								url : "${APIurl}", //Tên servlet
								data : "id=" + id, //Gán giá trị vào id mục đich để servlet nhận được Parameter
								dataType : "json",
								async : true,
								cache : false,
								success : function(result) {
									if(result != null)
										{
										var a = result.moneytopaid.toLocaleString("it-IT",{style: "currency",currency: "VND",});
										document.getElementById('money').value = a;
										moneytopaid = result.moneytopaid;
										id_pay = result.id;
										if (result.status == 0) {
											document.getElementById('status').value = "Chưa thanh toán";
											if(${Infor_user.money} > moneytopaid) 
												{
												document.getElementById("Button").disabled = false;
												}
											else {
												document.getElementById("Button").disabled = true;
											}

										} else {
											document.getElementById('status').value = "Đã thanh toán";
											document.getElementById("Button").disabled = true;

										}
										} 
									else{
										document.getElementById('money').value = "";
										document.getElementById('status').value = "Tài khoản không nợ học phí !";
										document.getElementById("Button").disabled = true;
									}
									

								},
								error : function(error) {
									
								}
							})

					$
							.ajax({
								type : "GET",
								url : "${APIurl1}", //Tên servlet
								data : "id=" + id, //Gán giá trị vào id mục đich để servlet nhận được Parameter
								dataType : "json",
								async : true,
								cache : false,
								success : function(result) {
									document.getElementById('name').value = result.name;
									document.getElementById('name_receive').value = result.name;


								},
								error : function(error) {
									document.getElementById('name').value = "";

								}

							})
				}
				
				
				
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

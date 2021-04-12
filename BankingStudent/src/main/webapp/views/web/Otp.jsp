<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-web-Pay" />
<c:url var="APIurl1" value="/api-web-inforuser" />
<c:url var="APIurl3" value="/api-web-Mail" />
<c:url var="APIurl4" value="/api-web-Otp" />
<c:url var="APIurl5" value="/api-web-History" />

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

<style>
span {
	border: solid 1px #ACACAC;
	padding: 2px;
}
</style>
<script type="text/javascript">


			function load()
			{
				var otp = ${Otp.otp};
				$.ajax({
					type : "GET",
					url : "${APIurl3}", //Tên servlet
					data : "otp=" + otp ,//Gán giá trị vào id mục đich để servlet nhận được Parameter
					contentType : "application/json",
					dataType : "json",
					success : function(result) {
						alert("Đã gửi otp !");

					},
					error : function(error) {
					}
				})
			}
			window.onload = load();
	
			
			</script>

<script type="text/javascript">

			function xoa()
			{
				var data = {
						"id_pay" : ${Otp.id_pay}  
					};
				$.ajax({
					type : "DELETE",
					url : "${APIurl4}", //Tên servlet
					data : JSON.stringify(data), //Gán giá trị vào id mục đich để servlet nhận được Parameter
					contentType : "application/json",
					dataType : "json",
					success : function(result) {
						alert('Giao dịch bị hủy');
						document.getElementById('myform').submit();
					},
					error : function(error) {
						var a = error;
					}
				})
				}   
	</script>
<script type="text/javascript">
		var pay1 = null;
		function pay()
		{
			$.ajax({
				type : "GET",
				url : "${APIurl}", //Tên servlet
				data : "id=" + ${idpay},  //Gán giá trị vào id mục đich để servlet nhận được Parameter
				dataType : "json",
				async : true, 
				cache : false,
				success : function(result) {
					if(result != null)
						{
						
						if (result.status == 0) {
							pay1 = result;
						} else {
			
						}
						}
					
					
			
				},
				error : function(error) {
					
				}
			})
		}
		window.onload = pay();
		</script>
<script type="text/javascript">
			
			function update()
			{
				 
				if(document.getElementById('otp').value == ${Otp.otp} )
				{
					var money = ${Infor_user.money} - <%=request.getAttribute("money")%> ;
					var iddata = ${Infor_user.id};
					var namedata = "${Infor_user.name}";
					var phone = ${Infor_user.phone};
					var address =" ${Infor_user.address}";
					var email = "${Infor_user.email}";
					var iduser = ${Infor_user.iduser};
					var da1 = {
							"id" : iddata , 
							"name" : namedata , 
							"phone" :phone , 
							"email" : email, 
							"address" : address  ,
							"money" : money,
							"iduser" : iduser
					};
					var da2 = {
							"id_pay" : ${Otp.id_pay},
							"status" : ${Otp.status},
							"iduserpay" : ${Otp.iduserpay},
							"otp" : ${Otp.otp} 
					} ;
					var da3 = {
							"fullname_pay" : "${Infor_user.name}",
							"fullname_receive" : "${name_receive}",
							"id_pay" : iddata,
							"id_receive" :  ${idpay},
							"moneytopaid" : ${money}
					}
					  
				
				$.ajax({
					type : "PUT", 
					url : "${APIurl4}", //Tên servlet 
					data : JSON.stringify(da2), //Gán giá trị vào id mục đich để servlet nhận được Parameter
					contentType : "application/json",
					dataType : "json",  
					success : function(result) {
						$.ajax({ 
							type : "PUT", 
							url : "${APIurl1}", //Tên servlet 
							data : JSON.stringify(da1), //Gán giá trị vào id mục đich để servlet nhận được Parameter
							contentType : "application/json",
							dataType : "json",
							success : function(result) {
								$.ajax({ 
									type : "PUT",
									url : "${APIurl}", //Tên servlet
									data : JSON.stringify(pay1), 
									contentType : "application/json", 
									dataType : "json", 
									success : function(result) {
										$.ajax({
											type : "POST", 
											url : "${APIurl5}",
											data : JSON.stringify(da3), 
											contentType : "application/json",
											dataType : "json", 
											success : function(result) { 
												alert('Giao dịch thành công'); 
												document.getElementById('myform').submit();
											},
											error : function(error) {
												var a = error;
											}
										})
									},
									error : function(error) {
										var a = error;
									} 
								})
							},
							error : function(error) {
								var a = error;
							}
						})
					},
					error : function(error) { 
						var a = error;
					}
				})
				}
				else {
					alert('Mã Otp không đúng !');
				}
				
			
				
				}</script>


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
									<h4 class="title">Nhập mã OTP đã được gửi vào mail
										${Infor_user.email}</h4>
								</div>
								<div class="content">
									<form action="<c:url value='/Tra-Tien'/>" method="GET"
										id="myform" name="myform">
										<div class="row">
											<div class="col-md-12">
												<div class="form-group">
													<label>Mã Otp</label> <input type="number" id="otp"
														name="otp" class="form-control" placeholder="Mã Otp"
														value="">
												</div>
											</div>
										</div>


										<br> <input type="button" name="huy" id="huy"
											onclick="xoa()" class="btn btn-info btn-md" value="Hủy">
										 <input type="button" name="xacnhan" id="xacnhan"
											onclick="update()" class="btn btn-info btn-md" value="Xác nhận">


										<div>
											<input type="hidden" value="pay" name="action" />
										</div>
									</form>
									<div>
										<span id="m">Phút</span> : <span id="s">Giây</span>
									</div>
								</div>
							</div>
						</div>


					</div>
				</div>
			</div>





			<script language="javascript">
				var m = null; // Phút
				var s = null; // Giây

				var timeout = null; // Timeout

				function start() {
					/*BƯỚC 1: LẤY GIÁ TRỊ BAN ĐẦU*/
					if (m === null) {
						m = 2;
						s = 0;
					}

					if (s === -1 && m != 0) {
						m -= 1;
						s = 59;
					}

					// Nếu số giờ = -1 tức là đã hết giờ, lúc này:
					//  - Dừng chương trình
					if (m == 0 && s == 0) {
						clearTimeout(timeout);
						xoa();
						return false;
					}

					/*BƯỚC 1: HIỂN THỊ ĐỒNG HỒ*/
					//     document.getElementById('h').innerText = h.toString();
					document.getElementById('m').innerText = m.toString();
					document.getElementById('s').innerText = s.toString();

					/*BƯỚC 1: GIẢM PHÚT XUỐNG 1 GIÂY VÀ GỌI LẠI SAU 1 GIÂY */
					timeout = setTimeout(function() {
						s--;
						start();
					}, 1000);
				}

				function stop() {
					clearTimeout(timeout);
				}
				
				
				window.onload = start();
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

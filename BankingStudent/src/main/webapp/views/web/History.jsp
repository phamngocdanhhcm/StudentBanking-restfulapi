<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-web-History" />

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


<script type="text/javascript">
	function load() {
		var da1 = ${Infor_user.id};
		$.ajax({
			type : "GET",
			url : "${APIurl}", //Tên servlet
			data : "id_pay=" + da1, //Gán giá trị vào id mục đich để servlet nhận được Parameter
			dataType : "json",
			async : true,
			cache : false,
			success : function(result) {
				 var listSize = Object.keys(result).length;
				 if (listSize == 0) {
	                    $('#message').text("Chưa có giao dịch với tài khoản này");
	                    $('#message').css('color', 'red');
	                    return;
	                }
				 if (listSize > 0) {
	                    $('#message').text("");
	                    //Khai báo table kiểu global để sử dụng ngoài fuction này
	                    table = document.getElementById("row");
	                    for (i = 0; i < listSize; i++) {
	                        var row = table.insertRow(i);

	                        var cell = row.insertCell(0);
	                        var cell1 = row.insertCell(1);
	                        var cell2 = row.insertCell(2);
	                        var cell3 = row.insertCell(3);
	                        var cell4 = row.insertCell(4);
	                        var cell5 = row.insertCell(5);


	                        cell.innerHTML = i + 1;
	                        cell1.innerHTML = result[i].fullname_pay;
	                        cell2.innerHTML = result[i].fullname_receive;
	                        cell3.innerHTML = result[i].id_pay;
	                        cell4.innerHTML = result[i].id_receive;
	                        cell5.innerHTML = result[i].moneytopaid.toLocaleString("it-IT",{style: "currency",currency: "VND",});

	                        row.className += 'trOnColor';// class có tên trOnColor

	                        cell.className += 'text-center'; 
	                        cell1.className += 'text-center';
	                        cell2.className += 'text-center';
	                        cell3.className += 'text-center';
	                        cell4.className += 'text-center';
	                        cell5.className += 'text-center';

	                    }
				 }
			},
			error : function(error) {
				var a = error;
			}
		})
	}
	window.onload = load();
</script>


<style type="text/css">


.history__table{width: 100%;}
.history__table thead{}
.history__table thead tr{background: #dfdfdf;}
.history__table thead tr th{padding: 10px 0; text-align: center;}
.history__table tbody {}
.history__table tbody tr:nth-child(even){background: #efefef;}
.history__table tbody tr:nth-child(odd){}
.history__table tbody tr{}
.history__table tbody tr td{padding: 18px 0px;}
</style>
 
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
									<h4 class="title">Lịch sử giao dịch</h4>
								</div>
								<div class="content">

									<p id="message" align="left"></p>
										
									<table class="history__table">
										<thead>
											<tr>
												<th>ID</th>
												<th>Full name pay</th>
												<th>Full name receive</th>
												<th>Id pay</th>
												<th>Id receive</th>
												<th>Money to paid</th>
											</tr>
										</thead>
										<tbody id="row">
										</tbody>
									</table>

									<div class="clearfix"></div>

								</div>
							</div>
						</div>


					</div>
				</div>
			</div>


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

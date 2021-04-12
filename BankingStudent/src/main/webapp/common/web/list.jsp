<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<div class="sidebar" data-color="purple"
	data-image="assets/img/sidebar-5.jpg">

	<div class="sidebar-wrapper">
		<div class="logo">
			<a href="http://www.creative-tim.com" class="simple-text"> Xin
				chào </a>
		</div>

		<ul class="nav">
			<li class="active"><a href='<c:url value="/trang-chu?action=trangchu"></c:url>'> <i
					class="pe-7s-user"></i>
					<p>Thông tin người dùng</p>
			</a></li>
			<li><a href='<c:url value="/Tra-Tien?action=pay"></c:url>'> <i class="pe-7s-note2"></i>
					<p>Nộp tiền</p>
			</a></li>
			<li><a href='<c:url value="/History"></c:url>'> <i class="pe-7s-news-paper"></i>
					<p>Lịch sử giao dịch</p>
			</a></li>
			<li><a href='<c:url value="/Hoc-Phi"></c:url>'> <i class="pe-7s-science"></i>
					<p>Học phí cần phải đóng</p>
			</a></li>
			
		</ul>
	</div>
</div>


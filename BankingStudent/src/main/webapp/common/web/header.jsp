<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/common/taglib.jsp"%>


<nav class="navbar navbar-default navbar-fixed">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#navigation-example-2">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">User</a>
		</div>
		<div class="collapse navbar-collapse">
			

			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">
						<p>Xin chào : ${Infor_user.name} </p>
				</a></li>
			
				
				<li><a href='<c:url value="/logout?action=logout"></c:url>'>
						<p>Log out</p>
				</a></li>
				<li class="separator hidden-lg hidden-md"></li>
			</ul>
		</div>
	</div>
</nav>

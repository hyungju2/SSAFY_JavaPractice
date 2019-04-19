<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" buffer="24kb"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.ssafy.vo.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style type="text/css">
nav.blackbar {
	list-style: none;
	background-color: black;
	padding: 5px;
	height: 40px;
	border: none;
}

.blackbar ul {
	float: right;
	margin: 1px;
}

.blackbar ul li {
	display: inline-block;
	padding-left: 20px;
	padding-right: 20px;
	margin: 2px;
}

.blackbar ul li button {
	background-color: #555;
	color: white;
	border: none;
	border-radius: 10px;
	height: 25px;
	width: 80px;
}

header img {
	margin-left: 30px;
	margin-top: 10px;
	height: 40px;
	width: 60px;
}

.logobar {
	display: flex;
}

.logobar ul {
	margin-top: 20px;
	margin-left: 100px;
}

.logobar ul li {
	float: right;
	list-style-type: none;
	padding-left: 20px;
	padding-right: 20px;
}

.logobar .logo {
	height: 50px;
	width: 70px;
}

.logobar .lens {
	height: 20px;
	width: 20px;
	background-color: gray;
	padding-top: 5px;
	padding-bottom: 5px;
	padding-left: 25px;
	padding-right: 5px;
	border-radius: 20px;
	margin-top: 15px;
}

.graybox {
	background-color: gray;
	color: white;
	width: 100%;
	text-align: center;
	padding-bottom: 10px;
	padding-top: 10px;
	margin-top: 10px;
}

.darkbox {
	background-color: #4d4d4d;
	color: gray;
	text-align: center;
	padding-bottom: 10px;
	padding-top: 10px;
}

.darkbox table {
	margin: 0 auto;
}

.darkbox table tr input, table select {
	border-radius: 3px;
	background-color: gray;
	border: none;
	height: 20px;
}

.darkbox table td {
	text-align: left;
	padding-left: 5px;
	padding-right: 5px;
	color: #999999
}

.darkbox table button {
	background-color: #0099ff;
	color: white;
	border-radius: 3px;
	width: 60px;
	height: 20px;
	border: none;
}

.container {
	display: inline-block;
	padding-top: 100px;
}

.row {
	display: flex;
	margin-left: 15%;
}

.row img {
	height: 200px;
	width: 220px;
}

.row .data {
	height: 300px;
	width: 70%;
}

.row .data a {
	text-decoration: none;
}

.row button {
	height: 20px;
	width: 50px;
	border: none;
	border-radius: 5px;
	background-color: #4db8ff;
	color: white;
}

footer a {
	text-decoration: none;
	color: #0099ff;
}

footer div {
	margin-left: 10px;
	margin-bottom: 10px;
}

footer div img {
	margin-right: 15px;
}

footer .bottombar {margin-left = 0;margin-right = 0;
	width: 120%;
	height: 20px;
	padding-top: 10px;
	padding-bottom: 10px;
	background-color: #ddd;
	text-align: center;
}

nav ul a {
	color: black;
}

.darkbox input, select {
	color: white;
}
</style>
<script type="text/javascript">
	$(function() {
		$('#userinfo').click(function() {
			location.href = 'userInfo.mvc';
		});
		$('#logout').click(function() {
			location.href = 'logout.mvc';
		});
		$('#searchuser').click(function() {
			location.href = 'html/searchuser.html';
		});
		$('#signup').click(function() {
			location.href = 'html/signup.html';
		});
		$('#search').click(function() {
			location.href = 'search_result.html';
		});
		$('#userOut').click(function() {
			location.href = 'userOutReady.mvc';
		});
	});
</script>
</head>
<body>
	<header>
		<nav class="blackbar">
			<ul>
				<c:if test="${empty user }">
					<li><button id="searchuser">회원검색</button></li>
					
					<li><button id="signup">Sign up</button></li>
					
					
					<li><button type="button" data-toggle="modal"
							data-target="#exampleModal">Login</button></li>
					<div class="modal fade" id="exampleModal" tabindex="-1"
						role="dialog" aria-labelledby="exampleModalLabel"
						aria-hidden="true">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">Login</h5>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<div class="modal-body">
									<form method="post" action="login.mvc">
										<div class="form-group">
											<label for="login_id" class="form-control-label">ID</label> <input
												type="text" class="form-control" name="login_id"
												id="login_id">
										</div>
										<div class="form-group">
											<label for="login_pw" class="form-control-label">PASSWORD</label>
											<input type="password" class="form-control" name="login_pw"
												id="login_pw">
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary"
												data-dismiss="modal">Close</button>
											<input type="submit" class="btn btn-primary" value="로그인">
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</c:if>
			</ul>
		</nav>
		<nav class="logobar">
			<a href="main.mvc"><img class="logo" alt="logo"
				src="img/logo.png"></a>
			<ul>
				<li class="info_eat">예상 섭취 정보</li>
				<li class="info_my">내 섭취정보</li>
				<li class="info_best">베스트 섭취 정보</li>
				<li class="info_item">
					<c:if test="${not empty user }">
						<a href="foodlist.mvc">상품정보</a>
					</c:if>
					<c:if test="${empty user }">
						상품정보
					</c:if>
				</li>
				<li class="announce">공지사항</li>
			</ul>
			<img class="lens" alt="search" src="img/lens.png">
		</nav>
	</header>
	<div class="graybox">
		<h3>WHAT WE PROVIDE</h3>
		<h5>건강한 삶을 위한 먹거리 프로젝트</h5>
	</div>
	
	<!-- contents -->
	<%
	System.out.println(request.getAttribute("user"));
	%>
	<div class="container">
		<div class="row">
			<% String name = (String)request.getAttribute("user");
				if(name!=null){%>
			<div class="data">
				<h2><%=name %></h2>
				<hr>
				<p>아이디로 가입된 성함입니다.</p>
			</div>
			<% } else {%>
			<div class="data">
				<h2>다시 검색해주세요.</h2>
				<hr>
				<p>아이디로 가입된 성함이 없습니다.</p>
			</div>
			<%} %>
		</div>
	
	</div>
	<!-- contents end -->

	<footer>
		<h3>Find us</h3>
		<hr>
		<div>
			<img alt="pin" src="img/pin.png" style="height: 25px; width: 20px;">(SSAFY)서울시
			강남구 테헤란로 멀티스퀘어
		</div>
		<div>
			<img alt="phone" src="img/phone.png"
				style="height: 25px; width: 20px;">1544-9001
		</div>
		<div>
			<img alt="mail" src="img/mail.png" style="height: 25px; width: 25px;"><a
				href="#">admin@ssafy.com</a>
		</div>
	</footer>
</body>
</html>
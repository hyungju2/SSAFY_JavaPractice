<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Safe Food</title>
<!-- Bootstrap core CSS -->
<link href="${pageContext.request.contextPath}/view/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom fonts for this template -->
<link href="${pageContext.request.contextPath}/view/vendor/fontawesome-free/css/all.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/view/vendor/simple-line-icons/css/simple-line-icons.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic"
	rel="stylesheet" type="text/css">
<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/view/css/landing-page.css" rel="stylesheet">
<style type="text/css">
.btn-primary {
	color: #fff;
	background-color: red;
	border-color: burlywood;
	margin: 5px;
}

ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #333;
	width: 100%;
}

li {
	float: left;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

.active {
	background-color: #4CAF50;
}
</style>
</head>
<body>
<!-- Navigation -->
	<!--  nav start -->
	<nav class="navbar navbar-light bg-light static-top">
		<div class="container">
			<a class="navbar-brand col-md-12" href="main.food"
				style="text-align: center; font-weight: bold; font: 40px sans-serif; padding-left: 230px"><h1>싸피맨의 안전 먹거리 탐방</h1></a>
		</div>
	</nav>
	
	<ul class="horizontal container-fluid" style="">
		<li><a href="main.food">Home</a></li>
		<li><a href="javascript:void(0)">공지 사항</a></li>
		<li><a href="foodInfo.food">상품 정보</a></li>
		<li><a href="javascript:void(0)">베스트 섭취 정보</a></li>
		<li><a href="javascript:void(0)">내 섭취 정보</a></li>
		<li><a href="javascript:void(0)">예상 섭취 정보</a></li>
		<li style="float: right;"><a href="searchFood.food">음식검색</a></li>
	</ul>
	<!-- nav end -->

	<!-- Masthead -->
	<header class="masthead text-white text-center">
		<div class="overlay"></div>
		<div class="container">
			<div class="row">
				<div class="col-xl-9 mx-auto">
					<h1 class="mb-5"><%=request.getAttribute("SearchName")%>님 환영합니다!</h1>
				</div>
				<div class="col-md-10 col-lg-8 col-xl-7 mx-auto">
					<form>
						<div class="form-row" style="">

							<div style="margin: 0 auto;">
								<button type="button" class="btn btn-block btn-lg btn-primary"
									style="">로그인을 해주세요</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</header>
	<!-- Icons Grid -->

	<!-- Image Showcases -->
	<section class="showcase">
		<div class="container-fluid p-0">
			<div class="row no-gutters">

				<div class="col-lg-6 order-lg-2 text-white showcase-img"
					style="background-image: url('${pageContext.request.contextPath}/view/img/건강라면2.jpg');"></div>
				<div class="col-lg-6 order-lg-1 my-auto showcase-text">
					<h2>잘 먹고 잘 살자</h2>
					<p class="lead mb-0">잘 먹는 것이 곧 잘 사는 시대, 내가 먹는 음식에 대한 정보를 제공해
						드립니다!</p>
				</div>
			</div>
			<div class="row no-gutters">
				<div class="col-lg-6 text-white showcase-img"
					style="background-image: url('${pageContext.request.contextPath}/view/img/milk.jpg');"></div>
				<div class="col-lg-6 my-auto showcase-text">
					<h2>걱정 없이 쭉 들이키세요!</h2>
					<p class="lead mb-0">공인된 신뢰성 높은 정보만을 제공합니다</p>
				</div>
			</div>
		</div>
	</section>
	<!-- Testimonials -->

	<!-- Footer -->
	<footer class="footer bg-light">
		<div class="container">
			<p class="text-muted small mb-4 mb-lg-0">
				위치 : 역삼역 1번 출구 멀티캠퍼스<br>
			</p>
			<p class="text-muted small mb-4 mb-lg-0">© Your Website 2019. All
				Rights Reserved.</p>
		</div>
	</footer>

	<!-- Bootstrap core JavaScript -->
	<script src="${pageContext.request.contextPath}/view/vendor/jquery/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/view/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>
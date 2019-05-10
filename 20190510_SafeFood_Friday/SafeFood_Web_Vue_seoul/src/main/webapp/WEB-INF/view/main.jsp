<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" buffer="24kb"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
</head>
<body>
<%@include file="topmenu.jsp" %>
	<!-- contents -->
	<div class="container">
		<div class="row">
			<div>
				<img alt="" src="img/칸타타아메리카노.jpg">
			</div>
			<div class="data">
				<h2>칸타타아메리카노</h2>
				19.03.12 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">#아메리카노</a><br>
				<hr>
				<p>사람은 크고 작고 간에 이상이 있음으로써 용감하고 굳세게 살 수 있는 것이다 석가는 무엇을 위하여 설산에서
					고행을 하였으며 예수는 무엇을 위하여 광야에서 방황하였으며 공자는 무엇을 위하여 천하를 철환하였는가? 밥을 위하여서 옷을
					위하여서</p>
				<c:if test="${not empty user }">
				<button>추가</button>
				<button>찜</button>
				</c:if>
			</div>
		</div>
		<div class="row">
			<div>
				<img alt="" src="img/맥심티오피마스터라떼.jpg">
			</div>
			<div class="data">
				<h2>칸타타아메리카노</h2>
				18.08.27 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">#라떼</a>&nbsp;&nbsp;<a
					href="#">#티오피</a><br>
				<hr>
				<p>사람은 크고 작고 간에 이상이 있음으로써 용감하고 굳세게 살 수 있는 것이다 석가는 무엇을 위하여 설산에서
					고행을 하였으며 예수는 무엇을 위하여 광야에서 방황하였으며 공자는 무엇을 위하여 천하를 철환하였는가? 밥을 위하여서 옷을
					위하여서</p>
				<c:if test="${not empty user }">
				<button>추가</button>
				<button>찜</button>
				</c:if>
			</div>

		</div>
	</div>
	<!-- contents end -->

<%@ include file="bottom.jsp" %>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=euc-kr"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.w3c.dom.*"%>
<%@ page import="javax.xml.parsers.*"%>
<%@ page import="java.util.*, java.nio.file.Path, java.nio.file.Paths"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="euc-kr">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Safe Food</title>
<!-- Bootstrap core CSS -->
<link href="${pageContext.request.contextPath}/view/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

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

#td div {
	border: 1px groove;
	width: 20%;
	text-align: center;
	display: inline-block;
}

#td img {
	width: 35%;
}

#custom-search-input {
	padding: 3px;
	border: solid 1px #E4E4E4;
	border-radius: 6px;
	background-color: #fff;
}

#custom-search-input input {
	border: 0;
	box-shadow: none;
}

#custom-search-input button {
	margin: 2px 0 0 0;
	background: none;
	box-shadow: none;
	border: 0;
	color: #666666;
	padding: 0 8px 0 10px;
	border-left: solid 1px #ccc;
}

#custom-search-input button:hover {
	border: 0;
	box-shadow: none;
	border-left: solid 1px #ccc;
}

#custom-search-input .glyphicon-search {
	font-size: 23px;
}

a:hover {
	color: blue;
	text-decoration: underline;
}

#td div {
	border: 1px groove;
	width: 20%;
	text-align: center;
	display: inline-block;
}

#td img {
	width: 35%;
}
</style>
</head>
<body>
	<nav class="navbar navbar-light bg-light static-top">
		<div class="container">
			<a class="navbar-brand col-md-12" href="main.food"
				style="text-align: center; font-weight: bold; font: 40px sans-serif; padding-left: 230px"><h1>싸피맨의 안전 먹거리 탐방</h1></a>
		</div>
		<% if (session.getAttribute("id") == null){ %>
			<!-- make modal -->
		        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#userLogin" >Login</button>
		        <!-- Modal start -->
		        <div class="modal fade" id="userLogin" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		          <div class="modal-dialog">
		            <div class="modal-content">
		              <div class="modal-header">
		              	<h4 class="modal-title" id="myModalLabel">로그인</h4>
		                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		              </div>
		              <form method="post" action="login.food" class="form-horizontal" role="form">
			          	  <div class="modal-body">
		               		<div class="form-group">
		                 		<label for="inputEmail" class="col-sm-5 control-label">이메일</label>
		                      	<div class="col-sm-10">
		                        	<input type="email" class="form-control" id="inputEmail" placeholder="Email" name="email" >
		                      	</div>
		                      	<div class="form-group">
		                      		<label for="inputPassword" class="col-sm-5 control-label">패스워드</label>
		                      		<div class="col-sm-10">
		                        		<input type="password" class="form-control" id="inputPassword" placeholder="Password" name="password">
		                      		</div>
		                    	</div>
			                 </div>
			              </div>
			              <div class="modal-footer">
			                <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
			                <button type="submit" class="btn btn-primary">로그인</button>
			              </div>
		              </form>
		            </div>
		          </div>
		        </div>
		        <!-- Modal end -->
				
				
				<!-- Sign In Modal Start -->
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#myModal">Sign In</button>
				<!-- Modal start -->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h4 class="modal-title" id="myModalLabel">회원 가입</h4>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">×</span>
								</button>
							</div>
							<form method="post" action="addMember.food" class="form-horizontal" role="form">
							<div class="modal-body">
									<div class="form-group">
										<label for="inputEmail" class="col-sm-5 control-label">이메일</label>
										<div class="col-sm-10">
											<input type="email" class="form-control" id="inputEmail" name="email"
												placeholder="Email">
										</div>
									</div>
									<div class="form-group">
										<label for="inputPassword" class="col-sm-5 control-label">패스워드</label>
										<div class="col-sm-10">
											<input type="password" class="form-control" id="inputPassword" name="password"
												placeholder="Password">
										</div>
									</div>
									<div class="form-group">
										<label for="inputName" class="col-sm-5 control-label">이름</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="inputName" name="name"
												placeholder="Name">
										</div>
									</div>
									<div class="form-group">
										<label for="inputAddress" class="col-sm-5 control-label">주소</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="inputAddress" name="address"
												placeholder="Address">
										</div>
									</div>
									<div class="form-group">
										<label for="inputPhone" class="col-sm-5 control-label">휴대전화번호</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="inputPhone" name="phoneNumber"
												placeholder="PhoneNumber">
										</div>
									</div>
									<div class="form-group">
										<label for="inputAllergy" class="col-sm-5 control-label">알레르기</label>
										<div class="col-sm-10">
											<div class="checkbox">
												<label><input type="checkbox" name="allergy" value="soybean">대두</label>
												<label><input type="checkbox" name="allergy" value="peanut">땅콩</label>
												<label><input type="checkbox" name="allergy" value="milk">우유</label>
												<label><input type="checkbox" name="allergy" value="crap">게</label>
												<label><input type="checkbox" name="allergy" value="shrimp">새우</label>
												<label><input type="checkbox" name="allergy" value="tuna">참치</label>
												<label><input type="checkbox" name="allergy" value="salmon">연어</label>
												<label><input type="checkbox" name="allergy" value="mugwork">쑥</label>
												<label><input type="checkbox" name="allergy" value="beef">소고기</label>
												<label><input type="checkbox" name="allergy" value="chicken">닭고기</label>
												<label><input type="checkbox" name="allergy" value="pork">돼지고기</label>
												<label><input type="checkbox" name="allergy" value="peach">복숭아</label>
												<label><input type="checkbox" name="allergy" value="dandelion">민들레</label>
												<label><input type="checkbox" name="allergy" value="eggwhite">계란흰자</label>
											</div>
										</div>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
										<button type="submit" class="btn btn-primary" id="dataSave">제출</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
				<!-- Modal end -->
		<% } else {	%>
				<a href="logout.food"><button type="button" class="btn btn-primary" data-toggle="modal">Logout</button></a>
		<% } %>
		<!-- make modal -->
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#userSecede" >회원 탈퇴</button>
        <!-- Modal start -->
       <div class="modal fade" id="userSecede" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
         <div class="modal-dialog">
           <div class="modal-content">
             <div class="modal-header">
                 <h4 class="modal-title" id="myModalLabel">회원 탈퇴</h4>
               <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
             </div>
             <div class="modal-body">
               <form method="post" action="deleteMember.food" class="form-horizontal" role="form">
                   <div class="form-group">
                     <label for="inputEmail" class="col-sm-5 control-label">이메일</label>
                     <div class="col-sm-10">
                       <input type="email" class="form-control"id="inputEmail" name="email" placeholder="Email" >
                     </div>
                     <div class="form-group">
                     <label for="inputPassword" class="col-sm-5 control-label">패스워드</label>
                     <div class="col-sm-10">
                       <input type="password" name="password" class="form-control" id="inputPassword" placeholder="Password">
                     </div>
                   </div>
                   <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
                    	<button type="submit" class="btn btn-primary">탈퇴</button>
                    </div>
                   </div>
                 </form>
             </div>
           </div>
         </div>
       </div>
       <!-- Modal end -->
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
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<h2>Custom search field</h2>
				<form method=post action="SearchFoodResult.food" >
					<div id="custom-search-input">
						<div class="input-group col-md-12">
							<input type="text" class="form-control input-lg" id="searchdata" placeholder="Buscar" name="FoodName" />
							<span class="input-group-btn">
								<button class="btn btn-info btn-lg" id="search" type="submit"> 
									<i class="glyphicon glyphicon-search"></i>
								</button>
							</span>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	<!-- Contents -->
	<div id="result"></div>
	<div id="td"></div>
		
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
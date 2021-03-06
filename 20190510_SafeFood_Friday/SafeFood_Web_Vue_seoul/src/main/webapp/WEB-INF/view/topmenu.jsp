<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
nav ul a {
	color: black;
}

.darkbox input, select {
	color: white;
}
</style>
<script type="text/javascript">
	$(function() {
		$('#userinfo').click(function(){
			location.href = 'userInfo.mvc'
		});
		$('#logout').click(function() {
			location.href = 'logout.mvc';
		});
		$('#signup').click(function() {
			location.href = 'signup.mvc';
		});
		$('#search').click(function() {
			location.href = 'search_result.mvc';
		});
		$('#userOut').click(function() {
			location.href = 'userOutReady.mvc';
		});
		
		if('${flag}' == 1){
			alert('로그인에 실패했습니다');
			location.href = 'main.mvc';
		}
		
	
		function login(){
			alert('로그인 후 조회 가능합니다');
		}
	});
</script>
</head>
<body>
	<header>
		<nav class="blackbar">
			<ul>
				<c:if test="${empty user }">
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
											<label for="id" class="form-control-label">ID</label> <input
												type="text" class="form-control" name="id"
												id="login_id">
										</div>
										<div class="form-group">
											<label for="password" class="form-control-label">PASSWORD</label>
											<input type="password" class="form-control" name="password"
												id="login_pw">
										</div>
										<div class="modal-footer">
											<input type="button" value="비밀번호찾기" onclick="location.href='searchPassForm.mvc'">
											<input type="submit" class="btn btn-primary" value="로그인">
											<button type="button" class="btn btn-secondary"
												data-dismiss="modal">Close</button>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</c:if>
				<c:if test="${not empty user }">
					<li><button id="logout">Logout</button></li>
					<li><button id="userinfo">회원정보</button></li>
				</c:if>
			</ul>
		</nav>
		<nav class="logobar">
			<a href="main.mvc"><img class="logo" alt="logo"
				src="img/logo.png"></a>
			<ul>
				<c:if test="${not empty user }">
					<a href="wishList.mvc"><li class="info_eat">예상 섭취 정보</li></a>
				</c:if>
				<c:if test="${empty user }">
					<li class="info_eat">예상 섭취 정보</li>
				</c:if>
				<li class="info_my">
					<c:if test="${not empty user }">
						<a href="eatFoodList.mvc">내 섭취정보</a>
					</c:if>
					<c:if test="${empty user }">
						내 섭취 정보
					</c:if>
				</li>
				<li class="info_best"><a href="bestEatFood.mvc">베스트 섭취정보</a></li>
				<li class="info_item">
					<c:if test="${not empty user }">
						<a href="foodlist.mvc">상품정보</a>
					</c:if>
					<c:if test="${empty user }">
						상품정보
					</c:if>
				</li>
				<li class="announce">
                <c:if test="${not empty user }">
                        <a href="boardList.mvc">공지사항</a>
                </c:if>
                <c:if test="${empty user }">
                      		  공지사항
                </c:if>    
                </li>
			</ul>
		</nav>
	</header>
	<div class="graybox">
		<h3>WHAT WE PROVIDE</h3>
		<h5>건강한 삶을 위한 먹거리 프로젝트</h5>
	</div>
	<div class="darkbox">
		<form action="search_result.mvc" method="get">
			<table>
				<tr>
					<td>검색조건</td>
					<td>검색단어</td>
					<td>&nbsp</td>
				</tr>
				<tr>
					<td><select name="search_opt">
							<option value="name">식품명</option>
							<option value="maker">제조사</option>
							<option value="material">원재료</option>
					</select></td>
					<td><input type="text" name="searchValue"></td>
					
					<c:if test="${not empty user }">
					<td><button id="search" type="submit">검색</button></td>
					</c:if>
				
					<c:if test="${empty user}">
					<td><button id="test" type="reset" onclick="login()">검색</button></td>
					</c:if>
					
				</tr>
			</table>
		</form>
	</div>

</body>
</html>
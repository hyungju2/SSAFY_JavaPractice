<%@ page language="java" contentType="text/html; charset=euc-kr"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.w3c.dom.*"%>
<%@ page import="javax.xml.parsers.*"%>
<%@ page import="java.util.*, java.nio.file.Path, java.nio.file.Paths"%>
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
<!-- Custom fonts for this template -->
<link href="${pageContext.request.contextPath}/view/vendor/fontawesome-free/css/all.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/view/vendor/simple-line-icons/css/simple-line-icons.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic"
	rel="stylesheet" type="text/css">
<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/view/css/landing-page.css" rel="stylesheet">
<script	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
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

#td button {
    margin-left:70px;
    margin-bottom: 20px;
    margin-top: 25px;
    border:none;
    width: 20%;
    height: 20%;
    text-align: center;
    display: inline-block;
    background-color: white;
}

#td img {
	width: 35%;
}
</style>
<%
	//XML 데이터를 호출할 URL
	String url = application.getRealPath("/view/foodInfo.xml");
	String[] fieldNames ={"name", "maker", "material", "image"};
	ArrayList<ArrayList<String>> pubList = new ArrayList<ArrayList<String>>();
	try {
		//XML파싱 준비
		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
		DocumentBuilder b = f.newDocumentBuilder();
		//위에서 구성한 URL을 통해 XMl 파싱 시작
		Document doc = b.parse(url);
		doc.getDocumentElement().normalize();
		
		//서버에서 응답한 XML데이터를 publication(발행문서 1개 해당)태그로 각각 나눔(파라미터로 요청한 size항목의 수만큼)
		NodeList items = doc.getElementsByTagName("food");
		
		//for 루프시작
		for (int i = 0; i < items.getLength(); i++) {
			//i번째 publication 태그를 가져와서
			Node n = items.item(i);
			//노드타입을 체크함, 노드 타입이 엘리먼트가 아닐경우에만 수행
			if (n.getNodeType() != Node.ELEMENT_NODE)
				continue;
			
			Element e = (Element) n;
			ArrayList<String> pub = new ArrayList<String>();
			//for 루프 시작
			for(String name : fieldNames){
				//"id", "title", "userName", "recommendId", "recommendName", "recommendDate", "url"에 해당하는 값을 XML 노드에서 가져옴
				NodeList titleList = e.getElementsByTagName(name);
				Element titleElem = (Element) titleList.item(0);
	
				Node titleNode = titleElem.getChildNodes().item(0);
				// 가져온 XML 값을 맵에 엘리먼트 이름 - 값 쌍으로 넣음
				pub.add(titleNode.getNodeValue());
			}
			//데이터가 전부 들어간 맵을 리스트에 넣고 화면에 뿌릴 준비.
			pubList.add(pub);
		}		
	} catch (Exception e) {
		e.printStackTrace();
	}
	HashMap<String, String> hash = new HashMap<String, String>();
	hash.put("soybean", "대두");
	hash.put("peanut", "땅콩");
	hash.put("milk", "우유");
	hash.put("crap", "게");
	hash.put("shrimp", "새우");
	hash.put("tuna", "참치");
	hash.put("salmon", "연어");
	hash.put("mugwork", "쑥");
	hash.put("beef", "소고기");
	hash.put("chicken", "닭고기");
	hash.put("pork", "돼지고기");
	hash.put("peach", "복숭아");
	hash.put("dandelion", "민들레");
	hash.put("eggwhite", "계란흰자");
%>
</head>
<body>
<!-- Navigation -->
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
				<!-- make modal -->
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
		<!-- Contents -->
		<div id="td">
			<% 	boolean check = false;
				for(ArrayList<String> temp: pubList){				
					if (temp.get(0).contains(request.getParameter("FoodName"))){
						check = true; 
					%>
						<button type="button" data-toggle="modal" id="<%= temp.get(0)%>"  data-target="#<%= temp.get(0)%>m"  >
							<img src= "${pageContext.request.contextPath}/view/<%= temp.get(3)%>"  /><br>
							<%= temp.get(0) %>
							<% if (session.getAttribute("allergy") != null){
									boolean allergyCheck = false;
									StringTokenizer st = new StringTokenizer((String)session.getAttribute("allergy"), " ");
									while(st.hasMoreTokens()){
										String value = st.nextToken();
										if (temp.get(2).contains(hash.get(value))){
											allergyCheck = true;
											break;
										}
									}
								if (allergyCheck){ %>
									<h5 style="color: red;">알러지 제품</h5>
							<% } %>
						</button>
				<%	} 
				} 
			} if (!check){ %>
				<h1 style="text-align: center;">검색 결과가 없습니다.</h1>	
			<% } %>
		</div>
		<div id="addModal">
		 	<% for(ArrayList<String> temp: pubList){ %>
			<div class="modal fade" id="<%= temp.get(0)%>m" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h4 class="modal-title" id="myModalLabel"><%= temp.get(0)%></h4>
							<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						</div>
						<div class="modal-body">
							<img src='${pageContext.request.contextPath}/view/<%= temp.get(3)%>' width="150" height="150" />
							<p><%= temp.get(2) %></p>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">확인</button>
						</div>
					</div>
				</div>
			</div>
			<% } %>
		</div>
		
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<style type="text/css">
	.container{
		text-align: center;
	}
	.container div{
		background-color: #E6E6E6;
		padding: 2px;
	}
</style>
</head>
<%
session.setAttribute("id", null);
session.setAttribute("pass", null);
session.setAttribute("allergy", null);
%>
<body>
	<div class="container">
		<h1>회원 탈퇴되었습니다.</h1>
		<div>
		<a href=main.food>처음으로</a> 
		</div>
	</div>
</body>
</html>
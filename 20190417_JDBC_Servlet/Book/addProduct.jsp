<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>물품추가</h1>
	<form action="addProduct.do" method="post">
		isbn : <input type="text" name="isbn"><br/>
		title : <input type="text" name="title"><br/>
		kind : <input type="text" name="kind"><br/>
		maker : <input type="text" name="maker"><br/>
		price : <input type="text" name="price"><br/>
		<button type="submit">물품추가</button>
	</form>
</body>
</html>
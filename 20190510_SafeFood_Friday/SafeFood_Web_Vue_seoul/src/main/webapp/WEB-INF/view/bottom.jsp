<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.container {
    /* display: inline-block; */
    padding-top: 100px;
}
.row {
    display: flex;
    /* margin-left: 15%; */
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
</style>
</head>
<body>
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
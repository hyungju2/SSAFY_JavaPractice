package com.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		//클라이언트로부터 전송되는 한글 처리
 		request.setCharacterEncoding("euc-kr"); //들어오는 타입을 한글 추가.
 		response.setContentType("text/html;charset=euc-kr");
 		
 		
 		PrintWriter out = response.getWriter();
 		//1.클라이언트가 보낸 데이터 받기
 		String num = request.getParameter("num");
 		String price = request.getParameter("price");
 		String info = request.getParameter("info");

 		
 		RequestDispatcher dispatcher = request.getRequestDispatcher("html/Product.jsp"); //css 적용할 수 있음. jsp로 넘기면 사용하기 쉬움
		dispatcher.forward(request, response); //화면 넘김
 	}

}

package com.ssafy.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.controller.SafeFoodController;
import com.ssafy.util.ContextPath;

@WebFilter("*.mvc")
public class SafeFoodFilter implements Filter {

	SafeFoodController controller;
	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		req.setCharacterEncoding("UTF-8");
		
		// 클라이언트로부터 들어오는 요청을 구분하는 문자열
		// http://localhost:8080/mvc/list.mvc
		String reqString = req.getServletPath();
		if(reqString.equals("/main.mvc")) { //초기화면 요청
			controller.mainPage(req, res);
		} else if(reqString.equals("/foodlist.mvc")) { // 푸드 전체 리스트 화면
			controller.foodlist(req, res);
		} else if(reqString.equals("/search_result.mvc")) { // 푸드 검색(식품명, 제조사, 원재료)
			controller.search(req, res);
		} else if(reqString.equals("/searchFood.mvc")) { // 상품 상제 정보 검색
			controller.searchFoodDetail(req, res);
		} else if(reqString.equals("/signup.mvc")) { // 회원가입
			controller.signup(req, res);
		} else if(reqString.equals("/login.mvc")) { // 로그인
			System.out.println("i'm controller");
			controller.signin(req, res);
		} else if(reqString.equals("/logout.mvc")) { // 로그아웃
			controller.logout(req, res);
		} else if(reqString.equals("/userOutReady.mvc")) { // 회원탈퇴
			controller.userOutReady(req, res);
		} else if(reqString.equals("/userOut.mvc")) { // 회원탈퇴
			controller.userOut(req, res);
		} else if(reqString.equals("/userInfo.mvc")) { // 회원정보
			controller.userInfo(req, res);
		} else if(reqString.equals("/userInfoEdit.mvc")) { // 회원 정보 수정
			controller.userEdit(req, res);
		} else if(reqString.equals("/userInfoEditComplete.mvc")) { // 회원 정보 수정완료
			controller.userEditComplete(req, res);
		} else if(reqString.equals("/userAddFood.mvc")) { // 음식 추가
			controller.userAddFood(req,res);
		} else if(reqString.equals("/searchuser.mvc")) {
			controller.searchUser(req, res);
		} else if(reqString.equals("/myFoodList.mvc")) { // 내가 먹은 음식정보
			controller.userFoodList(req,res);
		} else if(reqString.equals("/userRemoveFood.mvc")) { // 내가 먹은 음식 삭제
			controller.userDeleteFood(req,res);
		} else if(reqString.equals("/userAddFood.mvc")) {
			controller.userAddFood(req, res);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		ContextPath.createInstance(fConfig.getServletContext().getRealPath(""));
		controller = new SafeFoodController();
	}

}

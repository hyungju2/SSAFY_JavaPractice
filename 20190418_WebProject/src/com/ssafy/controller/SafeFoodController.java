package com.ssafy.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.service.FoodService;
import com.ssafy.service.FoodServiceImpl;
import com.ssafy.util.DBDriver;
import com.ssafy.vo.Food;
import com.ssafy.vo.FoodPageBean;
import com.ssafy.vo.User;
import com.ssafy.vo.UserFood;

// FrontController에서 넘어온 요청을 DAO에 넘겨서 작업지시하는 객체
// DAO한테서 받은 결과를 저장하고, JSP로 넘어감 -> forward방식으로 넘어감

public class SafeFoodController {

	private FoodService service;

	public SafeFoodController() {
		service = new FoodServiceImpl();
	}
	public void searchUser(HttpServletRequest req, HttpServletResponse res) {
		String userid = req.getParameter("search_id");
		User user = new User();
	    user = service.searchUser(userid);
		req.setAttribute("user", user.getName());
		RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/user_info.jsp");
		try {
			dispatcher.forward(req, res);
		}catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void searchFoodDetail(HttpServletRequest req, HttpServletResponse res) {
		String code = req.getParameter("code");
		Food food = service.search(Integer.parseInt(code));

		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		if (user != null) { // 로그인 된 상태이면 식품에 포함된 알러지 경고
			String foodAllergy = food.getAllergy();
			String userAllergy = user.getAllergy();
			List<String> contains = service.containAllergy(foodAllergy, userAllergy);
			req.setAttribute("contains", contains);
		}
		req.setAttribute("food", food);
		RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/product_info.jsp");
		try {
			dispatcher.forward(req, res);
			return;
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public void signup(HttpServletRequest req, HttpServletResponse res) {
		String id = req.getParameter("signup_id");
		String password = req.getParameter("signup_pw");
		String name = req.getParameter("signup_name");
		String address = req.getParameter("signup_address");
		String phone = req.getParameter("signup_phone");
		String[] check = req.getParameterValues("check");
		String allergy = String.join(",", check);
		service.addUser(id, password, name, address, phone, allergy);
		mainPage(req, res);
		return;
	}

	public void signin(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("I'm food cont");
		String id = req.getParameter("login_id");
        String password = req.getParameter("login_pw");
       
        User user = new User();
        user = service.signIn(id, password);
        
        if (user.getId()!=null) {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            foodlist(req, res);
        } else {
            mainPage(req, res);
        }
        
        
        return;
	}

	public void logout(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		session.invalidate();
		mainPage(req, res);
		return;
	}

	public void userOutReady(HttpServletRequest req, HttpServletResponse res) {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/userOut.jsp");
		try {
			dispatcher.forward(req, res);
			return;
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	public void userOut(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		String password = req.getParameter("out_passwd");
		if (password.equals(user.getPassword())) {
			session.invalidate();
			service.deleteUser(user);
			mainPage(req, res);
		} else {
			req.setAttribute("error", "비밀번호를 제대로 입력해주세요!");
			userOutReady(req, res);
		}
		return;
	}

	// 회원정보조회
	public void userInfo(HttpServletRequest req, HttpServletResponse res) {
		RequestDispatcher dispathcer = req.getRequestDispatcher("/jsp/userInfo.jsp");
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		String id = user.getId();
		user = service.searchUser(id);
		session.setAttribute("user", user);
		try {
			dispathcer.forward(req, res);
			return;
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	// 회원 정보 수정
	public void userEdit(HttpServletRequest req, HttpServletResponse res) {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/userInfoEdit.jsp");
		try {
			dispatcher.forward(req, res);
			return;
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	public void userEditComplete(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		String id = user.getId();
		String password = req.getParameter("signup_pw");
		String passwords = req.getParameter("signup_pw2");
		if (!password.equals(passwords)) {
			req.setAttribute("errorInfo", "비밀번호가 틀렸습니다!");
			userEdit(req, res);
			return;
		}
		
		String name = req.getParameter("signup_name");
		String address = req.getParameter("signup_address");
		String phone = req.getParameter("signup_phone");
		String[] check = req.getParameterValues("check");
		String allergy = String.join(",", check);
		service.modifyUser(id, password, name, address, phone, allergy);
		mainPage(req, res);
		return;
	}	

	// 메인 페이지 화면
	public void mainPage(HttpServletRequest req, HttpServletResponse res) {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/main.jsp");
		try {
			dispatcher.forward(req, res);
			return;
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	// 푸드 전체 리스트 화면
	public void foodlist(HttpServletRequest req, HttpServletResponse res) {
		List<Food> list = service.getFoods();
		req.setAttribute("list", list);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/foodlist.jsp");

		try {
			dispatcher.forward(req, res);
			return;
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	// key로 푸드 검색 (이름, 제조사, 원재료)
	public void search(HttpServletRequest req, HttpServletResponse res) {
		String key = req.getParameter("search_opt");
		String searchValue = req.getParameter("searchValue");
		FoodPageBean bean = new FoodPageBean(key, searchValue, "1", 1);
		List<Food> list = null;

		list = service.searchAll(bean);

		req.setAttribute("list", list);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/search_result.jsp");
		try {
			dispatcher.forward(req, res);
			return;
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	public void userFoodList(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		List<UserFood> foodlist = service.showUserFood(user);
		req.setAttribute("foodlist", foodlist);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/MyEat.jsp");
		try {
			dispatcher.forward(req, res);
			return;
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void userAddFood(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		int amount = Integer.parseInt(req.getParameter("amount"));
		int foodCode = Integer.parseInt(req.getParameter("foodCode"));
		service.addUserFood(user,amount, foodCode);
		userFoodList(req, res);
	}

	public void userDeleteFood(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		int foodCode = Integer.parseInt(req.getParameter("foodCode"));
		service.deleteUserFood(user, foodCode);
		userFoodList(req, res);
	
	}

}

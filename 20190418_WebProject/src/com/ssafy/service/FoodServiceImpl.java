package com.ssafy.service;

import java.util.List;

import com.ssafy.dao.FoodDao;
import com.ssafy.dao.FoodDaoImpl;
import com.ssafy.dao.UserDao;
import com.ssafy.dao.UserDaoImpl;
import com.ssafy.dao.UserFoodDao;
import com.ssafy.dao.UserFoodDaoImpl;
import com.ssafy.vo.Food;
import com.ssafy.vo.FoodPageBean;
import com.ssafy.vo.User;
import com.ssafy.vo.UserFood;

public class FoodServiceImpl implements FoodService {
	private FoodDao dao;
	private UserDao userDao;
	private UserFoodDao userFoodDao;
	
	private String[] allergys = { "대두", "땅콩", "우유", "게", "새우", "참치", "연어", "쑥", "소고기", "닭고기", "돼지고기", "복숭아", "민들레",
			"계란흰자" };

	public FoodServiceImpl() {
		dao = new FoodDaoImpl();
		userDao = new UserDaoImpl();
		userFoodDao = new UserFoodDaoImpl();
	}

	public List<Food> searchAll(FoodPageBean bean) {
		return dao.searchAll(bean);
	}

	public List<Food> getFoods() {
		return dao.getFoods();
	}

	public Food search(int code) {
		// code에 맞는 식품 정보를 검색하고, 검색된 식품의 원재료에 알레르기 성분이 있는지 확인하여 Food 정보에 입력한다.
		Food target = new Food();
		target = dao.search(code);
		String allergyList = "";
		for (String allergy : allergys) {
			if (target.getMaterial().contains(allergy)) { // 알러지 있으면 //원재료에 검색
				allergyList += allergy + " ";
			}
		}
		target.setAllergy(allergyList);

		return target;
	}

	public List<Food> searchBest() {
		return dao.searchBest();
	}

	public List<Food> searchBestIndex() {
		return dao.searchBestIndex();
	}

	public void addUser(String id, String password, String name, String address, String phone, String allergy) {
		User user = new User(id, password, name, address, phone, allergy);
		userDao.signUp(user);
	}

	public void modifyUser(String id, String password, String name, String address, String phone, String allergy) {
		userDao.modify(id, password, name, address, phone, allergy);
	}

	public User signIn(String id, String password) {
		User user = userDao.signIn(id, password);
		System.out.println("I;m food");
		if (user.getId() != null)
			return user;
		else
			return null;
	}

	public User searchUser(String id) {
		User user = userDao.searchUser(id);
		return user;

	}
	public boolean deleteUser(User user) {
		User result = userDao.searchID(user.getId());
		if (result.getPassword().equals(user.getPassword())) {
			userDao.delete(user);
			return true;
		}
		return false;
	}
	
	@Override
	public List<String> containAllergy(String foodAllergy, String userAllergy) {
		return dao.containAllergy(foodAllergy, userAllergy);
	}
	
	public List<UserFood> showUserFood(User user) {
		return userFoodDao.showUserFood(user);
	}
	
	public void addUserFood(User user, int amount, int foodCode) {
		userFoodDao.addUserFood(user, amount, foodCode);
	}
	
	public void deleteUserFood(User user, int foodCode) {
		userFoodDao.removeUserFood(user, foodCode);
	}

	public static void main(String[] args) {
		FoodDaoImpl dao = new FoodDaoImpl();
		FoodServiceImpl fsi = new FoodServiceImpl();
		fsi.dao = dao;
		System.out.println(fsi.search(2).getAllergy());
	}

	public static void print(List<Food> foods) {
		for (Food food : foods) {
			System.out.println(food);
		}
	}
}

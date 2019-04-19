package com.ssafy.service;

import java.util.List;

import com.ssafy.vo.Food;
import com.ssafy.vo.FoodPageBean;
import com.ssafy.vo.User;
import com.ssafy.vo.UserFood;

public interface FoodService {

	public List<Food> searchAll(FoodPageBean bean);

	public Food search(int code);
	
	public List<Food> getFoods();

	public List<Food> searchBest();

	public List<Food> searchBestIndex();

	public void addUser(String id, String password, String name, String address, String phone, String allergy);

	public User signIn(String id, String password);

	public List<String> containAllergy(String foodAllergy, String userAllergy);

	public void modifyUser(String id, String password, String name, String address, String phone, String allergy);
	
	public User searchUser(String id);

	public List<UserFood> showUserFood(User user);
	
	public void addUserFood(User user, int amount, int foodCode);

	public void deleteUserFood(User user, int foodCode);

	public boolean deleteUser(User user);
}

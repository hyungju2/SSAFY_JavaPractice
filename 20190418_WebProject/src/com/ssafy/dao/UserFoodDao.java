package com.ssafy.dao;

import java.util.List;

import com.ssafy.vo.Food;
import com.ssafy.vo.User;
import com.ssafy.vo.UserFood;

public interface UserFoodDao {
	
	public List<UserFood> showUserFood(User user);
	
	public void addUserFood(User user, int amount, int foodCode);
	
	public void modifyUserFood(User user, int amount, int foodCode);

	public void removeUserFood(User user, int foodCode);
	
	
}

package com.ssafy.vo;

public class UserFood {
	private String userId;
	private int foodCode;
	private int amount;
	private String foodName;
	private String foodImg;

	public UserFood() {
		super();
	}

	public UserFood(String userId, int foodCode, int amount, String foodName, String foodImg) {
		this.userId = userId;
		this.foodCode = foodCode;
		this.amount = amount;
		this.foodName = foodName;
		this.foodImg = foodImg;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getFoodCode() {
		return foodCode;
	}

	public void setFoodCode(int foodCode) {
		this.foodCode = foodCode;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getFoodImg() {
		return foodImg;
	}

	public void setFoodImg(String foodImg) {
		this.foodImg = foodImg;
	}

	@Override
	public String toString() {
		return "MyFood [userId=" + userId + ", foodCode=" + foodCode + ", amount=" + amount + ", foodName=" + foodName
				+ ", foodImg=" + foodImg + "]";
	}

}

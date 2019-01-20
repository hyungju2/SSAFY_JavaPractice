package DigitalPlaza;

public class User {
	private String userId;
	private String userName;
	private int userNum;
	private int userPhone;

	public User(String userId, String userName, int userNum, int userPhone) {
		this.userId = userId;
		this.userName = userName;
		this.userNum = userNum;
		this.userPhone = userPhone;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userNum=" + userNum + ", userPhone=" + userPhone
				+ "]";
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	public int getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(int userPhone) {
		this.userPhone = userPhone;
	}
	
}

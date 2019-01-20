package Movie;

public class User extends Movie {
	


	private String Name;
	private int PhoneNum;
	
	public String getName() {
		return Name;
	}
	public User(String name, int phoneNum) {
		super();
		Name = name;
		PhoneNum = phoneNum;
	}
	
	public void setName(String name) {
		Name = name;
	}
	public int getPhoneNum() {
		return PhoneNum;
	}
	public void setPhoneNum(int phoneNum) {
		PhoneNum = phoneNum;
	}

	

	public String toString() {
		return "User [Name=" + Name + ", PhoneNum=" + PhoneNum + "]";
	}

}

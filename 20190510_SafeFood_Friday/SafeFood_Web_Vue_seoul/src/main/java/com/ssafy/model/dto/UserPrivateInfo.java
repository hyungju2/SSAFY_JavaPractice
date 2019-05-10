package com.ssafy.model.dto;

public class UserPrivateInfo {
	private String id="";
	private String gender="";
	private String height="";
	private String weight="";
	private String age="";
	private String checkActivity="";
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getCheckActivity() {
		return checkActivity;
	}
	public void setCheckActivity(String checkActivity) {
		this.checkActivity = checkActivity;
	}
	@Override
	public String toString() {
		return "UserPrivateInfo [id=" + id + ", gender=" + gender + ", height=" + height + ", weight=" + weight
				+ ", age=" + age + ", checkActivity=" + checkActivity + "]";
	}
}

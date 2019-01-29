package com.gson;
//VO : 항상 데이터는 private으로
public class Person {
	private int num;
	private String name;
	private String address;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Person [num=" + num + ", name=" + name + ", address=" + address + "]";
	}
	public Person() {
		
	}
	public Person(int num, String name, String address) {
		this.num = num;
		this.name = name;
		this.address = address;
	}
	
}
package com.vo;
/**
 * VO 객체
 * Getter/Setter, toString 구현 
 * 테이블의 컬럼명과 필드명을 동일하게 만들어주는 것이 편리하다.
 * 데이터베이스명, id/pw, 테이블명, 테이블 생성(컬럼명, 타입) autoIncreament도 맞춰서 설정해줘야 한다.
 * 
 * 
 */
public class Car {
	private int id;
	private String name;
	private String manufacture;
	private int price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getManufacture() {
		return manufacture;
	}
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + ", manufacture=" + manufacture + ", price=" + price + "]";
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}

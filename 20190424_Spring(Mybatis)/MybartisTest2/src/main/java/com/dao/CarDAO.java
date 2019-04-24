package com.dao;

import java.util.List;

import com.vo.Car;


/**
 * PersonMapper에 있는 쿼리 정보와 1:1 매칭하는 짝꿍 클래스
 * 
 */
public interface CarDAO {
	public int insert(Car car);
	public void update(Car car);
	public void delete(int id);
	public List<Car> selectAll(); 
	public Car select(int id); //하나의 값만 조회
	public Car selectName(String name);
	public List<Car> selectPrice(int price);
}

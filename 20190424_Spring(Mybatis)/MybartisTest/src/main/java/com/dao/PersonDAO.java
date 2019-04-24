package com.dao;

import java.util.List;

import com.vo.Person;

/**
 * PersonMapper에 있는 쿼리 정보와 1:1 매칭하는 짝꿍 클래스
 * 
 */
public interface PersonDAO {
	public int insert(Person person);
	public void update(Person person);
	public void delete(int id);
	public List<Person> selectAll(); 
	public Person select(int id); //하나의 값만 조회
	public Person selectName(String name);
}

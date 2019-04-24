package com.main;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dao.CarDAO;
import com.mybatis.MybatisConnectionFactory;
import com.vo.Car;

public class Test {
	public static void main(String[] args) {
		//1. 세션연결
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSessionFactory().openSession(true);
		//true면 Auto commit, false면 Manual commit
		
		// 수동으로 commit을 하려면, 1. config.xml 파일에서 <transactionManager type="JDBC"> 수동커밋
		// openSession(false); 로 했을 경우에 수동으로 commit이 된다.
		
		//2. Mapper 연결(인터페이스)
		CarDAO carDAO = sqlSession.getMapper(CarDAO.class);

		//3. Query 실행
//		Car c = new Car();
//		c.setName("super");
//		c.setManufacture("audi");
//		c.setPrice(100000000);
//		carDAO.insert(c);
//		
		List<Car> list = carDAO.selectPrice(20000000);
		for(Car temp : list)
			System.out.println(temp);

		//carDAO.delete(1);
		//수동 commit일 경우 : 트랜잭션 관리기능 : 저장 commit / 취소 rollback
		//sqlSession.rollback(); //취소해라
		sqlSession.commit();
		//4. 트랜잭션 처리

	}//end of main
}//end of class

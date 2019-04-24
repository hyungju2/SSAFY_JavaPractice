package com.main;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dao.PersonDAO;
import com.mybatis.MybatisConnectionFactory;
import com.vo.Person;

public class Test {
	public static void main(String[] args) {
		//1. 세션연결
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSessionFactory().openSession(true);
		//true면 Auto commit, false면 Manual commit
		
		// 수동으로 commit을 하려면, 1. config.xml 파일에서 <transactionManager type="JDBC"> 수동커밋
		// openSession(false); 로 했을 경우에 수동으로 commit이 된다.
		
		//2. Mapper 연결(인터페이스)
		PersonDAO personDAO = sqlSession.getMapper(PersonDAO.class);

		//3. Query 실행
		
//		// selectAll
//		List<Person> plist = personDAO.selectAll();
//		System.out.println("id/tname");
//		System.out.println("=======================");
//		for(Person p : plist) {
//			System.out.println(p.getId()+"\t"+p.getName());
//		}
//		
//		Person p = personDAO.select(6);
//		System.out.println(p);
//		
//		//insert
//		Person p2 = new Person();
//		p2.setName("손흥민"); //id를 지정하지 않았지만, auto increment 값
//		personDAO.insert(p2);
//		
//		//update
//		p2.setId(3);
//		p2.setName("슈퍼콘");
//		personDAO.update(p2);
//		//delete
//		personDAO.delete(2);
//		
		Person p  =personDAO.selectName("슈퍼콘");
		System.out.println(p);
		//수동 commit일 경우 : 트랜잭션 관리기능 : 저장 commit / 취소 rollback
		//sqlSession.rollback(); //취소해라
		sqlSession.commit();
		//4. 트랜잭션 처리

	}//end of main
}//end of class

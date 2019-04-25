package dao;
/**
 * 세션의 객체는 우리가 만들지 않음, 알아서 채워줌
 * 데이터베이스와 연동하는 작업만 진행
 *
 */

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mysql.cj.xdevapi.SessionFactory;

import model.Product;

@Component
public class ProductDAO {
	@Autowired // 일치하는 타입을 찾아서 객체에 담아준다
	private SqlSessionFactory sessionFactory;

	// 테이블에서 code 값을 기준으로 데이터를 조회하는 메서드
	public Product selectOne(int code) {
		// sql 작업을 위한 세션을 얻어온다.
		// 가능한 작업 후에 세션을 닫아주어야 함.
		SqlSession session = sessionFactory.openSession(); // false
		try {
			Product p = session.selectOne("dao.mapper.productMapper.selectOne", code);
			return p;
		} finally {
			session.close();
		}
	}
	
	public List<Product> selectAll() {
		// sql 작업을 위한 세션을 얻어온다.
		// 가능한 작업 후에 세션을 닫아주어야 함.
		SqlSession session = sessionFactory.openSession(); // false
		try {
			List<Product> list = session.selectList("dao.mapper.productMapper.selectAll");
			return list;
		} finally {
			session.close();
		}
	}
	
	public void insert(Product p) {
		SqlSession session = sessionFactory.openSession(); // false
		try {
			session.insert("dao.mapper.productMapper.insert",p);
			return ;
		} finally {
			session.close();
		}
	}
	
	public void delete(int code) {
		SqlSession session = sessionFactory.openSession(); // false
		try {
			session.delete("dao.mapper.productMapper.delete",code);
			return ;
		} finally {
			session.close();
		}
	}
	
	public void update(Product p) {
		SqlSession session = sessionFactory.openSession(); // false
		try {
			System.out.println("gdgd"+p.toString());
			session.update("dao.mapper.productMapper.update",p);
			return ;
		} finally {
			session.close();
		}
	}
	
}

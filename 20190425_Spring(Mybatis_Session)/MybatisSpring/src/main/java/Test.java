import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import dao.ProductDAO;
import model.Product;

/**
 *	src 폴더 : 프로젝트의 클레스들의 루트, 같은 class path를 가짐.
 *	src/main/java			자바
 *	src/main/resources		xml, 이미지...
 *	src/test/java			테스트용
 *	폴더구조 : 종류별로 구분할 수 있도록 분류
 *	클래스의 경로 : "oo.oo.클래스명" 하위폴더를  . 으로 구분
 *	xml의 경로 : "oo/oo/oo.xml" 하위폴더를 /로 구분
 *
 *	Mybatis + Spring 연동
 *	1. 자바코드로부터 SQL문을 분리
 *  2. 'id=? and name=?'파라미터, ResultSet 결과값 매핑을 편리하게 해줌.
 *  3. SqlSession 로 Connection 관리 + 트랜젝션관리
 *  4. 객체관리 컨테이너 
 *  
 *  해야 할 작업
 *  pom.xml에 디펜던시 추가(필요한 라이브러리 설치)
 *  Spring Core(이미 있음), Spring context(이미 있음), Spring jdbc(o)
 *  Mybatis(o), MybatisSpring(o)
 *  Mysql(o)
 *	
 *
 *	ApplicationContext.xml 데이터베이스 정보, Alias, Mapperfile 위치
 *						   빈객체 관리하고 싶은 패키지를 스캔
 *						  SqlSessionFactoryBean 등록
 *						  SqlSessionTemplate 등록
 
	dao.mapper productMapper.xml 작성, SQL 저장해놓음.
	model에 VO 객체 Product 클래스를 등록
	dao 패키지에서 ProductDAO 작성
		@Autowired 로 일치하는 객체 SqlSessionFactory 를 변수로 가져옴.
 *
 */
public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("ApplicationContext.xml");
		ProductDAO dao = context.getBean("productDAO",ProductDAO.class);

		
		Product temp = new Product();
		temp.setCode(2);
		temp.setDescription("temp");
		temp.setName("temp");
		temp.setPictureurl("temp");
		temp.setPrice(5000);
		//dao.insert(temp);
		dao.update(temp);
		
		
		
	}//end of main
}//end of class

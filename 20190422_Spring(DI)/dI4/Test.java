package dI4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		// xml 설정파일을 작성
		// 자바코드에서xml 설정파일을 매개로 해서
		// ApplicationContext 객체를 생성
		// 컨테이너 객체로부터 bean 객체 얻어다 쓰기
		
		//Car c = new Car(); 객체 생성을 스프링이 대신해준다.
		ApplicationContext context = new GenericXmlApplicationContext("dI4/ApplicationContext.xml");
		//Car c = (Car) context.getBean("c"); //변수명을 통해 가져움.
		Car c = context.getBean("c",Car.class); //지정한 클래스 정보를 함께 넘겨줌
		c.drive();
		
		Car c2 = context.getBean("c",Car.class); //싱글톤 적용
		c2.drive();
		System.out.println(c==c2); //기본적으로 싱글톤을 제공하는 것을 알 수 있다.  주소가 같음.
	}//end of main
} //end of class
// 스프링 컨테이너의 기존 객체관리 정책
// 컨테이너 생성시 자신이 포함할 Bean 객체를 모두 생성
// 컨테이너 제거될 때 관리하는 Bean 객체를 모두 제거하고 종료됨.

/**
 BeanFactory : 객체 생성과 검색에 대한 기능을 정의, 싱글톤/프로토타입의 Bean인지 여부를 확인하는 기능
 |
 ApplicationContext : 메시지, 이벤트 환경변수 처리 기능.
 |
 GenericXmlApplictionContext, AnnotationConfigApplicationContext, GenericGroovyApplicationContext
 xml 로부터 설정정보를 가져옴,   Java annotation을 이용하여 클래스로부터 정보를 가져옴. 그루비 코드를 이용해서 정보를 가져옴.
 */

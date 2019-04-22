package dI4_1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * dI4 => dI4_1 
 *  
 *
 */
public class Test {
	public static void main(String[] args) {
	
		ApplicationContext context = new GenericXmlApplicationContext("dI4_1/ApplicationContext.xml");
		Car c = context.getBean("c",Car.class); //지정한 클래스 정보를 함께 넘겨줌
		c.drive();
		//컨테이너를 닫으면, Bean 객체가 소멸한다.
		
		//ApplicationContext는 close 함수가 없으므로, 형변환을 시켜주어서 종료한다.
		((GenericXmlApplicationContext)context).close();
		
	}//end of main
} //end of class



package dI5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * dI2 => dI5
 * 스프링 설정파일 객체간의 의존관계를 모두 설정
 *
 */
public class Test {
	
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("di5/ApplicationContext.xml");
		Car c = context.getBean("car",Car.class);
		c.drive();
		
		
	}//end of main
} //end of class

// 소스코드의 의존성이 들어가는 코드를 모두 제거하고,
// 의존성이 꼭 들어가야하는 코드는 한곳에 몰아 놓음 (스프링 컨테이너)
// IoC -> 제어의 역전
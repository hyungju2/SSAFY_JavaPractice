package dI6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * 
 * dI3(설정자) => dI6 사용.
 *  
 */

public class Test {
	
	public static void main(String[] args) {

// 객체를 만들거나 setter 메서드로 주입시키는 작업은 스프링컨테이너에서 모두 진행 완료

		ApplicationContext context = new GenericXmlApplicationContext("dI6/ApplicationContext.xml");
		Car c = context.getBean("car", Car.class);
		c.drive();
		//설정 파일에Bean 등록, 객체, setter 메서드로 자동 주입받음.
	}//end of main
} //end of class


package dI9;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

//의존성을 걷어내기 위해서 인터페이스를 사용하자.

public class Test {
	
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("dI9/ApplicationContext.xml");
		Car c = context.getBean("car",Car.class);
		c.drive();
	}//end of main
} //end of class
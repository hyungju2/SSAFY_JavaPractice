package dI7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		
		ApplicationContext context = new GenericXmlApplicationContext("di7/ApplicationContext.xml");
		Car c= context.getBean("c", Car.class);
		
		c.drive();
		((GenericXmlApplicationContext)context).close();
	}//end of main
} //end of class

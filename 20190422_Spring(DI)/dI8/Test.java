package dI8;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import dI8.Car;

public class Test {
	
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("dI8/ApplicationContext.xml");
		Car c = context.getBean("car",Car.class);
		c.drive();
	}//end of main
} //end of class

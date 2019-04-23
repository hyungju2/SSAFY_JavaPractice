package aop5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 *	AOP(Aspect-Oriented Programming) : 관점에 따라 구분
 *	핵심 관심사항
 *	공통 관심사항
 *	OOP 단점을 보완 : AOP를 통해서 핵심 관심사항과 공통 관심사항을 분리해서 구현
 *  
 *  공통 관심사항 적용할 코드 + 적용 지점 
 *	Pointcut - AOP 구성을 위해서 지정한 시점
 *	Aspect : AOP 구현체
 *	
 */
public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("aop5/ApplicationContext.xml"); //xml에서 가져올 때는 GenericXml
		IPerson boy = context.getBean("boy", IPerson.class);
		try {
			boy.doSomething();
		} catch (Exception e) {
		}
	
	}//end of main
}

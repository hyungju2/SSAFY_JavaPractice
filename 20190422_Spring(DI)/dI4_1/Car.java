package dI4_1;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Car implements InitializingBean, DisposableBean{
//	private KoreaTire tire;
	private ChinaTire tire;
	public Car() {
		tire = new ChinaTire();
		System.out.println("car 생성자");
	}
	public void drive() {
		System.out.println(tire.getName()+"로 굴러가는 자동차 dI4_1=> applicationContext.xml에 Bean설정");
	}
	
	public void myinitMethod() {
		System.out.println(" xml을 사용하여 객체 초기화시 호출 ");
	}
	
	public void mydestoryMethod() {
		System.out.println(" xml을 사용하여 객체 소멸될 때 호출 ");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		//초기화시 불리는 call back 메서드
		System.out.println(" 인터페이스를 이용하여 얘도 초기화시 호출됨");
	}
	@Override
	public void destroy() throws Exception {
		System.out.println(" 인터페이스를 이용하여 얘도 소멸될 때 호출됨");
	}
	
}

// 초기화 소멸 메서드 지정하는 방법
// 1. xml Bean 등록시 설정
// 2. 인터페이스 구현하는 방법 : InitializingBean, DesposibleBean이 먼저 호출된다. xml을 사용하지 않아도 된다.
// 3. 어노테이션 이용 방법
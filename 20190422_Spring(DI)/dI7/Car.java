package dI7;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component("c") //이 어노테이션이 붙어있는 class는 Bean으로 등록된다. ""안의 값은 ID값을 의미
				// 지정하지 않으면, "car" 클래스명의 첫글자를 소문자로 바꾼 이름이 아이디가 된다.

public class Car {
	private ChinaTire tire;
	public Car() {
		tire = new ChinaTire();
	}
	public void drive() {
		System.out.println(tire.getName()+"로 굴러가는 자동차 dI7");
	}
	
	@PostConstruct
	public void myinit() {
		System.out.println("초기화 메서드...");
	}
	
	@PreDestroy
	public void mydestory() {
		System.out.println("소멸 함수...");
	}
}

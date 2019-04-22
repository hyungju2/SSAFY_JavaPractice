package dI8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class Car {
	private Tire tire; //다형성: 부모의 참조변수에 자식의 객체를 저장할 수 있는 성질.
	
	@Autowired // 객체를 만들 때 필요한 매개변수를 타입에 맞는 것을 찾아서 알아서 지정해줌.
	// 필요한 타입이랑 맞는 타입의 Bean이 등록되지 않았을 때, NoSuchBeanDefinitionException 발생
	// 두개 있어도 Error!
	public Car(Tire t) {
		tire = t;
	}
	
	public void drive() {
		System.out.println(tire.getName()+"로 굴러가는 자동차 dI8");
	}
}

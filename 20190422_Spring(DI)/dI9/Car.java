package dI9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {
	private Tire tire; //다형성: 부모의 참조변수에 자식의 객체를 저장할 수 있는 성질.
	
	@Autowired//알아서 매개변수 찾아줌. setter 앞에 필요한 객체를 알아서 주입해라.
	//false로 해두면 못찾더라도 실행. @Autowired(required=false) 
	//맞는 타입을 찾지 못했다면, Exception
	// Nounique : 맞는 타입의 빈 객체가 두개 이상일 때, 원하는 객체를 지정.

	@Qualifier("koreaTire") //매칭되는 타입의 Bean이 여러개 있을 때
	
	//매칭되는 타입의 Bean이 두개 이상이지만, @Qualifier 없을 때, setter의 매개변수명과 같은 id가 있으면 Bean객체를 사용한다.
	//Qualifier이 가장 많이 사용된다.
	
	public void setTire(Tire t) { // setter로 주입받기
		tire = t; // properrty injection, 이 방법을 조금 더 선호.
	}
	
	public void drive() {
		System.out.println(tire.getName()+"로 굴러가는 자동차 dI9");
	}
}
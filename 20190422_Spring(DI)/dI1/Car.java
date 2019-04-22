package dI1;

public class Car {
//	private KoreaTire tire;
	private ChinaTire tire;
	public Car() {
		//tire = new KoreaTire();
		tire = new ChinaTire();
	}
	public void drive() {
		System.out.println(tire.getName()+"로 굴러가는 자동차 dI1");
	}
}

//의존성 -> 무언가를 하나 바꿔야 한다면, 다 바꿔주어야 함.
//의존성을 걷어내기 위해서 타입, 객체 생성 코드를 걷어내야한다.
//타입 걷어내기 - 인터페이스를 사용.(느슨한 결합)
//객체생성은 직접 안만들고 매개변수로 받기(생성자, Setter 매서드)

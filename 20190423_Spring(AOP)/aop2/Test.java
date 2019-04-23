package aop2;

public class Test {
	public static void main(String[] args) {
//		boy.doSomething(); 직접 호출하는 것이 아닌 대행자를 이용.
		Boy boy = new Boy();
		Girl girl = new Girl();
		PersonProxy proxy = new PersonProxy();
		proxy.setPerson(girl);
		proxy.doSomething();
	}
}
// 1. 원하는 기능의 원형을 가지는 인터페이스를 정의
// 2. 인터페이스를 구현해서 원하는 실제 기능을 작성
// 3. 1의 객체 기능을 호출하는 클래스를 대행자를 만든다
package aop2;
//3. 1의 객체 기능을 호출하는 클래스를 대행자를 만든다
public class PersonProxy implements IPerson{

	private IPerson person;
	
	public void setPerson(IPerson person) {
		this.person = person;
	}
	
	@Override
	public void doSomething() {
		System.out.println("문을 열고 집에 들어간다");
		try {
			System.out.println("불을 끄고 잔다");
			person.doSomething();
		} catch (Exception e) {
			System.out.println("119에 신고한다.");

		} finally {
			System.out.println("문을 열고 나온다");
		}
	}
	
}

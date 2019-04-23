package aop4;
/**
 * aop1 => aop2 복붙 
 *
 */
// 2. 인터페이스를 구현해서 원하는 실제 기능을 작성.
public class Girl implements IPerson{
	public String doSomething() {
		System.out.println("드라마를 본다");
		return "I'm a girl";
	}
}

package aop4;

import org.aspectj.lang.JoinPoint;

/**
 * 각각의 공통 관심사항을 시점별로 함수로 나눠서 구현하기
 *
 */

public class MyAspect {
	public void doBefore(JoinPoint pt) { //핵심 관심사항 실행 전
		//일반 메소드도 실행할 때
		Object o = pt.getTarget();
		if(o instanceof Boy) {
			Boy b=(Boy)o;
			b.hello(); //Boy 객체로 들어왔을 경우.
		}
		System.out.println("문을 열고 집에 들어감");
	}
	// 핵심 관심사항 실행
	public void doAfterReturning(String rt){ //핵심 관심사항 정상 실행 후, 매개변수가 있을 때 리턴값을 받을 수 있다.
		System.out.println("불끄고 잔다");
	}
	
	public void doAfterThrowing(Throwable th) { //핵심 실행 예외발생, 예외발생시점의 객체를 매개변수로 등록
		System.out.println(th.getMessage() +" : 119에 신고한다");
	}
	
	public void doAfter() { // finally
		System.out.println("문을 열고 나온다");
	}
}

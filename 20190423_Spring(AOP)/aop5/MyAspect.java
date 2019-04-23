package aop5;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 각각의 공통 관심사항을 시점별로 함수로 나눠서 구현하기
 *
 */

public class MyAspect {
	public void doAround(ProceedingJoinPoint pt) {
		// around 적용 시점 핵심관심 사항 실행 전, 후, 에러, 마지막 항상
		System.out.println("문을 열고 집에 들어감");
		try {
			String str = (String)pt.proceed();
			System.out.println("불 끄고 잔다, 리턴값 : "+str);
		} catch (Throwable e) {
			System.out.println(e.getMessage() + "119에 신고한다");
		} finally { // 핵심 관심사항 실행
			System.out.println("문을 열고 나온다");
		}
	}
}

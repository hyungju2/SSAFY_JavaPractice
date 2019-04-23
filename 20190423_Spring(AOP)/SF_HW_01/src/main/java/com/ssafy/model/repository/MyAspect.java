package com.ssafy.model.repository;

public class MyAspect {
	public void doBefore() {
		System.out.println("시작함");
	}
	// 핵심 관심사항 실행
	public void doAfterReturning(String rt){ //핵심 관심사항 정상 실행 후, 매개변수가 있을 때 리턴값을 받을 수 있다.
		System.out.println("시작 후");
	}
	public void doAfter() { // finally
		System.out.println("끝낸다");
	}
}

/**
	싱글톤의 조건 꼭 알아둘 것. 
	1. field static,2. 생성자 private,3. 객체 생성 메소드 static
 *  SingleTon Pattern : 메모리 상에서 생성된 객체가 하나임을 보장하는 디자인 패턴
 */

package com.singleton;

import com.basic.MainTest;

public class SingletonObject {

	private static SingletonObject instance; //field의 값은 static으로.
	
	private SingletonObject() {} //생성자의 수식어는 private. 즉, 클래스 외부에서는 사용 불가능.
	
	public static SingletonObject getInstance() { //생성 메소드는 static. getInstance는 Singleton의 대표.
		if(instance==null)
		{
			instance = new SingletonObject(); //private으로 선언된 instance는 내부에서만 생성가능.
		}
		return instance;
	}

	public void test() {
		System.out.println("hello");
	}
}

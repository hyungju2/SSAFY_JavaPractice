/**
 * 
 */
package com.singleton;

public class SingletonTest {
	
	
	public static void main(String[] args) {
		SingletonObject s1 = SingletonObject.getInstance(); //클래스 외부에서 사용할 떄. new로 사용할 수는 없음.
		SingletonObject s2 = SingletonObject.getInstance(); //singleton이기에, 두 번 생성해도 주소값은 같음.
		
		System.out.println(s1==s2);
		
	}
}

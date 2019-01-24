package com.basic;

final class Test{
	
}//클래스가 final이면 상속이 안된다. 메소드가 final이 아니여도, 오버라이딩 불가함.

class Test2{
	final void go() {} //메소드에 final이 붙어있으면 재정의 안됨. 메소드만 final이므로, 클래스 자체는 상속이 가능하다.
	void stop() {}
}

public class FinalTest extends Test2 {
	
	final static int x = 90; //Final필드는 값 변경이 안됨.
	
	public static void main(String[] args) {
		FinalTest t = new FinalTest();
		//static으로 선언된 곳에서 this나 super를 사용할 수 없는 이유는 시차때문. static이 먼저 시작됨.
		
			
	}//end of main
}//end of class

package com.exception;
//사용자 정의 예외 클래스: Exception 클래스를 상속 받아야 된다.
//생성자 굳이 필요없음. 
public class MyException extends Exception {
	MyException(){
		System.out.println("MyException 발생!");
	}
	@Override
	public String toString() {
		return "MyException!!! ";
	}
}
package com.exception;

//checked exception: IntaratorUI;

public class ThreadTest{

	public static void main(String[] args) {

		
	Thread t = new Thread();
	try {
		t.sleep(3000);
	} catch(InterruptedException e ) {
		e.printStackTrace();
		} //프로그램 실행을 잠시 맘춤

	System.out.println("Hello workd");

	try {
		t.sleep(3000, 20);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}

	System.out.println("Bye, world");
	}
}

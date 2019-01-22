package com.thread;

public class MainTest implements Runnable {
	
	MainTest(){
		Thread t = new Thread(this);
		t.start();
	
		try {
			t.join(); //MainThread가 실행되어야 하나, 사용자가 정의한 t Thread가 끝날 때까지 기다려야 함!
					  //join 메소드 사용!
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void test() {
		System.out.println("test method....");
	}
	
	public static void main(String[] args) {
		new MainTest().test(); //MainThread가 사용자 정의 Thread보다 우선 순위가 높음.
	}

	@Override
	public void run() { //thread가 수행하는 메소드
		System.out.println("thread...run()");
	}
}

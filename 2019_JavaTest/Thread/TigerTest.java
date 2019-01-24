package com.thread;

//Thread 상속받아서 thread를 사용.
class Tiger extends Thread{
	//thread가 해야 되는 작업 내용을 가진 메소. callback, method 있음.
	
	public void run() {
		System.out.println("thread is running..."+getName());
	} //코드상에서 직접 호출되진 않음. callback구성.
}

public class TigerTest{
	public static void main(String[] args) {
			Tiger t1 = new Tiger(); //상속을 받았으므로, t1은 Thread.
			t1.start(); //thread가 실행함.
			t1.run(); //main이 직접 실행하는 것. 실행 결과는 같으나, 실행 주체가 다름.
			
			Tiger t2 = new Tiger(); //상속을 받았으므로, t2은 Thread.
			t2.start();
			Tiger t3 = new Tiger(); //상속을 받았으므로, t3은 Thread.
			t3.start();		
	}
}

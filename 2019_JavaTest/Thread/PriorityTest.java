package com.thread;

class MyThread extends Thread{
	public void run() {
		System.out.println("name:" + getName());
	}
}

public class PriorityTest {
	public static void main(String[] args) {
		MyThread m1 = new MyThread();
		MyThread m2 = new MyThread();
		MyThread m3 = new MyThread();
	
		System.out.println(m1.getPriority()); 
		
		m1.setPriority(Thread.MIN_PRIORITY); //우선순위 지정 1번
		m2.setPriority(Thread.NORM_PRIORITY); //우선순위 지정 5번
		m3.setPriority(Thread.MAX_PRIORITY); //우선순위 지정 10번

		m1.start();
		m2.start();
		m3.start();
		
	}
}

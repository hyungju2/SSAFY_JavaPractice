package com.thread;

class Lion implements Runnable {

	@Override
	public void run() {
		System.out.println("thread in running..."+Thread.currentThread().getName()); 
		//Runnable Interface는 Thread와 직접 관련이 없으므로, getName을 직접 사용할 수 없다.
		
	}

}

public class LionTest{
	public static void main(String args[]) {
		Lion l1 = new Lion(); //Lion을 만들었다고 하여도, 이것은 Thread가 아님. Runnable객체여서, run()자체는 갖고있음.
		
		Thread t1 = new Thread(l1, "superman");
		t1.start();
		
		Thread t2 = new Thread(l1, "Willam");
		t2.start();
		
		Thread t3 = new Thread(l1, "Bentely");
		t3.start();  
		/**
		 * t1,t2,t3 모두 l1을 가리킴. 
		 * 작업 내용에 따라 다르게 사용하면 됨.
		 */
		
		
	}
}

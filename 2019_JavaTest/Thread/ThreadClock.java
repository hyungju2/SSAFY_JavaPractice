package com.thread;

import java.util.Date;

public class ThreadClock implements Runnable{

	public static void main(String[] args) {
		ThreadClock clock = new ThreadClock();
		
	}

	public ThreadClock() {
		//Thread 생성, start
		for(int i=0; i<2; i++)
		{
			try {
			Thread t = new Thread(this);
			t.start();
			t.join(i);
				}
			catch(Exception e){
				
			}
	}
	}
	
	@Override
	public void run() {
		//Thread가 해야하는 작업.
		Date d = new Date();
		System.out.println(d.toString());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

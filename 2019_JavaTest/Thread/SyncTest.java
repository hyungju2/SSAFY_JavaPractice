package com.thread;
/**
 * 동기화 : Synchronization / 멀티 Thread가 공유데이터에 접근해서 작업할 때 동시 접근이 안되도록 락을 거는일.
 * 순차실행이 되는 결과. 코드내에서 동기화 부분은 최소화 시키는 것이 좋음.
 * Vector -> 동기화 되어있음.
 * ArrayList -> 동기화 되어있지 않음. (멀티 스레드의 접근을 허용)/ 필요할 때 synchornized 추가하여 동기화하면 됨.
 * 최근 나온 것일수록 동기화 되어있지 않은 것이 많음.
 * 
 * @author student
 *
 */
public class SyncTest implements Runnable{
	
	SyncTest(){ //thread 생성, start
		Thread tom = new Thread(this,"davis");
		Thread jerry = new Thread(this,"jerry");	
		tom.start();
		
		jerry.start();
	}
	
	public static void main(String[] args) {
		new SyncTest();
	}

	@Override
	public void run() {
		kitchen();
		bedroom();
	}

	private synchronized void bedroom() { //동기화 키워드 : 락기능.
		String name = Thread.currentThread().getName();
		System.out.println(name+" 침실에 들어옴");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name+" 침실에 나감");
	}

	private synchronized void kitchen() {
		String name = Thread.currentThread().getName();
		System.out.println(name+" 부엌에 들어옴");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name+" 부엌에 나감");
	}
}


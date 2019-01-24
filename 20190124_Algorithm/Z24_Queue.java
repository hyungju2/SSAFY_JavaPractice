/**
 * Queue : 선형 자료구조, 선입 선출 FIFO
 * @author student
 *
 */
public class Z24_Queue {
	public static int q[] = new int[5];
	public static int front = -1; //첫 원소의 한칸 전을 가리킴
	public static int rear = -1; //마지막 원소를 가리킴
	
	public static boolean isFull()
	{
		return (rear == q.length-1);
	}
	
	public static void enQueue(int data)
	{
		if(isFull()) { //공간이 없으면
			System.out.println("queue is full");
		}
		else {
			q[++rear] = data;
		}
	}
	
	public static boolean isEmpty()
	{
		return (rear == front);
	}
	
	public static int deQueue() {
		if(isEmpty()){
			System.out.print("Queue is Empty");
			return -1;
		}else {
			return q[++front];
		}
		
	}
	
	public static void main(String[] args) {
		// 가장 중요
		q[++rear] = 1; //이 한줄로 enQueu를 구현. 
		q[++rear] = 2; //이 한줄로 enQueu를 구현. 
		q[++rear] = 3; //이 한줄로 enQueu를 구현. 
		System.out.println(q[++front]); //한 줄로 deque를 구현. 굳이 함수 생성x
		System.out.println(q[++front]);
		System.out.println(q[++front]);
		
		
		
	/*	enQueue(3);
		enQueue(4);
		enQueue(5);
		enQueue(5);
		enQueue(5);
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());
	
	*/
		
	}//end of main
}//end of class

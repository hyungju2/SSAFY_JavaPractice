/**
 * CircularQueue : 
 * @author student
 *
 */
public class Z25_CircularQueue {
	public static int q[] = new int[5];
	public static int front = -1; //첫 원소의 한칸 전을 가리킴
	public static int rear = -1; //마지막 원소를 가리킴
	
	public static boolean isFull()
	{
		return ((rear+1)%q.length)==front;
	}
	public static void enQueue(int data)
	{
		if(isFull()) { //공간이 없으면
			System.out.println("queue is full");
		}
		else {
			rear++;
			if(rear==q.length)
			{
				rear=0;
			}
			//rear = (rear+1)%q.length; => %연산자 속도가 매우 느리니, 위 코드로 대체.
			q[rear] = data;
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
			
			front++;
			if(front==q.length)
			{
				front = 0;
			}
			//front = (front+1)%q.length;
			return q[front];
		}
	}
	
	public static void main(String[] args) {
		enQueue(3);
		enQueue(4);
		enQueue(5);
		enQueue(6);
	
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());
		
		enQueue(7);
		System.out.println(deQueue());
		
		enQueue(3);
		System.out.println(deQueue());
		
		
	}//end of main
}//end of class

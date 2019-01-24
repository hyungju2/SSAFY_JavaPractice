import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Z26_Mychew {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int candy = 20; //사탕 갯수
		int givecandy = 0;
		int num[] = new int[20]; //사람 정보 저장
		int queue[] = new int[20]; //큐
		
		int front = -1;
		int rear = -1;
		
		queue[++rear] = 1;
		num[1] +=1;

		//Test1
		String s = br.readLine();
		System.out.println("큐에 있는 사람 수: "+(rear-front));
		System.out.print("현재 일인당 나눠주는 사탕의 수: ");
		for(int i=1; num[i]!=0; i++)
		{
			System.out.print(i+"번 :"+num[i]+"개 ");
		}
		System.out.println();
		System.out.println("현재까지 나눠준 사탕의 수: "+givecandy);
		
		//Test2
		queue[rear--] = 0;
		
		s = br.readLine();
		System.out.println("큐에 있는 사람 수: "+(rear-front));
		System.out.print("현재 일인당 나눠주는 사탕의 수: ");
		for(int i=1; num[i]!=0; i++)
		{
			givecandy += num[i];
			System.out.print(i+"번 :"+num[i]+"개 ");
		}
		System.out.println();
		System.out.println("현재까지 나눠준 사탕의 수: "+givecandy);
		
		//Test3 
		queue[++rear] = 1;
	
		s = br.readLine();
		System.out.println("큐에 있는 사람 수: "+(rear-front));
		System.out.print("현재 일인당 나눠주는 사탕의 수: ");
		for(int i=1; num[i]!=0; i++)
		{
			System.out.print(i+"번 :"+num[i]+"개 ");
		}
		System.out.println();
		System.out.println("현재까지 나눠준 사탕의 수: "+givecandy);
		
		//Test4
		queue[++rear] = 2;
		s = br.readLine();
		System.out.println("큐에 있는 사람 수: "+(rear-front));
		System.out.print("현재 일인당 나눠주는 사탕의 수: ");
		for(int i=1; num[i]!=0; i++)
		{
			System.out.print(i+"번 :"+num[i]+"개 ");
		}
		System.out.println();
		System.out.println("현재까지 나눠준 사탕의 수: "+givecandy);
		
		//Test5

		s = br.readLine();
		queue[rear-1] = queue[rear];
		queue[rear--] = 0;
		num[1]+=2;
		System.out.println("큐에 있는 사람 수: "+(rear-front));
		System.out.print("현재 일인당 나눠주는 사탕의 수: ");
		givecandy=0;
		for(int i=1; num[i]!=0; i++)
		{
			System.out.print(i+"번 :"+num[i]+"개 ");
			givecandy+=num[i];
		}
		System.out.println();
		System.out.println("현재까지 나눠준 사탕의 수: "+givecandy);
		
		
		//Test6
		queue[++rear] = 1;
		s = br.readLine();
		System.out.println("큐에 있는 사람 수: "+(rear-front));
		System.out.print("현재 일인당 나눠주는 사탕의 수: ");
		givecandy = 0;
		for(int i=1; num[i]!=0; i++)
		{
			System.out.print(i+"번 :"+num[i]+"개 ");
			givecandy+=num[i];
		}
		System.out.println();
		System.out.println("현재까지 나눠준 사탕의 수: "+givecandy);
		
		//Test7
		queue[++rear] = 3;
		s = br.readLine();
	
		System.out.println("큐에 있는 사람 수: "+(rear-front));
		System.out.print("현재 일인당 나눠주는 사탕의 수: ");
		for(int i=1; num[i]!=0; i++)
		{
			System.out.print(i+"번 :"+num[i]+"개 ");
		}
		System.out.println();
		System.out.println("현재까지 나눠준 사탕의 수: "+givecandy);
		
		//Test8, 2번이 나감.
				queue[rear-1] = queue[rear];
				queue[rear--] = 0;
				num[2]++;
				s = br.readLine();
				givecandy=0;
				System.out.println("큐에 있는 사람 수: "+(rear-front));
				System.out.print("현재 일인당 나눠주는 사탕의 수: ");
				for(int i=1; num[i]!=0; i++)
				{
					System.out.print(i+"번 :"+num[i]+"개 ");
					givecandy+=num[i];
				}
				System.out.println();
				System.out.println("현재까지 나눠준 사탕의 수: "+givecandy);
				
				//Test7
				queue[++rear] = 2;
				s = br.readLine();
			
				System.out.println("큐에 있는 사람 수: "+(rear-front));
				System.out.print("현재 일인당 나눠주는 사탕의 수: ");
				for(int i=1; num[i]!=0; i++)
				{
					System.out.print(i+"번 :"+num[i]+"개 ");
				}
				System.out.println();
				System.out.println("현재까지 나눠준 사탕의 수: "+givecandy);
				
				//Test10 4번이 들어옴
			
				queue[++rear] = 4;
				s = br.readLine();
			
				System.out.println("큐에 있는 사람 수: "+(rear-front));
				System.out.print("현재 일인당 나눠주는 사탕의 수: ");
				for(int i=1; num[i]!=0; i++)
				{
					System.out.print(i+"번 :"+num[i]+"개 ");
				}
				System.out.println();
				System.out.println("현재까지 나눠준 사탕의 수: "+givecandy);
				
				//Test 11 1이 나감.
				queue[rear-1] = queue[rear];
				queue[rear--] = 0;
				num[1]+=3;
				s = br.readLine();
				givecandy=0;
				System.out.println("큐에 있는 사람 수: "+(rear-front));
				System.out.print("현재 일인당 나눠주는 사탕의 수: ");
				for(int i=1; num[i]!=0; i++)
				{
					System.out.print(i+"번 :"+num[i]+"개 ");
					givecandy+=num[i];
				}
				System.out.println();
				System.out.println("현재까지 나눠준 사탕의 수: "+givecandy);
				//Test 12 1이 들어옴
				queue[++rear] = 1;
				s = br.readLine();
			
				System.out.println("큐에 있는 사람 수: "+(rear-front));
				System.out.print("현재 일인당 나눠주는 사탕의 수: ");
				for(int i=1; num[i]!=0; i++)
				{
					System.out.print(i+"번 :"+num[i]+"개 ");
				}
				System.out.println();
				System.out.println("현재까지 나눠준 사탕의 수: "+givecandy);
				
				//Test 13 5가 들어옴
				queue[++rear] = 5;
				s = br.readLine();
			
				System.out.println("큐에 있는 사람 수: "+(rear-front));
				System.out.print("현재 일인당 나눠주는 사탕의 수: ");
				for(int i=1; num[i]!=0; i++)
				{
					System.out.print(i+"번 :"+num[i]+"개 ");
				}
				System.out.println();
				System.out.println("현재까지 나눠준 사탕의 수: "+givecandy);
				
				//Test 14 3번이 나감.
				queue[rear-1] = queue[rear];
				queue[rear--] = 0;
				num[3]+=1;
				s = br.readLine();
				givecandy=0;
				System.out.println("큐에 있는 사람 수: "+(rear-front));
				System.out.print("현재 일인당 나눠주는 사탕의 수: ");
				for(int i=1; num[i]!=0; i++)
				{
					System.out.print(i+"번 :"+num[i]+"개 ");
					givecandy+=num[i];
				}
				System.out.println();
				System.out.println("현재까지 나눠준 사탕의 수: "+givecandy);
				
				//Test 15 2번이 나감.
				queue[rear-1] = queue[rear];
				queue[rear--] = 0;
				num[2]+=2;
				s = br.readLine();
				givecandy=0;
				System.out.println("큐에 있는 사람 수: "+(rear-front));
				System.out.print("현재 일인당 나눠주는 사탕의 수: ");
				for(int i=1; num[i]!=0; i++)
				{
					System.out.print(i+"번 :"+num[i]+"개 ");
					givecandy+=num[i];
				}
				System.out.println();
				System.out.println("현재까지 나눠준 사탕의 수: "+givecandy);
				
				//Test 4번이 나감
				queue[rear-1] = queue[rear];
				queue[rear--] = 0;
				num[4]+=1;
				s = br.readLine();
				givecandy=0;
				System.out.println("큐에 있는 사람 수: "+(rear-front));
				System.out.print("현재 일인당 나눠주는 사탕의 수: ");
				for(int i=1; num[i]!=0; i++)
				{
					System.out.print(i+"번 :"+num[i]+"개 ");
					givecandy+=num[i];
				}
				System.out.println();
				System.out.println("현재까지 나눠준 사탕의 수: "+givecandy);
				
				//Test 1번이 나감
				queue[rear-1] = queue[rear];
				queue[rear--] = 0;
				num[1]+=4;
				s = br.readLine();
				givecandy=0;
				System.out.println("큐에 있는 사람 수: "+(rear-front));
				System.out.print("현재 일인당 나눠주는 사탕의 수: ");
				for(int i=1; num[i]!=0; i++)
				{
					System.out.print(i+"번 :"+num[i]+"개 ");
					givecandy+=num[i];
				}
				System.out.println();
				System.out.println("현재까지 나눠준 사탕의 수: "+givecandy);
				
				//Test 5번이 나감
			    
				queue[rear--] = 0;
				num[5]+=5;
				s = br.readLine();
				givecandy=0;
				System.out.println("큐에 있는 사람 수: "+(rear-front));
				System.out.print("현재 일인당 나눠주는 사탕의 수: ");
				for(int i=1; num[i]!=0; i++)
				{
					System.out.print(i+"번 :"+num[i]+"개 ");
					givecandy+=num[i];
				}
				System.out.println();
				System.out.println("현재까지 나눠준 사탕의 수: "+givecandy);
				
				System.out.println("5번이 가져감!");
	}//end of main
}//end of class

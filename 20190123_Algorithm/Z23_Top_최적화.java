/**
 * 
 * 최초 -> 2380ms
 * BufferedReader 1280ms.
 * BufferedReader br = new BufferReader(new InputStreamReader(System.in));
 * 
 * StringBuilder 적용 534ms //화면에 출력해주는 것은 String보다 훨씬 빠름.
 * 
 * 
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Z23_Top {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		
		int[] arr = new int[N+1];
		int[] stack = new int[N]; //탑의 인덱스를 관리. 최악일 경우 N개의 스택이 쌓임.
		int top = -1;
		int start=1;
		String ar = br.readLine();
		StringTokenizer st = new StringTokenizer(ar," ");
		StringBuilder sb = new StringBuilder();
		while(st.hasMoreTokens())
		{
			arr[start++] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
		
			
			// 스택에 나보다 작은 높이의 탑이 있으면 꺼낸다. pop해서 버림.
			while(top > -1 && arr[stack[top]] < arr[i])
			{
				top--; //인덱스만 버림. (삭제의 효과)
			}
			if(top == -1) // 공백 스택일 때
			{
				sb.append("0 ");
			}
			else
			{
				sb.append(stack[top]).append(" "); //내 레이저를 수신할 수 있는 집.
				//문자열 더하는 연산보다 sb.append 연산이 훨씬 빠름.
				
			}//남아 있을 때
		
			stack[++top] =i;//스택에 내 탑의 index를 쌓기.
		}		
		System.out.println(sb);
		
	}//end of main
}//end of class

	

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Solution_5432_쇠막대기자르기_이형주 {

public static void main(String[] args) {

	int T;
	Scanner sc = new Scanner(System.in);
	T = sc.nextInt();
	int test = 0;
	while(test<T)
	{
		Stack st = new Stack();
	
		String s = sc.next();
		int stick = 0;
		boolean check[] = new boolean[100001];

		int count = 0;
		
		for(int i=1; i<s.length();i++)
		{
			char k = s.charAt(i-1);
			char t = s.charAt(i);
		
	
			if(k=='(')
				{
				check[i] = true;
				stick++;
				st.push(t);	
				}
			else
			if(k==')') {
				stick--;
					st.pop();	
			}
			if(k=='('&&t==')')
			{
				count+=stick;
			}
		}
		System.out.println("#"+(test+1)+" "+(count-1));
		test++;
	}
}//end of main
	}//end of class



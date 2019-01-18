
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
public class Solution_1218_SW문제해결기본4일차_괄호짝짓기_이형주 {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack st = new Stack();
		
		for(int testcase=1; testcase<=11; testcase++)
		{
			int num;
			num = sc.nextInt();
			int count = 1;
			String s = sc.next();
		
			for(int i=0; i<s.length(); i++)
			{
				
				
				char te = s.charAt(i);	
			
				if(te=='('||te=='['||te=='{'||te=='<')
			{
				st.push(te);
			}
			else
				if(te==')'||te==']'||te=='}'||te=='>') {
					if(!st.isEmpty())
					{
						char t = (char)st.pop();
						if(te==')')
						{
							if(!(t=='('))
							{
								count = 0;
								continue;
							}
						}
						if(te==']')
						{
							if(!(t=='['))
							{
								count = 0;
								continue;
							}
							}
						if(te=='}')
						{
							if(!(t=='{'))
							{
								count = 0;
								continue;
							}
						}
						if(te=='>')
						{
							if(!(t=='<'))
							{
								count = 0;
								continue;
							}
						}
						
					}
					}
				if((i==s.length()-1)&&(!(st.empty())))
					count=0;
				}
			System.out.println("#"+testcase+" "+count);
		}//end of testcase
	}//end of main
	}//end of class



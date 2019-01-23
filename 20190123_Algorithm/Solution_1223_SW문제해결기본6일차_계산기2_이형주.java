import java.util.Arrays;
import java.util.Scanner;

public class Solution_1223_SW문제해결기본6일차_계산기2_이형주 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);	
		
		for(int testcase = 1; testcase<11; testcase++) {
		int T = sc.nextInt();
		sc.nextLine();
		
		char []stackOp = new char[T]; //연산자를 저장할 스택
		char []Inputstack = new char[T];
		int top = -1;
		int index = 0;
		String st= sc.nextLine(); 
		String[] str = st.split("");
		
		for(int i=0; i<str.length; i++)
		{
			char c = str[i].charAt(0);//문자열의 첫글자를 잘라옴
			
		switch (c) {
		case '(': //무조건 스택에 저장. 우선순위 3
			stackOp[++top] = c;
			break;
			
		case '*' : //우선순위 2
		case '/' : //우선순위 2
			//스택을 확인해서, 우선순위가 나보다 낮으면 넣는다. 높거나 같으면, 계속 pop.
			while(top>=0 && (stackOp[top] == '*' || stackOp[top] == '/')) 
			{
				//System.out.print(stackOp[top]+" "); // *,/가 아니면 탈출함.
				Inputstack[index] = stackOp[top];
				index++;
				
				top--;
			}
			stackOp[++top] = c; //스택위에 내 연산자 쌓기
			break;
			
		case '+' : //우선순위 1
		case '-' : //우선순위 1
			//나보다 우선순위 낮은 것을 모두 pop
			while(top>=0 &&(stackOp[top] == '*' || stackOp[top] == '/' || stackOp[top] == '+' || stackOp[top] == '-'))
			{
				//System.out.print(stackOp[top]);
				Inputstack[index] = stackOp[top];
				index++;
				top--;
			}
			stackOp[++top] = c;
			break;
			
		case ')' : //스택에 넣지는 않고, 스택에서 나올때까지 pop
			while(top>=0 && (stackOp[top] != '('))
			{
				//System.out.print(stackOp[top]);
					Inputstack[index] = stackOp[top];
					index++;
					top--;
			}
			top--;
				break;
		
		default: 
		{
			//System.out.print(c);//숫자
			Inputstack[index] = c;
			index++;
			break;
		}
		}
		} //토큰이 끝난 것. end of while
		while(top>-1)
		{
			//System.out.print(stackOp[top]);
			Inputstack[index] = stackOp[top];
			index++;
			top--;
		}
		//후위 연산으로 변환 끝.
		//		System.out.println();
	
	
		int[] stackNum = new int[Inputstack.length];
		
		int rtop = -1;
		
		for(int i=0; i<Inputstack.length; i++)
		{
			char c = Inputstack[i];
			int num1, num2;
			switch(c)
			{
			case '+' :
				num2 = stackNum[rtop--];
				num1 = stackNum[rtop--];
				stackNum[++rtop] = num1 + num2;
				break;
		
			case '-' :
				num2 = stackNum[rtop--];
				num1 = stackNum[rtop--];
				stackNum[++rtop] = num1 - num2;
				break;
			
			case '*' :
				num2 = stackNum[rtop--];
				num1 = stackNum[rtop--];
				stackNum[++rtop] = num1 * num2;
				break;
			
			case '/' :
				num2 = stackNum[rtop--];
				num1 = stackNum[rtop--];
				stackNum[++rtop] = num1 / num2;
				break;
			default :
				stackNum[++rtop] = (int)Inputstack[i]-48;
				break;
			}
		}
		System.out.println("#"+testcase+" "+stackNum[rtop]);
	
		} //end of testcase
}//end of main
}//end of class

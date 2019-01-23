import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
중위 표기식을 후위 표기식으로 변경하여 출력하기.
Input
6 + 5 * ( 2 - 8 ) / 2
2 + 3 * 4 / 5

Output
6 5 2 8 - * 2 / +
2 3 4 * 5 / +
 */
public class Z20_MutliCal {
	public static void main(String[] args) throws Exception {

	Scanner sc = new Scanner(System.in);	
	char []stackOp = new char[100]; //연산자를 저장할 스택
	int top = -1;
	String[] str = sc.nextLine().split(" "); //
	
	for(int i=0; i<str.length; i++)
	{
		char c = str[i].charAt(0); //문자열의 첫글자를 잘라옴
		
	switch (c) {
	case '(': //무조건 스택에 저장. 우선순위 3
		stackOp[++top] = c;
		break;
		
	case '*' : //우선순위 2
	case '/' : //우선순위 2
		//스택을 확인해서, 우선순위가 나보다 낮으면 넣는다. 높거나 같으면, 계속 pop.
		while(top>=0 && (stackOp[top] == '*' || stackOp[top] == '/')) 
		{
			System.out.print(stackOp[top]+" "); // *,/가 아니면 탈출함.
			top--;
		}
		stackOp[++top] = c; //스택위에 내 연산자 쌓기
		break;
		
	case '+' : //우선순위 1
	case '-' : //우선순위 1
		//나보다 우선순위 낮은 것을 모두 pop
		while(top>=0 &&(stackOp[top] == '*' || stackOp[top] == '/' || stackOp[top] == '+' || stackOp[top] == '-'))
		{
			System.out.print(stackOp[top]);
			top--;
		}
		stackOp[++top] = c;
		break;
		
	case ')' : //스택에 넣지는 않고, 스택에서 나올때까지 pop
		while(top>=0 && (stackOp[top] != '('))
		{
				System.out.print(stackOp[top]);
				top--;
		}
		top--;
			break;
	
	default: 
		System.out.print(str[i]+" ");//숫자
		break;
	}
	} //토큰이 끝난 것.
	while(top>-1)
	{
		System.out.print(stackOp[top]);
		top--;
	}
	System.out.println();
	sc.close();
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 계산기, '+'와 '*'만 존재
 * @author student
 * 12 + 5 * 2 + 3 + 4 * 2
 */
public class Z19_cal {
	public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int []stack = new int[100];
	int top = -1;
	
	String str = br.readLine();
	StringTokenizer st = new StringTokenizer(str, " ");
	//전체 문자열과 쪼갤 기준자. 정규화 표현식이 안됨.
	//str.split(" ");은 정규화 가능. 속도면에서는 좀 더 느림.

	stack[++top]=Integer.parseInt(st.nextToken()); //첫번째 피연산자를 숫자로입력.
	
	while(st.hasMoreTokens())
	{
		char op = st.nextToken().charAt(0); //연산자
		int num = Integer.parseInt(st.nextToken()); //피연산자
		if(op == '+')
		{
			stack[++top] = num;
		}
		else if(op == '*')
		{
			int pre = stack[top];
			stack[top] = pre * num;
		}
	}
	int sum = 0;
	for(int i=0; i<=top; i++)
	{
		sum+=stack[i];
	}
	System.out.println("합은 "+sum);
}
}

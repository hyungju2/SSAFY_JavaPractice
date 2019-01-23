import java.util.Scanner;

/**
 * 후위 표기식으로 입력받아서 계산 결과를 출력
 * input
 * 6 5 2 8 - * 2 / +
 * 
 * output
 * -9
 * @author student
 *
 */
public class Z21_Cal3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] str = sc.nextLine().split(" ");
		
		int[] stackNum = new int[str.length];
		
		int top = -1;
		for (int i = 0; i < str.length; i++) {
			char c = str[i].charAt(0);
		
			int num1, num2;
			switch(c)
			{
			case '+' :
				num2 = stackNum[top--];
				num1 = stackNum[top--];
				stackNum[++top] = num1 + num2;
				break;
		
			case '-' :
				num2 = stackNum[top--];
				num1 = stackNum[top--];
				stackNum[++top] = num1 - num2;
				break;
			
			case '*' :
				num2 = stackNum[top--];
				num1 = stackNum[top--];
				stackNum[++top] = num1 * num2;
				break;
			
			case '/' :
				num2 = stackNum[top--];
				num1 = stackNum[top--];
				stackNum[++top] = num1 / num2;
				break;
			default :
				stackNum[++top] = Integer.parseInt(str[i]);
				break;
			}
		}
		System.out.println(stackNum[top]);//end of for
	}//end of main
}//end of class

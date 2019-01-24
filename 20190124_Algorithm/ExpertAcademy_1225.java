import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TTest {
	
	public static void main(String[] args) throws Exception {
		ArrayList<Integer> stack = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		for(int testcase = 1; testcase<=10; testcase++)
		{

			int tmp = 1;
			int T = sc.nextInt();
	
		for(int i=0; i<8; i++)
		{
			int num = sc.nextInt();
			stack.add(i, num);
		}
		
		while(tmp!=0) {
		for(int i=1; i<=5; i++)
		{
			tmp = stack.get(0);
			tmp -= i;
			stack.remove(0);
			if(tmp<=0)
			{
				tmp=0;
				stack.add(tmp);
				break;
			}
				stack.add(tmp);
		}	
		}//end of while
		System.out.print("#"+T+" ");
		
		for(int i=0; i<8; i++)
			{
			System.out.print(stack.get(i)+" ");
			}
		System.out.println();
		stack.clear();
		} //end of testcase

	}// end of main
}//end of class

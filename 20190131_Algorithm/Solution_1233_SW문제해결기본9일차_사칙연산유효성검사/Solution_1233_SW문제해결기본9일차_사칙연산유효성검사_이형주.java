import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_1233_SW문제해결기본9일차_사칙연산유효성검사_이형주 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int testcase = 1; testcase <= 10; testcase++) {
			
			int T = Integer.parseInt(br.readLine());
			String arr[] =  new String[T+1];
			String s;
			int result = 1;
			for (int i = 1; i <= T; i++) {
				s = br.readLine();
				StringTokenizer tk = new StringTokenizer(s," ");
				int n1 = Integer.parseInt(tk.nextToken());
				String n2 = tk.nextToken();
				arr[n1] = n2;
			}
			
			for(int k = T; k>0; k--)
			{
				if(!(arr[k].equals("*")||arr[k].equals("+")||arr[k].equals("/")||arr[k].equals("-"))) //숫자일 때
						{
							if(!(arr[k/2].equals("*")||arr[k/2].equals("+")||arr[k/2].equals("/")||arr[k/2].equals("-")))
									{
										result = 0;
										break;
									}
						}
				
			}
			System.out.println("#"+testcase+" "+result);
			} //end of Testcase
		
		} // end main
}//end of class

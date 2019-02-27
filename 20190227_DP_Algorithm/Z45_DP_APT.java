import java.util.Arrays;
import java.util.Scanner;

public class Z45_DP_APT {
	public static void main(String[] args) {
		System.out.println(f(2));
	}//end of main
	
	public static int f(int n) {
		int[] memo = new int[n+1];
		
		if(n>=2)
		{
		memo[1] = 2;
		memo[2] = 3;
		
		for(int i=3; i<=n; i++) {
			memo[i] = memo[i-1]+memo[i-2];
		}
		System.out.println(Arrays.toString(memo));
		return memo[n];
		}
		else
			return 2;
		} //end of fibo
}

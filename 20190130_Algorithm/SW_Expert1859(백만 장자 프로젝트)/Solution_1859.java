import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1859 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String Test = br.readLine();
		int test = Integer.parseInt(Test);
		for (int testcase = 1; testcase <= test; testcase++) {

			String N = br.readLine();
			int n = Integer.parseInt(N);
			String s = br.readLine();
			StringTokenizer tk = new StringTokenizer(s, " ");
			
			int arr[] = new int[n];
			int i = 0;
			
			while (tk.hasMoreTokens()) {
				arr[i] = Integer.parseInt(tk.nextToken());
				i++;
			}
			
			long price = 0; // 값의 범위 최댓값이 100억이기 때문에 int로 하면 짤림.
			int max = 0;
			
			for(int k = n-1; k>=0; k--) {
				if(max < arr[k]) {
					max = arr[k];
				}else {
					price+=(max-arr[k]);
				}
			}
			System.out.println("#"+testcase+" "+price);
		} // end of testcase
	} // end of main
}

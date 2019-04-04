import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_4050 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for(int testcase=1; testcase<=T; testcase++) {
			int N = Integer.parseInt(br.readLine().trim());
			StringTokenizer tk = new StringTokenizer(br.readLine()," ");
			int arr[] = new int[N];
			for(int i=0; i<arr.length; i++) {
				arr[i]= Integer.parseInt(tk.nextToken());
			}
			Arrays.sort(arr);
			int cost[] = new int[N]; //가격들을 비싼 순으로 정렬
			for(int i=0; i<cost.length; i++) {
				cost[cost.length-1-i]=arr[i];
			}
			if(cost.length%3==0) {
				for(int i=2; i<cost.length; i+=3) {
					cost[i] = 0;
				}
			}
			else if(cost.length%3==1)
			{
				for(int i=2; i<cost.length-1; i+=3) {
					cost[i]=0;
				}
			}
			else {
				for(int i=2; i<cost.length-2; i+=3) {
					cost[i]=0;
				}
			}
			int result=0;
			for(int i=0; i<cost.length; i++) {
				result+=cost[i];
			}
			
			System.out.println("#"+testcase+" "+result);
		}//end of testcase
	} //end of main
}//end of class

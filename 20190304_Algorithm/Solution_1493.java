import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1493 {
	
	public static int arr[][] = new int[300][300];
	
	public static void arrays() {
		arr[1][1] = 1;
		for(int i=1; i<arr.length; i++) {
				 arr[i][1]= 1+(i*(i-1))/2;
				 for(int j=2; j<arr.length; j++) {
				  arr[i][j] = arr[i][j-1]+j+(i-1);
				 }
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		arrays();
		for(int testcase=1; testcase<=T; testcase++) {
		
			String s = br.readLine();
			StringTokenizer tk = new StringTokenizer(s," ");
			int x = Integer.parseInt(tk.nextToken());
			int y = Integer.parseInt(tk.nextToken());
			int temp1=0,temp2=0,temp3=0,temp4 = 0;
			
			for(int i=1; i<arr.length;i++) {
				for(int j=1; j<arr.length; j++) {
					if(arr[i][j]==x)
					{
						temp1=i;
						temp2=j;
						break;
					}
				}
			}
			
			for(int i=1; i<arr.length;i++) {
				for(int j=1; j<arr.length; j++) {
					if(arr[i][j]==y)
					{
						temp3=i;
						temp4=j;
						break;
					}
				}
			}
			int sum = arr[temp1+temp3][temp2+temp4];
			System.out.println("#"+testcase+" "+sum);
		}//end of testcase
	}//end of main
	
	
}//end of class

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_2007 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int testcase=1; testcase<=T; testcase++) {
			String s = br.readLine();
			
			int num[] = new int[10];
			int cnt=0;
			for(int i=0; i<9; i++) {
				if(num[cnt]!=0)
					break;
				for(int j=i+1; j<10; j++) {
					if(s.charAt(i)==s.charAt(j)&&s.charAt(j)==s.charAt(i+j)) {
						if(s.charAt(i+1)==s.charAt(i+1+j))	{
						num[cnt] = j;
							cnt++;
							break;
					}
					}
				}
			}
			System.out.println("#"+testcase+" "+num[0]);
		}//end of testcase
	}//end of main
}//end of class

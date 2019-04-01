import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_4672 {
	public static String s;
	public static char arr[];
	public static char temp[];
	public static int check[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for(int testcase=1; testcase<=T; testcase++) {
			s = br.readLine().trim();
		
			arr = new char[s.length()];
			temp = new char[s.length()];
			check = new int[27];
			int res = s.length(); //각 문자 하나씩 더해줌.
			for(int i=0; i<s.length(); i++) {
				arr[i] = s.charAt(i);
				check[arr[i]-'0'-48]++; //check배열을 사용하여, 해당 문자열의 빈도를 구함
			}
			
		for(int i=0; i<check.length; i++) {
		 if(check[i]!=0&&check[i]>=2) { //2번이상 사용됐으면, 팩토리얼 만큼 반복되어야 최대
				res+=Fact(check[i])-check[i];
			}
		}
		
			System.out.println("#"+testcase+" "+res);
		}//end of testcase
	}//end of main
	private static int Fact(int i) {
		int res=1;
		for(int t=i; t>1; t--) {
			res+=t;
		}
		return res;
	}
	
	
}//end of class

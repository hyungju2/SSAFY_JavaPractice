import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_5672 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int testcase = 1; testcase <= T; testcase++) {
			int N = Integer.parseInt(br.readLine().trim());
			char[] c = new char[N];
			for (int i = 0; i < c.length; i++) {
				c[i] = br.readLine().charAt(0);
			}
			char[] result = new char[N]; //출력할 결과
			
			int s =-1; //앞쪽 앵무새
			int e =N; //뒷쪽 앵무새
			
			for (int i = 0; i < result.length; i++) {
				if(c[s+1] < c[e-1]) {
					result[i] = c[++s];
				}else if(c[s+1]>c[e-1]) {
					result[i] = c[--e];
				}else { //두 글자가 같은 경우
					int j=1;
					for(; s+j<e-j&& c[s+j] == c[e-j]; j++); //인덱스가 역전되지 않고, 글자가 다를 때까지 j를 증가
					
					if(c[s+j]<c[e-j]) {
						result[i] = c[++s];
					}else if(c[s+j]>c[e-j]){
						result[i] = c[--e];
					}else { //계속 같은 글자라는 의미거나, 한 글자라는 의미.
						result[i] = c[++s]; //아무거나 선택하면 된다.
					}
				}
			}
			
			System.out.println("#"+testcase+" "+new String(result));
		}
	}// end of main
} // end of class

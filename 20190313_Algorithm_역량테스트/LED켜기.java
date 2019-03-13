import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LED켜기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int testcase=1; testcase<=T; testcase++) {
			int N = Integer.parseInt(br.readLine().trim());
			
			StringTokenizer tk = new StringTokenizer(br.readLine()," ");
			
			boolean [] m = new boolean[N+1]; //0번칸 사용x
			
			
			for(int i=1; i<m.length; i++) {
				m[i] = tk.nextToken().equals("1")?true:false;
			}
			
			//주어진 LED 배열 상태를 모두 꺼진 상태로 변환하는 횟수를 구하자.
			int cnt=0;
			
			for(int i=1; i<m.length; i++) {
				if(m[i]) {
					cnt++;
					
				/*	for(int j=0; j<=2;j++) {
						int next = i+j;
						if(next<m.length) {
						m[i+j]=!m[i+j];
						}
						else
							break;
					}*/
					for(int j=i; j<m.length; j+=i) {
						m[j] = !m[j];
					}
					
				}
			}
			
			System.out.println("#"+testcase+" "+cnt);
		}//end of testcase
	}//end of main
}//end of class

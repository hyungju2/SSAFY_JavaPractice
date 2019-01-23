import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_탑레이저{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		int []tower = new int[num+1];
		int []stack = new int[num+1];
		int i = 1, max = 0;
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		while(st.hasMoreTokens()){
			tower[i++] = Integer.parseInt(st.nextToken());
		}
		
		for(i = 1; i < num + 1; i++) {
			if(max < tower[i]) {
				max = tower[i];
				stack[i] = 0;
				continue;
			}
			int top = i-1;
			while(top > 0) {
				if(tower[i] < tower[top]) {
					break;
				}
				top--;
			}
			stack[i] = top;
		}
			
		
		for(i = 1 ; i < num+1 ; i++ ) {
			System.out.print(stack[i] + " ");
		}
		
	}//end of main
}//end of class

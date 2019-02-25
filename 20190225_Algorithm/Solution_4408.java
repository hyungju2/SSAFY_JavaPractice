import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_4408 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= T; testcase++) {
			int N = Integer.parseInt(br.readLine());
			int arr[] = new int[200];
			
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				StringTokenizer tk = new StringTokenizer(s, " ");
				int cur = ((Integer.parseInt(tk.nextToken()))-1)/2; // ���� ��
				int ret = ((Integer.parseInt(tk.nextToken()))-1)/2; // ���ư� ��
				
				if(cur>ret) {  //cur�� ret���� �۰ų� ���� ���� �ǵ���.
					int temp = cur;
					cur = ret;
					ret = temp;
				}
				for(int j=cur; j<=ret; j++) {
					arr[j]++; //����ϴ� ���� �ε����� ����
				}
			}
			Arrays.sort(arr);
			System.out.println("#" + testcase + " " + arr[199]);
		} // end of testcase
	}// end of main
}// end of class

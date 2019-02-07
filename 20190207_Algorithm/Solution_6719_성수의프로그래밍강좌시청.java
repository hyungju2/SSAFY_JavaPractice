import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_6719_성수의프로그래밍강좌시청 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> list = new ArrayList<>();
		int T = Integer.parseInt(br.readLine());
		int N = 0;
		int K = 0;
		for (int testcase = 1; testcase <= T; testcase++) {
			
			double num = 0;
			String s = br.readLine();
			StringTokenizer tk = new StringTokenizer(s, " ");
			while (tk.hasMoreTokens()) {
				N = Integer.parseInt(tk.nextToken());
				K = Integer.parseInt(tk.nextToken());
			}
			s = br.readLine();
			StringTokenizer tk2 = new StringTokenizer(s," ");
			while(tk2.hasMoreTokens()) {
				list.add(Integer.parseInt(tk2.nextToken()));
			}
			Collections.sort(list);
			
			for(int j = list.size()-K; j<list.size(); j++ ) {
				num = (list.get(j)+num)/2.0;
			}
			System.out.printf("#%d %.6f\n",testcase,num);	
		} // end of testcase
	} // end of main
}// end of class

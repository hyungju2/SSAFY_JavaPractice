import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Solution_5213_진수의홀수약수_이형주 {
	static HashSet<Integer> hs;
	static long sum;
	static boolean check[];
	static boolean oddcheck[] = new boolean[1000001];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		oddcheck();
		
		for (int testcase = 1; testcase <= T; testcase++) {
			hs = new HashSet<>();
			String s = br.readLine();
			StringTokenizer tk = new StringTokenizer(s, " ");
			int L = Integer.parseInt(tk.nextToken());
			int R = Integer.parseInt(tk.nextToken());
			check = new boolean[R + 1];
			oddnum(R);
			sum = 0;
			for (int i = L; i <= R; i++) {
				if (check[i]) { // 소수가 아니면
					returnSum(i);
					hs.clear();
				} else {
					sum +=(i+1);
 				}
			}
			
			System.out.println("#" + testcase + " " + sum);
		} // end of testcase
	}// end of main
	
	public static void oddcheck() {
		for(int i=1; i<1000000; i+=2)
			oddcheck[i] = true;
	}
	
	
	public static void oddnum(int R) {
		check[1] = true; //소수가 아닐 떄 true
		for (int i = 2; i <= R; i++) {
			if (check[i] == false) {
				for (int a = i * 2; a <= R; a += i) {
					check[a] = true;
				}
			}
		}
	}

	public static void returnSum(int num) {
		hs.add(1);
		for (int i = 1; i <= num; i++) {
			for (int j = 1; i * j <= num; j++) {
				if (i * j != num)
					continue;
				else {
					hs.add(i);
					hs.add(j);
				}
			}
		}
		Iterator<Integer> itr = hs.iterator();
		while (itr.hasNext()) {
			int temp = itr.next();
			if(oddcheck[temp])
				sum += temp;
		}
	}
}// end of class

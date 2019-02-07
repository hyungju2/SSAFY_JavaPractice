import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5607_Professional조합 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= t; testcase++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s, " ");
			int n = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());

			// n! 처리부분
			long result = n;
			for (int i = n - 1; i > 0; i--) {
				result *= i;
				if (result < 1234567891)
					continue;
				else if (result >= 1234567891) {
					result %= 1234567891;
				}
			}

			// (n-r)!
			long fact1 = 1, fact2 = 1;// n-r! , r!
			for (int i = 1; i <= n - r; i++) {
				fact1 *= i;
				if (fact1 < 1234567891)
					continue;
				else if (fact1 >= 1234567891) {
					fact1 %= 1234567891;
				}
			}
			//r!
			for (int i = 1; i <= r; i++) {
				fact2 *= i;
				if(fact2 < 1234567891)
					continue;
				else if (fact2 >= 1234567891) {
					fact2 %= 1234567891;
				}
			}
		
			System.out.println("#" + testcase + " " +
			(result*mod_inverse((fact1*fact2)%1234567891,1234567889))%1234567891);
		}
	}// end of main
	static long mod_inverse(long a, long mod) {
		if(mod==1) return a;
		if(mod%2==0) {
			long t = mod_inverse(a,mod/2)%1234567891;
			return (t*t)%1234567891;
		} else {
			long t = mod_inverse(a,mod-1)%1234567891;
			return (t*a)%1234567891;
		}
	}
}// end of class

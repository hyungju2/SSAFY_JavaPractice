import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibo {
	static int left;
	static int right;
	static int res;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		long time = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == -1)
				break;
			left = 1;
			right = 1;
			res = 0;
			if (N <= 0)
				res = 0;
			if (0 < N && N < 2) {
				res = 1;
			}

			if (N > 2)
				fibo(N);

			if (res > 9999)
				res -= 10000;
			System.out.println(res);
		}
		
		System.out.println(System.currentTimeMillis()-time);
	} // end of main

	public static void fibo(int N) {

		if (N >= 15000) {
			int test = N%15000;
			for (int i = 0; i < test - 2; i++) {
				res = (left + right);
				left = right;
				right = res;
				if (left >= 10000) {
					left -= 10000;
				}
				if (right >= 10000) {
					right -= 10000;
				}
			}
		} else {
			for (int i = 0; i < N - 2; i++) {
				res = (left + right);
				left = right;
				right = res;

				if (left >= 10000) {
					left -= 10000;
				}
				if (right >= 10000) {
					right -= 10000;
				}
			}
		}
	}// end of fibo
	
} // end of class

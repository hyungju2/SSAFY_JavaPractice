import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_5986_새샘이와세소수_이형주 {

	static boolean check[] = new boolean[1000];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		getCheck();

		for (int testcase = 1; testcase <= T; testcase++) {
			int N = Integer.parseInt(br.readLine());
			int x = 2;
			int y = 2;
			int z = 2;
			int count = 0;
			for (x = 2; x <= N - 4; x++) { // y,z가 가질 수 있는 최소 소수는 2,2기 때문에.
				if (check[x]) // 2나 3이 아닌 소수일 떄 continue;
					continue;
				for (y = 2; x + y <= N - 2; y++) { // x+y한 값이 N을 초과해버리면 z를 확인 할 필요가 없음.
					if (x > y)
						continue;
					if (check[y]) // 두 값이 소수일 때
						continue;
					for (z = 2; x + y + z <= N; z++) {
						if (y > z)
							continue;
						if (x + y + z < N) // 3개의 합이 N보다 작다면 continue.
							continue;
						if (check[z]) // z가 소수가 아니라면, continue.
							continue;
						count++;
					}
				}
			}
			System.out.println("#" + testcase + " " + count);
		} // end of testcase
	}// end of main

	public static void getCheck() {
		check[1] = true; // true면 소수가 아니다.
		for (int i = 2; i < 1000; i++) {
			if (check[i] == false)
				for (int a = i * 2; a < 1000; a += i) {
					check[a] = true;
				}

		}
	} // get Check
}// end of class

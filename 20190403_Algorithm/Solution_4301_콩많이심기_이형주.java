import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4301 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int testcase = 1; testcase <= T; testcase++) {
			StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(tk.nextToken()); // 가로
			int M = Integer.parseInt(tk.nextToken()); // 세로

			boolean check[][] = new boolean[M][N];

			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					int nextX = i;
					int nextY = j;
					if (i >= 2) {
						nextX = i - 2;

					}
					if (j >= 2) {
						nextY = j - 2;
					}

					if (nextX != i || nextY != j) {
						if (nextX != i) {
							if (!check[nextX][j])
								check[i][j] = true;
						} else {
							if (!check[i][nextY])
								check[i][j] = true;
						}
					} else {
						check[i][j] = true;
					}

				}
			}
			int count = 0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (check[i][j])
						count++;
				}
			}
			System.out.println("#" + testcase + " " + count);
		} // end of testcase
	}// end of main
}// end of class

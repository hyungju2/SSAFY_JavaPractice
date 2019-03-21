import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3074 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int testcase = 1; testcase <= T; testcase++) {
			StringTokenizer tk = null;
			tk = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(tk.nextToken()); // 심사대 개수, 1<=N<=10^5
			int M = Integer.parseInt(tk.nextToken()); // 입국심사할 인원, 1<=M<=10^9
			int[] t = new int[N]; // 각 심사대에서 소요되는 시간

			for (int i = 0; i < N; i++) {
				t[i] = Integer.parseInt(br.readLine().trim()); // 시간 1<=M<=10^9
			}
			// 소요 시간의 범위 : 0~ 10^18
			long start = 0;
			long end = 1000000000L * M;
			long min = Long.MAX_VALUE; // M명이 입국심사할 때 필요한 소요시간의 최솟값
			while (start<=end) {
				long mid = (start + end) / 2;
				// 입국심사대에 통과하는 인원을 구하기
				long cnt = 0; // mid 시간에 심사대를 통과 한 인원
				for (int i = 0; i < N; i++) {
					cnt += mid / t[i];
				}
				// M명 , cnt명을 비교해서 범위를 재조정
				if (cnt < M) { // 작으면 범위를 큰 쪽으로 재조정
					start = mid + 1;
				} else if (M <= cnt) { // M==cnt인 경우에도 시간을 더 줄여서 다시 확인한다.
					if(min>mid) {
						min = mid;
					}
					end = min - 1;
				}
			} // end of while
			System.out.println("#" + testcase + " " + min);
		} // end of testcase
	} // end of main
} // end of class

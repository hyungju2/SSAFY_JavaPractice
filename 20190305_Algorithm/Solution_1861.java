import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1861 {
	static int dX[] = { -1, 1, 0, 0 }; // 상하좌우 dX
	static int dY[] = { 0, 0, -1, 1 }; // 상하좌우 dY
	static boolean check[][]; // check 배열
	static int arr[][]; // 정사각형
	static int count; // 방문 횟수를 count할 값
	static int N; // 방의 크기

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= T; testcase++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N]; // 방의 크기
			check = new boolean[N][N];// 방문 했는지를 check 할 배열

			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				StringTokenizer tk = new StringTokenizer(s, " ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(tk.nextToken());
				} // 배열에 저장
			} // end of Input Array
			Info[] res = new Info[N * N];
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					count = 1; // count 초기화.
					check = new boolean[N][N]; // 체크 배열 초기화.
					int num = BFS(i, j);
					res[cnt++] = new Info(i, j, num); // 현재 값과 최대 count 값을 넣어줌.
				}
			}
			Arrays.sort(res);
			int temp = res[0].count;
			int tmpx = res[0].x;
			int tmpy = res[0].y;
			
			for (int i = 1; res[i].count>=temp; i++) {
				if (arr[tmpx][tmpy] > arr[res[i].x][res[i].y]) {
					tmpx = res[i].x;
					tmpy = res[i].y;
				}
			}
			
			System.out.println("#" + testcase + " " + arr[tmpx][tmpy] + " " + (res[0].count));
		} // end of testcase

	}// end of main

	public static int BFS(int startX, int startY) {

		if (check[startX][startY]) // 방문 했다면 방문 횟수를 ArrayList에 넣어주고 종료.
		{
			return count;
		} else {
			check[startX][startY] = true;
			for (int i = 0; i < 4; i++) {
				int nextX = startX + dX[i]; // 다음 이동 할 배열
				int nextY = startY + dY[i];
				if (nextX > -1 && nextY > -1 && nextX < N && nextY < N) { // 배열의 범위 안에 있을 때
					if (!check[nextX][nextY] && (arr[startX][startY] + 1 == arr[nextX][nextY])) { // 다음 방의 크기가 1이 크다면
																									// 이동.
						count++; // 방문 횟수 증가
						BFS(nextX, nextY); // 다음지점 방문.
					}
				} else if (i == 3) {
					return count;
				}
			}

		}
		return count;
	}

	static class Info implements Comparable<Info> {
		int x;
		int y;
		int count;

		Info(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}

		@Override
		public String toString() {
			return "Info [x=" + x + ", y=" + y + ", count=" + count + "]";
		}

		public int compareTo(Info o) {
			return o.count - this.count;
		}

	}
}// end of class

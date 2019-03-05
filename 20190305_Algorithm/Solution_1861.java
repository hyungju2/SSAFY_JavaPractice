import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1861 {
	static int dX[] = { -1, 1, 0, 0 }; // �����¿� dX
	static int dY[] = { 0, 0, -1, 1 }; // �����¿� dY
	static boolean check[][]; // check �迭
	static int arr[][]; // ���簢��
	static int count; // �湮 Ƚ���� count�� ��
	static int N; // ���� ũ��

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= T; testcase++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N]; // ���� ũ��
			check = new boolean[N][N];// �湮 �ߴ����� check �� �迭

			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				StringTokenizer tk = new StringTokenizer(s, " ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(tk.nextToken());
				} // �迭�� ����
			} // end of Input Array
			Info[] res = new Info[N * N];
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					count = 1; // count �ʱ�ȭ.
					check = new boolean[N][N]; // üũ �迭 �ʱ�ȭ.
					int num = BFS(i, j);
					res[cnt++] = new Info(i, j, num); // ���� ���� �ִ� count ���� �־���.
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

		if (check[startX][startY]) // �湮 �ߴٸ� �湮 Ƚ���� ArrayList�� �־��ְ� ����.
		{
			return count;
		} else {
			check[startX][startY] = true;
			for (int i = 0; i < 4; i++) {
				int nextX = startX + dX[i]; // ���� �̵� �� �迭
				int nextY = startY + dY[i];
				if (nextX > -1 && nextY > -1 && nextX < N && nextY < N) { // �迭�� ���� �ȿ� ���� ��
					if (!check[nextX][nextY] && (arr[startX][startY] + 1 == arr[nextX][nextY])) { // ���� ���� ũ�Ⱑ 1�� ũ�ٸ�
																									// �̵�.
						count++; // �湮 Ƚ�� ����
						BFS(nextX, nextY); // �������� �湮.
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

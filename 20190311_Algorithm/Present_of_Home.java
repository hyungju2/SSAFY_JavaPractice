import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Present_of_Home {
	static int N;
	static int arr[][];
	static boolean[][] check;
	static int dX[] = { -1, 1, 0, 0 };
	static int dY[] = { 0, 0, -1, 1 };
	static int present;
	static ArrayList<Integer> res = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 2][N + 2];
		check = new boolean[N + 2][N + 2];
		for (int i = 1; i <= N; i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(tk.nextToken());
			}
		} // end of Input

		present = 0;
		check[1][1] = true;
		if (arr[1][1] == 2)
			present++;
		dfs(1, 1, present);

		int max = res.get(0);
		for (int i = 0; i < res.size(); i++) {
			if (max < res.get(i))
				max = res.get(i);
		}
		System.out.println(max);
	}// end of Main

	public static void dfs(int x, int y, int cnt) {
	
		if (x == N && y == N) {
			res.add(cnt);
			return; // 종료조건
		}

		for (int i = 0; i < 4; i++) {
			int nX = x + dX[i];
			int nY = y + dY[i];

			if (nX < 1 || nY < 1 || nX > N || nY > N)
				continue;
			else {
				if (arr[nX][nY] == 1 || check[nX][nY])
					continue;
				else {
					check[nX][nY]= true;
					if (arr[nX][nY] == 2) {
						dfs(nX, nY, cnt+ 1);
					} else {
						dfs(nX, nY, cnt);
					}
					check[nX][nY] = false;
				}
			}
		} // end of for
		return;
	}// end of bfs
}// end of class

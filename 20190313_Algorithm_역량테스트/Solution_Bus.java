import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_Bus {

	public static int n;
	private static int[][] m; // ctrl + 1 하면 자동으로 만들어짐
	public static int[][][] memo;
	
	public static void main(String[] args) throws NumberFormatException, IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());

		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine().trim());
			m = new int[n + 1][n + 1]; // 오른쪽, 하단 한줄씩 여백 안씀
			for (int i = 0; i < m.length; i++) {
				m[i][n] = 1;
				m[n][i] = 1; // 마지막 줄을 장애물로 해서 못 가도록 함.
			}

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; j++) {
					m[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			memo = new int[n][n][3]; //행, 열, mode, 계산할 경로의 개수를 저장할 배열
			for (int i = 0; i < n; i++) {
				for(int j=0; j<n; j++) {
					for(int k=0; k<3; k++) {
						memo[i][j][k] = -1; //계산 했는지 안 했는지를 비교하기 위함.
					}
			}
			}
			
			int cnt = 0;
			if (m[0][0] == 0 && m[0][1] == 0) {
				cnt += go(0, 0, 0); // 0,0 에 가로 방향으로 놓여 있는 경우
			}
			if (m[0][0] == 0 && m[1][0] == 0) {
				cnt += go(0, 0, 2); // 0,0에 세로 방향으로 높여 있는 경우
			}

			System.out.println("#" + t + " " + cnt);

		} // end for test case

	}// end of main

	/*
	 * 현재 좌표 r,c에서 도착지까지 갈 수 있는 경로의 수 r행 , c열, mode 방향, 0:가로, 1:대각, 2:세로, (r,c) 버스의
	 * 꼬리좌표
	 */
	public static int go(int r, int c, int mode) {
		if(memo[r][c][mode] !=-1) { //호출한 적이 있으면, 저장한 값으로 사용
			return memo[r][c][mode];
		}
		
		
		int cnt = 0; // 현재 좌표에서 도착지 까지 갈 수 있는 경로의 수
		if (mode == 0) { // 가로 -> 가로, 대각
			if (r == n - 1 && c + 1 == n - 1) {
				return 1;// 도착했냐?
			} else { // 도착 안했으면 재귀 호출
				if (m[r][c + 2] == 0) { // 가로 -> 가로
					cnt += go(r, c + 1, 0);
				}
				if (m[r+1][c+1] == 0 && m[r+1][c+2] == 0 && m[r+2][c+1] == 0) { // 가로 -> 대각
					cnt += go(r, c + 1, 1);
				}
			}

		} else if (mode == 1) { // 대각 -> 가로 대각 세로

			// 도착해도 대각선으로 들어오는건 인정안됨 무조건 재귀호출
			if (m[r + 1][c + 2] == 0) { // 대각 -> 가로
				cnt += go(r + 1, c + 1, 0);
			}
			if (m[r + 1][c + 2] == 0 && m[r + 2][c + 1] == 0 && m[r + 2][c + 2] == 0) { // 대각 ->세로
				cnt += go(r + 1, c + 1, 1);
			}
			if (m[r + 2][c + 1] == 0) { // 대각 -> 세로
				cnt += go(r + 1, c + 1, 2);
			}
		} else { // 세로 -> 세로, 대각
			if (r + 1 == n - 1 && c == n - 1) {// 도착했냐?
				return 1;
			} else {// 도착 안했으면 재귀 호출
				if (m[r + 1][c + 1] == 0 && m[r + 2][c] == 0 && m[r + 2][c + 1] == 0) { // 세로 -> 대각
					cnt += go(r + 1, c, 1);
				}

				if (m[r + 2][c] == 0) { // 세로 -> 세로
					cnt += go(r + 1, c, 2);
				}

			}
		}
		memo[r][c][mode]=cnt;
		return cnt;//
	}
}// end of class

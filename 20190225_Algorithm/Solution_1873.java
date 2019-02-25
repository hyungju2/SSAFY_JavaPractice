import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1873 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= T; testcase++) {
			String s = br.readLine();
			StringTokenizer tk = new StringTokenizer(s, " ");
			int H = Integer.parseInt(tk.nextToken());
			int W = Integer.parseInt(tk.nextToken());
			char[][] arr = new char[H][W];

			int x = 0; // 전차의 x위치
			int y = 0; // 전차의 y위치
			for (int i = 0; i < H; i++) {
				String num = br.readLine();
				for (int j = 0; j < W; j++) {
					arr[i][j] = num.charAt(j);
					if (num.charAt(j) == '^' || num.charAt(j) == 'v' || num.charAt(j) == '<' || num.charAt(j) == '>') {
						x = i;
						y = j;
					}
				}
			}
			
			int N = Integer.parseInt(br.readLine());
			String order = br.readLine();
			for (int i = 0; i < order.length(); i++) {
				if (order.charAt(i) == 'U') {
					arr[x][y] = '^'; // 해당 위치의 전차를 위로 바꿈
					if (x > 0) { // 범위 안에 들어갔을 떄
						if (arr[x - 1][y] == '.') // 평지라면
						{
							arr[x - 1][y] = '^'; // 위로 전차 이동
							arr[x][y] = '.'; // 전차가 이동 한 자리는 평지로
							x--; // 전차의 위치 이동
						} else
							continue;
					}
				} else if (order.charAt(i) == 'D') {
					arr[x][y] = 'v'; // 해당 위치의 전차를 위로 바꿈
					if (x < H - 1) { // 범위 안에 들어갔을 떄
						if (arr[x + 1][y] == '.') // 평지라면
						{
							arr[x + 1][y] = 'v'; // 아래로 전차 이동
							arr[x][y] = '.'; // 전차가 이동 한 자리는 평지로
							x++; // 전차의 위치 이동
						} else
							continue;
					}
				} else if (order.charAt(i) == 'L') {
					arr[x][y] = '<'; // 해당 위치의 전차를 위로 바꿈
					if (y > 0) { // 범위 안에 들어갔을 떄
						if (arr[x][y-1] == '.') // 평지라면
						{
							arr[x][y-1] = '<'; // 왼쪽으로 전차 이동
							arr[x][y] = '.'; // 전차가 이동 한 자리는 평지로
							y--; // 전차의 위치 이동
						} else
							continue;
					}
				} else if (order.charAt(i) == 'R') {
					arr[x][y] = '>'; // 해당 위치의 전차를 위로 바꿈
					if (y<W-1) { // 범위 안에 들어갔을 떄
						if (arr[x][y+1] == '.') // 평지라면
						{
							arr[x][y + 1] = '>'; // 오른쪽으로 전차 이동
							arr[x][y] = '.'; // 전차가 이동 한 자리는 평지로
							y++; // 전차의 위치 이동
						} else
							continue;
					}
				} else if (order.charAt(i) == 'S') {
					switch (arr[x][y]) {
					case '^':
						for (int j=1; x>= j; j++) {
							if(x >= j) {
							if ( arr[x-j][y] == '#') // 만약 위에가 강철 벽이라면
							{
								break;
							} else if (arr[x-j][y] == '*') { // 범위 안 넘고, 위에 값이 벽이라면
								arr[x-j][y] = '.'; // 위의 값을 평지로 바꿈
								break;
							}
							}
						}
						break;
					// end of shoot '^'
					case '<':
						for (int j = 1; y >= j; j++) {
							if(y >= j) {
							if (arr[x][y - j] == '#') // 만약 왼쪽이 강철 벽이라면
							{
								break;
							} else if (arr[x][y - j] == '*') { // 범위 안 넘고, 위에 값이 벽이라면
								arr[x][y - j] = '.'; // 위의 값을 평지로 바꿈
								break;
							}
							}
						}
						break;
					// end of shoot '<'
					case '>':

						for (int j = 1; y + j < W; j++) {
							if (y + j < W) {
								if (arr[x][y + j] == '#') // 만약 오른쪽이 강철 벽이라면
								{
									break;
								} else if (arr[x][y + j] == '*') { // 범위 안 넘고, 오른쪽 값이 벽이라면
									arr[x][y + j] = '.'; // 오른쪽 값을 평지로 바꿈
									break;
								}
							}
						}
						break;
					// end of shoot '>'
					case 'v':
						for (int j = 1; x + j < H; j++) {
							if (x + j < H) {
								if (arr[x + j][y] == '#') // 만약 아래가 강철 벽이라면
								{
									break;
								} else if (arr[x + j][y] == '*') { // 범위 안 넘고, 아래 값이 벽이라면
									arr[x+j][y] = '.'; // 아래 값을 평지로 바꿈
									break;
								}
							}
						}
						break;
					// end of shoot'v'
					}
				} // end of 'S'

			} // end of for
			System.out.print("#" + testcase + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
		} // end of testcase
	}// end of main
}// end of class

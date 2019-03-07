import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로봇이동거리_이형주 {
	static int dX[] = { -1, 1, 0, 0 };
	static int dY[] = { 0, 0, -1, 1 };
	static char arr[][];
	static char check[][];
	static int count;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= T; testcase++) {
			N = Integer.parseInt(br.readLine());
			arr = new char[N + 2][N + 2];
			robot rb[] = new robot[N * N + 1];
			check = new char[N + 2][N + 2];
			int index = 1;
			for (int i = 1; i <= N; i++) {
				StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
				for (int j = 1; j <= N; j++) {
					arr[i][j] = tk.nextToken().charAt(0);
					if (arr[i][j] == 'A' || arr[i][j] == 'B' || arr[i][j] == 'C') {
						rb[index++] = new robot(i, j, arr[i][j]);
						check[i][j] = arr[i][j]; // 로봇의 초기위치는 true.
					}
				}
			} // end of input

			count = 0;
			for (int i = 1; i < index; i++) { // 로봇의 개수만큼 반복.
				switch (rb[i].type) {
				case 'A':
					for(int j=rb[i].y+1; j<=N;j++)
						{
							if(check[rb[i].x][j]=='A'||check[rb[i].x][j]=='B'||check[rb[i].x][j]=='C'||arr[rb[i].x][j]=='W') //범위 밖
								break;
							else
									count++; //오른쪽으로만 탐색
						}
					break;
				case 'B':
					for(int j=rb[i].y-1; j>0; j--) { //왼쪽으로만 탐색
						if(check[rb[i].x][j]!=' '&&arr[rb[i].x][j]=='W')
							break;
						else
							count++;
					}
					for(int j=rb[i].y+1; j<=N; j++) { //오른으로만 탐색
						if(check[rb[i].x][j]!=' '&&arr[rb[i].x][j]=='W')
							break;
						else
							count++;
					}
					break;
				case 'C':
					for(int t=0; t<4; t++) {
						int tempX = rb[i].x+dX[t];
						int tempY = rb[i].y+dY[t];
						if(tempX<1||tempY<1||tempX>N||tempY>N)
							continue;
						else
						{
							if(check[tempX][tempY]!='A'&&check[tempX][tempY]!='B'&&arr[tempX][tempY]=='S') {
								if(t==0) {
									for(int k=tempX-1; k>1;k--) {
										if(check[k][tempY]=='A'||check[k][tempY]=='B'||check[tempX][k]=='C'||arr[k][tempY]=='W') {
										}
										count++;
									}
								}
								if(t==1) {
									for(int k=tempX+1; k<=N;k++) {
										if(check[k][tempY]=='A'||check[k][tempY]=='B'||check[tempX][k]=='C'||arr[k][tempY]=='W') {
											break;
										}
										count++;
									}
								}
								if(t==2) {
									for(int k=tempY-1; k>1;k--) {
										if(check[tempX][k]=='A'||check[tempX][k]=='B'||check[tempX][k]=='C'||arr[tempX][k]=='W') {
											break;
										}
										count++;
									}
								}
								if(t==3) {
									for(int k=tempY+1; k<=N;k++) {
										if(check[tempX][k]=='A'||check[tempX][k]=='B'||check[tempX][k]=='C'||arr[tempX][k]=='W') {
											break;
										}
										count++;
									}
								}
							}
						}
					}
				}// end of switch
			} //end of 로봇 반복
			System.out.println("#"+testcase+" "+count);
		} // end of testcase
	}// end of main

	
	public static class robot {
		int x;
		int y;
		char type;

		public robot(int x, int y, char type) {
			this.x = x;
			this.y = y;
			this.type = type;
		}

		@Override
		public String toString() {
			return "robot [x=" + x + ", y=" + y + ", type=" + type + "]";
		}

	} // end of robot
}// end of class

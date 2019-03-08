import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo1_서울_6반_이형주 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int testcase=1; testcase<=T; testcase++) {
			int N = Integer.parseInt(br.readLine());
			char arr[][] = new char [N+2][N+2]; //2차원 배열
			robot rob[] = new robot[N*N+1]; //로봇을 저장할 클래스 배열
			int cnt=1; //로봇의 개수
			for(int i=1; i<=N; i++) {
				StringTokenizer tk = new StringTokenizer(br.readLine()," ");
				for(int j=1; j<=N; j++) {
					arr[i][j] = tk.nextToken().charAt(0);
					if(arr[i][j]=='A'||arr[i][j]=='B'||arr[i][j]=='C')
					{
						rob[cnt++] = new robot(i,j,arr[i][j]);
					}
				}
			} //end of input
			
			int count = 0; //로봇의 이동거리
			for(int i=1; i<cnt; i++) { //로봇의 개수만큼 반복함.
				switch(rob[i].type) {
					case 'A':
					{
						int tempX = rob[i].x-1;
						for(int j=tempX;j>=1;j--) { //실제 로봇의 위치보다 1만큼 위에서부터 시작.
							if(arr[j][rob[i].y]!='W'&&arr[j][rob[i].y]!='A'&&arr[j][rob[i].y]!='B'&&arr[j][rob[i].y]!='C') { //벽이랑 B,C로봇 초기 위치x
								count++;
							}else
								break;
						}
					break;
					}//end of A
					case 'B':
					{
						int LeftY = rob[i].y-1; //왼쪽으로 이동
						for(int j=LeftY; j>=1; j--) {
							if(arr[rob[i].x][j]!='W'&&arr[rob[i].x][j]!='A'&&arr[rob[i].x][j]!='B'&&arr[rob[i].x][j]!='C') { //벽이랑 A,C로봇 초기 위치x
								count++;
							}else
								break;
						} //end of Left
						int RightY = rob[i].y+1; //오른쪽으로 이동.
						for(int j = RightY; j<=N; j++) { //배열의 범위안에 들어갈 때
							if(arr[rob[i].x][j]!='W'&&arr[rob[i].x][j]!='A'&&arr[rob[i].x][j]!='B'&&arr[rob[i].x][j]!='C') { //벽이랑 A,C로봇 초기 위치x
								count++;
							}else
								break;
						} //end of Left
						break;
					}//end of B
					case 'C':
					{
						int tempX = rob[i].x-1;
						for(int j=tempX;j>=1;j--) { //위로이동
							if(arr[j][rob[i].y]!='W'&&arr[j][rob[i].y]!='A'&&arr[j][rob[i].y]!='B'&&arr[j][rob[i].y]!='C') { //벽이랑 B,C로봇 초기 위치x
								count++;
							}else
								break;
						} //end of top
						
						tempX = rob[i].x+1;
						for(int j=tempX;j<=N;j++) { //실제 로봇의 위치보다 1만큼 위에서부터 시작.
							if(arr[j][rob[i].y]!='W'&&arr[j][rob[i].y]!='A'&&arr[j][rob[i].y]!='B'&&arr[j][rob[i].y]!='C') { //벽이랑 B,C로봇 초기 위치x
								count++;
							}else
								break;
						} //end of down
						
						int LeftY = rob[i].y-1; //왼쪽으로 이동
						for(int j=LeftY; j>=1; j--) {
							if(arr[rob[i].x][j]!='W'&&arr[rob[i].x][j]!='A'&&arr[rob[i].x][j]!='B'&&arr[rob[i].x][j]!='C') { //벽이랑 A,C로봇 초기 위치x
								count++;
							}else
								break;
						} //end of Left
						
						int RightY = rob[i].y+1; //오른쪽으로 이동.
						for(int j = RightY; j<=N; j++) { //배열의 범위안에 들어갈 때
							if(arr[rob[i].x][j]!='W'&&arr[rob[i].x][j]!='A'&&arr[rob[i].x][j]!='B'&&arr[rob[i].x][j]!='C') { //벽이랑 A,C로봇 초기 위치x
								count++;
							}else
								break;
						} //end of Left
						break;
					}//end of C
				} //end of switch
			}
			System.out.println("#"+testcase+" "+count);
		}//end of testcase
	}//end of main
	
	public static class robot{
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
		
	}
}//end of class

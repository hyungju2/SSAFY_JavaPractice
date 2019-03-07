import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Z56_파핑파핑지뢰찾기 {

	public static int[] dy = {-1,-1,-1,0,0,1,1,1}; //행
	public static int[] dx = {-1,0,1,-1,1,-1,0,1}; //열
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 1<=N<=300, 맵의 크기

		for (int testcase = 1; testcase <= T; testcase++) {
			int N = Integer.parseInt(br.readLine()); // 1<=N<=300, 맵의 크기
			char[][] m = new char[N + 2][N + 2]; // 입력받은 맵을 저장, 외곽을 한줄씩 여분을 둔다.
			
			for (int i = 1; i <= N; i++) {
				String s = br.readLine();
				for (int j = 1; j <= N; j++) {
					m[i][j] = s.charAt(j - 1);
				}
			} // end of input
			
			int[][] cnt = new int[N + 2][N + 2];// 폭탄의 개수를 표시하는 맵
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (m[i][j] == '*') // 폭탄이라면
					{
						cnt[i][j] = -1; // 폭탄이라는 의미.
						continue;
					}
					//인접칸들의 폭탄 개수를 카운팅
					for(int k=0; k<dy.length; k++) {
						if(m[i+dy[k]][j+dx[k]] =='*') {
							cnt[i][j]++;
						}
					}
				}
			}
			boolean[][] visited = new boolean[N+2][N+2]; //방문 여부를 체크할 변수.
			
			for(int i=0; i<visited.length; i++) { //외곽의 한줄을 방문한 것으로 미리 저장. (외곽 한 줄 안쓰면 필요x)
				visited[0][i] = true;
				visited[N+1][i] = true;
				visited[i][0] = true;
				visited[i][N+1] = true;
			}
			
			int result = 0; //클릭 회수를 저장할 변수
			//cnt[][] 에서 폭탄이 없는 0인 칸을 찾아서 열기
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(visited[i][j] ==false && cnt[i][j]==0) {
						bfs(visited,cnt,i,j);
						result++;
					}
				}
			}
			//방문하지 않은, 폭탄이 아닌 숫자들(열리지 않은 칸) 개수를 카운팅
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(visited[i][j] == false && cnt[i][j]>0) {
						result++;
					}
				}
			}
			
			System.out.println("#"+testcase+" "+result);
			
		} // end of testcase
	}// end of main
	
	public static int[][] q = new int[900000][2];
	//현재칸이 0이면, 인접한 칸들 중 0보다 큰 숫자칸을 방문한 것으로 표시.

	public static void bfs(boolean[][] visited, int[][]cnt, int r, int c) {
		int front = -1;
		int rear = -1;
		visited[r][c] = true;
		q[++rear][0] = r;
		q[rear][1] = c;
		while(front != rear) { //큐가 비어있지 않으면 반복
			r = q[++front][0]; //큐에서 1개 꺼내기
			c = q[front][1];
			//방문작업 : 인접한 칸들 중 0보다 큰 숫자칸을 방문한 것으로 표시.
			for (int i = 0; i < dy.length; i++) {
				if(visited[r+dy[i]][c+dx[i]]==false&&cnt[r+dy[i]][c+dx[i]]>0) {
					visited[r+dy[i]][c+dx[i]]=true;
				}
			}
			
			//방문을 안한, 인접한 칸을 큐에 넣기
			for (int i = 0; i < dy.length; i++) {
				if(visited[r+dy[i]][c+dx[i]]==false) {
					q[++rear][0] = r+dy[i];
					q[rear][1] = c+dx[i];
					visited[r+dy[i]][c+dx[i]]=true;
				}
			}
		}
	} //end of bfs
	
}// end of class

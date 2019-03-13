import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution7208 {

	static int N;
	static int arr[][];
	static int color[];
	static boolean check[];
	static int res;
	static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= T; testcase++) {
			N = Integer.parseInt(br.readLine()); // 배열의 크기
			arr = new int[N+2][N+2];
			color = new int[N+1];
			visited = new boolean[N+2][N+2];
			check = new boolean[5];

			StringTokenizer tk = null;
			tk = new StringTokenizer(br.readLine(), " ");
			
			for (int i = 1; i <=N ; i++) {
				color[i] = Integer.parseInt(tk.nextToken()); // color입력받음.
				check[color[i]] = true; // 사용한 값은 true로
			}

			for (int i = 1; i <= N; i++) {
				tk = new StringTokenizer(br.readLine(), " ");
				for (int j = 1; j <= N; j++) {
					arr[i][j] = Integer.parseInt(tk.nextToken());
				}
			} // end of Input

			res = 0;
			for (int i = 1; i <= N; i++) {
				search(i);
			}
			System.out.println("#" + testcase + " " + res);
		} // end of testcase
	}// end of main

	private static void search(int start) {
		for (int i = 1; i <= N; i++) {
			if (arr[start][i]==0||visited[start][i])
				continue;
				// check가 false라면, 사용되지 않은 색임.
				visited[start][i] = true;
				visited[i][start] = true;
				
				if (color[start] == color[i]) { //두개의 색이 같다.
					for(int k=1; k<=N; k++) {
						if(start==k)
							continue;
						
						else{
							boolean checkcol[] = new boolean[N+1];
							for(int t=1; t<=N; t++) {
							if(arr[i][t]==1) { //이후 연결된 애들
								checkcol[color[t]]=true; //이후 연결된 애들
							}
						}
							for(int g=1; g<checkcol.length; g++) {
								if(checkcol[g])continue;
								else{
									color[i]=g;
									res++;
									return;
								}
								}
						}
			}//end of k 두 색이 같다
		} //end of 두개의 색
		} // end of search
	}
}// end of class

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution_2819 {

	public static HashSet<String> hs;

	public static int x = 1;
	public static int y = 1;

	public static int dx[] = {-1,1,0,0};
	public static int dy[] = {0,0,-1,1};
	public static int d[][] = new int[6][6];
	public static int arr[][] = new int[6][6];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= T; testcase++) {

		
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 6; j++) {
					arr[i][j] = 0;
				}
			}

			String line1 = br.readLine();
			String line2 = br.readLine();
			String line3 = br.readLine();
			String line4 = br.readLine();

			StringTokenizer tk = new StringTokenizer(line1, " ");
			StringTokenizer tk2 = new StringTokenizer(line2, " ");
			StringTokenizer tk3 = new StringTokenizer(line3, " ");
			StringTokenizer tk4 = new StringTokenizer(line4, " ");

			for (int i = 1; i < 5; i++) {
				arr[1][i] = Integer.parseInt(tk.nextToken());
			}

			for (int i = 1; i < 5; i++) {
				arr[2][i] = Integer.parseInt(tk2.nextToken());
			}

			for (int i = 1; i < 5; i++) {
				arr[3][i] = Integer.parseInt(tk3.nextToken());
			}

			for (int i = 1; i < 5; i++) {
				arr[4][i] = Integer.parseInt(tk4.nextToken());
			}
			hs = new HashSet<String>();
			
			String result = "";
			for(int i=1; i<5; i++) {
				for(int j=1; j<5; j++) {
					result = arr[i][j]+"";
					DFS(result,0,i-1,j-1,6);
				}
			}
			
			System.out.println(hs.size());
		} // end of testcase
	}// end of main

	public static void DFS(String str,int depth, int x, int y, int cnt) {
		if(depth==cnt) {
			hs.add(str);
			return;
		}
		for(int i=0; i<4; i++) {
			int tmpx = x+dx[i];
			int tmpy = y+dy[i];
			if(!(tmpx>=1 && tmpy>=1||tmpx<5||tmpy<5)) {
				continue;
			}
			str += arr[tmpx][tmpy];
			DFS(str, depth+1, tmpx,tmpy,cnt--);
			str = str.substring(0,depth+1);
		}
	}
}// end of class

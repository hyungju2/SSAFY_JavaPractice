import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution_1082 {
	static int startX = 0;
	static int startY = 0;
	static int count = 0;
	static int dX[] = { -1, 1, 0, 0 };
	static int dY[] = { 0, 0, -1, 1 };
	static int x;
	static int y;
	static boolean check[][];
	static ArrayList<Integer> res = new ArrayList<>();
	static char arr[][];
	static HashSet<Fire> hs = new HashSet<>();
	static int tmpx;
	static int tmpY;
	static int ry;
	static int rx;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer tk = new StringTokenizer(s, " ");
		x = Integer.parseInt(tk.nextToken());
		y = Integer.parseInt(tk.nextToken());
		
		arr = new char[x + 1][y + 1]; // x,y 1부터 사용
		check = new boolean[x + 1][y + 1];
	
		for (int i = 1; i <= x; i++) {
			s = br.readLine();
			for (int j = 1; j <= y; j++) {
				char c = s.charAt(j - 1);
				if (c == 'S') { //도착지
					startX = i;
					startY = j;
				}
				if(c=='*') 
				{
					hs.add(new Fire(i,j)); //불이난 객체 생성하여 hash에 넣어줌.
				}
				arr[i][j] = c;
			}
		} // end of input
		int result = BFS(startX, startY);
				if(result==0)
					{System.out.println("impossible");
					}
				else
					System.out.println(result);
					}// end of main

	public static int BFS(int a, int b) {
		if (arr[a][b] == 'D') {
			return count;
		} else
			
			for(Fire p : hs) {
				Fire t = p;
				tmpx=t.x;
				tmpY=t.y;
				for(int k=0; k<4;k++) {
					rx=tmpx+dX[k]; //불이 이동하는 자리
					ry=tmpY+dY[k];
					
					if(rx > 0 && ry > 0 && rx <= x && ry <= y) { //불이 범위를 안 나갔을 때
						if(arr[rx][ry]=='.')
						{
							arr[rx][ry]='*'; //인접한 곳 모두 불 옮기기
						}
					}
				
				}
			} //불 옮기는 곳.
			
			for(int tx=1; tx<=x; tx++) {
				for(int ty=1; ty<=y; ty++) {
					if(arr[tx][ty]=='*')
					{
						hs.add(new Fire(tx,ty));
					}
				}
			}
			
		//불 저장
		
		 //평지일 떄
			for (int i = 0; i < 4; i++) {
				int neX = a + dX[i];
				int neY = b + dY[i];
			
				
				if (neX > 0 && neY > 0 && neX <= x && neY <= y) // 범위 안에 들어왔을 떄
				{
					if (check[neX][neY])
						continue; // 방문 했다면
					
					if (arr[neX][neY] == '.' || arr[neX][neY] == 'D') {
						count++;
						check[neX][neY] = true;
						return BFS(neX, neY);
					}
				}
			}
		return 0;
	}
	
	static class Fire{
		int x;
		int y;
		Fire(int x, int y){
			this.x = x;
			this.y = y;
		}
		}
}// end of class


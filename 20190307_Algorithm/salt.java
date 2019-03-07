import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소금쟁이합계_이형주 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int testcase=1; testcase<=T; testcase++) {
			StringTokenizer tk = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(tk.nextToken()); //배열
			int S = Integer.parseInt(tk.nextToken()); //소금쟁이 수
			int arr[][] = new int[N][N];
			Bug barr[] = new Bug[S];
			boolean visited[][] = new boolean[N+1][N+1];
			
			for(int i=0; i<S;i++) {
				StringTokenizer tk2 = new StringTokenizer(br.readLine()," ");
				barr[i] = new Bug(Integer.parseInt(tk2.nextToken()),Integer.parseInt(tk2.nextToken()),Integer.parseInt(tk2.nextToken()));
			}
			int count = 0;
			int temp=0;
			for(int i=0; i<S;i++) {
				switch(barr[i].jump)
				{
				case 1:
					temp=0;
					temp=barr[i].x;
					for(int t=3; t>=1; t--) {
						temp-=t;
					}
					if(temp>=0&&!visited[temp][barr[i].y]) {
						visited[temp][barr[i].y] = true;
						count++;
						}
					break;
				case 2:
					temp=0;
					temp=barr[i].x;
					for(int t=3; t>=1; t--) {
						temp+=t;
					}
					if(temp<N &&!visited[temp][barr[i].y]) {
						visited[temp][barr[i].y] = true;
						count++;
						}
					break;
				case 3:
					temp=0;
					temp=barr[i].y;
					for(int t=3; t>=1; t--) {
						temp-=t;
					}
					if(temp>=0&&!visited[barr[i].x][temp]) {
						visited[barr[i].x][temp] = true;
						count++;
						}
					break;
				case 4:
					temp=0;
					temp=barr[i].y;
					for(int t=3; t>=1; t--) {
						temp+=t;
					}
					if(temp<N&&!visited[barr[i].x][temp]) {
						visited[barr[i].x][temp] = true;
						count++;
						}
					break;
				}
			}
			System.out.println("#"+testcase+" "+count);
		}//end of testcase
	}//end of main
	
	public static class Bug{
		int x;
		int y;
		@Override
		public String toString() {
			return "Bug [x=" + x + ", y=" + y + ", jump=" + jump + "]";
		}
		int jump;
		public Bug(int x, int y, int jump) {
			this.x = x;
			this.y = y;
			this.jump = jump;
		}
		
	}
}//end of class

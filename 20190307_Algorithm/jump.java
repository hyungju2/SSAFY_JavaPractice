import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 점프사방_이형주 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int testcase=1; testcase<=T; testcase++) {
			StringTokenizer tk = new StringTokenizer(br.readLine()," ");
			int Y = Integer.parseInt(tk.nextToken());
			int X = Integer.parseInt(tk.nextToken());
			int N = Integer.parseInt(tk.nextToken()); //사람 수
			
			int arr[][] = new int[Y+2][X+2];
			human hm[] = new human[N+1]; //사람 수만큼 human 배열 만듦.
			
			for(int i=1; i<=Y; i++) {
				StringTokenizer tk2 = new StringTokenizer(br.readLine()," ");
				for(int j=1; j<=X; j++) {
					arr[i][j] = Integer.parseInt(tk2.nextToken());
				}
			}
			
			for(int i=1; i<N+1; i++) { //참가자의 시작위치, 행, 열, 횟수를 입력받기 위함.
				StringTokenizer tk3 = new StringTokenizer(br.readLine()," ");
				hm[i] = new human(Integer.parseInt(tk3.nextToken()),Integer.parseInt(tk3.nextToken()),Integer.parseInt(tk3.nextToken()),1000);
			}
			StringTokenizer tk4 = new StringTokenizer(br.readLine()," ");
			int cnt = Integer.parseInt(tk4.nextToken()); //함정 수
			for(int i=0; i<cnt; i++) {
				int tx = Integer.parseInt(tk4.nextToken());
				int ty = Integer.parseInt(tk4.nextToken());
				arr[tx][ty] = -1; //함정은 -1로 표시
			}
			int price = 0; //상금의 합계
			for(int i=1; i<=N; i++) { //사람 수만큼 반복.
				for(int j=0; j<hm[i].cnt; j++) { //해당 사람의 기회만큼 반복.
				int temp = arr[hm[i].x][hm[i].y]; //사람의 초기좌표에 있는 arr의 실제 값.
				//두 자리의 숫자 중 앞자리가 점프 방향,(오른,아래,왼쪽,위쪽)
				//두 자리의 숫자 중 뒷자리가 점프 칸수
					int d = temp/10; //방향
					int c = temp%10; //칸수
			
					switch(d) {
				case 1:{
					
					hm[i].y+=c; //오른쪽으로 이동.
					if(hm[i].y>Y||arr[hm[i].x][hm[i].y]==-1) { //범위 초과
						hm[i].price = -1000;
						hm[i].cnt=0; //기회 끝
					}
					break;
				}
				case 2:{
					hm[i].x+=c; //아래로 이동.
					if(hm[i].x>X||arr[hm[i].x][hm[i].y]==-1) { //범위 초과
						hm[i].price = -1000;
						hm[i].cnt=0; //기회 끝
					}
					break;
				}
				case 3:{
					hm[i].y-=c; //왼쪽으로 이동.
					if(hm[i].x<1||arr[hm[i].x][hm[i].y]==-1) { //범위 초과
						hm[i].price = -1000;
						hm[i].cnt=0; //기회 끝
					}
					break;
				}
				case 4:
				{
					hm[i].x-=c; //위로 이동.
					if(hm[i].x<1||arr[hm[i].x][hm[i].y]==-1) { //범위 초과
						hm[i].price = -1000;
						hm[i].cnt=0; //기회 끝
					}
					break;
					}
				} //end of switch
					
				}//사람의 기회만큼
				if(hm[i].price!=-1000) { //-1000이 아니라면
					hm[i].price = arr[hm[i].x][hm[i].y]*100-1000;
					price+=hm[i].price;
				}else
				{
					price+=hm[i].price;
				}
			} //end of human recur 
			System.out.println("#"+testcase+" "+price);
		} //end of testcase
	}//end of main
	
	public static class human{
		int x;
		int y;
		int cnt;
		int price;
		@Override
		public String toString() {
			return "human [x=" + x + ", y=" + y + ", cnt=" + cnt + "]";
		}
		public human(int x, int y, int cnt, int price) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.price = price;
		}
		
	} //end of human
}//end of class

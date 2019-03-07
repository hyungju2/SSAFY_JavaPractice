import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 빌딩_이형주 {
	static char arr[][];
	static int dX[] = {-1,-1,-1,0,0,1,1,1};
	static int dY[] = {-1,0,1,-1,1,-1,0,1};
	static int result[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int testcase=1; testcase<=T; testcase++) {
			int N = Integer.parseInt(br.readLine());
			arr = new char[N][N];
			result = new int[400]; //각 빌딩의 높이를 저장
			for(int i=0;i <N; i++) {
				StringTokenizer tk = new StringTokenizer(br.readLine()," ");
				for(int j=0; j<N; j++) {
					arr[i][j] =tk.nextToken().charAt(0);
				}
			}
			int cnt=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					int checkG=0;
					int temp=0;
					if(arr[i][j]=='G')
						continue;
					for(int k=0; k<8;k++) {
						int nextX = i+dX[k];
						int nextY = j+dY[k];
						if(nextX<0||nextY<0||nextX>=N||nextY>=N) {
							continue;
						}else
						{
							if(arr[nextX][nextY]=='G')
							{
								result[cnt++]=2;
								checkG++;
								break;
							}
						}
					} //end of nextX,nextY
					if(checkG==0) {
						for(int t=0; t<N; t++) {
							if(arr[i][t]=='B')
								temp++;
							if(arr[t][j]=='B')
								temp++;
						}
					result[cnt++]=temp-1;
					} //checkG ==0
				}
			}
			Arrays.sort(result);
			System.out.println("#"+testcase+" "+result[399]);
		} //end of testcase
	}//end of main
}//end of class

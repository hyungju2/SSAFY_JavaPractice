import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Algo2_서울_6반_이형주 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int testcase=1; testcase<=T; testcase++) {
			int W = Integer.parseInt(br.readLine()); //중량
			int N = Integer.parseInt(br.readLine()); //봉지의 개수
			
			int res[][] = new int[N+1][W+1];
			int temp[] = new int[N+1];
			StringTokenizer tk = new StringTokenizer(br.readLine()," ");
			for(int i=1; i<=W; i++) {
				res[0][i] = i;
			}
			for(int i=1; i<=N; i++) {
				temp[i] = Integer.parseInt(tk.nextToken());
			}
			Arrays.sort(temp);
			
			for(int i=1; i<=N; i++) {
				res[i][0] = temp[i];
			}
			
			for(int i=1; i<=W; i++) { //제일 작은 값으로 초기화
				if(res[1][0]<=res[0][i]) {
					if(res[0][i]%res[1][0]==0)
					{
						res[1][i] = res[0][i]/res[1][0];
					}
					else
						res[1][i] = 0;
				}
			}
			
			for(int i=2; i<=N; i++) { //초기화 이후부터 반복 진행.(봉지의 개수만큼)
				int m = 0;
				for(int j=1; j<=W; j++) { //밀가루의 중량만큼.
					
					if(res[i][0]>res[0][j]) {
					res[i][j]=res[i-1][j]; //이전 값을 그대로 가져옴.
						}
					else { //비교 연산 시작.
							if(res[0][j]%res[i][0]==0) //본인의 무게랑 같다면
							{
								m=j;
								res[i][j]=res[0][j]/res[i][0]; //본인것으로 하나 채우는게 가장 최적.
								continue;
							}
							else {
								int tem = res[0][j]-m;//총 용량에서 본인 무게 값 뻄
								int min =W; //최대
								for(int t=1;t<=i; t++) { //밀가루 열의 담을 수 있는최솟값 찾음
									if(min>res[t][tem])
										min=res[t][tem]; //밀가루 열에서 담을 수 있는 최솟값 찾음
								}
								if(res[i-1][j] > tem+min)
								{
									if(min==0&&res[i-1][j]!=0)
										res[i][j] = res[i-1][j];
									if(min==0&&res[i-1][j]==0)
										res[i][j] = 0;
									else
										res[i][j] = res[i][m]+min;
								}else
								{
									res[i][j] = res[i-1][j];
								}
							}
							
					}
				} //밀가루 중량만큼 반복
			}//봉지의 개수만큼 반복
		if(res[N][W]==0) {
			System.out.println("#"+testcase+" "+"-1");
		}else {
			System.out.println("#"+testcase+" "+res[N][W]);
		}
		}//end of testcase
	}//end of main
}

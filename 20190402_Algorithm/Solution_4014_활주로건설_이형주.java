import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4014 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for(int testcase=1; testcase<=T; testcase++) {
			StringTokenizer tk = null;
			tk = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(tk.nextToken()); // N*N 지형 높이
			int X = Integer.parseInt(tk.nextToken()); // 경사로의 가로길이
			int arr[][] = new int[N][N]; //활주로 
			boolean check[][] = new boolean[N][N];
			for(int i=0; i<N; i++) {
				tk = new StringTokenizer(br.readLine()," ");
				for(int j=0; j<N; j++) {
					arr[i][j]=Integer.parseInt(tk.nextToken());
				}
			}
			int res=0;
			int d = 0; //방향. 0이면 같다, -1이면 내려간다, 1이면 올라간다 
			int height = 0;
			int tem=0;
			for(int i=0; i<N; i++) {
				tem=0;
				for(int j=1; j<N; j++) {
					if(j==1) { //처음일 때는 방향을 정해줘야 함.
					if(arr[i][j]>arr[i][j-1])
					{
						d=1; //올라간다
						height = arr[i][j]-arr[i][j-1];
						if(j-X<0||X==0)
						{
						tem=-1;
						break;
						}
					for(int t=1; t<X; t++) {
						if(arr[i][j-1-t]!=arr[i][j-t]&&!check[i][j-1-t]&&!check[i][j-t])
							{
							tem = -1;
							}
					}
					if(tem!=-1) { //활주로 사용한 것 check
						for(int t=1; t<=X; t++) {
							check[i][j-t] = true;
						}
					}
						if(height!=1) //높이가 1이상이면 의미x{
						{
						tem=-1;
						}
					}else if(arr[i][j]<arr[i][j-1]) {
							d=-1; //내려간다
							height = arr[i][j-1]-arr[i][j];
							if(j-1+X>=N||X==0)
							{
								tem=-1;
								break;
							}
							for(int t=0; t<X-1; t++) {
								if(arr[i][j+t]!=arr[i][j+t+1]||check[i][j+t]||check[i][j+t+1])
								{
									tem=-1;
									break;
								}
							}
							if(tem!=-1) {
								for(int t=1; t<=X;t++) {
									check[i][j-1+t]=true;
								}
							}
							if(height!=1) //높이가 1이상이면 의미x
							{
								tem=-1;
							}
					}
					else {
						d=0; //같다
						height = 0;
						
					}
					} //처음일 때
					
					
					else {
						if(d==1) { 
							if(arr[i][j]<arr[i][j-1])
								{
								if(j-1+X>=N||X==0)
								{
									tem=-1;
									break;
								}
								for(int t=0; t<X-1; t++) {
									if(arr[i][j+t]!=arr[i][j+t+1]||check[i][j+t]||check[i][j+t+1])
									{
										tem=-1;
										break;
									}
								}
								if(tem!=-1) {
									for(int t=1; t<=X;t++) {
										check[i][j-1+t]=true;
									}
								}
								}
							if(arr[i][j]>arr[i][j-1]) { //크다면 경사로만큼 반복되어야 함.
								if(j-X<0||X==0)
								{
								tem=-1;
								break;
								}
							for(int t=1; t<X; t++) {
								if(arr[i][j-1-t]!=arr[i][j-t]||check[i][j-1-t]||check[i][j-t])
									{
									tem = -1;
									}
							}
							if(tem!=-1) { //활주로 사용한 것 check
								for(int t=1; t<=X; t++) {
									check[i][j-t] = true;
								}
							}
							}
							d=0;
						}else if(d==0) { //아무거나 상관 없으나, 높이차이 1이하
							if(Math.abs(arr[i][j]-arr[i][j-1])>1)
								{tem = -1;
								}
							if(arr[i][j]>arr[i][j-1]) //올라갈 때
								{
								if(j-X<0||X==0)
								{
								tem=-1;
								break;
								}
							for(int t=1; t<X; t++) {
								if(arr[i][j-1-t]!=arr[i][j-t]||check[i][j-1-t]||check[i][j-t])
									{
									tem = -1;
									}
							}
							if(tem!=-1) { //활주로 사용한 것 check
								for(int t=1; t<=X; t++) {
									check[i][j-t] = true;
								}
							}
								d=1;
								} //올라갈 때
							else if(arr[i][j]<arr[i][j-1]) { //내려갈 때
								if(j-1+X>=N||X==0)
								{
									tem=-1;
									break;
								}
								for(int t=0; t<X-1; t++) {
									if(arr[i][j+t]!=arr[i][j+t+1]||check[i][j+t]||check[i][j+t+1])
									{
										tem=-1;
										break;
									}
								}
								if(tem!=-1) {
									for(int t=1; t<=X;t++) {
										check[i][j-1+t]=true;
									}
								}
								d=-1;
							}
							else {
								d=0;
							}
						} //같을 때
						else { //내려갈 때, 같은 것만 허용.
							if(arr[i][j]!=arr[i][j-1])
								{
								tem = -1;
								}
							d=0;
						}
					}
					
				}//end of j
				if(tem!=-1)res++;
			} //end of i
			//가로 구하기
			
			//세로 구하기
			
			for(int i=0; i<check.length; i++) {
				for(int j=0; j<check.length; j++) {
					check[i][j]=false;
				}
			}
	
			d = 0; //방향. 0이면 같다, -1이면 내려간다, 1이면 올라간다 
			height = 0;
			tem=0;
			for(int j=0; j<N; j++) {
				tem=0;
				for(int i=1; i<N; i++) {
					if(i==1) { //처음일 때는 방향을 정해줘야 함.
					if(arr[i][j]>arr[i-1][j])
					{
						d=1; //올라간다
						height = arr[i][j]-arr[i-1][j];
					
						if(i-X<0||X==0)
						{
							tem=-1;
							break;
						}
						
						for(int t=1; t<X; t++) {
							if(arr[i-1-t][j]!=arr[i-t][j]||check[i-1-t][j]||check[i-t][j])
								{tem = -1;
								}
						}
						
						if(height!=1) //높이가 1이상이면 의미x{
						{
							tem=-1;
						}
						if(tem!=-1) {
							for(int t=1; t<=X; t++) {
								check[i-t][j]=true;
							}
						}
					}else if(arr[i][j]<arr[i-1][j]) {
							d=-1; //내려간다
							height = arr[i-1][j]-arr[i][j];
							
							if(i-1+X>=N||X==0)
							{
								tem=-1;
								break;
							}
							for(int t=0; t<X-1; t++) {
								if(arr[i+t][j]!=arr[i+t+1][j]||check[i+t][j]||check[i+t+1][j])
								{
									tem=-1;
									break;
								}
							}
							if(height!=1) //높이가 1이상이면 의미x
							{
								tem=-1;
							}
							if(tem!=-1) {
								for(int t=1; t<=X; t++) {
									check[i-1+t][j]=true;
								}
							}
					}
					else {
						d=0; //같다
						height = 0;
						
					}
					} //처음일 때
					
					
					else {
						if(d==1) { //올라간다면 같거나, 올라가야 함
							if(arr[i][j]<arr[i-1][j])
								{
								if(i-1+X>=N||X==0)
								{
									tem=-1;
									break;
								}
								for(int t=0; t<X-1; t++) {
									if(arr[i+t][j]!=arr[i+t+1][j]||check[i+t][j]||check[i+t+1][j])
									{
										tem=-1;
										break;
									}
								}
							
								if(tem!=-1) {
									for(int t=1; t<=X; t++) {
										check[i-1+t][j]=true;
									}
								}
								}
							if(arr[i][j]>arr[i-1][j]) { //크다면 경사로만큼 반복되어야 함.
								if(i-X<0||X==0)
								{
									tem=-1;
									break;
								}
								
								for(int t=1; t<X; t++) {
									if(arr[i-1-t][j]!=arr[i-t][j]||check[i-1-t][j]||check[i-t][j])
										{tem = -1;
										}
								}
								
								if(tem!=-1) {
									for(int t=1; t<=X; t++) {
										check[i-t][j]=true;
									}
								}
							}
							d=0;
						}else if(d==0) { //아무거나 상관 없으나, 높이차이 1이하
							if(Math.abs(arr[i][j]-arr[i-1][j])>1)
								{tem = -1;
								}
							if(arr[i][j]>arr[i-1][j]) //올라갈 때
								{
								if(i-X<0||X==0)
								{
									tem=-1;
									break;
								}
								
								for(int t=1; t<X; t++) {
									if(arr[i-1-t][j]!=arr[i-t][j]||check[i-1-t][j]||check[i-t][j])
										{tem = -1;
										}
								}
							
								if(tem!=-1) {
									for(int t=1; t<=X; t++) {
										check[i-t][j]=true;
									}
								}
								d=1;
								} //올라갈 때
							else if(arr[i][j]<arr[i-1][j]) { //내려갈 때
								if(i-1+X>=N||X==0)
								{
									tem=-1;
									break;
								}
								for(int t=0; t<X-1; t++) {
									if(arr[i+t][j]!=arr[i+t+1][j]||check[i+t][j]||check[i+t+1][j])
									{
										tem=-1;
										break;
									}
								}
							
								if(tem!=-1) {
									for(int t=1; t<=X; t++) {
										check[i-1+t][j]=true;
									}
								}
								d=-1;
							}
							else {
								d=0;
							}
						} //같을 때
						else { //내려갈 때, 같은 것만 허용.
							if(arr[i][j]!=arr[i-1][j])
								{
								tem = -1;
								}
							d=0;
						}
					}
					
				}//end of j
				if(tem!=-1)res++;
			} //end of i
			//가로 구하기
			
			
			System.out.println("#"+testcase+" "+res);
		}//end of testcase
	}//end of main
}//end of class

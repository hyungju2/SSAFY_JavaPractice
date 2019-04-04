import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_6109 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int testcase = 1; testcase <= T; testcase++) {
			StringTokenizer tk = null;
			tk = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(tk.nextToken());
			String direction = tk.nextToken();
			int arr[][] = new int[N][N];
			boolean check[][] = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				tk = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(tk.nextToken());
				}
			} // end of Input

			switch (direction) {
			case "up":
				for (int i = 1; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (arr[i - 1][j] == arr[i][j] && !check[i - 1][j]&& !check[i][j]) {
							arr[i - 1][j] += arr[i][j]; // 두개 더해줌.
							check[i - 1][j] = true; // 더해진 숫자라는 것을 알리기 위한 check
							arr[i][j] = 0;
						}
						if (arr[i - 1][j] == 0) {
							{
								int t = 0;
								for (; i - 1 - t >= 0; t++) {
									if (arr[i - 1 - t][j] == 0) {
										check[i-1-t][j]=false;
										arr[i-1-t][j] = arr[i-t][j];
										arr[i-t][j] = 0;
									} else
										break;
								}
								if(i-1-t>=0) {
								if(arr[i-1-t][j]==arr[i-t][j]&&!check[i-1-t][j]&&!check[i-t][j]) {
									arr[i-1-t][j] += arr[i-t][j];
									arr[i-t][j]=0;
									check[i-1-t][j]=true;
								}
								}
							}

						}
					}
				}
				break;
			case "down":
				for (int i = N-2; i >=0; i--) {
					for (int j = 0; j < N; j++) {
						if (arr[i+1][j] == arr[i][j] && !check[i+1][j]&& !check[i][j]) {
							arr[i+1][j] += arr[i][j]; // 두개 더해줌.
							check[i+1][j] = true; // 더해진 숫자라는 것을 알리기 위한 check
							arr[i][j] = 0;
						}
						if (arr[i+1][j] == 0) {
							{
								int t = 0;
								for (; i+1+t<N; t++) {
									if (arr[i+1+t][j] == 0) {
										check[i+1+t][j]=false;
										arr[i+1+t][j]=arr[i+t][j];
										arr[i+t][j] = 0;
									} else
										break;
								}
								if(i+1+t<N) {
								if(arr[i+1+t][j]==arr[i+t][j]&&!check[i+1+t][j]&&!check[i+t][j]) {
									arr[i+1+t][j] += arr[i+t][j];
									arr[i+t][j]=0;
									check[i+1+t][j]=true;
								}
								}
							}

						}
					}
				}
				break;
			case "left":
				for (int i = 0; i <N; i++) {
					for (int j = 1; j<N; j++) {
						if (arr[i][j-1] == arr[i][j] && !check[i][j-1]&& !check[i][j]) {
							arr[i][j-1] += arr[i][j]; // 두개 더해줌.
							check[i][j-1] = true; // 더해진 숫자라는 것을 알리기 위한 check
							arr[i][j] = 0;
						}
						if (arr[i][j-1] == 0) {
							{
								int t = 0;
								for (; j-1-t>=0; t++) {
									if (arr[i][j-1-t] == 0) {
										check[i][j-1-t]=false;
										arr[i][j-1-t] = arr[i][j-t];
										arr[i][j-t] = 0;
									} else
										break;
								}
								if(j-1-t>=0) {
								if(arr[i][j-1-t]==arr[i][j-t]&&!check[i][j-1-t]&&!check[i][j-t]) {
									arr[i][j-1-t] += arr[i][j-t];
									arr[i][j-t]=0;
									check[i][j-1-t]=true;
								}
								}
							}

						}
					}
				}
				break;
			case "right":
				for (int i = 0; i <N; i++) {
					for (int j = N-2; j>=0; j--) {
						if (arr[i][j+1] == arr[i][j] && !check[i][j+1] && !check[i][j]) {
							arr[i][j+1] += arr[i][j]; // 두개 더해줌.
							check[i][j+1] = true; // 더해진 숫자라는 것을 알리기 위한 check
							arr[i][j] = 0;
						}
						if (arr[i][j+1] == 0) {
							{
								int t = 0;
								for (; j+1+t<N; t++) {
									if (arr[i][j+1+t] == 0) {
										check[i][j+1+t]=false;
										arr[i][j+1+t] = arr[i][j+t];
										arr[i][j+t] = 0;
									} else
										break;
								}
								if(j+1+t<N) {
								if(arr[i][j+1+t]==arr[i][j+t]&&!check[i][j+1+t]&&!check[i][j+t]) {
									arr[i][j+1+t] += arr[i][j+t];
									arr[i][j+t]=0;
									check[i][j+1+t]=true;
								}
								}
							}
						}
					}
				}
				break;

			} // end of switch
			if(testcase>1)
				System.out.println();
			System.out.println("#"+testcase);
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					System.out.print(arr[i][j]+" ");
				}
				if(i<N-1)
				System.out.println();
			}

		} // end of testcase
	} // end of main
}// end of solution

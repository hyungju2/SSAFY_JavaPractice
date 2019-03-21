import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1865_new {
	public static int[] arr;
	public static double max;
	public static double[][] p;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for(int testcase=1; testcase<=T; testcase++) {
			int N = Integer.parseInt(br.readLine().trim()); // 1<=N<=16
			p = new double[N][N];
			for(int i=0; i<N; i++) {
				StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					p[i][j] = Integer.parseInt(tk.nextToken())/100D; //1<=P[i][j]<=100
				}
			}
			arr = new int[N];
			for(int i=0; i<N; i++) {
				arr[i]=i;
			}
			max = 0;
			f(0,100D); //순열 만들기
			System.out.printf("#%d %.6f\n",testcase,max); //반올림해서 소수점 6째자리까지 출력
		}//end of testcase
	} //end of main
	
	/*step :현재 단계, pp : 이전단계까지 구한 확률*/
	public static void f(int step, double pp) {
		if(step == arr.length) {
			if(max<pp) //최대 확률이면 업데이트
				max=pp;
		}else {
			for(int i= step; i<arr.length; i++) { //step 현재 배정할 칸
				swap(step, i); //바꿔줌
				if(max < pp*p[step][arr[step]]) {
					f(step+1,pp*p[step][arr[step]]);
				}
				swap(i,step); //바꿔줌
			}
		}
	} //end of f
	
	public static void swap(int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
}

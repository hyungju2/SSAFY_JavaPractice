import java.util.Arrays;

/**
 * 동전 거스름돈 최소 개수
 * 값이 커진다면, 동전들의 최소 공배수를 제외한 후 가장 큰 값으로 나누어서 처리한다.
 */
public class Z47_DP_Coin {
	public static void main(String[] args) {
		System.out.println(f(8));
	}//end of main
	
	public static int f(int n) {
		int[] C = new int[n+1]; //거스름돈 동전의 최소개수(최적의 해)

		//1원에 동전을 고려한 경우 -> 초기값은 넣어줘야 함.
		for(int i=1; i<=n; i++) {
			C[i] = i;
		}
		System.out.println(Arrays.toString(C));

		//4원 동전을 고려한 경우, 이후부터는 입력값에 따라 Setting.
		for(int i=4; i<=n; i++) {
			if(C[i]>C[i-4]+1)
				//4원을 고려
			{
				C[i] = C[i-4]+1;
			}
		}
		System.out.println(Arrays.toString(C));
		//6원 동전을 고려
		for(int i=6; i<=n; i++) {
			if(C[i]>C[i-6]+1)
			{
				C[i] = C[i-6]+1;
			}
		}
		System.out.println(Arrays.toString(C));
		return C[n];
	}
}

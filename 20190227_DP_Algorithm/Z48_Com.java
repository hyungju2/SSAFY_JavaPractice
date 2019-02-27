import java.util.Arrays;

/**
 * 이항계수
 *
 */
public class Z48_Com {
	public static void main(String[] args) {
		System.out.println(bino(4, 2));// 6
	}// end of main

	public static int bino(int n, int k) {
		int[][] B = new int[n + 1][k + 1];
	
		for (int i = 0; i <= n; i++) {
		
			int min = i < k? i : k;
			
			for (int j = 0; j <=min; j++) {
			
				if(j==0 || j==i)
				{
					B[i][j] = 1;
				}else {
					B[i][j]=B[i-1][j-1] + B[i-1][j];
				}
			}
		}
		for(int i=0; i<B.length; i++) {
			System.out.println(Arrays.toString(B[i]));
		}
		return B[n][k];
	}
}// end of class

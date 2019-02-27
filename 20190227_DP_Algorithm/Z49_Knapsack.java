
/**
 * 0-1 Knapsack : DP로 풀기
 */
import java.util.Arrays;

public class Z49_Knapsack {
	public static void main(String[] args) {
		System.out.println(knapsack(10));
	} // end of main

	public static int knapsack(int N) {

		int[][] item = { { 10, 5 }, { 40, 4 }, { 30, 6 }, { 50, 3 } };
		int[][] K = new int[item.length + 1][N + 1];

		for (int i = 0; i < item.length; i++) {
			for (int w = 0; w < item[i][1]; w++) { // 임시 배낭의 무게
				K[i+1][w] = K[i][w]; // 임시 배낭의 무게가 무거우면, 이전 값을 가져오기.
			}
			for (int w = item[i][1]; w <= N; w++) { //무게보다 작을 떄까지 반복. 현재 무게
				int now = item[i][0]+K[i][w-item[i][1]]; // 현재 item 반영
				int pre = K[i][w]; // 현재 아이템을 반영 않는 경우. 아이템의 무게 이후부터
				K[i+1][w] = now >= pre ? now : pre;
			}
		}
		for (int i = 0; i < K.length; i++) {
			System.out.println(Arrays.toString(K[i]));
		}
		return K[item.length][N];
	} // end of kanp

	
}// end of class

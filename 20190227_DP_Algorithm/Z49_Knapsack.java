
/**
 * 0-1 Knapsack : DP�� Ǯ��
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
			for (int w = 0; w < item[i][1]; w++) { // �ӽ� �賶�� ����
				K[i+1][w] = K[i][w]; // �ӽ� �賶�� ���԰� ���ſ��, ���� ���� ��������.
			}
			for (int w = item[i][1]; w <= N; w++) { //���Ժ��� ���� ������ �ݺ�. ���� ����
				int now = item[i][0]+K[i][w-item[i][1]]; // ���� item �ݿ�
				int pre = K[i][w]; // ���� �������� �ݿ� �ʴ� ���. �������� ���� ���ĺ���
				K[i+1][w] = now >= pre ? now : pre;
			}
		}
		for (int i = 0; i < K.length; i++) {
			System.out.println(Arrays.toString(K[i]));
		}
		return K[item.length][N];
	} // end of kanp

	
}// end of class

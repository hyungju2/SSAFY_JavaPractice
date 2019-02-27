import java.util.Arrays;

/**
 * ���� �Ž����� �ּ� ����
 * ���� Ŀ���ٸ�, �������� �ּ� ������� ������ �� ���� ū ������ ����� ó���Ѵ�.
 */
public class Z47_DP_Coin {
	public static void main(String[] args) {
		System.out.println(f(8));
	}//end of main
	
	public static int f(int n) {
		int[] C = new int[n+1]; //�Ž����� ������ �ּҰ���(������ ��)

		//1���� ������ ����� ��� -> �ʱⰪ�� �־���� ��.
		for(int i=1; i<=n; i++) {
			C[i] = i;
		}
		System.out.println(Arrays.toString(C));

		//4�� ������ ����� ���, ���ĺ��ʹ� �Է°��� ���� Setting.
		for(int i=4; i<=n; i++) {
			if(C[i]>C[i-4]+1)
				//4���� ���
			{
				C[i] = C[i-4]+1;
			}
		}
		System.out.println(Arrays.toString(C));
		//6�� ������ ���
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

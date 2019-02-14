import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * greedy�� �ȵǴ� ���̽��� �����Ƿ�, ����!!!
 *  Greedy���� ����, BackTracking . 
 *  ������, ��� ���̽�Ʋ ��Ȯ�ϰ� Test�� �� ����.
 *  ����ġ�⸦ ���Ѵٸ�, �ᱹ ������.
 * @author student
 *
 */
public class Z31_MaxMoney2 {
	public static int max;
	
	public static HashSet<String> s = new HashSet<String>(); // ���� ������ �� ����ġ�� �ϱ� ����.

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= TC; testcase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String s = st.nextToken();
			
			int[] num = new int[s.length()];
			
			for (int i = 0; i < num.length; i++) {
				num[i] = s.charAt(i) - '0';
			}
			int N = Integer.parseInt(st.nextToken());

			max = 0; // ���� ������ ���� testcase�� ���� �ʱ�ȭ �ؾ� ��.
			find(num, N);

			System.out.println("#" + testcase + " " + max);
		} // end of testcase
	}// end of main

	public static void find(int[] num, int N) {
		// num ���� �迭�� ���� int ���� �ݾ����� ����.
		int val = 0;
		
		for (int i = 0; i < num.length; i++) {
			val = val*10 + num[i]; // �� �ܰ迡���� �ִ� ���
		}
		
		if(s.contains(""+val + N)) { //������ �Ǿ��ٸ�, �̹� Check�� ��Ȳ�̹Ƿ� ���ȣ���� ����
			return; //������ key���̶�� �����ϸ� ��. 
		}else {
			s.add("" + val + N);
		}
		

		if (N == 0) { // basis case
			if (max < val) {
				max = val;
			}
		} else { // ��� ��Ʈ

			for (int i = 0; i < num.length - 1; i++) { // ��ȯ�� ù��° ����
				for (int j = i + 1; j < num.length; j++) // ��ȯ�� �ι�° ����
				{
					int temp = num[i];
					num[i] = num[j];
					num[j] = temp;

					find(num, N - 1);

					temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
		}
	}
}// end of class

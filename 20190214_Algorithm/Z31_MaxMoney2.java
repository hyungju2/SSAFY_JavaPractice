import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * greedy는 안되는 케이스가 있으므로, 위험!!!
 *  Greedy보다 느림, BackTracking . 
 *  하지만, 모든 케이스틀 정확하게 Test할 수 있음.
 *  가지치기를 못한다면, 결국 실패함.
 * @author student
 *
 */
public class Z31_MaxMoney2 {
	public static int max;
	
	public static HashSet<String> s = new HashSet<String>(); // 같은 숫자일 때 가지치기 하기 위함.

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

			max = 0; // 전역 변수는 다음 testcase를 위해 초기화 해야 함.
			find(num, N);

			System.out.println("#" + testcase + " " + max);
		} // end of testcase
	}// end of main

	public static void find(int[] num, int N) {
		// num 숫자 배열의 값을 int 형의 금액으로 변경.
		int val = 0;
		
		for (int i = 0; i < num.length; i++) {
			val = val*10 + num[i]; // 현 단계에서의 최대 상금
		}
		
		if(s.contains(""+val + N)) { //포함이 되었다면, 이미 Check한 상황이므로 재귀호출을 종료
			return; //고유한 key값이라고 생각하면 됨. 
		}else {
			s.add("" + val + N);
		}
		

		if (N == 0) { // basis case
			if (max < val) {
				max = val;
			}
		} else { // 재귀 파트

			for (int i = 0; i < num.length - 1; i++) { // 교환할 첫번째 숫자
				for (int j = i + 1; j < num.length; j++) // 교환할 두번째 숫자
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

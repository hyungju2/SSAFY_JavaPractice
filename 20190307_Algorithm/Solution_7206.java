import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_7206 {
	static String num;
	static int answer[];
	static int count;
	static int index;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= T; testcase++) {
			num = br.readLine();
			answer = new int[10000]; // ������ ���� �� �迭
			int index = 0;
			int res = 1;
			String sres = ""; // ��Ʈ������ ó���ϱ� ����.
			count = 0;
			for (int i = 0; i < num.length(); i++) { // ���ڸ��� �ɰ�.
				res *= (num.charAt(i) - '0');
			}
			sres = String.valueOf(res);
			if (res < 10) {
				answer[index++] = count;
			} else {
				find(sres); // �ϳ��� �ɰ� �� ����.
			}
			if(num.length()>2) {
			for (int i = 1; i < num.length(); i++) { // ó�� index����, �ϳ��� �� ������Ű�� �ɰ�.
				String a = div(num, 0, i);
				String b = div(num, i, num.length());
				int ia = Integer.parseInt(a); // �ɰ� ���� ����ȯ
				int ib = Integer.parseInt(b);
				count = 0;
				if (ia * ib < 10) { // �ɰ����� ���� 10���� ������ �Լ� ���� x
					answer[index++] = count+1;
					continue;
				} else {
					find(String.valueOf(ia * ib)); // �ΰ��� ���� find
				}
			}
			}
			Arrays.sort(answer);
			System.out.println("#" + testcase + " " + answer[answer.length - 1]);
		} // end of testcase
	}// end of main

	public static int find(String ins) {
			count++;
			if (ins.length()>2) {
				int res = 1;
				String sres = ""; // ��Ʈ������ ó���ϱ� ����.
				for (int i = 0; i < ins.length(); i++) { // ���ڸ��� �ɰ�.
					sres += ins.charAt(i);
					res *= (ins.charAt(i) - '0');
				}
				if (res < 10) {
					answer[index++] = ++count; // ���ڸ��� �ɰ� ���� ���� 10���� ������, index���� count ����.
					count--;
					return 0;
				} else {
				
					find(String.valueOf(res)); // ��� ����.
				}
			}
			
			for (int i = 1; i < ins.length(); i++) {
				String a = div(ins, 0, i);
				String b = div(ins, i, ins.length());
				int ia = Integer.parseInt(a); // �ɰ� ���� ����ȯ
				int ib = Integer.parseInt(b);
				if (ia * ib < 10) { // �ɰ����� ���� 10���� ������ �Լ� ���� x
					answer[index++] = ++count;
					count--;
					continue;
				} else {
					find(String.valueOf(ia * ib)); // �ΰ��� ���� find
				}
			}
		count--;
		return 0;
		}

	public static String div(String s, int start, int end) {
		String temp = s.substring(start, end);
		return temp;
	}
}// end of class

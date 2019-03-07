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
			answer = new int[10000]; // 정답을 저장 할 배열
			int index = 0;
			int res = 1;
			String sres = ""; // 스트링으로 처리하기 위함.
			count = 0;
			for (int i = 0; i < num.length(); i++) { // 한자리씩 쪼갬.
				res *= (num.charAt(i) - '0');
			}
			sres = String.valueOf(res);
			if (res < 10) {
				answer[index++] = count;
			} else {
				find(sres); // 하나씩 쪼갠 것 넣음.
			}
			if(num.length()>2) {
			for (int i = 1; i < num.length(); i++) { // 처음 index부터, 하나씩 값 증가시키며 쪼갬.
				String a = div(num, 0, i);
				String b = div(num, i, num.length());
				int ia = Integer.parseInt(a); // 쪼갠 수를 형변환
				int ib = Integer.parseInt(b);
				count = 0;
				if (ia * ib < 10) { // 쪼갠거의 곱이 10보다 작으면 함수 실행 x
					answer[index++] = count+1;
					continue;
				} else {
					find(String.valueOf(ia * ib)); // 두개의 곱을 find
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
				String sres = ""; // 스트링으로 처리하기 위함.
				for (int i = 0; i < ins.length(); i++) { // 한자리씩 쪼갬.
					sres += ins.charAt(i);
					res *= (ins.charAt(i) - '0');
				}
				if (res < 10) {
					answer[index++] = ++count; // 한자리씩 쪼갠 것의 곱이 10보다 작으면, index값에 count 넣음.
					count--;
					return 0;
				} else {
				
					find(String.valueOf(res)); // 재귀 실행.
				}
			}
			
			for (int i = 1; i < ins.length(); i++) {
				String a = div(ins, 0, i);
				String b = div(ins, i, ins.length());
				int ia = Integer.parseInt(a); // 쪼갠 수를 형변환
				int ib = Integer.parseInt(b);
				if (ia * ib < 10) { // 쪼갠거의 곱이 10보다 작으면 함수 실행 x
					answer[index++] = ++count;
					count--;
					continue;
				} else {
					find(String.valueOf(ia * ib)); // 두개의 곱을 find
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

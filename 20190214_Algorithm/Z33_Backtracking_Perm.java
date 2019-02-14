/**
 * 순열 backtracking.
 * 반복문 -> n의 개수에 동적으로 대응하기 어렵다.
 * 재귀함수1 -> swap
 * 재귀함수2 -> 백트래킹
 * 
 * @author student
 *
 */
public class Z33_Backtracking_Perm {
	public static int[] arr = { 1, 3, 5, 7 };

	public static void main(String[] args) {
		int[] a = new int[arr.length];
		backtrack(a, 0, a.length);

	}// end of main

	// a배열은 각 배열의 사용 여부를 지정한 배열, current는 현재, input은 종료 조건
	public static void backtrack(int a[], int current, int input) {
		int[] c = new int[a.length]; // 후보군을 지정할 배열
		if (current == input) { // 종료 파트
			process_solution(a, current);
		} else { // 재귀파트
			int ncands = make_candidates(a, current, input, c); // 후보군의 갯수를 return받음.
			for (int i = 0; i < ncands; i++) { // 후보군의 갯수만큼 반복.
				a[current] = c[i];
				backtrack(a, current + 1, input);
			}
		}
	} // end of backtrack

	// a[]: 각 비트의 사용여부를 지정한 배열, current = 현재단계, input= 종료단계, c[] 후보군을 저장할 배열, return
	// 후보군
	public static int make_candidates(int[] a, int current, int input, int[] c) {
		boolean[] in_perm = new boolean[a.length]; // 이전 단계까지 사용한 숫자를 Check할 Flag변수.
		for (int i = 0; i < current; i++) {
			in_perm[a[i]] = true;
		}
		int ncands = 0; // 후보군의 갯수
		for (int i = 0; i < in_perm.length; i++) {
			if (!in_perm[i]) { // 사용하지 않은 숫자
				c[ncands++] = i;
			}
		}
		return ncands;
	}// end of make_candidates

	// 순열을 출력하는 함수
	public static void process_solution(int[] a, int current) {
		int num=0;
		for (int i = 0; i < a.length; i++) {
			System.out.print(arr[a[i]] + " ");
		}
		System.out.println();
	} // end of process

}// end of class

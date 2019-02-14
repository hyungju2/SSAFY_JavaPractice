/**
 * ���� backtracking.
 * �ݺ��� -> n�� ������ �������� �����ϱ� ��ƴ�.
 * ����Լ�1 -> swap
 * ����Լ�2 -> ��Ʈ��ŷ
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

	// a�迭�� �� �迭�� ��� ���θ� ������ �迭, current�� ����, input�� ���� ����
	public static void backtrack(int a[], int current, int input) {
		int[] c = new int[a.length]; // �ĺ����� ������ �迭
		if (current == input) { // ���� ��Ʈ
			process_solution(a, current);
		} else { // �����Ʈ
			int ncands = make_candidates(a, current, input, c); // �ĺ����� ������ return����.
			for (int i = 0; i < ncands; i++) { // �ĺ����� ������ŭ �ݺ�.
				a[current] = c[i];
				backtrack(a, current + 1, input);
			}
		}
	} // end of backtrack

	// a[]: �� ��Ʈ�� ��뿩�θ� ������ �迭, current = ����ܰ�, input= ����ܰ�, c[] �ĺ����� ������ �迭, return
	// �ĺ���
	public static int make_candidates(int[] a, int current, int input, int[] c) {
		boolean[] in_perm = new boolean[a.length]; // ���� �ܰ���� ����� ���ڸ� Check�� Flag����.
		for (int i = 0; i < current; i++) {
			in_perm[a[i]] = true;
		}
		int ncands = 0; // �ĺ����� ����
		for (int i = 0; i < in_perm.length; i++) {
			if (!in_perm[i]) { // ������� ���� ����
				c[ncands++] = i;
			}
		}
		return ncands;
	}// end of make_candidates

	// ������ ����ϴ� �Լ�
	public static void process_solution(int[] a, int current) {
		int num=0;
		for (int i = 0; i < a.length; i++) {
			System.out.print(arr[a[i]] + " ");
		}
		System.out.println();
	} // end of process

}// end of class

/**
 * �ݺ��� �̿� : n�� ������ �������� �ٲ�� �����ϱ� �����.
 * Binary Counting : Shift ������ �̿�. ������ �� �ִ� ��Ʈ(long 64bit)�� �ִ��� �������ִ�.
 * ��Ʈ��ŷ
 * @author student
 *
 */
public class Z33_Backtracking_Powerset {
	public static int[] arr = {1,3,5}; //�κ������� ���ϰ��� �ϴ� ���� �迭
	public static void main(String[] args) {
		//arr�� powerset�� �̿��Ͽ� �κ����� ���ϱ�.
		boolean[] a = new boolean[arr.length];
	
		backtrack(a,0,a.length); //a, ����ܰ�, ����ܰ�
		
	}//end of main
	
	//a�迭�� �� �迭�� ��� ���θ� ������ �迭, current�� ����, input�� ���� ����
	public static void backtrack(boolean a[], int current, int input) {
		boolean[] c = new boolean[a.length]; //�ĺ����� ������ �迭
		if(current == input) { //���� ��Ʈ
			process_solution(a, current);
		}else { //�����Ʈ
			int ncands = make_candidates(a, current, input, c); //�ĺ����� ������ return����.
			for (int i = 0; i < ncands; i++) { //�ĺ����� ������ŭ �ݺ�.
				a[current] = c[i];
				backtrack(a, current+1, input);
			}
		}
	} //end of backtrack
	

	// a[]:  �� ��Ʈ�� ��뿩�θ� ������ �迭, current = ����ܰ�,  input= ����ܰ�, c[] �ĺ����� ������ �迭, return �ĺ���
	public static int make_candidates(boolean[] a, int current, int input, boolean[] c) {
		c[0] = true;
		c[1] = false;
		return 2;
	}//end of make_candidates

	
	//����ϴ� �Լ�
	public static void process_solution(boolean[] a, int current) {
		for (int i = 0; i < a.length; i++) {
			if(a[i]) {
				System.out.print(arr[i]+" ");
			}
		}
		System.out.println();
	} //end of process
}//end of class

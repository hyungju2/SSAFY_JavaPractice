/**
 * 반복문 이용 : n의 갯수가 동적으로 바뀌면 대응하기 어려움.
 * Binary Counting : Shift 연산을 이용. 저장할 수 있는 비트(long 64bit)의 최댓값이 정해져있다.
 * 백트래킹
 * @author student
 *
 */
public class Z33_Backtracking_Powerset {
	public static int[] arr = {1,3,5}; //부분집합을 구하고자 하는 원래 배열
	public static void main(String[] args) {
		//arr의 powerset을 이용하여 부분집합 구하기.
		boolean[] a = new boolean[arr.length];
	
		backtrack(a,0,a.length); //a, 현재단계, 종료단계
		
	}//end of main
	
	//a배열은 각 배열의 사용 여부를 지정한 배열, current는 현재, input은 종료 조건
	public static void backtrack(boolean a[], int current, int input) {
		boolean[] c = new boolean[a.length]; //후보군을 지정할 배열
		if(current == input) { //종료 파트
			process_solution(a, current);
		}else { //재귀파트
			int ncands = make_candidates(a, current, input, c); //후보군의 갯수를 return받음.
			for (int i = 0; i < ncands; i++) { //후보군의 갯수만큼 반복.
				a[current] = c[i];
				backtrack(a, current+1, input);
			}
		}
	} //end of backtrack
	

	// a[]:  각 비트의 사용여부를 지정한 배열, current = 현재단계,  input= 종료단계, c[] 후보군을 저장할 배열, return 후보군
	public static int make_candidates(boolean[] a, int current, int input, boolean[] c) {
		c[0] = true;
		c[1] = false;
		return 2;
	}//end of make_candidates

	
	//출력하는 함수
	public static void process_solution(boolean[] a, int current) {
		for (int i = 0; i < a.length; i++) {
			if(a[i]) {
				System.out.print(arr[i]+" ");
			}
		}
		System.out.println();
	} //end of process
}//end of class

import java.util.Arrays;

/**
 * 배열 사용
 * 
 * @author student
 *
 */
public class Z28_MergeSort2 {

	public static void merge(int[] arr, int left, int mid, int right) {
		int[] temp = new int[right+left];
		int l = left; // 왼쪽 배열의 index
		int r = mid; // 오른쪽 배열의 index
		int index = 0; // 병합 할 배열의 index

		// 양쪽이 모두 원소가 남는경우
		while (l < mid && r < right) {
			if (arr[l] < arr[r]) {
				temp[index++] = arr[l++];
			} else
				temp[index++] = arr[r++];
		}
		// 왼쪽만 남은 경우
		System.arraycopy(arr, l, temp, index, mid-l);
		// 오른쪽만 남은 경우.
		System.arraycopy(arr, mid, temp, index, right-r);
		System.arraycopy(temp, 0, arr, left, right-r);
	}
	
	public static void mergeSort(int[] arr, int left, int right) {
		if (right - left <= 1) {
			return;
		} else {
			int mid = (left + right) / 2;
			mergeSort(arr,left,mid);
			mergeSort(arr,mid,right);
			merge(arr, left, mid, right); // mid를 중심으로 반 쪼개라.
			return;
		}
	}
	public static void main(String[] args) {
		int[] arr = {6,4,5,8,7,2,9,0,1};
		mergeSort(arr, 0, arr.length);
		System.out.println(Arrays.toString(arr));
	}// end of main
}// end of class

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 병합정렬 1 - 리스트 사용
 * @author student
 *
 */
public class Z28_MergeSort{
	
	public static List<Integer> merge(List<Integer> left, List<Integer> right){
		
		List<Integer> result = new ArrayList<Integer>(left.size()+right.size()); //내부 배열의 크기를 처음에 지정하기.
		int l = 0; // Left 리스트의 index
		int r = 0; // Right 리스트의 index
		
		//양쪽리스트의 원소가 모두 있는 경우.
		while(l < left.size() && r<right.size()) {
		if(left.get(l) < right.get(r)) {//첫번째 원소끼리 비교
				result.add(left.get(l++));
			} else {
				result.add(right.get(r++));
			}
		
		}
		
		//왼쪽 리스트만 원소가 있는 경우.
		while(l<left.size())
		{
			result.add(left.get(l++));
		}
		//오른쪽 리스트만 원소가 있는 경우.
		while(r<right.size()) {
			result.add(right.get(r++));
		}
		return result;
	}
	
	
	public static List<Integer> mergeSort(List<Integer> ll) { //리스트 덩어리를 쪼개기
		if(ll.size()<=1) { //종료파트
			return ll;
		} else { //재귀파트
			int m = ll.size()/2;
			List<Integer> left = mergeSort(ll.subList(0, m));
			List<Integer> right = mergeSort(ll.subList(m,ll.size()));
			return merge(left,right);
		}
	}
	
	public static void main(String[] args) {
		Integer[] arr = {6,4,8,5,7,2,9,3,0,1}; //애초에 Integer로 선언해두면, 객체 하나씩 다 autoboxing됨.
		ArrayList<Integer> ll = new ArrayList(Arrays.asList(arr)); //배열 선언이 객체로 되어있지 않으면, 객체 주소가 불려옴.
		System.out.println(mergeSort(ll));
	}
}
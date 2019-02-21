import java.util.Arrays;

/**
 * 문자열 검색을 빠르게 하려면 보이어무어 알고리즘
 * 
 * 특정 문자열에서 모든 부분 문자열을 정렬된 상태로 알고싶다면 특정 문자열의 모든 접미사를 구함 -> 접미사를 정렬 -> 각 접미사의 모든
 * 접두사를 구함.
 * 
 * 트라이(Trie) : 문자열의 집합을 표현하는 트리 Compressed Trie :어떤 문자열의 접미사들을 트라이로 표현
 * Compressed Trie 문제점( 접미사가 다른 접미사의 접두어가 되는 경우 구분이 불가, 문자열의 끝에 $ 표시)
 * 
 * -> 해결하기 위해 접미어 트리 : Suffix Tree 생성 시간복잡도 O[n^2] => O[n log n] => O[n]
 * 
 * 접미어 배열 (Suffix Array) : 접미어들의 시작 index 만 저장해서 문자열을 표현하는 방법 ->접미어 트리에 비해(메모리를
 * 절약 1/4, 속도는 느리다.) NlongN -> 정렬하는데 가장 시간이 오래걸림.
 * 
 * LCP 배열 : 최장 공통 접두어(Longest Commen Prefix), 접미어 배열 사용시 보조적으로 필요하다. 두 문자열 사이의
 * 공통 접두어의 길이.
 * 
 */
public class Z40_SuffixArray {
	public static void main(String[] args) {
		String s = "banana";

		// s 문자열의 모든 접미사 생성

		int[] sa = new int[s.length()];// Suffix Array : index
		for (int i = 0; i < sa.length; i++) {
			sa[i] = i; // 초기화
		}
		// s 문자열의 접미사를 정렬
		for (int i = 0; i < sa.length; i++){// 선택정렬
			int minIndex = i;
			for (int j = i; j < sa.length; j++) {
				// s.subString(sa[minIndex]) ~~ s.subString(sa[j])까지 비교
				if (s.substring(sa[minIndex]).compareTo(s.substring(sa[j])) > 0) {
					minIndex = j; // 뒤가 더 작음.
				}
			}
			// minIndex <-> i swap
			int temp = sa[minIndex];
			sa[minIndex] = sa[i];
			sa[i] = temp;
		}

		int[] LCP = new int[s.length()]; // 최장 공통 접두어를 저장 할 배열
		for (int i = 1; i < LCP.length; i++) {
			String s1 = s.substring(sa[i-1]);
			String s2 = s.substring(sa[i]);
			while (s1.length() > LCP[i] && s2.length() > LCP[i] && s1.charAt(LCP[i]) == s2.charAt(LCP[i])) {
				LCP[i]++;
			}
		}
		System.out.println(Arrays.toString(LCP)+" : LCP");
		// s 문자열의 정렬된 모든 접미사의 모든 접두사를 구사한다.

		// suffix Array를 활용해서 접미사 문자열을 출력
		System.out.println(Arrays.toString(sa) + ": Suffix Array");
		for (int i = 0; i < sa.length; i++) {
			String str = s.substring(sa[i]); // 접미사
			System.out.println("<" + str + ">");

			// s문자열의 정렬된 모든 접미사의 모든 접두사를 생성.

			for (int j = LCP[i]+1; j <= str.length(); j++) { // 중복된 접두사는 제거하고 출력.
				System.out.println(str.substring(0, j));
			}
			System.out.println(str.length() + ": 접두사의 개수"); // 해당 접미사의 개수
			System.out.println(LCP[i]+" : 최장공통 접두사의 개수");
			System.out.println(str.length()-LCP[i]+" : 유효한 부분 문자열의 개수");
			
			System.out.println("===================");
		
		}
		

		//s 문자열에서 만들 수 있는 모든 부분문자열에서 사전식 정렬상태에서 k번째 문자열을 출력하시오.
		int k=13;
		int index = k;
		
		for(int t=0; t<sa.length; t++) {
			String strg = s.substring(sa[t]); //접미사
			
			if(index - (strg.length()-LCP[t]) >0) {
				index=index-(strg.length()-LCP[t]);
			} else {
				System.out.println(k+"번째 문자열: "+strg.substring(0,LCP[t]+index));
				break;
			}
		}
			
	} // end of main
}// end of class

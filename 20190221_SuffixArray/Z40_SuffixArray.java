import java.util.Arrays;

/**
 * ���ڿ� �˻��� ������ �Ϸ��� ���̾�� �˰���
 * 
 * Ư�� ���ڿ����� ��� �κ� ���ڿ��� ���ĵ� ���·� �˰�ʹٸ� Ư�� ���ڿ��� ��� ���̻縦 ���� -> ���̻縦 ���� -> �� ���̻��� ���
 * ���λ縦 ����.
 * 
 * Ʈ����(Trie) : ���ڿ��� ������ ǥ���ϴ� Ʈ�� Compressed Trie :� ���ڿ��� ���̻���� Ʈ���̷� ǥ��
 * Compressed Trie ������( ���̻簡 �ٸ� ���̻��� ���ξ �Ǵ� ��� ������ �Ұ�, ���ڿ��� ���� $ ǥ��)
 * 
 * -> �ذ��ϱ� ���� ���̾� Ʈ�� : Suffix Tree ���� �ð����⵵ O[n^2] => O[n log n] => O[n]
 * 
 * ���̾� �迭 (Suffix Array) : ���̾���� ���� index �� �����ؼ� ���ڿ��� ǥ���ϴ� ��� ->���̾� Ʈ���� ����(�޸𸮸�
 * ���� 1/4, �ӵ��� ������.) NlongN -> �����ϴµ� ���� �ð��� �����ɸ�.
 * 
 * LCP �迭 : ���� ���� ���ξ�(Longest Commen Prefix), ���̾� �迭 ���� ���������� �ʿ��ϴ�. �� ���ڿ� ������
 * ���� ���ξ��� ����.
 * 
 */
public class Z40_SuffixArray {
	public static void main(String[] args) {
		String s = "banana";

		// s ���ڿ��� ��� ���̻� ����

		int[] sa = new int[s.length()];// Suffix Array : index
		for (int i = 0; i < sa.length; i++) {
			sa[i] = i; // �ʱ�ȭ
		}
		// s ���ڿ��� ���̻縦 ����
		for (int i = 0; i < sa.length; i++){// ��������
			int minIndex = i;
			for (int j = i; j < sa.length; j++) {
				// s.subString(sa[minIndex]) ~~ s.subString(sa[j])���� ��
				if (s.substring(sa[minIndex]).compareTo(s.substring(sa[j])) > 0) {
					minIndex = j; // �ڰ� �� ����.
				}
			}
			// minIndex <-> i swap
			int temp = sa[minIndex];
			sa[minIndex] = sa[i];
			sa[i] = temp;
		}

		int[] LCP = new int[s.length()]; // ���� ���� ���ξ ���� �� �迭
		for (int i = 1; i < LCP.length; i++) {
			String s1 = s.substring(sa[i-1]);
			String s2 = s.substring(sa[i]);
			while (s1.length() > LCP[i] && s2.length() > LCP[i] && s1.charAt(LCP[i]) == s2.charAt(LCP[i])) {
				LCP[i]++;
			}
		}
		System.out.println(Arrays.toString(LCP)+" : LCP");
		// s ���ڿ��� ���ĵ� ��� ���̻��� ��� ���λ縦 �����Ѵ�.

		// suffix Array�� Ȱ���ؼ� ���̻� ���ڿ��� ���
		System.out.println(Arrays.toString(sa) + ": Suffix Array");
		for (int i = 0; i < sa.length; i++) {
			String str = s.substring(sa[i]); // ���̻�
			System.out.println("<" + str + ">");

			// s���ڿ��� ���ĵ� ��� ���̻��� ��� ���λ縦 ����.

			for (int j = LCP[i]+1; j <= str.length(); j++) { // �ߺ��� ���λ�� �����ϰ� ���.
				System.out.println(str.substring(0, j));
			}
			System.out.println(str.length() + ": ���λ��� ����"); // �ش� ���̻��� ����
			System.out.println(LCP[i]+" : ������� ���λ��� ����");
			System.out.println(str.length()-LCP[i]+" : ��ȿ�� �κ� ���ڿ��� ����");
			
			System.out.println("===================");
		
		}
		

		//s ���ڿ����� ���� �� �ִ� ��� �κй��ڿ����� ������ ���Ļ��¿��� k��° ���ڿ��� ����Ͻÿ�.
		int k=13;
		int index = k;
		
		for(int t=0; t<sa.length; t++) {
			String strg = s.substring(sa[t]); //���̻�
			
			if(index - (strg.length()-LCP[t]) >0) {
				index=index-(strg.length()-LCP[t]);
			} else {
				System.out.println(k+"��° ���ڿ�: "+strg.substring(0,LCP[t]+index));
				break;
			}
		}
			
	} // end of main
}// end of class

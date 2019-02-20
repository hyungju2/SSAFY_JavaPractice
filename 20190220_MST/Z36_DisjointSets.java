/**
 * ���μ� ���� disjointSet 
 * makeSet(int x) ��� x�� �����ϴ� ���ο� ������ ����
 * findSet(int x) ��� x�� �����ϴ� ������ ã�Ƽ� ��ǥ�ڸ� ����
 * union(int x, int y) ��� x, y�� �����ϴ� �� ������ ����.
 * link(int px, int py) x��ǥ�ڿ� y��ǥ���� ������ ��ħ
 */
public class Z36_DisjointSets {
	static int[] p = new int[10]; //�θ� ������ �迭.
	static int[] rank = new int[p.length]; //���̸� ������ �迭
	public static void main(String[] args) {
		 
		for (int i = 0; i < p.length; i++) {
			makeSet(i);		
		}
		
		printSet();
		System.out.println();
		union(0,1); printSet();
		System.out.println();
		union(2,3); printSet();
		System.out.println();
		union(0,3); printSet();
		
	} //end of main
	
	// ��ǥ�ڸ� ã����.
	public static int findSet(int x) {
		if(p[x]==x) {
			return x;
		}
		else {
			p[x] =  findSet(p[x]); //path Compression ��ǥ�ڸ� ã���� ����.
			return p[x];
		}
	}
	
	//��� x,y�� �����ϴ� �� ������ ����. ���� �ٸ� �����϶��� ��ħ
	public static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		link(px,py);
	}
	
	// x��ǥ�ڿ� y��ǥ���� ������ ��ħ.
	public static void link(int px, int py) {
		if(rank[px]>rank[py]) {
			p[py] = px; //�������� ū�ʿ� ���δ�.
		}
		else {
			p[px] = py;
			if(rank[px] == rank[py]) {
				rank[py]++; //�� ��ǥ���� ��ũ���� ���� ���� ��ũ���� 1 ����.
			}
		}
	}

	// ��� x�� �����ϴ� ���ο� ������ ����
	public static void makeSet(int x) {
		p[x] = x; //�θ� ����, �ڱ� �ڽ��� index or -1�� ǥ��
		rank[x] = 0; // ���� �ʱ갪�� 0�̶� �ǹ� ����.
	}
	
	//p�� rank �迭�� ������ִ� �Լ�.
	public static void printSet() {
		System.out.print("index :");
		for (int i = 0; i < p.length; i++) {
			System.out.printf("%2d",i);
		}
		System.out.println();
		System.out.print("parent :");
		for (int i = 0; i < p.length; i++) {
			System.out.printf("%2d",p[i]);
		}
		System.out.println();
		System.out.print("rank :");
		for (int i = 0; i < rank.length; i++) {
			System.out.printf("%2d",rank[i]);
		}
		System.out.println();
	}
}//end of class

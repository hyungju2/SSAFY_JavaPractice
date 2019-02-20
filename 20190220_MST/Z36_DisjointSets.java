/**
 * 서로소 집합 disjointSet 
 * makeSet(int x) 멤버 x를 포함하는 새로운 집합을 생성
 * findSet(int x) 멤버 x를 포함하는 집합을 찾아서 대표자를 리턴
 * union(int x, int y) 멤버 x, y를 포함하는 두 집합을 통합.
 * link(int px, int py) x대표자와 y대표자의 집합을 합침
 */
public class Z36_DisjointSets {
	static int[] p = new int[10]; //부모를 저장할 배열.
	static int[] rank = new int[p.length]; //깊이를 저장할 배열
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
	
	// 대표자를 찾아줌.
	public static int findSet(int x) {
		if(p[x]==x) {
			return x;
		}
		else {
			p[x] =  findSet(p[x]); //path Compression 대표자를 찾으면 저장.
			return p[x];
		}
	}
	
	//멤버 x,y를 포함하는 두 집합을 통합. 서로 다른 집합일때만 합침
	public static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		link(px,py);
	}
	
	// x대표자와 y대표자의 집합을 합침.
	public static void link(int px, int py) {
		if(rank[px]>rank[py]) {
			p[py] = px; //작은쪽을 큰쪽에 붙인다.
		}
		else {
			p[px] = py;
			if(rank[px] == rank[py]) {
				rank[py]++; //두 대표자의 랭크값이 같은 경우는 랭크값을 1 증가.
			}
		}
	}

	// 멤버 x를 포함하는 새로운 집합을 생성
	public static void makeSet(int x) {
		p[x] = x; //부모를 저장, 자기 자신의 index or -1을 표기
		rank[x] = 0; // 원래 초깃값이 0이라 의미 없음.
	}
	
	//p와 rank 배열을 출력해주는 함수.
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

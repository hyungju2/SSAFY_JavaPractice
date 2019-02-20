import java.util.Arrays;
import java.util.Scanner;

/**
 * MST 최소 신장 트리
 *  prim(프림): 선택한 정점에서 인접한 간선중에 최소 가중치의 정점을 선택해 나간다.
 *  	Greedy 설계기법
 *  	우선순위큐를 사용해서 구현해야 함(힙을 구현)
 *  
 *  KRUSKAL : 최소 가중치의 간선을 선택해 나간다.
 *		서로 상호 배타집합(Disjoint Set)을 구현해야함.
 *		
 *	input : 정점의 개수V, 간선의 개수 E 이후, E개의 간선 정보를 입력  (정점1 정점2 가중치)
 
7 11 
0 6 51
5 3 18
1 2 21
2 6	25
2 6 25
0 2 31
0 5 60
3 4 34
2 4 46
4 6 51
5 4 40
0 1 32
 */
public class Z37_MST_KRUSKAL {
	
	static int[] p; //부모를 저장할 배열.
	static int[] rank; //깊이를 저장할 배열
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		p = new int[V];
		rank = new int[p.length];
		
		Edge[] G = new Edge[E]; //간선의 정보를 저장할 배열 = 간선배열
		
		for(int i=0; i<E; i++) {
			G[i] = new Edge(sc.nextInt(),sc.nextInt(),sc.nextInt());
		}
		
		//KRUSKAL : 서로 소 집합을 사용한다.
		//모든 정점들을 원소 1개짜리의 집합으로 만든다.
			for(int i=0; i<p.length; i++) {
				makeSet(i);
			}
		//가중치를 기준으로 간선배열을 정렬
			Arrays.sort(G); //  compareTo 구현해야 한다.
			
		//반복 (간선이 N-1개 선택할 때까지, 가중치가 낮은 간선을 선택)
		for(int i=0; i<E; i++)
		{
			Edge e = G[i];
			int pa = findSet(e.a);
			int pb = findSet(e.b);
			if(pa!=pb) { //다른 집합일 때, 대표자가 다름.
				union(pa,pb);
				System.out.println(e.a+"-"+e.b+"-"+e.val);
			}
		}
		//cycle이 발생하지 않는 정점을 선택.
		
		//두 정점의 집합을 하나의 집합으로 합침.
		
	}//end of main
	
	
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
	

	public static class Edge implements Comparable<Edge>{ //inner class는 static 붙일 수 있음.
		int a; //정점 1
		int b; //정점 2
		int val;//가중치
		
		public Edge(int a, int b, int val) {
			this.a = a;
			this.b = b;
			this.val = val;
		}

		public int compareTo(Edge o) { //간선의 가중치를 기준으로 정렬한다.
			return this.val - o.val;
		}
	}
}//end of class

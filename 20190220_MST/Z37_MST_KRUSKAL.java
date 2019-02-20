import java.util.Arrays;
import java.util.Scanner;

/**
 * MST �ּ� ���� Ʈ��
 *  prim(����): ������ �������� ������ �����߿� �ּ� ����ġ�� ������ ������ ������.
 *  	Greedy ������
 *  	�켱����ť�� ����ؼ� �����ؾ� ��(���� ����)
 *  
 *  KRUSKAL : �ּ� ����ġ�� ������ ������ ������.
 *		���� ��ȣ ��Ÿ����(Disjoint Set)�� �����ؾ���.
 *		
 *	input : ������ ����V, ������ ���� E ����, E���� ���� ������ �Է�  (����1 ����2 ����ġ)
 
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
	
	static int[] p; //�θ� ������ �迭.
	static int[] rank; //���̸� ������ �迭
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		p = new int[V];
		rank = new int[p.length];
		
		Edge[] G = new Edge[E]; //������ ������ ������ �迭 = �����迭
		
		for(int i=0; i<E; i++) {
			G[i] = new Edge(sc.nextInt(),sc.nextInt(),sc.nextInt());
		}
		
		//KRUSKAL : ���� �� ������ ����Ѵ�.
		//��� �������� ���� 1��¥���� �������� �����.
			for(int i=0; i<p.length; i++) {
				makeSet(i);
			}
		//����ġ�� �������� �����迭�� ����
			Arrays.sort(G); //  compareTo �����ؾ� �Ѵ�.
			
		//�ݺ� (������ N-1�� ������ ������, ����ġ�� ���� ������ ����)
		for(int i=0; i<E; i++)
		{
			Edge e = G[i];
			int pa = findSet(e.a);
			int pb = findSet(e.b);
			if(pa!=pb) { //�ٸ� ������ ��, ��ǥ�ڰ� �ٸ�.
				union(pa,pb);
				System.out.println(e.a+"-"+e.b+"-"+e.val);
			}
		}
		//cycle�� �߻����� �ʴ� ������ ����.
		
		//�� ������ ������ �ϳ��� �������� ��ħ.
		
	}//end of main
	
	
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
	

	public static class Edge implements Comparable<Edge>{ //inner class�� static ���� �� ����.
		int a; //���� 1
		int b; //���� 2
		int val;//����ġ
		
		public Edge(int a, int b, int val) {
			this.a = a;
			this.b = b;
			this.val = val;
		}

		public int compareTo(Edge o) { //������ ����ġ�� �������� �����Ѵ�.
			return this.val - o.val;
		}
	}
}//end of class

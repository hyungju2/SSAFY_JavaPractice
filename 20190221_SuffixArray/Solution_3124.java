import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3124 {
	
	static int[] p;
	static int[] rank;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int testcase = 1; testcase <= T; testcase++) {
			String s = br.readLine();
			StringTokenizer tk = new StringTokenizer(s, " ");
			int v = Integer.parseInt(tk.nextToken());
			int e = Integer.parseInt(tk.nextToken());
			Edge[] G = new Edge[e];
			p = new int[v+1];
			rank = new int[p.length];
			
			for (int i = 0; i < e; i++) {
				s = br.readLine();
				tk = new StringTokenizer(s, " ");
				int x = Integer.parseInt(tk.nextToken());
				int y = Integer.parseInt(tk.nextToken());
				int val = Integer.parseInt(tk.nextToken());
				G[i] = new Edge(x,y,val);
			}
			
			for(int i=0; i<p.length; i++) {
				makeSet(i);
			}
			Arrays.sort(G);
			long sum = 0;
		
			for(int i=0; i<e; i++) {
				Edge k = G[i];
				int px = findSet(k.x);
				int py = findSet(k.y);
				if(px!=py) {
					union(px,py);
					sum+=k.val;
				}
			}
			System.out.println("#"+testcase+" "+sum);
		} // end of testcase
	}// end of main
	
	public static void link(int px, int py) {
		if(rank[px]>rank[py]) {
			p[py] = px;
		}
		else {
			p[px] = py;
			if(rank[px] == rank[py]) {
				rank[py]++;
			}
		}
	}
	
	public static void union(int x, int y) {
		link(x,y);
	}
	
	public static void makeSet(int i) {
		p[i] = i;
		rank[i] = 0;
	}
	public static int findSet(int x) {
		if(p[x]==x) {
			return x;
		}else {
			p[x] = findSet(p[x]);
			return p[x];
		}
	}
	
	public static class Edge implements Comparable<Edge>{
		int x;
		int y;
		int val;
		
		public Edge(int x, int y, int val) {
			this.x = x;
			this.y = y;
			this.val = val;
		}

		public int compareTo(Edge o) {
			return this.val - o.val;
		}
		
		
	}
}// end of class

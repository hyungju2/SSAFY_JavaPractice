import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Tree {
	public static int p[];
	public static int rank[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = null;
		tk = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(tk.nextToken());
		int M = Integer.parseInt(tk.nextToken());
		
		Edge[] e = new Edge[M];
		for(int i=0; i<M; i++) {
			tk = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(tk.nextToken());
			int y = Integer.parseInt(tk.nextToken());
			int val = Integer.parseInt(tk.nextToken());
			e[i] = new Edge(x,y,val);
		}
		p = new int[N+1];
		rank = new int[N+1];
		
		for(int i=1; i<N+1; i++) { //make set
			p[i]=i;
		}
		
		Arrays.sort(e);
		int result=0;
		for(int i=0; i<e.length; i++) {
			int px = findSet(e[i].x);
			int py = findSet(e[i].y);
			if(px!=py)
			{
				union(px,py);
				result+=e[i].val;
			}
		}
		System.out.println(result);
	}//end of main

	private static void union(int px, int py) {
		int x = findSet(px);
		int y = findSet(py);
		link(x,y);
		
	}

	private static void link(int px, int py) {
		if(rank[px]>rank[py]) {
			p[py]=px;
		}else
		{
			p[px] = py;
			if(rank[px]==rank[py])
				rank[py]++;
		}
	}

	private static int findSet(int x) {
		if(p[x]==x)
			return x;
		else
		{
			p[x] = findSet(p[x]);
			return p[x];
		}
	}

	public static class Edge implements Comparable<Edge> {
		int x;
		int y;
		int val;
		@Override
		public String toString() {
			return "Edge [x=" + x + ", y=" + y + ", val=" + val + "]";
		}
		public Edge(int x, int y, int val) {
			this.x = x;
			this.y = y;
			this.val = val;
		}
		@Override
		public int compareTo(Edge o) {
			return o.val-this.val;
		}
	} //end of Edge
}

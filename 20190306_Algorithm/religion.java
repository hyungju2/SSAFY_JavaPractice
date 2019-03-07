import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class religion {
	static int p[];
	static int rank[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(tk.nextToken());
		int m = Integer.parseInt(tk.nextToken());
		
		if (m == 0) {
			System.out.println(n);
			return;
		}

		p = new int[n + 1];
		rank = new int[n + 1];
		for (int i = 0; i < n + 1; i++) {
			p[i] = i;
		} // find set
		Edge arr[] = new Edge[m];
		for (int i = 0; i < m; i++) {
			StringTokenizer tks = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(tks.nextToken());
			int y = Integer.parseInt(tks.nextToken());
			arr[i] = new Edge(x, y);
		}

		Arrays.sort(arr);
		for (int i = 0; i < m; i++) {
			Edge T = arr[i];
			int tempx = findSet(T.x);
			int tempy = findSet(T.y);

			if (tempx != tempy) {
				union(tempx, tempy);
			}
		}

		HashSet<Integer> hs = new HashSet<>();
		for (int i = 1; i < n; i++) {
			if(p[i]==i)
				hs.add(p[i]);
		}
		System.out.println(hs.size());
	}// end of main

	public static void union(int a, int b) {
		int px = findSet(a);
		int py = findSet(b);
		link(px, py);
	} // end of union

	public static void link(int px, int py) {
		if (rank[px] > rank[py]) {
			p[px] = py;
		} else {
			p[py] = px;
			if (rank[px] == rank[py]) {
				rank[py]++;
			}
		}
	} // end of link

	public static int findSet(int x) {
		if (p[x] == x)
			return x;
		else {
			p[x] = findSet(p[x]);
			return p[x];
		}
	} // 대표자를 찾음. end of findset

	static class Edge implements Comparable<Edge> {
		int x;
		int y;

		Edge(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int compareTo(Edge o) {
			return this.x - o.x;
		}

		public String toString() {
			return "Edge [x=" + x + ", y=" + y + "]";
		}

	}// end of Edge

}// end of religion

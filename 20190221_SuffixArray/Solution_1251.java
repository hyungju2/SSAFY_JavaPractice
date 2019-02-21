import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_1251 {
    public static int[] p;
    public static int[] rank;
    public static void main(String[] args) throws Exception {
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     
        
        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
           
        	int N = Integer.parseInt(br.readLine());
            double sum = 0;
            double[][] islands = new double[N][2];
            
            String s = br.readLine();
            String s2 = br.readLine();
            StringTokenizer tk = new StringTokenizer(s," ");
            StringTokenizer tk2 = new StringTokenizer(s2," ");
            
            for(int i=0; i<N; i++) {
            	islands[i][0] = Double.parseDouble(tk.nextToken());
            	islands[i][1] = Double.parseDouble(tk2.nextToken());
            }
        
            double E = Double.parseDouble(br.readLine());
            
            Edge[] e = new Edge[N*N];
            int index = 0;
            for (int i = 0; i < islands.length-1; i++) {
                for (int j = 0; j < islands.length; j++) {
                    if(i != j) {
                        e[++index] = new Edge(i, j, Math.pow(islands[i][0] - islands[j][0], 2)
                                                    + Math.pow(islands[i][1] - islands[j][1], 2));
                    }
                }
            }
            
            Edge[] G = new Edge[index];
            System.arraycopy(e, 1, G, 0, index);
            
            p = new int[N];
            rank = new int[p.length];
            for (int i = 0; i < p.length; i++) {
                makeSet(i);
            }
            Arrays.sort(G);
            
            for (int i = 0, cnt = 0; i < G.length && cnt < N; i++) {
                Edge tmpG = G[i];
                int px = findSet(tmpG.s);
                int py = findSet(tmpG.e);
                if(px != py) {
                    union(px, py);
                    cnt++;
                    sum += tmpG.val;
                }
            }
            
            System.out.println("#"+testCase+" "+ String.format("%.0f", sum*E));
        }
    } // end of main
    
    public static void makeSet(int x) {
        p[x] = x;
    }
    
    public static int findSet(int x) {
        if(p[x] == x) {
            return p[x];
        } else {
            p[x] = findSet(p[x]);
            return p[x];
        }
    }
    
    public static void union(int x, int y) {
        int px = findSet(x);
        int py = findSet(y);
        if(rank[px] > rank[py]) {
            p[py] = px;
        } else {
            if(rank[px] == rank[py]) {
                rank[py]++;
            }
            p[px] = py;
        }
    }
    
    
    public static class Edge implements Comparable<Edge>{
        int s;
        int e;
        double val;
        
        public Edge(int s, int e, double val) {
            this.s = s;
            this.e = e;
            this.val = val;
        }
        @Override
        public int compareTo(Edge o) {
            return (int)(this.val - o.val);
        }
    }
} // end of class
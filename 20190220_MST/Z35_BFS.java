import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BFS 너비우선 탐색
 * queue 구조가 필요(선입선출)
 * 반복문, 재귀함수
 * input
 * 1 2 1 3 2 4 2 5 4 6 5 6 6 7 3 7
 * 
 * output
 * 1 2 3 4 5 7 6
 * or
 * 1 3 2 7 5 4 6 
 */
public class Z35_BFS {
	public static void main(String[] args) throws IOException {
		//그래프를 저장하는 방식 : 인접행렬, 인접리스트, 간선배열
		int[][] G = new int[8][8];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer tk = new StringTokenizer(input," ");
		while(tk.hasMoreTokens()) {
			int s = Integer.parseInt(tk.nextToken());
			int e = Integer.parseInt(tk.nextToken());
			G[s][e] = 1;
			G[e][s] = 1; //우향 그래프
		}
		int[] q = new int[100]; //선형 큐 생성.
		int front = -1;
		int rear = -1;
		boolean[] visited = new boolean[8];
		
		int v = 1; //시작 정점.
		q[++rear] = v; //시작 정점을 넣어라.
		visited[v] = true; //정점 v를 방문했으니, visited를 true로
		
		while(front!=rear) { //큐가 비어있지 않은 경우 반복
			//큐의 첫번째 원소 반환.
			

			v = q[++front]; // 큐의 첫번째 원소 반환
			System.out.print(" "+v);
			visited[v] = true;
			
			for (int i = 0; i < visited.length; i++) { //v와 인접한 정점에 대해 방문했는지 확인
			//for(int i = visited.length-1; i>=0; i--) { //큰 숫자부터	
			if(G[v][i] == 1 && !visited[i] ) { //인접한 정점이고, 방문하지 않은 곳.
					//큐에 넣고, 방문한 곳으로 표기.
					q[++rear] = i; //큐에 넣기.
					visited[i] = true;//방문한 것으로 표기.
				}
			}
		}
		
	} //end of main
}//end of class

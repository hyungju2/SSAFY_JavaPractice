import java.util.Stack;

/**
 * 그래프에서 모든 정점을 빠짐없이 순회하는 방법
 * DFS
 * BFS
 * @author student
 *
 */

public class Z18_DFS {
	
	public static void main(String[] args) {
	
		 int[][] G = {
				{}, //정점 0에 인접한 정점, 안쓰는 것. 
				{2,3}, //정점 1에 인접한 정점
				{1,4,5}, //정점 2에 인접한 정점
				{1,7}, //정점 3에 인접한 정점
				{2,6}, //정점 4에 인접한 정점
				{2,6}, //정점 5에 인접한 정점
				{4,5,7}, //정점 6에 인접한 정점
				{3,6}, //정점 7에 인접한 정점
		}; //그래프에서 연결된 정점들의 간선정보를 저장.

		 int[] stack = new int[10];
		 int top = -1; // stack의 인덱스를 관리.
		 boolean visited[] = new boolean[8]; //0번을 안씀.
		 
		 int v = 1; //시작 정점
		 System.out.print(v+" "); //방문해서 할 일.
		 visited[v] = true; //방문 여부 체크
		 stack[++top] = v; //마지막 갈림길을 확인하기 위해 지나가는 정점들을 저장.
		 
		 //반복, 스택에서 값을 꺼내서 인접한 정점 중에 방문 안한 정점을 찾아서 방문.
		 while(top>-1) { //Stack이 비어지면 종료하겠다.
			 v = stack[top]; //마지막 정점을 읽어옴.
			 int w = -1; //다음 갈 정점. -1이면 인접한 정점이 없다.
			 for (int i = 0; i < G[v].length; i++) { //인접한 정점 확인
				if(!visited[G[v][i]])
				{
					w = G[v][i]; //다음 갈 정점 저장.
					System.out.print(w+" ");
					visited[G[v][i]] = true;
					stack[++top] = w;
					break;
				}
			}
			 if(w==-1) //인접한 정점중에 방문할 곳이 없음.
			 {
				 top--;
			 }
		 }
		 
	}//end of main
}//end of class


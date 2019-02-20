import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BFS �ʺ�켱 Ž��
 * queue ������ �ʿ�(���Լ���)
 * �ݺ���, ����Լ�
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
		//�׷����� �����ϴ� ��� : �������, ��������Ʈ, �����迭
		int[][] G = new int[8][8];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer tk = new StringTokenizer(input," ");
		while(tk.hasMoreTokens()) {
			int s = Integer.parseInt(tk.nextToken());
			int e = Integer.parseInt(tk.nextToken());
			G[s][e] = 1;
			G[e][s] = 1; //���� �׷���
		}
		int[] q = new int[100]; //���� ť ����.
		int front = -1;
		int rear = -1;
		boolean[] visited = new boolean[8];
		
		int v = 1; //���� ����.
		q[++rear] = v; //���� ������ �־��.
		visited[v] = true; //���� v�� �湮������, visited�� true��
		
		while(front!=rear) { //ť�� ������� ���� ��� �ݺ�
			//ť�� ù��° ���� ��ȯ.
			

			v = q[++front]; // ť�� ù��° ���� ��ȯ
			System.out.print(" "+v);
			visited[v] = true;
			
			for (int i = 0; i < visited.length; i++) { //v�� ������ ������ ���� �湮�ߴ��� Ȯ��
			//for(int i = visited.length-1; i>=0; i--) { //ū ���ں���	
			if(G[v][i] == 1 && !visited[i] ) { //������ �����̰�, �湮���� ���� ��.
					//ť�� �ְ�, �湮�� ������ ǥ��.
					q[++rear] = i; //ť�� �ֱ�.
					visited[i] = true;//�湮�� ������ ǥ��.
				}
			}
		}
		
	} //end of main
}//end of class

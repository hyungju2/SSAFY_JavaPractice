import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Z56_������������ã�� {

	public static int[] dy = {-1,-1,-1,0,0,1,1,1}; //��
	public static int[] dx = {-1,0,1,-1,1,-1,0,1}; //��
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 1<=N<=300, ���� ũ��

		for (int testcase = 1; testcase <= T; testcase++) {
			int N = Integer.parseInt(br.readLine()); // 1<=N<=300, ���� ũ��
			char[][] m = new char[N + 2][N + 2]; // �Է¹��� ���� ����, �ܰ��� ���پ� ������ �д�.
			
			for (int i = 1; i <= N; i++) {
				String s = br.readLine();
				for (int j = 1; j <= N; j++) {
					m[i][j] = s.charAt(j - 1);
				}
			} // end of input
			
			int[][] cnt = new int[N + 2][N + 2];// ��ź�� ������ ǥ���ϴ� ��
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (m[i][j] == '*') // ��ź�̶��
					{
						cnt[i][j] = -1; // ��ź�̶�� �ǹ�.
						continue;
					}
					//����ĭ���� ��ź ������ ī����
					for(int k=0; k<dy.length; k++) {
						if(m[i+dy[k]][j+dx[k]] =='*') {
							cnt[i][j]++;
						}
					}
				}
			}
			boolean[][] visited = new boolean[N+2][N+2]; //�湮 ���θ� üũ�� ����.
			
			for(int i=0; i<visited.length; i++) { //�ܰ��� ������ �湮�� ������ �̸� ����. (�ܰ� �� �� �Ⱦ��� �ʿ�x)
				visited[0][i] = true;
				visited[N+1][i] = true;
				visited[i][0] = true;
				visited[i][N+1] = true;
			}
			
			int result = 0; //Ŭ�� ȸ���� ������ ����
			//cnt[][] ���� ��ź�� ���� 0�� ĭ�� ã�Ƽ� ����
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(visited[i][j] ==false && cnt[i][j]==0) {
						bfs(visited,cnt,i,j);
						result++;
					}
				}
			}
			//�湮���� ����, ��ź�� �ƴ� ���ڵ�(������ ���� ĭ) ������ ī����
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(visited[i][j] == false && cnt[i][j]>0) {
						result++;
					}
				}
			}
			
			System.out.println("#"+testcase+" "+result);
			
		} // end of testcase
	}// end of main
	
	public static int[][] q = new int[900000][2];
	//����ĭ�� 0�̸�, ������ ĭ�� �� 0���� ū ����ĭ�� �湮�� ������ ǥ��.

	public static void bfs(boolean[][] visited, int[][]cnt, int r, int c) {
		int front = -1;
		int rear = -1;
		visited[r][c] = true;
		q[++rear][0] = r;
		q[rear][1] = c;
		while(front != rear) { //ť�� ������� ������ �ݺ�
			r = q[++front][0]; //ť���� 1�� ������
			c = q[front][1];
			//�湮�۾� : ������ ĭ�� �� 0���� ū ����ĭ�� �湮�� ������ ǥ��.
			for (int i = 0; i < dy.length; i++) {
				if(visited[r+dy[i]][c+dx[i]]==false&&cnt[r+dy[i]][c+dx[i]]>0) {
					visited[r+dy[i]][c+dx[i]]=true;
				}
			}
			
			//�湮�� ����, ������ ĭ�� ť�� �ֱ�
			for (int i = 0; i < dy.length; i++) {
				if(visited[r+dy[i]][c+dx[i]]==false) {
					q[++rear][0] = r+dy[i];
					q[rear][1] = c+dx[i];
					visited[r+dy[i]][c+dx[i]]=true;
				}
			}
		}
	} //end of bfs
	
}// end of class

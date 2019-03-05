import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import org.omg.Messaging.SyncScopeHelper;

public class Solution_1258 {
	static int N; // �迭�� ũ��
	static int arr[][]; // �Է� ���� 2���� �迭
	static int dX[] = {1,0,-1,0 }; // dX
	static int dY[] = {0,1,0,-1 }; // dY
	static boolean check[][]; // check �迭
	static int count;// �ٸ� ���� ������ count
	static int row; // �� ������
	static int col; // �� �Ʒ�
	
	static int left; //����
 	static int up; //����
	
	static int number; //���� ����
	static ArrayList<bottle> res = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int testcase=1; testcase<=T; testcase++) {
			res.clear();
			N = Integer.parseInt(br.readLine());
			arr=new int[N][N]; //2���� �迭 ����
			check = new boolean[N][N]; //check �迭 �ʱ�ȭ
			
			for(int i=0; i<N; i++) {
					String s = br.readLine();
					StringTokenizer tk = new StringTokenizer(s, " ");
							for(int j=0; j<N; j++) {
								arr[i][j] = Integer.parseInt(tk.nextToken());
							}
				} //end of Input
			
			number=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					row=0;
					col=0;
					count=0;
					left=0;
					up=0;
					if (check[i][j]||arr[i][j]==0) {
						continue;
					}
					BFS(i,j);
					number++;
				}
			}
			
			int temp=res.get(0).number;
		
			bottle[] result = new bottle[N*N];
			
			for(int i=0; i<res.size(); i++) {
				System.out.println(res.get(i).toString());
			}
			System.out.println("���� ��");
			
			int botc=0;
			result[botc++] = res.get(0);
			
			for(int i=1; i<res.size(); i++)
			{
				if(res.get(i).number!=temp)
				{
					temp=res.get(i+1).number;
					result[botc++]=res.get(i);
				
				}
			}
			
			for(int i=0; i<botc; i++) {
				System.out.println(result[i].toString());
			}
			System.out.println("�ߺ� ����");
		
			
			for(int i=0; i<botc; i++) {
				{
					bottle min = result[i];
					int minIndex=i;
					for(int j=i; j<botc; j++) {
						if(min.count>result[j].count) {
							min = result[j];
							minIndex=j;
						}
						
					}
					result[minIndex] = result[i];
					result[i] = min;
				}
			}
			
			for(int i=0; i<botc; i++) {
				System.out.println(result[i].toString());
			}
			System.out.println("ũ�� ������ ����");
			
			System.out.print("#"+testcase+" "+botc);
			
			for(int i=0; i<botc; i++) {
				System.out.print(" "+(result[i].row+1)+" "+(result[i].col+1));
			}
			System.out.println();
		}//end of testcase
	}// end of main

	public static void BFS(int x, int y) {
		if (check[x][y]||arr[x][y]==0) // �湮�� ���̸� ����.
		{
			return;
		} else {
			check[x][y] = true;
			for (int i = 0; i < 4; i++) {
				int nextX = x + dX[i];
				int nextY = y + dY[i];
				if ((nextX>-1)&&(nextY>-1)&&(nextX<N)&&(nextY<N)){ // ���� �ȿ� ������ ��
					if(arr[nextX][nextY]==0||check[nextX][nextY])
						continue;
					else {
						if (i == 0 )// �Ʒ��� �̵�
						{
							row++; // �Ʒ����̵�
							count++; // �ϳ� ����
							BFS(nextX, nextY);
						}
						if(i==2) { //���� �̵�
							up++;
							count++; // �ϳ� ����
							BFS(nextX, nextY);
						}
						if(i==1) { //������ �̵�
							col++; // �� ����
							count++; // �ϳ� ����
							BFS(nextX, nextY);
						}
						if(i==3) { //���� �̵�
							left++;
							count++; // �ϳ� ����
							BFS(nextX, nextY);
						}
						
					}
				}
			} // end of for
		
			res.add(new bottle(row-up, col-left, count,number));
		} // end of else
	}// end of BFS

	public static class bottle implements Comparable<bottle> {
		int row;
		int col;
		int count;
		int number;

		@Override
		public String toString() {
			return "bottle [row=" + row + ", col=" + col + ", count=" + count + ", number=" + number + "]";
		}

		bottle(int row, int col, int count, int number) {
			this.row = row;
			this.col = col;
			this.count = count;
			this.number = number;
		}

		@Override
		public int compareTo(bottle o) {
			return o.count-this.count;
		}
	}
}// end of class

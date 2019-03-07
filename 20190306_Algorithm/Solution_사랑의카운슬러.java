import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * �������� ������ ¦����, �� �� ¦�� �����ش�.
 * ¦�� �����ִ� ��� ����� ���� ����.
 * ������ ¦���� ����� ���͸� ���� -> ��ü �� ���� -> ũ�⸦ ���� -> �ּ� ã��
 * 
 * ��ü ������ �� = �����ġ ������ ��ǥ �� - �������� ������ ��ǥ ��
 * 	�����ġ������ ����Ǿ ��ü ���� ���� ����
 * 	������ġ���� ����Ǿ ��ü ������ ���� ����
 * �ᱹ, �����ġ�� �׷�, ������ġ�� �׷����� �����ϴ� ���� = 
 * �����ġ�� �� �� �ִ� N/2������ �����̸� ã�� ���չ���
 * 
 */

public class Solution_�����ī��� {
	
	public static int[][] m; //�������� ��ǥ�� ������ �迭.
	public static int[][] tr; //������ �����̸� ������ �迭
	public static long min; //���� ũ���� �ּҰ�
	public static int sumX, sumY; //��ü x, y ��ǥ�� ��
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int testcase=1; testcase<=TC; testcase++) {
			int N = Integer.parseInt(br.readLine()); //�������� ����
			m = new int[N][2]; //�������� ��ǥ�� ����.
			
			sumX = sumY = 0;
			
			for(int i=0; i<N; i++) {
				StringTokenizer tk = new StringTokenizer(br.readLine()," ");
				int x = Integer.parseInt(tk.nextToken());
				int y = Integer.parseInt(tk.nextToken());
				m[i][0] = x;
				m[i][1] = y;
				sumX+=x;
				sumY+=y;
			}
			tr = new int[N/2][2]; //������ �������� �迭�� ����.
			min = Long.MAX_VALUE;
			comb(N, N/2);
			System.out.println("#"+testcase+" "+min);
		} //end of testcase
	}//end of main
	
	public static void comb(int n, int r) {
		if(n<r)
			return;
		else
			if(r==0) { //�ϳ��� ������ �ϼ� ��.
				int sumSelectX =0; //������ �����̵��� x��
				int sumSelectY =0; //������ �����̵��� y��
				
				for (int i = 0; i < tr.length; i++) { //������ ������ ��ŭ �ݺ�
					sumSelectX +=tr[i][0];
					sumSelectY +=tr[i][1];
				}
				int sumUnselectX = sumX - sumSelectX; //��ü���� ���õ� ���� ��, ���õ��� ����x��ǥ ��
				int sumUnselectY = sumY - sumSelectY; //��ü���� ���õ� ���� ��
				long vX = sumSelectX - sumUnselectX;
				long vY = sumSelectY - sumUnselectY;
				long v = vX*vX + vY*vY;
				if(min>v)
					min = v;
			}else {
				tr[r-1][0] = m[n-1][0];
				tr[r-1][1] = m[n-1][1];
				comb(n-1,r-1);
				comb(n-1,r);
			}
	} //end of comb
}//end of class

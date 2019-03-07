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
 * 1�� ���: ������ �����̸� tr �迭�� �����س���, ������ �ϼ��Ǹ� ó������ �����Ѵ�.
 * 2�� ���: ������ �Ѹ��� ������ ������ �������� ����� �Ű������� ������ �ٴѴ�.
 * 
 */

public class Solution_�����ī���2 {
	
	public static int[][] m; //�������� ��ǥ�� ������ �迭.
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
			min = Long.MAX_VALUE;
			comb(N,N/2,0,0); //���� ������ x,y�� ��ǥ.
			System.out.println("#"+testcase+" "+min);
		} //end of testcase
	}//end of main
	
	//������ (n,c,������� ������ �������� x��, y�� ��)
	public static void comb(int n, int r,int sumX, int sumY) {
		if(n<r)
			return;
		else
			if(r==0) { //�ϳ��� ������ �ϼ� ��.
				int sumUnselectX = sumX - sumX; //��ü���� ���õ� ���� ��, ���õ��� ����x��ǥ ��
				int sumUnselectY = sumY - sumY; //��ü���� ���õ� ���� ��
				long vX = sumX - sumUnselectX;
				long vY = sumY - sumUnselectY;
				long v = vX*vX + vY*vY;
				if(min>v)
					min = v;
			}else {
				comb(n-1,r-1, sumX+m[n-1][0],sumY+m[n-1][1]); //������ ���
				comb(n-1,r, sumX,sumY); //�������� ���� ���
			}
	} //end of comb
}//end of class

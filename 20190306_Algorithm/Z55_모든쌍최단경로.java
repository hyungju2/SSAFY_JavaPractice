/**
 * ��� �� �ִ� ���(All Pairs Shortest) DP : ���� ��ȹ�� O[n^3]
 * 
 *
 */
public class Z55_�����ִܰ�� {
	public static void main(String[] args) {
		final int M = Integer.MAX_VALUE;
		int[][] D = { {0,4,2,5,M},
					  {M,0,1,M,4},
					  {1,3,0,1,2}, 
					  {-2,M,M,0,2}, 
					  {M,-3,3,1,0} };
		//���
		for(int i=0; i<D.length; i++) {
			for(int j=0; j<D[i].length; j++) {
				System.out.printf("%2s, ", D[i][j] == M?"M":D[i][j]);
			}
			System.out.println();
		}
		for(int k=0; k<D.length; k++) {//���� �� ����
			for(int i=0; i<D.length; i++) { //��������
				if(k==i) continue; //���� cycle�� ��, continue
				for(int j=0; j<D.length; j++) { //���� ����
					if(k==j||i==j) continue; //���� �ٸ� ���� �湮
					
				//	D[i][j] = min(D[i][j], D[i][k]+D[k][j]]) //���� ���� ��� or �����ؼ� ���� ��� �� ������.
				
				// ������            ���� ������ ���İ��� ���ο� �� ��� ��.
				// D[i][j] = D[i][k] + D[k][j];
				
			    //Case1: ���� ���� ��� M / ���� ���� ��� M -> �׳� �д�.
				//Case2: ���� ���� ���1 / ���� ���� ��� M -> �׳� �д�.
				//Case3: �������� ��� M / ���� ���� ��� 1 -> Update(���ο� ���)
				//Case4: ���� ���� ���1 / ���� ���� ��� 1 -> �� ��, ���� ��η� ����.
					if(D[i][k] !=M && D[k][j] !=M //���ο� ��ΰ� ���Ѵ밡 �ƴϴ�.
							&&D[i][j]>D[i][k]+D[k][j]) {
						D[i][j]=D[i][k]+D[k][j]; // �� ��ΰ� �� ���� ���̸� Update
					}
				}
			}
		}
		
		System.out.println("�ִ� ���");
		for(int i=0; i<D.length; i++) {
			for(int j=0; j<D[i].length; j++) {
				System.out.printf("%2s, ",D[i][j]);
			}
			System.out.println();
		}
	}//end of main
}//end of class

import java.util.Arrays;

/**
 * ���ͽ�Ʈ�� Dijkstra 
 * �ϳ��� �������� �����ؼ� ������ �������� �ִܰŸ��� ���ϴ� �˰���
 * ���� �ƴ� ����ġ������ ��� ����
 * O[n^2]
 * 
 * ��� �������� ����ؼ� ������ ��� ���������� �ִܰŸ��� ���Ϸ���?
 * ���ͽ�Ʈ�� * n(������ ������ŭ �ݺ�)
 *  = �÷��̵� ���� �˰��� O[n^3] �ڵ尡 ����.
 * 
 * 
 */
public class Z39_Dijkstra {
	public static void main(String[] args) {
		final int M = Integer.MAX_VALUE;
		int[][] G= {
				{0,3,5,M,M,M},
				{M,0,2,6,M,M},
				{M,1,0,4,6,M},
				{M,M,M,0,2,3},
				{3,M,M,M,0,6},
				{M,M,M,M,M,0}
		};
		
		int s = 0; //���� ���� ����
		int[] D = G[s].clone(); //���������� ���������� ��������, ����ġ �迭�� �ʱ�ȭ. clone()�� ���� ����.
		boolean[] used = new boolean[G.length]; //������ ���̸�ŭ. ����� ������ ����(visited)
		
		for(int i=0; i<used.length; i++) { //������ ������ŭ �ݺ�, �� ����Ŭ ���� ���� 1���� ���õ�.
			//������� ���� �����߿� ����ġ�� �ּ��� ��.
			int minIndex = -1; //�ּ� ����ġ�� index
			int min = M; //�ּ� ����ġ ���� ����.
			
			for(int j=0;j<D.length; j++) {
				if(!used[j] && min>D[j]) {
					minIndex = j;
					min = D[j];
				}
			}
			//�ּ� ����ġ�� ���� ������ ����, ���� ��ȣ : minIndex
			used[minIndex] = true; //��� �� ������ ����.
			
			//�ּ� ����ġ�� ������ �����ؼ� �� ������ ���ؼ� �� �� �ִ� ������ ������ ���� ������Ʈ
			for (int j = 0; j < D.length; j++) {
				//������� ���� ���� && ������ ���� && ����ġ�� �۾����� ������Ʈ
				if(!used[j]&&G[minIndex][j]!=M&&D[j]>D[minIndex]+G[minIndex][j]) {
					D[j] = D[minIndex] + G[minIndex][j];
				}
			}
			System.out.println(Arrays.toString(D)); //����ġ �迭
			
			System.out.println(D[1]); //a�������� ����ؼ� b������ �ִܰŸ�.
			System.out.println(D[2]); //a�������� ����ؼ� c������ �ִܰŸ�.
			System.out.println(D[3]); //a�������� ����ؼ� d������ �ִܰŸ�.
		}
		
	}// end of main
}


public class Z30_��Ʈ {
	public static void main(String[] args) {
		int n = 0b100110111; //(b�� �����ϸ� 0~1����)
		int x = 0x1; //16������ �����ϸ�, maximum 8�ڸ�
		System.out.println(n & 0b1); //�� �ڸ��� bit�� ��� 0���� ä����.
		System.out.println((n & 0b10)==0 ? 0:1); //�����ϸ� ���� ��µ�. bit�� 0,1���� Ȯ���ϱ� ���� checksum
		
		for (int i = 8; i>=0 ; i--) {
			System.out.print((n&(1<<i)) == 0? 0:1);
		}
		System.out.println();
		System.out.println("original num:"+n);
		//�ڸ����� ���� ���� (int)logN +1�� �ϸ� �ڸ����� ���� �� �ִ�.
		//�ڸ��� ���ϱ� 8.0<=log2(N) <9.0�� N�� 9�ڸ����
		// 1�� �����ְ� int���� �ϸ� 9�� ���� ���� �� �ִ�.
		// �� ���� Ÿ�Կ� �°� �α��� ���� �ٲ��ָ� �� �ڸ������� ���� �� �ִ�. 
		int res = (int)(Math.log(n)/Math.log(2)) +1;
		System.out.println(res+"�ڸ���");
		
		//2������ 10������ �����ϱ�
		int result=0;

		for(int i=8; i>=0; i--) {
			result <<=1; //�ڸ��� �ø�
			if((n&(1<<i))!=0) {
				result++;
			}
		}
		
		System.out.println(result);
	}
}

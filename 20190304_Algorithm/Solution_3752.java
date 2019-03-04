import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution_3752 {

	public static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= T; testcase++) {
			int N = Integer.parseInt(br.readLine());
			boolean check[] = new boolean[10001]; //�ִ� ���� 100�� * 100�� case => �� ���� �ִ�ġ�� 10000
			String num = br.readLine();
			StringTokenizer tk = new StringTokenizer(num, " ");
			arr = new int[N]; // �迭 �ʱ�ȭ
			int sum = 0;
			for (int i = 0; i < N; i++) {
				int inum = Integer.parseInt(tk.nextToken()); 
				arr[i] = inum; 
				for(int j=sum; j>=0; j--) { //���� �� �ִ� ���� �պ��� ���� ���� Ž��
					if(check[j]) { //check[j]�� true�̷���, ���� �Է¹��� ���̰ų�, ���� �Է¹��� ������ ���� �� �ִ� ���յ� 
						check[j+inum]=true; //���� �Է¹��� �� + ���� �Է¹����� or ���� ���� ����+ ���� �Է¹��� ��
					}
				}
				check[inum]=true; //���� �Է¹��� ���� true�� ���ش�.
				sum+=inum; //���� �������Ѱ���.
			}
			if(sum==0) { //0�Է¹��� ���� ����ó��
				System.out.println("#"+testcase+" "+0);
				return;
			}
			int count =1;  //0�� �ƴ϶��, �ּ� 1���̻��� ���̽��� �ִ�.(0���� ��)
			for(int i=1; i<=sum;i++) { //�ִ�ġ���� check�迭�� true�� ������ ī��Ʈ.
				if(check[i])
					count++;
			}
			System.out.println("#"+testcase+" "+count);
		}// end of testcase
	}// end of main



}// end of class

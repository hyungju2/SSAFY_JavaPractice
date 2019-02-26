import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_5986_�����̿ͼ��Ҽ�_������ {

	static boolean check[] = new boolean[1000];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		getCheck();

		for (int testcase = 1; testcase <= T; testcase++) {
			int N = Integer.parseInt(br.readLine());
			int x = 2;
			int y = 2;
			int z = 2;
			int count = 0;
			for (x = 2; x <= N - 4; x++) { // y,z�� ���� �� �ִ� �ּ� �Ҽ��� 2,2�� ������.
				if (check[x]) // 2�� 3�� �ƴ� �Ҽ��� �� continue;
					continue;
				for (y = 2; x + y <= N - 2; y++) { // x+y�� ���� N�� �ʰ��ع����� z�� Ȯ�� �� �ʿ䰡 ����.
					if (x > y)
						continue;
					if (check[y]) // �� ���� �Ҽ��� ��
						continue;
					for (z = 2; x + y + z <= N; z++) {
						if (y > z)
							continue;
						if (x + y + z < N) // 3���� ���� N���� �۴ٸ� continue.
							continue;
						if (check[z]) // z�� �Ҽ��� �ƴ϶��, continue.
							continue;
						count++;
					}
				}
			}
			System.out.println("#" + testcase + " " + count);
		} // end of testcase
	}// end of main

	public static void getCheck() {
		check[1] = true; // true�� �Ҽ��� �ƴϴ�.
		for (int i = 2; i < 1000; i++) {
			if (check[i] == false)
				for (int a = i * 2; a < 1000; a += i) {
					check[a] = true;
				}

		}
	} // get Check
}// end of class

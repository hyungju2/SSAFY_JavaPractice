import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_2634 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer tk = new StringTokenizer(s, " ");
		ArrayList<Animal> ani = new ArrayList<>();
		int M = Integer.parseInt(tk.nextToken()); // ����� ��
		int N = Integer.parseInt(tk.nextToken()); // ������ ��
		int L = Integer.parseInt(tk.nextToken()); // �����Ÿ�
		s = br.readLine();
		tk = new StringTokenizer(s, " ");
		int hun[] = new int[M];

		for (int i = 0; i < M; i++) { // ����� ��
			hun[i] = Integer.parseInt(tk.nextToken());
		}
		int count = 0;
		for (int i = 0; i < N; i++) { // ���� �Է¹���
			s = br.readLine();
			tk = new StringTokenizer(s, " ");
			int x = Integer.parseInt(tk.nextToken());
			int y = Integer.parseInt(tk.nextToken());
			ani.add(new Animal(x, y, 0));
		}
		Arrays.sort(hun);
		int min;
		Animal tmp;
		int tempindex = 0;

		for (int i = 0; i < ani.size(); i++) {
			min = ani.get(i).x;
			tempindex = i;
			for (int j = i + 1; j < ani.size(); j++) {
				if (min > ani.get(j).x) {
					tempindex = j;
					min = ani.get(j).x;
				}
			}
			tmp = ani.get(i); // ū ��
			ani.set(i, ani.get(tempindex)); // ū ���� ��ġ��, �� ���� ���� �ִ´�.
			ani.set(tempindex, tmp); // ���� �������� �ִ� ��ġ�� ū ���� �־��ش�.
		}

		for (int i = 0; i < hun.length; i++) {
			for (int j = 0; j < ani.size(); j++) {
				if (ani.get(j).count != 0) // �̹� ���� ����
					continue;
				int temp = hun[i] > ani.get(j).x ? hun[i] - ani.get(j).x : ani.get(j).x - hun[i];
				if (ani.get(j).y > L || temp > L)
					continue;
				int length = temp + ani.get(j).y;
				if (length > L)
					continue;
				else {
					if (length <= L) {
						count++;
						ani.get(j).count++;
					}
				}
			}
		}
		System.out.println(count);
	}// end of main

	public static class Animal {
		int x;
		int y;
		int count; // �� �� ��������

		Animal(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
}// end of class

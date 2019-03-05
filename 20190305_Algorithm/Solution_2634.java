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
		int M = Integer.parseInt(tk.nextToken()); // 사대의 수
		int N = Integer.parseInt(tk.nextToken()); // 동물의 수
		int L = Integer.parseInt(tk.nextToken()); // 사정거리
		s = br.readLine();
		tk = new StringTokenizer(s, " ");
		int hun[] = new int[M];

		for (int i = 0; i < M; i++) { // 사대의 수
			hun[i] = Integer.parseInt(tk.nextToken());
		}
		int count = 0;
		for (int i = 0; i < N; i++) { // 동물 입력받음
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
			tmp = ani.get(i); // 큰 값
			ani.set(i, ani.get(tempindex)); // 큰 값의 위치에, 더 작은 값을 넣는다.
			ani.set(tempindex, tmp); // 원래 작은값이 있던 위치에 큰 값을 넣어준다.
		}

		for (int i = 0; i < hun.length; i++) {
			for (int j = 0; j < ani.size(); j++) {
				if (ani.get(j).count != 0) // 이미 잡힌 동물
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
		int count; // 몇 번 잡혔는지

		Animal(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
}// end of class

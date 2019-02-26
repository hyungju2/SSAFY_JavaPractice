import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_6485_삼성시의버스노선_이형주 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= T; testcase++) {
			int N = Integer.parseInt(br.readLine());
			Bus arr[] = new Bus[N];
			for (int busstop = 0; busstop < N; busstop++) {
				StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
				arr[busstop] = new Bus(Integer.parseInt(tk.nextToken()), Integer.parseInt(tk.nextToken()));
			}
			Arrays.sort(arr);
			int p = Integer.parseInt(br.readLine());
			int busc[] = new int[p]; //버스들의 번호를 저장
			int res[] = new int[p];
			for (int bus = 0; bus < p; bus++) {
				busc[bus] = Integer.parseInt(br.readLine());
			}
			int count = 1;
			for (int i = 0; i < p; i++) {
				for (int j = 0; j < N; j++) {
					if (busc[i] < arr[j].start) //버스번호가, 정류장의 시작점보다 작으면
						continue;
					else if (busc[i] <= arr[j].last) { //버스번호가 정류장의 끝 이하일 떄, 즉 포함될 떄
						res[i]+=count; //결과를 저장하는res배열의 i(버스번호)번째에 값을 1씩 증가.
					}
				}
			}
			System.out.print("#"+testcase);
			for(int i=0; i<res.length; i++)
			{
				System.out.print(" "+res[i]);
			}
			System.out.println();
		} // end of testcase
	}// end of main

	public static class Bus implements Comparable<Bus> {
		int start;
		int last;

		Bus(int start, int last) {
			this.start = start;
			this.last = last;
		}

		public int compareTo(Bus o) {
			return this.start - o.start;
		}
	}
}// end of class

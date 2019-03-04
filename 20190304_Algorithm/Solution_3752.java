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
			boolean check[] = new boolean[10001]; //최대 점수 100점 * 100개 case => 총 합의 최대치는 10000
			String num = br.readLine();
			StringTokenizer tk = new StringTokenizer(num, " ");
			arr = new int[N]; // 배열 초기화
			int sum = 0;
			for (int i = 0; i < N; i++) {
				int inum = Integer.parseInt(tk.nextToken()); 
				arr[i] = inum; 
				for(int j=sum; j>=0; j--) { //나올 수 있는 값의 합보다 작은 범위 탐색
					if(check[j]) { //check[j]가 true이려면, 전에 입력받은 값이거나, 전에 입력받은 값에서 만들 수 있는 조합들 
						check[j+inum]=true; //전에 입력받은 것 + 새로 입력받은것 or 전에 나온 조합+ 새로 입력받은 것
					}
				}
				check[inum]=true; //현재 입력받은 값은 true로 해준다.
				sum+=inum; //값을 누적시켜간다.
			}
			if(sum==0) { //0입력받을 때의 예외처리
				System.out.println("#"+testcase+" "+0);
				return;
			}
			int count =1;  //0이 아니라면, 최소 1개이상의 케이스가 있다.(0점일 때)
			for(int i=1; i<=sum;i++) { //최대치까지 check배열이 true인 개수를 카운트.
				if(check[i])
					count++;
			}
			System.out.println("#"+testcase+" "+count);
		}// end of testcase
	}// end of main



}// end of class

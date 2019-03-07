import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 지렁이의 개수는 짝수게, 둘 씩 짝을 지어준다.
 * 짝을 지어주는 모든 경우의 수를 생각.
 * 각각의 짝으로 만드는 백터를 구함 -> 전체 합 구함 -> 크기를 구함 -> 최소 찾음
 * 
 * 전체 백터의 합 = 출발위치 지렁이 좌표 합 - 도착위지 지렁이 좌표 합
 * 	출발위치끼리는 변경되어도 전체 백터 합은 동일
 * 	도착위치끼리 변경되어도 전체 백터의 합은 동일
 * 결국, 출발위치의 그룹, 도착위치의 그룹으로 분할하는 문제 = 
 * 출발위치에 올 수 있는 N/2마리의 지렁이를 찾는 조합문제
 * 
 * 1번 방법: 선택한 지렁이를 tr 배열에 저장해놓고, 조합이 완성되면 처음부터 덧셈한다.
 * 2번 방법: 지렁이 한마리 선택할 때마다 덧셈을한 결과를 매개변수로 가지고 다닌다.
 * 
 */

public class Solution_사랑의카운슬러2 {
	
	public static int[][] m; //지렁이의 좌표를 저장할 배열.
	public static long min; //벡터 크기의 최소값
	public static int sumX, sumY; //전체 x, y 좌표의 합
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int testcase=1; testcase<=TC; testcase++) {
			int N = Integer.parseInt(br.readLine()); //지렁이의 개수
			m = new int[N][2]; //지렁이의 좌표를 저장.
			
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
			comb(N,N/2,0,0); //현재 선택한 x,y의 좌표.
			System.out.println("#"+testcase+" "+min);
		} //end of testcase
	}//end of main
	
	//조합의 (n,c,현재까지 선택한 지렁이의 x합, y의 합)
	public static void comb(int n, int r,int sumX, int sumY) {
		if(n<r)
			return;
		else
			if(r==0) { //하나의 조합이 완성 됨.
				int sumUnselectX = sumX - sumX; //전체에서 선택된 것을 뺌, 선택되지 않은x좌표 합
				int sumUnselectY = sumY - sumY; //전체에서 선택된 것을 뺌
				long vX = sumX - sumUnselectX;
				long vY = sumY - sumUnselectY;
				long v = vX*vX + vY*vY;
				if(min>v)
					min = v;
			}else {
				comb(n-1,r-1, sumX+m[n-1][0],sumY+m[n-1][1]); //선택한 경우
				comb(n-1,r, sumX,sumY); //선택하지 않은 경우
			}
	} //end of comb
}//end of class

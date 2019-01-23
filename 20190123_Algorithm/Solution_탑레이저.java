import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_탑레이저{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int []tower = new int[num+1];
		int []stack = new int[num+1];
		int index = 1, max = 0;
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		while(st.hasMoreTokens()){
			tower[index++] = Integer.parseInt(st.nextToken());
		}
		for(index = 1; index < num + 1; index++) {
			
			if(max < tower[index]) { //본인보다 오른쪽에 더 높은 탑이 있다면, 레이저가 도달하지 않으므로 검사 x
				max = tower[index]; 
				stack[index] = 0;
				continue;
			}
			int beside = index-1;
			while(beside > 0) {
				if(tower[index] < tower[beside]) {
					break; //만약 옆에 탑이 더 작다면 루프를 빠져나옴.
				}
				beside--; //한칸씩 왼쪽으로 이동. 본인보다 높은 높이의 탑이 있다면, beside에 번호가 찍힘.
			}
			stack[index] = beside; //찍힌 beside를 stack의 index에 저장.
		}
			
		for(index = 1 ; index < num+1 ; index++ ) {
			System.out.print(stack[index] + " "); //전체 stack에 있는 값 출력.
		}
		
	}//end of main
}//end of class

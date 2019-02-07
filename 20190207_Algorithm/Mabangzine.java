import java.util.ArrayList;
import java.util.Scanner;

public class Mabangzine {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.print("행의 개수: ");
		int size = sc.nextInt();
		int resultsum = 0;
		int[][] mat = new int[size][size];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				mat[i][j] = sc.nextInt();
				resultsum+=mat[i][j];
			}
		}

		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		int index = 0;
		for (int cnt = 0; cnt < size; cnt++) {
			int sum = 0;
			for (int i = 0; i < size; i++) {
				 sum += mat[cnt][i]; // 가로 합을 0,1,2에 넣음.
			}
			list.add(sum);
		}

		for (int i =0; i < size; i++) {
			int sum = 0;
			for (int k = 0; k < size; k++) {
				sum+= mat[k][i];
			}
			list.add(sum);
		}

		int sum = 0;
		for(int i=0; i<size; i++) {
			sum+=mat[i][i];
		}
		list.add(sum);
		
		check(list);

		System.out.println("총 합:"+resultsum);
		System.out.println("한 행의 값:"+resultsum/size);
	}// end of main
	
	public static void check(ArrayList<Integer> a) {
		for(int i=0; i<a.size()-1; i++)
		{
			if(a.get(i)!=a.get(i+1))
				{System.out.println("마방진이 아닙니다.");
				return;
				}
		}
			System.out.println("마방진입니다");
	}
}

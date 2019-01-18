import java.util.Scanner;
public class Solution_5431_민석이의과제하기_이형주 {
public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	

	for(int testcase=1; testcase<=T; testcase++)
	{
		
		int N,K; //N은 수강생 수, K는 제출한 수
		N = sc.nextInt();
		K = sc.nextInt();
		
		Boolean Array[] = new Boolean[N+2];
		for(int i=0; i<Array.length; i++)
		{
			Array[i] = false;
		}
		
		for(int j=1; j<=K; j++)
		{
			int num = sc.nextInt();
			Array[num] = true;
		}
		
	/*	for(int j=1; j<=N; j++)
		{
	
			System.out.print(Array[j]+" "+j+" "); 
		}
		*/
	
		System.out.print("#"+testcase);
		for(int j=1; j<=N; j++)
		{
			if(Array[j]==false)
			{
				System.out.print(" "+j);
			}
		}
		System.out.println();
		
	}//end of testcase
	
}//end of main
}//end of class

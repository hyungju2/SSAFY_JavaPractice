import java.util.Scanner;

public class Solution_2063_중간값찾기_이형주 {



public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();
	
	int Array[] = new int[200];
	
	for(int i=1; i<=N; i++)
	{
		Array[i] = sc.nextInt();
	}
	
	//buble sort
	for(int i=1; i<N+1; i++)
	{
		for(int j=1; j<=N-i; j++)
		{
			if(Array[j]>Array[j+1])
			{
				int temp = Array[j];
				Array[j] = Array[j+1];
				Array[j+1] = temp;
			}
		}
	}
			System.out.print(Array[N/2+1]+" ");

		}//end of main
}//end of class

import java.util.Scanner;

public class Solution_1204_SW_문제해결기본1일차_최빈수구하기_이형주 {



public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	
	for(int testcase = 1; testcase<=T; testcase++)
	{
		sc.nextInt();	
	int Array[] = new int[1001];
	int max = 0;
	int MaxArray[] = new int[1001];
	
	for(int i=1; i<=1000; i++)
	{
		Array[i] = sc.nextInt();
	}
	
	//buble sort
	for(int i=1; i<1000; i++)
	{
		for(int j=1; j<=1000-i; j++)
		{
			if(Array[j]>Array[j+1])
			{
				int temp = Array[j];
				Array[j] = Array[j+1];
				Array[j+1] = temp;
			}
		}
	}
	
	for(int i=1; i<1000; i++)
	{
		if(Array[i]==Array[i+1])
			MaxArray[Array[i]]++;
	}
	for(int i=1; i<=1000; i++)
	{
		if(max<MaxArray[i])
			max=MaxArray[i];
	}
	
	for(int i=1000; i>0; i--)
	{
		if(max==MaxArray[i])
			{
			System.out.println("#"+testcase+":"+i);
			break;
			}
	}

	}//end of testcase
		}//end of main
}//end of class

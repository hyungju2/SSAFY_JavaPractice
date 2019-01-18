import java.util.Arrays;
import java.util.Scanner;

public class Solution_1208_SW문제해결기본1일차_Flatten_이형주 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int testcase=1; testcase<=10; testcase++)
		{
			int height[] = new int[101];
			int max = 0;
			int min =100;
			int Dump = sc.nextInt();
			for(int i=1; i<=100; i++)
			{
				int heigh = sc.nextInt();
				height[i] = heigh;
			}
		
			for (int i = height.length-1; i > 0; i--) { //정렬 할 범위의 시작위치
				for(int j = 0; j<i; j++) { //실제 정렬 할 범위
						if(height[j]>height[j+1]) //두개의 값을 비교해서 큰 값으로 교환.
						{
							int temp = height[j];
							height[j] = height[j+1];
							height[j+1] = temp;
						}
				}
			
			}
			for(int t=1; t<=Dump; t++)
			{
				if(max==min)
					break;
				
				max = height[100];
				min = height[1];
				
				
				height[100]--;
				height[1]++;
				
				for (int i = height.length-1; i> 0; i--) { //정렬 할 범위의 시작위치
					for(int j = 0; j<i; j++) { //실제 정렬 할 범위
							if(height[j]>=height[j+1]) //두개의 값을 비교해서 큰 값으로 교환.
							{
								int temp = height[j];
								height[j] = height[j+1];
								height[j+1] = temp;
							}
					}
				if(i == height.length/2) {
					break; //중간에 빠져 나옴. 끝까지 정렬하는 것보다 효율적임. 
				}
				}	
			}
		
			
			System.out.println("#"+testcase+" "+(height[100]-height[1]));
		}//end of testcase
	}//end of main
}//end of class

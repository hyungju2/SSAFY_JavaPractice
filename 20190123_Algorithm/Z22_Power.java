/**
 * 제곱 재귀함수
 * @author student
 *
 */
public class Z22_Power {
	public static void main(String[] args) {
	
		//2^10을 출력.
		
		System.out.println(power(2,10));
		
	}//end of main

	private static int power(int i, int j) {
		if(j==0) //종료파트
		{
			return 1;
		}
		else 
			if(j==1)//재귀파트
		return i;
		
		else
			if(j%2 ==0)
			{
					int n = power(i,j/2);
					return n*n;
			}
			else
			{
				int n = power(i,(j-1)/2);
				return n*n*i;
			}
	}
}//end of class

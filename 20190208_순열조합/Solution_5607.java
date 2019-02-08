import java.util.Scanner;

public class Solution_5607 {
	public static int p = 1234567891;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for (int testcase = 1; testcase <= TC; testcase++) {

			int N = sc.nextInt(); // 1~1000000
			int R = sc.nextInt(); // 0~N

			long[] fact = new long[N+1]; // factorial값을 %p하여 저장할 배열.
			fact[0] = 1;
			for (int i = 1; i < fact.length; i++) {
				fact[i] = fact[i-1]*i%p;
			}

			long result = fact[N] * power(fact[N-R]*fact[R]%p,p-2)%p; // nCr한 결과값.
			System.out.println("#" + testcase + " " + result);
		} // end of testcase
	}// end of main

	public static long power(long base, long ex) { //재귀함수, base ^ex 제곱승을 리턴.
		if(ex ==0) { //종료
			return 1;
		}else if(ex ==1){ //재귀
			return base;
		}
		else if(ex%2==0){ //짝수의 경우. x^8 = x^4 * x^4
			long result = power(base,ex/2); //Memoization
			return result*result % p; //반쪽 짜리의 제곱. 중간 중간에 모듈러 연산을 해줌으로써 범위 초과를 방지.
		}
		else { //홀수일 때
			long result = power(base,ex/2);
			return result*result%p*base %p; // x^9 = x^4 * x^4 * x
		}
	}
}


public class Z30_비트 {
	public static void main(String[] args) {
		int n = 0b100110111; //(b로 지정하면 0~1까지)
		int x = 0x1; //16진수로 선언하면, maximum 8자리
		System.out.println(n & 0b1); //앞 자리의 bit는 모두 0으로 채워짐.
		System.out.println((n & 0b10)==0 ? 0:1); //연산하면 값이 출력됨. bit가 0,1인지 확인하기 위한 checksum
		
		for (int i = 8; i>=0 ; i--) {
			System.out.print((n&(1<<i)) == 0? 0:1);
		}
		System.out.println();
		System.out.println("original num:"+n);
		//자릿수를 구할 때면 (int)logN +1을 하면 자릿수를 구할 수 있다.
		//자릿수 구하기 8.0<=log2(N) <9.0임 N이 9자리라면
		// 1을 더해주고 int형을 하면 9의 값을 얻을 수 있다.
		// 각 진수 타입에 맞게 로그의 밑을 바꿔주면 몇 자릿수인지 구할 수 있다. 
		int res = (int)(Math.log(n)/Math.log(2)) +1;
		System.out.println(res+"자릿수");
		
		//2진수를 10진수로 변경하기
		int result=0;

		for(int i=8; i>=0; i--) {
			result <<=1; //자릿수 올림
			if((n&(1<<i))!=0) {
				result++;
			}
		}
		
		System.out.println(result);
	}
}

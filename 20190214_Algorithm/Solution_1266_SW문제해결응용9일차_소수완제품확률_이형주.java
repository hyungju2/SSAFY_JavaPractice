import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1266_SW문제해결응용9일차_소수완제품확률_이형주 {
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int testcase=1; testcase<=T; testcase++)
		{
			
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s," ");
			
			int ia = Integer.parseInt(st.nextToken());
			int ib = Integer.parseInt(st.nextToken());
			
			double a = (float)ia/100;
			double b = (float)ib/100;
			
			double Arra[] = new double[19];
			double Arrb[] = new double[19];
			double resA =0;
			double resB =0;
			double result = 0;
		
			
			Arra[0] = pow(1-a,18); //아무것도 못 만들 확률
			Arrb[0] = pow(1-b,18);
			Arra[1] = a*pow(1-a,17)*18;
			Arrb[1] = b*pow(1-b,17)*18; //한 개만들 확률
			
			int num=2;
			
			for(int i=4; i<=18; i++)
			{
				if((i%2!=0)&&(i%3!=0))
				{	
					continue;
				} //소수라면 continue
				else
				{
					Arra[num]=pow(a,i)*pow(1-a,18-i)*((reFact(18,i)/Fact(i)));
					Arrb[num]=pow(b,i)*pow(1-b,18-i)*((reFact(18,i)/Fact(i)));
					num++;
				}
			}
			
			result = 0;
			
			for(int i=0; i<12;i++)
			{
				resA=Arra[i];
				for(int j=0; j<12; j++)
					{
						resB=Arrb[j];
						result+=resA*resB;
					}
			}
			System.out.printf("#"+testcase+" ");
			System.out.printf("%.6f", 1-result);
			System.out.println();
		} //end of testcase
	} //end of main
	
	public static double reFact(int n, int k) {
		if(k==0)
			return 1;
		else
			return n*reFact(n-1,k-1);
	}
	
	public static double Fact(int n) {
		if(n<=1)
			return 1;
		else
			return n*Fact(n-1);
	}
	
	public static double pow(double num, int k) {
		if(k==0) {
			return 1;
		}
		else if(k==1) {
			return num;
		}else if(k%2==0) {
			double tmp = pow(num, k/2);
			return tmp*tmp;
		}
		else {
			double tmp = pow(num, k/2);
			return tmp*tmp*num;
		}
	} //end of pow
	
}

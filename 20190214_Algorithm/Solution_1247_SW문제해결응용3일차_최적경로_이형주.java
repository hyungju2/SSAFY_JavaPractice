import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1247_SW문제해결응용3일차_최적경로_이형주 {
	
	static int resx[] = new int[1000000];
	static int resy[] = new int[1000000];
	static int answer = 100000;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
	
		for (int testcase = 1; testcase <= T; testcase++) {
			int N = Integer.parseInt(br.readLine());
			int homex[] = new int[1];
			int homey[] = new int[1];
			
			int corpx[] = new int[1];
			int corpy[] = new int[1];
			
			
			int x[] = new int[101];
		    int	y[] = new int[101];
			
			String s = br.readLine();
			StringTokenizer tk = new StringTokenizer(s, " ");
			
			homex[0] = Integer.parseInt(tk.nextToken());
			homey[0] = Integer.parseInt(tk.nextToken());
			
			corpx[0] = Integer.parseInt(tk.nextToken());
			corpy[0] = Integer.parseInt(tk.nextToken());
			
			int num  = 0;
			//num 1은 회사, 2는 집, 3부터가 고객의 집
			while(tk.hasMoreTokens()) {
				x[num] = Integer.parseInt(tk.nextToken());
				y[num] = Integer.parseInt(tk.nextToken());
				num++;
			}
			answer = 1000000;
			Perm(homex,homey,corpx,corpy,x,y,num,num,num);
			System.out.println("#"+testcase+" "+answer);
		} // end of testcase

	}// end of main
	
	public static void Perm(int[] homex, int[] homey, int[] corpx, int[] corpy,int []x, int[]y, int n, int r, int q) {
		
		int result = 0;
		if(r==0) {
			result = process(homex, homey, corpx, corpy, x,y, q);
			if(answer>result)
				answer=result;
			
		}
		for(int i=n-1; i>=0; i--) {
			int temp = x[i];
			int temp2 = y[i];
			x[i] = x[n-1];
			y[i] = y[n-1];
			x[n-1] = temp;
			y[n-1] = temp2;
			
			resx[r-1] = x[n-1];
			resy[r-1] = y[n-1];
			
			Perm(homex, homey, corpx, corpy, x,y,n-1, r-1, q);
			
			temp = x[i];
			temp2 = y[i];
			x[i] = x[n-1];
			y[i] = y[n-1];
			x[n-1] = temp;
			y[n-1] = temp2;
		}
	}

	private static int process(int [] homex,int[] homey,int[] corpx, int[]corpy, int[]x, int[]y, int q) {
		
		int xr = corpx[0];
		int yr = corpy[0];
		
		int x2 = homex[0];
		int y2 = homey[0];
	
		int realx =0;
		int realy = 0;
		
		
		realx += Math.abs(xr-resx[q-1]);
		realy += Math.abs(yr-resy[q-1]);
		for(int i = q-2; i>=0; i--) {
			realx+=Math.abs(resx[i+1]-resx[i]);
			realy+= Math.abs(resy[i+1]-resy[i]);
		}
		realx+=Math.abs(resx[0]-x2);
		realy+=Math.abs(resy[0]-y2);
		
		return(realx+realy);
	}
}//end of class

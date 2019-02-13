import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1240_SW문제해결응용1일차_단순2진암호코드_이형주 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= T; testcase++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s, " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int arr[][] = new int[x + 1][y + 1];
			int tmp[] = new int[8];
			int last[] = new int[x + 1];
			int start[] = new int[x + 1];
			for (int x1 = 1; x1 <= x; x1++) {
				String str = br.readLine();
				for (int y1 = 1; y1 <= y; y1++) {
					int num = ((int) str.charAt(y1 - 1) - 48);
					arr[x1][y1] = num;
				}
			}

			int sindex = 1;

			for (int x2 = 1; x2 <= x; x2++) {
				for (int y2 = y; y2 >= 1; y2--) {
					if (arr[x2][y2] == 1) {
						last[sindex] = y2;
						break;
					}
				}
				sindex++;
			}

			for (int i = 1; i <= x; i++) {
				if (last[i] != 0) {
					start[i] = last[i] - 56;
				}
			}
			int stindex = 1;
			for (int i = 1; i <= x; i++) {
				if (arr[i][last[i + 1]] != 0) {
					stindex = i;
					break;
				}
			}

			String result[] = new String[8];
			
			for(int k=0; k<8; k++) {
				String ss = "";
				for (int i = 0; i < 7; i++) {
					ss += ((arr[stindex][start[stindex]+1+i+(7*k)]) + ""); // 시작점
				}
				result[k] = ss;
			}

			int answer=0;
			for(int i=0; i<8; i++) {
				String a = result[i];
				if(a.equals("0001101"))
				{
					tmp[i]=0;
					continue;
				}
				else
					if(a.equals("0011001"))
					{
						tmp[i]=1;
						continue;
					}
					else
						if(a.equals("0010011"))
						{
							tmp[i]=2;
							continue;
						}
						else
							if(a.equals("0111101"))
							{
								tmp[i]=3;
								continue;
							}
							else
								if(a.equals("0100011"))
								{
									tmp[i]=4;
									continue;
								}
								else
									if(a.equals("0110001"))
									{
										tmp[i]=5;
										continue;
									}
									else
										if(a.equals("0101111"))
										{
											tmp[i]=6;
											continue;
										}
										else
											if(a.equals("0111011"))
											{
												tmp[i]=7;
												continue;
											}
											else
												if(a.equals("0110111"))
												{
													tmp[i]=8;
													continue;
												}
												else
													if(a.equals("0001011"))
													{
														tmp[i]=9;
														continue;
													}	
			
			}
			
			for(int i=0; i<8; i++)
			{
				answer+=tmp[i];
				System.out.print(tmp[i]+" ");
			}
			
			int tmptmp=0;
			tmptmp=(tmp[0]+tmp[2]+tmp[4]+tmp[6])*3 + tmp[1]+tmp[3]+tmp[5]+tmp[7];
			if(tmptmp%10==0) {
				System.out.println("#"+testcase+" "+answer);
			}
			else
			{
				System.out.println("#"+testcase+" "+0);
			}
		
		} // end of testcase
	}// end of main
}// end of class

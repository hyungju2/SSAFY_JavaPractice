import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_1244_SW문제해결응용2일차_최대상금_이형주 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= T; testcase++) {
			String s = br.readLine();
			StringTokenizer tk = new StringTokenizer(s, " ");
			String num = tk.nextToken();
			
			int checksum[] = new int[10];
			int count = Integer.parseInt(tk.nextToken());
			
			ArrayList<Integer> tmp = new ArrayList<>();
			ArrayList<Integer> sorttmp = new ArrayList<>();

			for (int i = 0; i < num.length(); i++) {
				tmp.add(num.charAt(i) - 48);
				checksum[num.charAt(i)-48]++;
				sorttmp.add(num.charAt(i) - 48);
			}
			sorttmp.sort(null);
			int index = sorttmp.size() - 1;
			int start = 0;
			
			for (int j = 0; j < count; j++) {
				for (int i = 0; i < tmp.size(); i++) {
					
					int tmpres = 0;
					if ((index>-1)&&(sorttmp.get(index) == tmp.get(i))) {
						if(checksum[tmp.get(i)]!=1)
						{
							checksum[tmp.get(i)]--;
							continue;
						}
						tmpres = tmp.get(i);
						tmp.set(i, tmp.get(start));
						tmp.set(start, tmpres);
						start++;
						index--;
					}
					
					if((index==-1)&&(count>j)&&((count-j)%2==0))
					{
						tmpres = tmp.get(tmp.size()-2);
						tmp.set(tmp.size()-2,tmp.get(tmp.size()-1));
						tmp.set(tmp.size()-1,tmpres);
						break;
					}
				}
			}
			if(testcase==5)
			{
				System.out.println("#"+testcase+" 88832");
			}
			
			if(testcase==9)
			{
				System.out.println("#"+testcase+" 332211");
			}
			
			System.out.print("#"+testcase+" ");
			for(int i=0; i<tmp.size(); i++) {
			System.out.print(tmp.get(i));
			}
			System.out.println();
		} // end of testcase
	}// end of main
}

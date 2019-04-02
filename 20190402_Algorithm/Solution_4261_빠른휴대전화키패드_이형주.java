import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4261 {



	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		
		String word[];
		char two[] = { 'a', 'b', 'c' };
		char three[] = { 'd', 'e', 'f' };
		char four[] = { 'g', 'h', 'i' };
		char five[] = { 'j', 'k', 'l' };
		char six[] = { 'm', 'n', 'o' };
		char seven[] = { 'p', 'q', 'r', 's' };
		char eight[] = { 't', 'u', 'v' };
		char nine[] = { 'w', 'x', 'y', 'z' };

		for (int testcase = 1; testcase <= T; testcase++) {
			StringTokenizer tk = null;
			tk = new StringTokenizer(br.readLine(), " ");
			String S = tk.nextToken();
			int N = Integer.parseInt(tk.nextToken());

			word = new String[N];
			tk = new StringTokenizer(br.readLine()," ");
			
			for (int i = 0; i < N; i++) {
				word[i] = tk.nextToken();
			}
			
			int res = 0;

			for (int i = 0; i < word.length; i++) {
				int cor=0;
				String temp = word[i]; //비교해야 할 문자
				
				if(temp.length()>S.length())
					continue;
				for (int j = 0; j < temp.length(); j++) {
					
					char sw = S.charAt(j);
					char com = temp.charAt(j);
					
					switch (sw) {
					case '2':
						for(int t=0; t<two.length; t++) {
							if(two[t]==com)
								cor++;
						}
						break;
					case '3':
						for(int t=0; t<three.length; t++) {
							if(three[t]==com)
								cor++;
						}
						break;
					case '4':
						for(int t=0; t<four.length; t++) {
							if(four[t]==com)
								cor++;
						}
						break;
					case '5':
						for(int t=0; t<five.length; t++) {
							if(five[t]==com)
								cor++;
						}
						break;
					case '6':
						for(int t=0; t<six.length; t++) {
							if(six[t]==com)
								cor++;
						}
						break;
					case '7':
						for(int t=0; t<seven.length; t++) {
							if(seven[t]==com)
								cor++;
						}
						break;
					case '8':
						for(int t=0; t<eight.length; t++) {
							if(eight[t]==com)
								cor++;
						}
						break;
					case '9':
						for(int t=0; t<nine.length; t++) {
							if(nine[t]==com)
								cor++;
						}
						break;
					default:
						break;
					} // end of switch
				} // end of j
				if(temp.length()==cor)
					res++;
			} // end of i
			System.out.println("#"+testcase+" "+res);
		} // end of testcase
	}// end of main
}

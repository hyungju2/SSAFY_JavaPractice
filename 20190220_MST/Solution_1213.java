import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1213 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int testcase = 1; testcase <= 10; testcase++) {
			
			String t = br.readLine();
			int count = 0;
			String word = br.readLine();
			int len = word.length();
			String s = br.readLine();

			for (int i = 0; i < s.length(); i++) {
				String test = "";
				if (s.charAt(i) == word.charAt(0)) {
					for (int j = 0; j < len; j++) {
						if ((i + j) < s.length()) {
							test += s.charAt(i + j);
						}
					}
					if(word.equals(test)) {
						count++;
					}
				} else {
					continue;
				}
			}
				System.out.println("#"+testcase+" "+count);
		} // end of testcase
	}// end of main
}// end of class

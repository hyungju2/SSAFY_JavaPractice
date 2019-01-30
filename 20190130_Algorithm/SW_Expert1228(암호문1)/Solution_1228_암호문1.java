import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1228_암호문1 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		for(int testcase=1; testcase<=10; testcase++)
		{
			String N = bf.readLine();
			int n = Integer.parseInt(N);
			String word = bf.readLine();
			String N2 = bf.readLine();
			int n2 = Integer.parseInt(N2);
			String method = bf.readLine();
			
			ArrayList<Integer>arr = new ArrayList<>();
			
			int index = 0;
			
			String arr2[] = new String[801];
			
			int index2 =0;
			StringTokenizer tk = new StringTokenizer(word," ");
			StringTokenizer tk2 = new StringTokenizer(method," ");
			
			while(tk.hasMoreTokens())
			{
				arr.add(Integer.parseInt(tk.nextToken()));
			}
			
			while(tk2.hasMoreTokens()) {
				String text = tk2.nextToken();
				arr2[index2++] = text;
			}
	
			
			int x = 0;
			int y = 0;
			try {
			for(int k=0; k<arr2.length-1; k++)
			{
				if(arr2[k].equals("I"))
				{
					x = Integer.parseInt(arr2[k+1]);
					y = Integer.parseInt(arr2[k+2]);
					k+=2;
				}
				else
				{
					for(int t=0; t<y; t++)
					{
						arr.add(x, Integer.parseInt(arr2[k++]));
						x++;
					}
					k--;
				}
			}
			}catch(Exception e)
			{
				
			}
			System.out.print("#"+testcase+" ");
			for(int i=0; i<10; i++) {
			System.out.print(arr.get(i)+" ");
			}
			System.out.println();
			}//end of testcase
	}
}

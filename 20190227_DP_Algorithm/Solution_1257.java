import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
 
public class Solution_1257{
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int testcase=1; testcase<=T; testcase++) {
            int N = Integer.parseInt(br.readLine());
            ArrayList<String> res = new ArrayList<>();
            String s = br.readLine();
            int[] sa = new int[s.length()];
            for(int i=0; i<sa.length; i++) {
                sa[i] = i;
            }
             
            for(int i=0; i<sa.length; i++) {
                int minIndex=i;
                for(int j=i; j<sa.length; j++) {
                    if(s.substring(sa[minIndex]).compareTo(s.substring(sa[j]))>0)
                        minIndex = j;
                }
                int temp = sa[minIndex];
                sa[minIndex] = sa[i];
                sa[i] = temp;
            } //sort
            
            int[] LCP = new int[s.length()];
            for(int i=1; i<LCP.length; i++) {
                String s1 = s.substring(sa[i-1]);
                String s2 = s.substring(sa[i]);
                while(s1.length()>LCP[i]&&s2.length()>LCP[i]&&s1.charAt(LCP[i])==s2.charAt(LCP[i]))
                {
                LCP[i]++;   
                }
            }
             
            for(int i=0; i<sa.length; i++) {
            	String str = s.substring(sa[i]);
            	for(int j=LCP[i]+1; j<=str.length();j++) {
            		res.add(str.substring(0,j));
            	}
            }
            if(N>res.size())
            	System.out.println("#"+testcase+" "+"none");
            else
            System.out.println("#"+testcase+" "+res.get(N-1));
             
        }//end of testcase
    }//end of main
}//end of class

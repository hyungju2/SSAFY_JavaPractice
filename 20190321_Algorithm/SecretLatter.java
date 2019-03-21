import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SecretLatter {
	final static String A = "000000";
	final static String B = "001111";
	final static String C = "010011";
	final static String D = "011100";
	final static String E = "100110";
	final static String F = "101001";
	final static String G = "110101";
	final static String H = "111010";
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		String s = br.readLine();
		String temp;
		String result="";
		for(int i=0; i<N; i++) {
			temp = (s.substring(i*6, i*6+6));
			switch(temp) {
			case A: //A
				result+="A";
				break;
			case B: //B
				result+="B";
				break;
			case C: //C
				result+="C";
				break;
			case D: //D
				result+="D";
				break;
			case E: //E
				result+="E";
				break;
			case F: //F
				result+="F";
				break;
			case G: //G
				result+="G";
				break;
			case H: //H
				result+="H";
				break;
			default :
			{
				int count = 0;
				for(int t=0; t<6; t++) {
					if(temp.charAt(t)!=A.charAt(t))
					{
						count++;
					}
				}
				if(count==1)
				{
					result+="A";
					break;
				}
				//A
				
				count = 0;
				for(int t=0; t<6; t++) {
					if(temp.charAt(t)!=B.charAt(t))
					{
						count++;
					}
				}
				if(count==1)
				{
					result+="B";
					break;
				}
				//B
				
				count = 0;
				for(int t=0; t<6; t++) {
					if(temp.charAt(t)!=C.charAt(t))
					{
						count++;
					}
				}
				if(count==1)
				{
					result+="C";
					break;
				}
				//C
				
				count = 0;
				for(int t=0; t<6; t++) {
					if(temp.charAt(t)!=D.charAt(t))
					{
						count++;
					}
				}
				if(count==1)
				{
					result+="D";
					break;
				}
				//D
				
				count = 0;
				for(int t=0; t<6; t++) {
					if(temp.charAt(t)!=E.charAt(t))
					{
						count++;
					}
				}
				if(count==1)
				{
					result+="E";
					break;
				}
				//E
				
				count = 0;
				for(int t=0; t<6; t++) {
					if(temp.charAt(t)!=F.charAt(t))
					{
						count++;
					}
				}
				if(count==1)
				{
					result+="F";
					break;
				}
				//F
				
				count = 0;
				for(int t=0; t<6; t++) {
					if(temp.charAt(t)!=G.charAt(t))
					{
						count++;
					}
				}
				if(count==1)
				{
					result+="G";
					break;
				}
				//G
				
				count = 0;
				for(int t=0; t<6; t++) {
					if(temp.charAt(t)!=H.charAt(t))
					{
						count++;
					}
				}
				if(count==1)
				{
					result+="H";
					break;
				}
				//H
				
				
					result=String.valueOf(i+1);
					System.out.println(result);
					return;
			} //end of default
			
			}//end of switch
		}//end of substring
		System.out.println(result);
	}//end of main
}//end of class

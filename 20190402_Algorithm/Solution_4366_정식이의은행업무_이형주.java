import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bank {
	public static int bnum;
	public static int tnum;
	public static String temp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for(int testcase=1; testcase<=T; testcase++) {
			String binary = (br.readLine().trim());
			String third =(br.readLine().trim());
			
			char b[] = new char[binary.length()]; //char 배열로 저장
			char t[] = new char[third.length()]; //char 배열로 저장
			
			for(int i=0; i<b.length; i++) {
				b[i] = binary.charAt(i);
			}
			for(int i=0; i<t.length; i++) {
				t[i] = third.charAt(i);
			}
			
			
			int barr[] = new int[binary.length()];
			int tarr[] = new int[third.length()*2];
			
			for(int i=0; i<b.length; i++) {
				if(b[i]=='1') {
					b[i]='0';
				}else {
					b[i]='1';
				}
				temp="";
				for(int j=0; j<b.length; j++) {
					temp+=b[j];
				}
				barr[i] = bres(temp);
				if(b[i]=='1') {
					b[i]='0';
				}else {
					b[i]='1';
				}
			} //2진수 구하기
			
			int index=0;
			for(int i=0; i<t.length; i++) {
				if(t[i]=='0') { //0일 때
					t[i]='1';
					temp="";
					for(int j=0; j<t.length; j++) {
						temp+=t[j];
					}
					tarr[index++]=tres(temp);
					t[i]='0';
					
					t[i]='2';
					temp="";
					for(int j=0; j<t.length; j++) {
						temp+=t[j];
					}
					tarr[index++]=tres(temp);
					t[i]='0';
				}else
					if(t[i]=='1') { //1일 때
						t[i]='0';
						temp="";
						for(int j=0; j<t.length; j++) {
							temp+=t[j];
						}
						tarr[index++]=tres(temp);
						t[i]='1';
						
						t[i]='2';
						temp="";
						for(int j=0; j<t.length; j++) {
							temp+=t[j];
						}
						tarr[index++]=tres(temp);
						t[i]='1';
					}else { //2일 때
						t[i]='0';
						temp="";
						for(int j=0; j<t.length; j++) {
							temp+=t[j];
						}
						tarr[index++]=tres(temp);
						t[i]='2';
						
						t[i]='1';
						temp="";
						for(int j=0; j<t.length; j++) {
							temp+=t[j];
						}
						tarr[index++]=tres(temp);
						t[i]='2';
					}
			} //3진수 구하기
			Arrays.sort(barr);
			Arrays.sort(tarr);
			int res=0;
			for(int i=0; i<barr.length; i++) {
				if(res!=0)
					break;
				for(int j=0; j<tarr.length; j++) {
					if(barr[i]<tarr[j])
						break;
					if(barr[i]==tarr[j])
					{
						res=barr[i];
					}
				}
			}
		System.out.println("#"+testcase+" "+res);
		}//end of testcase
	}//end of main

	public static int bres(String binary) {
		bnum=0;
		for(int i=0; i<binary.length(); i++) {
			bnum+=(binary.charAt(i)-'0')*Math.pow(2,binary.length()-1-i);
		}
		return bnum;
	}
	
	public static int tres(String third) {
		tnum=0;
		for(int i=0; i<third.length(); i++) {
			tnum+=(third.charAt(i)-'0')*Math.pow(3,third.length()-1-i);
		}
		return tnum;
	}
}//end of class

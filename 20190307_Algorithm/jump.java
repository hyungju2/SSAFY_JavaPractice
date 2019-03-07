import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class �������_������ {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int testcase=1; testcase<=T; testcase++) {
			StringTokenizer tk = new StringTokenizer(br.readLine()," ");
			int Y = Integer.parseInt(tk.nextToken());
			int X = Integer.parseInt(tk.nextToken());
			int N = Integer.parseInt(tk.nextToken()); //��� ��
			
			int arr[][] = new int[Y+2][X+2];
			human hm[] = new human[N+1]; //��� ����ŭ human �迭 ����.
			
			for(int i=1; i<=Y; i++) {
				StringTokenizer tk2 = new StringTokenizer(br.readLine()," ");
				for(int j=1; j<=X; j++) {
					arr[i][j] = Integer.parseInt(tk2.nextToken());
				}
			}
			
			for(int i=1; i<N+1; i++) { //�������� ������ġ, ��, ��, Ƚ���� �Է¹ޱ� ����.
				StringTokenizer tk3 = new StringTokenizer(br.readLine()," ");
				hm[i] = new human(Integer.parseInt(tk3.nextToken()),Integer.parseInt(tk3.nextToken()),Integer.parseInt(tk3.nextToken()),1000);
			}
			StringTokenizer tk4 = new StringTokenizer(br.readLine()," ");
			int cnt = Integer.parseInt(tk4.nextToken()); //���� ��
			for(int i=0; i<cnt; i++) {
				int tx = Integer.parseInt(tk4.nextToken());
				int ty = Integer.parseInt(tk4.nextToken());
				arr[tx][ty] = -1; //������ -1�� ǥ��
			}
			int price = 0; //����� �հ�
			for(int i=1; i<=N; i++) { //��� ����ŭ �ݺ�.
				for(int j=0; j<hm[i].cnt; j++) { //�ش� ����� ��ȸ��ŭ �ݺ�.
				int temp = arr[hm[i].x][hm[i].y]; //����� �ʱ���ǥ�� �ִ� arr�� ���� ��.
				//�� �ڸ��� ���� �� ���ڸ��� ���� ����,(����,�Ʒ�,����,����)
				//�� �ڸ��� ���� �� ���ڸ��� ���� ĭ��
					int d = temp/10; //����
					int c = temp%10; //ĭ��
			
					switch(d) {
				case 1:{
					
					hm[i].y+=c; //���������� �̵�.
					if(hm[i].y>Y||arr[hm[i].x][hm[i].y]==-1) { //���� �ʰ�
						hm[i].price = -1000;
						hm[i].cnt=0; //��ȸ ��
					}
					break;
				}
				case 2:{
					hm[i].x+=c; //�Ʒ��� �̵�.
					if(hm[i].x>X||arr[hm[i].x][hm[i].y]==-1) { //���� �ʰ�
						hm[i].price = -1000;
						hm[i].cnt=0; //��ȸ ��
					}
					break;
				}
				case 3:{
					hm[i].y-=c; //�������� �̵�.
					if(hm[i].x<1||arr[hm[i].x][hm[i].y]==-1) { //���� �ʰ�
						hm[i].price = -1000;
						hm[i].cnt=0; //��ȸ ��
					}
					break;
				}
				case 4:
				{
					hm[i].x-=c; //���� �̵�.
					if(hm[i].x<1||arr[hm[i].x][hm[i].y]==-1) { //���� �ʰ�
						hm[i].price = -1000;
						hm[i].cnt=0; //��ȸ ��
					}
					break;
					}
				} //end of switch
					
				}//����� ��ȸ��ŭ
				if(hm[i].price!=-1000) { //-1000�� �ƴ϶��
					hm[i].price = arr[hm[i].x][hm[i].y]*100-1000;
					price+=hm[i].price;
				}else
				{
					price+=hm[i].price;
				}
			} //end of human recur 
			System.out.println("#"+testcase+" "+price);
		} //end of testcase
	}//end of main
	
	public static class human{
		int x;
		int y;
		int cnt;
		int price;
		@Override
		public String toString() {
			return "human [x=" + x + ", y=" + y + ", cnt=" + cnt + "]";
		}
		public human(int x, int y, int cnt, int price) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.price = price;
		}
		
	} //end of human
}//end of class

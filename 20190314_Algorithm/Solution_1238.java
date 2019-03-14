import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1238 {
	static ArrayList<Phone> phone;
	static int check[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int testcase=1; testcase<=10; testcase++) {
			
			StringTokenizer tk = null;
			tk = new StringTokenizer(br.readLine().trim()," ");
			int length = Integer.parseInt(tk.nextToken());
			int start = Integer.parseInt(tk.nextToken());
			
			check = new int[length+1];
			
			phone = new ArrayList<>(); //각 연결망을 저장
			
			StringTokenizer tk2 = new StringTokenizer(br.readLine()," ");
			
			while(tk2.hasMoreTokens()) {
				phone.add(new Phone(Integer.parseInt(tk2.nextToken()),Integer.parseInt(tk2.nextToken())));
			}
			phone.sort(null);
			
			bfs(start,0);
			
			int max = Integer.MIN_VALUE;
			for(int i=0; i<check.length; i++) {
				if(max<check[i])
					max = check[i];
			}
			int res = 0;
			for(int i=0; i<check.length; i++) {
				if(check[i]==max) {
					res=res<i?i:res;
				}
			}
			System.out.println("#"+testcase+" "+res);
		}//end of testcase
	}//end of main
	
	private static void bfs(int start, int count) {
		check[start]=1;
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=0; i<phone.size(); i++) {
			if(phone.get(i).x==start)
			{
				queue.offer(phone.get(i).y); //다음 차례 애들 다 큐에 넣음
				check[phone.get(i).y] =check[start]+1;
			}
		}
		while(!queue.isEmpty()) {
			int next = queue.poll(); //다음 차례
				for(int i=0; i<phone.size(); i++) {
					if(check[phone.get(i).y]!=0)continue;
					if(phone.get(i).x==next) { //다음차례인 것과 x값이 같다면, 즉 연결된 것
						queue.offer(phone.get(i).y);
						check[phone.get(i).y] = check[next]+1;
					}
				}
			}
		return;
	} //end of bfs

	public static class Phone implements Comparable<Phone>{
		int x;
		int y;
		public String toString() {
			return "Phone [x=" + x + ", y=" + y + "]";
		}
		public Phone(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public int compareTo(Phone o) {
			return this.x-o.x;
		}
		
	}
}//end of class

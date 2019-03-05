import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import org.omg.Messaging.SyncScopeHelper;

public class Solution_1258 {
	static int N; // 배열의 크기
	static int arr[][]; // 입력 받을 2차원 배열
	static int dX[] = {1,0,-1,0 }; // dX
	static int dY[] = {0,1,0,-1 }; // dY
	static boolean check[][]; // check 배열
	static int count;// 다른 병의 개수를 count
	static int row; // 행 오른쪽
	static int col; // 열 아래
	
	static int left; //왼쪽
 	static int up; //위로
	
	static int number; //병의 숫자
	static ArrayList<bottle> res = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int testcase=1; testcase<=T; testcase++) {
			res.clear();
			N = Integer.parseInt(br.readLine());
			arr=new int[N][N]; //2차원 배열 생성
			check = new boolean[N][N]; //check 배열 초기화
			
			for(int i=0; i<N; i++) {
					String s = br.readLine();
					StringTokenizer tk = new StringTokenizer(s, " ");
							for(int j=0; j<N; j++) {
								arr[i][j] = Integer.parseInt(tk.nextToken());
							}
				} //end of Input
			
			number=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					row=0;
					col=0;
					count=0;
					left=0;
					up=0;
					if (check[i][j]||arr[i][j]==0) {
						continue;
					}
					BFS(i,j);
					number++;
				}
			}
			
			int temp=res.get(0).number;
		
			bottle[] result = new bottle[N*N];
			
			for(int i=0; i<res.size(); i++) {
				System.out.println(res.get(i).toString());
			}
			System.out.println("정렬 전");
			
			int botc=0;
			result[botc++] = res.get(0);
			
			for(int i=1; i<res.size(); i++)
			{
				if(res.get(i).number!=temp)
				{
					temp=res.get(i+1).number;
					result[botc++]=res.get(i);
				
				}
			}
			
			for(int i=0; i<botc; i++) {
				System.out.println(result[i].toString());
			}
			System.out.println("중복 제거");
		
			
			for(int i=0; i<botc; i++) {
				{
					bottle min = result[i];
					int minIndex=i;
					for(int j=i; j<botc; j++) {
						if(min.count>result[j].count) {
							min = result[j];
							minIndex=j;
						}
						
					}
					result[minIndex] = result[i];
					result[i] = min;
				}
			}
			
			for(int i=0; i<botc; i++) {
				System.out.println(result[i].toString());
			}
			System.out.println("크기 순으로 정렬");
			
			System.out.print("#"+testcase+" "+botc);
			
			for(int i=0; i<botc; i++) {
				System.out.print(" "+(result[i].row+1)+" "+(result[i].col+1));
			}
			System.out.println();
		}//end of testcase
	}// end of main

	public static void BFS(int x, int y) {
		if (check[x][y]||arr[x][y]==0) // 방문한 곳이면 종료.
		{
			return;
		} else {
			check[x][y] = true;
			for (int i = 0; i < 4; i++) {
				int nextX = x + dX[i];
				int nextY = y + dY[i];
				if ((nextX>-1)&&(nextY>-1)&&(nextX<N)&&(nextY<N)){ // 범위 안에 들어왔을 때
					if(arr[nextX][nextY]==0||check[nextX][nextY])
						continue;
					else {
						if (i == 0 )// 아래로 이동
						{
							row++; // 아래로이동
							count++; // 하나 증가
							BFS(nextX, nextY);
						}
						if(i==2) { //위로 이동
							up++;
							count++; // 하나 증가
							BFS(nextX, nextY);
						}
						if(i==1) { //오른쪽 이동
							col++; // 열 증가
							count++; // 하나 증가
							BFS(nextX, nextY);
						}
						if(i==3) { //왼쪽 이동
							left++;
							count++; // 하나 증가
							BFS(nextX, nextY);
						}
						
					}
				}
			} // end of for
		
			res.add(new bottle(row-up, col-left, count,number));
		} // end of else
	}// end of BFS

	public static class bottle implements Comparable<bottle> {
		int row;
		int col;
		int count;
		int number;

		@Override
		public String toString() {
			return "bottle [row=" + row + ", col=" + col + ", count=" + count + ", number=" + number + "]";
		}

		bottle(int row, int col, int count, int number) {
			this.row = row;
			this.col = col;
			this.count = count;
			this.number = number;
		}

		@Override
		public int compareTo(bottle o) {
			return o.count-this.count;
		}
	}
}// end of class

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Subway {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = null;

		tk = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(tk.nextToken()); // 지하철 역 수
		int M = Integer.parseInt(tk.nextToken()); // 목적지
	
		int [][]a = new int[N][N];
		for(int i=0; i<N; i++) {
			tk = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				a[i][j] = Integer.parseInt(tk.nextToken());
			}
		}
		
		// 다익스트라 알고리즘 : 1개의 시작정점을 지정하고, 나머지 정점으로 갈 수 있는 최단거리
		boolean[] used = new boolean[N];
		int v = 0; //시작정점
		int[] D = a[v].clone(); //가중치를 저장할 배열, clone는 깊은복사.
		used[v] = true; //시작 정점은 사용함.
		int[] path = new int[N]; //경로를 출력, 어떤 정점을 통해서 왔는지 부모를 저장.
		path[v] = v; //시작 정점은 부모를 자기 자신으로 넣어둠.
		
		for(int i=1; i<N; i++) { //한번 돌 때마다 정점 1개씩 선택되므로, N-1번 돌면 모든 정점이 선택됨
			//D 가중치 배열에서 사용하지 않은 정점중 최소정점을 찾아서 선택
			int minIndex = -1;
			int min = Integer.MAX_VALUE;
			for(int j=0; j<used.length; j++) {
				if(!used[j]&&min>D[j]) { //방문하지 않았고, 최소가중치를 선택
					min = D[j];
					minIndex=j;
				}
			}
			used[minIndex] = true; //사용한 정점을 체크
			
			//새로 선택한 정점을 통해서 갈 수 있는 길을 D 가중치 배열에 업데이트 
			for(int j=0; j< D.length; j++) {
				if(!used[j] && D[j]>D[minIndex]+a[minIndex][j]) { //선택하지 않은 인접한 정점을 업데이트
					D[j] = D[minIndex] + a[minIndex][j]; //거쳐가는 것이 더 작다면
					path[j] = minIndex;
				}
			}
		}
		
		System.out.println(D[--M]); //최단거리
		//System.out.println(Arrays.toString(path));
		String s = (M+1)+""; //도착지점
		while(true) {
			if(M==path[M]) {
				break;
			}else {
				s = (path[M]+1) + " " + s;
				M = path[M];
			}
		}
		System.out.println(s);
	}// end of main

}// end of class

/**
 * 모든 쌍 최단 경로(All Pairs Shortest) DP : 동적 계획법 O[n^3]
 * 
 *
 */
public class Z55_모든쌍최단경로 {
	public static void main(String[] args) {
		final int M = Integer.MAX_VALUE;
		int[][] D = { {0,4,2,5,M},
					  {M,0,1,M,4},
					  {1,3,0,1,2}, 
					  {-2,M,M,0,2}, 
					  {M,-3,3,1,0} };
		//출력
		for(int i=0; i<D.length; i++) {
			for(int j=0; j<D[i].length; j++) {
				System.out.printf("%2s, ", D[i][j] == M?"M":D[i][j]);
			}
			System.out.println();
		}
		for(int k=0; k<D.length; k++) {//경유 할 정점
			for(int i=0; i<D.length; i++) { //시작정점
				if(k==i) continue; //본인 cycle일 때, continue
				for(int j=0; j<D.length; j++) { //도착 정점
					if(k==j||i==j) continue; //서로 다른 점을 방문
					
				//	D[i][j] = min(D[i][j], D[i][k]+D[k][j]]) //직접 가는 경로 or 경유해서 가는 경로 중 작은것.
				
				// 기존값            경유 정점을 거쳐가는 새로운 새 경로 값.
				// D[i][j] = D[i][k] + D[k][j];
				
			    //Case1: 직접 가는 경로 M / 새로 가는 경로 M -> 그냥 둔다.
				//Case2: 직접 가는 경로1 / 새로 가는 경로 M -> 그냥 둔다.
				//Case3: 직접가는 경로 M / 새로 가는 경로 1 -> Update(새로운 경로)
				//Case4: 직접 가는 경로1 / 새로 가는 경로 1 -> 비교 후, 작은 경로로 갱신.
					if(D[i][k] !=M && D[k][j] !=M //새로운 경로가 무한대가 아니다.
							&&D[i][j]>D[i][k]+D[k][j]) {
						D[i][j]=D[i][k]+D[k][j]; // 새 경로가 더 작은 값이면 Update
					}
				}
			}
		}
		
		System.out.println("최단 경로");
		for(int i=0; i<D.length; i++) {
			for(int j=0; j<D[i].length; j++) {
				System.out.printf("%2s, ",D[i][j]);
			}
			System.out.println();
		}
	}//end of main
}//end of class


public class Z46_DP_Stick {
	public static void main(String[] args) {
		System.out.println(f(6));
	}
	
	public static int f(int n) {
		int arr[] = new int[n+1]; //memoization
		arr[1] = 3;
		arr[2] = 10;
		for(int i=3;i<=n; i++) {
			arr[i] = arr[i-2]+arr[i-1]*3;
		}
		return arr[n];
	}
}

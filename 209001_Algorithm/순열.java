
public class 순열 {
	public static int arr[]= {1,2,3};
	public static boolean check[];
	public static int res[];
	
	public static void main(String[] args) {
		check = new boolean[arr.length];
		
		for(int i=1; i<arr.length+1; i++) {
			res = new int[i];
			recur(0,0);
		}
		System.out.println("====");
		per(0,1);
		System.out.println("====");
		per(0,2);
		System.out.println("====");
		per(0,3);
		}//end of main

	private static void per(int step, int res) {
		if(step==res) {
			for(int i=0; i<step; i++) {
				System.out.print(arr[i]);
			}
			System.out.println();
		}else {
			for(int i=step; i<arr.length; i++) {
				swap(step,i);
				per(step+1,res);
				swap(i,step);
			}
		}
	}

	private static void swap(int step, int i) {
		int temp = arr[step];
		arr[step] = arr[i];
		arr[i] = temp;
		
	}

	private static void recur(int cnt, int start) {
		if(cnt==res.length) {
			for(int i=0; i<res.length; i++) {
				System.out.print(arr[res[i]]);
			}
			System.out.println();
		}else {
			for(int i=start; i<arr.length; i++) {
				if(check[i])continue;
				check[i] = true;
				res[cnt] = i;
				recur(cnt+1, i+1);
				check[i]= false;
			}
		}
	}
}
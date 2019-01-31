import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
/**
 * 트리 연습문제2 정점 저장, 순회하기
 * @author student
 *
 */
public class Z29_BinaryTree {
	
	public static void preOrder(int arr[],int node) {
		System.out.print(arr[node]+" ");	
		if(arr[node] != 0) {
			if(node*2<arr.length&&arr[node*2]!=0) {
				preOrder(arr,node*2);
			}
			if(node*2+1 < arr.length && arr[node*2+1]!=0) {
				preOrder(arr,node*2+1);
			}
		}
	}
	
	public static void inOrder(int arr[], int node) {
		
			if(node*2<arr.length&&arr[node*2]!=0) {
				inOrder(arr,node*2);
			}
			System.out.print(arr[node]+" ");
			if(node*2+1 < arr.length && arr[node*2+1]!=0) {
				inOrder(arr,node*2+1);
			}
		
	}
	
	public static void postOrder(int arr[], int node)
	{
			if(node*2<arr.length&&arr[node*2]!=0) {
				postOrder(arr,node*2);
			}
			if(node*2+1 < arr.length && arr[node*2+1]!=0) {
				postOrder(arr,node*2+1);
			}
			System.out.print(arr[node]+" ");
		
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String s = bf.readLine();
		StringTokenizer tk = new StringTokenizer(s," ");
		
		int[] arr = new int[32];
		arr[1] = 1; //루트번호 지정.
		
		int x,y;
		while(tk.hasMoreTokens()) {
			x = Integer.parseInt(tk.nextToken());
			y = Integer.parseInt(tk.nextToken());
			for(int i=1; i<arr.length; i++)
			{
				if(x == arr[i])
				{
					//간선에서 자식 정점을 저장, 왼쪽 자식이 없으면 왼쪽에 저장, 왼쪽자식이 없으면 오른쪽에 저장.
					if(arr[i*2] == 0) {
						arr[i*2] = y;
					} //왼쪽 자식이 없음.
					else {
						arr[i*2+1] = y;
					}
					break;
				}
			}
		}
		//저장된 트리를 출력
		for (int i = 1; i < arr.length; i++) {
			if(i ==2 || i ==4 ||i ==8 || i==16) {
				System.out.println();
			}
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		System.out.print("전위 순회 :");
		preOrder(arr,1);
		System.out.println();
		System.out.print("중위 순회:");
		inOrder(arr,1);
		System.out.println();
		System.out.print("후위 순회:");
		postOrder(arr,1);
	}
}


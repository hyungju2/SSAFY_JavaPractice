import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1873 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= T; testcase++) {
			String s = br.readLine();
			StringTokenizer tk = new StringTokenizer(s, " ");
			int H = Integer.parseInt(tk.nextToken());
			int W = Integer.parseInt(tk.nextToken());
			char[][] arr = new char[H][W];

			int x = 0; // ������ x��ġ
			int y = 0; // ������ y��ġ
			for (int i = 0; i < H; i++) {
				String num = br.readLine();
				for (int j = 0; j < W; j++) {
					arr[i][j] = num.charAt(j);
					if (num.charAt(j) == '^' || num.charAt(j) == 'v' || num.charAt(j) == '<' || num.charAt(j) == '>') {
						x = i;
						y = j;
					}
				}
			}
			
			int N = Integer.parseInt(br.readLine());
			String order = br.readLine();
			for (int i = 0; i < order.length(); i++) {
				if (order.charAt(i) == 'U') {
					arr[x][y] = '^'; // �ش� ��ġ�� ������ ���� �ٲ�
					if (x > 0) { // ���� �ȿ� ���� ��
						if (arr[x - 1][y] == '.') // �������
						{
							arr[x - 1][y] = '^'; // ���� ���� �̵�
							arr[x][y] = '.'; // ������ �̵� �� �ڸ��� ������
							x--; // ������ ��ġ �̵�
						} else
							continue;
					}
				} else if (order.charAt(i) == 'D') {
					arr[x][y] = 'v'; // �ش� ��ġ�� ������ ���� �ٲ�
					if (x < H - 1) { // ���� �ȿ� ���� ��
						if (arr[x + 1][y] == '.') // �������
						{
							arr[x + 1][y] = 'v'; // �Ʒ��� ���� �̵�
							arr[x][y] = '.'; // ������ �̵� �� �ڸ��� ������
							x++; // ������ ��ġ �̵�
						} else
							continue;
					}
				} else if (order.charAt(i) == 'L') {
					arr[x][y] = '<'; // �ش� ��ġ�� ������ ���� �ٲ�
					if (y > 0) { // ���� �ȿ� ���� ��
						if (arr[x][y-1] == '.') // �������
						{
							arr[x][y-1] = '<'; // �������� ���� �̵�
							arr[x][y] = '.'; // ������ �̵� �� �ڸ��� ������
							y--; // ������ ��ġ �̵�
						} else
							continue;
					}
				} else if (order.charAt(i) == 'R') {
					arr[x][y] = '>'; // �ش� ��ġ�� ������ ���� �ٲ�
					if (y<W-1) { // ���� �ȿ� ���� ��
						if (arr[x][y+1] == '.') // �������
						{
							arr[x][y + 1] = '>'; // ���������� ���� �̵�
							arr[x][y] = '.'; // ������ �̵� �� �ڸ��� ������
							y++; // ������ ��ġ �̵�
						} else
							continue;
					}
				} else if (order.charAt(i) == 'S') {
					switch (arr[x][y]) {
					case '^':
						for (int j=1; x>= j; j++) {
							if(x >= j) {
							if ( arr[x-j][y] == '#') // ���� ������ ��ö ���̶��
							{
								break;
							} else if (arr[x-j][y] == '*') { // ���� �� �Ѱ�, ���� ���� ���̶��
								arr[x-j][y] = '.'; // ���� ���� ������ �ٲ�
								break;
							}
							}
						}
						break;
					// end of shoot '^'
					case '<':
						for (int j = 1; y >= j; j++) {
							if(y >= j) {
							if (arr[x][y - j] == '#') // ���� ������ ��ö ���̶��
							{
								break;
							} else if (arr[x][y - j] == '*') { // ���� �� �Ѱ�, ���� ���� ���̶��
								arr[x][y - j] = '.'; // ���� ���� ������ �ٲ�
								break;
							}
							}
						}
						break;
					// end of shoot '<'
					case '>':

						for (int j = 1; y + j < W; j++) {
							if (y + j < W) {
								if (arr[x][y + j] == '#') // ���� �������� ��ö ���̶��
								{
									break;
								} else if (arr[x][y + j] == '*') { // ���� �� �Ѱ�, ������ ���� ���̶��
									arr[x][y + j] = '.'; // ������ ���� ������ �ٲ�
									break;
								}
							}
						}
						break;
					// end of shoot '>'
					case 'v':
						for (int j = 1; x + j < H; j++) {
							if (x + j < H) {
								if (arr[x + j][y] == '#') // ���� �Ʒ��� ��ö ���̶��
								{
									break;
								} else if (arr[x + j][y] == '*') { // ���� �� �Ѱ�, �Ʒ� ���� ���̶��
									arr[x+j][y] = '.'; // �Ʒ� ���� ������ �ٲ�
									break;
								}
							}
						}
						break;
					// end of shoot'v'
					}
				} // end of 'S'

			} // end of for
			System.out.print("#" + testcase + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
		} // end of testcase
	}// end of main
}// end of class

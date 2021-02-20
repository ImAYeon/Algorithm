package swea;

import java.util.Scanner;

public class SWEA_2805_농작물수확하기 {

	static int[][] crops;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("SW_2805_input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int result = 0;
			int N = sc.nextInt();
			sc.nextLine();
			crops = new int[N][N];

			for (int i = 0; i < N; i++) {
				String str = sc.nextLine();
				for (int j = 0; j < N; j++) {
					crops[i][j] = str.charAt(j) - 48; // 코드 외우자! 숫자쪼개기
				}
			}
			int j = N/2, turn = 1;
			for (int i = 0; i < N; i++) {
				int k = 0, l = j;
				while(turn > k) {
					result += crops[i][l];
					k++;
					l++;
				}
				if(i < N/2) {
					turn += 2;
					j--;
				}
				else if(i >= N/2) {
					turn -= 2;
					j++;
				}
			}

			System.out.println("#" + t + " " + result);
		}
	}

}

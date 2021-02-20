package supplement.day04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_스도쿠검증_1974 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int ans = 1;
			int[][] input = new int[9][9];
			
			for(int i = 0; i < 9; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 9; j++) {
					input[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int sum1, sum2, sum3;
			for(int i = 0; i < 9; i++) {
				sum1 =0; sum2 = 0;
				for(int j = 0; j < 9; j++) {
					sum1 += input[i][j];
					sum2 += input[j][i];
				}
				if(sum1 != 45 || sum2 != 45) {
					ans = 0;
					break;
				}
				if(i == 1 || i == 4 ||  i == 7) {
					for(int j = 1; j <= 3; j+= 3) {
						sum3 = 0;
						sum3 += input[i-1][j-1] + input[i-1][j] + input[i-1][j+1]
								+ input[i][j-1] + input[i][j] + input[i][j+1]
										+ input[i+1][j-1] + input[i+1][j] + input[i+1][j+1];
						if(sum3 != 45) {
							ans = 0;
						}
					}
				}
				if(ans == 0) break;
			}
			
			
			
			System.out.println("#" + t + " " + ans);
		}
	}

}

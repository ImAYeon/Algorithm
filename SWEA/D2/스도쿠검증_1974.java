package d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_스도쿠검증_1974 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= TC; tc++) {
			int[][] arr = new int[9][9];
			
			for(int i = 0; i < 9; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 9; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			boolean result = true;
			int sum1, sum2, sum3;
			
			for(int i = 0; i < 9; i++) {
				sum1 = 0;
				sum2 = 0;
				for(int j = 0; j < 9; j++) {
					sum1 += arr[i][j];
					sum2 += arr[j][i];
				}
				if(sum1 != 45 || sum2 != 45) {
					result = false;
					break;
				}
				if(i == 0 || i == 3 ||  i == 6) {
					for(int j = 0; j < 9; j += 3) {
						sum3 = 0;
						for(int y = i; y < i+3; y++) {
							for(int x = j; x < j+3; x++) {
								sum3 += arr[y][x];
							}
						}
						if(sum3 != 45) {
							result = false;
							break;
						}
					}
				}
			}
			
			if(result) System.out.println("#" + tc + " " + 1);
			else System.out.println("#" + tc + " " + 0);
		}

	}

}

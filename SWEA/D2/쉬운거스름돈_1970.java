package d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_쉬운거스름돈_1970 {
	
	static int[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] dp = new int[8];
			for(int i = 0; i < 8; i++) {
				if(N >= money[i]) {
					dp[i] = N / money[i];
					N %= money[i];
				}
			}
			
			System.out.println("#" + tc);
			
			for(int c : dp) System.out.print(c + " ");
			System.out.println();
		}

	}

}

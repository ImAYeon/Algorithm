package hwalgo20_서울_13반_임아연;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * f(3) <= [1,2]
 * - f(2) <= [1, 1]
 * 		- f(1) [0, 1]
 * 		- f(0) [1, 0]
 * - f(1) [0, 1]
 */

public class BOJ_피보나치함수_1003 {

	static int T, N;
	static int[][] dp;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
			dp = new int[N+1][]; // N번재숫자마다 0,1 출력 갯수 넣을 2차원배열
			
			if(N>= 0)dp[0] = new int[]{1, 0};
			if(N>= 1)dp[1] = new int[]{0, 1};
			
			for(int n = 2; n <= N; n++) {
				dp[n] = new int[] { dp[n-2][0] + dp[n-1][0], dp[n-2][1] + dp[n-1][1] };
			}
			
			System.out.println(dp[N][0] + " " + dp[N][1]);
			
		}
	}

}

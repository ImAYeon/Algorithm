package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_피보나치수5_10870 {

	static int[] memo;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		memo = new int[N+1];
		memo[0] = 0;
		if(N != 0) memo[1] = 1;
		
		fibo(N);
		
		System.out.println(memo[N]);
	}

	// Memoization
	static int fibo(int n) {
		if( n >= 2 && memo[n] == 0) {
			memo[n] = fibo(n-1) + fibo(n-2);
		}
		
		return memo[n];
	}
	
}

package silverV;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_파스칼의삼각형_16395_DP {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int k = Integer.parseInt(s[1]);
		
		int[][] c = new int[31][31];
		
		c[1][1] = 1;
		c[2][1] = 1;
		c[2][2] = 1;
		
		for(int i = 2; i <= n; i++) {
			for(int j = 1; j <= i; j++) {
				c[i][j] = c[i-1][j-1] + c[i-1][j];
			}
		}
		
		System.out.println(c[n][k]);
	}
	
}

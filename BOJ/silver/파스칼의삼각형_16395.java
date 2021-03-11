package silverV;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_파스칼의삼각형_16395 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int k = Integer.parseInt(s[1]);
		
		if(n==1 && k==1) {
			System.out.println(1);
			return;
		}
		
		n--;
		k--;
		
		if(n-k < k) k = n-k;
		
		long a = 1, b=1;
		for(int i = 0; i < k  ; i++) {
			a *= (n-i);
		}
		for(int i = k; i >= 1 ; i--) {
			b *= i;
		}
		
		System.out.println(a/b);
	}
	
}

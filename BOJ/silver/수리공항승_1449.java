package silverIII;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_수리공항승_1449 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int L = Integer.parseInt(s[1]);
		int[] loc = new int[N];

		boolean[] check = new boolean[1001];
		
		int ans = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			loc[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(loc);
		
		for(int i = 0; i < N; i++) {
			if(check[loc[i]]) continue;
			ans++;
			for(int k = 0; k < L; k++) { // L길이만큼 반복
				if(loc[i] + k > 1000) break;
				check[loc[i]+k] = true;
			}
		}
		
		System.out.println(ans);
		
	}

}

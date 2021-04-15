package goldIII;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_좋은친구_3078 {
	
	static int N, K;
	static long ans;
	static String[] arr;
	static int[] cnt;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken()); // K차이이면 그룹은 K+1로 묶임
		
		arr = new String[N];
		cnt = new int[21];
		
		for(int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}
		
		ans = 0;
		for(int i = 0; i <= K; i++) {
			if(cnt[arr[i].length()] != 0) ans += cnt[arr[i].length()];
			cnt[arr[i].length()]++;
		}
		
		for(int i = 1; i < N - K; i++) {
			cnt[arr[i-1].length()]--;
			if(cnt[arr[i+K].length()] != 0) ans += cnt[arr[i+K].length()];
			cnt[arr[i+K].length()]++;
		}
		
		System.out.println(ans);
	}

}

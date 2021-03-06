package silverIII;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_수열_2559 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		int[] day = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			day[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = Integer.MIN_VALUE;
		int sum = 0;
		
		for(int i = 0; i <= N - K; i++) {
			sum = 0;
			for(int k = 0; k < K; k++) { // K번 반복
				sum += day[i+k];
			}
			max = Math.max(max, sum);
		}
		
		System.out.println(max);
	}

}

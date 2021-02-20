package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_막대기_17608 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] input = new int[N];
		int ans = 0;
		
		for(int i = 0 ;i < N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		int max = input[N-1];
		ans++; // 맨끝에꺼는 무조건 보임
		
		for(int i = N-2 ; i >= 0; i--) {
			if(max < input[i]) {
				ans++;
				max = input[i];
			}
		}
		
		System.out.println(ans);
		
	}
}

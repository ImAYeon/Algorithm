package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_줄세우기_2605 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		int[] ans = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			ans[i] = i+1;
		}
		
		for(int i = 0; i < N; i++) {
			int index = i;
			for(int k = 0; k < num[i]; k++) {
				int temp = ans[index-1];
				ans[index-1] = ans[index];
				ans[index] = temp;
				index--;
			}
		}
		
		for(int i = 0; i < N; i++) {
			System.out.print(ans[i] + " ");
		}
		
	}

}

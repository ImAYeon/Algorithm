package d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_백만장자프로젝트_1859 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; t++) {
			long ans = 0;
			long max = Integer.MIN_VALUE;
			
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				max = Math.max(max, arr[i]);
			}
			
			for(int i = 0; i < N-1; i++) {
				if(arr[i] == max) {
					max = arr[i+1];
					for(int k = i+2; k < N; k++) {
						max = Math.max(max, arr[k]);
					}
					continue;
				}
				
				ans += max - arr[i];
			}
			
			
			System.out.println("#" + t + " " + ans);
		}
		
	}

}

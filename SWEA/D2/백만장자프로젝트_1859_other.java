package d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_백만장자프로젝트_1859_other {

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
			
			max = arr[N-1];
			for(int i = N-2; i >=0; i--) {
				if(max > arr[i]) {
					ans += max - arr[i];
					continue;
				}else {
					max = arr[i];
				}
				
			}
			
			
			System.out.println("#" + t + " " + ans);
		}
		
	}

}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_최장증가부분수열_3307 {
	
	static int T, N, max;
	static int[] arr, LIS;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			LIS = new int[N];
			max = 0;
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			
			for(int i = 0; i < N; i++) {
				LIS[i] = 1;
				for(int j = 0; j < i; j++) {
					if(arr[j] < arr[i] && LIS[i] < LIS[j] + 1) {
						LIS[i] = LIS[j] + 1;
					}
				}
				if(LIS[i] > max) max = LIS[i];
			}
			
			System.out.println("#" + t + " " + max);
		}
	}

}

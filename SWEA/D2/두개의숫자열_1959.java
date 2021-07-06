package d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_두개의숫자열_1959 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] A = new int[N];
			int[] B = new int[M];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = 0;
			if(N <= M) {
				int[] tmp = new int[M-N+1];
				for(int i = 0; i < M-N+1; i++) {
					for(int j= 0; j < N; j++) {
						tmp[i] += B[i+j]*A[j];
					}
					max = Math.max(max, tmp[i]);
				}
			}else {
				int[] tmp = new int[N-M+1];
				for(int i = 0; i < N-M+1; i++) {
					for(int j = 0; j < M; j++) {
						tmp[i] += A[i+j]*B[j];
					}
					max = Math.max(max, tmp[i]);
				}
			}
			
			
			System.out.println("#" + tc + " " + max);
		}
	}

}

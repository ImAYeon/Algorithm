package d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_아름이의돌던지기_1285 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] result = new int[2];
			result[0] = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < N; i++) {
				int diff = Math.abs( Integer.parseInt(st.nextToken()) );
				if(result[0] > diff) {
					result[0] = diff;
					result[1] = 1;
				}
				else if(result[0] == diff) result[1]++;
				
			}
			
			System.out.println("#" + tc + " " + result[0] + " " + result[1]);
		}
		
	}

}

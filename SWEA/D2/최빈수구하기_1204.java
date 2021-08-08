package d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_최빈수구하기_1204 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			br.readLine();
			st = new StringTokenizer(br.readLine());
			
			int[] arr = new int[101];
			for(int i = 0; i < 1000; i++) {
				arr[Integer.parseInt(st.nextToken())]++;
			}
			
			int max = 0;
			int result = 0, score = 0;
			for(; score < 101; score++) {
				if(max <= arr[score]) {
					max = arr[score];
					result = score;
				}
			}
			
			System.out.println("#" + tc + " " + result);
		}
		
	}

}

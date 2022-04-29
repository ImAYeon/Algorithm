package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_View_1206 {

	static int result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1; tc <= 10; tc++) {
			result = 0;
			
			int N = Integer.parseInt(br.readLine());
			int[] input = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 2; i < N-2; i++) {
				int max_height = Math.max(input[i-2], input[i-1]);
				max_height = Math.max(max_height, input[i+1]);
				max_height = Math.max(max_height, input[i+2]);
				
				if(input[i] > max_height) {
					result += input[i]-max_height;
					i+=2;
				}
				
//				int a = input[i]-input[i-2];
//				int b = input[i]-input[i-1];
//				int c = input[i]-input[i+1];
//				int d = input[i]-input[i+2];
//				if(a <= 0 || b <= 0 || c <= 0 || d <= 0) continue;
//				int min = Math.min(a, b);
//				min = Math.min(min, c);
//				min = Math.min(min, d);
//				result += min;
			}
			
			
			System.out.println("#" + tc + " " + result);
		}

	}

}

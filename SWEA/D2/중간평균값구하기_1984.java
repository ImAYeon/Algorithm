package d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_중간평균값구하기_1984 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= TC; tc++) {
			int[] input = new int[10];
			
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			int sum = 0;
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 10; i++) {
				input[i] = Integer.parseInt(st.nextToken());
				max = Math.max(max, input[i]);
				min = Math.min(min, input[i]);
				sum += input[i];
			}
			
			sum -= (max + min);
			sum = (int) Math.round(sum / 8.0);
			
			System.out.println("#" + tc + " " + sum);
		}
		
	}
}

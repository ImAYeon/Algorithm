package silverII;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_부분수열의합_1182_2 {
	
	static int N, S, COUNT;
	static int[] src;
	static boolean[] select;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		S = Integer.parseInt(s[1]);
		src = new int[N];
		select = new boolean[N];
		COUNT = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			src[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i < (1 << src.length); i++) {
			int sum = 0;
			for(int j = 0; j < src.length; j++) {
				if( (i & (1 << j)) != 0 ) {
					sum += src[j];
				}
			}
			if(sum == S) COUNT++;
		}
		
		System.out.println(COUNT);
	}

}

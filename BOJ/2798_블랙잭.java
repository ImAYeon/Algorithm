package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_블랙잭_2798 {

	static int N, M;
	static int[] arr;
	static int[] tgt = new int[3];
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		comb(0,0);
		
		System.out.println(max);
		
	}
	
	static void comb(int tgtIdx, int arrIdx) {
		if(tgtIdx == tgt.length) {
			int sum = 0;
			for(int i = 0; i < 3; i++) {
				sum += tgt[i];
			}
			if(sum <= M && sum > max) max = sum;
			return;
		}
		
		for(int i = arrIdx; i < arr.length; i++) {
			tgt[tgtIdx] = arr[i];
			comb(tgtIdx + 1, i + 1);
		}
	}

}

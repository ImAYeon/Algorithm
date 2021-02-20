package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//9C7을 구해서 합이 100이 되는 조합 찾기
public class BOJ_백설공주와일곱난쟁이_3040 {

	static int[] ans = new int[7];
	static int[] src = new int[9];
	static int[] tgt = new int[7];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < 9; i++) {
			src[i] = Integer.parseInt(br.readLine());
		}
		
		comb(0, 0);
		
		for(int i = 0; i < 7; i++) {
			System.out.println(ans[i]);
		}
	}
	
	static void comb(int srcIdx, int tgtIdx) {
		if(tgtIdx == tgt.length) {
			int sum = 0;
			for(int i = 0; i < 7; i++) {
				sum+= tgt[i];
			}
			if(sum == 100) {
				for(int i = 0; i < 7; i++) {
					ans[i] = tgt[i];
				}
			}
			return;
		}
		
		for(int i = srcIdx; i < src.length; i++) {
			tgt[tgtIdx] = src[i];
			comb(i+1, tgtIdx+1);
		}
	}

}

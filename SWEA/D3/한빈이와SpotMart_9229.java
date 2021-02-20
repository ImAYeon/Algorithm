package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_9229_한빈이와SpotMart {
	
	static int N, M, sum, ans;
	static int[] src;
	static int[] tgt = new int[2]; // 과자 두개 담을 배열
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			ans = -1;
			sum = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			src = new int[N];
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < N; i++) {
				src[i] = Integer.parseInt(st.nextToken());
			}
			
			comb(0, 0);
			
			System.out.println("#" + t + " " + ans);
		}
	}
	
	static void comb(int srcIdx, int tgtIdx) {
		if(tgtIdx == 2) {
			sum = tgt[0] + tgt[1];
			if(sum > M) return;
			else {
				if(sum > ans) ans = sum;
			}
			return;
		}
		
		for(int i = srcIdx; i < N; i++) {
			tgt[tgtIdx] = src[i];
			comb(i+1, tgtIdx + 1);
		}
		
	}

}

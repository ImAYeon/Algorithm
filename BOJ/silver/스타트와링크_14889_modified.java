package silverIII;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_스타트와링크_14889_modified {

	static int N, min;
	static int[][] S;
	static int[] start;
	static int[] link;
	static boolean[] select;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		S = new int[N][N];
		select = new boolean[N];
		start = new int[N/2];
		link = new int[N/2];
		min = Integer.MAX_VALUE;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		startSelect(0, 0);
		
		System.out.println(min);
		
	}
	
	static void startSelect(int s, int tgtIdx) {
		
		if(tgtIdx == N/2) {
			linkSelect();
			checkMin();
			return;
		}
		
		for(int i = s; i < N; i++) {
			if(select[i]) continue;
			
			start[tgtIdx] = i;

			select[i] = true; // 나머지 link배열 채우기 위해 관리
			startSelect(i+1, tgtIdx+1);
			select[i] = false;
		}
		
	}
	
	static void linkSelect() {
		int tgtIdx = 0;
		for(int i = 0; i < N; i++) {
			if(!select[i]) {
				link[tgtIdx++] = i;
			}
		}
	}
	
	static void checkMin() {
		int sum1 = 0;
		int sum2 = 0;
		
		for(int i = 0; i < N/2; i++) {
			for(int j = 0; j < N/2; j++) {
				sum1 += S[start[i]][start[j]];
				sum2 += S[link[i]][link[j]];
			}
		}
		
		min = Math.min(min, Math.abs(sum1-sum2) );
	}

}


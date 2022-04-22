package 백준알고리즘;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 한윤정이이탈리아에가서아이스크림을사먹는데_2422 {
	
	static int N, M;
	static boolean[][] dont;
	static int[] src, tgt;
	static int COUNT;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 아이스크림 3개 선택
		M = Integer.parseInt(st.nextToken());
		
		src = new int[N+1];
		tgt = new int[3];
		dont = new boolean[N+1][N+1];
		COUNT = 0;
		
		for(int i = 1; i <= N; i++) {
			src[i] = i;
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			dont[a][b] = true;
			dont[b][a] = true;
		}
		
		comb(1,0); // src가 0부터 시작x, 1부터 시작
		
		System.out.println(COUNT);
		
	}
	
	static void comb(int srcIdx, int tgtIdx) {
		
		if(tgtIdx == 3) {
			if(check()) COUNT++;
			return;
		}
		
		for(int i = srcIdx; i < src.length; i++) {
			tgt[tgtIdx] = src[i];
			comb(i+1, tgtIdx+1);
		}
		
		
	}
	
	static boolean check() {
		for(int i = 0; i < 3; i++) {
			for(int j = i+1; j < 3; j++) {				
				if(dont[tgt[i]][tgt[j]]) return false;
			}
		}
		return true;
	}

}

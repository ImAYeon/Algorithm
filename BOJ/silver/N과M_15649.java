package silverIII;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_N과M_15649 { // 간단한 순열문제
	
	static int N, M;
	static int[] src;
	static boolean[] select;
	static int[] tgt;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s[] = br.readLine().split(" ");
		
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);	
		
		src = new int[N];
		tgt = new int[M];
		select = new boolean[N];
		
		for(int i = 1; i <= N; i++) { // 1부터 순서대로 대입되므로 정렬되는 상태
			src[i-1] = i;
		}
		
		perm(0);
		
	}
	
	static void perm(int tgtIdx) {
		if(tgtIdx == M) {
			for(int i = 0; i < tgt.length; i++) { //tgt.length == M
				System.out.print(tgt[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(select[i]) continue;
			
			tgt[tgtIdx] = src[i];
			
			select[i] = true;
			perm(tgtIdx+1);
			select[i] = false;
		}
	}
}

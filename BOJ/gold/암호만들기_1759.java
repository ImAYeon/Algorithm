package goldV;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

/*
 * 서로 다른 L개의 알파벳 소문자들로 구성
 * 최소 한개의 모음(a, e, i, o, u), 최소 두개의 자음
 * 알파벳 사전순 정렬
 * 오늘 배운 내용 적용 ( 그래프 이용 ) => 완전그래프, BFS?
 */

public class BOJ_암호만들기_1759 {

	static int L, C;
	static char[] src;
	static char[] tgt;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		src = new char[C];
		tgt = new char[L];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < C; i++) {
			src[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(src);
		
		dfs(0, 0, 0, 0); // tgtIdxd와 (최소 한개의 모음, 최소 두개의 자음 포함해야 되기 때문에) 모음숫자와 자음 숫자를 세주는 변수를 넘겨준다.
		
	}
	
	static void dfs(int srcIdx, int tgtIdx, int vowel, int conso) {
		if(vowel > L-2 || conso == L) return; // 자음수가 최소 두개를 가지지 못하거나, 모음수가 최소 한개가 되지 못하면 탈락
		
		if(tgtIdx == L) {
			for(int i = 0; i < L; i++) {
				System.out.print(tgt[i]);
			}
			System.out.println();
			return;
		}
		
		for(int i = srcIdx ; i < C; i++) {
			
			tgt[tgtIdx] = src[i];
			if(src[i] == 'a' || src[i] == 'e' || src[i] == 'i' || src[i] == 'o' || src[i] == 'u') {
				dfs(i+1, tgtIdx+1, vowel+1, conso);
			}else {
				dfs(i+1, tgtIdx+1, vowel, conso+1);
			}
		}
		
	}

}

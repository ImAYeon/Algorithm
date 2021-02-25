package silverI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_링크와스타트_15661 {

	static int N;
	static int[][] S;
	static int min;
	static boolean[] select;
	

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		S = new int[N][N];
		min = Integer.MAX_VALUE;
		
		select = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 먼저 부분집합으로 두개의 집합 모두 수가 1개 이상일때 체크
		// 두 집합 sum 해서 차이 계산해서 최솟값 찾기
		comb(0);
		
		System.out.println(min);
	}
	
	static void comb(int srcIdx) {
		
		if(srcIdx == N){
			checkSum();
			return;
		}
		
		select[srcIdx] = true;
		comb(srcIdx+1);
		select[srcIdx] = false;
		comb(srcIdx+1);
		
		
	}
	
	static void checkSum() {
		
		ArrayList<Integer> al1 = new ArrayList<>();
		ArrayList<Integer> al2 = new ArrayList<>();
		
		int sum1 = 0;
		int sum2 = 0;
		
		for(int i = 0; i < N; i++) {
			if(select[i]) {
				al1.add(i);
			}
			else {
				al2.add(i);
			}
		}
		
		for(int i = 0; i < al1.size(); i++) {
			for(int j = 0; j < al1.size(); j++) {
				sum1 += S[al1.get(i)][al1.get(j)];
			}
		}
		for(int i = 0; i < al2.size(); i++) {
			for(int j = 0; j < al2.size(); j++) {
				sum2 += S[al2.get(i)][al2.get(j)];
			}
		}
		
		min = Math.min(min, Math.abs(sum1 - sum2));
		
	}
	

}

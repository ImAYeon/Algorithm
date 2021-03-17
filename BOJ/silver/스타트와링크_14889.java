package silverIII;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_스타트와링크_14889 {

	static int N, min;
	static int[][] S;
	static boolean[] select;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		S = new int[N][N];
		select = new boolean[N];
		min = Integer.MAX_VALUE;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		subset(0);
		
		System.out.println(min);
		
	}
	
	static void subset(int index) {
		
		if(index == N) {
			checkMin();
			return;
		}
		
		select[index] = true;
		subset(index+1);
		select[index] = false;
		subset(index+1);
		
	}
	
	static void checkMin() {
		ArrayList<Integer> aL1 = new ArrayList<Integer>();
		ArrayList<Integer> aL2 = new ArrayList<Integer>();
		
		for(int i = 0; i < N; i++) {
			if(select[i]) aL1.add(i);
			else aL2.add(i);
		}
		
		if(aL1.size() != N/2 && aL2.size() != N/2) return; // 사실 그냥 aL1.sizE() != N/2 만 해줘도 됨, 어차피 하나가 N/2면 나머지는 알아서 N/2
		
		int sum1 = 0;
		int sum2 = 0;
		
		for(int i = 0; i < aL1.size(); i++) {
			for(int j = 0; j < aL1.size(); j++) {
				sum1 += S[aL1.get(i)][aL1.get(j)];
			}
		}
		for(int i = 0; i < aL2.size(); i++) {
			for(int j = 0; j < aL2.size(); j++) {
				sum2 += S[aL2.get(i)][aL2.get(j)];
			}
		}
		min = Math.min(min, Math.abs(sum1-sum2) );
	}

}


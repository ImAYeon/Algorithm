package silverII;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_부분수열의합_1182_other {
	
	static int N, S, COUNT;
	static int[] src;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		S = Integer.parseInt(s[1]);
		src = new int[N];
		COUNT = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			src[i] = Integer.parseInt(st.nextToken());
		}
		
		subset(0,0);
		
		if(S == 0) COUNT--;// 공집합도 포함되기 때문에 COUNT에서 1개 빼줘야함
		
		System.out.println(COUNT);
	}
	
	static void subset(int srcIdx, int sum) {
		
		// 기저조건
		if( srcIdx == src.length ) {
			if(sum == S) COUNT++;
			return;
		}
		
		subset(srcIdx + 1, sum + src[srcIdx]);
		
		subset(srcIdx + 1, sum);
	}

}

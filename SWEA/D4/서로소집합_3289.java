package d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_서로소집합_3289 {

	static int T, N, M;
	static int[] parents;
	
	static int findSet(int a) {
		if(parents[a] == a) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) return false;
		
		parents[aRoot] = bRoot;
		
		return true;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken()); // 입력으로 주어지는 연산의 개수
			parents = new int[N+1];
			
			for(int i = 1; i <= N; i++) { // make-set 부분
				parents[i] = i;
			}
			
			 StringBuilder sb = new StringBuilder();
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(num == 0) { // a집합과  b집합을 합침
					union(a,b);
				}else if(num == 1) {
					if(findSet(a) == findSet(b)) sb.append(1);
					else sb.append(0);
				}
			}
			
			System.out.println("#" + t + " " + sb.toString());
		}
		
		
	}

}

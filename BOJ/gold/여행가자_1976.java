package goldIV;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_여행가자_1976 {
	
	static int N, M;
	static String ans = "YES";
	static int[] parents;
	
	static int findSet(int a) {
		if(parents[a] == a) return a;
			
		return parents[a] = findSet(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		int[][] node = new int[N+1][N+1];
		
		parents = new int[N+1];
		for(int i = 1; i <= N; i++) {
			parents[i] = i;
		}
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				node[i][j] = Integer.parseInt(st.nextToken());
				if(node[i][j] == 1) union(i, j);
			}
		}

		st = new StringTokenizer(br.readLine());
		
		int start = findSet(Integer.parseInt(st.nextToken()));
		while(st.hasMoreTokens()) {
			int temp_node = Integer.parseInt(st.nextToken());
			if(start != findSet(temp_node)) {
				ans = "NO";
				break;
			}
		}
		
		System.out.println(ans);
		
	}

}

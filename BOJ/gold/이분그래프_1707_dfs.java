package goldIV;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_이분그래프_1707_dfs {
	
	static int T, V, E;
	static int[] visit;
	static ArrayList<Integer>[] arrList;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			visit = new int[V+1];
			
			arrList = new ArrayList[V+1];
			for(int i = 1; i <= V; i++) {
				arrList[i] = new ArrayList<Integer>();
			}
			
			for(int i = 0; i < E; i++) {
				 st = new StringTokenizer(br.readLine());
				 int A = Integer.parseInt(st.nextToken());
				 int B = Integer.parseInt(st.nextToken());
				 arrList[A].add(B);
				 arrList[B].add(A);
			}
			
			
			for(int i = 1; i <= V; i++) {
				if(visit[i] == 0) {
					dfs(i, 1);
				}
			}
			if(isPossible()) {
				System.out.println("YES");				
			}else {
				System.out.println("NO");
			}
		}
		
	}
	
	static void dfs(int node, int num) {
		visit[node] = num;
		for(int i = 0; i < arrList[node].size(); i++) {
			int next = arrList[node].get(i);
			if(visit[next] == 0) {
				dfs(next, 3-num);
			}
		}
		
	}
	
	static boolean isPossible() {
		for(int i = 1; i <= V; i++) {
			for(int j = 0; j < arrList[i].size(); j++) {
				if(visit[i] == visit[arrList[i].get(j)]) return false;
			}
		}
		return true;
	}

}

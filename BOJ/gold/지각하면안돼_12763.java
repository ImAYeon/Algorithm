package goldII;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_지각하면안돼_12763 {
	
	static int N, T, M, L;
	static ArrayList<int[]>[] arrList;
	static boolean[] visited;
	static int min = 10001;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		T = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		L = Integer.parseInt(br.readLine());
		arrList = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		for(int i = 1; i <= N; i++) {
			arrList[i] = new ArrayList<int[]>();
		}
		
		for(int i = 0; i < L; i++) {
			s = br.readLine().split(" ");
			
			arrList[Integer.parseInt(s[0])].add(new int[]{ Integer.parseInt(s[1]), Integer.parseInt(s[2]), Integer.parseInt(s[3]) });
			arrList[Integer.parseInt(s[1])].add(new int[]{ Integer.parseInt(s[0]), Integer.parseInt(s[2]), Integer.parseInt(s[3]) });
		}
		
		visited[1] = true;
		dfs(1, 0, 0);
		
		if(min == 10001) System.out.println(-1);
		else System.out.println(min);
	}
	
	static void dfs(int node, int time, int money) {
		
		if(time > T || money > M || money >= min) return;
		
		if(node == N) {
			min = Math.min(min, money);
			System.out.println();
			return;
		}
		
		
		for(int i = 0; i < arrList[node].size(); i++) {
			int[] current = arrList[node].get(i);
			
			if(visited[current[0]]) continue;
			System.out.println("( " + current[0] + " " + current[1] + " " + current[2] + ") : T =" + (time+current[1]) + ", money =" + (money+current[2]));
			
			visited[current[0]] = true;
			dfs(current[0], time + current[1], money + current[2]);
			visited[current[0]] = false;
		}
		
	}
}

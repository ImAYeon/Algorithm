package goldIV;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_이분그래프_1707_bfs {
	
	static int T, V, E;
	static int[] visit;
	static ArrayList<Integer>[] arrList;
	static String ans;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			visit = new int[V+1];
			ans = "";
			
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
					boolean check = bfs(i, 1);
					if(!check) break;
				}
			}

			System.out.println(ans);
		}
		
	}
	
	static boolean bfs(int node, int num) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(node);
		visit[node] = num;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			for(int i = 0; i < arrList[current].size(); i++) {
				int temp = arrList[current].get(i);
				if(visit[temp] == 0) {
					visit[temp] = 3 - visit[current];
					queue.offer(temp);
				}
				else if(visit[temp] == visit[current]) {
					ans = "NO";
					return false;
				}
			}
		}
		
		ans = "YES";
		return true;
		
	}

}

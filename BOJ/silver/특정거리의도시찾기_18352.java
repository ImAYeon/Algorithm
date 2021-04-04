package silverII;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_특정거리의도시찾기_18352 {
	
	static int N, M, K, X;
	static ArrayList<Integer>[] arrList;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		arrList = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			arrList[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			arrList[A].add(B);
		}
		
		PriorityQueue<Integer> ans = new PriorityQueue<>((o1, o2) -> {return o1 - o2; });
		
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {X, 0});
		visited = new boolean[N+1];
		visited[X] = true;
		while(!queue.isEmpty()) {
			int[] p = queue.poll();
			int current = p[0];
			int dist = p[1];
			if( dist == K) {
				ans.offer(current);
				continue;
			}
			for(int i = 0; i < arrList[current].size(); i++) {
				int node = arrList[current].get(i);
				if(!visited[node]) {
					visited[node] = true;
					queue.offer(new int[] {node, dist + 1});
				}
			}
		}
		if(ans.isEmpty()) System.out.println(-1);
		else {
			while(!ans.isEmpty()) {
				System.out.println(ans.poll());
			}
		}
	}

}

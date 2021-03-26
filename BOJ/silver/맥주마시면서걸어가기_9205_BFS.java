import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//silver I

public class BJ_맥주마시면서걸어가기_9205_BFS { // *****동우님 코드

	static int T, N;
	static int BIG = 101*32767*2; // 편의점이 100개 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			N = Integer.parseInt(br.readLine());
			 Node[] nodes = new Node[N + 2];
			 
			 for(int i = 0; i < N+2; i++) {
				 st = new StringTokenizer(br.readLine());
				 nodes[i] = new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			 }
			 
			 for(int i = 0; i < N + 2; i++) {
				 for(int j = i + 1; j < N + 2; j++) {
					 if(getDist(nodes[i], nodes[j]) <= 50*20) {
						 nodes[i].edge.add(j);
						 nodes[j].edge.add(i);
					 }
				 }
			 }
			 
			 boolean[] visited = new boolean[N + 2];
			 Queue<Integer> q = new LinkedList<>();
			 q.offer(0);
			 visited[0] = true;
			 while( !q.isEmpty() ) {
				 int temp = q.poll();
				 for(int i = 0; i < nodes[temp].edge.size(); i++) {
					 if(!visited[nodes[temp].edge.get(i)]) {
						 visited[nodes[temp].edge.get(i)] = true;
						 q.offer(nodes[temp].edge.get(i));
					 }
				 }
			 }
			 if(visited[N+1])
				 System.out.println("happy");
			 else
				 System.out.println("sad");
		}
		
		br.close();
		
	}
	
	static int getDist(Node n1, Node n2) {
		return Math.abs(n1.x - n2.x) + Math.abs(n1.y - n2.y);
	}
	
	static class Node{
		int x;
		int y;
		ArrayList<Integer> edge = new ArrayList<>();
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}

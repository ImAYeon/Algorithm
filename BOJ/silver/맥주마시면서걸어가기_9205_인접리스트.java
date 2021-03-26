import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// silver I

public class BOJ_맥주마시면서걸어가기_9205 {

	static int T, N;
	static int[][] adjMatrix;
	static ArrayList<Node> arrList;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			adjMatrix = new int[N+2][N+2]; // 집  + N- 편의점 갯수 + 페스티벌 => 0 ~ N+1
			arrList = new ArrayList<Node>();
			
			for(int i = 0; i < N+2; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				arrList.add(new Node(x,y));
			}
			
			for(int i = 0; i < N+2; i++) {
				for(int j = 0; j< N+2; j++) {
					adjMatrix[i][j] = 9999999;  // Integer.MAX_VALUE; 안하는 이유 : 더하는 과정에서 overflow
				}
			}
			
			for(int i = 0; i < N + 2; i++) {
				for(int j = 0; j < N + 2; j++) {
					if(i == j) continue;
					
					Node current = arrList.get(i);
					Node next = arrList.get(j);
					
					int dist = Math.abs(current.x-next.x)+ Math.abs(current.y-next.y);
					if(dist <= 1000) adjMatrix[i][j] = 1;
				}
			}
			
			for(int k = 0; k < N + 2; k++) {
				for(int i = 0; i < N + 2; i++) {
					if(i == k) continue; // 출발지와 경유지가 같다면 다음 출발지
					for(int j = 0; j < N + 2; j++) {
						if(i == j || k == j) continue; // 경유지와 목적지가 같거나 출발지가 곧 목적지라면 패스
						if(adjMatrix[i][j] > adjMatrix[i][k]+adjMatrix[k][j]) {
							adjMatrix[i][j] = adjMatrix[i][k]+adjMatrix[k][j];
						}
					}
				}
			}
			
			if(0 < adjMatrix[0][N+1] && adjMatrix[0][N+1] < 999999)
				System.out.println("happy");
			else
				System.out.println("sad");
			
			
		}
	}
	
	static class Node{
		int x;
		int y;
		
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

}

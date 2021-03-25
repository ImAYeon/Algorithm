import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_길찾기_1219_DFS {

	static int N, flag;
	static int[][] Node;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int t = 1; t <= 10; t++) {
			flag = 0;
			st = new StringTokenizer(br.readLine());
			st.nextToken(); //테스트 케이스 번호
			N = Integer.parseInt(st.nextToken());
			Node = new int[N][2]; // 갈 수 있는 길은 최대 2개
			visited = new boolean[N][2]; // 갈 수 있는 길은 최대 2개
			
			st = new StringTokenizer(br.readLine());
			int n = 0;
			for(int i = 0; i < N; i++) {
				n = Integer.parseInt(st.nextToken());
				if(Node[n][0] > 0) {
					Node[n][1] = Integer.parseInt(st.nextToken());					
				}else {
					Node[n][0] = Integer.parseInt(st.nextToken());
				}
			}
			
			dfs(0);
			
			StringBuilder sb = new StringBuilder();
			sb.append("#" + t + " ");
			if(flag == 0) {
				sb.append(0);
			}else {
				sb.append(1);
			}
			System.out.println(sb.toString());
			
		}
		
	}
	
	static void dfs(int cnt) {
		if(Node[cnt][0] == 99 || Node[cnt][1] == 99) {
			flag = 1;
			return;
		}
		
		for(int i = 0; i < 2; i++) {
			if(visited[cnt][i]) continue;
			
			visited[cnt][i] = true;
			dfs(Node[cnt][i]);
		}
		
		
	}

}

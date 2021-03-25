import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_길찾기_1219_BFS {

	static int N;
	static int[][] Node;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int t = 1; t <= 10; t++) {
			int flag = 0;
			st = new StringTokenizer(br.readLine());
			st.nextToken(); //테스트 케이스 번호
			N = Integer.parseInt(st.nextToken());
			Node = new int[N][2]; // 갈 수 있는 길은 최대 2개
			
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
			
			Queue<Integer> queue = new LinkedList<Integer>();
			
			queue.offer(0);
			while(!queue.isEmpty()) {
				int current = queue.poll();
				for(int i = 0; i < 2; i++) {
					if(Node[current][i] == 99) {
						flag = 1;
						break;
					}
					if(Node[current][i] > 0) queue.offer(Node[current][i]);
				}
				if(flag == 1) break;
			}

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

}

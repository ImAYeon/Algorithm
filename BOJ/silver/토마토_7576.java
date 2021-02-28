import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 실버 I
public class BOJ_토마토_7576 {

	static int[] dy = {-1, 1,  0, 0}; // 상 하 좌 우
	static int[] dx = { 0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int M = Integer.parseInt(s[0]); // 가로 수 (x축)
		int N = Integer.parseInt(s[1]); // 세로 수 (y축)
		
		Queue<int[]> queue = new LinkedList<int[]>();
		
		int[][] map = new int[N][M];
		
		StringTokenizer st;
		boolean check= true;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) check = false;
				if(map[i][j] == 1) {
					queue.offer(new  int[] {i,j});
				}
			}
		}
		
		if(check) {
			System.out.println(0);
			return;
		}
		
		int cnt = 0, size = 0;
		int[] temp;
		while(!queue.isEmpty()) {
			
			size = queue.size();
			
			while (--size >= 0) {
				temp = queue.poll();
				// 사방탐색
				for(int k = 0; k < 4; k++) {
					int ny = temp[0] + dy[k];
					int nx = temp[1] + dx[k];
					if(ny < 0 || ny >= N || nx < 0 || nx >= M 
							|| map[ny][nx] == -1 || map[ny][nx] == 1) continue;
					else if(map[ny][nx] == 0) {
						map[ny][nx] = 1;
						queue.offer(new int[] {ny,nx});
					}
				}
			}
			cnt++;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}
		
		System.out.println(cnt-1); // 마지막에 탐색을 못하는 상황에도 cnt가 더해지므로 1을 빼줌
		
		
		
	}

}

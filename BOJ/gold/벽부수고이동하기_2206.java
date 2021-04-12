package goldIV;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_벽부수고이동하기_2206 {
	
	static int N, M;
	static int[][] map;
	static boolean isBreak; // 벽을 한개 부셨는지 안부셨는지
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static boolean[][][] visited;
	static Queue<int[]> queue = new LinkedList<int[]>();
	

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M][2];
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		// 이전에 벽을 부순적이 있는지도 함께 넘겨주기 ( x, y, distance, (0 or 1) )
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {0, 0, 1, 0});
		visited[0][0][0] = true;
		visited[0][0][1] = true;
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int x = temp[0];
			int y = temp[1];
			int isBreak = temp[3];
			
			if(y == N-1 && x == M-1) {
				System.out.println(temp[2]);
				System.exit(0);
			}		
			
			for(int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
			
				if(nx < 0 || ny < 0 || nx >= M || ny >= N ) continue;

				if(map[ny][nx] == 1) { // 벽이 있는 경우
					if(isBreak == 0 && !visited[ny][nx][1]) {
						visited[ny][nx][1] = true;
						queue.offer( new int[] {nx, ny, temp[2] + 1, 1} );
					}
				}else { //벽이 없는 경우
					if(!visited[ny][nx][isBreak]) {
						visited[ny][nx][isBreak] = true;
						queue.offer(new int[] {nx, ny, temp[2] + 1, isBreak});
					}
				}
			}
			
		}
		
		System.out.println(-1);
		
	}
	

}

// 벽을 이미 부수고 이동하는 경로랑 부수지 않은 상태의 경로랑 다르기 때문에 visit배열을 3차원으로 두고 따로 방문 체크를 해줘야 한다***********

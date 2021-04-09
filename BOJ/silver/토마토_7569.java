package silverI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 최소 일수 : BFS
public class BOJ_토마토_7569 {
	
	static int M, N, H, ans;
	static int[][][] tomato; 
	static boolean flag; // 맨 처음에 토마토가 모두 익어있는 상황과 맨 나중에 모두 익지 못하는 상황인지 관리
	static int[] dz = {-1, 1, 0, 0, 0, 0};
	static int[] dy = {0, 0, -1, 1, 0, 0};
	static int[] dx = {0, 0, 0, 0, -1, 1};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken()); // 2 <= M <= 100
		N = Integer.parseInt(st.nextToken()); // 2 <= N <= 100
		H = Integer.parseInt(st.nextToken()); // 1 <= H <= 100
		
		tomato = new int[H][N][M];
		
		Queue<int[]> queue = new LinkedList<int[]>(); // 먼저 이미 익어있는 토마토들 전부를 담아놔야 함
		
		
		for(int h = 0; h < H; h++) {
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < M; j++) {
					tomato[h][i][j] = Integer.parseInt(st.nextToken());
					if(tomato[h][i][j] == 0) flag = true;
					else if(tomato[h][i][j] == 1) {
						queue.offer(new int[]{h, i, j, 0}); // z, y, x, day 계산
					}
				}
			}
		}
		
		if(!flag) { // flag가 false면 전부 익었다는 뜻
			System.out.println(0);
			System.exit(0);
		}
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int cz = temp[0];
			int cy = temp[1];
			int cx = temp[2];
			tomato[cz][cy][cx] = 2; // 방문 표시
			
			for(int k = 0; k < 6; k++) {
				int nz = cz + dz[k];
				int ny = cy + dy[k];
				int nx = cx + dx[k];
				
				if(nz < 0 || ny < 0 || nx < 0 || nz >= H || ny >= N || nx >= M || tomato[nz][ny][nx] == -1 || tomato[nz][ny][nx] == 2) continue;
				
				tomato[nz][ny][nx] = 2;
				queue.offer(new int[] {nz, ny, nx, temp[3] + 1});
			}
			ans = temp[3];
			
		}
		
		for(int h = 0; h < H; h++) {
			for(int i = 0; i < N; i++) {
				for(int j = 0;j < M; j++) {
					if(tomato[h][i][j] == 0) flag = false;
				}
			}
		}
		
		if(!flag) System.out.println(-1);
		else System.out.println(ans);
		
	}

}

package review;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_토마토_7576 {
	
	static int M, N, cnt, cntNot;
	static int[][] map;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		Queue<int[]> queue = new LinkedList<int[]>();
		
		// 나는 익은 토마토와 벽을 셋는데 안익은 토마토를 세는게 변수 하나로 끝났을 거 같다.
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					queue.offer(new int[] {i, j, 0});
					cnt++;
				}
				if(map[i][j] == -1) cntNot++;
			}
		}
		
		if(cnt == N*M - cntNot) {
			System.out.println(0);
			System.exit(0);
		}
		
		int y, x, day = 0;
		while(!queue.isEmpty()) {
			int temp[] = queue.poll();
			y = temp[0];
			x = temp[1];
			day = temp[2];
			
			for(int k = 0; k < 4; k++) {
				int ny = y + dy[k];
				int nx = x + dx[k];
				
				if(ny < 0 || nx < 0 || ny >= N || nx >= M || map[ny][nx] == -1 || map[ny][nx] == 1) continue;
				
				map[ny][nx] = 1; // 방문처리 - 익은 토마토 표시
				cnt++;
				queue.offer(new int[] {ny, nx, day + 1});
			}	
		}
		
		if(cnt != N*M - cntNot){
			System.out.println(-1);
		}else {
			System.out.println(day);
		}
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//골드 V
public class BOJ_치즈_2636 {

	static int R,C, cheese, cntRemain, time;
	static int[][] map;
	static int[] dy = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dx = { 0, 0, -1, 1 };
	static boolean[][] visit;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		
		for(int i= 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) cheese++;
			}
		}
		Queue<int[]> queue = new LinkedList<int[]>();
		
		while(cheese != 0) {
			time++;
			cntRemain = cheese;
			
			queue.add(new int[] {0,0});
			
			visit = new boolean[R][C];
			visit[0][0] = true;
			
			
			while(!queue.isEmpty()) {
				int[] temp = queue.poll();
				
				for(int k = 0; k < 4; k++) {
					int ny = temp[0] + dy[k];
					int nx = temp[1] + dx[k];
					if(ny < 0 || nx < 0 || ny >= R || nx >= C || visit[ny][nx]) continue;
					if(map[ny][nx] == 1) {
						cheese--;
						map[ny][nx] = 0;
					}else if(map[ny][nx] == 0) {
						queue.offer(new int[] { ny, nx } );						
					}
					visit[ny][nx] = true;
				}
			}
			
		}
		
		System.out.println(time);
		System.out.println(cntRemain);
		
		
	}

}

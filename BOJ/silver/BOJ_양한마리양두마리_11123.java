import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_양한마리양두마리_11123 { // S1
	
	static int[] dy = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int ans = 0;
			
			String[] s = br.readLine().split(" ");
			int H = Integer.parseInt(s[0]); // 그리드의 높이
			int W = Integer.parseInt(s[1]); // 그리드의 너비
			
			char[][] map = new char[H][W];
			
			for(int i = 0; i < H; i++) {
				String line = br.readLine();
				for(int j = 0; j < W; j++) {
					map[i][j] = line.charAt(j);
				}
			}
			
			for(int i = 0 ; i < H; i++) {
				for(int j = 0; j < W; j++) {
					if(map[i][j] != '#') continue;
					
					Queue<int[]> queue = new LinkedList<int[]>();
					
					queue.offer(new int[]{i, j});
					
					while(!queue.isEmpty()) {
						int[] l = queue.poll();
						int y = l[0];
						int x = l[1];
						
						for(int k = 0; k < 4; k++) {
							int nx = x + dx[k];
							int ny = y + dy[k];
							
							if(nx < 0 || nx >= W || ny < 0 || ny >= H || map[ny][nx] != '#') continue;
							
							queue.offer(new int[] {ny, nx});
							map[ny][nx] = '.';
						}
					}
					ans++;
				}
			}
			
			
			System.out.println(ans);
		}

	}

}

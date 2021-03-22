package d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_미로2_1227_bfs {

	static int T;
	static int[] temp;
	static char[][] map;
	static Queue<int[]> queue;
	
	static int[] dy = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dx = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		for(int t = 1; t <= 10; t++) {
			T = Integer.parseInt(br.readLine());
			sb = new StringBuilder();
			map = new char[100][100];
			for(int i = 0; i < 100; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			queue = new LinkedList<int[]>();
			queue.add(new int[] {1, 1});
			
			boolean check = false;
			
			while(!queue.isEmpty()) {
				temp = queue.poll();
				// 사방탐색
				for (int k = 0; k < 4; k++) {
					int ny = temp[0] + dy[k];
					int nx = temp[1] + dx[k];
					if (ny < 0 || ny >= 100 || nx < 0 || nx >= 100 ||map[ny][nx] == '1')
						continue;
					else if (map[ny][nx] == '3') {
						check = true;
						break;
					}
					else if (map[ny][nx] == '0') {
						map[ny][nx] = '1';
						queue.offer(new int[] { ny, nx });
					}
				}
				if(check) break;
			}
			
			sb.append("#" + t + " ");
			if(check) sb.append(1);
			else sb.append(0);
			
			System.out.println(sb.toString());
			
		}
		
	}

}

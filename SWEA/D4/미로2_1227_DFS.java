package d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_미로2_1227_dfs {

	static int T;
	static int[] temp;
	static boolean check;
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
			
			check = false;
			dfs(1, 1);
			
			if(check) {
				System.out.println("#" + t + " 1");
			}else {
				System.out.println("#" + t + " 0");
			}
		}	
	}
	
	static void dfs(int y, int x) {
		if( map[y][x] == '3') {
			check = true;
			return;
		}
		
		if( map[y][x] == '1') {
			return;
		}
		
		map[y][x] = '1';
		for (int k = 0; k < 4; k++) {
			int ny = y + dy[k];
			int nx = x + dx[k];
			if (ny < 0 || ny >= 100 || nx < 0 || nx >= 100) continue;
			dfs(ny, nx);
		}
		map[y][x] = '0';
	}

}

	package hwalgo12_서울_13_임아연;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_알파벳_1987 {
	
	static int[] dx = {0, 0, -1, 1}; // 상 하 좌 우
	static int[] dy = {-1, 1, 0, 0};
	static int R,C,max;
	static char[][] map;
	static boolean[] check;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		R = Integer.parseInt(s[0]);
		C = Integer.parseInt(s[1]);
		
		map = new char[R][C];
		check = new boolean[26]; // A ~ Z
		
		for(int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		max = Integer.MIN_VALUE;
		
		check[map[0][0] - 'A'] = true; // [0,0] 인덱스에 있는 알파벳 체크
		go(0, 0, 1);
		
		System.out.println(max);
	}
	
	static void go(int x, int y, int cnt) {
		
		max = Math.max(max, cnt);
		
		for(int k = 0; k < 4; k++) {
			int ny = y + dy[k];
			int nx = x + dx[k];
			if(ny < 0 || ny >= R || nx < 0 || nx >= C || check[map[ny][nx] - 'A']) continue; // map[ny][nx] - 'A' => A면 0인덱스, B면 1인덱스,,, check인덱스 나타냄
			check[map[ny][nx] - 'A'] = true;
			go(nx, ny, cnt+1);
			check[map[ny][nx] - 'A'] = false;
		}
		
	}

}

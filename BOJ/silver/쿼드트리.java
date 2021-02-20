package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_쿼드트리_1992 {
	
	static int[][] map;
	static int N;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for(int i = 0 ; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		video(0,0,N);
		
		
	}
	
	static void video(int y, int x, int n) {
		
		if(check(y, x, n)) {
			System.out.print(map[y][x]);
			return;
		}
		else {
			n /= 2;
			if(n == 1) {
				System.out.print("(" + map[y][x]+""+map[y][x+1]+""+map[y+1][x]+""+map[y+1][x+1] + ")");
				
				return;
			}
			System.out.print("(");
			video(y,x, n);
			video(y,x+n, n);
			video(y+n,x, n);
			video(y+n,x+n, n);
			System.out.print(")");
		}
	}
	
	static boolean check(int y, int x, int n) {
		for(int i = y; i < y+n; i++) {
			for(int j = x; j < x+n; j++) {
				if(map[i][j] != map[y][x]) return false;
			}
		}
		return true;
	}
}

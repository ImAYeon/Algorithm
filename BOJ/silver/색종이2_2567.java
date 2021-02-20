package supplement.day05;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_색종이2_2567 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[101][101];
		
		String[] s; int x,y;
		for(int n = 1; n <= N; n++) {
			s = br.readLine().split(" ");
			x = Integer.parseInt(s[0]);
			y = Integer.parseInt(s[1]);
			for(int i = y; i < y+10; i++) {
				for(int j = x; j < x+10; j++) {
					map[i][j] = 1;
				}
			}
		}
		
		int cnt = 0;
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(map[i][j] == 0 && map[i][j+1] == 1) cnt++;
				if(map[i][j] == 1 && map[i][j+1] == 0) cnt++;
				
				if(map[i][j] == 0 && map[i+1][j] == 1) cnt++;
				if(map[i][j] == 1 && map[i+1][j] == 0) cnt++;
				
			}
		}
		
		System.out.println(cnt);
	}

}

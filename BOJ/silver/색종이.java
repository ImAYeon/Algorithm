package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2563_색종이 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		boolean[][] arr = new boolean[100][100];
		
		for(int k = 0 ; k < N; k++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			
			for(int i = y; i < y+10; i++) {
				for(int j = x; j < x+10; j++) {
					arr[i][j] = true;
				}
			}
		}
		
		int ans = 0;
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(arr[i][j]) ans++;
			}
		}
		System.out.println(ans);
		
	}

}

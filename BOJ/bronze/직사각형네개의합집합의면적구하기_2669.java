package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_직사각형네개의합집합의면적구하기_2669 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[][] area = new boolean[100][100];
		
		StringTokenizer st;
		for(int k = 0; k < 4; k++) {
			st = new StringTokenizer(br.readLine());
			
			int xStart = Integer.parseInt(st.nextToken());
			int yStart = Integer.parseInt(st.nextToken());
			int xEnd = Integer.parseInt(st.nextToken());
			int yEnd = Integer.parseInt(st.nextToken());
			
			for(int i = yStart; i < yEnd; i++) {
				for(int j = xStart; j < xEnd; j++) {
					area[i][j] = true;
				}
			}
		}
		
		int ans = 0;
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(area[i][j]) ans++;
			}
		}
		
		System.out.println(ans);
		

	}

}

package d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_어디에단어가들어갈수있을까_1979 {
	
	static int total_cnt = 0;
	static int[][] arr;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			
			total_cnt = 0;
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			arr = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 가로 
			for(int i = 0; i < N; i++) {
				for(int j = 0;j < N; j++) {
					if(arr[i][j] == 1) {
						int cnt = 0;
						while(true) {
							if(j >= N || arr[i][j] == 0) break;
							cnt++;
							j++;
						}
						if(cnt == K) total_cnt++;
					}
				}
			}
			
			// 세로
			for(int j = 0;j < N; j++) {
				for(int i = 0; i < N; i++) {
					if(arr[i][j] == 1) {
						int cnt = 0;
						while(true) {
							if(i >= N || arr[i][j] == 0) break;
							cnt++;
							i++;
						}
						if(cnt == K) total_cnt++;
					}
				}
			}
			
			
			System.out.println("#" + tc + " " + total_cnt);
		}

	}
}

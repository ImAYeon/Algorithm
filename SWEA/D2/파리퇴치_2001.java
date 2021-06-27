package d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_파리퇴치_2001 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 영역 크기
			int M = Integer.parseInt(st.nextToken()); // 파리채 크기
			
			// 배열 초기화
			int[][] arr = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int max = 0;
			for(int i = 0; i <= N-M ; i++) {
				for(int j = 0; j <= N-M; j++) {
					int sum = 0;
					for(int x = i; x < i+M; x++) {
						for(int y = j; y < j+M; y++) {
							sum += arr[x][y];
						}
					}
					max = Math.max(max, sum);
				}
			}
			
			System.out.println("#" + tc + " " + max);
		}
		
	}

}

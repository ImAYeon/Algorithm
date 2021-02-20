package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_체스판다시칠하기_1018 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		char[][] chess1 = {
				{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
				{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
				{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
				{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
				{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
				{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
				{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
				{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}
		};
		
		char[][] chess2 = {
				{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
				{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
				{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
				{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
				{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
				{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
				{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
				{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}
		};
		
		char[][] map = new char[N][M];
		
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		int min = Integer.MAX_VALUE;
		
		for(int n = 0; n <= N-8; n++) {
			for(int m = 0; m <= M-8; m++) {
				int cnt1 = 0;
				int cnt2 = 0;
				for(int i = n, a=0; i < n+8; i++, a++) {
					for(int j = m, b=0; j < m+8; j++, b++) {
						if(map[i][j] != chess1[a][b]) cnt1++;
						if(map[i][j] != chess2[a][b]) cnt2++;
					}
				}
				min = Math.min(min, cnt1);
				min = Math.min(min, cnt2);
			}
		}
	
		System.out.println(min);
		
	}
	
}

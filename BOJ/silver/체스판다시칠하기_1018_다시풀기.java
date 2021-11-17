import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_체스판다시칠하기_1018 {
	
	static char[][] map;
	static char[][] chess1 = {
		{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
		{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
		{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
		{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
		{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
		{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
		{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
		{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}};
	static char[][] chess2 = {
		{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
		{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
		{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
		{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
		{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
		{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
		{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
		{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		
		for(int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		// 지민이가 다시 칠해야 하는 정사각형의 최소 개수 구하기
		int sum1, sum2;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i <= N-8; i++) {
			for(int j = 0; j <= M-8; j++) {
				sum1 = 0; sum2 = 0;
				for(int x = 0; x < 8; x++) {
					for(int y = 0; y < 8; y++) {
						if(map[i+x][j+y] != chess1[x][y]) sum1++;
						if(map[i+x][j+y] != chess2[x][y]) sum2++;
					}
				}
				min = Math.min(min, sum1);
				min = Math.min(min, sum2);
			}
		}
		
		System.out.println(min);
		
	}

}

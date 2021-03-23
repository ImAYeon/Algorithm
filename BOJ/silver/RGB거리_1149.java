import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_RGB거리_1149 {
	
	static int N;
	static int[][] cost;
	static int[][] dp;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		cost = new int[N+1][3]; // [i]{빨, 초, 파}
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			cost[i][0] = Integer.parseInt(st.nextToken());
			cost[i][1] = Integer.parseInt(st.nextToken());
			cost[i][2] = Integer.parseInt(st.nextToken());
		}
		for(int n = 2; n <= N; n++) {
			cost[n][0] = Math.min(cost[n-1][1], cost[n-1][2]) + cost[n][0]; // 빨간색선택 가정 : 그 전 선택은 파란색 또는 초록색중 비용이 최소인거여야함
			cost[n][1] = Math.min(cost[n-1][0], cost[n-1][2]) + cost[n][1]; 
			cost[n][2] = Math.min(cost[n-1][0], cost[n-1][1]) + cost[n][2];
		}
		
		System.out.println(Math.min(Math.min(cost[N][0], cost[N][1]), cost[N][2]));
	}

}

package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_부녀회장이될테야_2775 {
	
	static int[][] memo= new int[15][15]; // 14층 14호 까지 있으므로 y=> 0~14, x = 1 ~ 14
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			
			int k = Integer.parseInt(br.readLine()); // 층수
			int n = Integer.parseInt(br.readLine()); // 호수
			
			
			for(int x = 1; x <= 14; x++) {
				memo[0][x] = x;
			}
			
			System.out.println(calc(k, n));
		}
	}
	
	static int calc(int floor, int unit) {//층, 호
		
		
		if(floor > 0 && memo[floor][unit] == 0) {
			for(int j = 1; j <= unit; j++) {
				memo[floor][unit] += calc(floor-1,j);
			}
		}
		
		
		return memo[floor][unit];
	}
}

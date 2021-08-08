package d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_간단한소인수분해_1945 {

	static int[] num = {2, 3, 5, 7, 11};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int[] result = new int[5];
			
			int N = Integer.parseInt(br.readLine());
			
			for(int i = 4; i >= 0; i--) {
				int cnt = 0;
				while(N % num[i] == 0) {
					cnt++;
					N /= num[i];
				}
				result[i] = cnt;
			}
			
			System.out.print("#" + tc + " ");
			
			for(int i = 0; i < 5; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
		}
		
	}

}

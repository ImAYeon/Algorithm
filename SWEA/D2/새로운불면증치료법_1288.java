package d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_새로운불면증치료법_1288 {
	
	static boolean[] num;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			num = new boolean[10];
			
			int k = 1;
			while(true) {
				int n = N * k;
				
				checkNum(n);

				if(checkStop()) break;
				
				k++;
      }
			
			System.out.println("#" + tc + " " + k*N);
		}
		
	}
	
	static void checkNum(int n) {
		while(true) {
			num[n % 10] = true;
			n /= 10;
			if(n == 0) break;
		}
	}
	
	static boolean checkStop() {
		for(int i = 0; i < num.length; i++) {
			if(num[i] == false) return false;
		}
		return true;
	}

}

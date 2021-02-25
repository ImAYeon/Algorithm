package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_비밀이메일_2999 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] c = br.readLine().toCharArray();
		
		int N = c.length;
		
    // 공약수 구하기
//		int R = 1,C = N, cnt = 1;
//		while(true) {
//			if(cnt >= C) break;
//			if(N % cnt == 0) {
//				R = cnt;
//				C = N / cnt;
//			}
//			cnt++;
//		}
		
    // 공약수 구하기 - 더 쉬운 
		int R = 1, C= N;
		int s = (int) Math.sqrt(N);
		for(int i = 1; i <= s; i++) {
			if(N % i == 0) R =i;
		}
		C = N / R;
		
		char[][] arr = new char[R][C];
		
		int cnt = 0;
		for(int j = 0; j < C; j++) {
			for(int i = 0; i < R; i++) {
				arr[i][j] = c[cnt++];
			}
		}

		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++){
				System.out.print(arr[i][j]);
			}
		}
		
		
	}

}

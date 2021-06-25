package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_직사각형을만드는방법_8320 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n= Integer.parseInt(br.readLine());
		
		int ans = 0;
		for(int i = 1; i * i <= n; i++) {
			for(int j = i; j <= n; j++) {
				if(i * j <= n) {
					ans++;
				}
			}
		}
		System.out.println(ans);
		
	}

}

// 다른 사람 코드
/*
	for (int i = 1; i <= n; i++) {
		for (int j = i; i * j <= n; j++) {
			cnt++;
		}
	}
*/

package boj.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_설탕배달_2839 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int t = N / 5; // N = 18 -> t = 3
		
		int temp = 0;
		int ans = 0;
		
		for(int i = t; i >= 0; i--) {
			ans = i; // 5킬로그램의 봉지 갯수
			temp = N - i * 5;
			if(temp % 3 == 0) {
				ans += temp / 3;
				break;
			}
		}
		
		if(ans == 0) System.out.println(-1);
		else System.out.println(ans);
	}

}

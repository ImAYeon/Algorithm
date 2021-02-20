package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_농구경기_1159 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] result = new int[26]; // 26개의 소문자를 담을 배열
		
		for(int i = 0 ; i < N; i++){
			result[(br.readLine().charAt(0)) - 'a']++;
		}
		
		int cnt = 0;
		for(int i = 0; i < 26; i++) {
			if(result[i] >= 5) {
				cnt++;
				System.out.print((char)('a' + i));
			}
		}
		if(cnt == 0) {
			System.out.println("PREDAJA");
		}
		
		
		
	}

}

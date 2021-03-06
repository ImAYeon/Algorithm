package silverII;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_수열_2491 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N];
		boolean check; // true이면 커지고 있는거, false이면 작아지고 있는거
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 1;
		int cnt = 1;
		
		for(int i = 1; i < N; i++) { // 커지는 상황 계산
			if( input[i] >= input[i-1] ) cnt++;
			else cnt = 1;
			max = Math.max(max, cnt);
		}
		
		cnt = 1;
		for(int i = 1; i < N; i++) { // 작아지는 상황 계산
			if( input[i] <= input[i-1] ) cnt++;
			else cnt = 1;
			max = Math.max(max, cnt);
		}
		
		System.out.println(max);
		
	}

}

package silverI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_신입사원_1946_Array {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N+1];
			
			for(int i = 1 ; i <= N; i++) {
				String[] s = br.readLine().split(" ");
				arr[Integer.parseInt(s[0])] = Integer.parseInt(s[1]);
			}
			
			int min = arr[1]; // 1등의 score성적을 받아온다.
			int cnt = 1; //1등은 무조건 선발
			for(int i = 2; i <= N; i++) {
				int score = arr[i];
				if(min > score) {
					cnt++;
					min = score;
				}
				
			}
			
			System.out.println(cnt);
		}
	}

}

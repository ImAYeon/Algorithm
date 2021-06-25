package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_영식이와친구들_1592 {
	
	// 규칙을 보니까 인덱스 1이 제일 먼저 공을 받은 횟수가 늘어나게 된다.
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M  = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int cnt = 0;
		int idx = 1;
		int ans = 0;
		while(true) {
			if(idx == 1) cnt++;
			if(cnt == M) break;
			if(cnt % 2 != 0) { // 홀수
				idx = (idx + L)%N;
			}else { // 짝수
				idx = (N + idx - L)%N;
			}
			ans++;
		}
		
		System.out.println(ans);
	}

}

package goldIV;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// D = 8 / K = 4
// 7] 9 7 30 2 [7 9 25

public class BOJ_회전초밥_15961 { // BOJ_회전초밥_2531과 같은 
	
	static int N, D, K, C, max, n;
	static int[] arr, cnt;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 벨트에 놓인 접시의 수
		D = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
		K = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
		C = Integer.parseInt(st.nextToken()); // 쿠폰 버호
		
		arr = new int[N];
		cnt = new int[D+1];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		System.out.println(sol());
		
	}
	
	static int sol() {
		n = 0; max = 0;
		for(int i = 0; i< K; i++) {
			if(cnt[arr[i]] == 0) n++;
			cnt[arr[i]]++;
		}
		
		max = n;
		
		for(int i = 1; i < N; i++) {
			if(max <= n) {
				if(cnt[C] == 0) max = n+1;
				else max = n;
			}
			
			cnt[arr[i-1]]--;
			if(cnt[arr[i-1]] == 0) n--;
			if(cnt[arr[(i+K-1) % N]] == 0) n++;
			cnt[arr[(i+K-1) % N]]++;
		}
		return max;
	}

}

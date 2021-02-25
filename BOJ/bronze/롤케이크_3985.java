package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_롤케이크_3985 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		boolean[] cake = new boolean[L+1];
		
		int maxExp = 0;
		int ansExpIndex = 0;
		int maxReal = 0;
		int ansRealIndex = 0;
		
		for(int i = 1; i <= N; i++) { //방청객의 수만큼 반복
			StringTokenizer st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			if((K-P+1) > maxExp) {
				maxExp = K-P+1;
				ansExpIndex = i;
			}
			
			int cnt = 0;
			for(int j = P; j <= K; j++) {
				if(cake[j]) continue; // 이미 다른사람이 가져간 조각
				cake[j] = true;
				cnt++; // 실제로 몇 개의 조각을 가져갔는지
			}
			
			if(cnt > maxReal) {
				maxReal = cnt;
				ansRealIndex = i;
			}
			
		}
		
		System.out.println(ansExpIndex);
		System.out.println(ansRealIndex);
		
	}

}

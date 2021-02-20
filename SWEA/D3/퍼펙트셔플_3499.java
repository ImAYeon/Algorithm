package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_퍼펙트셔플_3499 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			
			StringBuilder sb = new StringBuilder();
			
			int N = Integer.parseInt(br.readLine());
			
			String[] arr = new String[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i = 0 ;i < N; i++) {
				arr[i] = st.nextToken();
			}
			
			for(int i = 0; i < N/2; i++) {
				if(N % 2 == 0) {
					sb.append(arr[i] + " "); //인덱스 짝수
					sb.append(arr[N/2 + i] + " "); //인덱스 홀수
				}
				else { // 홀수일때는 먼저 놓는쪽이 카드를 한개 더 가져감
					sb.append(arr[i] + " "); //인덱스 짝수
					sb.append(arr[N/2 + 1 + i] + " "); //인덱스 홀수
				}
			}
			
			if(N % 2 == 1) {
				sb.append(arr[N/2]);
			}
			else {
				if(sb.length() > 0) sb.setLength(sb.length() - 1);
			}
			
			System.out.println("#" + t + " " + sb.toString());
		
		}
		
	}

}

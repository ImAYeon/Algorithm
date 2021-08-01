package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 딱지놀이_14696 {
	
	static int[] A, B;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			A = new int[5]; // 별 : 4, 원 : 3, 네모 : 2, 세모 : 1
			B = new int[5];
			
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 어린이 A
			
			for(int i = 0; i < n; i++) {
				A[Integer.parseInt(st.nextToken())]++;
			}
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			
			for(int i = 0; i < n; i++) {
				B[Integer.parseInt(st.nextToken())]++;
			}
			
			char result = 'D';
			for(int k = 4; k >= 1; k--) {
				if(A[k] == B[k]) continue;
				else if(A[k] > B[k]) {
					result = 'A';
					break;
				}else {
					result = 'B';
					break;
				}
			}
			
			System.out.println(result);
		}
	}

}

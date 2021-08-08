package d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_간단한압축풀기_1946 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			sb = new StringBuilder();
			
			int n = Integer.parseInt(br.readLine());
			
			int cnt = 0;
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				
				char alpha = st.nextToken().charAt(0);
				int num = Integer.parseInt(st.nextToken());
				
				for(int j = 0; j < num ;j++) {
					sb.append(alpha);
					cnt++;
					if(cnt == 10) {
						sb.append("\n");
						cnt = 0;
					}
				}
			}
			
			System.out.println("#" + tc);
			System.out.println(sb.toString());
		}

	}

}

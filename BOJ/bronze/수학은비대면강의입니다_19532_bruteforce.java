package 백준알고리즘;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수학은비대면강의입니다_19532_bruteforce {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());
		
		// ax + by = c
		// dx + ey = f
		
		for(int x = -999; x <= 999; x++) {
			for(int y = -999; y <= 999; y++) {
				if( ((a*x)+(b*y) == c) && ((d*x)+(e*y) == f) ) {
					System.out.println(x + " " + y);
					System.exit(0);
				};
			}
		}
		
	}

}

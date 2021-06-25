package silverI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_직사각형_2527 {

	static int x1, y1, p1, q1, x2, y2, p2, q2;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int t = 1; t <= 4; t++) {
			char ans;
			
			st = new StringTokenizer(br.readLine());			
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			
			p1 = Integer.parseInt(st.nextToken());
			q1 = Integer.parseInt(st.nextToken());
			p2 = Integer.parseInt(st.nextToken());
			q2 = Integer.parseInt(st.nextToken());
			
			// 공통부분 없을 때
			if(x2 < p1 || p2 < x1 || y2 < q1 || q2 < y1) ans = 'd';
			
			// 점
			else if( (x2 == p1 && y1 == q2) || (p1 == x2 && q1 == y2) || (x1 == p2 && q1 == y2) || (x1 == p2 && y1 == q2) ) ans = 'c';
			
	
			else {
				// 선분
				if( (y1 == q2) || (y2 == q1) || (x1 == p2) || (x2 == p1) ) ans = 'b';
				// 직사각형
				else ans = 'a';
			}
			
			
			System.out.println(ans);
		}
		
		
		
	}

}

package silverV;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_개미_10158 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken()); // 가로길이
		int h = Integer.parseInt(st.nextToken()); // 세로길이
		
		st = new StringTokenizer(br.readLine()); 
		int p = Integer.parseInt(st.nextToken()); // 초기 위치 좌표값 - x좌표
		int q = Integer.parseInt(st.nextToken()); // 초기 위치 좌표값 - y좌표
		
		int t = Integer.parseInt(br.readLine());
		
		int ansX = (p + t) % (2 * w);
		int ansY = (q + t) % (2 * h);

		if(ansX > w) ansX = (2 * w) - ansX;
		if(ansY > h) ansY = (2 * h) - ansY;
		
		StringBuilder sb = new StringBuilder();
		sb.append(ansX).append(" ").append(ansY);
		
		System.out.println(sb.toString());
	}

}

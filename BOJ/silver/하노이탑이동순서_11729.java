package silverII;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_하노이탑이동순서_11729 {

	static int COUNT;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		
		int N = Integer.parseInt(br.readLine());

		sb = new StringBuilder();
		
		hanoi(N, 1, 2, 3);
		
		sb.insert(0, COUNT+ "\n");
		System.out.println(sb.toString());
	}
	
	private static void hanoi(int cnt, int from, int temp, int to) {
		if(cnt == 0) {
			return;
		}
		
		COUNT++;
		
		// n-1개 원판 이동
		hanoi(cnt-1, from, to, temp);
		
		// n번째 원판 이동
		sb.append(from).append(" ").append(to).append("\n");
		
		// n-1개 원판 이동
		hanoi(cnt-1, temp, from, to);
	}

}

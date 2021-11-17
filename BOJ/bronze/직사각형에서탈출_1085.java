import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_직사각형에서탈출_1085 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		// 직사각형의 경계선까지 가는 거리의 최솟값
		int min = Math.min(x,y);
		min = Math.min(w-x, min);
		min = Math.min(h-y, min);
		
		System.out.println(min);
	}

}

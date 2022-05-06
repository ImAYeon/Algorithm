import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GBC {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] limit = new int[N][2];
		int[][] run = new int[M][2];
		
		for(int i = 0, pre=0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			limit[i][0] = Integer.parseInt(st.nextToken()) + pre;
			pre = limit[i][0];
			limit[i][1] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0, pre=0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			run[i][0] = Integer.parseInt(st.nextToken()) + pre;
			pre = run[i][0];
			run[i][1] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println("limit");
		for(int i = 0; i < N; i++) {
			System.out.println(limit[i][0] + " " + limit[i][1]);
		}
		System.out.println("run");
		for(int i = 0; i < N; i++) {
			System.out.println(run[i][0] + " " + run[i][1]);
		}
		
		int max = 0; // 처음에 Integer.MIN_VALUE 값으로 초기화해서 제한 속도를 벗어나지 않은 경우 0이 출력되지 않는 오류가 있었다.
		int i = 0, j=0, current = 1;
		
		while(i < N) {
			if(current > limit[i][0]) {
				i++; continue;
			}
			if(current > run[j][0]) {
				j++; continue;
			}
			
			max = Math.max(max, run[j][1]-limit[i][1]);

			current++;
		}
		
		System.out.println(max);
		
	}

}

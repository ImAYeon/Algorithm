package silverI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
 * 1 4
 * 2 5 x
 * 3 6 x
 * 4 2
 * 5 7 x
 * 6 1
 * 7 3 x
 * 
 */

public class BOJ_신입사원_1946_PQ { //PriorityQueue이용

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			PriorityQueue<int[]> queue = new PriorityQueue<int[]>( (emp1, emp2) -> {return emp1[0] - emp2[0];}); // 서류심사 성적 (순위이기 때문에 1 2 3 오름차순으로 정렬하면 제일 높은 성적순으로 정렬되는것)
			
			for(int i = 0 ; i < N; i++) {
				String[] s = br.readLine().split(" ");
				queue.offer(new int[] {Integer.parseInt(s[0]), Integer.parseInt(s[1])});
			}
			
			int compareScore = queue.poll()[1]; // 1등의 score성적을 받아온다.
			int cnt = 1; //1등은 무조건 선발
			while(!queue.isEmpty()) {	// 2등부터 
				int score = queue.poll()[1];
				// 2, 3, 4,, 서류점수가 높은얘들에서 낮은얘들로 탐색 - 서류점수도 낮은데 면접 성적까지 낮다면 제외
				// score이 지금탐색하는 자기자신 -> 자기자신보다 서류점수가 높은얘들중에 제일 면접점수가 높은순위가 score에 담겨있음 -> 자기자신보다 서류점수가 높은데 면접점수까지 높다면 자기자신은 선발에서 제외된다.
				if(compareScore > score) { // 서류점수가 높은얘들중 제일 면접점수가 높은순위가 score에 담겨있으므로 score 보다 더 면접순위가 높다면 자기보다 서류점수가 높은얘들보다 면접순위는 더 높은게 되기 때문에 선발됨
					cnt++;
					compareScore = score;
				}
				
			}
			
			System.out.println(cnt);
		}
	}

}

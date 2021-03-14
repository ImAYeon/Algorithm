package silverI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_최소회의실개수_19598 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		
		int[][] arr = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, (o1, o2) -> { //시작시간 기준 정렬
			if(o1[0] == o2[0]) return o1[1] - o2[1];
			return o1[0] - o2[0];
		});
		
		pq.offer(arr[0][1]);
		for(int i = 1; i < N; i++) {
			// pq.peek() : 종료시간중 제일 빨리 끝나는 시간
			if(!pq.isEmpty() && pq.peek() <= arr[i][0] ) pq.poll();
			pq.offer(arr[i][1]);
		}
		
		System.out.println(pq.size());
	}

}

package goldIV;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_강의실배정_11000 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		
		int[][] arr = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, (o1, o2) -> {
			return o1[0] - o2[0]; // 시작시간 기준으로 정렬
		});
		
		queue.offer(arr[0][1]);
		
		for(int i = 1; i < N; i++) {
			if(!queue.isEmpty() && arr[i][0] >= queue.peek()) {
				queue.poll();
			}
			queue.offer(arr[i][1]);
		}
		
		System.out.println(queue.size());
	}

}

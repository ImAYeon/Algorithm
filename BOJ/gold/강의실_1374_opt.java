package goldIV;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;


/*
 * 3 2 14 COUNT++
 * 1 3 8 COUNT++
 * 5 6 20 COUNT++
 * 8 6 27 COUNT++
 * 2 7 13 COUNT++
 * 4 12 18
 * 6 15 21
 * 7 20 25
 * */
public class BOJ_강의실_1374_other { //  시작시간기준

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(s[1]);
			arr[i][1] = Integer.parseInt(s[2]);
		}
		
		Arrays.sort(arr, ( o1, o2 ) -> {
			if(o1[0] == o2[0]) return o1[1] - o2[1]; // 시작시간이 같으면 종료시간 기준으로 정렬
			return o1[0] - o2[0]; // 시작시간 기준으로 정렬
		});
		
		//종료시간 담을 pq
		PriorityQueue<Integer> result = new PriorityQueue<Integer>( (o1, o2) -> { 
			return o1 - o2; // 종료시간이 빠른순대로 정렬
		});
		
		
		result.offer(arr[0][1]); // 첫번째 강의 종료시간 넣기
		for(int i = 1; i < N; i++) {
			if(!result.isEmpty() && arr[i][0] >= result.peek()){ // 강의실이 배정되어있는 강의중 제일 빨리 끝나는 강의 보다 시작 시간이 늦다면 그 강의실에 배정됨 ( 끝난 강의는 result에서 빼준다 )
				result.poll();
			}
			result.offer(arr[i][1]); // 모든 강의들의 끝나는 시간은 queue에 넣는다.
		}
		
		System.out.println(result.size());
		
	}

}


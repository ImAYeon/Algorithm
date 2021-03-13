package goldIV;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
public class BOJ_강의실_1374 { //  시작시간기준

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N+1][2];
		
		// 입력 받을 pq
		PriorityQueue<int[]> queue = new PriorityQueue<int[]>( (o1, o2) -> { // 시작 시간이 빠른순대로 정렬하게끔
			if(o1[0] == o2[0]) return o1[1] - o2[1]; //시작시간(첫번째인덱스)이 같다면 종료시간(두번째인덱스)으로 정렬
			return o1[0] - o2[0];
		});
		
		//종료시간 담을 pq
		PriorityQueue<Integer> result = new PriorityQueue<Integer>( (o1, o2) -> { 
			return o1 - o2; // 종료시간이 빠른순대로 정렬
		});
		
		
		for(int i = 1; i <= N; i++) {
			String[] s = br.readLine().split(" ");
			queue.offer( new int[] { Integer.parseInt(s[1]) , Integer.parseInt(s[2]) } );
		}
		
		result.offer(queue.poll()[1]);
		int cnt = 1; //맨처음꺼 강의실 바로 배정하기 때문에 1에서 시작
		for(int i = 2; i <= N; i++) {
			if(!queue.isEmpty() && queue.peek()[0] < result.peek()) {
				cnt++; // 현재 보고있는 강의가 이미 강의실을 배정받은 강의들중에 제일 빨리 끝나는 강의보다도 일찍 시작한다면 강의실 하나 더 배정해줘야함
			}else {
				result.poll();
			}
			result.offer(queue.poll()[1]);
		}
		
		System.out.println(cnt);
		
	}

}


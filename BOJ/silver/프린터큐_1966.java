import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_프린터큐_1966 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int TC = 1; TC <= T; TC++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 문서의 개수
			int M = Integer.parseInt(st.nextToken()); // 몇 번째로 인쇄되었는지 궁금한 문서 - 현재 Queue의 몇번째 순서인지
			
			Queue<int[]> queue = new LinkedList<int[]>();

			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				queue.offer(new int[]{i,Integer.parseInt(st.nextToken())});
			}
			
			Queue<Integer> answer = new LinkedList<Integer>();
			
			int cnt = 0;
			while(!queue.isEmpty()) {
				int[] current = queue.poll();
				
				boolean check = true;
				
				Iterator<int[]> it = queue.iterator();
				while(it.hasNext()) {
					int[] p = it.next();
					if(current[1] < p[1]) {
						check = false; // 우선순위가 더 큰게 존재
						break;
					}
				}
				
				if(check) { // check가 true로 그대일 경우 우선순위가 큰게 존재하지 않음
					cnt++;
					if(current[0] == M) break;
				}else {
					queue.offer(current);
				}
			}
			
			System.out.println(cnt);
		}
	}

}

package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_요세푸스문제_1158 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		Queue<Integer> queue = new LinkedList<Integer>();
		Queue<Integer> ans = new LinkedList<Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		
		int cnt = 0;
		while(!queue.isEmpty()) {
			cnt++;
			if(cnt % K == 0) {
				sb.append(queue.poll() + ", ");
				cnt = 0;
				continue;
			}
			queue.offer(queue.poll());
		}
		
		sb.setLength(sb.length() - 2);
		sb.append(">");
		System.out.println(sb.toString());
	}

}

package swea.d0204;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1225_암호생성기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t = 1; t <=10; t++) {
			Queue<Integer> queue = new LinkedList<Integer>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < 8; i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			
			int sub = 1;
			while(true) {
				if(queue.peek() - sub <= 0) {
					queue.poll();
					queue.offer(0);
					break;
				}
				queue.offer(queue.poll() - sub);
				if(sub == 5) {
					sub = 1;
					continue;
				}
				sub++; 
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#" + t + " ");
			while(!queue.isEmpty()) {
				sb.append(queue.poll() + " ");
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");
			System.out.println(sb.toString());
		}
	}

}

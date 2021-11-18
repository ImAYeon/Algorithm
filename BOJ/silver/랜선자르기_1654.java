import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_랜선자르기_1654 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] line = new int[K];
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < K; i++) {
			line[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, line[i]);
		}
		
		long left = 1; // 랜선길이 자연수이므로 최솟값은 1로
		long right = max;
		int sum = 0;
		long mid = 0;
		
		while(left <= right) {
			mid = (left+right)/2;
			
			sum = 0;
			for(int i = 0; i < K; i++) {
				sum += line[i]/mid;
			}
			
			// mid(랜선의 길이)로 자른 갯수가 N보다 같거나 크면 랜선의 길이를 좀 더 늘려서 시도해보기
			if(sum >= N) { 
				left = mid + 1;
			}
			// mid(랜선의 길이)로 잘랐는데 N보다 작으면 랜선의 길이를 줄여서 시도해봐야 함
			else { 
				right = mid - 1;
			}
		}
		
		System.out.println(right);
	}

}

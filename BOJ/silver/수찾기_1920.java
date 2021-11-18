import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_수찾기_1920 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] n = new int[N];
		for(int i = 0; i < N; i++) {
			n[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(n); // 이분탐색에서 중요한 부분
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] m = new int[M];
		for(int i = 0; i < M; i++) {
			m[i] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			sb.append( binarySearch(n,m[i]) ).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static int binarySearch(int[] arr, int key) {
		
		int start = 0;
		int end = arr.length -1;
		
		while(start <= end) {
			int mid = (start+end)/2;
			
			if(key < arr[mid]) {
				end = mid-1;
			}
			else if(key > arr[mid]) {
				start = mid+1;
			}
			else { // key == mid
				return 1; // 존재하면 1 출력
			}
		}
		
		return 0; // 존재하지 않으면 0 출력
	}
}

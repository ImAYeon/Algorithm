import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_숫자카드2_10816 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr); // 항상 이분탐색할 때 중요!!!!!
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			int m = Integer.parseInt(st.nextToken());
			sb.append(upperBound(arr,m) - lowerBound(arr,m)).append(" ");
		}
		
		System.out.println(sb.toString());

	}
	
	static int lowerBound(int[] arr, int key) {
		int lo = 0;
		int hi = arr.length;
		
		// lo가 hi랑 같아질 때까지 반복
		while(lo < hi) {
			
			int mid = (lo + hi) / 2; // 중간위치를 구한다.
			
			/*
			 * key 값이 중간 위치의 값보다 작거나 같을 경우
			 * 
			 * 중복 원소에 대해 왼쪽으로 탐색하도록 상계를 내린다.
			 */
			if(key <= arr[mid]) {
				hi = mid;
			}
			else {
				lo = mid + 1;
			}
		}
		
		return lo;
	}
	
	static int upperBound(int[] arr, int key) {
		int lo = 0;
		int hi = arr.length;
		
		// lo가 hi랑 같아질 때 까지 반복
		while(lo < hi) {
			
			int mid = (lo + hi) / 2; // 중간위치를 구한다.
			
			// key값이 중간 위치의 값보다 작을 경우
			if(key < arr[mid]) {				
				hi = mid;
			}
			// 중복원소의 경우 else에서 처리된다.
			else {
				lo = mid+1;
			}
		}
		
		return lo;
	}
}

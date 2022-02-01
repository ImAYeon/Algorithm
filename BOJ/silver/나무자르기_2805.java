import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_나무자르기_2805 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 나무의 수
		int M = Integer.parseInt(st.nextToken()); // 나무의 길이
		
		st = new StringTokenizer(br.readLine());
		

		int min = 0;
		int max = Integer.MIN_VALUE;
		
		int[] tree = new int[N];
		for(int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, tree[i]);
		}
		
		while(min < max) {
			
			int mid = (min+max)/2; // 중간값 : 자르는 높이
			
			int sum = 0;
			for(int i = 0; i < N; i++) {
				int temp = tree[i] - mid;
				if(temp > 0) sum += temp; // 잘라지는 부분이 있을 때만 더함
			}
			System.out.println("min : " + min + ", max : " + max);
			System.out.println("mid : " + mid + ", sum : " + sum + ", M : " + M);
			if(sum < M) { // 가져가려고 하는 나무 M보다 잘라진 나무 합이 작으면 자르는 높이(중간값)를 낮춰야 함
				max = mid;
				System.out.println("max = mid" + "\n");
			}
			else { // 가져가려고 하는 나무 M보다 잘라진 나무 합이 크면 자르는 높이를 좀 높여봄
				min = mid+1;
				System.out.println("min = mid + 1" + "\n");
			} // 1 2 
		}
		
		
		System.out.println(min-1);
	}

}

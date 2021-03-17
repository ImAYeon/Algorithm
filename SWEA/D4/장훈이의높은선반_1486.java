import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_장훈이의높은선반_1486 { // 높이가 B 이상인 탑 중에서 높이가 가장 낮은 탑

	static int T, N, B, minDiff;
	static int[] H;
	static boolean[] select;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for(int testCase = 1; testCase <= T; testCase++) {
			minDiff = Integer.MAX_VALUE; 
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			H = new int[N];
			select = new boolean[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				H[i] = Integer.parseInt(st.nextToken());
			}
			
			subset(0);
			
			System.out.println("#" + testCase + " " + minDiff);
		}
		
	}
	
	static void subset(int index) {
		if( index == N ) {
			
			int sum = 0;
			for(int i = 0; i < N; i++) {
				if(select[i]) sum += H[i]; 
			}
			if(sum >= B) {
				if(sum - B < minDiff) minDiff = sum - B;
			}
			return;
		}
		
		select[index] = true;
		subset(index+1);
		select[index] = false;
		subset(index+1);
	}

}

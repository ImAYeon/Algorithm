import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// silver III
public class BOJ_근손실_18429 {

	static int N, K, COUNT;
	static int[] src;
	static boolean select[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		K = Integer.parseInt(s[1]);
		
		src = new int[N];
		select = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			src[i] = Integer.parseInt(st.nextToken());
		}
		
		perm(0, 500);
		
		System.out.println(COUNT);
	}
	
	static void perm(int tgtIdx, int sum) {
		
		if(sum < 500) return;
		
		if(tgtIdx == N) {
			COUNT++;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(select[i]) continue;
			
			select[i] = true;
			perm(tgtIdx+1, sum - K + src[i]);
			select[i] = false;
			
		}
	}

}

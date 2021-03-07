package silverIII;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_안테나_18310 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] house = new int[N];	
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			house[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(house);
		
		int ans = 0;
		if(N % 2 == 0) {
			ans= house[N / 2 - 1];
		}else {
			ans = house[N / 2];
		}
		
		
		System.out.println(ans);
	}

}

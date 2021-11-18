import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_영화감독숌_1436 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// 666, 1666, 2666, 3666, 4666, 5666, 6666, 6667, 6668, 6669,
		int count = 0, result = 0;
		for(int i = 666; ;i++) {
			if(Integer.toString(i).contains("666")) count++;
			if(count == N) {
				result = i;
				break;
			}
		}
		System.out.println(result);
		
	}

}

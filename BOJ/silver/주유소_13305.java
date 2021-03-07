package silverIV;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_주유소_13305 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long[] length = new long[N-1]; // 도시를 연결하는 도로의 길이
		long[] price = new long[N]; // 주유소의 리엍당 가격
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N-1; i++) {
			length[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}
		
		long ans = length[0] * price[0];
		int index = 1;
		long min = price[0];
		while(index <= price.length - 2) {
			min = Math.min(min, price[index]);
			
			ans += length[index] * min;
			
			index++;
		}
		
		System.out.println(ans);
	}

}

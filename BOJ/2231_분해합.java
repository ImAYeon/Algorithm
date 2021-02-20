package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_분해합_2231 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		
		int sum = 0, num;
		
		for(int i = 1 ; i < N; i++) {
			sum = 0;
			sum += i;
			num = i;
			
			while(num != 0) {
				sum += num % 10; // 자릿 수 구하기
				num /= 10;
			}
			
			if(sum == N) {
				ans = i;
				break;
			}
		}
		
		System.out.println(ans);
	}

}

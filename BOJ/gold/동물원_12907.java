package goldV;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_동물원_12907 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] input = new int[41];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			input[ Integer.parseInt(st.nextToken()) ]++;
		}
		
		
		if(input[0] > 2) {
			System.out.println(0);
			return;
		}
		
		for(int i = 1; i <= 40; i++) {
			if(input[i-1] < input[i]) {
				System.out.println(0);
				return;
			}
		}
		
		// 안되는거 위에서 다 골라냈기 때문에 여기서부턴 무조건 2221 이런식 또는 22111이런식 또는 2222
		// count가 2인데까지만 2가지 경우의 수 + 2인 index 그다음이 1이면  그 1이 고양이인지 토끼인지 경우의 수 2 또 곱해주기
		long ans = 1;
		int i = 0;
		while(input[i] == 2) {
			ans *= 2;
			i += 1;
		}
		if(input[i] == 1) ans *= 2;
		
		
		System.out.println(ans);
	}

}
/*
 * 내가 이해안가는 부분이 N = 40이고, 대답이 40이면 틀린거 아닌가였다 ( 고양이만 40마리라고하면 나보다 큰 동물이 40마리라고 대답하면 말이 안되니까 )
 * 근데 이 경우에는 40마리중 한마리가 대답으로 40을 하게 되면 index 0부터 39까지 어차피 cnt = 0인곳이 생긴다. 그러므로 조건에 안맞아 0을 알맞게 출력한다.
 */

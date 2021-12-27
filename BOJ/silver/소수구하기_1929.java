import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 에라토스테네스의 체 이용
public class BOJ_소수구하기_1929 {
	
	static boolean[] prime;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		prime = new boolean[N+1];
		
		make_prime();
		
		for(int i = M; i <= N; i++) {
			if(!prime[i]) sb.append(i).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void make_prime() {
		prime[0] = prime[1] = true; //false일 경우 소수
		
		for(int i = 2; i < Math.sqrt(prime.length); i++) {
			if(prime[i]) continue;
			for(int j = i*i; j < prime.length; j+=i) {
				prime[j] = true;
			}
		}
	}

}

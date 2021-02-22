package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//bronze2 //IM시험대비
public class BOJ_방배정_13300 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		int ans = 0;
		
		int[] woman = new int[7];
		int[] man = new int[7]; //1~6학년(0인덱스 사용x), j -> 학년에 들어가는 숫자
		
		for(int i = 0 ; i < N; i++) {
			s = br.readLine().split(" ");
			int sex = Integer.parseInt(s[0]);
			int grade = Integer.parseInt(s[1]);
			
			if(sex == 0) {
				woman[grade]++;
			}else if(sex == 1) {
				man[grade]++;
			}
		}
		
		for(int i = 1 ; i <= 6; i++) {
			if(woman[i] != 0) {
				ans += woman[i] / K;
				if(woman[i] % K != 0) ans++;
			}
			if(man[i] != 0) {
				ans += man[i] / K;
				if(man[i] % K != 0) ans++;			
			}
		}
		
		System.out.println(ans);
	}

}

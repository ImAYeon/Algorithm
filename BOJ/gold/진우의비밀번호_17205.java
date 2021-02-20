package goldV;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_진우의비밀번호_17205 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); //비밀번호의 최대 길이
		char[] password = br.readLine().toCharArray();
		long ans = 0;
		
		//맨앞자리 알파벳 앞에 올 수 있는 알파벳에 대한 모든 비밀번호 길이에 대한 숫자 계산
		// 만약 맨앞자리가 c이고, 비밀번호 최대 길이가 3이라면  앞자리가 a와 b가 오는 비밀번호길이가 1,2,3인 모든 경우의 수
		
		
		//password[0]의 수앞에 올수있는 경우의 수
		for(int k = 0; k < password.length; k++) {
			for(int i = 0 ; i < N-k ; i++) {
				// 26 ^ 0 = 1(a), 26 ^ 1 = 26(aa~az), 26^2(aaa~azz) => i = 0부터 최대 비밀번호 길이-1만큼(최대비밀번호길이가 3이라면 aaa~azz처럼 뒤에 두자리가 오는 경우의 26^2이기 때문에 최대비밀번호길이-1까지)
				// password[0] - 'a'를 곱해주는 이유는  앞자리가 만약 c라면 'c'-'a'는 2이므로 c앞에 a,b 두자리가 올수있음을 뜻함
				ans += Math.pow(26, i) *(password[k] - 'a'); 
			}
			ans++; // password[k] 자기자신
		}
		
		
		System.out.println(ans);
	}

}

// ex) bc....
// 맨앞자리가 b이면 a로시작하는 비밀번호 최대 길이까지 만들 수 있는 모든 비밀번호 계산

// ===============어떤 알파벳으로 시작한는 비밀번호 최대 길이의 모든 비밀번호는 따로 계산 (어떤 알파벳으로 시작하는 비밀번호가 1자리,2자리,,, 여러가지가 될 수 있기 때문 - a, aa, ab, ac, ...az, aaa, aaaa...)=================

// 여기서부턴 몇번째오느냐에 계산
// 두번째 자리가 c이면 두번째자리에서 비밀번호 최대 길이-1로 올 수 있는 a,b로 시작하는 모든 비밀번호 계산
// 알파벳은 26개, 비밀번호 최대 길이가 N개라고 했을 때 
// ex) bcde => 비밀번호 최대 길이가 4라면 (bc..) c이전에 올 수 있는 b로 시작하는 비밀번호는 두번째자리가 a일때 나머지 두자리수는 26*26 두번째자리가 b일때 나머지 두자리수는 26*26 => 더해줌
// ex) (bce.) => e앞에 올 수 있는 a,b,c,d 마다 마지막 한자리수 올수있는 경우의수 26개씩 더해줌 => 26*4

// 6 cbb
// => 먼저 c앞에 올 수 있는 경우의 수 계산하고
// => 그 다음 두번째 자리 b 앞에 올 수 있는 a의 경우의 수

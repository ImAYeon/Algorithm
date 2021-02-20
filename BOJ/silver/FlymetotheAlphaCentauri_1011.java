package silverI;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_FlymetotheAlphaCentauri_1011 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			
			String[] s = br.readLine().split(" ");
			int x = Integer.parseInt(s[0]); //  현재 위치
			int y = Integer.parseInt(s[1]); // 목표 위치
			
			int diff = y - x;
			
			int k = 1, cnt = 0;
			while(true) {
				if((diff - 2*k) > 0) { 
					diff -= 2 * k;
					cnt += 2;
					if(diff == 0) break;
				} 
				else if (diff >= k) {
					diff -= k;
					cnt++;
					if(diff == 0) break;
				}
				else if(diff < k) {
					cnt++;
					break;
				}
				k++;
			}
			
			System.out.println(cnt);
		}
	}
	
}

//x +(( 1 + (0,1,2- k) + (k-1,k,k+1) + (k-1,k,k+1) .... (0 또는 1또는 2)  + (1))) => y =====> 계속 k+1로 가다가 중간지점부터 다시 k-1로 가면 
// 1 + 2 + 3 + 4 + 5 + 4 + 3 + 2 + 1


//ex) x = 1, y = 5 => 1, 2, 1
//ex) x = 1, y = 6 => 1 2 1 1 (y-x(여기선5)를 쪼개야됨 -> 1(맨앞)+1(맨뒤) 를 빼고 남은 3을 그다음 2 + 2 보다 작으니까 2로 뺀다 그다음 남은 1을 횟수로 쳐주면 1은 어차피 1, 2, 1 에서 언제든지 들어갈 수 있는 숫자가 됨
//ex) x = 1, y = 10 => 1 2 3 2 1 (y-x(여기선 9) -> 1(맨앞) + 1(맨뒤)를 빼면 7이남음 그다음 2+2보다 크니까 2(2번째)+2(뒤에서두번째)로 빼주면 3이남음 그럼 3+3보다 작은수인지 확인하고 그다음 3보다 같거나 작은지 확인하고(뺄수있는지확인) 3을 빼줌
//ex) x = 1, y = 12 => y-x(11) 1 + 1 빼면 9 -> 2 + 2 빼면 5 -> 3+3보다 작고 3보다 크니까 3을 뺌 -> 2가 남음 , 2는  2가있던자리 앞뒤로 아무데나 넣을수있으므로 횟수로 쳐줌

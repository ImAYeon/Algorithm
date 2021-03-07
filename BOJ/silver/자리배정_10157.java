package silverV;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_자리배정_10157 {

	static int[] dx = { 1,  0, -1,  0};// 우 하 좌 상
	static int[] dy = { 0,  1,  0, -1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int C = Integer.parseInt(s[0]); // 가로
		int R = Integer.parseInt(s[1])+1; // 세로 - ( 7(C) X 6(R) 이라고 칠 때  (0,1) 부터 시작한다고 치고 6(R) 6(C) 5(R) 5(C) 4(R) 4(C)... 이런식으로 이동하기 때문에 밑에서 R-- 했을 때 6이 되려면 처음에 R + 1(7)해주기 )
		
		int K = Integer.parseInt(br.readLine()); // 대기번호

		if( K > C*R ) {
			System.out.println(0);
			return;
		}
		
		int x=0, y=1, cnt=0, d=-1; // (x+1방향으로 먼저 가기 때문에  x=0)
		int check = 1;
		while(check > 0) {
			d = (d + 1) % 4; // d == 0 : 우 / d == 1 : 하 / d == 2 : 좌 / d == 3 : 상
			
			if ( d % 2 == 0 ) R--; // 우, 좌 일때 R갯수 1개 줄이기 
			else C--;
			
			check = d % 2 == 0 ? R : C;
			
			for(int j = 0; j < check ;j++) {
				cnt++;
				x += dx[d];
				y += dy[d];
				if(cnt == K) {
					System.out.println(y + " " + x);
					return;
				}
			}
			
		}
		
		
		System.out.println(x + " " + y);
	}

}
